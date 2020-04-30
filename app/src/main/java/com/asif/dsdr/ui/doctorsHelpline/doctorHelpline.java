package com.asif.dsdr.ui.doctorsHelpline;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.asif.dsdr.R;

import java.util.ArrayList;
import java.util.Objects;

public class doctorHelpline extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Objects.requireNonNull(((AppCompatActivity) requireActivity())
                .getSupportActionBar())
                .setTitle("ডক্টরস হেল্পলাইন");

        return inflater.inflate(R.layout.fragment_doctors, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final ArrayList<itemResource> arrayList = new ArrayList<>();

        String[] doc = {"Doctor 1 (Call / Whatsapp)", "Doctor 2 (Call / Whatsapp)", "Doctor 3 (Call / Whatsapp)",
                "Doctor 4 (Call / Whatsapp)", "Doctor 5 (Call / Whatsapp)", "Doctor 6 (Call / Whatsapp)",
                "Doctor 7 (Call / Whatsapp)", "Doctor 8 (Call / Whatsapp)", "Doctor 9 (Call / Whatsapp)",
                "Doctor 10 (Call / Whatsapp)"};
        String[] no = {"01767012127", "01537236046", "01832481701",
                "01908528959", "01832481802", "01708335928",
                "01635746803", "01533019995", "01722723396",
                "01882446277"};

        for (int i = 0; i < doc.length; i++) {
            arrayList.add(new itemResource(doc[i], no[i]));
        }

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView1);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        itemAdapter adapter = new itemAdapter(arrayList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new itemAdapter.MyClickListener() {
            @Override
            public void onPhoneCall(int p) {
                String s = arrayList.get(p).getText2();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + s));
                startActivity(intent);
            }

            @Override
            public void onWhatsapp(int p) {
                sendtoWhatsapp(arrayList.get(p).getText2());
            }
        });


    }

    private void sendtoWhatsapp(String num) {
        PackageManager pm = requireContext().getPackageManager();
        boolean i;
        try {
            pm.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES);
            i = true;
        } catch (PackageManager.NameNotFoundException e) {
            i = false;
            e.printStackTrace();
        }

        if (i) {
            Uri uri = Uri.parse("smsto:" + num);
            Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
            //intent.setType("text/plain");
            intent.setPackage("com.whatsapp");
            startActivity(Intent.createChooser(intent, ""));
        } else {
            Toast.makeText(getContext(), "Whatsapp Not Installed!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Objects.requireNonNull(((AppCompatActivity) requireActivity())
                .getSupportActionBar())
                .setTitle(getString(R.string.menu_home));
    }
}
