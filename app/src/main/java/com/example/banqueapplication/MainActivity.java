package com.example.banqueapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    ListView listView;
    ArrayList<History> arrayList;
    HistoryAdapter arrayAdapter;
    Integer num = 1;
    Double my_solde = 0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate: Started");
        listView = (ListView)findViewById(R.id.listView);
        arrayList = new ArrayList<History>();
        arrayAdapter = new HistoryAdapter(this, R.layout.list_adapter_view,arrayList);
        listView.setAdapter(arrayAdapter);
    }
    public void addSolde(View view) {
        TextView msg_err = (TextView) findViewById(R.id.error);
        TextView montantView = (TextView) findViewById(R.id.montantInput);
        String montant = montantView.getText().toString();
        if (!montant.isEmpty()) {
            TextView soldeView = (TextView) findViewById(R.id.soldeView2);
            TextView dateView = findViewById(R.id.dateInput);
            String date = dateView.getText().toString();
            DateValidator validator = new DateValidatorUsingDateFormat("MM/dd/yyyy");
            dateView.setText("");
            if (validator.isValid(date)) {
                my_solde = my_solde + Double.parseDouble(montant);
                String solde_text = Double.toString(my_solde);
                soldeView.setText(solde_text);
                History tmp_history = new History(num, montant, date);
                montantView.setText("");
                num++;
                msg_err.setText("");
                arrayList.add(tmp_history);
                arrayAdapter.notifyDataSetChanged();
            }
            else {
                msg_err.setText("Veuillez entrez une date do format MM/dd/yy.");
                System.out.println("Veuillez entrez une date do format MM/dd/yy.");
            }
        }
        else {
            msg_err.setText("Veuillez entrez un montant correcte ");
            System.out.println("Veuillez entrez un montant correcte");
        }
    }
}