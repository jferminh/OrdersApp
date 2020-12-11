package com.example.myapplication.application.injection

import com.example.myapplication.domain.DefaultCustomerRepository
import com.example.myapplication.domain.ICustomerRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class ActivityRetainedModule {
    @Binds
    abstract fun dataSourceCustomer(impl: DefaultCustomerRepository): ICustomerRepository
}