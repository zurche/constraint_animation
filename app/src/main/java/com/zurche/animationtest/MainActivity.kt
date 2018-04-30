package com.zurche.animationtest


import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.v7.app.AppCompatActivity
import android.transition.TransitionManager
import android.widget.ImageView
import kotlinx.android.synthetic.main.poster_expanded.*

class MainActivity : AppCompatActivity() {

    private var set: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.poster_expanded)

        val constraintSet = ConstraintSet()
        constraintSet.clone(root_main)
        val constraintSetTwo = ConstraintSet()
        constraintSetTwo.load(this, R.layout.poster_description)

        findViewById<ImageView>(R.id.movie_poster).setOnClickListener {
            TransitionManager.beginDelayedTransition(root_main)
            val constraint = if (set) constraintSet else constraintSetTwo
            constraint.applyTo(root_main)
            set = !set
        }
    }
}

