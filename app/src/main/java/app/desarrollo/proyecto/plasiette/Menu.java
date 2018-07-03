package app.desarrollo.proyecto.plasiette;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.ListMenuItemView;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
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
import java.sql.BatchUpdateException;
import java.util.ArrayList;
import java.util.List;

import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

public class Menu extends AppCompatActivity {

    String[] images=new String[5];
    String[] comidas= new String[5];
    String[] precios=new String[5];
    int CounterPedidos;
    int contador;
    JSONArray jsonArray = new JSONArray();
    private ArrayList<String> list = new ArrayList<String>();

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getSharedPreferences("Mypref",0);
        setContentView(R.layout.menu);
        String url="http://plasiettetest.000webhostapp.com/menuByRuc.php";
        String ruc=sharedPreferences.getString("ruc",null);
        MenuTask menuTask = new MenuTask();
        menuTask.execute(url,ruc);
        final ListView listView = (ListView) findViewById(android.R.id.list);
        Button buttonOrder = (Button) findViewById(R.id.order_pedido);

        final TextView textView = (TextView) findViewById(R.id.comida_title);
        final TextView textView1 = (TextView) findViewById(R.id.counter_plate);

        buttonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JSONObject foods= new JSONObject();
                try {
                    foods.put("foods", jsonArray);
                }
                catch (Exception e){

                }
                Log.i("TAG",foods.toString());
            }
        });
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
            ListView listView = (ListView) view.findViewById(android.R.id.list);
            ImageView imageView =(ImageView) view.findViewById(R.id.imagePlate);
            final TextView textView= (TextView) view.findViewById(R.id.comida_title);
            final TextView textViewCounter = (TextView) view.findViewById(R.id.counter_plate) ;
            contador= Integer.parseInt(textViewCounter.getText().toString());
            TextView textView2= (TextView) view.findViewById(R.id.price);
            Button button = (Button) view.findViewById(R.id.addPlate);
            Button button1 = (Button) view.findViewById(R.id.resPlate);
            textView.setText(comidas[i]);
            textView2.setText(precios[i]);
            final JSONObject jsonObject = new JSONObject();
            final String[] listorder = {};
            button.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    contador++;
                    CounterPedidos++;
                    textViewCounter.setText(contador+"");

                    try{
                        if(textViewCounter.getText()=="1") {
                            jsonObject.put("details", textView.getText());
                            jsonObject.put("cantidad", textViewCounter.getText());
                            listorder[CounterPedidos]=textView.getText().toString();

                        }else{
                            int pointer=0;
                            for(int i=0;i<listorder.length;i++){
                                if(listorder[i]==textView.getText())pointer=i;

                            }
                            jsonArray.remove(pointer);
                            jsonObject.put("details", textView.getText());
                            jsonObject.put("cantidad", textViewCounter.getText());
                        }
                    }catch (Exception e){
                    }
                    jsonArray.put(jsonObject);
                }
            });
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CounterPedidos--;
                    int pos= jsonArray.length();
                    if(contador == 0) {
                        contador = 0;
                        textViewCounter.setText(contador + "");
                    }
                    else {
                        contador--;
                        textViewCounter.setText(contador+"");
                    }
                    jsonArray.remove(pos);
                    Log.i("Log tag ",jsonArray+"");
                    Log.i("Log pedido", contador+"");
                }
            });

            Glide.with(getApplicationContext()).load(images[i]).into(imageView);

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

            final ListView listView = (ListView) findViewById(android.R.id.list);
            CustomAdapter customAdapter= new CustomAdapter();
            listView.setAdapter(customAdapter);

        }
    }
}