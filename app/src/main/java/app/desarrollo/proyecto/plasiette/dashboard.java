package app.desarrollo.proyecto.plasiette;

import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class dashboard extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
        ImageView info_pedido;
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
        info_pedido = (ImageView) findViewById(R.id.info_pedido);


        ImageView img = (ImageView) findViewById(R.id.info_pedido);
        img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               Intent intent= new Intent(dashboard.this, InfoPedido.class);
                startActivity(intent);
            }
        });
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
        } else if (id == R.id.pedidos) {
            Toast.makeText(dashboard.this, "dashboard pedidos", Toast.LENGTH_LONG).show();
        } else if (id == R.id.menu) {
            Intent intent = new Intent(dashboard.this, Menu.class);
            startActivity(intent);
        } else if (id == R.id.vals) {
            Toast.makeText(dashboard.this, "dashboard valoraciones", Toast.LENGTH_LONG).show();
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
}
