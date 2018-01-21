package com.mortgagehotline.manager.Adapter.MainDataAdapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mortgagehotline.manager.Model.CaseInfo.Case;
import com.mortgagehotline.manager.R;

import java.util.ArrayList;


public class RvAdapter extends RecyclerView.Adapter<RvAdapter.TaskViewHolder> {


    class TaskViewHolder extends RecyclerView.ViewHolder {


        TextView L1;
        TextView L2;
        TextView L3;
        TextView R1;
        TextView R2;

        TaskViewHolder(View itemView) {
            super(itemView);

            L1 = (TextView)itemView.findViewById(R.id.L1);

            L2 = (TextView)itemView.findViewById(R.id.L2);

            L3 = (TextView)itemView.findViewById(R.id.L3);

            R1 = (TextView)itemView.findViewById(R.id.R1);

            R2 = (TextView)itemView.findViewById(R.id.R2);

        }


    }


    private ArrayList<Case> Caselist;

    public RvAdapter(ArrayList<Case> Caselist){

        this.Caselist = Caselist;

    }

    @Override
    public RvAdapter.TaskViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview, viewGroup, false);
        TaskViewHolder pvh = new TaskViewHolder(v);

        return pvh;
    }

    @Override
    public void onBindViewHolder(TaskViewHolder personViewHolder, int i) {

        personViewHolder.L1.setText(Caselist.get(i).getL1());

        personViewHolder.L2.setText(Caselist.get(i).getL2());

        personViewHolder.L3.setText(Caselist.get(i).getL3());

        personViewHolder.R1.setText(Caselist.get(i).getR1());

        personViewHolder.R2.setText(Caselist.get(i).getR2());

    }


    @Override
    public int getItemCount() {
        return Caselist.size();
    }

    public Case getItem(int position){

        return Caselist.get(position);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


}
