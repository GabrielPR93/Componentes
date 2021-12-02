package com.example.componentes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;

import java.util.Locale;

import javax.xml.transform.Result;

public class Secundaria extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);

        final RatingBar ratingBar=findViewById(R.id.ratingBar2);
        final Button button=findViewById(R.id.button);
        final ImageButton imagebuton=findViewById(R.id.imageButton);
        final EditText editText=findViewById(R.id.editTextTextPersonName2);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent=getIntent();
        final Intent intentSec=new Intent();

        ratingBar.setRating(intent.getFloatExtra("progreso",1f));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intentSec.putExtra("progreso2",ratingBar.getRating());
                setResult(RESULT_OK,intentSec);
                finish();

            }
        }) ;
        imagebuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //int phoneNumber=Integer.parseInt(editText.getText().toString());
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + 6666666));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}