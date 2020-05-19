package com.example.appcm;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    String img2 = "https://scontent-mad1-1.xx.fbcdn.net/v/t1.0-9/p960x960/72779229_2473653816052328_8207904719968927744_o.jpg?_nc_cat=103&_nc_sid=85a577&_nc_ohc=lsVI-W1m5H0AX-ZNBw9&_nc_ht=scontent-mad1-1.xx&_nc_tp=6&oh=da0ba5f9e9f9042a7cc6177d0544e79c&oe=5EE82B7D";
    ImageView i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i = findViewById(R.id.image2);
        Picasso.get().load(img2).into(i);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
    }



    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;

    }


    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.noticias:
//                lblMensaje.setText("¡Últimas Noticias!");
                Intent i = new Intent(this, NoticiasActivity.class);
                startActivity(i);
                finish();
                return true;
            case R.id.fotos:
//                lblMensaje.setText("¡Nuestras Fotos!");;
                Intent i1 = new Intent(this, FotosActivity.class);
                startActivity(i1);
                finish();
                return true;
            case R.id.viernesSanto:
//                lblMensaje.setText("¡Viernes Santo y Nuestro Recorrido!");;
                Intent i2 = new Intent(this, ViernesSantoActivity.class);
                startActivity(i2);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
