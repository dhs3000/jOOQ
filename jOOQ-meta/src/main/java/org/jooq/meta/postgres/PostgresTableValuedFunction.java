/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Other licenses:
 * -----------------------------------------------------------------------------
 * Commercial licenses for this work are available. These replace the above
 * Apache-2.0 license and offer limited warranties, support, maintenance, and
 * commercial database integrations.
 *
 * For more information, please visit: https://www.jooq.org/legal/licensing
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package org.jooq.meta.postgres;

import static org.jooq.impl.DSL.coalesce;
import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.inline;
import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.nvl;
import static org.jooq.impl.DSL.partitionBy;
import static org.jooq.impl.DSL.row;
import static org.jooq.impl.DSL.rowNumber;
import static org.jooq.impl.DSL.select;
import static org.jooq.impl.DSL.substring;
import static org.jooq.impl.DSL.val;
import static org.jooq.impl.DSL.when;
import static org.jooq.meta.postgres.PostgresRoutineDefinition.pNumericPrecision;
import static org.jooq.meta.postgres.information_schema.Tables.ATTRIBUTES;
import static org.jooq.meta.postgres.information_schema.Tables.COLUMNS;
import static org.jooq.meta.postgres.information_schema.Tables.PARAMETERS;
import static org.jooq.meta.postgres.information_schema.Tables.ROUTINES;
import static org.jooq.meta.postgres.pg_catalog.Tables.PG_ATTRIBUTE;
import static org.jooq.meta.postgres.pg_catalog.Tables.PG_CLASS;
import static org.jooq.meta.postgres.pg_catalog.Tables.PG_PROC;
import static org.jooq.meta.postgres.pg_catalog.Tables.PG_TYPE;
import static org.jooq.tools.StringUtils.defaultString;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.jooq.Field;
import org.jooq.Record;
import org.jooq.TableOptions.TableType;
import org.jooq.meta.AbstractTableDefinition;
import org.jooq.meta.ColumnDefinition;
import org.jooq.meta.DataTypeDefinition;
import org.jooq.meta.DefaultColumnDefinition;
import org.jooq.meta.DefaultDataTypeDefinition;
import org.jooq.meta.ParameterDefinition;
import org.jooq.meta.SchemaDefinition;
import org.jooq.meta.postgres.information_schema.tables.Attributes;
import org.jooq.meta.postgres.information_schema.tables.Columns;
import org.jooq.meta.postgres.information_schema.tables.Parameters;
import org.jooq.meta.postgres.information_schema.tables.Routines;
import org.jooq.meta.postgres.pg_catalog.tables.PgAttribute;
import org.jooq.meta.postgres.pg_catalog.tables.PgClass;
import org.jooq.meta.postgres.pg_catalog.tables.PgProc;
import org.jooq.meta.postgres.pg_catalog.tables.PgType;

/**
 * @author Lukas Eder
 */
public class PostgresTableValuedFunction extends AbstractTableDefinition {

    private final PostgresRoutineDefinition routine;
    private final String                    specificName;

    public PostgresTableValuedFunction(SchemaDefinition schema, String name, String specificName, String comment) {
        this(schema, name, specificName, comment, null);
    }

    public PostgresTableValuedFunction(SchemaDefinition schema, String name, String specificName, String comment, String source) {
        this(schema, name, specificName, comment, source, null, null);
    }

    public PostgresTableValuedFunction(SchemaDefinition schema, String name, String specificName, String comment, String source, SchemaDefinition referencedSchema, String referencedName) {
        super(schema, name, comment, TableType.FUNCTION, source, referencedSchema, referencedName);

        this.routine = new PostgresRoutineDefinition(schema.getDatabase(), schema.getInputName(), name, specificName);
        this.specificName = specificName;
    }

