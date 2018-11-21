package br.com.rhfa.desafio.zupmovies.views.fragments


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import br.com.rhfa.desafio.zupmovies.mvp.base.BasePresenter
import br.com.rhfa.desafio.zupmovies.mvp.base.BaseView
import br.com.rhfa.desafio.zupmovies.mvp.base.BaseViewFragment

abstract class BaseFragments<T : BasePresenter> : Fragment(), BaseViewFragment {

    abstract fun layoutId(): Int

    var presenter: T? = null
        private set

    lateinit var mView: View

    protected val activityBase: BaseView?
        get() = activity as BaseView?

    protected abstract fun newPresenter(): T

    internal abstract fun myOnCreate(view: View, savedInstanceState: Bundle?)

    internal abstract fun myOnViewCreate(view: View, savedInstanceState: Bundle?)

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        mView = inflater.inflate(layoutId(),
                container, false)

        presenter = newPresenter()

        presenter!!.setView(this)
        myOnCreate(mView, savedInstanceState)

        return mView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myOnViewCreate(view, savedInstanceState)

    }

    fun findViewById(resourceId: Int): View {
        return mView.findViewById(resourceId)
    }

    override fun showProgressBar(visibilidade: Int) {

    }

    override fun runOnUiThread(action: Runnable) {
        if (activityBase != null) {
            activityBase!!.runOnUiThread(action)
        }
    }

    override fun gotoNextScreen(cls: Class<*>) {
        val intent = Intent(activity, cls)
        startActivity(intent)
    }

    override fun gotoNextScreen(cls: Class<*>, requestCode: Int) {
        val intent = Intent(activity, cls)
        startActivityForResult(intent, requestCode)
    }

    override fun gotoNextScreen(cls: Class<*>, dataBundle: String, keyBundle: String) {
        val intent = Intent(activity, cls)
        val bundle = Bundle()
        bundle.putString(keyBundle, dataBundle)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    override fun gotoNextScreen(cls: Class<*>, bundle: Bundle) {
        val intent = Intent(activity, cls)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    override fun gotoNextScreen(cls: Class<*>, bundle: Bundle, requestCode: Int) {
        val intent = Intent(activity, cls)
        intent.putExtras(bundle)
        activity!!.startActivityForResult(intent, requestCode)
    }

    override fun getFragment(): BaseViewFragment? {
        return null
    }

    override fun showToast(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }
}
