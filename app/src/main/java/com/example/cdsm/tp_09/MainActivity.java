package com.example.cdsm.tp_09;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] continents = {"Europe", "Afrique","Asie"};
    private String[] paysEurope = {"France","Espagne","Italie","Angleterre"};
    private String[] paysAfrique = {"Maroc","Algérie","Tunisie","Cote d'ivoire"};
    private String[] paysAsie = {"Chine","Japon","Inde"};

    private Integer[] drapEurope={R.drawable.france,R.drawable.espagne,R.drawable.italie,R.drawable.angleterre};
    private Integer[] drapAfrique={R.drawable.tunisie,R.drawable.coteivoire,R.drawable.maroc};
    private Integer[] drapAsie={R.drawable.chine,R.drawable.japon,R.drawable.inde};


    private String[] CapitalPaysEurope = {"Paris","Madrid","Rome","Londres"};
    private String[] CapitalPaysAfrique = {"Rabat","Alger","Tunis","Yamoussoukro"};
    private String[] CapitalPaysAsie = {"Pékin","Tokyo","New Delhi"};

    private String[] pays = {"France","Espagne","Italie","Angleterre","Maroc","Algérie","Tunisie","Cote d'ivoire","Chine","Japon","Inde"};
    private Integer[] drapeau = {R.drawable.france,R.drawable.espagne,R.drawable.italie,R.drawable.angleterre,
                                 R.drawable.tunisie,R.drawable.coteivoire,R.drawable.maroc,
                                 R.drawable.chine,R.drawable.japon,R.drawable.inde};
    private String[] capitale = {"Paris","Madrid","Rome","Londres","Rabat","Alger","Tunis","Yamoussoukro","Pékin","Tokyo","New Delhi"};


    private Intent intent;

    private Spinner spinner;
    private ListView list;
    private String continentChoisi;
    private TextView txtMsg;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.ma_liste);
        spinner = (Spinner) findViewById(R.id.spinner1);
        txtMsg = (TextView) findViewById(R.id.textview);

        CustomIconLabelAdapter adapterLabel = new CustomIconLabelAdapter(this, R.layout.custom_row_icon_label,pays,drapeau,capitale );
        list.setAdapter(adapterLabel);



        intent = new Intent(this, Nouv_Act.class);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av, View v, int position, long id) {
                String text = "Position: " + position + "\nData: " + paysEurope[position];
                txtMsg.setText(text);

                onCLickList(position);
            }
        });


       /* final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, continents);
        spinner.setAdapter(adapter);*/

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {

                txtMsg.setText("Vous avez choisi " + adapterView.getSelectedItem().toString());
                continentChoisi = adapterView.getSelectedItem().toString();
                adapterList(continentChoisi);


            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }
    private void adapterList(String choix) {
        switch (choix) {
            case "Europe":
                CustomIconLabelAdapter adapterLabel = new CustomIconLabelAdapter(this, R.layout.custom_row_icon_label,pays,drapeau,capitale );
                list.setAdapter(adapterLabel);

                break;


            case "Afrique":
                CustomIconLabelAdapter adapterLabel2 = new CustomIconLabelAdapter(this, R.layout.custom_row_icon_label,pays,drapeau,capitale );
                list.setAdapter(adapterLabel2);
                break;


            case "Asie":
                CustomIconLabelAdapter adapterLabel3 = new CustomIconLabelAdapter(this, R.layout.custom_row_icon_label,pays,drapeau,capitale );
                list.setAdapter(adapterLabel3);
                break;
        }
    }

    private void onCLickList(int choix){

                switch (continentChoisi) {
                    case "Europe" :intent.putExtra("Pays", paysEurope[choix]);
                    intent.putExtra("Capital", CapitalPaysEurope[choix]);
                    intent.putExtra("drap",drapEurope[choix]);
                    break;

                    case "Afrique":

                    intent.putExtra("Pays", paysAfrique[choix]);
                    intent.putExtra("Capital", CapitalPaysAfrique[choix]);
                    intent.putExtra("drap", drapAfrique[choix]);
                    break;

                    case "Asie":

                    intent.putExtra("Pays", paysAsie[choix]);
                    intent.putExtra("Capital", CapitalPaysAsie[choix]);
                    intent.putExtra("drap", drapAsie[choix]);
                    break;
                }
                startActivity(intent);

        }
    }




