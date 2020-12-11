package com.example.myapplication.ui.customer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.myapplication.R
import com.example.myapplication.data.model.CustomerEntity
import com.example.myapplication.databinding.FragmentNewCustomerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewCustomerFragment : Fragment(R.layout.fragment_new_customer) {

    private val viewModel by activityViewModels<CustomerViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentNewCustomerBinding.bind(view)
        binding.btnSave.setOnClickListener {
            viewModel.newCustomer(
                CustomerEntity(
                    binding.txtIdCustomer.text.toString(),
                    binding.txtCompany.text.toString(),
                    binding.txtContact.text.toString(),
                    binding.txtAddress.text.toString(),
                    binding.txtCity.text.toString(),
                    binding.txtState.text.toString(),
                    binding.txtZip.text.toString(),
                    binding.txtEmail.text.toString(),
                    binding.txtPhone.text.toString()
                )
            )
        }

    }


}