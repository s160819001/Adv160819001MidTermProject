package dk.ubaya.adv160819001midtermproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dk.ubaya.adv160819001midtermproject.R
import dk.ubaya.adv160819001midtermproject.viewmodel.BookListViewModel
import kotlinx.android.synthetic.main.fragment_book_list.*

class BookListFragment : Fragment() {
    private lateinit var viewModelBook: BookListViewModel
    private val bookListAdapter  = BookListAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModelBook = ViewModelProvider(this).get(BookListViewModel::class.java)
        viewModelBook.refresh()

        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = bookListAdapter

        refreshLayoutBook.setOnRefreshListener {
            recView.visibility = View.GONE
            txtError.visibility = View.GONE
            progressLoad.visibility = View.VISIBLE
            viewModelBook.refresh()
            refreshLayoutBook.isRefreshing = false
        }

        observeViewModel()
    }

    fun observeViewModel() {
        viewModelBook.booksLD.observe(viewLifecycleOwner, Observer {
            bookListAdapter.updateBookList(it)
        })

        viewModelBook.loadingErrorLD.observe(viewLifecycleOwner, Observer {
            txtError.visibility = if (it) View.VISIBLE else View.GONE
        })

        viewModelBook.loadingLD.observe(viewLifecycleOwner, Observer {
            if(it) {
                progressLoad.visibility = View.VISIBLE
                recView.visibility = View.GONE
            } else {
                progressLoad.visibility = View.GONE
                recView.visibility = View.VISIBLE
            }
        })
    }
}