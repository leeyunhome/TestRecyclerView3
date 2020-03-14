package com.egloos.neuezeal.testrecyclerview3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var list = (1..100).toList().shuffled()

        var adapter = NumberDataAdapter(list)
        adapter.onItemSelectionChangedListener = {
            println("선택된 ID: $it")
        }
        integerList.adapter = adapter
        integerList.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
    }
}
