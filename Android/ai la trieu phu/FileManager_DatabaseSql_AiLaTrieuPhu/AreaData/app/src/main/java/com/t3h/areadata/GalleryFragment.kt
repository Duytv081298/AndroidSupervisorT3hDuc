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

class GalleryFragment : Fragment(), ImageAdapter.IImageAdapter {
    private lateinit var binding: FragmentGalleryBinding
    private lateinit var paths: MutableList<String>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGalleryBinding.inflate(inflater, container, false)
//        val paths = getDatas()
        binding.rcImage.layoutManager =
            GridLayoutManager(context, 3)
        getDatas()
        binding.rcImage.adapter = ImageAdapter(this)

        binding.btnBack.setOnClickListener {
            this@GalleryFragment.activity!!.onBackPressed()
        }
        return binding.root
    }

    private fun getDatas(): MutableList<String> {
        paths = mutableListOf()
        val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val cusor =
            context!!.contentResolver.query(
                uri,
                arrayOf("_id, _data"), null, null, null
            )
        cusor!!.moveToFirst()
        while (!cusor.isAfterLast) {
            val path = cusor.getString(
                cusor.getColumnIndex("_data")
            )
            val id = cusor.getInt(
                cusor.getColumnIndex("_id")
            )

            paths.add(path)
            cusor.moveToNext()
        }
        cusor.close()
        return paths
    }

    override fun onClick(position: Int, v:View) {
        (activity as ContainActivity).openImageDetailFragment(
            paths[position], this,v
        )
    }

    override fun getItem(position: Int): String {
        return paths[position]
    }

    override fun size()=paths.size
}