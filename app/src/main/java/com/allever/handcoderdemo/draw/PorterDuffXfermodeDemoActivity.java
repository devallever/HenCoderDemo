package com.allever.handcoderdemo.draw;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.allever.handcoderdemo.R;

public class PorterDuffXfermodeDemoActivity extends AppCompatActivity implements View.OnClickListener {

    private PorterDuffXfermodeView porterDuffXfermodeView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_porter_duff_mode_demo);
        porterDuffXfermodeView = findViewById(R.id.porterDuffXfermodeView);
        findViewById(R.id.src).setOnClickListener(this);
        findViewById(R.id.dst).setOnClickListener(this);
        findViewById(R.id.clear).setOnClickListener(this);

        findViewById(R.id.src_in).setOnClickListener(this);
        findViewById(R.id.dst_in).setOnClickListener(this);
        findViewById(R.id.src_out).setOnClickListener(this);
        findViewById(R.id.dst_out).setOnClickListener(this);
        findViewById(R.id.src_over).setOnClickListener(this);
        findViewById(R.id.dst_over).setOnClickListener(this);
        findViewById(R.id.src_atop).setOnClickListener(this);
        findViewById(R.id.dst_atop).setOnClickListener(this);

        findViewById(R.id.darken).setOnClickListener(this);
        findViewById(R.id.lighten).setOnClickListener(this);
        findViewById(R.id.multiply).setOnClickListener(this);
        findViewById(R.id.screen).setOnClickListener(this);

        findViewById(R.id.xor).setOnClickListener(this);
        findViewById(R.id.add).setOnClickListener(this);
        findViewById(R.id.overlay).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        PorterDuff.Mode mode;
        switch (v.getId()) {
            case R.id.src:
                mode = PorterDuff.Mode.SRC;
                break;
            case R.id.dst:
                mode = PorterDuff.Mode.DST;
                break;
            case R.id.clear:
                mode = PorterDuff.Mode.CLEAR;
                break;

            case R.id.src_in:
                mode = PorterDuff.Mode.SRC_IN;
                break;
            case R.id.dst_in:
                mode = PorterDuff.Mode.DST_IN;
                break;
            case R.id.src_out:
                mode = PorterDuff.Mode.SRC_OUT;
                break;
            case R.id.dst_out:
                mode = PorterDuff.Mode.DST_OUT;
                break;
            case R.id.src_over:
                mode = PorterDuff.Mode.SRC_OVER;
                break;
            case R.id.dst_over:
                mode = PorterDuff.Mode.DST_OVER;
                break;
            case R.id.src_atop:
                mode = PorterDuff.Mode.SRC_ATOP;
                break;
            case R.id.dst_atop:
                mode = PorterDuff.Mode.DST_ATOP;
                break;


            case R.id.darken:
                mode = PorterDuff.Mode.DARKEN;
                break;
            case R.id.lighten:
                mode = PorterDuff.Mode.LIGHTEN;
                break;
            case R.id.multiply:
                mode = PorterDuff.Mode.MULTIPLY;
                break;
            case R.id.screen:
                mode = PorterDuff.Mode.SCREEN;
                break;
            case R.id.xor:
                mode = PorterDuff.Mode.XOR;
                break;
            case R.id.add:
                mode = PorterDuff.Mode.ADD;
                break;
            case R.id.overlay:
                mode = PorterDuff.Mode.OVERLAY;
                break;
            default:
                mode = PorterDuff.Mode.MULTIPLY;
                break;
        }

        porterDuffXfermodeView.setMode(mode);
    }
}
