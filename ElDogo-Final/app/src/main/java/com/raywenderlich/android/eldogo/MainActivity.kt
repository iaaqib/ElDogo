package com.raywenderlich.android.eldogo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity(), DogListFragment.OnDogSelected {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.root_layout, DogListFragment.newInstance(), "dogList")
                .commit()
        }
    }

    override fun onDogSelected(dogModel: DogModel) {
        val detailsFragment =
            DogDetailsFragment.newInstance(dogModel)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.root_layout, detailsFragment, "dogDetails")
            .addToBackStack(null)
            .commit()
    }

}
