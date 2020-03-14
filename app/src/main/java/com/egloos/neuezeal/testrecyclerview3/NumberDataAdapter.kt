package com.egloos.neuezeal.testrecyclerview3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_integer.view.*

class NumberDataAdapter(var list : List<Int>):RecyclerView.Adapter<NumberViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_integer, parent, false)
//        view.setOnClickListener(object: View.OnClickListener{
//            override fun onClick(v: View?) {
//                val id = v?.tag
//                if (selectionList.contains(id)) selectionList.remove(id)
//                else selectionList.add(id as Long)
//                notifyDataSetChanged()
//                onItemSelectionChangedListener?.let { it(selectionList) }
//
//            }
//        })
        view.setOnClickListener(View.OnClickListener {
            val id = it?.tag
            if(selectionList.contains(id)) selectionList.remove(id)
            else selectionList.add(id as Long)
            notifyDataSetChanged()
//            onItemSelectionChangedListener?.let{ it(selectionList)}
            onItemSelectionChangedListener?.let{ it(selectionList)}
        })
        return NumberViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        holder.containerView.integerText.text = list[position].toString()
        holder.containerView.tag = getItemId(position)
        holder.containerView.isActivated = selectionList.contains(getItemId(position))

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    val selectionList = mutableListOf<Long>()
    var onItemSelectionChangedListener: ((MutableList<Long>)->Unit)? = null
}