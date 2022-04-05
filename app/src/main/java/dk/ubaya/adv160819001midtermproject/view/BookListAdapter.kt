package dk.ubaya.adv160819001midtermproject.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import dk.ubaya.adv160819001midtermproject.R
import dk.ubaya.adv160819001midtermproject.model.Book
import dk.ubaya.adv160819001midtermproject.util.loadImage
import kotlinx.android.synthetic.main.book_list_item.view.*

class BookListAdapter(val bookList:ArrayList<Book>): RecyclerView.Adapter<BookListAdapter.BookViewHolder>() {
    class BookViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    fun updateBookList(newBookList: List<Book>) {
        bookList.clear()
        bookList.addAll(newBookList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.book_list_item, parent, false)
        return BookViewHolder(v)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.view.txtTitle.text = bookList[position].title
        holder.view.txtAuthor.text = bookList[position].author
        holder.view.txtPublisher.text = bookList[position].publisher
        holder.view.imageView.loadImage("https://ubaya.fun/native/160819001/anmp/img/${bookList[position].isbn}.jpg", holder.view.progressBar)

        holder.view.cardView.setOnClickListener {
            Navigation.findNavController(it).navigate(BookListFragmentDirections.actionBookDetail(bookList[position].isbn.toString()))
        }
    }

    override fun getItemCount(): Int {
        return bookList.size
    }
}