package ntnu.idatt2506.assignment_1_idatt2506

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import ntnu.idatt2506.assignment_1_idatt2506.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setter opp action bar (toolbar) for å vise menyen
        setSupportActionBar(binding.toolbar)
    }

    // Oppretter menyen
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    // Håndterer valg i menyen
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_firstname -> {
                Log.w("MainActivity", "Firstname pressed")
                true
            }
            R.id.action_lastname -> {
                Log.e("MainActivity", "Lastname pressed")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
