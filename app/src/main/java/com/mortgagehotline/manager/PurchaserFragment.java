package com.mortgagehotline.manager;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mortgagehotline.manager.Adapter.ListDataAdapter.FragmentRVAdapter;
import com.mortgagehotline.manager.Adapter.MainDataAdapter.RecyclerItemClickListener;
import com.mortgagehotline.manager.Model.DataList.DataListType;
import com.mortgagehotline.manager.Support.RecyclerViewDividerItem_MultiViewHolder;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PurchaserFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PurchaserFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PurchaserFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private RecyclerView mRecyclerView;


    public PurchaserFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PurchaserFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PurchaserFragment newInstance(String param1, String param2) {
        PurchaserFragment fragment = new PurchaserFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public void setupListView(){

        ArrayList<DataListType> arrayList = new ArrayList<>();

        DataListType dTitleList = new DataListType(0,"Purchaser","");                arrayList.add(dTitleList);
        DataListType dList1 = new DataListType(1,"Peter Smith","810101-01-1234");               arrayList.add(dList1);
        DataListType dList2 = new DataListType(1,"Peter Smith","810101-01-1234");               arrayList.add(dList2);
        DataListType dList3 = new DataListType(1,"Peter Smith","810101-01-4321");               arrayList.add(dList3);
        DataListType dTitleList2 = new DataListType(0,"Borrower","");                arrayList.add(dTitleList2);
        DataListType dList4 = new DataListType(1,"Peter Smith","810101-01-1234");               arrayList.add(dList4);
        DataListType dList5 = new DataListType(1,"Peter Smith","810101-01-1234");               arrayList.add(dList5);
        DataListType dList6 = new DataListType(1,"Peter Smith","810101-01-5566");               arrayList.add(dList6);
        DataListType dTitleList3 = new DataListType(0,"Vendor","");                arrayList.add(dTitleList3);
        DataListType dList7 = new DataListType(1,"Peter Smith","810101-01-1234");               arrayList.add(dList7);
        DataListType dList8 = new DataListType(1,"Peter Smith","810101-01-1234");               arrayList.add(dList8);
        DataListType dList9 = new DataListType(1,"Peter Smith","810101-01-1234");               arrayList.add(dList9);

        final FragmentRVAdapter fragmentRVAdapter = new FragmentRVAdapter(getContext(), arrayList);               fragmentRVAdapter.notifyDataSetChanged();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), OrientationHelper.VERTICAL, false);
        RecyclerViewDividerItem_MultiViewHolder dividerItem = new RecyclerViewDividerItem_MultiViewHolder(getContext(),linearLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItem);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), mRecyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                if(position == 0 || position == 4 || position == 8){

                }else{

                    DataListType agentContact = fragmentRVAdapter.getItem(position);

                    String AgentName = agentContact.getTitle();
                    String AgentNewIC = agentContact.getData();
                    Bundle contactBundle = new Bundle();
                    contactBundle.putString("AgentName",AgentName);
                    contactBundle.putString("AgentNewIC",AgentNewIC);

                    Intent intentbundle = new Intent(getActivity(),ContactDetailsActivity.class);
                    intentbundle.putExtras(contactBundle);
                    startActivity(intentbundle);
                    Toast.makeText(getContext(), "You clicked " + fragmentRVAdapter.getItem(position).getData() + " on row number " + position, Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onLongItemClick(View view, int position) {
                //Future Add longclick Call function
            }
        }));

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(fragmentRVAdapter);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_purchaser, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.purchase_recyclerview);


        setupListView();

        /*hListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> item, View view, int position, long id) {
                DataListType agentContact = (DataListType) item.getItemAtPosition(position);

                String AgentName = agentContact.getTitle();
                String AgentNewIC = agentContact.getData();
                Bundle contactBundle = new Bundle();
                contactBundle.putString("AgentName",AgentName);
                contactBundle.putString("AgentNewIC",AgentNewIC);

                Intent intentbundle = new Intent(getActivity(),ContactDetailsActivity.class);
                intentbundle.putExtras(contactBundle);
                startActivity(intentbundle);
            }
        });*/

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
