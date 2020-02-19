package com.allever.handcoderdemo.draw;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.allever.handcoderdemo.R;
import com.allever.lib.common.app.App;

public class CustomDrawActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        App.context = getApplicationContext();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_draw);
    }
}
