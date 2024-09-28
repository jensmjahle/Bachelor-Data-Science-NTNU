package ntnu.idatt2506.assignment_3_idatt2506

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts


class MainActivity : ComponentActivity() {

    private val friendsList = ArrayList<String>()
    private lateinit var friendsAdapter: ArrayAdapter<String>

    private val editFriendLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            val editedName = data?.getStringExtra("name")
            val editedBirthdate = data?.getStringExtra("birthdate")
            val position = data?.getIntExtra("position", -1) ?: -1

            if (editedName != null && editedBirthdate != null && position != -1) {
                friendsList[position] = "Navn: $editedName - Fødselsdato: $editedBirthdate"
                friendsAdapter.notifyDataSetChanged()
            }
        }
    }



    private val newFriendLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            val name = data?.getStringExtra("name")
            val birthdate = data?.getStringExtra("birthdate")

            if (name != null && birthdate != null) {
                friendsList.add("Navn: $name - Fødselsdato: $birthdate")
                friendsAdapter.notifyDataSetChanged()
            }

            Log.d("MainActivity", "Name: $name, Birthdate: $birthdate")
        } else if (result.resultCode == RESULT_CANCELED) {
            Log.d("MainActivity", "NewFriendActivity canceled")
        } else {
            Log.e("MainActivity", "Unexpected result from NewFriendActivity")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addNewFriendButton = findViewById<Button>(R.id.addNewFriend_Button)
        val friendsListView = findViewById<ListView>(R.id.friendsListView)

        friendsAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, friendsList)
        friendsListView.adapter = friendsAdapter

        addNewFriendButton.setOnClickListener {
            val intent = Intent(this, NewFriendActivity::class.java)
            newFriendLauncher.launch(intent)
        }

        friendsListView.setOnItemClickListener { parent, view, position, id ->
            Log.e("MainActivity", "Friend clicked at position: $position")
            showActionDialog(position)
        }


    }

    private fun showActionDialog(position: Int) {
        Log.d("MainActivity", "Showing action dialog for position: $position")
        val actions = arrayOf("Avbryt", "Rediger", "Fjern")
        val builder = android.app.AlertDialog.Builder(this)
        builder.setTitle("Velg handling")
        builder.setItems(actions) { dialog, which ->
            when (which) {
                0 -> dialog.dismiss()
                1 -> editFriend(position)
                2 -> removeFriend(position)
            }
            }
        builder.show()
    }

    private fun editFriend (position: Int) {
        val friendData = friendsList[position].split(" - ")
        val name = friendData[0].substring("Navn: ".length)
        val birthdate = friendData[1].substring("Fødselsdato: ".length)

        val intent = Intent(this, NewFriendActivity::class.java)
        intent.putExtra("name", name)
        intent.putExtra("birthdate", birthdate)
        intent.putExtra("position", position)
        editFriendLauncher.launch(intent)
    }

    private fun removeFriend (position: Int) {
        friendsList.removeAt(position)
        friendsAdapter.notifyDataSetChanged()
        Log.d("MainActivity", "Friend removed at position: $position")
        Toast.makeText(this, "Venn fjernet", Toast.LENGTH_SHORT).show()
    }


}

