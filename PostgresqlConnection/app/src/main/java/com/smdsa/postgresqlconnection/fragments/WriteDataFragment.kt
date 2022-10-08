package com.smdsa.postgresqlconnection.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.smdsa.postgresqlconnection.databinding.FragmentWriteDataBinding
import com.smdsa.postgresqlconnection.retrofit.MyRetrofit
import com.smdsa.postgresqlconnection.retrofit.WordDataClassPost
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WriteDataFragment : Fragment() {

    private lateinit var binding: FragmentWriteDataBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWriteDataBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.pushButton.setOnClickListener {
            MyRetrofit()
                .retrofit
                .saveWord(WordDataClassPost(binding.word.text.toString()))
                .enqueue(object : Callback<WordDataClassPost>{
                    override fun onResponse(
                        call: Call<WordDataClassPost>,
                        response: Response<WordDataClassPost>
                    ) {
                        if(response.code() == 201){
                            Toast.makeText(activity, "Successful", Toast.LENGTH_LONG).show()
                        }
                    }

                    override fun onFailure(call: Call<WordDataClassPost>, t: Throwable) {
                       Toast.makeText(activity, t.message.toString(), Toast.LENGTH_LONG).show()
                    }
                })
        }
    }
}