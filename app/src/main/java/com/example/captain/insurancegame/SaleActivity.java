package com.example.captain.insurancegame;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class SaleActivity extends Activity {
    private VideoView videoView;
    private Button btn_start,btn_end;
    private MediaController mediaController;
    private Context mcontent;
    private ImageView letter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sale);
        mcontent=this;
        videoView= (VideoView) findViewById(R.id.videoView);
        mediaController = new MediaController(this);
        String uri = "android.resource://" + getPackageName() + "/" + R.raw.sale;
        videoView.setVideoURI(Uri.parse(uri));
        videoView.setMediaController(mediaController);
        mediaController.setMediaPlayer(videoView);
        videoView.requestFocus();
        videoView.start();
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                Intent intent=getIntent();
                int fee=intent.getIntExtra("feebefo",0);
                Intent intent1=new Intent(mcontent,firstActivity.class);
                intent1.putExtra("lettershown",1);
                intent1.putExtra("feebefo",fee);
                startActivity(intent1);
            }
        });




    }



}