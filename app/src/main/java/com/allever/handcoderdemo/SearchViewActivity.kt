package com.allever.handcoderdemo

import android.graphics.Color
import android.os.Bundle
import com.allever.handcoderdemo.draw.SearchView
import com.allever.lib.common.app.BaseActivity
import com.allever.lib.common.util.ToastUtils
import com.allever.lib.common.util.log
import com.allever.lib.common.util.toast
import kotlinx.android.synthetic.main.activity_search_view.*

class SearchViewActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_view)

//        searchView.setBg(resources.getDrawable(R.drawable.search_bar_bg_2))
//        searchView.setIconColor(Color.parseColor("#ffffff"))
//        searchView.setTextColor(Color.parseColor("#ffffff"))
//        searchView.setHintTextColor(Color.parseColor("#666666"))
        searchView.addSearchListener {
            toast(it)
            log(it)
        }
    }
}