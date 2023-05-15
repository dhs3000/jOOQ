/*
 * This file is generated by jOOQ.
 */
package org.jooq.example.testcontainers.db.tables;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function11;
import org.jooq.Identity;
import org.jooq.InverseForeignKey;
import org.jooq.Name;
import org.jooq.Path;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row11;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.example.testcontainers.db.Keys;
import org.jooq.example.testcontainers.db.Public;
import org.jooq.example.testcontainers.db.tables.Address.AddressPath;
import org.jooq.example.testcontainers.db.tables.Payment.PaymentPath;
import org.jooq.example.testcontainers.db.tables.PaymentP2007_01.PaymentP2007_01Path;
import org.jooq.example.testcontainers.db.tables.PaymentP2007_02.PaymentP2007_02Path;
import org.jooq.example.testcontainers.db.tables.PaymentP2007_03.PaymentP2007_03Path;
import org.jooq.example.testcontainers.db.tables.PaymentP2007_04.PaymentP2007_04Path;
import org.jooq.example.testcontainers.db.tables.PaymentP2007_05.PaymentP2007_05Path;
import org.jooq.example.testcontainers.db.tables.PaymentP2007_06.PaymentP2007_06Path;
import org.jooq.example.testcontainers.db.tables.Rental.RentalPath;
import org.jooq.example.testcontainers.db.tables.Store.StorePath;
import org.jooq.example.testcontainers.db.tables.records.StaffRecord;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Staff extends TableImpl<StaffRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.staff</code>
     */
    public static final Staff STAFF = new Staff();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<StaffRecord> getRecordType() {
        return StaffRecord.class;
    }

    /**
     * The column <code>public.staff.staff_id</code>.
     */
    public final TableField<StaffRecord, Long> STAFF_ID = createField(DSL.name("staff_id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.staff.first_name</code>.
     */
    public final TableField<StaffRecord, String> FIRST_NAME = createField(DSL.name("first_name"), SQLDataType.VARCHAR(45).nullable(false), this, "");

    /**
     * The column <code>public.staff.last_name</code>.
     */
    public final TableField<StaffRecord, String> LAST_NAME = createField(DSL.name("last_name"), SQLDataType.VARCHAR(45).nullable(false), this, "");

    /**
     * The column <code>public.staff.address_id</code>.
     */
    public final TableField<StaffRecord, Long> ADDRESS_ID = createField(DSL.name("address_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.staff.email</code>.
     */
    public final TableField<StaffRecord, String> EMAIL = createField(DSL.name("email"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>public.staff.store_id</code>.
     */
    public final TableField<StaffRecord, Long> STORE_ID = createField(DSL.name("store_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.staff.active</code>.
     */
    public final TableField<StaffRecord, Boolean> ACTIVE = createField(DSL.name("active"), SQLDataType.BOOLEAN.nullable(false).defaultValue(DSL.field(DSL.raw("true"), SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>public.staff.username</code>.
     */
    public final TableField<StaffRecord, String> USERNAME = createField(DSL.name("username"), SQLDataType.VARCHAR(16).nullable(false), this, "");

    /**
     * The column <code>public.staff.password</code>.
     */
    public final TableField<StaffRecord, String> PASSWORD = createField(DSL.name("password"), SQLDataType.VARCHAR(40), this, "");

    /**
     * The column <code>public.staff.last_update</code>.
     */
    public final TableField<StaffRecord, LocalDateTime> LAST_UPDATE = createField(DSL.name("last_update"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field(DSL.raw("now()"), SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.staff.picture</code>.
     */
    public final TableField<StaffRecord, byte[]> PICTURE = createField(DSL.name("picture"), SQLDataType.BLOB, this, "");

    private Staff(Name alias, Table<StaffRecord> aliased) {
        this(alias, aliased, null);
    }

    private Staff(Name alias, Table<StaffRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.staff</code> table reference
     */
    public Staff(String alias) {
        this(DSL.name(alias), STAFF);
    }

    /**
     * Create an aliased <code>public.staff</code> table reference
     */
    public Staff(Name alias) {
        this(alias, STAFF);
    }

    /**
     * Create a <code>public.staff</code> table reference
     */
    public Staff() {
        this(DSL.name("staff"), null);
    }

    public <O extends Record> Staff(Table<O> path, ForeignKey<O, StaffRecord> childPath, InverseForeignKey<O, StaffRecord> parentPath) {
        super(path, childPath, parentPath, STAFF);
    }

    public static class StaffPath extends Staff implements Path<StaffRecord> {
        public <O extends Record> StaffPath(Table<O> path, ForeignKey<O, StaffRecord> childPath, InverseForeignKey<O, StaffRecord> parentPath) {
            super(path, childPath, parentPath);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<StaffRecord, Long> getIdentity() {
        return (Identity<StaffRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<StaffRecord> getPrimaryKey() {
        return Keys.STAFF_PKEY;
    }

    @Override
    public List<ForeignKey<StaffRecord, ?>> getReferences() {
        return Arrays.asList(Keys.STAFF__STAFF_ADDRESS_ID_FKEY, Keys.STAFF__STAFF_STORE_ID_FKEY);
    }

    private transient AddressPath _address;

    /**
     * Get the implicit join path to the <code>public.address</code> table.
     */
    public AddressPath address() {
        if (_address == null)
            _address = new AddressPath(this, Keys.STAFF__STAFF_ADDRESS_ID_FKEY, null);

        return _address;
    }

    private transient StorePath _store;

    /**
     * Get the implicit join path to the <code>public.store</code> table.
     */
    public StorePath store() {
        if (_store == null)
            _store = new StorePath(this, Keys.STAFF__STAFF_STORE_ID_FKEY, null);

        return _store;
    }

    private transient PaymentPath _payment;

    /**
     * Get the implicit to-many join path to the <code>public.payment</code>
     * table
     */
    public PaymentPath payment() {
        if (_payment == null)
            _payment = new PaymentPath(this, null, Keys.PAYMENT__PAYMENT_STAFF_ID_FKEY.getInverseKey());

        return _payment;
    }

    private transient PaymentP2007_01Path _paymentP2007_01;

    /**
     * Get the implicit to-many join path to the
     * <code>public.payment_p2007_01</code> table
     */
    public PaymentP2007_01Path paymentP2007_01() {
        if (_paymentP2007_01 == null)
            _paymentP2007_01 = new PaymentP2007_01Path(this, null, Keys.PAYMENT_P2007_01__PAYMENT_P2007_01_STAFF_ID_FKEY.getInverseKey());

        return _paymentP2007_01;
    }

    private transient PaymentP2007_02Path _paymentP2007_02;

    /**
     * Get the implicit to-many join path to the
     * <code>public.payment_p2007_02</code> table
     */
    public PaymentP2007_02Path paymentP2007_02() {
        if (_paymentP2007_02 == null)
            _paymentP2007_02 = new PaymentP2007_02Path(this, null, Keys.PAYMENT_P2007_02__PAYMENT_P2007_02_STAFF_ID_FKEY.getInverseKey());

        return _paymentP2007_02;
    }

    private transient PaymentP2007_03Path _paymentP2007_03;

    /**
     * Get the implicit to-many join path to the
     * <code>public.payment_p2007_03</code> table
     */
    public PaymentP2007_03Path paymentP2007_03() {
        if (_paymentP2007_03 == null)
            _paymentP2007_03 = new PaymentP2007_03Path(this, null, Keys.PAYMENT_P2007_03__PAYMENT_P2007_03_STAFF_ID_FKEY.getInverseKey());

        return _paymentP2007_03;
    }

    private transient PaymentP2007_04Path _paymentP2007_04;

    /**
     * Get the implicit to-many join path to the
     * <code>public.payment_p2007_04</code> table
     */
    public PaymentP2007_04Path paymentP2007_04() {
        if (_paymentP2007_04 == null)
            _paymentP2007_04 = new PaymentP2007_04Path(this, null, Keys.PAYMENT_P2007_04__PAYMENT_P2007_04_STAFF_ID_FKEY.getInverseKey());

        return _paymentP2007_04;
    }

    private transient PaymentP2007_05Path _paymentP2007_05;

    /**
     * Get the implicit to-many join path to the
     * <code>public.payment_p2007_05</code> table
     */
    public PaymentP2007_05Path paymentP2007_05() {
        if (_paymentP2007_05 == null)
            _paymentP2007_05 = new PaymentP2007_05Path(this, null, Keys.PAYMENT_P2007_05__PAYMENT_P2007_05_STAFF_ID_FKEY.getInverseKey());

        return _paymentP2007_05;
    }

    private transient PaymentP2007_06Path _paymentP2007_06;

    /**
     * Get the implicit to-many join path to the
     * <code>public.payment_p2007_06</code> table
     */
    public PaymentP2007_06Path paymentP2007_06() {
        if (_paymentP2007_06 == null)
            _paymentP2007_06 = new PaymentP2007_06Path(this, null, Keys.PAYMENT_P2007_06__PAYMENT_P2007_06_STAFF_ID_FKEY.getInverseKey());

        return _paymentP2007_06;
    }

    private transient RentalPath _rental;

    /**
     * Get the implicit to-many join path to the <code>public.rental</code>
     * table
     */
    public RentalPath rental() {
        if (_rental == null)
            _rental = new RentalPath(this, null, Keys.RENTAL__RENTAL_STAFF_ID_FKEY.getInverseKey());

        return _rental;
    }

    @Override
    public Staff as(String alias) {
        return new Staff(DSL.name(alias), this);
    }

    @Override
    public Staff as(Name alias) {
        return new Staff(alias, this);
    }

    @Override
    public Staff as(Table<?> alias) {
        return new Staff(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Staff rename(String name) {
        return new Staff(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Staff rename(Name name) {
        return new Staff(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Staff rename(Table<?> name) {
        return new Staff(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row11 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row11<Long, String, String, Long, String, Long, Boolean, String, String, LocalDateTime, byte[]> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function11<? super Long, ? super String, ? super String, ? super Long, ? super String, ? super Long, ? super Boolean, ? super String, ? super String, ? super LocalDateTime, ? super byte[], ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function11<? super Long, ? super String, ? super String, ? super Long, ? super String, ? super Long, ? super Boolean, ? super String, ? super String, ? super LocalDateTime, ? super byte[], ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
