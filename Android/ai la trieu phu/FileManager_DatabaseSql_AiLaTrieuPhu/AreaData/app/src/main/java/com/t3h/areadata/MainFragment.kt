package com.t3h.areadata

import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.t3h.areadata.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    private fun init() {
        binding.btnImg.text = "Image\n" + getCount()
        binding.btnImg.setOnClickListener {
            (activity as ContainActivity).openGalleryFragment()
        }
    }

    private fun getCount(): Int {
        //ten table la image
        val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val cusor =
            context!!.contentResolver.query(
                uri,
                arrayOf("count(_id) as c"), null, null, null
            )
        for (columnName in cusor!!.columnNames) {
            Log.d("MainFragment", "column name: " + columnName)
        }
        //move cusor den dau table
        cusor.moveToFirst()
        val numberCount = cusor.getInt(
            cusor.getColumnIndex("c")
        )
        cusor.close()
        return numberCount
    }

//    _id
//    2020-05-27 21:01:57.425 5453-5453/com.t3h.areadata D/MainFragment: column name: _data
//    2020-05-27 21:01:57.425 5453-5453/com.t3h.areadata D/MainFragment: column name: _size
//    2020-05-27 21:01:57.425 5453-5453/com.t3h.areadata D/MainFragment: column name: _display_name
//    2020-05-27 21:01:57.426 5453-5453/com.t3h.areadata D/MainFragment: column name: mime_type
//    2020-05-27 21:01:57.426 5453-5453/com.t3h.areadata D/MainFragment: column name: title
//    2020-05-27 21:01:57.426 5453-5453/com.t3h.areadata D/MainFragment: column name: date_added
//    2020-05-27 21:01:57.426 5453-5453/com.t3h.areadata D/MainFragment: column name: date_modified
//    2020-05-27 21:01:57.426 5453-5453/com.t3h.areadata D/MainFragment: column name: description
//    2020-05-27 21:01:57.426 5453-5453/com.t3h.areadata D/MainFragment: column name: picasa_id
//    2020-05-27 21:01:57.426 5453-5453/com.t3h.areadata D/MainFragment: column name: isprivate
//    2020-05-27 21:01:57.426 5453-5453/com.t3h.areadata D/MainFragment: column name: latitude
//    2020-05-27 21:01:57.426 5453-5453/com.t3h.areadata D/MainFragment: column name: longitude
//    2020-05-27 21:01:57.426 5453-5453/com.t3h.areadata D/MainFragment: column name: datetaken
//    2020-05-27 21:01:57.426 5453-5453/com.t3h.areadata D/MainFragment: column name: orientation
//    2020-05-27 21:01:57.426 5453-5453/com.t3h.areadata D/MainFragment: column name: mini_thumb_magic
//    2020-05-27 21:01:57.426 5453-5453/com.t3h.areadata D/MainFragment: column name: bucket_id
//    2020-05-27 21:01:57.426 5453-5453/com.t3h.areadata D/MainFragment: column name: bucket_display_name
//    2020-05-27 21:01:57.426 5453-5453/com.t3h.areadata D/MainFragment: column name: width
//    2020-05-27 21:01:57.426 5453-5453/com.t3h.areadata D/MainFragment: column name: height
}