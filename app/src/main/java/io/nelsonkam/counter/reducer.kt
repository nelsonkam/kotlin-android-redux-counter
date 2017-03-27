package io.nelsonkam.counter

/**
 * Created by nelson on 3/27/17.
 */

fun reducer(state: Counter, action: Action): Counter = when (action.type) {
    INCREMENT -> state.copy(count = state.count + 1)
    DECREMENT -> state.copy(count = state.count - 1)
    else -> state
}