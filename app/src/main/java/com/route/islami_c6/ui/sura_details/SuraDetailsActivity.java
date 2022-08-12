package com.route.islami_c6.ui.sura_details;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.route.islami_c6.R;
import com.route.islami_c6.ui.home.quran_fragment.SuraNamesAdapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SuraDetailsActivity extends AppCompatActivity {
    ArrayList<String> suraLines = new ArrayList<String>();
    TextView suraNameTextView;
    RecyclerView suraVerseRecyclerView;
    SuraVerseAdapter suraVerseAdapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sura_details);
        suraVerseRecyclerView = findViewById(R.id.sura_verse_recycler_view);
        suraNameTextView = findViewById(R.id.sura_details_activity_sura_name_text_view);
        String fileName = getIntent().getStringExtra("file_name");
        String suraName = getIntent().getStringExtra("sura_name");
        suraNameTextView.setText(suraName);
        readSuraFile(fileName);
        suraVerseAdapter = new SuraVerseAdapter(suraLines);

        suraVerseRecyclerView.setAdapter(suraVerseAdapter);

    }
    public void readSuraFile(String fileName){
        BufferedReader reader;
        try{
            final InputStream file = getAssets().open(fileName);
            reader = new BufferedReader(new InputStreamReader(file));
            String line = reader.readLine();
            while(line != null){
                Log.e("Sura details",line) ;
                suraLines.add(line);
                line = reader.readLine();
            }
        } catch(IOException ioe){
            Log.e("Sura details","Error "+ioe.getMessage());
            ioe.printStackTrace();
        }
    }
}
