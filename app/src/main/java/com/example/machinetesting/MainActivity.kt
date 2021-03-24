package com.example.machinetesting

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.machinetesting.adapter.DataAdapter
import com.example.machinetesting.model.ResponseModel
import com.example.machinetesting.networking.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        mainActivityViewModel.getList()!!.observe(this, Observer { list ->
            progressBar.visibility = View.GONE
            rvImageList.adapter = DataAdapter(list as ArrayList<ResponseModel>)
        })
    }
}