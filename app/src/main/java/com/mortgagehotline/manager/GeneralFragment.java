package com.mortgagehotline.manager;

import android.content.Context;
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

import com.mortgagehotline.manager.Adapter.ListDataAdapter.FragmentRVAdapter;
import com.mortgagehotline.manager.Model.DataList.DataListType;
import com.mortgagehotline.manager.Support.RecyclerViewDividerItem_MultiViewHolder;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GeneralFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GeneralFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GeneralFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private RecyclerView mRecyclerView;


    public GeneralFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GeneralFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GeneralFragment newInstance(String param1, String param2) {
        GeneralFragment fragment = new GeneralFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public void setupListview(){

      ArrayList<DataListType> arrayList1 = new ArrayList<>();


        DataListType dList1 = new DataListType(1,"Reference No.","A12345");               arrayList1.add(dList1);
        DataListType dList2 = new DataListType(1,"Open Date","1 December 2017");          arrayList1.add(dList2);
        DataListType dList3 = new DataListType(1,"File Type","Subsale SNP");              arrayList1.add(dList3);
        DataListType dList4 = new DataListType(1, "SPA Lawyer","Lawyer A");                arrayList1.add(dList4);
        DataListType dList5 = new DataListType(1, "Vendor Lawyer","Vendor Lawyer A");      arrayList1.add(dList5);
        DataListType dTitleList = new DataListType(0,"Property Details","");                arrayList1.add(dTitleList);
        DataListType dList6 = new DataListType(1,"Developer Name","Tropicana Crop");      arrayList1.add(dList6);
        DataListType dList7 = new DataListType(1,"Project Name","Project A");             arrayList1.add(dList7);

        DataListType dList8 = new DataListType(2,"Phase/Block","A");                      arrayList1.add(dList8);
        DataListType dList9 = new DataListType(2,"Lot No.","08");                         arrayList1.add(dList9);
        DataListType dList10 = new DataListType(2,"Price","RM 1,000,000");                arrayList1.add(dList10);
        DataListType dList11 = new DataListType(2,"Title","Master");                      arrayList1.add(dList11);
        DataListType dList12 = new DataListType(2,"Tenure","Freehold");                   arrayList1.add(dList12);

        DataListType dList13 = new DataListType(1,"Agent","John Smith");                  arrayList1.add(dList13);
        DataListType dList14 = new DataListType(1,"Banker","John Smith");                 arrayList1.add(dList14);
        DataListType dTitleList1 = new DataListType(0,"Bank Details","");                arrayList1.add(dTitleList1);
        DataListType dList15 = new DataListType(1,"Bank Name","RHB Bank");                arrayList1.add(dList15);
        DataListType dList16 = new DataListType(1,"Bank Reference","A123456");            arrayList1.add(dList16);
        DataListType dList17 = new DataListType(1,"Branch","Tun Razak");                  arrayList1.add(dList17);
        DataListType dList18 = new DataListType(1,"Facility Type","Islamic Loan");        arrayList1.add(dList18);

        DataListType dList19 = new DataListType(2,"Loan Amount","Rm 1");                  arrayList1.add(dList19);
        DataListType dList20 = new DataListType(2,"Letter Offer Date","01 December 2017");arrayList1.add(dList20);
        DataListType dList21 = new DataListType(2,"Letter Instruc. Date","01 December 2017`"); arrayList1.add(dList21);



        FragmentRVAdapter recyclerviewAdapter = new FragmentRVAdapter(getContext(),arrayList1);        recyclerviewAdapter.notifyDataSetChanged();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), OrientationHelper.VERTICAL, false);
        RecyclerViewDividerItem_MultiViewHolder dividerItem = new RecyclerViewDividerItem_MultiViewHolder(getContext(),linearLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItem);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(recyclerviewAdapter);


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
        View view = inflater.inflate(R.layout.fragment_general, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.general_recyclerview);

        setupListview();

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
