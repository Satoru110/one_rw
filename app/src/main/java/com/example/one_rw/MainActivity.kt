package com.example.one_rw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.one_rw.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var index = 0
    private val imageIdList = listOf(
        R.drawable.churka,
        R.drawable.ded,
        R.drawable.gop,
        R.drawable.hohol,
        R.drawable.kaka,
        R.drawable.krut,
        R.drawable.max,
        R.drawable.rinok,
    )
    private val adapter = RcAdapter()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()

    }
    private fun init(){
        binding.apply {
            rcView.layoutManager =LinearLayoutManager(this@MainActivity)
            rcView.adapter=adapter
            ButtonAdd.setOnClickListener {
                if(index>7) index = 0
                val pudge = Pudge(imageIdList[index],"Pudge,$index")
                adapter.addPudge(pudge)
                index++

            }
        }
    }
}