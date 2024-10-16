package ntnu.idatt2506.assignment_4_idatt2506

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


class InformationFragment : Fragment() {

    private lateinit var titleView: TextView
    private lateinit var descriptionView: TextView
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_information, container, false)


        titleView = view.findViewById(R.id.titleTextView)
        descriptionView = view.findViewById(R.id.descriptionTextView)
        imageView = view.findViewById(R.id.coverArtImageView)

        return view
    }

    fun updateContent(item: Item) {
        titleView.text = item.title
        descriptionView.text = item.description
        imageView.setImageResource(item.image)
    }


}