package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_b_layout.*

class FragmentB : Fragment(){
    private lateinit var fragmentDelegate: FragmentBDelegate

    fun setDelegate(fragmentBDelegate: FragmentBDelegate){
        this.fragmentDelegate = fragmentBDelegate
    }

    interface FragmentBDelegate {
        fun senMessageToFragmentA(message: String)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.fragment_b_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragment_two_button.setOnClickListener {
            fragmentDelegate.senMessageToFragmentA("Fragment B says hi!")
        }
    }


    fun displayMessageInB(message: String){
        fragment_two_textview.text = message
    }
}