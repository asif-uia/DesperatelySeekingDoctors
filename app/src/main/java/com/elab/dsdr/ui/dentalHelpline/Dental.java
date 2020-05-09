package com.elab.dsdr.ui.dentalHelpline;

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

public class Dental extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Objects.requireNonNull(((AppCompatActivity) requireActivity())
                .getSupportActionBar())
                .setTitle("ডেন্টাল কর্ণার");
        return inflater.inflate(R.layout.fragment_dental, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewPager viewPager = view.findViewById(R.id.pager_den);
        TabLayout tabLayout = view.findViewById(R.id.tablayout_den);
        //pagerAdapter = new PagerAdapter(getChildFragmentManager());

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        PagerAdapter pagerAdapter = new PagerAdapter(getChildFragmentManager());
        pagerAdapter.addFragment(new helpline(), "হেলপ লাইন");
        pagerAdapter.addFragment(new tips(), "দন্ত্য জিজ্ঞাসা");
        viewPager.setAdapter(pagerAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setTitle(getString(R.string.menu_home));
    }
}
