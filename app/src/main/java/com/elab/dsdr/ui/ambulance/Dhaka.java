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

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Dhaka extends Fragment {

    private List<String> listDataHeader;
    private HashMap<String, List<String>> listDataChild;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dhaka, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ExpandableListView expandableListView = view.findViewById(R.id.dhk_exp);
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
        listDataHeader = Arrays.asList(getResources().getStringArray(R.array.Dhaka));
        listDataChild = new HashMap<>();

        listDataChild.put(listDataHeader.get(0), Arrays.asList(getResources().getStringArray(R.array.dhk1)));
        listDataChild.put(listDataHeader.get(1), Arrays.asList(getResources().getStringArray(R.array.dhk2)));
        listDataChild.put(listDataHeader.get(2), Arrays.asList(getResources().getStringArray(R.array.dhk3)));
        listDataChild.put(listDataHeader.get(3), Arrays.asList(getResources().getStringArray(R.array.dhk4)));
        listDataChild.put(listDataHeader.get(4), Arrays.asList(getResources().getStringArray(R.array.dhk5)));
        listDataChild.put(listDataHeader.get(5), Arrays.asList(getResources().getStringArray(R.array.dhk6)));
        listDataChild.put(listDataHeader.get(6), Arrays.asList(getResources().getStringArray(R.array.dhk7)));
        listDataChild.put(listDataHeader.get(7), Arrays.asList(getResources().getStringArray(R.array.dhk8)));
        listDataChild.put(listDataHeader.get(8), Arrays.asList(getResources().getStringArray(R.array.dhk9)));
        listDataChild.put(listDataHeader.get(9), Arrays.asList(getResources().getStringArray(R.array.dhk10)));
        listDataChild.put(listDataHeader.get(10), Arrays.asList(getResources().getStringArray(R.array.dhk11)));
        listDataChild.put(listDataHeader.get(11), Arrays.asList(getResources().getStringArray(R.array.dhk12)));
        listDataChild.put(listDataHeader.get(12), Arrays.asList(getResources().getStringArray(R.array.dhk13)));
        listDataChild.put(listDataHeader.get(13), Arrays.asList(getResources().getStringArray(R.array.dhk14)));
        listDataChild.put(listDataHeader.get(14), Arrays.asList(getResources().getStringArray(R.array.dhk15)));
        listDataChild.put(listDataHeader.get(15), Arrays.asList(getResources().getStringArray(R.array.dhk16)));
        listDataChild.put(listDataHeader.get(16), Arrays.asList(getResources().getStringArray(R.array.dhk17)));
        listDataChild.put(listDataHeader.get(17), Arrays.asList(getResources().getStringArray(R.array.dhk18)));
        listDataChild.put(listDataHeader.get(18), Arrays.asList(getResources().getStringArray(R.array.dhk19)));
        listDataChild.put(listDataHeader.get(19), Arrays.asList(getResources().getStringArray(R.array.dhk20)));
        listDataChild.put(listDataHeader.get(20), Arrays.asList(getResources().getStringArray(R.array.dhk21)));
        listDataChild.put(listDataHeader.get(21), Arrays.asList(getResources().getStringArray(R.array.dhk22)));
        listDataChild.put(listDataHeader.get(22), Arrays.asList(getResources().getStringArray(R.array.dhk23)));
        listDataChild.put(listDataHeader.get(23), Arrays.asList(getResources().getStringArray(R.array.dhk24)));
        listDataChild.put(listDataHeader.get(24), Arrays.asList(getResources().getStringArray(R.array.dhk25)));
        listDataChild.put(listDataHeader.get(25), Arrays.asList(getResources().getStringArray(R.array.dhk26)));
        listDataChild.put(listDataHeader.get(26), Arrays.asList(getResources().getStringArray(R.array.dhk27)));
    }

    private void childActionIntent(String tel) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + tel));
        startActivity(intent);
    }
}
