package com.example.swipevideo2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

/**
 * Main class
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Sets up app
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final ViewPager2 videoViewPager = findViewById(R.id.videosViewPager);

        List<VideoItem> videoItemsList = new ArrayList<>();

        //Video1
        VideoItem videoDolphin = new VideoItem();
        videoDolphin.videoURL = "https://github.com/Rask4arm/VideoDemo/raw/refs/heads/main/low_resolution_dolphin.mp4";
        videoDolphin.videoTitle = "Dolphins";
        videoDolphin.videoDescription = "Dolphins in Galapagos";
        videoItemsList.add(videoDolphin);

        //Video2
        VideoItem videoTest = new VideoItem();
        videoTest.videoURL = "https://github.com/Rask4arm/VideoDemo/raw/refs/heads/main/Low_resolution_test.mp4";
        videoTest.videoTitle = "Test";
        videoTest.videoDescription = "Test video for swiping app";
        videoItemsList.add(videoTest);

        //Video3
        VideoItem videoBird = new VideoItem();
        videoBird.videoURL = "https://github.com/Rask4arm/VideoDemo/raw/refs/heads/main/low_resolution_bird.mp4";
        videoBird.videoTitle = "Bird";
        videoBird.videoDescription = "Bird in Galapagos";
        videoItemsList.add(videoBird);

        //Video4
        VideoItem videoTest2 = new VideoItem();
        videoTest2.videoURL = "https://github.com/Rask4arm/VideoDemo/raw/refs/heads/main/Low_resolution_test.mp4";
        videoTest2.videoTitle = "Test";
        videoTest2.videoDescription = "Test video for swiping app";
        videoItemsList.add(videoTest2);

        //Video5
        VideoItem videoBird2 = new VideoItem();
        videoBird2.videoURL = "https://github.com/Rask4arm/VideoDemo/raw/refs/heads/main/low_resolution_bird.mp4";
        videoBird2.videoTitle = "Bird";
        videoBird2.videoDescription = "Bird in Galapagos";
        videoItemsList.add(videoBird2);


        videoViewPager.setAdapter(new VideoAdapter(videoItemsList));
    }
}