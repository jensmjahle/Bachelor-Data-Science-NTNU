package ntnu.idatt2506.assignment_5_idatt2506

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.json.JSONArray


const val URL = "https://bigdata.idi.ntnu.no/mobil/tallspill.jsp"
class MainActivity : ComponentActivity() {
    private val network: HttpWrapper = HttpWrapper(URL)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<Button>(R.id.startButton)
        val name = findViewById<TextView>(R.id.nameInput)
        val cardNumber = findViewById<TextView>(R.id.cardNumberInput)
        val replyText = findViewById<TextView>(R.id.replyText)
        val submitButton = findViewById<Button>(R.id.submitButton)
        val resetButton = findViewById<Button>(R.id.resetButton)
        val guessedNumber = findViewById<TextView>(R.id.guessedNumberInput)

        startButton.setOnClickListener {
            if (name.text.isNotEmpty() && cardNumber.text.isNotEmpty()) {
                val parameterList = mapOf(
                    "navn" to name.text.toString(),
                    "kortnummer" to cardNumber.text.toString()
                )
                name.visibility= View.GONE
                cardNumber.visibility= View.GONE
                startButton.visibility= View.GONE
                replyText.visibility= View.VISIBLE
                submitButton.visibility= View.VISIBLE
                resetButton.visibility= View.VISIBLE
                guessedNumber.visibility= View.VISIBLE
                performRequest(HTTP.GET, parameterList)
            } else {
                Log.e("onCreate()", "name or cardNumber is empty")
                setResult("name or cardNumber is empty")
            }
        }
        submitButton.setOnClickListener {
            if (guessedNumber.text.isNotEmpty()) {
                val text = guessedNumber.text.toString()
                Log.i("onCreate()", guessedNumber.text.toString())
                val parameterList = mapOf(
                    "tall" to guessedNumber.text.toString()
                )
                Log.i("onCreate()", "guessedNumber is $text")
                performRequest(HTTP.GET, parameterList)
            } else {
                Log.e("onCreate()", "guessedNumber is empty")
                setResult("guessedNumber is empty")
            }
        }
        resetButton.setOnClickListener {
            replyText.text = ""
            guessedNumber.text = ""
            name.visibility= View.VISIBLE
            cardNumber.visibility= View.VISIBLE
            startButton.visibility= View.VISIBLE
            replyText.visibility= View.GONE
            submitButton.visibility= View.GONE
            resetButton.visibility= View.GONE
            guessedNumber.visibility= View.GONE
        }
    }

    private fun performRequest(typeOfRequest: HTTP, parameterList: Map<String, String>) {
        Log.i("performRequest()", "typeOfRequest: $typeOfRequest")
        Log.i("performRequest()", "parameterList: $parameterList")

        CoroutineScope(IO).launch {
            val response: String = try {
                when (typeOfRequest) {
                    HTTP.GET -> network.get(parameterList)
                    HTTP.POST -> network.post(parameterList)
                    HTTP.GET_WITH_HEADER -> network.getWithHeader(parameterList)
                }
            } catch (e: Exception) {
                Log.e("performRequest()", e.message!!)
                e.toString()
            }

            // Endre UI på hovedtråden
            MainScope().launch {
                setResult(response)
            }
        }
    }

    /**
     * Show result from server in UI
     */
    private fun setResult(response: String?) {
        findViewById<TextView>(R.id.replyText).text = response
        findViewById<EditText>(R.id.guessedNumberInput).text.clear()
        Log.i("setResult()", response!!)
    }
}

