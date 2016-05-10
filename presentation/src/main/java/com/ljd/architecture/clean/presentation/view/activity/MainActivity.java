package com.ljd.architecture.clean.presentation.view.activity;

import android.os.Bundle;

import com.ljd.architecture.clean.presentation.R;


import butterknife.ButterKnife;
import butterknife.OnClick;
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_LoadData)
    void navigateToUserList() {
        this.navigator.navigateToUserList(this);
    }


}
