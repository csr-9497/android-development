package app.desarrollo.proyecto.plasiette;

import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.IDNA;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

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
import java.util.ArrayList;
import java.util.List;

public class dashboard extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ImageView info_pedido;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.perfil, R.string.pedidos);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        /*info_pedido = (ImageView) findViewById(R.id.info_pedido);

        TextView t = findViewById(R.id.textofecha);
        ImageView img = (ImageView) findViewById(R.id.info_pedido);
        img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               Intent intent= new Intent(dashboard.this, InfoPedido.class);
                startActivity(intent);
            }
        });*/

        SharedPreferences sharedPreferences = getSharedPreferences("Mypref",0);
        String url="http://plasiettetest.000webhostapp.com/lastMenuByClient.php";
        String ruc=sharedPreferences.getString("ruc",null);
        String client=sharedPreferences.getString("id",null);
        String fecha="2018-06-30";
        PedidosTask pedidosTask = new PedidosTask();
        pedidosTask.execute(url,ruc,client,fecha);
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.perfil) {
            Toast.makeText(dashboard.this, "dashboard perfil", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(dashboard.this, ProfileActivity.class);
            startActivity(intent);
        } else if (id == R.id.pedidos) {
            Toast.makeText(dashboard.this, "dashboard pedidos", Toast.LENGTH_LONG).show();
        } else if (id == R.id.menu) {
            Intent intent = new Intent(dashboard.this, Menu.class);
            startActivity(intent);
        } else if (id == R.id.vals) {
            Toast.makeText(dashboard.this, "dashboard valoraciones", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(dashboard.this, ValoracionActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_acerca){
            Toast.makeText(dashboard.this, "dashboard acerca", Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_contacto){
            Toast.makeText(dashboard.this, "dashboard contacto", Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_calificanos){
            Toast.makeText(dashboard.this, "dashboard calificanos", Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_report_error){
            Toast.makeText(dashboard.this, "dashboard reportar error", Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_logout){
            Toast.makeText(dashboard.this, "dashboard salir", Toast.LENGTH_LONG).show();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public class MyAdapter extends RecyclerView.Adapter<dashboard.MyAdapter.ViewHolder> {
        //private ValoracionActivity.DownloadImageTask downloadImageTask;
        private List<Rating> mDataset;

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView menu_id,ruc,details,price,score,description;
            public ImageView image;
            public ViewHolder(View v) {
                super(v);
                menu_id = v.findViewById(R.id.id);
                //ruc = v.findViewById(R.id.ruc);
                details = v.findViewById(R.id.details);
                price = v.findViewById(R.id.price);
                image = v.findViewById(R.id.image);
                //score = v.findViewById(R.id.score);
                //description = v.findViewById(R.id.description);
            }
        }

        public MyAdapter(List<Rating> myDataset) {
            mDataset = myDataset;
        }

        @Override
        public dashboard.MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v =  LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.dashboard_row, parent, false);
            dashboard.MyAdapter.ViewHolder vh = new dashboard.MyAdapter.ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(dashboard.MyAdapter.ViewHolder holder, int position) {
            Rating rating = mDataset.get(position);
            holder.menu_id.setText(rating.getId());
            //holder.ruc.setText(rating.getRuc());
            holder.details.setText(rating.getDetails());
            holder.price.setText(rating.getPrice());
            //holder.image.setText(rating.getImage());
            Glide.with(getApplicationContext()).load(rating.getImage()).into(holder.image);
            //downloadImageTask.setBmImage(holder.image);
            //downloadImageTask.execute(rating.getImage());
            //holder.score.setText(rating.getScore());
            //holder.description.setText(rating.getDescription());
        }

        @Override
        public int getItemCount() {
            return mDataset.size();
        }
    }

    private class PedidosTask extends AsyncTask<String, Void, Void> {
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
                        .appendQueryParameter("ruc", strings[1])
                        .appendQueryParameter("client", strings[2])
                        .appendQueryParameter("fecha", strings[3]);
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
                Rating menu;
                for (int i = 0; i < lengthJsonArr; i++) {
                    try {
                        menu = new Rating();
                        JSONObject jsonChildNode = jsonArray.getJSONObject(i);
                        menu.setId(jsonChildNode.getString("id"));
                        menu.setDetails(jsonChildNode.getString("details"));
                        menu.setPrice(jsonChildNode.getString("price"));
                        menu.setImage(jsonChildNode.getString("image"));
                        list.add(menu);
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
            mAdapter = new dashboard.MyAdapter(list);
            mRecyclerView.setAdapter(mAdapter);
        }
    }

}
