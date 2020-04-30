package com.asif.dsdr.ui.zillaChambers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.asif.dsdr.R;

import java.util.ArrayList;
import java.util.Objects;

public class zillaChamber extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Objects.requireNonNull(((AppCompatActivity) requireActivity())
                .getSupportActionBar())
                .setTitle("জেলাভিত্তিক চেম্বারসমূহ");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_zilla_chamber, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<itemResource> arrayList = new ArrayList<>();

        arrayList.add(new itemResource(getString(R.string.zil0)));
        arrayList.add(new itemResource(getString(R.string.zil1)));
        arrayList.add(new itemResource(getString(R.string.zil2)));

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView_zilla);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        itemAdapter adapter = new itemAdapter(arrayList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Objects.requireNonNull(((AppCompatActivity) requireActivity())
                .getSupportActionBar())
                .setTitle(getString(R.string.menu_home));
    }
}
