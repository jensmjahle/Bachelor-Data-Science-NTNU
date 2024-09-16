package ntnu.idatt2506.assignment_2_1_idatt2506

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast

class RandomNumberActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Get the max limit from the intent extras
        val maxLimit = intent.getIntExtra("MAX_LIMIT", 100)

        // Generate a random number within the specified range
        val randomNumber = (0..maxLimit).random()

        // Display a toast message with the random number
        //Toast.makeText(this, "Random Number: $randomNumber", Toast.LENGTH_SHORT).show()

        // send the random number back to the calling activity
        setResult(Activity.RESULT_OK, Intent().putExtra("RANDOM_NUMBER", randomNumber))
        finish()
    }


}
