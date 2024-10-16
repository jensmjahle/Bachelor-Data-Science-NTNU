package ntnu.idatt2506.assignment_4_idatt2506

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.FragmentActivity
import ntnu.idatt2506.assignment_4_idatt2506.ui.theme.Assignment_4_IDATT2506Theme

class MainActivity : FragmentActivity(), ListFragment.OnItemClickListener {
    private lateinit var informationFragment: InformationFragment
    private var currentIndex: Int = 0

    private val items = listOf(
        Item("Titanic", "En episk kjærlighetshistorie satt mot bakteppet av det tragiske forliset av RMS Titanic.", R.drawable.titanic),
        Item("Avengers", "En gruppe superhelter må forenes for å stoppe en mektig fiende fra å ødelegge jorden.", R.drawable.avengers),
        Item("Thor", "En tidligere mektig gud som må bevise seg verdig til å bære sin hammer igjen.", R.drawable.thor),
        Item("Platanic", "En episk kjærlighetshistorie satt mot bakteppet av det tragiske forliset av RMS Titanic.", R.drawable.titanic),
        Item("Revengers", "En gruppe superhelter må forenes for å stoppe en mektig fiende fra å ødelegge jorden.", R.drawable.avengers),
        Item("Thor: Odin Son", "En tidligere mektig gud som må bevise seg verdig til å bære sin hammer igjen.", R.drawable.thor)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listFragment = ListFragment()
        listFragment.setOnItemClickListener(this)

        supportFragmentManager.beginTransaction()
            .replace(R.id.listFragmentContainerView, listFragment)
            .commit()

        informationFragment = InformationFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.informationFragmentContainerView, informationFragment)
            .commit()

        val prevButton = findViewById<Button>(R.id.previousButton)
        val nextButton = findViewById<Button>(R.id.nextButton)

        // Funksjonalitet for "Neste"-knappen
        nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % items.size
            updateFragmentsWithNewItem()
        }

        // Funksjonalitet for "Forrige"-knappen
        prevButton.setOnClickListener {
            currentIndex = if (currentIndex - 1 < 0) items.size - 1 else currentIndex - 1
            updateFragmentsWithNewItem()
        }

    }

    private fun updateFragmentsWithNewItem() {
        if (currentIndex in items.indices) {
            informationFragment.updateContent(items[currentIndex])
            val listFragment = supportFragmentManager.findFragmentById(R.id.listFragmentContainerView) as? ListFragment

            listFragment?.scrollToItem(currentIndex) ?: run {
                Log.e("ListFragment", "ListFragment not found or not scrollable")
            }
        } else {
           Log.e("ListFragment", "Invalid index: $currentIndex")
        }

    }
    override fun onItemClick(item: Item) {
        val informationFragment = supportFragmentManager.findFragmentById(R.id.informationFragmentContainerView) as? InformationFragment
        informationFragment?.updateContent(item)

        currentIndex = items.indexOf(item)
    }

    fun getItems(): List<Item> {
        return items
    }
}

