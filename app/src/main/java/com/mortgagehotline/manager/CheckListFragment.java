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

import com.mortgagehotline.manager.Adapter.ListDataAdapter.FragmentRVAdapter_CheckLIst;
import com.mortgagehotline.manager.Model.DataList.CheckListType;
import com.mortgagehotline.manager.Support.RecyclerViewDividerItem;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CheckListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CheckListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CheckListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private RecyclerView hRecyclerView;


    public CheckListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CheckListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CheckListFragment newInstance(String param1, String param2) {
        CheckListFragment fragment = new CheckListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public void setupListView(){

        ArrayList<CheckListType> arrayList = new ArrayList<>();

        CheckListType dList1 = new CheckListType("Check List1","1 December 2017", true,"The description of the check list for very long content. The description of the check list for very long content. The description of the check list for very long content. The description of the check list for very long content.The description of the check list for very long content.The description of the check list for very long content.");
        CheckListType dList2 = new CheckListType("Check List2", "1 December 2017", false, "The description of the check list for very long content. The description of the check list for very long content. The description of the check list for very long content. The description of the check list for very long content.The description of the check list for very long content.The description of the check list for very long content");
        CheckListType dList3 = new CheckListType("Check List3", "1 December 2017", true, "");

        arrayList.add(dList1); arrayList.add(dList2); arrayList.add(dList3);

        FragmentRVAdapter_CheckLIst recyclerviewAdapter = new FragmentRVAdapter_CheckLIst(getContext(),arrayList);   recyclerviewAdapter.notifyDataSetChanged();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), OrientationHelper.VERTICAL, false);
        RecyclerViewDividerItem dividerItem = new RecyclerViewDividerItem(getContext(),linearLayoutManager.getOrientation());
        hRecyclerView.addItemDecoration(dividerItem);
        hRecyclerView.setLayoutManager(linearLayoutManager);
        hRecyclerView.setItemAnimator(new DefaultItemAnimator());
        hRecyclerView.setAdapter(recyclerviewAdapter);


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

        View view = inflater.inflate(R.layout.fragment_check_list, container, false);

        hRecyclerView = (RecyclerView) view.findViewById(R.id.rvList_CheckItem);

        setupListView();

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
