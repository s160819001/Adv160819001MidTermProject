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
import kotlinx.android.synthetic.main.fragment_book_list.view.*

class BookListAdapter(val bookList:ArrayList<Book>): RecyclerView.Adapter<BookListAdapter.StudentViewHolder>() {
    class StudentViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    fun updateBookList(newBookList: List<Book>) {
        bookList.clear()
        bookList.addAll(newBookList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.book_list_item, parent, false)
        return StudentViewHolder(v)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.view.txtTitle.text = bookList[position].title
        holder.view.txtAuthor.text = bookList[position].author
        holder.view.txtPublisher.text = bookList[position].publisher
        holder.view.imageView.loadImage("https://ubaya.fun/native/160819001/anmp/img/${bookList[position].isbn}.jpg", holder.view.progressBar)

//        holder.view.btnDetail.setOnClickListener {
//            val action = StudentListFragmentDirections.actionStudenDetail(studenList[position].id.toString())
//            Navigation.findNavController(it).navigate(action)
//        }
    }

    override fun getItemCount(): Int {
        return bookList.size
    }
}