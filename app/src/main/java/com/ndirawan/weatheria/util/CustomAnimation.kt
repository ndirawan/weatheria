package com.ndirawan.weatheria.util

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.view.View

object CustomAnimation {
    fun fadeOut(v : View){
        val anim = ObjectAnimator.ofFloat(v, "alpha", 1f, 0f)
        anim.duration = 1000
        anim.addListener(object : AnimatorListenerAdapter(){
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                v.visibility = View.GONE
            }
        })
        anim.start()
    }
}