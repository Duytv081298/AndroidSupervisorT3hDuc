package com.t3h.demoailatrieuphu

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.os.Environment
import android.util.Log
import java.io.File
import java.io.FileOutputStream

class SqlALTPManager(private val context: Context) {
    init {
        copyDataBase()
    }

    private var database: SQLiteDatabase? = null
    fun copyDataBase() {
        //lay duong dan external app
        var path = Environment.getDataDirectory().path + "/data" + "/" +
                context.packageName + "/db"
        File(path).mkdirs()
        path += "/ailatriphu"
        if (File(path).exists()) {
            return
        }
        //truy vao asset bang assetManager
        val accetManager = context.assets
        val input = accetManager.open("latrieuphu")
        val out = FileOutputStream(path)
        val b = ByteArray(1024)
        var le = input.read(b)
        while (le > -1) {
            out.write(b, 0, le)
            le = input.read(b)
        }
        input.close()
        out.close()
    }

    private fun openDatabase() {
        var path = Environment.getDataDirectory().path + "/data" + "/" +
                context.packageName + "/db"
        path += "/ailatriphu"
        database = SQLiteDatabase.openDatabase(
            path, null,
            SQLiteDatabase.OPEN_READWRITE
        )
    }

    private fun closeDatabase() {
        if (database != null && database!!.isOpen) {
            database!!.close()
            database = null
        }
    }

    fun query15Question() {
        openDatabase()
        val sql = "select * from (select * from Question order by RANDOM()) as que " +
                "group by level order by level asc"

        val c = database!!.rawQuery(sql, null)
        c.moveToFirst()
        val indexQuestion = c.getColumnIndex("question")
        val indexLevel = c.getColumnIndex("level")
        val indexCaseA = c.getColumnIndex("casea")
        val indexCaseB = c.getColumnIndex("caseb")
        val indexCaseC = c.getColumnIndex("casec")
        val indexCaseD = c.getColumnIndex("cased")
        val indexTrueCase = c.getColumnIndex("truecase")
        while (!c.isAfterLast){
            val level = c.getInt(indexLevel)
            val question = c.getString(indexQuestion)
            val caseA = c.getString(indexCaseA)
            val caseB = c.getString(indexCaseB)
            val caseC = c.getString(indexCaseC)
            val caseD = c.getString(indexCaseD)
            val trueCase = c.getString(indexTrueCase)
            Log.d("SqlALTPManager", "level: " + level)
            Log.d("SqlALTPManager", "question: " + question)
            Log.d("SqlALTPManager", "caseA: " + caseA)
            Log.d("SqlALTPManager", "caseB: " + caseB)
            Log.d("SqlALTPManager", "caseC: " + caseC)
            Log.d("SqlALTPManager", "caseD: " + caseD)
            Log.d("SqlALTPManager", "trueCase " + trueCase)
            Log.d("SqlALTPManager", "============================")
            c.moveToNext()
        }

        c.close()
        closeDatabase()
    }
}