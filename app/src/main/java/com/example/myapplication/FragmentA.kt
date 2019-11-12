package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_a_layout.*

class FragmentA : Fragment(){

    private lateinit var fragmentDelegate: FragmentADelegate


    fun setDelegate(fragmentADelegate: FragmentADelegate){
        this.fragmentDelegate = fragmentADelegate
    }

    interface FragmentADelegate {
        fun sendMessage(message: String)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.fragment_a_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragment_one_button.setOnClickListener {
            fragmentDelegate.sendMessage("Fragment A says hi!")
        }
    }

    fun displayMessageInA(message: String){
        fragment_one_textview.text = message
    }
}