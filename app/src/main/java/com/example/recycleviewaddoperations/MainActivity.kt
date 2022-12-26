package com.example.recycleviewaddoperations

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    var uiEtUserName : EditText? = null
    var uiBtSubmit : Button? = null
    lateinit var adapter:RecycleAdapter
    lateinit var names : ArrayList<UserNameModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpUi()
        setUpListeners()
    }

    private fun setUpUi() {
        uiEtUserName = findViewById(R.id.uiEtUserName)
        uiBtSubmit = findViewById(R.id.uiBtsubmit)
        var recycleView: RecyclerView = findViewById(R.id.uiRvUserRecycleList)
        recycleView.layoutManager = LinearLayoutManager(this)
        names = arrayListOf<UserNameModel>(
            UserNameModel(
                userName = "Syed Abuthahir"
            )
        )
        adapter = RecycleAdapter(names)
        recycleView.adapter =adapter

    }



    @SuppressLint("NotifyDataSetChanged")
    private fun setUpListeners() {

        uiBtSubmit?.setOnClickListener {
            val uname :String = uiEtUserName?.text.toString().trim()
            upDateList(uname)
            Toast.makeText(this,"button working",Toast.LENGTH_LONG).show()
            adapter.notifyDataSetChanged()

        }
    }

    private fun upDateList(uname: String?) {
        names.add(
            UserNameModel(
                userName = uname
            )
        )
        uiEtUserName?.text=null

    }
}