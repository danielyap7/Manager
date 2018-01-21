package com.mortgagehotline.manager.Adapter.ListDataAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mortgagehotline.manager.Model.DataList.DataListType;
import com.mortgagehotline.manager.R;

import java.util.ArrayList;

/**
 * Created by yaptzeyang on 06/01/2018.
 */

public class DataTypeAdapter extends ArrayAdapter<DataListType> {

    private Context hContext;
    private LayoutInflater hInflater;
    private ArrayList<DataListType> hDataSource;


    public DataTypeAdapter(@NonNull Context context, ArrayList<DataListType> item) {
        super(context, 0, item);
        hContext = context;
        hDataSource = item;
        hInflater = (LayoutInflater) hContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return hDataSource.size();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        DataListType itemdata = (DataListType) getItem(position);

        if(convertView == null){
            convertView = hInflater.inflate(R.layout.listdata_layout, parent, false);
        }

        TextView title = (TextView) convertView.findViewById(R.id.DataTitleUp);
        TextView stringdata = (TextView) convertView.findViewById(R.id.DataStringDown);

        title.setText(itemdata.getTitle());
        stringdata.setText(itemdata.getData());

        return convertView;

    }
}
