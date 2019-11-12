package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), FragmentA.FragmentADelegate, FragmentB.FragmentBDelegate {

    override fun sendMessageToFragmentB(message: String) {
        fragmentB.displayMessageInB(message)
    }

    override fun senMessageToFragmentA(message: String) {
        fragmentA.displayMessageInA(message)
    }

    private lateinit var fragmentA: FragmentA
    private lateinit var fragmentB: FragmentB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentA = FragmentA()
        fragmentB = FragmentB()

        open_fragments_button.setOnClickListener {

            openFragments()
        }
    }

    private fun openFragments() {
        supportFragmentManager.beginTransaction()
            .add(R.id.frame_layout_one, fragmentA)
            .addToBackStack(fragmentA.tag)
            .commit()

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout_two, fragmentB)
            .addToBackStack(fragmentB.tag)
            .commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        supportFragmentManager.popBackStack()
    }

    override fun onAttachFragment(fragment: Fragment) {
        super.onAttachFragment(fragment)
        if (fragment is FragmentA)
            (fragment as FragmentA).setDelegate(this)
        else
            (fragment as FragmentB).setDelegate(this)

    }
}
