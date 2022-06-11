package de.androidcrypto.firebasestorageuploadfiles;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

public class MainActivity extends AppCompatActivity {

    Button uploadImage, uploadVideo, uploadPdf;
    Button viewImages, listAllFiles;

    Intent uploadImageIntent, uploadVideoIntent, uploadPdfIntent;
    Intent viewImagesIntent, listAllFilesIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uploadImage = findViewById(R.id.btnMainUploadImage);
        uploadVideo = findViewById(R.id.btnMainUploadVideo);
        uploadPdf = findViewById(R.id.btnMainUploadPdf);
        viewImages = findViewById(R.id.btnMainViewImages);
        listAllFiles = findViewById(R.id.btnMainListAllFiles);

        uploadImageIntent = new Intent(MainActivity.this, UploadImageActivity.class);
        uploadVideoIntent = new Intent(MainActivity.this, UploadVideoActivity.class);
        uploadPdfIntent = new Intent(MainActivity.this, UploadPdfActivity.class);
        viewImagesIntent = new Intent(MainActivity.this, ViewImagesActivity.class);

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

        viewImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(viewImagesIntent);
            }
        });

        listAllFiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //StorageReference listRef = FirebaseStorage.getInstance().getReference().child("images");
                StorageReference listRef = FirebaseStorage.getInstance().getReference();

                listRef.listAll()
                        .addOnSuccessListener(new OnSuccessListener<ListResult>() {
                            @Override
                            public void onSuccess(ListResult listResult) {
                                for (StorageReference prefix : listResult.getPrefixes()) {
                                    // All the prefixes under listRef.
                                    // You may call listAll() recursively on them.
                                    System.out.println("prefix: " + prefix.getName());
                                }

                                for (StorageReference item : listResult.getItems()) {
                                    // All the items under listRef.
                                    System.out.println("item: " + item.getName());
                                    System.out.println("bucket: " + item.getBucket());
                                }
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                // Uh-oh, an error occurred!
                            }
                        });
            }
        });
    }
}