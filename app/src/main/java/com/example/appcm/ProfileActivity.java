package com.example.appcm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {

    private Button mBtnSignout;
    private FirebaseAuth mAuth;
    private TextView mTextViewName;
    private TextView mTextViewEmail;

    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mBtnSignout = (Button) findViewById(R.id.btnSignout);
        mTextViewName = (TextView) findViewById(R.id.TextViewName);
        mTextViewEmail = (TextView) findViewById(R.id.TextViewEmail);

        mBtnSignout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                startActivity(new Intent(ProfileActivity.this, MainActivity.class));

            }
        });
        getUserInfo();

    }

    private void getUserInfo(){
        FirebaseUser user = mAuth.getCurrentUser();
        if(user==null) {
            mTextViewName.setText("Por favor, inicie sesion");
            mTextViewEmail.setText("");
            mBtnSignout.setText("Volver a inicio");
        } else {
            String id = mAuth.getCurrentUser().getUid();
            mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        String name = dataSnapshot.child("name").getValue().toString();
                        String email = dataSnapshot.child("email").getValue().toString();

                        mTextViewName.setText(name);
                        mTextViewEmail.setText(email);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
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
            case R.id.registro:
                Intent i5 = new Intent(this, RegistroActivity.class);
                startActivity(i5);
                finish();
                return true;
            case R.id.profile:
                Intent i6 = new Intent(this, ProfileActivity.class);
                startActivity(i6);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
