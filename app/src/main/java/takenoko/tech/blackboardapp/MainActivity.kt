package takenoko.tech.blackboardapp

import android.graphics.PointF
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MotionEvent

class MainActivity : AppCompatActivity() {

    var log = "----MainActivity----"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(log, "onCreate")
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        var point: PointF = PointF(event!!.getX(), event!!.getY())
        Log.i(log, "("+ point.x +","+ point.y +")")
        return true
    }
}
