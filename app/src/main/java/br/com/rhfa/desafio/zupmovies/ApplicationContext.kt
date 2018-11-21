package br.com.rhfa.desafio.zupmovies

import android.app.Application
import android.content.Context

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator
import com.nostra13.universalimageloader.core.DisplayImageOptions
import com.nostra13.universalimageloader.core.ImageLoader
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration
import com.nostra13.universalimageloader.core.assist.QueueProcessingType

class ApplicationContext : Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        initImageLoader(applicationContext)
    }

    override fun onTerminate() {
        super.onTerminate()
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
    }

    companion object {
        var appContext: Context? = null
            private set

        fun initImageLoader(context: Context) {
            val opts = DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true).build()

            val config = ImageLoaderConfiguration.Builder(context)
            config.threadPriority(Thread.NORM_PRIORITY - 2)
            config.denyCacheImageMultipleSizesInMemory()
            config.diskCacheFileNameGenerator(Md5FileNameGenerator())
            config.diskCacheSize(50 * 1024 * 1024) // 50 MiB
            config.tasksProcessingOrder(QueueProcessingType.LIFO)
            config.defaultDisplayImageOptions(opts)

            ImageLoader.getInstance().init(config.build())
        }
    }
}
