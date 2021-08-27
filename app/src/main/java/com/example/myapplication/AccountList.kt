package com.example.myapplication

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.account_list.*


class AccountList : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.account_list)

        btn_navi.setOnClickListener {
            layout_drawer.openDrawer(GravityCompat.END) // END:RIGHT, START:LEFT
        }

        naviView.setNavigationItemSelectedListener(this)    // 네비게이션 메뉴 아이템에 클릭 속성 부여
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {    // 네비게이션 메뉴 아이템 클릭 시 수행
        when(item.itemId)
        {
            R.id.menu_item_1 -> Toast.makeText(applicationContext, "현황확인 clicked", Toast.LENGTH_SHORT).show()
            R.id.menu_item_2 -> Toast.makeText(applicationContext, "신고건목록 clicked", Toast.LENGTH_SHORT).show()
        }
        layout_drawer.closeDrawers()    // 클릭 시 네비게이션 뷰 닫기
        return false
    }


    override fun onBackPressed() {
        if (layout_drawer.isDrawerOpen(GravityCompat.END)) {
            layout_drawer.closeDrawers()
        }
        super.onBackPressed()   // 일반 백버튼 기능
    }
}