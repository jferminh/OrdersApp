package com.example.myapplication.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myapplication.data.model.CustomerEntity

@Dao
interface CustomerDao {

    @Query("SELECT * FROM customersTable")
    suspend fun getAllCustomers(): List<CustomerEntity>

    @Query("SELECT * FROM customersTable")
    fun getAllCustomersWithChanges(): LiveData<List<CustomerEntity>>

    @Query("SELECT * FROM customersTable WHERE company_name LIKE '%' || :customerName || '%'")
    suspend fun getCustomerByName(customerName: String): List<CustomerEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCustomers(customer: CustomerEntity)

    @Delete
    suspend fun deleteCustomer(customer: CustomerEntity)
}