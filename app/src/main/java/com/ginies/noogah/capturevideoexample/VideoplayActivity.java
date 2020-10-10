package com.ginies.noogah.capturevideoexample;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

public class VideoplayActivity extends AppCompatActivity {
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videoplay);

        videoView = findViewById(R.id.videoview);
        Uri videoUri = Uri.parse(getIntent().getExtras().getString("videoUri"));
        videoView.setVideoURI(videoUri);
        videoView.start();
    }
}