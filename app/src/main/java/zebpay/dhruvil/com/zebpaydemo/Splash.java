package zebpay.dhruvil.com.zebpaydemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.skyfishjy.library.RippleBackground;

public class Splash extends AppCompatActivity {
    boolean shouldopen = true;
    RippleBackground rippleBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        rippleBackground = (RippleBackground) findViewById(R.id.content);

    }

    @Override
    protected void onPause() {
        super.onPause();
        shouldopen = false;
        rippleBackground.stopRippleAnimation();
    }

    @Override
    protected void onResume() {
        super.onResume();
        shouldopen = true;
        startsplash();
        rippleBackground.startRippleAnimation();
    }

    private void startsplash() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    if (shouldopen) {
                        startActivity(new Intent(Splash.this, MainActivity.class));
                        finish();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
