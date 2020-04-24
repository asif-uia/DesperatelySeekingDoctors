package com.asif.dsdr.ui.doctorsHelpline;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asif.dsdr.R;

import java.util.ArrayList;
import java.util.Objects;

public class doctorHelpline extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Objects.requireNonNull(((AppCompatActivity) Objects.requireNonNull(getActivity()))
                .getSupportActionBar())
                .setTitle(getString(R.string.doctors_help));

        return inflater.inflate(R.layout.fragment_doctors, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final ArrayList<itemResource> arrayList = new ArrayList<>();

        String[] doc = {"Doctor 1", "Doctor 2", "Doctor 3",
                "Doctor 4", "Doctor 5", "Doctor 6",
                "Doctor 7", "Doctor 8", "Doctor 9",
                "Doctor 10"};
        String[] no = {"01767012127", "01537236046", "01832481701",
                "01908528959", "01832481802", "01708335928",
                "01635746803", "01533019995", "01722723396",
                "01882446277"};

        for (int i = 0; i < doc.length; i++) {
            arrayList.add(new itemResource(R.drawable.ic_doctor, R.drawable.ic_phone, doc[i], no[i]));
        }

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView1);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        itemAdapter adapter = new itemAdapter(arrayList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new itemAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //System.out.println(arrayList.get(position).getText2());
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:" + arrayList.get(position).getText2()));
                startActivity(i);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Objects.requireNonNull(((AppCompatActivity) Objects.requireNonNull(getActivity()))
                .getSupportActionBar())
                .setTitle(getString(R.string.menu_home));
    }
}
