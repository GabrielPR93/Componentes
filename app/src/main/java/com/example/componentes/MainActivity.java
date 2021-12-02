package com.example.componentes;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.Instrumentation;
import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.service.carrier.CarrierMessagingService;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    int cont=0;
    private TextView textView3;
    private RatingBar ratingBar;
    private SeekBar seekbar;
    private TextView textView5;
    private TextView textViewSwitch;
    private EditText textoeditado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ToggleButton btn5=findViewById(R.id.button5);
       final Button btn2=findViewById(R.id.button2);
        final Button btn4=findViewById(R.id.button4);
        textView3=findViewById(R.id.textView3);
        final CheckBox checkBox1=findViewById(R.id.checkBox1);
        final CheckBox checkBox2=findViewById(R.id.checkBox2);
        final CheckBox checkBox3=findViewById(R.id.checkBox3);
        seekbar=findViewById(R.id.seekBar);
        textView5=findViewById(R.id.textView5);
        final Switch switch1=findViewById(R.id.switch1);
        textViewSwitch=findViewById(R.id.textViewSwitch);
        ratingBar=findViewById(R.id.ratingBar);
        textoeditado=findViewById(R.id.editTextTextPersonName);
       final ImageButton imageButton=findViewById(R.id.button3);
       final RadioGroup radiogroup=findViewById(R.id.radioGroup);
       final Button ocultarActionBar=findViewById(R.id.bOcultar);

       radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup group, int checkedId) {
               RadioButton rb1=findViewById(R.id.radioButton);
               RadioButton rb2=findViewById(R.id.radioButton2);
    
               if(rb1.isChecked()){
                   Toast.makeText(MainActivity.this, "Primer checkbox", Toast.LENGTH_SHORT).show();
               }else if(rb2.isChecked()){
                   Toast.makeText(MainActivity.this, "Segundo Checkbox", Toast.LENGTH_SHORT).show();
               }
               
           }
       });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent=new Intent(MainActivity.this,Secundaria.class);
                intent.putExtra("progreso",ratingBar.getRating());
                startActivityForResult(intent,1);

            }

        });

    btn5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

       if(checkBox3.isChecked()){
           checkBox3.setChecked(false);
       }else{
           checkBox3.setChecked(true);
       }
        }
    });

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView5.setText(""+progress);
                getSupportActionBar().setSubtitle(" "+progress); //El subtitulo
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switch1.isChecked()){
                    textViewSwitch.setText("Activo");
                }else{
                    textViewSwitch.setText("Desactivo");
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             btn5.setChecked(false);
             checkBox1.setChecked(false);
             checkBox2.setChecked(false);
             checkBox3.setChecked(false);
             switch1.setChecked(false);
             textViewSwitch.setText("Desactivo");
             seekbar.setProgress(0);
             ratingBar.setRating(0);
             textoeditado.setHint("Introduce tu nombre");
             textView3.setText("ImageButton y un boton con imagen");
             cont=0;
            }
        });


        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox2.isChecked()){
                    cont--;
                    if(cont<0){
                        cont=0;
                    }
                    textView3.setText(""+cont);
                }else{
                    cont++;
                    textView3.setText(""+cont);
                }
            }
        });

        ocultarActionBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(getSupportActionBar().isShowing()){
                   getSupportActionBar().hide();
               }else {
                   getSupportActionBar().show();
               }
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            float result=data.getFloatExtra("progreso2",1f);
            textView3.setText(""+result);
            ratingBar.setRating(result);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                final Intent intentTerciaria=new Intent(MainActivity.this,terciaria.class);
                startActivity(intentTerciaria);
                Log.i("info","item 1 seleccionado");
                return true;
            case R.id.item2:
               textView3.setText("");
               textView5.setText("");
               seekbar.setProgress(0);
                return true;
            case R.id.item3:
                textoeditado.setText("");
            return true;
            case R.id.opc1:
                Toast.makeText(this, "Opc1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.opc2:
                Toast.makeText(this, "Opc2", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }



    }
}