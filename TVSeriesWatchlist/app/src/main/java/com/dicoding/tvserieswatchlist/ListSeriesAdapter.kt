package com.dicoding.tvserieswatchlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.tvserieswatchlist.databinding.ItemRowSeriesBinding

class ListSeriesAdapter(private val listSeries: ArrayList<Series>) : RecyclerView.Adapter<ListSeriesAdapter.SeriesViewHolder>() {

    var onItemClick : ((Series) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeriesViewHolder {
        val viewBinding = ItemRowSeriesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SeriesViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: SeriesViewHolder, position: Int) {
        val series = listSeries[position]
        holder.bind(series)
        holder.itemView.setOnClickListener{
            onItemClick?.invoke(series)
        }
    }

    override fun getItemCount(): Int {
        return listSeries.size
    }

    class SeriesViewHolder(private val viewBinding: ItemRowSeriesBinding) : RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(series: Series){
            viewBinding.tvItemName.text = series.name
            viewBinding.tvItemGenre.text = series.genre
            viewBinding.tvItemYear.text = series.year.toString()
            viewBinding.imgItemPhoto.setImageResource(series.photo)

        }
    }
}