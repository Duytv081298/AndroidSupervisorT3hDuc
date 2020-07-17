package com.t3h.areadata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.t3h.areadata.databinding.FragmentDetailImageBinding
import java.io.File

class ImageDetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailImageBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailImageBinding.inflate(
            inflater, container, false
        )
        val path = arguments!!.getString("PATH")
        Glide.with(context!!)
            .load(File(path))
            .into(binding.ivImg)

        binding.btnBack.setOnClickListener {
            activity!!.onBackPressed()
        }
//            .addSharedElement(ivShare, "IV")
        ViewCompat.setTransitionName(binding.ivImg, "IV")
        return binding.root
    }
}