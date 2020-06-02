package com.example.appcm;

import android.app.DownloadManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FotosActivity extends AppCompatActivity {

    WebView wv;
    String img1 = "https://scontent.fsvq2-2.fna.fbcdn.net/v/t1.0-9/95097018_2892641654153540_3454090799128510464_o.jpg?_nc_cat=108&_nc_sid=730e14&_nc_ohc=FEnDjPDI06MAX-nptH1&_nc_ht=scontent.fsvq2-2.fna&oh=e8b1a5d10187a1f40c026b95f187da2f&oe=5EE9681E";
    String img2 = "https://scontent.fsvq2-1.fna.fbcdn.net/v/t1.0-9/97119507_2933499373401101_3751680677817352192_n.jpg?_nc_cat=103&_nc_sid=8bfeb9&_nc_ohc=Abfim3sjenYAX9hHiK8&_nc_ht=scontent.fsvq2-1.fna&oh=a45d6000287a31c12ebcf96606ec6d3f&oe=5EE7A265";
    String img3 = "https://scontent.fsvq2-2.fna.fbcdn.net/v/t1.0-9/400369_369278159823248_1373836294_n.jpg?_nc_cat=104&_nc_sid=d2e176&_nc_ohc=RpZ5szmB4ygAX9hg4rH&_nc_ht=scontent.fsvq2-2.fna&oh=15019c4ba066b4fbb21618fa3223430d&oe=5EF188A6";
    String img4 = "https://scontent.fsvq2-2.fna.fbcdn.net/v/t31.0-8/15541103_1188406131243776_2350750941547787891_o.jpg?_nc_cat=105&_nc_sid=19026a&_nc_ohc=GfQAXWU5CqEAX9mN6Ht&_nc_ht=scontent.fsvq2-2.fna&oh=5e801d729f99a9de0d5b328859161160&oe=5EF19375";
    String img5 = "https://scontent.fsvq2-2.fna.fbcdn.net/v/t31.0-8/17973932_1299799966771058_7507077018600504511_o.jpg?_nc_cat=106&_nc_sid=e3f864&_nc_ohc=Obfj8X4M8pEAX-IGtUL&_nc_ht=scontent.fsvq2-2.fna&oh=41f2a6066c05801823408b6727f5d003&oe=5EF46B11";
    String img6 = "https://scontent.fsvq2-2.fna.fbcdn.net/v/t1.0-9/40016046_1819265371491179_2596150702132690944_o.jpg?_nc_cat=108&_nc_sid=e3f864&_nc_ohc=9pE7q8Qb2CUAX86qH0C&_nc_ht=scontent.fsvq2-2.fna&oh=0044f4a1e8635faff7f25b2d3f38354b&oe=5EF3404D";
    String img7 = "https://scontent.fsvq2-2.fna.fbcdn.net/v/t1.0-9/91903965_2833417876742585_2037516301785628672_o.jpg?_nc_cat=104&_nc_sid=730e14&_nc_ohc=vf9RP2m4kiEAX8eLFht&_nc_ht=scontent.fsvq2-2.fna&oh=32ce1d446683cddbac17d3500b8dc530&oe=5EF0BFE3";
    String img8 = "https://scontent.fsvq2-2.fna.fbcdn.net/v/t1.0-9/84228467_2704356209648753_8352814369620361216_o.jpg?_nc_cat=108&_nc_sid=730e14&_nc_ohc=78G5YbrnFwIAX8DMRt8&_nc_ht=scontent.fsvq2-2.fna&oh=4f4ff69682abac95be9ad13e34f300af&oe=5EF484F7";

    ImageView i;
    ImageView i2;
    ImageView i3;
    ImageView i4;
    ImageView i5;
    ImageView i6;
    ImageView i7;
    ImageView i8;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fotos_activity);

        i = findViewById(R.id.imageView1);
        i2 = findViewById(R.id.imageView2);
        i3 = findViewById(R.id.imageView3);
        i4 = findViewById(R.id.imageView4);
        i5 = findViewById(R.id.imageView5);
        i6 = findViewById(R.id.imageView6);
        i7 = findViewById(R.id.imageView7);
        i8 = findViewById(R.id.imageView8);


        Picasso.get().load(img1).into(i);
        Picasso.get().load(img2).into(i2);
        Picasso.get().load(img3).into(i3);
        Picasso.get().load(img4).into(i4);
        Picasso.get().load(img5).into(i5);
        Picasso.get().load(img6).into(i6);
        Picasso.get().load(img7).into(i7);
        Picasso.get().load(img8).into(i8);

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
