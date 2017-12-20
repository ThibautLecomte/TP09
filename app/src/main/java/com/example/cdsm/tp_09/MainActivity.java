package com.example.cdsm.tp_09;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private  String[] continents = {"Europe", "Afrique","Asie"};
    private  String[] paysEurope = {"France","Espagne","Italie","Angleterre"};
    private String[] paysAfrique = {"Maroc","Algérie","Tunisie","Cote d'ivoire"};
    private String[] paysAsie = {"Chine"};


    private Spinner spinner;
    private ListView list;

    private TextView txtMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.ma_liste);
        spinner = (Spinner) findViewById(R.id.spinner1);
        txtMsg = (TextView) findViewById(R.id.textview);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av, View v, int position, long id) {
                String text = "Position: " + position + "\nData: " + paysEurope[position];
                txtMsg.setText(text);
            }
        });


        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, continents);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {

                txtMsg.setText("Vous avez choisi " + adapterView.getSelectedItem().toString());

                adapterList(adapterView.getSelectedItem().toString());


            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }
    private void adapterList(String choix) {
        switch (choix) {
            case "Europe":
                ArrayAdapter<String> adap = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, paysEurope);
                list.setAdapter(adap);
                break;


            case "Afrique":
                ArrayAdapter<String> adap2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, paysAfrique);
                list.setAdapter(adap2);
                break;


            case "Asie":
                ArrayAdapter<String> adap3 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, paysAsie);
                list.setAdapter(adap3);
                break;
        }
    }

}
