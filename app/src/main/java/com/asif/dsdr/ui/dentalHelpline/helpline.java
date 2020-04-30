package com.asif.dsdr.ui.dentalHelpline;

import android.content.Intent;
import android.net.Uri;
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

public class helpline extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dentalhelpline, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final ArrayList<dentalResource> arrayList = new ArrayList<>();

        String[] doc = getResources().getStringArray(R.array.teledentists);
        String[] no = getResources().getStringArray(R.array.teledentist_no);

        for (int i = 0; i < doc.length; i++) {
            arrayList.add(new dentalResource(doc[i], no[i]));
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
}
