package com.shaadi.exercise.core.viewcontainer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.shaadi.exercise.core.extension.ifNotInflated
import com.shaadi.exercise.databinding.FragmentToolbarBinding
import kotlinx.android.synthetic.main.fragment_toolbar.*
import kotlinx.android.synthetic.main.fragment_toolbar.view.*

/**
 * Created by Suyash Chavan.
 */
abstract class BaseFragment : Fragment() {

    val root by lazy {
        binding.root
    }
    /**
     * binding: Data binding to layout inflated by {@link layoutId()}
     * Note: Holding onto binding of layout (Fragment View) is not a memory leak
     */
    internal lateinit var binding : ViewDataBinding

    abstract fun layoutId(): Int

    abstract fun prepareMandatoryInstances()

    abstract fun loadData()

    abstract fun assignListener()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentToolbarBinding.inflate(inflater,container,false)
        inflateLayout(layoutId())
        prepareMandatoryInstances()
        loadData()
        assignListener()
        return binding.root
    }

    private fun inflateLayout(layoutRes: Int) {
        root.body_stub.layoutResource = layoutRes
        root.body_stub.inflate()
    }

    internal fun showProgress(){
        hideErrorScreen()
        progressStatus(View.VISIBLE)
    }

    internal fun dismissProgress() = progressStatus(View.GONE)

    private fun progressStatus(viewStatus: Int) =
        with(this) { this.progress?.visibility = viewStatus }

    fun showErrorScreen(layoutRes: Int) {
        root.body_container.visibility = View.GONE
        root.error_screen.ifNotInflated(
            inflate = {
                root.error_screen.layoutResource = layoutRes
                root.error_screen.inflate()
            },elseDo = {
                root.error_container.visibility = View.VISIBLE
            }
        )

    }

    private fun hideErrorScreen() {
        root.body_container.visibility = View.VISIBLE
        root.error_container.visibility = View.GONE
    }
}