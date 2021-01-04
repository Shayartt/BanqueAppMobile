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

public class HistoryAdapter extends ArrayAdapter<History> {
    private static final String TAG = "HistoryListAdapter";
    private Context mContext;
    private ArrayList<History> history;
    private int mResource;

    public HistoryAdapter(@NonNull Context context, int resource, @NonNull ArrayList<History> objects) {
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
    }

    @Override
    public int getPosition(@Nullable History item) {
        return history.indexOf(item);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parents){
        if ( convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(mResource,parents,false);
        }
        //History histor = history.get(position);

        TextView Num = (TextView) convertView.findViewById(R.id.textNum);
        TextView Montant = (TextView) convertView.findViewById(R.id.textMontant);
        TextView Date = (TextView) convertView.findViewById(R.id.textDate);
        Num.setText(getItem(position).getNum().toString());
        Montant.setText(getItem(position).getMontant());
        Date.setText(getItem(position).getDate());

        return convertView;
    }

}
//@NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        Integer Num = getItem(position).getNum();
//        String Montant = getItem(position).getMontant();
//        String Date = getItem(position).getDate();
//        History new_history = new History(Num,Montant,Date);
//
//        LayoutInflater inflater = LayoutInflater.from(mContext);
//        convertView = inflater.inflate(mResource,parent,false);
//        TextView tvNum = (TextView) convertView.findViewById(R.id.numHistory);
//        TextView tvMontant = (TextView) convertView.findViewById(R.id.montantHistory);
//        TextView tvDate = (TextView) convertView.findViewById(R.id.dateHistory);
//        tvDate.setText(Date);
//        tvMontant.setText(Montant);
//        tvNum.setText(Num);
//        return convertView;
//    }
//}