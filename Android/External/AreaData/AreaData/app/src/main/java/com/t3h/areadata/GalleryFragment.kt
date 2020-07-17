package com.t3h.areadata

import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.t3h.areadata.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {
    private lateinit var binding: FragmentGalleryBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGalleryBinding.inflate(inflater, container, false)
//        val paths = getDatas()
        binding.rcImage.layoutManager =
            GridLayoutManager(context, 3)
        binding.rcImage.adapter = ImageAdapter(getDatas())

        binding.btnBack.setOnClickListener{
            this@GalleryFragment.activity!!.onBackPressed()
        }
        return binding.root
    }

    private fun getDatas(): MutableList<String> {
        val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val cusor =
            context!!.contentResolver.query(
                uri,
                arrayOf("_id, _data"), null, null, null
            )
        cusor!!.moveToFirst()
        val paths = mutableListOf<String>()
        while (!cusor.isAfterLast) {
            val path = cusor.getString(
                cusor.getColumnIndex("_data")
            )
            paths.add(path)
        }
        cusor.close()
        return paths
    }
}