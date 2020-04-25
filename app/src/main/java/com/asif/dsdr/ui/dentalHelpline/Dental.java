package com.asif.dsdr.ui.dentalHelpline;

import android.content.Intent;
import android.net.Uri;
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

import java.util.ArrayList;
import java.util.Objects;

import com.asif.dsdr.R;

public class Dental extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setTitle("Dentists Helpline");
        return inflater.inflate(R.layout.fragment_dental, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final ArrayList<dentalResource> arrayList = new ArrayList<>();

        String []doc = getResources().getStringArray(R.array.teledentists);
        String []no = getResources().getStringArray(R.array.teledentist_no);

        for (int i = 0; i < doc.length; i++) {
            arrayList.add(new dentalResource(R.drawable.ic_tooth, R.drawable.ic_phone, doc[i], no[i]));
        }

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView4);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        dentalAdapter adapter = new dentalAdapter(arrayList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new dentalAdapter.onItemClickListener() {
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
        Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setTitle(getString(R.string.menu_home));
    }
}