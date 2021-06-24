package com.example.cryptoapp.ui.adapters

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cryptoapp.R
import com.example.cryptoapp.databinding.ViewHolderCryptoMarketItemBinding
import com.example.cryptoapp.network.response.get.Market

const val TAG="ADAPTER"
class CryptoRecyclerAdapter(val list:List<Market>):RecyclerView.Adapter<CryptoRecyclerAdapter.CryptoViewHolder>() {
    inner  class CryptoViewHolder(val binding:ViewHolderCryptoMarketItemBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val binding=ViewHolderCryptoMarketItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CryptoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        val binding=holder.binding
        binding.currencyName.text=list[position].symbol
        binding.cryptoPrice.text="${list[position].price}"
        Log.e(TAG,"Price ${list[position].priceUnconverted}")
        Log.e(TAG,"Percent ${list[position].change24h}")
        Log.e(TAG,"volume ${list[position].volume24h}")
        if(list[position].change24h<0){
//            the price decreased
            binding.cryptoPercent.setTextColor(Color.RED)
            binding.cryptoPercent.text="${list[position].change24h}"
            Glide.with(holder.itemView).load(R.drawable.arrow_down).into(binding.arrowImage)
        }
        else{
            binding.cryptoPercent.setTextColor(Color.GREEN)
            binding.cryptoPercent.text="${list[position].change24h}"
            Glide.with(holder.itemView).load(R.drawable.arrow_up).into(binding.arrowImage)
        }
    }

    override fun getItemCount()=list.size
}