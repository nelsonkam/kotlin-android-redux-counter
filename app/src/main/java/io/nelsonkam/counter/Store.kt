package io.nelsonkam.counter

/**
 * Created by nelson on 3/22/17.
 */

class Store(private var state: Counter, private val reducer: (Counter, Action) -> Counter) {
    private val listeners: ArrayList<() -> Unit> = arrayListOf()


    fun getState(): Counter = state

    // Store's dispatcher
    fun dispatch(action: Action): Action {
        this.state = reducer(state, action)
        listeners.forEach { it() }
        return action
    }

    fun subscribe(listener: () -> Unit): () -> Unit {
        listeners.add(listener)
        return {
            listeners.remove(listener)
        }
    }
}



