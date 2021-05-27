package com.bhlee.kotlinproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.bhlee.kotlinproject.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

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

        binding.btnNavi.setOnClickListener {
            binding.layoutDrawer.openDrawer(GravityCompat.START)
        }

        binding.naviView.setNavigationItemSelectedListener(this)

        val item = arrayOf("사과", "배", "딸기", "키위", "포도")

//        binding.listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, item)

        val Adapter = UserAdapter(this, UserList)
        binding.listView.adapter = Adapter
        binding.listView.onItemClickListener = AdapterView.OnItemClickListener {parent, view, position, id ->
            val selectItem = parent.getItemAtPosition(position) as User
            Toast.makeText(this, selectItem.name, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.access -> Toast.makeText(applicationContext, "접근성", Toast.LENGTH_SHORT).show()
            R.id.email -> Toast.makeText(applicationContext, "이메일", Toast.LENGTH_SHORT).show()
            R.id.message -> Toast.makeText(applicationContext, "메시지", Toast.LENGTH_SHORT).show()
        }
        binding.layoutDrawer.closeDrawers()
        return false
    }

    override fun onBackPressed() {
        if(binding.layoutDrawer.isDrawerOpen(GravityCompat.START)){
            binding.layoutDrawer.closeDrawers()
        }else{
            super.onBackPressed()
        }
    }
}