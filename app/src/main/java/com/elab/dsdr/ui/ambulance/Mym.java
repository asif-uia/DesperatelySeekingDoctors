package com.elab.dsdr.ui.ambulance;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.elab.dsdr.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Mym extends Fragment {
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listDataChild;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mym, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ExpandableListView expandableListView = view.findViewById(R.id.mym_exp);
        final ExpandableListAdapter listAdapter;

        prepareListData();

        listAdapter = new ExpandableListAdapter(getContext(), listDataHeader, listDataChild);

        expandableListView.setAdapter(listAdapter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                for (int i = 0; i < listAdapter.getGroupCount(); i++) {
                    if (groupPosition == i)
                        childActionIntent(Objects.requireNonNull(listDataChild.get(listDataHeader.get(i))).get(childPosition));
                }

                return false;
            }
        });
    }

    private void prepareListData() {
        listDataChild = new HashMap<>();

        listDataHeader = Arrays.asList(getResources().getStringArray(R.array.mymen));

        List<String> l1 = new ArrayList<>();
        l1.add("52291");

        List<String> l2 = new ArrayList<>();
        l2.add("55840");

        List<String> l3 = new ArrayList<>();
        l3.add("61765");

        List<String> l4 = new ArrayList<>();
        l4.add("63400");

        List<String> l5 = new ArrayList<>();
        l5.add("01717-209005");

        List<String> l6 = new ArrayList<>();
        l6.add("01955933510");


        listDataChild.put(listDataHeader.get(0), l1);
        listDataChild.put(listDataHeader.get(1), l2);
        listDataChild.put(listDataHeader.get(2), l3);
        listDataChild.put(listDataHeader.get(3), l4);
        listDataChild.put(listDataHeader.get(4), l5);
        listDataChild.put(listDataHeader.get(5), l6);
    }

    private void childActionIntent(String tel) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + tel));
        startActivity(intent);
    }
}

