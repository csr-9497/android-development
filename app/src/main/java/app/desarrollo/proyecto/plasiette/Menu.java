package app.desarrollo.proyecto.plasiette;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Menu extends AppCompatActivity {

    String[] images=new String[5];
    String[] comidas= new String[5];
    String[] precios=new String[5];

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        String url="http://plasiettetest.000webhostapp.com/menuByRuc.php";
        String ruc="11111111111";
        MenuTask menuTask = new MenuTask();
        menuTask.execute(url,ruc);
    }

    class CustomAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return comidas.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.menu_row, null);
            ImageView imageView= (ImageView) view.findViewById(R.id.imagePlate);
            TextView textView= (TextView) view.findViewById(R.id.comida_title);
            TextView textView2= (TextView) view.findViewById(R.id.price);

            imageView.setImageResource(R.drawable.comida1);
            textView.setText(comidas[i]);
            textView2.setText(precios[i]);
            return view;
        }
    }
    private class MenuTask extends AsyncTask<String, Void, Void> {
        private static final String TAG = "Log TAG: ";
        @Override
        protected Void doInBackground(String... strings) {
            String result = "";
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("POST");
                con.setDoInput(true);
                con.setDoOutput(true);
                Uri.Builder builder = new Uri.Builder()
                        .appendQueryParameter("ruc", strings[1]);
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
                JSONArray jsonArray = jsonObject.getJSONArray("rows");
                int lengthJsonArr = jsonArray.length();
                for (int i = 0; i < lengthJsonArr; i++) {
                    try {
                        JSONObject jsonChildNode = jsonArray.getJSONObject(i);
                        comidas[i] = jsonChildNode.getString("details");
                        precios[i] = jsonChildNode.getString("price");
                        images[i]=jsonChildNode.getString("image");
                    }
                    catch (JSONException e){
                        e.printStackTrace();
                    }
                }
                //jsonObject.getBoolean("auth");
            } catch (Exception e) {
                e.printStackTrace();
                Log.d(TAG, ""+e);
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            ListView listView = (ListView) findViewById(android.R.id.list);
            CustomAdapter customAdapter= new CustomAdapter();
            listView.setAdapter(customAdapter);
        }
    }
}