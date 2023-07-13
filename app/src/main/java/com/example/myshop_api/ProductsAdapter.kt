package com.example.myshop_api

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.inputmethod.InputBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.myshop_api.databinding.RecyclerBinding
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class ProductsAdapter( var productlist: List<Product>):RecyclerView.Adapter<ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding =
            RecyclerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val currentProduct = productlist.get(position)
        val binding = holder.binding
        binding.textView.text = currentProduct.title
        binding.textView2.text = currentProduct.description
        binding.textView3.text = currentProduct.category
        binding.textView4.text = currentProduct.rating
        binding.textView5.text = currentProduct.stock.toString()
        binding.textView6.text = currentProduct.id.toString()
        binding.textView7.text = currentProduct.Price.toString()

        Picasso
            .get()
            .load (currentProduct.thumbnail)
            .placeholder(R.drawable.ic_launcher_foreground)
////            .resize(80,80)
////            .centerCrop()
            .transform(CropCircleTransformation())
            .into(binding.imageView)


    }

    override fun getItemCount(): Int {
        return productlist.size
    }
}

class ProductViewHolder(var binding: RecyclerBinding ):RecyclerView.ViewHolder(binding.root)
