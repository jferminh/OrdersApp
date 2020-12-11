package com.example.myapplication.ui.customer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.core.Resource
import com.example.myapplication.data.model.CustomerEntity
import com.example.myapplication.databinding.FragmentCustomerBinding
import com.example.myapplication.utils.show
import com.example.myapplication.utils.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CustomerFragment : Fragment(R.layout.fragment_customer), CustomerAdapter.OnCustomerClickListener {

    private val viewModel by activityViewModels<CustomerViewModel>()
    private lateinit var customerAdapter: CustomerAdapter

    private lateinit var customerViewModel: CustomerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        customerAdapter = CustomerAdapter(requireContext(), this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentCustomerBinding.bind(view)

        binding.rvCustomer.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCustomer.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        binding.rvCustomer.adapter = customerAdapter
        binding.fabCustomer.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_customer_to_newCustomerFragment)
        }

        viewModel.getCustomers().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    if (it.data.isEmpty()) {
                        binding.emptyContainer.root.show()
                        return@observe
                    }
                    customerAdapter.setCustomerList(it.data)
                }
                is Resource.Failure -> {
                    showToast("An error occurred ${it.exception}")
                }
            }
        }
//        binding.searchViewCustomer.onQueryTextChanged {
//            viewModel.set
//        }
    }


    override fun onCustomerClick(customerEntity: CustomerEntity, position: Int) {
        TODO("Not yet implemented")
    }

}