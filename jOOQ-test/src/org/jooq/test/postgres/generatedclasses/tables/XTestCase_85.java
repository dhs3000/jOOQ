/**
 * This class is generated by jOOQ
 */
package org.jooq.test.postgres.generatedclasses.tables;

/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class XTestCase_85 extends org.jooq.impl.TableImpl<org.jooq.test.postgres.generatedclasses.tables.records.XTestCase_85Record> {

	private static final long serialVersionUID = 2023739352;

	/**
	 * The singleton instance of <code>public.x_test_case_85</code>
	 */
	public static final org.jooq.test.postgres.generatedclasses.tables.XTestCase_85 X_TEST_CASE_85 = new org.jooq.test.postgres.generatedclasses.tables.XTestCase_85();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.jooq.test.postgres.generatedclasses.tables.records.XTestCase_85Record> getRecordType() {
		return org.jooq.test.postgres.generatedclasses.tables.records.XTestCase_85Record.class;
	}

	/**
	 * The column <code>public.x_test_case_85.id</code>. 
	 */
	public final org.jooq.TableField<org.jooq.test.postgres.generatedclasses.tables.records.XTestCase_85Record, java.lang.Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this);

	/**
	 * The column <code>public.x_test_case_85.x_unused_id</code>. 
	 */
	public final org.jooq.TableField<org.jooq.test.postgres.generatedclasses.tables.records.XTestCase_85Record, java.lang.Integer> X_UNUSED_ID = createField("x_unused_id", org.jooq.impl.SQLDataType.INTEGER.defaulted(true), this);

	/**
	 * The column <code>public.x_test_case_85.x_unused_name</code>. 
	 */
	public final org.jooq.TableField<org.jooq.test.postgres.generatedclasses.tables.records.XTestCase_85Record, java.lang.String> X_UNUSED_NAME = createField("x_unused_name", org.jooq.impl.SQLDataType.VARCHAR.length(10).defaulted(true), this);

	/**
	 * Create a <code>public.x_test_case_85</code> table reference
	 */
	public XTestCase_85() {
		super("x_test_case_85", org.jooq.test.postgres.generatedclasses.Public.PUBLIC);
	}

	/**
	 * Create an aliased <code>public.x_test_case_85</code> table reference
	 */
	public XTestCase_85(java.lang.String alias) {
		super(alias, org.jooq.test.postgres.generatedclasses.Public.PUBLIC, org.jooq.test.postgres.generatedclasses.tables.XTestCase_85.X_TEST_CASE_85);
	}

	private XTestCase_85(java.lang.String alias, org.jooq.Table<org.jooq.test.postgres.generatedclasses.tables.records.XTestCase_85Record> aliased) {
		super(alias, org.jooq.test.postgres.generatedclasses.Public.PUBLIC, aliased);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<org.jooq.test.postgres.generatedclasses.tables.records.XTestCase_85Record> getPrimaryKey() {
		return org.jooq.test.postgres.generatedclasses.Keys.PK_X_TEST_CASE_85;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<org.jooq.test.postgres.generatedclasses.tables.records.XTestCase_85Record>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<org.jooq.test.postgres.generatedclasses.tables.records.XTestCase_85Record>>asList(org.jooq.test.postgres.generatedclasses.Keys.PK_X_TEST_CASE_85);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<org.jooq.test.postgres.generatedclasses.tables.records.XTestCase_85Record, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<org.jooq.test.postgres.generatedclasses.tables.records.XTestCase_85Record, ?>>asList(org.jooq.test.postgres.generatedclasses.Keys.X_TEST_CASE_85__FK_X_TEST_CASE_85);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.test.postgres.generatedclasses.tables.XTestCase_85 as(java.lang.String alias) {
		return new org.jooq.test.postgres.generatedclasses.tables.XTestCase_85(alias, this);
	}

	/**
	 * Rename this table
	 */
	public org.jooq.test.postgres.generatedclasses.tables.XTestCase_85 rename(java.lang.String name) {
		return new org.jooq.test.postgres.generatedclasses.tables.XTestCase_85(name, null);
	}
}
