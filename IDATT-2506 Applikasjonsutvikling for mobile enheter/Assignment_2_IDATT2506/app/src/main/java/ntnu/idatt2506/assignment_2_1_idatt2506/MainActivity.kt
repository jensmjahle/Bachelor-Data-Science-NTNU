package ntnu.idatt2506.assignment_2_1_idatt2506

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : Activity() {
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)

       resultTextView = findViewById(R.id.resultTextView)

       val startButton : Button = findViewById(R.id.startButton)
        val simpleMathButton : Button = findViewById(R.id.simpleMathButton)

        //Starts the RandomNumberActivity when the button is clicked
       startButton.setOnClickListener {
           val intent = Intent(this, RandomNumberActivity::class.java)
           intent.putExtra("MAX_LIMIT", 100)
           startActivityForResult(intent, 1)
       }

       simpleMathButton.setOnClickListener {
           val intent = Intent(this, SimpleMathActivity::class.java)
           startActivity(intent)
       }

    }

    @SuppressLint("SetTextI18n")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == RESULT_OK) {
            //Retrieves the random number from the Intent and displays it in the resultTextView
            val randomNumber = data?.getIntExtra("RANDOM_NUMBER", 0)
            resultTextView.text = "Random Number: $randomNumber"
        } else {
            Log.e("MainActivity", "Unexpected result code: $resultCode")
        }
    }

}
