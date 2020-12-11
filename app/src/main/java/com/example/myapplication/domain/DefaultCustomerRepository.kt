package com.example.myapplication.domain

import androidx.lifecycle.LiveData
import com.example.myapplication.core.Resource
import com.example.myapplication.data.local.LocalDataSourceCustomer
import com.example.myapplication.data.model.CustomerEntity
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

@ExperimentalCoroutinesApi
@ActivityRetainedScoped
class DefaultCustomerRepository @Inject constructor(
    private val localDataSourceCustomer: LocalDataSourceCustomer
) : ICustomerRepository {
    override suspend fun getAllCustomers(): Resource<List<CustomerEntity>> {
        return localDataSourceCustomer.getAllCustomers()
    }

    override fun getCustomers(): LiveData<List<CustomerEntity>> {
        return localDataSourceCustomer.getCustomers()
    }

    override suspend fun newCustomer(customerEntity: CustomerEntity) {
        localDataSourceCustomer.newCustomer(customerEntity)
    }

    override suspend fun deleteCustomer(customerEntity: CustomerEntity) {
        localDataSourceCustomer.deleteCustomer(customerEntity)
    }

    override suspend fun getCustomerByName(customerName: String): Resource<List<CustomerEntity>> {
        return localDataSourceCustomer.getCustomerByName(customerName)
    }
}