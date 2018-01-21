package com.mortgagehotline.manager.Adapter.ListDataAdapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mortgagehotline.manager.Model.DataList.CheckListType;
import com.mortgagehotline.manager.Model.DataList.DataListType;
import com.mortgagehotline.manager.R;

import java.util.ArrayList;

/**
 * Created by yaptzeyang on 09/01/2018.
 */

public class FragmentRVAdapter_CheckLIst extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context mContext;
    private ArrayList<CheckListType> hItemList;
    private LayoutInflater mInflater;
    private LinearLayout linearLayout;
    private TextView datetime;


    public FragmentRVAdapter_CheckLIst(Context context, ArrayList<CheckListType> ItemList) {
        this.mInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.hItemList = ItemList;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        view = mInflater.inflate(R.layout.listdata_layout_checklist,parent,false);
        linearLayout = view.findViewById(R.id.expandable_text);
        datetime = view.findViewById(R.id.ChecklistTitle_date);
        return new CustomViewHolder(view);
        }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        CheckListType datalist = hItemList.get(position);
        CheckBox expended = ((CustomViewHolder) holder).expandTrigger;
        EditText textdata = ((CustomViewHolder) holder).dataEditText;

        ((CustomViewHolder) holder).titleTextview.setText(datalist.getChecklistTitle());
        ((CustomViewHolder) holder).dateTextview.setText(datalist.getChecklistDate());
        expended.setChecked(datalist.getExpanded());
        textdata.setText(datalist.getChecklistData());
        textdata.setTextColor(Color.BLACK);
        textdata.setEnabled(false);

        if(expended.isChecked()){
            linearLayout.setVisibility(View.VISIBLE);
            datetime.setVisibility(View.VISIBLE);

        }
        else{
            linearLayout.setVisibility(View.GONE);
            datetime.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return hItemList.size();
    }

    public CheckListType getItem(int position){

        return hItemList.get(position);
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView titleTextview;
        protected TextView dateTextview;
        protected CheckBox expandTrigger;
        protected EditText dataEditText;

        public CustomViewHolder(View view) {
            super(view);
            this.titleTextview = (TextView) view.findViewById(R.id.ChecklistTitle);
            this.dateTextview = (TextView) view.findViewById(R.id.ChecklistTitle_date);
            this.expandTrigger = (CheckBox) view.findViewById(R.id.expend_trigger);
            this.dataEditText = (EditText) view.findViewById(R.id.expended_textfield);
        }
    }

}
