package org.senac.gabrielkraetzer.jogodados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var img : ImageView
    private lateinit var bt : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.img = findViewById(R.id.image)
        img.setImageResource(R.drawable.empty_dice)

        this.bt = findViewById(R.id.btPlay)
        this.bt.setOnClickListener(){
            var index = Random.nextInt(1,6)
            img.setImageResource(returnImage(index - 1))
            Toast.makeText(this,"${index}",Toast.LENGTH_LONG).show()
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        //outPersistentState.put(TAG, valor)?:
    }

    private fun returnImage(index : Int): Int {
        var range = listOf<Int>(
            R.drawable.dice_1,
            R.drawable.dice_2,
            R.drawable.dice_3,
            R.drawable.dice_4,
            R.drawable.dice_5,
            R.drawable.dice_6)
        return range.get(index)
    }
}
