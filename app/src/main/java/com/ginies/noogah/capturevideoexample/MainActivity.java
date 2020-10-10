package com.ginies.noogah.capturevideoexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static int ViDEO_REQUEST = 101;
    private Uri videoUri = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Capturevideo(View view) {
        Intent Videointent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);

        if (Videointent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(Videointent, ViDEO_REQUEST);

        }
    }

    public void Playvideo(View view) {
        Intent PlayIntent = new Intent(this,VideoplayActivity.class);
        PlayIntent.putExtra("videoUri",videoUri.toString());
        startActivity(PlayIntent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ViDEO_REQUEST && resultCode == RESULT_OK) {
            videoUri = data.getData();

        }
    }
}