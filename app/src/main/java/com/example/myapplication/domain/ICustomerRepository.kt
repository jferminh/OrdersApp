package com.example.myapplication.domain

import androidx.lifecycle.LiveData
import com.example.myapplication.core.Resource
import com.example.myapplication.data.model.CustomerEntity
import kotlinx.coroutines.flow.Flow

interface ICustomerRepository {
    suspend fun getCustomerByName(customerName: String): Resource<List<CustomerEntity>>
    suspend fun getAllCustomers(): Resource<List<CustomerEntity>>
    fun getCustomers(): LiveData<List<CustomerEntity>>
    suspend fun newCustomer(customerEntity: CustomerEntity)
    suspend fun deleteCustomer(customerEntity: CustomerEntity)
}