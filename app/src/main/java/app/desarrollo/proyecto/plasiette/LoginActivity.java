package app.desarrollo.proyecto.plasiette;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.net.Uri;
import android.os.AsyncTask;
import android.widget.Toast;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class LoginActivity extends AppCompatActivity {
    Button button,button2,button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_sign_in);
        final EditText userData = (EditText) findViewById(R.id.username);
        final EditText passData = (EditText) findViewById(R.id.password);
        button = (Button)findViewById(R.id.button_sign_in);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = userData.getText().toString();
                String pass = passData.getText().toString();
                String strUrl="http://plasiettetest.000webhostapp.com/Authenticate_Login.php";
                new LoginTask().execute(strUrl,user,pass);
            }
        });
        button2 = (Button) findViewById(R.id.sign_in_text);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent = new Intent(LoginActivity.this,LoginAcitivitySignUp.class);
                startActivity(intent);
            }
        });
        button3 = (Button) findViewById(R.id.forgot_password);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,LoginActivityForgotPassword.class);
                startActivity(intent);
            }
        });

    }

    public class LoginTask extends AsyncTask<String,String,String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(LoginActivity.this, "Espere un momento", Toast.LENGTH_LONG).show();

        }

        @Override
        protected String doInBackground(String... strings) {
            String result = "";
            try {
                URL url= new URL(strings[0]);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
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
            if(s == "true") {
                Intent intent = new Intent(LoginActivity.this, dashboard.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(LoginActivity.this, "Ingrese credenciales validas", Toast.LENGTH_LONG).show();
            }
        }
    }
}