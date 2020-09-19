package com.company.rollthedice

import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.random.Random

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    var randomNumber: Int = 0
    var player1Score: Int = 0
    var player2Score: Int = 0
    var activePlayerA: Boolean = true
    var activePlayerB: Boolean = false
    var gamePoint: Int = 20
    var x: Int = 1



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewGamePoint.text = gamePoint.toString()

        imageView.setOnClickListener {

            randomNumber = (1..6).random()

            val timer = object : CountDownTimer(600, 100) {
                override fun onTick(millisUntilFinished: Long) {
                    // do something
                    when (x) {
                        1 -> {
                            imageView.setImageResource(R.drawable.a)
                        }
                        2 -> {
                            imageView.setImageResource(R.drawable.b)
                        }
                        3 -> {
                            imageView.setImageResource(R.drawable.c)
                        }
                        4 -> {
                            imageView.setImageResource(R.drawable.d)
                        }
                        5 -> {
                            imageView.setImageResource(R.drawable.e)
                        }
                        6 -> {
                            imageView.setImageResource(R.drawable.f)
                        }
                    }
                    x++
                }

                override fun onFinish() {
                    // do something
                    x = 1
                    when (randomNumber) {
                        1 -> {
                            imageView.setImageResource(R.drawable.a)
                        }
                        2 -> {
                            imageView.setImageResource(R.drawable.b)
                        }
                        3 -> {
                            imageView.setImageResource(R.drawable.c)
                        }
                        4 -> {
                            imageView.setImageResource(R.drawable.d)
                        }
                        5 -> {
                            imageView.setImageResource(R.drawable.e)
                        }
                        6 -> {
                            imageView.setImageResource(R.drawable.f)
                        }
                    }
                    if (activePlayerA) {
                        player1Score += randomNumber
                        activePlayerA = false
                        activePlayerB = true
                        textViewPlayer1Point.text = player1Score.toString()

                        if (player1Score >= gamePoint) {
                            textViewWinner.text = "Player 1 is The Winner"
                            imageView.isClickable = false
                            buttonAgain.visibility = View.VISIBLE
                        }
                    } else {
                        player2Score += randomNumber
                        activePlayerA = true
                        activePlayerB = false
                        textViewPlayer2Point.text = player2Score.toString()

                        if (player2Score >= gamePoint) {
                            textViewWinner.text = "Player 2 is The Winner"
                            imageView.isClickable = false
                            buttonAgain.visibility = View.VISIBLE
                        }
                    }
                }}
                timer.start()

            }

        buttonAgain.setOnClickListener {
            imageView.isClickable = true
            player1Score = 0
            player2Score = 0
            buttonAgain.visibility = View.INVISIBLE
            textViewPlayer1Point.text = player1Score.toString()
            textViewPlayer2Point.text = player2Score.toString()
            activePlayerA = false
            activePlayerB = true
        }


}
}