package com.emanuel.affirmations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emanuel.affirmations.adapter.ItemAdapter
import com.emanuel.affirmations.data.Datasource
import com.emanuel.affirmations.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myDataset = Datasource().loadAffirmations()
        with(binding.recyclerAffirmations) {
            adapter = ItemAdapter(
                context = this@MainActivity,
                dataset = myDataset
            )
            setHasFixedSize(true)
        }

    }
}