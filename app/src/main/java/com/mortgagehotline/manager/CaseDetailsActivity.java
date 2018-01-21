package com.mortgagehotline.manager;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class CaseDetailsActivity extends AppCompatActivity {

    private GeneralFragment hgeneralFragment = new GeneralFragment();
    private PurchaserFragment hpurchaserFragment = new PurchaserFragment();
    private CheckListFragment hcheckListFragment = new CheckListFragment();

    private String ReferenceID;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentManager = getSupportFragmentManager();

            if (hgeneralFragment.isAdded() && hpurchaserFragment.isAdded() && hcheckListFragment.isAdded()) {
                Fragment.SavedState pgeneralFragment = fragmentManager.saveFragmentInstanceState(hgeneralFragment);
                Fragment.SavedState ppurhcaserFragment = fragmentManager.saveFragmentInstanceState(hpurchaserFragment);
                Fragment.SavedState pcheckpistFragment = fragmentManager.saveFragmentInstanceState(hcheckListFragment);

                hgeneralFragment = new GeneralFragment();
                hgeneralFragment.setInitialSavedState(pgeneralFragment);
                hpurchaserFragment = new PurchaserFragment();
                hpurchaserFragment.setInitialSavedState(ppurhcaserFragment);
                hcheckListFragment = new CheckListFragment();
                hcheckListFragment.setInitialSavedState(pcheckpistFragment);

            }


            FragmentTransaction navFragment = fragmentManager.beginTransaction();
            navFragment.replace(R.id.fragmentGeneral, hgeneralFragment);
            navFragment.replace(R.id.fragmentPurchase, hpurchaserFragment);
            navFragment.replace(R.id.fragmentCheckList, hcheckListFragment);
            navFragment.commit();

            switch (item.getItemId()) {
                case R.id.navigation_general:
                    //navFragment.replace(R.id.fragmentMain,new GeneralFragment()).commit();
                    navFragment.show(hgeneralFragment);
                    navFragment.hide(hpurchaserFragment);
                    navFragment.hide(hcheckListFragment);
                    return true;
                case R.id.navigation_purchaser:
                    navFragment.hide(hgeneralFragment);
                    navFragment.show(hpurchaserFragment);
                    navFragment.hide(hcheckListFragment);
                    return true;
                case R.id.navigation_checklist:
                    navFragment.hide(hgeneralFragment);
                    navFragment.hide(hpurchaserFragment);
                    navFragment.show(hcheckListFragment);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_details);

        Intent intentEx = getIntent();
        Bundle ExtractBundle = intentEx.getExtras();

        if (ExtractBundle != null) {
            if (!ExtractBundle.isEmpty()) {

                ReferenceID = ExtractBundle.getString("RID");
            }

            ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(ReferenceID);

            BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
            navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragmentGeneral, new GeneralFragment()).commit();

        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int actionID = item.getItemId();

        if(actionID == android.R.id.home){
            onBackPressed();
            return true;

        }
        return false;
    }

}