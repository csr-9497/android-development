package app.desarrollo.proyecto.plasiette;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class ProfileActivity extends AppCompatActivity {

    Client client = new Client();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getSharedPreferences("Mypref",0);
        setContentView(R.layout.client_profile);
        String url="http://plasiettetest.000webhostapp.com/clientById.php";
        String clientId=sharedPreferences.getString("id",null);
        ProfileTask profileTask = new ProfileTask();
        profileTask.execute(url,clientId);
        //Toast.makeText(this, client.getName(), Toast.LENGTH_LONG).show();
    }

    private class ProfileTask extends AsyncTask<String, Void, Void> {
        private static final String TAG = "Log TAG: ";

        @Override
        protected Void doInBackground(String... strings) {
            String result;
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("POST");
                con.setDoInput(true);
                con.setDoOutput(true);
                Uri.Builder builder = new Uri.Builder()
                        .appendQueryParameter("client", strings[1]);
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
                JSONArray jsonArray = jsonObject.getJSONArray("profile");
                JSONObject jsonChildNode = jsonArray.getJSONObject(0);
                //Log.i("Log_tag",jsonChildNode.getString("name"));
                client.setId(jsonObject.getString("id"));
                client.setName(jsonChildNode.getString("name"));
                client.setPhone(jsonChildNode.getString("phone"));
                client.setEmail(jsonChildNode.getString("email"));
                Log.i("Log_tag",client.getId());
                Log.i("Log_tag",client.getName());
                Log.i("Log_tag",client.getPhone());
                Log.i("Log_tag",client.getEmail());
            } catch (Exception e) {
                e.printStackTrace();
                Log.d(TAG,""+e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            TextView profile_id = (TextView)findViewById(R.id.profile_id);
            profile_id.setText(client.getId());
            TextView profile_name = (TextView)findViewById(R.id.profile_name);
            profile_name.setText(client.getName());
            TextView profile_phone = (TextView)findViewById(R.id.profile_phone);
            profile_phone.setText(client.getPhone());
            TextView profile_email = (TextView)findViewById(R.id.profile_email);
            profile_email.setText(client.getEmail());
        }
    }
}
