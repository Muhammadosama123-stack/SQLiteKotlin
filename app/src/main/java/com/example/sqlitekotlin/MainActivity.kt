package com.example.sqlitekotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {
            val myDatabase = this.openOrCreateDatabase("Actors", Context.MODE_PRIVATE, null)
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS actors (name VARCHAR, age INT(2)) ")
            // myDatabase.execSQL("INSERT INTO actors(name , age) VALUES ('osama' , 25)")
            //myDatabase.execSQL("INSERT INTO actors(name , age) VALUES ('mobeen' , 24)")
            //myDatabase.execSQL("INSERT INTO actors(name , age) VALUES ('luqs' , 24)")
            //myDatabase.execSQL("INSERT INTO actors(name , age) VALUES ('amar' , 25)")
            //myDatabase.execSQL("UPDATE actors SET age = 30 WHERE name = 'mobeen'") // with this command we update the database
           // myDatabase.execSQL("DELETE FROM actors WHERE name = 'mobeen'") // with this command we delete any data from table

            // instruction below refers to line of code 28. this is how we filter our results.
            // if we need to find any sort of data from the database we can use these several commands to find.
            //WHERE name = 'luqs'
            // WHERE age > 20   you can use any sign to find the age such as < > + <= >= != and many more
            // WHERE name LIKE = 'l%' we will get the result of all names Starting with L.
            // WHERE name LIKE = '%e%' we will get the result of all names which contains letter e.
            // WHERE name LIKE = '%n' we will get the results of all name which ends at s.
            val cursor = myDatabase.rawQuery("SELECT * FROM actors WHERE name = 'luqs'", null)

            val nameIndex = cursor.getColumnIndex("name")
            val ageIndex = cursor.getColumnIndex("age")
            cursor.moveToFirst()

            while (cursor != null) {
                println("Name: " + cursor.getString(nameIndex))
                println("Age: " + cursor!!.getInt(ageIndex))
                cursor.moveToNext()

            }
            if (cursor != null){
                cursor.close()
            }
        }
        catch (e: Exception){
            e.printStackTrace()
        }




    }
}