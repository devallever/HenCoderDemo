package com.allever.handcoderdemo

import android.os.Bundle
import com.allever.lib.common.app.BaseActivity
import kotlinx.android.synthetic.main.activity_auto_tag.*
import java.util.ArrayList

class AutoTagActivity: BaseActivity() {

    private lateinit var mAutoAdapter: MyTagAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auto_tag)


        val list = ArrayList<String>()
        list.add("1")
        list.add("22222222222222222222222222222222222222222222")
        list.add("清空万里")
        list.add("两条相交线")
        list.add("短途")
        list.add("希望在明天会更好")
        mAutoAdapter = MyTagAdapter(this)
        mAutoAdapter.setData(list as ArrayList<String>?)
        autoTagLayout.setAdapter(mAutoAdapter)
    }
}