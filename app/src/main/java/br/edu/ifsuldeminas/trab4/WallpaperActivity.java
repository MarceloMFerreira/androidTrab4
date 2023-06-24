package br.edu.ifsuldeminas.trab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.WallpaperManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.io.IOException;

public class WallpaperActivity extends AppCompatActivity {
    private ImageView imageView;
    private Button wallpaperButton;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        imageView = findViewById(R.id.imageView);
        wallpaperButton = findViewById(R.id.wallpaperButton);
        progressBar = findViewById(R.id.progressBar);

        String searchQuery = getIntent().getStringExtra("searchQuery");
        if (searchQuery != null) {
            new DownloadWallpaperTask().execute(searchQuery);
        }

        wallpaperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                WallpaperManager wallpaperManager = WallpaperManager.getInstance(WallpaperActivity.this);
                try {
                    wallpaperManager.setBitmap(bitmap);
                    Toast.makeText(WallpaperActivity.this, "Papel de parede definido com sucesso",
                            Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(WallpaperActivity.this, "Erro ao definir o papel de parede",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private class DownloadWallpaperTask extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            String searchQuery = params[0];
            try {
                return Glide.with(WallpaperActivity.this)
                        .asBitmap()
                        .load(searchQuery)
                        .apply(new RequestOptions()
                                .diskCacheStrategy(DiskCacheStrategy.NONE))
                        .submit()
                        .get();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            String searchLink = sharedPreferences.getString("searchLink", "");


            TextView linkTextView = findViewById(R.id.linkTextView);
            linkTextView.setText(searchLink);

            progressBar.setVisibility(View.GONE);
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
            } else {
                Toast.makeText(WallpaperActivity.this, "Falha ao carregar o papel de parede",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}
