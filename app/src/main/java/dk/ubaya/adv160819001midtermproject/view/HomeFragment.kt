package dk.ubaya.adv160819001midtermproject.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.SupportActionModeWrapper
import dk.ubaya.adv160819001midtermproject.R
import dk.ubaya.adv160819001midtermproject.util.loadImage
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


//        (activity as AppCompatActivity).toolbar.setTitle("Home")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        (activity as AppCompatActivity).supportActionBar?.setTitle("Home")
//        (activity as AppCompatActivity).supportActionBar?.title="Home"
        imageViewHome.loadImage("https://ubaya.fun/native/160819001/anmp/img/ubayalibrary.jpg")
        imageViewNews1.loadImage("https://ubaya.fun/native/160819001/anmp/img/news-1.jpg")
    }


}