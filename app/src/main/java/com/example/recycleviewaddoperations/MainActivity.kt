package com.example.recycleviewaddoperations

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewaddoperations.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private var uiEtUserName : EditText? = null
    private var uiBtSubmit : Button? = null
    private var recyclerView:RecyclerView?=null
    lateinit var adapter:RecycleAdapter
    lateinit var names : ArrayList<UserNameModel>

    private val binding:ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setUpUi()
        setUpListeners()
    }

    private fun setUpUi() {
        uiEtUserName = binding.uiEtUserName
        uiBtSubmit = binding.uiBtAddUserName
        recyclerView= binding.uiRvUserNameList
        names = arrayListOf<UserNameModel>(
            UserNameModel(
                userName = "Syed Abuthahir"
            )
        )
        adapter = RecycleAdapter(names)
        recyclerView!!.adapter =adapter

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