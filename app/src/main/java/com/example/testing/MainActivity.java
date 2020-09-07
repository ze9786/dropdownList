package com.example.testing;

import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private TextView text;
    private Button spinnerBtn;
    private ScrollView spinnerList_scrollView;
    private boolean spinnerBtnisOpened = false;
    private TextView spinnerTextView;
    private LinearLayout spinnerLinearLayout;
    private RelativeLayout spinnerRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.triangleText);
        spinnerBtn = findViewById(R.id.spinnerBtn);
        spinnerList_scrollView = findViewById(R.id.spinnerList_scrollView);
        spinnerLinearLayout = findViewById(R.id.spinnerLinearLayout);
        spinnerRelativeLayout = findViewById(R.id.spinnerRelativeLayout);

        String[] arr = {"", "+86", "+852", "+853", "+86", "+852", "+853", "+86", "+852", "+853", "+852", "+853"
                , "+86", "+852", "+853", "+852", "+853", "+86", "+852", "+853", "+852", "+853", "+86", "+852", "+853",};
        if (spinnerLinearLayout.getParent() != null)
            ((ViewGroup) spinnerLinearLayout.getParent()).removeAllViews();
        for (String s : arr) {
            spinnerTextView = new TextView(getBaseContext());
            spinnerTextView.setText(s);
            spinnerTextView.setPadding(40, 0, 0, 30);
            spinnerTextView.setTypeface(Typeface.create("sans-serif-thin", Typeface.NORMAL));
            spinnerTextView.setTextColor(Color.parseColor("#5b5c5a"));
            spinnerTextView.setClickable(true);
            spinnerTextView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            spinnerTextView.setOnClickListener(view -> {
                spinnerBtn.setText(s);
                spinnerRelativeLayout.setVisibility(View.GONE);
                text.setText("▼");
                spinnerBtnisOpened = false;
            });
            spinnerLinearLayout.addView(spinnerTextView);
        }
        spinnerList_scrollView.setClickable(true);
        spinnerList_scrollView.addView(spinnerLinearLayout);
        ExpandCollapseAnimation.setHeightForWrapContent(this, spinnerRelativeLayout);




        spinnerBtn.setOnClickListener(e -> {
            if (!spinnerBtnisOpened ) {
                spinnerBtnisOpened = true;
                ExpandCollapseAnimation animation = new ExpandCollapseAnimation(spinnerRelativeLayout, 1000);
                spinnerRelativeLayout.startAnimation(animation);
                text.setText("▲");
            } else {
                spinnerBtnisOpened = false;
                ExpandCollapseAnimation animation = new ExpandCollapseAnimation(spinnerRelativeLayout, 1000);
                spinnerRelativeLayout.startAnimation(animation);
                text.setText("▼");
            }
        });


    }


}