package dk.ubaya.adv160819001midtermproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import dk.ubaya.adv160819001midtermproject.R
import dk.ubaya.adv160819001midtermproject.util.loadImage
import dk.ubaya.adv160819001midtermproject.viewmodel.BookDetailViewModel
import kotlinx.android.synthetic.main.fragment_book_detail.*
import java.util.*
import java.util.concurrent.TimeUnit

class BookDetailFragment : Fragment() {
    private lateinit var viewModel: BookDetailViewModel
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(BookDetailViewModel::class.java)
        viewModel.fetch(BookDetailFragmentArgs.fromBundle(requireArguments()).isbn.toString())

        viewModel.bookLD.observe(viewLifecycleOwner, Observer{
            txtTitleDetail.setText(it.title)
            txtAuthorDetail.setText(it.author)
            txtPublisherDetail.setText(it.publisher)
            txtYear.setText(it.year)
            txtISBN.setText(it.isbn)
            txtSynopsis.setText(it.synopsis)
            imageViewDetail.loadImage("https://ubaya.fun/native/160819001/anmp/img/${it.isbn}.jpg", progressBarDetail)

            var book=it
            btnBorrow.setOnClickListener {
                Navigation.findNavController(it).navigate(BookDetailFragmentDirections.actionLocationFragment(book.location.toString()))
            }
        })
    }
}