package com.example.appcm;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FotosActivity extends AppCompatActivity {

    GridView gridView;
    String[] Names = {"Viernes Santo 2017", "II Torneo de Padel 2016","V Zambombá 2016"};
    int[] Images = {R.drawable.viernes_santo, R.drawable.padel, R.drawable.zambomba};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fotos_activity);

        gridView = findViewById(R.id.gridview);

        CustomAdapter customAdapeter = new CustomAdapter();
        gridView.setAdapter(customAdapeter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),GridItemActivity.class);
                intent.putExtra("name",Names[position]);
                intent.putExtra("image",Images[position]);
                startActivity(intent);
            }
        });

    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return Images.length ;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view1 = getLayoutInflater().inflate(R.layout.fila_data,null);

            TextView name = view1.findViewById(R.id.nombre_foto);
            ImageView image = view1.findViewById(R.id.images);

            name.setText(Names[position]);
            image.setImageResource(Images[position]);

            return view1;
        }
    }




    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        TextView lblMensaje= findViewById(R.id.lblMensaje);
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
