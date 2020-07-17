package com.t3h.demoexternal

import android.os.Environment
import androidx.lifecycle.MutableLiveData
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class MainModel {
    private val format = SimpleDateFormat("DD/MM/YYYY")
    val listFiles = MutableLiveData<MutableList<ItemFile>>()
    var currentPath =""
    fun updateAllFolderOrFile(path: String) {
        currentPath = path
        val listItemFile = mutableListOf<ItemFile>()
        val filePath = File(path)
        if (filePath.isDirectory) {
            for (file in filePath.listFiles()) {
                listItemFile.add(
                    ItemFile(
                        file.path,
                        file.name,
                        if (file.isDirectory) R.drawable.round_folder_indigo_500_48dp else R.drawable.round_insert_drive_file_indigo_500_48dp,
                        format.format(
                            Date(file.lastModified() )
                        )
                    )
                )
            }
        }
        listFiles.value = listItemFile
    }
}