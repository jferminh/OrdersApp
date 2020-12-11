package com.example.myapplication.ui.customer

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.myapplication.application.ToastHelper
import com.example.myapplication.core.Resource
import com.example.myapplication.data.model.CustomerEntity
import com.example.myapplication.domain.ICustomerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CustomerViewModel @ViewModelInject constructor(
    private val repository: ICustomerRepository,
    private val toastHelper: ToastHelper,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

//    private val currentCustomerName = savedStateHandle.getLiveData<<String>("customerName", "Julio")
//
//    val fetchCustomerList = currentCustomerName.dist

    fun getCustomers() =
        liveData<Resource<List<CustomerEntity>>>(viewModelScope.coroutineContext + Dispatchers.IO) {
            emit(Resource.Loading())
            try {
                emitSource(repository.getCustomers().map { Resource.Success(it) })
            } catch (e: Exception) {
                emit(Resource.Failure(e))
            }
        }

    fun newCustomer(customerEntity: CustomerEntity) {
        viewModelScope.launch {
            repository.newCustomer(customerEntity)
            toastHelper.sendToast("Customer saved")
        }
    }

    fun deleteCustomer(customerEntity: CustomerEntity) {
        viewModelScope.launch {
            repository.deleteCustomer(customerEntity)
            toastHelper.sendToast("Customer deleted")
        }
    }

}