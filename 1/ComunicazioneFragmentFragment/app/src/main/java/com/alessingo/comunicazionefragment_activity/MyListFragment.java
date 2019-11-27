package com.alessingo.comunicazionefragment_activity;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyListFragment extends ListFragment {

    private List<String> list;
    private OnMyListListner onMyListListner;

    public interface OnMyListListner {
        void onElementSelected(int pos);
    }

    public MyListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        list = new ArrayList<>();

        list.add("primo");
        list.add("secondo");
        list.add("terzo");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, list);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        onMyListListner.onElementSelected(position);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            onMyListListner = (OnMyListListner) context;
        } catch (ClassCastException e) {
            throw new ClassCastException("Devi implementare l'interfaccia");
        }
    }
}
