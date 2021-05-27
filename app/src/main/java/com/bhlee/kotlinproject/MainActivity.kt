package com.bhlee.kotlinproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import com.bhlee.kotlinproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var UserList = arrayListOf<User>(
        User(R.drawable.android, "bhlee", "26", "안녕하세요"),
        User(R.drawable.android, "bhlee", "26", "안녕하세요"),
        User(R.drawable.android, "bhlee", "26", "안녕하세요"),
        User(R.drawable.android, "bhlee", "26", "안녕하세요"),
        User(R.drawable.android, "bhlee", "26", "안녕하세요"),
        User(R.drawable.android, "bhlee", "26", "안녕하세요")
    )
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val item = arrayOf("사과", "배", "딸기", "키위", "포도")

//        binding.listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, item)

        val Adapter = UserAdapter(this, UserList)
        binding.listView.adapter = Adapter
        binding.listView.onItemClickListener = AdapterView.OnItemClickListener {parent, view, position, id ->
            val selectItem = parent.getItemAtPosition(position) as User
            Toast.makeText(this, selectItem.name, Toast.LENGTH_SHORT).show()
        }
    }
}