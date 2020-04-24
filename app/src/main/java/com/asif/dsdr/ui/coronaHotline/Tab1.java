package com.asif.dsdr.ui.coronaHotline;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asif.dsdr.R;

import java.util.ArrayList;

public class Tab1 extends Fragment {
    private RecyclerView recyclerView;
    private hotlineAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final ArrayList<hotlineResource> arrayList = new ArrayList<>();
        arrayList.add(new hotlineResource(R.drawable.ic_phone, "333", getString(R.string.nat_help)));
        arrayList.add(new hotlineResource(R.drawable.ic_phone, "109", getString(R.string.nat_help2)));
        arrayList.add(new hotlineResource(R.drawable.ic_phone, "10655", getString(R.string.iedcr)));
        arrayList.add(new hotlineResource(R.drawable.ic_phone, "09611677777", getString(R.string.bissesoggo)));
        arrayList.add(new hotlineResource(R.drawable.ic_phone, "16263", getString(R.string.sastho)));

        recyclerView = view.findViewById(R.id.hotline1);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        adapter = new hotlineAdapter(arrayList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new hotlineAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:" + arrayList.get(position).getText1()));
                startActivity(i);
            }
        });
    }
}