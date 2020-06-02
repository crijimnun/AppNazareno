package com.example.appcm;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ViernesSantoActivity extends AppCompatActivity
        implements OnMapReadyCallback {


    private GoogleMap mapa;
    private DatabaseReference mDatabase;
    private Marker marker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viernessanto_activity);

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);
    }

    public void onMapReady(GoogleMap googleMap) {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            mapa=googleMap;
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    10);
        } else {

            googleMap.setMyLocationEnabled(true);

            rutaCofradia(googleMap);
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 10) {
            if (grantResults.length == 1
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                //Permiso concedido


                mapa.setMyLocationEnabled(true);

                rutaCofradia(mapa);

            } else {
                //Permiso denegado:

                Log.e("Mensaje", "Permiso denegado");

                rutaCofradia(mapa);
            }
        }
    }


    public void rutaCofradia (final GoogleMap googleMap){
        LatLng casariche = new LatLng(37.293972, -4.760576);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        googleMap.addPolyline(new PolylineOptions()
                .add(new LatLng(37.295660, -4.759148), new LatLng(37.295359, -4.759039)
                        , new LatLng(37.295356, -4.759250), new LatLng(37.295304, -4.759329)
                        , new LatLng(37.294940, -4.759624), new LatLng(37.294391, -4.760237)
                        , new LatLng(37.293972, -4.760577), new LatLng(37.294342, -4.761521)
                        , new LatLng(37.294432, -4.761676), new LatLng(37.294637, -4.761481)
                        , new LatLng(37.294729, -4.761330), new LatLng(37.294983, -4.761655)
                        , new LatLng(37.295191, -4.762048), new LatLng(37.294983, -4.761655)
                        , new LatLng(37.294729, -4.761330), new LatLng(37.294637, -4.761481)
                        , new LatLng(37.294432, -4.761676), new LatLng(37.294353, -4.761559)
                        , new LatLng(37.294206, -4.761631), new LatLng(37.293493, -4.761866)
                        , new LatLng(37.293218, -4.761157), new LatLng(37.292148, -4.761946)
                        , new LatLng(37.291978, -4.761572), new LatLng(37.290296, -4.762048)
                        , new LatLng(37.290137, -4.762147), new LatLng(37.289983, -4.762276)
                        , new LatLng(37.289696, -4.762420), new LatLng(37.289870, -4.762984)
                        , new LatLng(37.291433, -4.762399), new LatLng(37.292148, -4.761946)
                        , new LatLng(37.293218, -4.761157), new LatLng(37.293176, -4.761072)
                        , new LatLng(37.293974, -4.760577), new LatLng(37.293548, -4.759493)
                        , new LatLng(37.294516, -4.759002), new LatLng(37.294424, -4.758755)
                        , new LatLng(37.294981, -4.758320), new LatLng(37.295268, -4.758795)
                        , new LatLng(37.295748, -4.758434), new LatLng(37.296343, -4.758093)
                        , new LatLng(37.296568, -4.758570), new LatLng(37.296010, -4.759068)
                        , new LatLng(37.295839, -4.759187), new LatLng(37.295660, -4.759148)
                )
                .width(7)
                .color(Color.RED));

        mDatabase.child("posicionCofradia").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    Double latitud = Double.parseDouble(dataSnapshot.child("Latitud").getValue().toString());
                    Double longitud = Double.parseDouble(dataSnapshot.child("Longitud").getValue().toString());

                    if(marker != null)
                        marker.remove();

                    MarkerOptions mark = new MarkerOptions().position(new LatLng(latitud, longitud)).title("Cofradia");

                    marker = googleMap.addMarker(mark);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        googleMap.addMarker(new MarkerOptions().position(new LatLng(37.295660, -4.759148))
                .title("Salida"));

        CameraPosition cameraPosition= CameraPosition.builder()
                .target(casariche).zoom(16).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.pagHome:
                Intent i3 = new Intent(this, MainActivity.class);
                startActivity(i3);
                finish();
                return true;
            case R.id.noticias:

                Intent i = new Intent(this, NoticiasActivity.class);
                startActivity(i);
                finish();
                return true;
            case R.id.fotos:

                Intent i1 = new Intent(this, FotosActivity.class);
                startActivity(i1);
                finish();
                return true;
            case R.id.viernesSanto:

                Intent i2 = new Intent(this, ViernesSantoActivity.class);
                startActivity(i2);
                finish();
                return true;
            case R.id.IniSesion:

                Intent i4 = new Intent(this, LoginActivity.class);
                startActivity(i4);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
