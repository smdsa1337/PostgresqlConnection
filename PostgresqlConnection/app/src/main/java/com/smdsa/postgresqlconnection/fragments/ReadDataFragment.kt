package com.smdsa.postgresqlconnection.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.smdsa.postgresqlconnection.databinding.FragmentReadDataBinding
import com.smdsa.postgresqlconnection.retrofit.MyRetrofit
import com.smdsa.postgresqlconnection.retrofit.WordsDataClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReadDataFragment : Fragment() {

    private lateinit var binding: FragmentReadDataBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentReadDataBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        MyRetrofit()
            .retrofit
            .getAll()
            .enqueue(object : Callback<ArrayList<WordsDataClass>> {
                override fun onResponse(call: Call<ArrayList<WordsDataClass>>,
                                        response: Response<ArrayList<WordsDataClass>>){
                    var a = ""
                    response.body()?.forEach {
                        a+= it.word + " "
                    }
                    binding.text2.text = a
                }

                override fun onFailure(call: Call<ArrayList<WordsDataClass>>, t: Throwable) {}
            })
    }
}