package io.nelsonkam.counter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.android.appKodein
import com.github.salomonbrys.kodein.instance

class MainActivity : AppCompatActivity() {
    private val injector = KodeinInjector()
    val store: Store by injector.instance()
    lateinit var unsubscribe: () -> Unit
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injector.inject(appKodein())

        // View setup
        val view = CounterView(this, store)
        view.render()
        unsubscribe = store.subscribe(view::render)

        // Middleware actions related to activity's creation
    }

    override fun onDestroy() {
        super.onDestroy()
        unsubscribe()
    }
}
