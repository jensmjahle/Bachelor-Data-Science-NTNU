package ntnu.idatt2506.assignment_3_idatt2506

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity


class NewFriendActivity : ComponentActivity() {
    private lateinit var saveButton: Button
    private lateinit var cancelButton: Button
    private lateinit var nameEditText: EditText
    private lateinit var birthdateEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_friend)

        saveButton = findViewById(R.id.saveButton)
        cancelButton = findViewById(R.id.cancelButton)
        nameEditText = findViewById(R.id.nameInput)
        birthdateEditText = findViewById(R.id.birthdateInput)


        val incomingName = intent.getStringExtra("name")
        val incomingBirthdate = intent.getStringExtra("birthdate")
        val position = intent.getIntExtra("position", -1)

        if (incomingName != null && incomingBirthdate != null) {
            nameEditText.setText(incomingName)
            birthdateEditText.setText(incomingBirthdate)
        }

        saveButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val birthdate = birthdateEditText.text.toString()

            val resultIntent = Intent()
            resultIntent.putExtra("name", name)
            resultIntent.putExtra("birthdate", birthdate)
            resultIntent.putExtra("position", position)
            setResult(Activity.RESULT_OK, resultIntent)
            if (position != -1) {
                Toast.makeText(this, "Friend updated!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Friend added!", Toast.LENGTH_SHORT).show()
            }
            finish()
        }
        cancelButton.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            Toast.makeText(this, "Operation canceled!", Toast.LENGTH_SHORT).show()
            finish()
        }


    }
}

