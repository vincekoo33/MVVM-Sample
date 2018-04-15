package koo.vincent.myapplication.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.animation.DynamicAnimation
import android.support.animation.FlingAnimation
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.ViewTreeObserver
import dagger.android.AndroidInjection
import koo.vincent.myapplication.R
import koo.vincent.myapplication.base.BaseActivity
import koo.vincent.myapplication.databinding.ActivityMainBinding
import koo.vincent.myapplication.di.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var maxTranslationX: Float = 0f
    private var maxTranslationY: Float = 0f

    private var gestureListener = object : GestureDetector.SimpleOnGestureListener() {

        override fun onDown(e: MotionEvent?): Boolean {
            return true
        }

        override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
            val flingX = FlingAnimation(viewToFling, DynamicAnimation.TRANSLATION_X)
            flingX.setStartVelocity(velocityX)
                    .setMinValue(0f) // minimum translationX property
                    .setMaxValue(maxTranslationX)  // maximum translationX property
                    .setFriction(FRICTION)
                    .start()
            return true
        }
    }

    companion object {
        const val FRICTION: Float = 1.25f
    }

    override val viewModel by lazy(LazyThreadSafetyMode.NONE) {
        ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
    }


    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)

        constraintLayout.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                maxTranslationX = (constraintLayout.width - viewToFling.width).toFloat()
                maxTranslationY = (constraintLayout.height - viewToFling.height).toFloat()

                //As only wanted the first call back, so now remove the listener
                constraintLayout.viewTreeObserver.removeOnGlobalLayoutListener(this)
            }
        })

        val gestureDetector = GestureDetector(this, gestureListener)
        viewToFling.setOnTouchListener { _, event -> gestureDetector.onTouchEvent(event) }
    }
}
