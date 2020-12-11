package com.example.myapplication.data.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.myapplication.core.Resource
import com.example.myapplication.data.model.CustomerEntity
import com.example.myapplication.data.model.asCustomerEntity
import com.example.myapplication.data.model.asCustomerList
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
class LocalDataSourceCustomer @Inject constructor(private val customerDao: CustomerDao) {
    fun getCustomers(): LiveData<List<CustomerEntity>> {
        return customerDao.getAllCustomersWithChanges().map { it.asCustomerList() }
    }

    suspend fun getAllCustomers(): Resource<List<CustomerEntity>> {
        return Resource.Success(customerDao.getAllCustomers().asCustomerList())
    }

    suspend fun getCustomerByName(customerName: String): Resource<List<CustomerEntity>> {
        return Resource.Success(customerDao.getCustomerByName(customerName).asCustomerList())
    }

    suspend fun newCustomer(customerEntity: CustomerEntity){
        return customerDao.saveCustomers(customerEntity.asCustomerEntity())
    }

    suspend fun deleteCustomer(customerEntity: CustomerEntity) {
        return customerDao.deleteCustomer(customerEntity.asCustomerEntity())
    }
}