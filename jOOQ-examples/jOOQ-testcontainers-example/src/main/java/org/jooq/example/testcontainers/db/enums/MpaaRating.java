/*
 * This file is generated by jOOQ.
 */
package org.jooq.example.testcontainers.db.enums;


import org.jooq.Catalog;
import org.jooq.EnumType;
import org.jooq.Schema;
import org.jooq.example.testcontainers.db.Public;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public enum MpaaRating implements EnumType {

    G("G"),

    PG("PG"),

    PG_13("PG-13"),

    R("R"),

    NC_17("NC-17");

    private final String literal;

    private MpaaRating(String literal) {
        this.literal = literal;
    }

    @Override
    public Catalog getCatalog() {
        return getSchema().getCatalog();
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public String getName() {
        return "mpaa_rating";
    }

    @Override
    public String getLiteral() {
        return literal;
    }

    /**
     * Lookup a value of this EnumType by its literal. Returns
     * <code>null</code>, if no such value could be found, see {@link
     * EnumType#lookupLiteral(Class, String)}.
     */
    public static MpaaRating lookupLiteral(String literal) {
        return EnumType.lookupLiteral(MpaaRating.class, literal);
    }
}
