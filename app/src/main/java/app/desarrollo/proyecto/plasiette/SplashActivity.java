package app.desarrollo.proyecto.plasiette;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.wang.avi.AVLoadingIndicatorView;
import com.wang.avi.indicators.BallClipRotateIndicator;

public class SplashActivity extends AppCompatActivity {
    private AVLoadingIndicatorView mIndicator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        mIndicator = (AVLoadingIndicatorView)findViewById(R.id.av_indicator);
        mIndicator.setIndicator(new BallClipRotateIndicator());

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mIndicator.smoothToShow();
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000l);

    }


}
