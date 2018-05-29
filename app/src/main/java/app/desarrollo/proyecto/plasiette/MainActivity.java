package app.desarrollo.proyecto.plasiette;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_sign_in);

        final EditText username=(EditText)findViewById(R.id.username);
        final EditText password=(EditText)findViewById(R.id.password);
        Button signIn=(Button)findViewById(R.id.sign);
        signIn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username.getText().toString();
                String pass=password.getText().toString();
                String strUrl="https://plasiettetest.000webhostapp.com/Authenticate_Login.php";
                Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();
                new LoginTask().execute(strUrl,user,pass);
            }
        });
    }

    public class LoginTask extends AsyncTask<String,String,String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            String result = "";
            try {
                URL url= new URL(strings[0]);
                HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
                con.setRequestMethod("POST");
                con.setDoInput(true);
                con.setDoOutput(true);
                Uri.Builder builder = new Uri.Builder()
                        .appendQueryParameter("username", strings[1])
                        .appendQueryParameter("password", strings[2]);
                String query = builder.build().getEncodedQuery();
                OutputStream os = con.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(query);
                writer.flush();
                writer.close();
                os.close();
                con.connect();

                BufferedReader bf = new BufferedReader(new InputStreamReader(con.getInputStream()));
                result = bf.readLine();

                JSONObject jsonObject = new JSONObject(result);
                result=jsonObject.getString("auth");
                //jsonObject.getBoolean("auth");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(s=="true") {
                Intent intent= new Intent(MainActivity.this, dashboard.class);
                startActivity(intent);
            } else {
                Intent intent= new Intent(MainActivity.this, SplashActivity.class);
                startActivity(intent);
            }
        }
    }
}
