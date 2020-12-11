package com.example.myapplication.ui.customer

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.DiffUtil.DiffResult.NO_POSITION
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.core.BaseViewHolder
import com.example.myapplication.data.model.CustomerEntity
import com.example.myapplication.databinding.CustomersRowBinding

class CustomerAdapter(
    private val context: Context,
    private val itemClickListener: OnCustomerClickListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    private var customerList = listOf<CustomerEntity>()

    fun setCustomerList(customerList: List<CustomerEntity>) {
        this.customerList = customerList
        notifyDataSetChanged()
    }

    interface OnCustomerClickListener {
        fun onCustomerClick(customerEntity: CustomerEntity, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = CustomersRowBinding.inflate(LayoutInflater.from(context), parent, false)
        val holder = CustomerViewHolder(itemBinding)

        itemBinding.root.setOnClickListener {
            val position = holder.adapterPosition.takeIf { it != NO_POSITION } ?: return@setOnClickListener
            itemClickListener.onCustomerClick(customerList[position], position)
        }
        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is CustomerViewHolder -> holder.bind(customerList[position])
        }
    }

    override fun getItemCount(): Int = customerList.size

    private inner class CustomerViewHolder(
        val binding: CustomersRowBinding
    ) : BaseViewHolder<CustomerEntity>(binding.root) {
        override fun bind(item: CustomerEntity) = with(binding) {
            Glide.with(context)
                .load(R.mipmap.ic_launcher)
                .centerCrop()
                .into(imgCustomer)

            txtCompanyName.text = item.companyName
            txtAddress.text = item.address
        }
    }
}