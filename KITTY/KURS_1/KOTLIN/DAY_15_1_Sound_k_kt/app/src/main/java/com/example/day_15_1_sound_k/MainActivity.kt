package com.example.day_15_1_sound_k

import android.content.res.AssetFileDescriptor
import android.media.AudioAttributes
import android.media.SoundPool
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Toast

import java.io.IOException

import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mSoundPool: SoundPool? = null

    private var mCatSound:      Int = 0
    private var mChickenSound:  Int = 0
    private var mCowSound:      Int = 0
    private var mDogSound:      Int = 0
    private var mDuckSound:     Int = 0
    private var mSheepSound:    Int = 0

    private var mStreamID:      Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Весь кусок инициализации звуков вынесен в onResume чтобы освобождать его в onPause

        // Вариант звука на корову: нажать на картину и мычит пока держишь
        imageButtonCow.setOnTouchListener { v, event ->
          when (event.action) {
              MotionEvent.ACTION_UP     -> if (mStreamID > 0)
                                            mSoundPool!!.stop(mStreamID)
              MotionEvent.ACTION_DOWN   -> mStreamID = playSound(mCowSound)
              MotionEvent.ACTION_CANCEL -> mSoundPool!!.stop(mStreamID)
          }
           true
        }
    }
    fun onClick(view: View) { when (view.id) {
        R.id.imageButtonCow     -> playSound(mCowSound)
        R.id.imageButtonChicken -> playSound(mChickenSound)
        R.id.imageButtonCat     -> playSound(mCatSound)
        R.id.imageButtonDuck    -> playSound(mDuckSound)
        R.id.imageButtonSheep   -> playSound(mSheepSound)
        R.id.imageButtonDog     -> playSound(mDogSound)
    }}

     private fun playSound(sound: Int): Int {
        if (sound > 0) {
            mStreamID = mSoundPool!!.play(sound, 1f, 1f, 1, 0, 1f)
        }
        return mStreamID
    }
     private fun loadSound(fileName: String): Int {
        val afd: AssetFileDescriptor
        try {
            afd = assets!!.openFd(fileName)
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(applicationContext, "Не могу загрузить файл $fileName",
                    Toast.LENGTH_SHORT).show()
            return -1
        }
        return mSoundPool!!.load(afd, 1)
    }

    override fun onResume() {
        super.onResume()
    //  Нам надо создать объект SoundPool, загрузить в него аудио-файлы из папки assets методом load().

        val attributes = AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build()
        mSoundPool = SoundPool.Builder()
                .setAudioAttributes(attributes)
                .build()

        // получим идентификаторы
        mCatSound   = loadSound("cat.ogg")
        mChickenSound = loadSound("t_chicken.mp3")
        mCowSound   = loadSound("Cow.mp3")
        mDogSound   = loadSound("dog.ogg")
        mDuckSound  = loadSound("duck.ogg")
        mSheepSound = loadSound("sheep.ogg")
    }

    override fun onPause() {
        super.onPause()
        mSoundPool!!.release()
        mSoundPool = null
    }
}



