package io.nelsonkam.counter

import android.app.Application
import com.github.salomonbrys.kodein.*

/**
 * Created by nelson on 3/22/17.
 */

class App : Application(), KodeinAware {
    override val kodein by Kodein.lazy {
        bind<Store>() with singleton {
            Store(Counter(0), ::reducer)
        }
    }
}
