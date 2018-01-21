package com.mortgagehotline.manager.Adapter.ListDataAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mortgagehotline.manager.Model.DataList.DataListType;
import com.mortgagehotline.manager.R;

import java.util.ArrayList;

/**
 * Created by yaptzeyang on 09/01/2018.
 */

public class FragmentRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context mContext;
    private ArrayList<DataListType> hItemList;
    private LayoutInflater mInflater;
    private int selectedPos = RecyclerView.NO_POSITION;
    private int focusedItem = 0;


    public FragmentRVAdapter(Context context, ArrayList<DataListType> ItemList) {
        this.mInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.hItemList = ItemList;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        switch (viewType){

            case DataListType.TITLE_TYPE:
                view = mInflater.inflate(R.layout.listdata_layout_title,parent, false);
                return new CustomTitleViewHolder(view);

            case DataListType.UPDOWN_TYPE:
                view = mInflater.inflate(R.layout.listdata_layout,parent,false);
                return new CustomViewHolder(view);

            case DataListType.LEFTRIGHT_TYPE:
                view = mInflater.inflate(R.layout.listdata_layout_type2,parent,false);
                return new CustomViewHolder2(view);

            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        holder.itemView.setSelected(selectedPos == position);

        DataListType datalist = hItemList.get(position);

        switch (datalist.getType()){
            case DataListType.TITLE_TYPE:
                String header = datalist.getTitle();
                ((CustomTitleViewHolder) holder).headerTextview.setText(header);
                break;
            case DataListType.UPDOWN_TYPE:
                ((CustomViewHolder) holder).titleTextview.setText(datalist.getTitle());
                ((CustomViewHolder) holder).dataTextview.setText(datalist.getData());
                break;
            case DataListType.LEFTRIGHT_TYPE:
                ((CustomViewHolder2) holder).titleTextview.setText(datalist.getTitle());
                ((CustomViewHolder2) holder).dataTextview.setText(datalist.getData());
                break;
        }

    }

    @Override
    public int getItemViewType(int position) {
        switch (hItemList.get(position).getType()) {
            case 0:
                return DataListType.TITLE_TYPE;
            case 1:
                return DataListType.UPDOWN_TYPE;
            case 2:
                return DataListType.LEFTRIGHT_TYPE;
            default:
                return -1;

        }
    }

    @Override
    public int getItemCount() {
        return hItemList.size();
    }

    public DataListType getItem(int position){

        return hItemList.get(position);
    }



    public class CustomTitleViewHolder extends RecyclerView.ViewHolder {
        protected TextView headerTextview;

        public CustomTitleViewHolder(View view) {
            super(view);
            this.headerTextview = (TextView) view.findViewById(R.id.DataTitleSolo);
        }
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView titleTextview;
        protected TextView dataTextview;

        public CustomViewHolder(View view) {
            super(view);
            this.titleTextview = (TextView) view.findViewById(R.id.DataTitleUp);
            this.dataTextview = (TextView) view.findViewById(R.id.DataStringDown);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Redraw the old selection and the new
                    notifyItemChanged(focusedItem);
                    focusedItem = getLayoutPosition();
                    notifyItemChanged(focusedItem);
                }
            });
        }
    }

    public class CustomViewHolder2 extends RecyclerView.ViewHolder {
        protected TextView titleTextview;
        protected TextView dataTextview;

        public CustomViewHolder2(View view) {
            super(view);
            this.titleTextview = (TextView) view.findViewById(R.id.DataTitleLeft);
            this.dataTextview = (TextView) view.findViewById(R.id.DataStringRight);
        }
    }
}
