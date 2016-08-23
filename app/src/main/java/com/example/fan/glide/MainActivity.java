package com.example.fan.glide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.GifTypeRequest;
import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mGifButton;
    private Button mClearButton;
    private ImageView mGifImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();
        setOnClickListener();
    }

    private void findView() {
        mGifButton = (Button) findViewById(R.id.gifButton);
        mGifImageView = (ImageView) findViewById(R.id.gifImageView);
        mClearButton = (Button) findViewById(R.id.clearButton);
    }

    private void setOnClickListener() {
        mGifButton.setOnClickListener(this);
    }

    private void handleGifButton() {
        long startTime = System.currentTimeMillis();
        DrawableTypeRequest<String> drawableTypeRequest = Glide.with(this).load("http://10.60.205.206:8080/abc.gif");
        long endTime1 = System.currentTimeMillis();

        Log.d("glideActivity", (endTime1 - startTime) + "ms");
        GifTypeRequest gifTypeRequest = drawableTypeRequest.asGif();
        long endTime2 = System.currentTimeMillis();
        Log.d("glideActivity", (endTime2 - endTime1) + "ms");
        gifTypeRequest.into(mGifImageView);
        long endTime3 = System.currentTimeMillis();
        Log.d("glideActivity", (endTime3 - endTime2) + "ms");
    }

    private void handleClearButton() {
        Glide.clear(mGifImageView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.gifButton:
                handleGifButton();
                break;
            case R.id.clearButton:
                handleClearButton();
                break;
            default:
                break;
        }
    }
}
