package edu.temple.inclassactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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

        // Attach an instance of ImageDisplayFragment using factory method
        if(supportFragmentManager.findFragmentById(R.id.imageFragmentContainer) !is ImageDisplayFragment)
            supportFragmentManager
                .beginTransaction()
                .add(R.id.imageFragmentContainer, ImageDisplayFragment())
                .addToBackStack(null)
                .commit()
    }

    override fun imageSelected(itemId: Int){
        Toast.makeText(this, "You selected $itemId", Toast.LENGTH_SHORT).show()
    }
}