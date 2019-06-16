package com.shaadi.exercise.features.shaadimatches.ui

import com.shaadi.exercise.R
import com.shaadi.exercise.core.extension.loadFromUrl
import com.shaadi.exercise.core.viewcontainer.BaseFragment
import com.shaadi.exercise.core.views.bind
import com.shaadi.exercise.core.views.removeItemAtPosition
import com.shaadi.exercise.features.shaadimatches.data.ShaadiMatchesViewModel
import com.shaadi.exercise.features.shaadimatches.data.dagger.inject
import jp.wasabeef.recyclerview.animators.SlideInRightAnimator
import kotlinx.android.synthetic.main.layout_no_data.view.*
import kotlinx.android.synthetic.main.layout_shaadi_matches.view.*
import kotlinx.android.synthetic.main.view_item_shaadi_matches.view.*
import javax.inject.Inject


/**
 * Created by Suyash Chavan.
 */
class ShaadiMatchesFragment : BaseFragment() {

    override fun layoutId(): Int = R.layout.layout_shaadi_matches

    @Inject
    lateinit var shaadiMatchesViewModel: ShaadiMatchesViewModel

    override fun prepareMandatoryInstances() = inject()

    override fun assignListener() {

    }

    override fun loadData() {
        shaadiMatchesViewModel.getShaadiMatches(
            onResult = {
                dismissProgress()

                val shaadiMatches= it.toMutableList()
                root.recycler_view.bind(shaadiMatches, singleLayout = R.layout.view_item_shaadi_matches){user, pos ->
                    this.image_profile_pic.loadFromUrl(user.picture.medium, isCircular = true)

                    val name = "${user.name.first} ${user.name.last.substring(0,1)}"
                    this.name.text = name

                    val description = resources.getString(
                        R.string.description,
                        user.dob.age.toString(),
                        user.location.city,
                        user.location.state,
                        user.location.postcode,
                        user.cell
                    )
                    this.description.text = description

                    this.decline.setOnClickListener {
                        root.recycler_view.removeItemAtPosition(shaadiMatches.indexOf(user))
                        shaadiMatches.remove(user)
                    }
                }
            },
            onError = {
                dismissProgress()
                showErrorScreen(R.layout.layout_no_data)

                root.retry.setOnClickListener {
                    showProgress()
                    loadData()
                }
            }
        )
        root.recycler_view.itemAnimator = SlideInRightAnimator()
    }
}