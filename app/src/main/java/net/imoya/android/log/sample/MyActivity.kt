package net.imoya.android.log.sample

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MyLog.init(this)

        MyLog.v(TAG, "onCreate: start")

        setContentView(R.layout.main_activity)

        findViewById<Button>(R.id.v).setOnClickListener { MyLog.v(TAG, "Button V is clicked") }
        findViewById<Button>(R.id.d).setOnClickListener { MyLog.d(TAG, "Button D is clicked") }
        findViewById<Button>(R.id.i).setOnClickListener { MyLog.i(TAG, "Button I is clicked") }
        findViewById<Button>(R.id.w).setOnClickListener { MyLog.w(TAG, "Button W is clicked") }
        findViewById<Button>(R.id.e).setOnClickListener { MyLog.e(TAG, "Button E is clicked") }

        MyLog.v(TAG, "onCreate: end")
    }

    companion object {
        /**
         * Tag for log
         */
        const val TAG = "MainActivity"
    }
}