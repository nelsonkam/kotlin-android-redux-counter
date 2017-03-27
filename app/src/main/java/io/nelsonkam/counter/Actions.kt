package io.nelsonkam.counter

/**
 * Created by nelson on 3/27/17.
 */

// Action types...
const val INCREMENT = "INCREMENT"
const val DECREMENT = "DECREMENT"


data class Action(val type: String, val payload: Any = 0)