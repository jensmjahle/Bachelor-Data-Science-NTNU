package ntnu.idatt2506.assignment_4_idatt2506

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ListFragment : Fragment() {

    interface OnItemClickListener {
        fun onItemClick(item: Item)
    }

    private lateinit var itemClickListener: OnItemClickListener
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    fun setOnItemClickListener(listener: OnItemClickListener) {
        itemClickListener = listener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        recyclerView = view.findViewById<RecyclerView>(R.id.listOfMoviesRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val items = (activity as MainActivity).getItems()

        adapter = ItemAdapter(items) { item ->
            itemClickListener.onItemClick(item)
        }
        recyclerView.adapter = adapter


        return view
    }

    fun scrollToItem(index: Int) {
        recyclerView.scrollToPosition(index)
    }
}
