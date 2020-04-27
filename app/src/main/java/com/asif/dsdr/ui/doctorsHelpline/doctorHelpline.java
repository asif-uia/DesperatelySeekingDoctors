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
import com.asif.dsdr.itemAdapter;
import com.asif.dsdr.itemResource;

import java.util.ArrayList;
import java.util.Objects;

public class doctorHelpline extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Objects.requireNonNull(((AppCompatActivity) Objects.requireNonNull(getActivity()))
                .getSupportActionBar())
                .setTitle(getString(R.string.doctors_help));

        return inflater.inflate(R.layout.fragment_doctors, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final ArrayList<com.asif.dsdr.itemResource> arrayList = new ArrayList<>();

        String[] doc = {"Doctor 1 (Call / Whatsapp)", "Doctor 2 (Call / Whatsapp)", "Doctor 3 (Call / Whatsapp)",
                "Doctor 4 (Call / Whatsapp)", "Doctor 5 (Call / Whatsapp)", "Doctor 6 (Call / Whatsapp)",
                "Doctor 7 (Call / Whatsapp)", "Doctor 8 (Call / Whatsapp)", "Doctor 9 (Call / Whatsapp)",
                "Doctor 10 (Call / Whatsapp)"};
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
        com.asif.dsdr.itemAdapter adapter = new com.asif.dsdr.itemAdapter(arrayList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new itemAdapter.MyClickListener() {
            @Override
            public void onEdit(int p) {
                //String s = arrayList.get(p).getText2();
                //Toast.makeText(getContext(), "Whatsapp", Toast.LENGTH_LONG).show();
                String s = arrayList.get(p).getText2();
                //Toast.makeText(getContext(), s, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + s));
                startActivity(intent);
            }

            @Override
            public void onDelete(int p) {
                sendtoWhatsapp(arrayList.get(p).getText2());
            }
        });


    }

    private void sendtoWhatsapp(String num) {
        PackageManager pm = Objects.requireNonNull(getContext()).getPackageManager();
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
        Objects.requireNonNull(((AppCompatActivity) Objects.requireNonNull(getActivity()))
                .getSupportActionBar())
                .setTitle(getString(R.string.menu_home));
    }
}
