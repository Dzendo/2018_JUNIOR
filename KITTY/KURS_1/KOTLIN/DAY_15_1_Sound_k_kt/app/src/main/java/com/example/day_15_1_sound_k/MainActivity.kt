package com.example.day_15_1_sound_k

import android.content.res.AssetFileDescriptor
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.media.SoundPool
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast

import java.io.IOException

import androidx.appcompat.app.AppCompatActivity
import com.example.day_15_1_sound_k.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var variant: Int = 1
    private lateinit var mSoundPool: SoundPool
    private var mediaPlayer: MediaPlayer? = null
    private var mStreamID: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Весь кусок инициализации звуков вынесен в onResume чтобы освобождать его в onPause

        // Вариант звука на корову: нажать на картину и мычит пока держишь
        /*binding.imageButtonCow.setOnTouchListener { v, event ->
          val resId = loadAssets("Cow.mp3")
          Thread.sleep(1000)
          when (event.action) {
              MotionEvent.ACTION_UP     -> if (mStreamID > 0) mSoundPool.stop(mStreamID)
              MotionEvent.ACTION_DOWN   -> mStreamID = playSoundPool(resId)
              MotionEvent.ACTION_CANCEL -> mSoundPool.stop(mStreamID)
          }
           true
        }*/
    }


    @ExperimentalStdlibApi
    fun onClick(view: View) = playSound(view.tag.toString())

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
    }

    override fun onPause() {
        super.onPause()
        mSoundPool.release()
        //mSoundPool = null
    }
    @ExperimentalStdlibApi
    private fun playSound(fileName: String) {
        when(variant) {
            1 -> {
                if (mStreamID > 0) mSoundPool.stop(mStreamID)
                val resId = loadAssets(fileName)
                Thread.sleep(1000)  // костыль
                playSoundPool(resId)
            }
            2 -> {
                val resId = loadRow(fileName)
                playMediaPlayer(resId)
            }
        }
    }
    private fun playSoundPool(sound: Int): Int {
        if (sound > 0) {
            mStreamID = mSoundPool.play(sound, 1f, 1f, 1, 0, 1f)
        }
        return mStreamID
    }
    private fun loadAssets(fileName: String): Int {
        val afd: AssetFileDescriptor
        try {
            afd = assets.openFd(fileName)
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(applicationContext, "Не могу загрузить файл $fileName",
                Toast.LENGTH_SHORT).show()
            return -1
        }
        return mSoundPool.load(afd, 1)
    }

    private fun playMediaPlayer(sound: Int): Int {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = MediaPlayer.create(applicationContext, sound)
        mediaPlayer?.start()
        return 1
    }
    @ExperimentalStdlibApi
    private fun loadRow(fileName: String): Int =
        resources.getIdentifier(
            fileName.lowercase().substringBefore('.'),
            "raw", applicationContext.packageName
        )

    fun onClickVariant(view:View){
        variant = when (view){
            binding.SoundPool -> 1
            binding.MediaPlayer -> 2
            else -> 0
        }
    }

    fun playMediaPlayerAsset(view: View) {   // работает странно - проигрывает всe .ogg а не mp3
        mediaPlayer?.stop()
        mediaPlayer?.release()
        val afd = applicationContext.assets.openFd("t_chicken.mp3") //as AssetFileDescriptor
        mediaPlayer = MediaPlayer()
        mediaPlayer?.setDataSource(afd.fileDescriptor)
        mediaPlayer?.isLooping = true // Set looping
        mediaPlayer?.setVolume(100f, 100f)
        mediaPlayer?.setAudioAttributes(
            AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build()
        )
        mediaPlayer?.prepare()
        mediaPlayer?.start()
    }

    fun onClickURI(view:View) {  // работает MediaPlayer: Couldn't open и играет
        mediaPlayer?.stop()
        mediaPlayer?.release()
        val uri: Uri =
            Uri.parse("https://firebasestorage.googleapis.com/v0/b/nmixer-97a91.appspot.com/o/musics%2FDark%20World.mp3?alt=media&token=f8564ca6-cf59-468d-bd98-13ff646a1752")
            //Uri.parse("https://d2fmfepycn0xw0.cloudfront.net/?gender=male&accent=british&text=chair")
            mediaPlayer = MediaPlayer.create(this, uri)
         /*   mediaPlayer?.setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build()
            )*/
        mediaPlayer?.start()
    }
    fun onClickHTTP(view:View) {  // работает Виноградов
        mediaPlayer?.stop()
        //val http = "https://firebasestorage.googleapis.com/v0/b/nmixer-97a91.appspot.com/o/musics%2FDark%20World.mp3?alt=media&token=f8564ca6-cf59-468d-bd98-13ff646a1752"
        //val http = "https://d2fmfepycn0xw0.cloudfront.net/?gender=male&accent=british&text=chair"
        val http = "https://d2fmfepycn0xw0.cloudfront.net?gender=male&accent=british&text=a+separate+seat+for+one+person+with+four+legs+and+a+support+for+the+back"
        mediaPlayer = MediaPlayer()
        mediaPlayer?.setDataSource(http)
        mediaPlayer?.setAudioAttributes(
            AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build()
        )
        //mediaPlayer.setOnPreparedListener(this)
        mediaPlayer?.prepare()
        //mediaPlayer?.prepareAsync()
        mediaPlayer?.start()
    }
}



