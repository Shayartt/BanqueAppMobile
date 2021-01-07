package com.example.banqueapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    ListView listView; //Declaring our list view
    ArrayList<History> arrayList; //Creating an arraylist of history
    HistoryAdapter arrayAdapter; // creating our arrayAdapter
    Integer num = 1; // This is for the num of transaction since we're using memory cache
    Double my_solde = 0.0; // Initialize the solde at 0.0 to start
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate: Started");
        // The following lines just to create our custom adapter for the listView
        listView = (ListView)findViewById(R.id.listView);
        arrayList = new ArrayList<History>();
        arrayAdapter = new HistoryAdapter(this, R.layout.list_adapter_view,arrayList); //As you can see we're affecting this adapter to another layout
        listView.setAdapter(arrayAdapter);
    }
    public static boolean isNumeric(String strNum) { // To verify with the value input since we're using TextView
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    public void addSolde(View view) { // Onclick Button
        TextView msg_err = (TextView) findViewById(R.id.error); //Getting the textView for errors
        TextView montantView = (TextView) findViewById(R.id.montantInput); //Getting the textView for value of transaction
        String montant = montantView.getText().toString(); // geting the value of the last textView an casting it to string
        TextView history_label = (TextView) findViewById(R.id.historyLabel);

        if (!montant.isEmpty() && isNumeric(montant)) { // In case the user didn't enter a good value (not empty and a number)
            if (montant.indexOf("-") != -1) {
                String montant_tmp = montant.substring(1);
                if (Double.parseDouble(montant_tmp) > my_solde) {
                    msg_err.setText("Votre solde est insuffisant ");
                    return;
                }
            }
            history_label.setText("L'historique des transactions :");
            TextView soldeView = (TextView) findViewById(R.id.soldeView2);
            TextView dateView = findViewById(R.id.dateInput);
            String date = dateView.getText().toString(); //Getting the input date
            DateValidator validator = new DateValidatorUsingDateFormat("dd/MM/yyyy"); //Creating our date format
            dateView.setText(""); // Cleaning the user input for the next transaction
            if (validator.isValid(date)) { //In case the input date is in the right format
                my_solde = my_solde + Double.parseDouble(montant); // Compute the new value of our Account balance
                String solde_text = Double.toString(my_solde); // Parsing the value into String
                soldeView.setText(solde_text); // Showing the new value in the TextView
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //The formatter that we're going to use to parse our data
                LocalDate date_clean = LocalDate.parse(date,formatter); //To parse our String date into a LocalDate format
                History tmp_history = new History(num, montant, date_clean); //Creating our object of class History with the number,value and date
                montantView.setText(""); // Cleaning the user input for the next transaction
                num++; // Incrementing the number of transaction
                msg_err.setText(""); // Cleaning the user input for the next transaction
                arrayList.add(tmp_history); //adding our History object to the array list
                arrayAdapter.notifyDataSetChanged(); // Update the listView
            }
            else { // Date format is incorrect
                msg_err.setText("Veuillez entrez une date do format dd/mm/yy.");
            }
        }
        else { // Value of transaction is incorrect
            msg_err.setText("Veuillez entrez un montant correcte ");
        }
    }
}