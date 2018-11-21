package br.com.rhfa.desafio.zupmovies.views.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.rhfa.desafio.zupmovies.mvp.base.BasePresenter
import android.support.v7.widget.RecyclerView.Adapter

abstract class BaseRecyclerViewAdapter<T, VH : RecyclerView.ViewHolder>(private var dataList: MutableList<T>?, val basePresenterImpl: BasePresenter) : Adapter<VH>() {

    protected abstract fun layoutId(): Int

    protected abstract fun myOnCreateViewHolder(parent: View, viewType: Int, mBasePresenterImpl: BasePresenter): VH

    protected abstract fun myOnBindViewHolder(holder: VH, position: Int, item: T)

    protected fun onClean() {}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(layoutId(), parent, false)

        return myOnCreateViewHolder(itemView, viewType, basePresenterImpl)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        myOnBindViewHolder(holder, position, dataList!![position])
    }

    override fun getItemCount(): Int {
        return dataList!!.size
    }

    fun addItem(value: T) {
        dataList!!.add(value)
        notifyDataSetChanged()
    }

    fun addAll(values: List<T>) {
        dataList!!.addAll(values)
        notifyItemInserted(dataList!!.size)
        notifyItemRangeChanged(dataList!!.size - 1, dataList!!.size)
    }

    fun removeItem(position: Int) {
        dataList!!.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, dataList!!.size)
    }

    fun clear() {
        if (dataList != null && dataList!!.size > 0) {
            val size = this.dataList!!.size
            this.dataList!!.clear()
            onClean()
            notifyItemRangeRemoved(0, size)
        }
    }

    fun getDataList(): List<T>? {
        return dataList
    }
}
