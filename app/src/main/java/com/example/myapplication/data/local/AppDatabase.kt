package com.example.myapplication.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.data.model.CustomerEntity
import com.example.myapplication.data.model.OrderEntity
import com.example.myapplication.data.model.OrdersItems
import com.example.myapplication.data.model.ProductsEntity

@Database(
    entities = [CustomerEntity::class, OrderEntity::class, ProductsEntity::class, OrdersItems::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun customerDao(): CustomerDao
}