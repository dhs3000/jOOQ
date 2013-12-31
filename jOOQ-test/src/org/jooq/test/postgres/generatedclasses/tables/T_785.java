/**
 * This class is generated by jOOQ
 */
package org.jooq.test.postgres.generatedclasses.tables;

/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class T_785 extends org.jooq.impl.TableImpl<org.jooq.test.postgres.generatedclasses.tables.records.T_785Record> {

	private static final long serialVersionUID = -295148374;

	/**
	 * The singleton instance of <code>public.t_785</code>
	 */
	public static final org.jooq.test.postgres.generatedclasses.tables.T_785 T_785 = new org.jooq.test.postgres.generatedclasses.tables.T_785();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.jooq.test.postgres.generatedclasses.tables.records.T_785Record> getRecordType() {
		return org.jooq.test.postgres.generatedclasses.tables.records.T_785Record.class;
	}

	/**
	 * The column <code>public.t_785.id</code>. 
	 */
	public final org.jooq.TableField<org.jooq.test.postgres.generatedclasses.tables.records.T_785Record, java.lang.Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.defaulted(true), this);

	/**
	 * The column <code>public.t_785.name</code>. 
	 */
	public final org.jooq.TableField<org.jooq.test.postgres.generatedclasses.tables.records.T_785Record, java.lang.String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(50).defaulted(true), this);

	/**
	 * The column <code>public.t_785.value</code>. 
	 */
	public final org.jooq.TableField<org.jooq.test.postgres.generatedclasses.tables.records.T_785Record, java.lang.String> VALUE = createField("value", org.jooq.impl.SQLDataType.VARCHAR.length(50).defaulted(true), this);

	/**
	 * Create a <code>public.t_785</code> table reference
	 */
	public T_785() {
		super("t_785", org.jooq.test.postgres.generatedclasses.Public.PUBLIC);
	}

	/**
	 * Create an aliased <code>public.t_785</code> table reference
	 */
	public T_785(java.lang.String alias) {
		super(alias, org.jooq.test.postgres.generatedclasses.Public.PUBLIC, org.jooq.test.postgres.generatedclasses.tables.T_785.T_785);
	}

	private T_785(java.lang.String alias, org.jooq.Table<org.jooq.test.postgres.generatedclasses.tables.records.T_785Record> aliased) {
		super(alias, org.jooq.test.postgres.generatedclasses.Public.PUBLIC, aliased);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.test.postgres.generatedclasses.tables.T_785 as(java.lang.String alias) {
		return new org.jooq.test.postgres.generatedclasses.tables.T_785(alias, this);
	}

	/**
	 * Rename this table
	 */
	public org.jooq.test.postgres.generatedclasses.tables.T_785 rename(java.lang.String name) {
		return new org.jooq.test.postgres.generatedclasses.tables.T_785(name, null);
	}
}
