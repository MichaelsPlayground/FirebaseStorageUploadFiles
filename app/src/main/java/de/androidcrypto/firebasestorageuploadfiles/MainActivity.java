package de.androidcrypto.firebasestorageuploadfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button uploadImage, uploadVideo, uploadPdf;

    Intent uploadImageIntent, uploadVideoIntent, uploadPdfIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uploadImage = findViewById(R.id.btnMainUploadImage);
        uploadVideo = findViewById(R.id.btnMainUploadVideo);
        uploadPdf = findViewById(R.id.btnMainUploadPdf);

        uploadImageIntent = new Intent(MainActivity.this, UploadImageActivity.class);
        uploadVideoIntent = new Intent(MainActivity.this, UploadVideoActivity.class);
        uploadPdfIntent = new Intent(MainActivity.this, UploadPdfActivity.class);

        uploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(uploadImageIntent);
            }
        });

        uploadVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(uploadVideoIntent);
            }
        });

        uploadPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(uploadPdfIntent);
            }
        });
    }
}