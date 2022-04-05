package dk.ubaya.adv160819001midtermproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import dk.ubaya.adv160819001midtermproject.R
import kotlinx.android.synthetic.main.fragment_thesis_detail.*

class ThesisDetailFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_thesis_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = ThesisDetailFragmentArgs.fromBundle(requireArguments()).id
        var year = ThesisDetailFragmentArgs.fromBundle(requireArguments()).year
        val splitid = id.split("-")
        val useid = splitid[1]+"_"+splitid[2]
        if(year=="2022"){
            year="file3"
        }else if(year=="2021"||year=="2020")
            year="file2"
        val url= "https://digilib.ubaya.ac.id/index.php?page=view/pdf_list&kode=$id&file=uploads_pdfmirrorghost/$year/$id/"+useid+"_Abstrak.pdf"

        webView.webViewClient = WebViewClient()
        webView.loadUrl(url)
        webView.settings.javaScriptEnabled=true
    }
}