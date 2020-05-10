package com.elab.dsdr.ui.bloodbank;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.elab.dsdr.R;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class bloodBank extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setTitle(getString(R.string.blood_bank));
        return inflater.inflate(R.layout.fragment_blood_bank, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewPager viewPager = view.findViewById(R.id.pager_blood);
        TabLayout tabLayout = view.findViewById(R.id.tablayout_blood);

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        PagerAdapter pagerAdapter = new PagerAdapter(getChildFragmentManager());
        pagerAdapter.addFragment(new dhaka_BB(), "ঢাকা বিভাগ");
        pagerAdapter.addFragment(new others_BB(), "অন্যান্য বিভাগসমূহ");

        viewPager.setAdapter(pagerAdapter);
    }
}
