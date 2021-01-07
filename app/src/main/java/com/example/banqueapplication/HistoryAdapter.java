package com.example.banqueapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class HistoryAdapter extends ArrayAdapter<History> { //This class is used to create our custom ListView
    private static final String TAG = "HistoryListAdapter";
    private Context mContext;
    private ArrayList<History> history; //Declaring an array list of our History class
    private int mResource;

    public HistoryAdapter(@NonNull Context context, int resource, @NonNull ArrayList<History> objects) { //The constructor of our adapter with our context and ressources
        super(context, resource, objects);
        this.mContext = context;
        mResource = resource;
        this.history = objects;
    }

    @Override
    public int getCount() {

        return history.size();

    }

    @Nullable
    @Override
    public History getItem(int position) {
        return history.get(position);
    } //Return the item in the giving position

    @Override
    public int getPosition(@Nullable History item) {
        return history.indexOf(item);
    } //To get the position of certain item

    @Override
    public long getItemId(int position) {
        return position;
    } //get position by itemID

    public View getView(int position, View convertView, ViewGroup parents){ //Get the view in a given position
        if ( convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(mResource,parents,false);
            // Inflate our layer from the custom context and using our ressources
        }

        TextView Num = (TextView) convertView.findViewById(R.id.textNum); //For the labels in our application
        TextView Montant = (TextView) convertView.findViewById(R.id.textMontant);
        TextView Date = (TextView) convertView.findViewById(R.id.textDate);
        Num.setText(getItem(position).getNum().toString());
        Montant.setText(getItem(position).getMontant());
        Date.setText(getItem(position).getDate().toString());


        return convertView;
    }

}