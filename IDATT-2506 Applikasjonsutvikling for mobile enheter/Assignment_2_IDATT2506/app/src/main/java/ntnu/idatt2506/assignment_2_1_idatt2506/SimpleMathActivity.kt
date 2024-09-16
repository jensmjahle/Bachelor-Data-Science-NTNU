package ntnu.idatt2506.assignment_2_1_idatt2506

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.StringRes

class SimpleMathActivity : Activity() {
    private lateinit var numberOneTextView: TextView
    private lateinit var numberTwoTextView: TextView
    private lateinit var answerEditText: EditText
    private lateinit var upperLimitEditText: EditText

    private var numberOne: Int? = null
    private var numberTwo: Int? = null

    private val REQUEST_CODE_RANDOM_NUMBER_ONE = 1
    private val REQUEST_CODE_RANDOM_NUMBER_TWO = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_math)

        numberOneTextView = findViewById(R.id.numberOneTextView)
        numberTwoTextView = findViewById(R.id.numberTwoTextView)
        answerEditText = findViewById(R.id.userAnswerInput)
        upperLimitEditText = findViewById(R.id.upperLimitInput)

        val goBackButton = findViewById<Button>(R.id.goBackButton)
        val addButton = findViewById<Button>(R.id.addButton)
        val multiplyButton = findViewById<Button>(R.id.multiplyButton)


        numberOneTextView.text

        goBackButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        addButton.setOnClickListener{
            add()
            startRandomNumberActivity()
        }
        multiplyButton.setOnClickListener{
            multiply()
            startRandomNumberActivity()
        }

        // Initialize the numbers on activity creation
        startRandomNumberActivity()

    }

    private fun startRandomNumberActivity() {
        val maxLimit = upperLimitEditText.text.toString().toIntOrNull() ?: 10

        // Start RandomNumberActivity to get the first number
        val intentOne = Intent(this, RandomNumberActivity::class.java).apply {
            putExtra("MAX_LIMIT", maxLimit)
        }
        startActivityForResult(intentOne, REQUEST_CODE_RANDOM_NUMBER_ONE)
    }
    private fun startSecondRandomNumberActivity() {
        val maxLimit = upperLimitEditText.text.toString().toIntOrNull() ?: 10

        // Start RandomNumberActivity to get the second number
        val intentTwo = Intent(this, RandomNumberActivity::class.java).apply {
            putExtra("MAX_LIMIT", maxLimit)
        }
        startActivityForResult(intentTwo, REQUEST_CODE_RANDOM_NUMBER_TWO)
    }


    private fun add(){
        val numberOne = numberOneTextView.text.toString().toIntOrNull()
        val numberTwo = numberTwoTextView.text.toString().toIntOrNull()
        if (numberOne == null || numberTwo == null) {
            Log.d("SimpleMathActivity", "Invalid input")
            return
        }
        val answer = numberOne + numberTwo
        val userAnswer = answerEditText.text.toString().toIntOrNull()
        if (userAnswer == null) {
            Log.d("SimpleMathActivity", "Invalid input")
            return
        }
        if (answer == userAnswer) {
            Toast.makeText(this, R.string.correct, Toast.LENGTH_SHORT).show()
            return
        }
        Toast.makeText(this, getString(R.string.wrong) + " " + answer, Toast.LENGTH_SHORT).show()

        return
    }
    private fun multiply(){
        val numberOne = numberOneTextView.text.toString().toIntOrNull()
        val numberTwo = numberTwoTextView.text.toString().toIntOrNull()
        if (numberOne == null || numberTwo == null) {
            Log.d("SimpleMathActivity", "Invalid input")
            return
        }
        val answer = numberOne * numberTwo
        val userAnswer = answerEditText.text.toString().toIntOrNull()
        if (userAnswer == null) {
            Log.d("SimpleMathActivity", "Invalid input")
            return
        }
        if (answer == userAnswer) {
            Toast.makeText(this, R.string.correct, Toast.LENGTH_SHORT).show()
            return
        }
        Toast.makeText(this, getString(R.string.wrong) + " " + answer, Toast.LENGTH_SHORT).show()

        return
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK) {
            val randomNumber = data?.getIntExtra("RANDOM_NUMBER", 0) ?: 0

            when (requestCode) {
                REQUEST_CODE_RANDOM_NUMBER_ONE -> {
                    numberOne = randomNumber
                    numberOneTextView.text = randomNumber.toString()
                    startSecondRandomNumberActivity() // Start the second request after receiving the first
                }
                REQUEST_CODE_RANDOM_NUMBER_TWO -> {
                    numberTwo = randomNumber
                    numberTwoTextView.text = randomNumber.toString()
                }
            }
        } else {
            Log.e("SimpleMathActivity", "Unexpected result code: $resultCode")
        }
    }
}
