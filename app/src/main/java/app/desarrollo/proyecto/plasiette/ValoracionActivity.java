package app.desarrollo.proyecto.plasiette;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ValoracionActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ValuesEnviroment valuesEnviroment= new ValuesEnviroment();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valoraciones);
        SharedPreferences sharedPreferences = getSharedPreferences("Mypref",0);
        String url="http://plasiettetest.000webhostapp.com/ratingByClientId.php";
        String clientId=sharedPreferences.getString("id",null);
        ValoracionTask valoracionTask = new ValoracionTask();
        valoracionTask.execute(url,clientId);
        String a=ValoracionActivity.class.getSimpleName();
        Toast.makeText(ValoracionActivity.this, a, Toast.LENGTH_LONG).show();
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private DownloadImageTask downloadImageTask;
        private List<Rating> mDataset;

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView menu_id,ruc,details,price,score,description;
            public ImageView image;
            public ViewHolder(View v) {
                super(v);
                //menu_id = v.findViewById(R.id.menu_id);
                //ruc = v.findViewById(R.id.ruc);
                details = v.findViewById(R.id.details);
                //price = v.findViewById(R.id.price);
                image = v.findViewById(R.id.imagePlate);
                score = v.findViewById(R.id.score);
                description = v.findViewById(R.id.description);
            }
        }

        public MyAdapter(List<Rating> myDataset) {
            mDataset = myDataset;
        }

        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
            View v =  LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.activity_rating_row, parent, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Rating rating = mDataset.get(position);
            //holder.menu_id.setText(rating.getId());
            //holder.ruc.setText(rating.getRuc());
            holder.details.setText(rating.getDetails());
            //holder.price.setText(rating.price);
            //downloadImageTask.setBmImage(holder.image);
            //downloadImageTask.execute(rating.getImage());
            holder.score.setText(rating.getScore());
            holder.description.setText(rating.getDescription());
        }

        @Override
        public int getItemCount() {
            return mDataset.size();
        }
    }

    class ValoracionTask extends AsyncTask<String,Void,Void> {
        private static final String TAG = "Log TAG: ";
        List<Rating> list = new ArrayList<>();

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
                String id = jsonObject.getString("id");
                JSONArray jsonArray = jsonObject.getJSONArray("rating");
                int lengthJsonArr = jsonArray.length();
                Rating rating;
                for (int i = 0; i < lengthJsonArr; i++) {
                    try {
                        rating = new Rating();
                        JSONObject jsonChildNode = jsonArray.getJSONObject(i);
                        //Log.i(TAG,jsonChildNode.getString("details"));
                        rating.setId(jsonChildNode.getString("id"));
                        rating.setRuc(jsonChildNode.getString("concesionaria_ruc"));
                        rating.setDetails(jsonChildNode.getString("details"));
                        rating.setPrice(jsonChildNode.getString("price"));
                        rating.setImage(jsonChildNode.getString("image"));
                        rating.setScore(jsonChildNode.getString("score"));
                        rating.setDescription(jsonChildNode.getString("description"));
                        list.add(rating);
                    }
                    catch (JSONException e){
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                Log.d(TAG,""+e);
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mRecyclerView = (RecyclerView) findViewById(R.id.recView);
            mRecyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(getApplicationContext());
            mRecyclerView.setLayoutManager(mLayoutManager);
            mAdapter = new MyAdapter(list);
            mRecyclerView.setAdapter(mAdapter);
        }
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

        private ImageView bmImage;

        public DownloadImageTask() {
        }

        public ImageView getBmImage() {
            return bmImage;
        }

        public void setBmImage(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}