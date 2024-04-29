 package za.ac.iie.tamagotchiapp

 import android.annotation.SuppressLint
 import android.os.Bundle
 import android.widget.Button
 import android.widget.ImageView
 import android.widget.TextView
 import androidx.appcompat.app.AppCompatActivity

 class GameActivity : AppCompatActivity() {

     private lateinit var petImage: ImageView
     private lateinit var healthTextView: TextView
     private lateinit var hungerTextView: TextView
     private lateinit var cleanlinessTextView: TextView
     private lateinit var messageTextView: TextView

     private var petHealth = 0
     private var petHunger = 100
     private var petCleanliness = 0

     @SuppressLint("MissingInflatedId")
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_game)

         petImage = findViewById(R.id.pet_image)

         healthTextView = findViewById(R.id.healthTextView)
         hungerTextView = findViewById(R.id.hungerTextView)
         cleanlinessTextView = findViewById(R.id.cleanlinessTextView)
         messageTextView = findViewById(R.id.messageTextView)

         val feedButton = findViewById<Button>(R.id.feedButton)
         val cleanButton = findViewById<Button>(R.id.cleanButton)
         val playButton = findViewById<Button>(R.id.playButton)
         val imageView3 : ImageView = findViewById<ImageView>(R.id.imageView3)
         val imageView2 : ImageView = findViewById<ImageView>(R.id.imageView2)
         updateStatus()

         feedButton.setOnClickListener {
             // Change pet image to feeding action
             // Update pet status values
             petImage.setImageResource(R.drawable.feeding)
             petHunger -= 10
             if (petHunger < 0) petHunger = 0
             if (petHunger == 0)
                 displayMessage("Your are PAW-SOME!")
             updateStatus()
         }

         cleanButton.setOnClickListener {
             // Change pet image to cleaning action
             // Update pet status values
             petImage.setImageResource(R.drawable.clean)
             petCleanliness += 10
             if (petCleanliness > 100) petCleanliness = 100
             if (petCleanliness == 100)
                 displayMessage("I WOOF you!")
             updateStatus()
         }

         playButton.setOnClickListener {
             // Change pet image to playing action
             // Update pet status values
             petImage.setImageResource(R.drawable.play)
             petHealth += 10
             if (petHealth > 100) petHealth = 100
             if (petHealth == 100)
                 displayMessage("You are my BEST FUR-REND!")
             updateStatus()
         }
     }

     private fun updateStatus() {
         healthTextView.text = "Health: $petHealth"
         hungerTextView.text = "Hunger: $petHunger"
         cleanlinessTextView.text = "Cleanliness: $petCleanliness"
     }

     private fun displayMessage(message: String) {
         messageTextView.text = message
     }
 }
