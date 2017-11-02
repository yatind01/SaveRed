package com.example.yatindhingra.savered;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class carousal extends AppCompatActivity {

    CarouselView carouselView;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    int[] sampleImages = {R.drawable.img4, R.drawable.img3, R.drawable.img2};
    Button foodButton;
    Button cameraButton;
    Button mapButton;
    Button mainButton;
    int val = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carousal);

        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);

        carouselView.setImageListener(imageListener);

        foodButton = (Button) findViewById(R.id.foodButton);
        cameraButton = (Button) findViewById(R.id.cameraButton);
        mapButton = (Button) findViewById(R.id.mapButton);
        mainButton = (Button) findViewById(R.id.mainButton);

        foodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(carousal.this, search.class);
                startActivity(i);
            }
        });

        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent();

            }
        });

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(carousal.this, MapsActivity.class);
                startActivity(i);
            }
        });

        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(carousal.this, workout.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Intent i = new Intent(carousal.this, caloriesCount.class);
        i.putExtra("counter", val);
        val++;
        startActivity(i);
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageResource(sampleImages[position]);
        }
    };

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
}
