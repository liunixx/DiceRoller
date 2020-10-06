package tw.khliu.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var dice_image:ImageView
    lateinit var dice_image2:ImageView
    lateinit var roll_button:Button
    lateinit var reset_button:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.initVar()
        roll_button.setOnClickListener { rollDice() }
        reset_button.setOnClickListener { reset() }
        /*
        countup_button.setOnClickListener { countUp() }
        reset_button.setOnClickListener { reset() }
        */
    }

    private fun initVar() {
        roll_button = findViewById(R.id.roll_button)
        dice_image = findViewById(R.id.dice_image)
        dice_image2=findViewById(R.id.dice_image2)
        reset_button=findViewById(R.id.reset_button)
    }


    private fun rollDice(){
        // Toast.makeText(this,"button clicked",Toast.LENGTH_SHORT).show()
        //val resultText:TextView=findViewById(R.id.result_text)
        //
        // resultText.text=rendomInt.toString()
        dice_image.setImageResource(getRandomDiceImage())
        dice_image2.setImageResource(getRandomDiceImage())
    }

    private fun getRandomDiceImage() : Int {
           val randomInt=(1..6).random()
           val imgSrc = when(randomInt) {
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            6->R.drawable.dice_6
               else->R.drawable.empty_dice
          }
         return imgSrc
    }

      /*
    private fun countUp() {
        val result =  result_text.text.toString()
        if(result.equals(resources.getString(R.string.init_text))) {
            result_text.text="1"
        } else  {
            var num = result.toInt()
            if(num>=6)  num=6
            else num+=1
            result_text.text=""+num
        }
    }
   */
    private fun reset() {
            dice_image.setImageResource(R.drawable.empty_dice)
            dice_image2.setImageResource(R.drawable.empty_dice)
    }

}