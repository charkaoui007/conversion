package com.example.conversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner sp1,sp2;
    EditText ed1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1=findViewById(R.id.amount);
        sp1=findViewById(R.id.sp1);
        sp2=findViewById(R.id.sp2);
        b1=findViewById(R.id.B1);

        String [] from ={"USD","MAD","EUR"};
        ArrayAdapter ad = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(ad);

        String [] to ={"USD","MAD","EUR"};
        ArrayAdapter ad1 = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,to);
        sp2.setAdapter(ad1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double nv;

                Double val = Double.parseDouble(ed1.getText().toString());
                if(sp1.getSelectedItem().toString() == "USD" && sp2.getSelectedItem().toString() =="MAD"){
                    nv = val * 10 ;
                    Toast.makeText(getApplicationContext(),nv.toString(),Toast.LENGTH_LONG).show();
                }else if(sp1.getSelectedItem().toString() == "USD" && sp2.getSelectedItem().toString() =="EUR"){
                    nv = val * 1.94 ;
                    Toast.makeText(getApplicationContext(),nv.toString(),Toast.LENGTH_LONG).show();
                }
                else if(sp1.getSelectedItem().toString() == "MAD" && sp2.getSelectedItem().toString() =="USD"){
                    nv = val / 10 ;
                    Toast.makeText(getApplicationContext(),nv.toString(),Toast.LENGTH_LONG).show();
                }
                else if(sp1.getSelectedItem().toString() == "MAD" && sp2.getSelectedItem().toString() =="EUR"){
                    nv = val / 11 ;
                    Toast.makeText(getApplicationContext(),nv.toString(),Toast.LENGTH_LONG).show();
                }
                else if(sp1.getSelectedItem().toString() == "EUR" && sp2.getSelectedItem().toString() =="MAD"){
                    nv = val * 11 ;
                    Toast.makeText(getApplicationContext(),nv.toString(),Toast.LENGTH_LONG).show();
                }
                else if(sp1.getSelectedItem().toString() == "EUR" && sp2.getSelectedItem().toString() =="USD"){
                    nv = val / 1.94 ;
                    Toast.makeText(getApplicationContext(),nv.toString(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}