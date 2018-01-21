package com.mortgagehotline.manager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mortgagehotline.manager.Adapter.ListDataAdapter.FragmentRVAdapter;
import com.mortgagehotline.manager.Adapter.MainDataAdapter.RecyclerItemClickListener;
import com.mortgagehotline.manager.Model.DataList.DataListType;
import com.mortgagehotline.manager.Support.RecyclerViewDividerItem;

import java.util.ArrayList;

public class ContactDetailsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private String AgtName;
    private String AgtIC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(true);


        Intent intentEx = getIntent();
        Bundle ExtractBundle = intentEx.getExtras();

        if (ExtractBundle != null) {
            if(!ExtractBundle.isEmpty()){

                AgtName = ExtractBundle.getString("AgentName");
                AgtIC = ExtractBundle.getString("AgentNewIC");
            }
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.contactdetails_recyclerview);
        setupListView(AgtName,AgtIC);

    }

    public void setupListView(String Name, String NewIC){

        ArrayList<DataListType> hDataListType = new ArrayList<>();

        DataListType hDataList1 = new DataListType(1,"Name",Name);  hDataListType.add(hDataList1);
        DataListType hDataList2 = new DataListType(1,"IC",NewIC);    hDataListType.add(hDataList2);
        DataListType hDataList3 = new DataListType(1,"Contact No.","6012-1234567");   hDataListType.add(hDataList3);
        DataListType hDataList4 = new DataListType(1,"Email","john@mortgage.my");     hDataListType.add(hDataList4);
        DataListType hDataList5 = new DataListType(1,"Address","Jalan Kuchai, 55100, Kuala Lumpur, Malaysia");    hDataListType.add(hDataList5);

        final FragmentRVAdapter fragmentRVAdapter = new FragmentRVAdapter(getApplicationContext(), hDataListType);               fragmentRVAdapter.notifyDataSetChanged();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), OrientationHelper.VERTICAL, false);
        RecyclerViewDividerItem dividerItem = new RecyclerViewDividerItem(mRecyclerView.getContext(),linearLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItem);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(fragmentRVAdapter);

        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), mRecyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                if(position == 2){
                    DataListType onclickItem = (DataListType) fragmentRVAdapter.getItem(position);
                    DataListType onclickItem2 = (DataListType) fragmentRVAdapter.getItem(0);

                    final String phoneNumber = onclickItem.getData();
                    String Name = onclickItem2.getData();

                    AlertDialog.Builder alert = new AlertDialog.Builder(ContactDetailsActivity.this);
                    alert.setMessage("Call " + Name + " ? " + phoneNumber)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(getApplicationContext(), "Calling "+ phoneNumber ,Toast.LENGTH_SHORT).show();

                  /*          String calldata = "tel:"+phoneNumber;
                            Intent callIntent = new Intent(Intent.ACTION_DIAL);
                            callIntent.setData(Uri.parse(calldata));
                            startActivity(callIntent);*/
                                }
                            })
                            .setNegativeButton("NO", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            })
                            .create()
                            .show();
                }
            }

            @Override
            public void onLongItemClick(View view, int position) {
                //Future Add longclick Call function
            }
        }));


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int actionID = item.getItemId();

        if(actionID == android.R.id.home){
            onBackPressed();
            return  true;
        }
        return false;
    }
}
