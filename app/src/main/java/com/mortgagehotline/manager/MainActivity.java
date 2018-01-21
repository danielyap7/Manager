package com.mortgagehotline.manager;

import android.support.v7.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.mortgagehotline.manager.Adapter.MainDataAdapter.RecyclerItemClickListener;
import com.mortgagehotline.manager.Adapter.MainDataAdapter.RvAdapter;
import com.mortgagehotline.manager.Model.CaseInfo.Case;
import com.mortgagehotline.manager.Support.RecyclerViewDividerItem;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ArrayList<Case> caseList;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // ActionBar mActionBar = getSupportActionBar();
      //  mActionBar.setDisplayShowTitleEnabled(true);
      //  mActionBar.setTitle("Cases Many Cases");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);




        rv = findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);

        rv.setLayoutManager(llm);
        initializeData();
        initializeAdapter();

        rv.addOnItemTouchListener(
                new RecyclerItemClickListener(this, rv ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {

                        RvAdapter rvAdapter = new RvAdapter(caseList);
                        Case caseItem = rvAdapter.getItem(position);

                        String ReferenceID = caseItem.getL1();

                        Bundle contactBundle = new Bundle();
                        contactBundle.putString("RID",ReferenceID);

                        Intent intentbundle = new Intent(getApplicationContext(),CaseDetailsActivity.class);
                        intentbundle.putExtras(contactBundle);
                        startActivity(intentbundle);


                    }

                    @Override public void onLongItemClick(View view, int position) {
                    }
                })
        );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent = new Intent(MainActivity.this, Profile_Activity.class);
        startActivity(intent);

        return true;
    }



        private void initializeData(){

            caseList = new ArrayList<>();

            caseList.add(new Case("A12345", "Project Name ABC", "Anna Dome", "15 December 2017", "In Progress"));

            caseList.add(new Case("A12345", "Project Name ABC", "Anna Dome", "15 December 2017", "In Progress"));
            caseList.add(new Case("A12345", "Project Name ABC", "Anna Dome", "15 December 2017", "In Progress"));
            caseList.add(new Case("A12345", "Project Name ABC", "Anna Dome", "15 December 2017", "In Progress"));
            caseList.add(new Case("A12345", "Project Name ABC", "Anna Dome", "15 December 2017", "In Progress"));
            caseList.add(new Case("A12345", "Project Name ABC", "Anna Dome", "15 December 2017", "In Progress"));
            caseList.add(new Case("A12345", "Project Name ABC", "Anna Dome", "15 December 2017", "In Progress"));
            caseList.add(new Case("A12345", "Project Name ABC", "Anna Dome", "15 December 2017", "In Progress"));
            caseList.add(new Case("A12345", "Project Name ABC", "Anna Dome", "15 December 2017", "In Progress"));
            caseList.add(new Case("A12345", "Project Name ABC", "Anna Dome", "15 December 2017", "In Progress"));
            caseList.add(new Case("A12345", "Project Name ABC", "Anna Dome", "15 December 2017", "In Progress"));
            caseList.add(new Case("A12345", "Project Name ABC", "Anna Dome", "15 December 2017", "In Progress"));
            caseList.add(new Case("A12345", "Project Name ABC", "Anna Dome", "15 December 2017", "In Progress"));


    }

    private void initializeAdapter(){

        RvAdapter adapter = new RvAdapter(caseList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(rv.getContext(), OrientationHelper.VERTICAL, false);
        RecyclerViewDividerItem dividerItem = new RecyclerViewDividerItem(rv.getContext(),linearLayoutManager.getOrientation());
        rv.addItemDecoration(dividerItem);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(adapter);



    }
}
