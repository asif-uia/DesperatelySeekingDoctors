package com.asif.dsdr.ui.coronaTestLab;

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

import com.asif.dsdr.R;
import com.asif.dsdr.ui.ambulance.ExpandableListAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class coronaTestLab extends Fragment {

    private List<String> listDataHeader;
    private HashMap<String, List<String>> listDataChild;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_corona_test_lab, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ExpandableListView expandableListView = view.findViewById(R.id.test_exp);
        final ExpandableListAdapter listAdapter;

        prepareListData();

        listAdapter = new ExpandableListAdapter(getContext(), listDataHeader, listDataChild);

        expandableListView.setAdapter(listAdapter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                for (int i = 0; i < listAdapter.getGroupCount(); i++) {
                    if (groupPosition == i)
                        childActionIntent(listDataChild.get(listDataHeader.get(i)).get(childPosition));
                }

                return false;
            }
        });
    }

    private void prepareListData() {
        listDataHeader = Arrays.asList(getResources().getStringArray(R.array.corona_labs));
        listDataChild = new HashMap<String, List<String>>();

        List<String> l = new ArrayList<String>();
        l.add("00");
        l.add("78");
        l.add("54");
        l.add("15");

        listDataChild.put(listDataHeader.get(0), l);
        listDataChild.put(listDataHeader.get(1), l);
    }

    private void childActionIntent(String tel) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + tel));
        startActivity(intent);
    }
}
