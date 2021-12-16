//package com.ranzan.takeaway2.view
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.databinding.DataBindingUtil
//import androidx.recyclerview.widget.RecyclerView
//import com.ranzan.takeaway2.R
//import com.ranzan.takeaway2.databinding.ItemViewBinding
//import com.ranzan.takeaway2.model.api.AddressListItem
//
//class RecyclerView(var list: ArrayList<AddressListItem>) :
//    RecyclerView.Adapter<RecyclerViewHolder>() {
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
//        val layoutIn = LayoutInflater.from(parent.context)
//        val itemViewBinding: ItemViewBinding =
//            DataBindingUtil.inflate(layoutIn, R.layout.item_view, parent, false)
//        return RecyclerViewHolder(itemViewBinding)
//    }
//
//    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
//        holder.onBind(list[position])
//    }
//
//    override fun getItemCount(): Int = list.size
//}
//
//class RecyclerViewHolder(private val itemViewBinding: ItemViewBinding) :
//    RecyclerView.ViewHolder(itemViewBinding.root) {
//
//    fun onBind(addressListItem: AddressListItem) {
//        itemViewBinding.addressItem = addressListItem
//    }
//
//
//}