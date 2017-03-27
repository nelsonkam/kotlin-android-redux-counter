package io.nelsonkam.counter

import android.app.Activity
import android.widget.Button
import android.widget.TextView
import org.jetbrains.anko.find
import org.jetbrains.anko.onClick

/**
 * Created by nelson on 3/22/17.
 */
class CounterView(private val ctx: Activity, private val store: Store) {
    private val btnIncrement: Button = ctx.find(R.id.btn_increment)
    private val btnDecrement: Button = ctx.find(R.id.btn_decrement)
    private val counter: TextView = ctx.find(R.id.counter)
    fun render() {
        val state = store.getState()
        btnIncrement.onClick { store.dispatch(Action(INCREMENT)) }
        btnDecrement.onClick { store.dispatch(Action(DECREMENT)) }
        counter.text = state.count.toString()
    }
}