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
 * ASL 2.0 and offer limited warranties, support, maintenance, and commercial
 * database integrations.
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
package org.jooq.impl;

// ...
import static org.jooq.impl.DSL.function;
import static org.jooq.impl.DSL.inline;
import static org.jooq.impl.Names.N_LEAST;
import static org.jooq.impl.Names.N_MIN;
import static org.jooq.impl.Names.N_MINVALUE;
import static org.jooq.impl.Tools.EMPTY_FIELD;
import static org.jooq.impl.Tools.nullSafeDataType;

import org.jooq.Context;
import org.jooq.DataType;
import org.jooq.Field;
import org.jooq.Function1;
import org.jooq.impl.QOM.UnmodifiableList;

/**
 * @author Lukas Eder
 */
final class Least<T> extends AbstractField<T> implements QOM.Least<T> {

    private final QueryPartListView<Field<T>> args;

    @SuppressWarnings({ "unchecked" })
    Least(Field<?>... args) {
        this(args, (DataType<T>) nullSafeDataType(args));
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    Least(Field<?>[] args, DataType<T> type) {
        super(N_LEAST, type);

        this.args = (QueryPartListView) QueryPartListView.wrap(args);
    }

    @Override
    public final void accept(Context<?> ctx) {
        if (args.isEmpty()) {
            ctx.visit(inline(null, getDataType()));
            return;
        }
        else if (args.size() == 1) {
            ctx.visit(args.get(0));
            return;
        }

        switch (ctx.family()) {
















            case DERBY: {
                GreatestLeast.acceptCaseEmulation(ctx, args, DSL::least, Field::lt);
                return;
            }

            case FIREBIRD:
                ctx.visit(function(N_MINVALUE, getDataType(), args.toArray(EMPTY_FIELD)));
                return;

            case SQLITE:
                ctx.visit(function(N_MIN, getDataType(), args.toArray(EMPTY_FIELD)));
                return;

            default:
                ctx.visit(function(N_LEAST, getDataType(), args.toArray(EMPTY_FIELD)));
                return;
        }
    }

    // -------------------------------------------------------------------------
    // XXX: Query Object Model
    // -------------------------------------------------------------------------

    @Override
    public final UnmodifiableList<? extends Field<T>> $arg1() {
        return QOM.unmodifiable((UnmodifiableList<? extends Field<T>>) args);
    }

    @Override
    public final Function1<? super UnmodifiableList<? extends Field<T>>, ? extends Field<T>> $constructor() {
        return a -> a.isEmpty()
            ? new Least<>(EMPTY_FIELD, getDataType())
            : new Least<>(a.toArray(EMPTY_FIELD));
    }
}
