package com.example.myapplication.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "customersTable")
data class CustomerEntity(
        @PrimaryKey
        @ColumnInfo(name = "customer_id")
        val customerId: String = "",
        @ColumnInfo(name = "company_name")
        val companyName: String = "",
        @ColumnInfo(name = "contact_name")
        val contactName: String = "",
        @ColumnInfo(name = "address")
        val address: String = "",
        @ColumnInfo(name = "city")
        val city: String = "",
        @ColumnInfo(name = "state")
        val state: String = "",
        @ColumnInfo(name = "zip")
        val zip: String = "",
        @ColumnInfo(name = "email")
        val email: String = "",
        @ColumnInfo(name = "phone")
        val phone: String = ""
)

@Entity(tableName = "ordersTable")
data class OrderEntity (
        @PrimaryKey
        @ColumnInfo(name = "order_id")
        val orderId: String = "",
        @ColumnInfo(name = "customer_id")
        val custormerId: String = "",
        @ColumnInfo(name = "order_status")
        val orderStatus: String = "",
        @ColumnInfo(name = "order_date")
        val orderDate: String = "",
        @ColumnInfo(name = "required_date")
        val requiredDate: String = "",
        @ColumnInfo(name = "shipped_date")
        val shippedDate: String = "",
        @ColumnInfo(name = "gross_total")
        val grossTotal: Float = 0F,
        @ColumnInfo(name = "tax")
        val tax: Float = 0F,
        @ColumnInfo(name = "total_order")
        val totalOrder: Float = 0F
)

@Entity(
        tableName = "orders_items",
        primaryKeys = ["order_id", "item_id"]
)
data class OrdersItems (
        @ColumnInfo(name = "order_id")
        val orderId: String = "",
        @ColumnInfo(name = "item_id")
        val itemId: String = "",
        @ColumnInfo(name = "product_id")
        val productId: String = "",
        @ColumnInfo(name = "quantity")
        val quantity: Int = 0,
        @ColumnInfo(name = "unit_price")
        val unitPrice: Float = 0F
)

@Entity(tableName = "products")
data class ProductsEntity (
        @PrimaryKey
        @ColumnInfo(name = "product_id")
        val productId: String = "",
        @ColumnInfo(name = "product_name")
        val productName: String = "",
        val description: String = "",
        @ColumnInfo(name = "product_price")
        val productPrice: Float = 0F
)

fun List<CustomerEntity>.asCustomerList(): List<CustomerEntity> = this.map {
        CustomerEntity(it.customerId, it.companyName, it.contactName, it.address, it.city, it.state, it.zip, it.email, it.phone)
}

fun CustomerEntity.asCustomerEntity(): CustomerEntity =
        CustomerEntity(this.customerId, this.companyName, this.contactName, this.address, this.city, this.state, this.zip, this.email, this.phone)
