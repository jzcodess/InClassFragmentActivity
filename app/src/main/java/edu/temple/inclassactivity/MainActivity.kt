package edu.temple.inclassactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        // Fetch images into IntArray called imageArray
        val typedArray = resources.obtainTypedArray(R.array.image_ids)
        val imageArray = IntArray(typedArray.length()) {typedArray.getResourceId(it, 0)}
        typedArray.recycle()

        mainViewModel.setImageIds(imageArray)

        val imageArray1 = ImageDisplayFragment.newInstance(imageArray)

        // Attach an instance of ImageDisplayFragment using factory method
        supportFragmentManager
            .beginTransaction()
            .add(R.id.imageFragmentContainer, imageArray1)
            .commit()
    }

    override fun imageSelected(itemId)
}