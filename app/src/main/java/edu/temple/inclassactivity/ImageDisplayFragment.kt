/**
 * Please study this class, but do not modify it
 */

package edu.temple.inclassactivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.selects.select

const val IMAGES_KEY = "imageList"

class ImageDisplayFragment : Fragment() {

    private val mainViewModel : MainViewModel by lazy{
        ViewModelProvider(requireActivity())[MainViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // The inflated layout file is returned to the parent/host and displayed to the user
        return inflater.inflate(R.layout.fragment_image_display, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // The recycler view is the root element of the Fragment's layout
        // as such the view argument passed to onViewCreated() is the RecyclerView
        with(view as RecyclerView) {

            mainViewModel.getImageIds().observe(requireActivity()) {
                adapter = CustomRecyclerAdapter(it, requireActivity() as ImageSelectedInterface)
            }
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
    }
}

interface ImageSelectedInterface{
    fun imageSelected(itemId: Int)
}
