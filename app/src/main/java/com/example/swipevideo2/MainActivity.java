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

public class MainActivity extends AppCompatActivity {

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

        VideoItem videoCelebration = new VideoItem();
        videoCelebration.videoURL = "https://github.com/Rask4arm/VideoDemo/raw/refs/heads/main/IMG_5802.MOV";
        videoCelebration.videoTitle = "Dolphins";
        videoCelebration.videoDescription = "Dolphins in galapagos";
        videoItemsList.add(videoCelebration);

        VideoItem videoItemParty = new VideoItem();
        videoItemParty.videoURL = "https://github.com/Rask4arm/VideoDemo/raw/refs/heads/main/IMG_6111.MOV";
        videoItemParty.videoTitle = "Badger";
        videoItemParty.videoDescription = "Badger in my back yard";
        videoItemsList.add(videoItemParty);


        videoViewPager.setAdapter(new VideoAdapter(videoItemsList));
    }
}