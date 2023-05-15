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
import org.jooq.Function7;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.InverseForeignKey;
import org.jooq.Name;
import org.jooq.Path;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row7;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.example.testcontainers.db.Indexes;
import org.jooq.example.testcontainers.db.Keys;
import org.jooq.example.testcontainers.db.Public;
import org.jooq.example.testcontainers.db.tables.Customer.CustomerPath;
import org.jooq.example.testcontainers.db.tables.Inventory.InventoryPath;
import org.jooq.example.testcontainers.db.tables.Payment.PaymentPath;
import org.jooq.example.testcontainers.db.tables.PaymentP2007_01.PaymentP2007_01Path;
import org.jooq.example.testcontainers.db.tables.PaymentP2007_02.PaymentP2007_02Path;
import org.jooq.example.testcontainers.db.tables.PaymentP2007_03.PaymentP2007_03Path;
import org.jooq.example.testcontainers.db.tables.PaymentP2007_04.PaymentP2007_04Path;
import org.jooq.example.testcontainers.db.tables.PaymentP2007_05.PaymentP2007_05Path;
import org.jooq.example.testcontainers.db.tables.PaymentP2007_06.PaymentP2007_06Path;
import org.jooq.example.testcontainers.db.tables.Staff.StaffPath;
import org.jooq.example.testcontainers.db.tables.records.RentalRecord;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Rental extends TableImpl<RentalRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.rental</code>
     */
    public static final Rental RENTAL = new Rental();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RentalRecord> getRecordType() {
        return RentalRecord.class;
    }

    /**
     * The column <code>public.rental.rental_id</code>.
     */
    public final TableField<RentalRecord, Long> RENTAL_ID = createField(DSL.name("rental_id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.rental.rental_date</code>.
     */
    public final TableField<RentalRecord, LocalDateTime> RENTAL_DATE = createField(DSL.name("rental_date"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "");

    /**
     * The column <code>public.rental.inventory_id</code>.
     */
    public final TableField<RentalRecord, Long> INVENTORY_ID = createField(DSL.name("inventory_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.rental.customer_id</code>.
     */
    public final TableField<RentalRecord, Long> CUSTOMER_ID = createField(DSL.name("customer_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.rental.return_date</code>.
     */
    public final TableField<RentalRecord, LocalDateTime> RETURN_DATE = createField(DSL.name("return_date"), SQLDataType.LOCALDATETIME(6), this, "");

    /**
     * The column <code>public.rental.staff_id</code>.
     */
    public final TableField<RentalRecord, Long> STAFF_ID = createField(DSL.name("staff_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.rental.last_update</code>.
     */
    public final TableField<RentalRecord, LocalDateTime> LAST_UPDATE = createField(DSL.name("last_update"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field(DSL.raw("now()"), SQLDataType.LOCALDATETIME)), this, "");

    private Rental(Name alias, Table<RentalRecord> aliased) {
        this(alias, aliased, null);
    }

    private Rental(Name alias, Table<RentalRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.rental</code> table reference
     */
    public Rental(String alias) {
        this(DSL.name(alias), RENTAL);
    }

    /**
     * Create an aliased <code>public.rental</code> table reference
     */
    public Rental(Name alias) {
        this(alias, RENTAL);
    }

    /**
     * Create a <code>public.rental</code> table reference
     */
    public Rental() {
        this(DSL.name("rental"), null);
    }

    public <O extends Record> Rental(Table<O> path, ForeignKey<O, RentalRecord> childPath, InverseForeignKey<O, RentalRecord> parentPath) {
        super(path, childPath, parentPath, RENTAL);
    }

    public static class RentalPath extends Rental implements Path<RentalRecord> {
        public <O extends Record> RentalPath(Table<O> path, ForeignKey<O, RentalRecord> childPath, InverseForeignKey<O, RentalRecord> parentPath) {
            super(path, childPath, parentPath);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.IDX_FK_INVENTORY_ID, Indexes.IDX_UNQ_RENTAL_RENTAL_DATE_INVENTORY_ID_CUSTOMER_ID);
    }

    @Override
    public Identity<RentalRecord, Long> getIdentity() {
        return (Identity<RentalRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<RentalRecord> getPrimaryKey() {
        return Keys.RENTAL_PKEY;
    }

    @Override
    public List<ForeignKey<RentalRecord, ?>> getReferences() {
        return Arrays.asList(Keys.RENTAL__RENTAL_INVENTORY_ID_FKEY, Keys.RENTAL__RENTAL_CUSTOMER_ID_FKEY, Keys.RENTAL__RENTAL_STAFF_ID_FKEY);
    }

    private transient InventoryPath _inventory;

    /**
     * Get the implicit join path to the <code>public.inventory</code> table.
     */
    public InventoryPath inventory() {
        if (_inventory == null)
            _inventory = new InventoryPath(this, Keys.RENTAL__RENTAL_INVENTORY_ID_FKEY, null);

        return _inventory;
    }

    private transient CustomerPath _customer;

    /**
     * Get the implicit join path to the <code>public.customer</code> table.
     */
    public CustomerPath customer() {
        if (_customer == null)
            _customer = new CustomerPath(this, Keys.RENTAL__RENTAL_CUSTOMER_ID_FKEY, null);

        return _customer;
    }

    private transient StaffPath _staff;

    /**
     * Get the implicit join path to the <code>public.staff</code> table.
     */
    public StaffPath staff() {
        if (_staff == null)
            _staff = new StaffPath(this, Keys.RENTAL__RENTAL_STAFF_ID_FKEY, null);

        return _staff;
    }

    private transient PaymentPath _payment;

    /**
     * Get the implicit to-many join path to the <code>public.payment</code>
     * table
     */
    public PaymentPath payment() {
        if (_payment == null)
            _payment = new PaymentPath(this, null, Keys.PAYMENT__PAYMENT_RENTAL_ID_FKEY.getInverseKey());

        return _payment;
    }

    private transient PaymentP2007_01Path _paymentP2007_01;

    /**
     * Get the implicit to-many join path to the
     * <code>public.payment_p2007_01</code> table
     */
    public PaymentP2007_01Path paymentP2007_01() {
        if (_paymentP2007_01 == null)
            _paymentP2007_01 = new PaymentP2007_01Path(this, null, Keys.PAYMENT_P2007_01__PAYMENT_P2007_01_RENTAL_ID_FKEY.getInverseKey());

        return _paymentP2007_01;
    }

    private transient PaymentP2007_02Path _paymentP2007_02;

    /**
     * Get the implicit to-many join path to the
     * <code>public.payment_p2007_02</code> table
     */
    public PaymentP2007_02Path paymentP2007_02() {
        if (_paymentP2007_02 == null)
            _paymentP2007_02 = new PaymentP2007_02Path(this, null, Keys.PAYMENT_P2007_02__PAYMENT_P2007_02_RENTAL_ID_FKEY.getInverseKey());

        return _paymentP2007_02;
    }

    private transient PaymentP2007_03Path _paymentP2007_03;

    /**
     * Get the implicit to-many join path to the
     * <code>public.payment_p2007_03</code> table
     */
    public PaymentP2007_03Path paymentP2007_03() {
        if (_paymentP2007_03 == null)
            _paymentP2007_03 = new PaymentP2007_03Path(this, null, Keys.PAYMENT_P2007_03__PAYMENT_P2007_03_RENTAL_ID_FKEY.getInverseKey());

        return _paymentP2007_03;
    }

    private transient PaymentP2007_04Path _paymentP2007_04;

    /**
     * Get the implicit to-many join path to the
     * <code>public.payment_p2007_04</code> table
     */
    public PaymentP2007_04Path paymentP2007_04() {
        if (_paymentP2007_04 == null)
            _paymentP2007_04 = new PaymentP2007_04Path(this, null, Keys.PAYMENT_P2007_04__PAYMENT_P2007_04_RENTAL_ID_FKEY.getInverseKey());

        return _paymentP2007_04;
    }

    private transient PaymentP2007_05Path _paymentP2007_05;

    /**
     * Get the implicit to-many join path to the
     * <code>public.payment_p2007_05</code> table
     */
    public PaymentP2007_05Path paymentP2007_05() {
        if (_paymentP2007_05 == null)
            _paymentP2007_05 = new PaymentP2007_05Path(this, null, Keys.PAYMENT_P2007_05__PAYMENT_P2007_05_RENTAL_ID_FKEY.getInverseKey());

        return _paymentP2007_05;
    }

    private transient PaymentP2007_06Path _paymentP2007_06;

    /**
     * Get the implicit to-many join path to the
     * <code>public.payment_p2007_06</code> table
     */
    public PaymentP2007_06Path paymentP2007_06() {
        if (_paymentP2007_06 == null)
            _paymentP2007_06 = new PaymentP2007_06Path(this, null, Keys.PAYMENT_P2007_06__PAYMENT_P2007_06_RENTAL_ID_FKEY.getInverseKey());

        return _paymentP2007_06;
    }

    @Override
    public Rental as(String alias) {
        return new Rental(DSL.name(alias), this);
    }

    @Override
    public Rental as(Name alias) {
        return new Rental(alias, this);
    }

    @Override
    public Rental as(Table<?> alias) {
        return new Rental(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Rental rename(String name) {
        return new Rental(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Rental rename(Name name) {
        return new Rental(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Rental rename(Table<?> name) {
        return new Rental(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row7 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row7<Long, LocalDateTime, Long, Long, LocalDateTime, Long, LocalDateTime> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function7<? super Long, ? super LocalDateTime, ? super Long, ? super Long, ? super LocalDateTime, ? super Long, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function7<? super Long, ? super LocalDateTime, ? super Long, ? super Long, ? super LocalDateTime, ? super Long, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
