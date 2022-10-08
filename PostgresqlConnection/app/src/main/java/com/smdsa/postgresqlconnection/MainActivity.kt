package com.smdsa.postgresqlconnection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.smdsa.postgresqlconnection.databinding.ActivityMainBinding
import com.smdsa.postgresqlconnection.fragments.ReadDataFragment
import com.smdsa.postgresqlconnection.fragments.WriteDataFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container_view, ReadDataFragment())
            .commit()

        binding.navigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.action_write -> supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view, WriteDataFragment()).commit()
                R.id.action_read -> supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view, ReadDataFragment()).commit()
            }
            return@setOnItemSelectedListener true
        }
    }
}