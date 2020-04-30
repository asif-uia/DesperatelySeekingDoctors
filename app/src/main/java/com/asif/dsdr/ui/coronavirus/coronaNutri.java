package com.asif.dsdr.ui.coronavirus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.asif.dsdr.R;

import java.util.ArrayList;

public class coronaNutri extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_corona_nutri, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<itemResource> arrayList = new ArrayList<>();
        arrayList.add(new itemResource(getString(R.string.pus1)));
        arrayList.add(new itemResource(getString(R.string.pus2)));
        arrayList.add(new itemResource(getString(R.string.pus3)));
        arrayList.add(new itemResource(getString(R.string.pus4)));
        arrayList.add(new itemResource(getString(R.string.pus5)));
        arrayList.add(new itemResource(getString(R.string.pus6)));

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView_nutri);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        itemAdapter adapter = new itemAdapter(arrayList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


    }
}
