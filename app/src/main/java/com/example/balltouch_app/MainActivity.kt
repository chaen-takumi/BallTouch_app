package com.example.balltouch_app

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        //2)新しいクラス
        val ballView = BallView(this)
        setContentView(ballView)
    }

    //1)Viewを継承したクラス
    class BallView(context: Context?) : View(context) {
        private var paint: Paint = Paint()
        private var circlesX: Float = 200F
        private var circlesY: Float = 200F

        //3)OnDrawでの描写準備
        override fun onDraw(canvas: Canvas?) {
            super.onDraw(canvas)

            canvas?.drawColor(Color.RED)//キャンバスの色

            //4)ペイントする色と図形の指定
            paint.color = Color.YELLOW
            canvas?.drawCircle(circlesX, circlesY, 50F, paint)


        }

        override fun onTouchEvent(event: MotionEvent?): Boolean {

            //タッチ
            circlesX = event!!.x
            circlesY = event.y
            invalidate()

            return true
        }

    }
}