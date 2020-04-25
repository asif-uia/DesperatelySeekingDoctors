package com.asif.dsdr.ui.ambulance;

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

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Rangpur extends Fragment {
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listDataChild;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rangpur, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ExpandableListView expandableListView = view.findViewById(R.id.rang_exp);
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
        listDataHeader = Arrays.asList(getResources().getStringArray(R.array.Rangpur));
        listDataChild = new HashMap<>();

        listDataChild.put(listDataHeader.get(0), Arrays.asList(getResources().getStringArray(R.array.r1)));
        listDataChild.put(listDataHeader.get(1), Arrays.asList(getResources().getStringArray(R.array.r2)));
        listDataChild.put(listDataHeader.get(2), Arrays.asList(getResources().getStringArray(R.array.r3)));
        listDataChild.put(listDataHeader.get(3), Arrays.asList(getResources().getStringArray(R.array.r4)));
        listDataChild.put(listDataHeader.get(4), Arrays.asList(getResources().getStringArray(R.array.r5)));
        listDataChild.put(listDataHeader.get(5), Arrays.asList(getResources().getStringArray(R.array.r6)));
        listDataChild.put(listDataHeader.get(6), Arrays.asList(getResources().getStringArray(R.array.r7)));
        listDataChild.put(listDataHeader.get(7), Arrays.asList(getResources().getStringArray(R.array.r8)));
        listDataChild.put(listDataHeader.get(8), Arrays.asList(getResources().getStringArray(R.array.r9)));
        listDataChild.put(listDataHeader.get(9), Arrays.asList(getResources().getStringArray(R.array.r10)));
    }

    private void childActionIntent(String tel) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + tel));
        startActivity(intent);
    }
}