    @Override
    public List<ColumnDefinition> getElements0() throws SQLException {
        List<ColumnDefinition> result = new ArrayList<>();
        PostgresDatabase db = (PostgresDatabase) getDatabase();

        Routines r = ROUTINES.as("r");
        Parameters p = PARAMETERS.as("p");
        Columns c = COLUMNS.as("c");
        Attributes a = ATTRIBUTES.as("a");
        Columns x = COLUMNS.as("x");
        PgClass pg_c = PG_CLASS.as("pgc");
        PgAttribute pg_a = PG_ATTRIBUTE.as("pga");
        PgProc pg_p = PG_PROC.as("pgp");
        PgType pg_t = PG_TYPE.as("pgt");

        Field<Integer> pPrecision = pNumericPrecision(p);
        Field<Integer> cPrecision = nvl(c.DATETIME_PRECISION, c.NUMERIC_PRECISION);
        Field<Integer> aPrecision = nvl(a.DATETIME_PRECISION, a.NUMERIC_PRECISION);
        Field<Integer> rPrecision = nvl(r.DATETIME_PRECISION, r.NUMERIC_PRECISION);







        for (Record record : create()

                // [#3375] The first subselect is expected to return only those
                // table-valued functions that return a TABLE type, as that TABLE
                // type is reported implicitly via PARAMETERS.PARAMETER_MODE = 'OUT'
                .select(
                    p.PARAMETER_NAME,
                    rowNumber().over(partitionBy(p.SPECIFIC_NAME).orderBy(p.ORDINAL_POSITION)).as(p.ORDINAL_POSITION),
                    when(p.DATA_TYPE.eq(inline("ARRAY")), substring(p.UDT_NAME, inline(2)).concat(" ARRAY"))
                        .else_(p.DATA_TYPE)
                        .as(p.DATA_TYPE),
                    p.CHARACTER_MAXIMUM_LENGTH,
                    pPrecision.as(p.NUMERIC_PRECISION),
                    p.NUMERIC_SCALE,
                    inline("true").as(c.IS_NULLABLE),
                   (db.is94()
                        ? p.PARAMETER_DEFAULT
                        : inline((String) null)).as(c.COLUMN_DEFAULT),
                    p.UDT_SCHEMA,
                    when(p.DATA_TYPE.eq(inline("ARRAY")), substring(p.UDT_NAME, inline(2)))
                        .else_(p.UDT_NAME)
                        .as(p.UDT_NAME)
                )
                .from(r)
                .join(p).on(row(r.SPECIFIC_CATALOG, r.SPECIFIC_SCHEMA, r.SPECIFIC_NAME)
                            .eq(p.SPECIFIC_CATALOG, p.SPECIFIC_SCHEMA, p.SPECIFIC_NAME))
                .join(pg_p).on(pg_p.PRONAME.concat("_").concat(pg_p.OID).eq(r.SPECIFIC_NAME))
                           .and(pg_p.pgNamespace().NSPNAME.eq(r.SPECIFIC_SCHEMA))
                .where(r.SPECIFIC_NAME.eq(specificName))
                .and(p.PARAMETER_MODE.ne("IN"))
                .and(pg_p.PRORETSET)

                .unionAll(

                // [#3376] The second subselect is expected to return only those
                // table-valued functions that return a SETOF [ table or udt type ], as that
                // table reference is reported via a TYPE_UDT that matches a table
                // from INFORMATION_SCHEMA.TABLES
                 select(
                    coalesce(c.COLUMN_NAME, a.ATTRIBUTE_NAME, val(getName())).as(c.COLUMN_NAME),
                    coalesce(c.ORDINAL_POSITION, a.ORDINAL_POSITION, inline(1)).as(c.ORDINAL_POSITION),
                    db.arrayDataType(x.DATA_TYPE, x.UDT_NAME, pg_a.ATTNDIMS).as(c.DATA_TYPE),
                    coalesce(c.CHARACTER_MAXIMUM_LENGTH, a.CHARACTER_MAXIMUM_LENGTH, r.CHARACTER_MAXIMUM_LENGTH  ).as(c.CHARACTER_MAXIMUM_LENGTH),
                    coalesce(cPrecision, aPrecision, rPrecision).as(c.NUMERIC_PRECISION),
                    coalesce(c.NUMERIC_SCALE, a.NUMERIC_SCALE, r.NUMERIC_SCALE).as(c.NUMERIC_SCALE),
                    coalesce(c.IS_NULLABLE, a.IS_NULLABLE, inline("true")).as(c.IS_NULLABLE),
                    coalesce(c.COLUMN_DEFAULT, a.ATTRIBUTE_DEFAULT, inline((String) null)).as(c.COLUMN_DEFAULT),
                    coalesce(c.UDT_SCHEMA, a.ATTRIBUTE_UDT_SCHEMA, inline((String) null)).as(c.UDT_SCHEMA),
                    db.arrayUdtName(x.DATA_TYPE, x.UDT_NAME).as(c.UDT_NAME)
                )
                .from(r)

                // [#4269] SETOF [ scalar type ] routines don't have any corresponding
                // entries in INFORMATION_SCHEMA.COLUMNS or INFORMATION_SCHEMA.ATTRIBUTES.
                // Their single result table column type is contained in ROUTINES
                .join(pg_p)
                    .on(pg_p.PRONAME.concat("_").concat(pg_p.OID).eq(r.SPECIFIC_NAME))
                    .and(pg_p.pgNamespace().NSPNAME.eq(r.SPECIFIC_SCHEMA))

                // [#7406] COLUMNS and ATTRIBUTES are mutually exclusive, hence no cross product here
                .leftJoin(c)
                    .on(row(r.TYPE_UDT_CATALOG, r.TYPE_UDT_SCHEMA, r.TYPE_UDT_NAME)
                        .eq(c.TABLE_CATALOG,    c.TABLE_SCHEMA,    c.TABLE_NAME))
                .leftJoin(a)
                    .on(row(r.TYPE_UDT_CATALOG, r.TYPE_UDT_SCHEMA, r.TYPE_UDT_NAME)
                        .eq(a.UDT_CATALOG,      a.UDT_SCHEMA,    a.UDT_NAME))

                .leftJoin(pg_c)
                    .on(nvl(c.TABLE_NAME, a.UDT_NAME).eq(pg_c.RELNAME))
                    .and(pg_c.pgNamespace().NSPNAME.eq(r.SPECIFIC_SCHEMA))
                .leftJoin(pg_a)
                    .on(pg_c.OID.eq(pg_a.ATTRELID))
                    .and(nvl(c.COLUMN_NAME, a.ATTRIBUTE_NAME).eq(pg_a.ATTNAME))
                .crossApply(
                    select(
                        coalesce(c.DATA_TYPE, a.DATA_TYPE, r.DATA_TYPE).as(x.DATA_TYPE),
                        coalesce(
                            c.UDT_NAME, a.ATTRIBUTE_UDT_NAME, r.UDT_NAME,
                            field(select(pg_t.TYPNAME).from(pg_t).where(pg_t.OID.eq(pg_p.PRORETTYPE)))
                        ).as(x.UDT_NAME)
                    ).asTable(x)
                )
                .where(r.SPECIFIC_NAME.eq(specificName))

                // [#4269] Exclude TABLE [ some type ] routines from the first UNION ALL subselect
                // Can this be done more elegantly?
                .and(         row(r.SPECIFIC_CATALOG, r.SPECIFIC_SCHEMA, r.SPECIFIC_NAME)
                    .notIn(select(p.SPECIFIC_CATALOG, p.SPECIFIC_SCHEMA, p.SPECIFIC_NAME).from(p).where(p.PARAMETER_MODE.eq("OUT"))))
                .and(pg_p.PRORETSET))

                // Either subselect can be ordered by their ORDINAL_POSITION
                .orderBy(2)
        ) {

            SchemaDefinition typeSchema = null;

            String schemaName = record.get(p.UDT_SCHEMA);
            if (schemaName != null)
                typeSchema = getDatabase().getSchema(schemaName);

            DataTypeDefinition type = new DefaultDataTypeDefinition(
                getDatabase(),
                typeSchema,
                record.get(p.DATA_TYPE),
                record.get(p.CHARACTER_MAXIMUM_LENGTH),
                record.get(p.NUMERIC_PRECISION),
                record.get(p.NUMERIC_SCALE),
                record.get(c.IS_NULLABLE, boolean.class),
                record.get(c.COLUMN_DEFAULT),
                name(
                    record.get(p.UDT_SCHEMA),
                    record.get(p.UDT_NAME)
                )
            );

            result.add(new DefaultColumnDefinition(
                getDatabase().getTable(getSchema(), getName()),
                record.get(p.PARAMETER_NAME),
                result.size() + 1,
                type,
                defaultString(record.get(c.COLUMN_DEFAULT)).startsWith("nextval"),
                null
            ));
        }

        return result;
    }

    @Override
    protected List<ParameterDefinition> getParameters0() {
        return routine.getInParameters();
    }
}
