package com.asif.dsdr.ui.healthTips;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.asif.dsdr.R;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class healthTipsMain extends Fragment {

    private List<String> listDataHeader;
    private HashMap<String, List<String>> listDataChild;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Objects.requireNonNull(((AppCompatActivity) requireActivity())
                .getSupportActionBar())
                .setTitle("হেলথ টিপস");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_health_tips_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ExpandableListView expandableListView = view.findViewById(R.id.tips_exp);
        final healthExpandableListAdapter adapter;

        prepareListData();

        adapter = new healthExpandableListAdapter(getContext(), listDataHeader, listDataChild);

        expandableListView.setAdapter(adapter);
    }

    private void prepareListData() {
        listDataHeader = Arrays.asList(getResources().getStringArray(R.array.tips));
        listDataChild = new HashMap<>();

        listDataChild.put(listDataHeader.get(0), Arrays.asList(getResources().getStringArray(R.array.diab1)));
        listDataChild.put(listDataHeader.get(1), Arrays.asList(getResources().getStringArray(R.array.diab2)));
        listDataChild.put(listDataHeader.get(2), Arrays.asList(getResources().getStringArray(R.array.migr)));
        listDataChild.put(listDataHeader.get(3), Arrays.asList(getResources().getStringArray(R.array.burnt)));
        listDataChild.put(listDataHeader.get(4), Arrays.asList(getResources().getStringArray(R.array.bedsore)));
        listDataChild.put(listDataHeader.get(5), Arrays.asList(getResources().getStringArray(R.array.skin)));
        listDataChild.put(listDataHeader.get(6), Arrays.asList(getResources().getStringArray(R.array.diahr)));
        listDataChild.put(listDataHeader.get(7), Arrays.asList(getResources().getStringArray(R.array.kosh)));
        listDataChild.put(listDataHeader.get(8), Arrays.asList(getResources().getStringArray(R.array.gha)));
        listDataChild.put(listDataHeader.get(9), Arrays.asList(getResources().getStringArray(R.array.urine_p)));
        listDataChild.put(listDataHeader.get(10), Arrays.asList(getResources().getStringArray(R.array.gastric)));
        listDataChild.put(listDataHeader.get(11), Arrays.asList(getResources().getStringArray(R.array.sleep_hyg)));
        listDataChild.put(listDataHeader.get(12), Arrays.asList(getResources().getStringArray(R.array.komor)));
        listDataChild.put(listDataHeader.get(13), Arrays.asList(getResources().getStringArray(R.array.canula)));
        listDataChild.put(listDataHeader.get(14), Arrays.asList(getResources().getStringArray(R.array.cough_cold)));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Objects.requireNonNull(((AppCompatActivity) requireActivity())
                .getSupportActionBar())
                .setTitle(getString(R.string.menu_home));
    }
}
