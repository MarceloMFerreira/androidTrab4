package br.edu.ifsuldeminas.trab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText searchEditText;
    private Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchEditText = findViewById(R.id.searchEditText);
        searchButton = findViewById(R.id.searchButton);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchQuery = searchEditText.getText().toString().trim();
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("searchLink", searchQuery);
                editor.apply();

                if (searchQuery.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Por favor, insira um termo de busca",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, WallpaperActivity.class);
                    intent.putExtra("searchQuery", searchQuery);
                    startActivity(intent);
                }
            }
        });
    }
}
