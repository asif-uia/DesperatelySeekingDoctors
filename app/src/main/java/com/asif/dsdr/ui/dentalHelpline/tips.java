package com.asif.dsdr.ui.dentalHelpline;

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

public class tips extends Fragment {
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listDataChild;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dentaltips, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ExpandableListView expandableListView = view.findViewById(R.id.dental_tips_exp);
        final dentalExpandableListAdapter adapter;

        prepareListData();

        adapter = new dentalExpandableListAdapter(getContext(), listDataHeader, listDataChild);
        expandableListView.setAdapter(adapter);
    }

    private void prepareListData() {
        listDataHeader = Arrays.asList(getResources().getStringArray(R.array.dentaltips));
        listDataChild = new HashMap<>();

        listDataChild.put(listDataHeader.get(0), Arrays.asList(getResources().getStringArray(R.array.gin)));
        listDataChild.put(listDataHeader.get(1), Arrays.asList(getResources().getStringArray(R.array.hal)));
    }
}
