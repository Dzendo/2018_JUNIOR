package com.example.day_17_1_anime

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils.loadAnimation
import kotlinx.android.synthetic.main.activity_main.*
import com.example.day_17_1_anime.R.anim.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sun.startAnimation(loadAnimation(this,sun_rise))
        clock.startAnimation(loadAnimation(this, clock_turn))
        hour_hand.startAnimation(loadAnimation(this, hour_turn))


        /*    // Анимация для восхода солнца sun
           sun.startAnimation(loadAnimation(this,sun_rise))
           // анимация для вращения часов clock
           val clockTurnAnimation = loadAnimation(this, clock_turn)
           clock.startAnimation(clockTurnAnimation)
           // анимация для часовую стрелки
           val hourTurnAnimation = AnimationUtils.loadAnimation(this, R.anim.hour_turn)
           // присоединяем анимацию к часовую стрелки
           hour_hand.startAnimation(hourTurnAnimation)
          */

        // А так не двигается почему-то задать вопрос Kitty
        fun Anime (v: View, id:Int)= {v.startAnimation(loadAnimation(this,id))}
        Anime (sun,sun_rise)
        Anime (hour_hand,hour_turn)
        Anime (hour_hand,hour_turn)

    }
}
