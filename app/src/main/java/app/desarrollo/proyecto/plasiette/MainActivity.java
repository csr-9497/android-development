package app.desarrollo.proyecto.plasiette;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_sign_up);
    }
    Intent intent= new Intent(MainActivity.this, dashboard.class);
}
