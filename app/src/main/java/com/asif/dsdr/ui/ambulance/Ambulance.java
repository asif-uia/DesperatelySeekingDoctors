package com.asif.dsdr.ui.ambulance;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.asif.dsdr.R;
import com.asif.dsdr.ui.coronacell.PagerAdapter;
import com.google.android.material.tabs.TabLayout;


public class Ambulance extends Fragment {
    private ViewPager viewPager;
    private TabLayout tabLayout;

    private PagerAdapter pagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((AppCompatActivity) requireActivity()).getSupportActionBar().setTitle(getString(R.string.emergency_amb));
        return inflater.inflate(R.layout.fragment_ambulance, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewPager = view.findViewById(R.id.pager2);
        tabLayout = view.findViewById(R.id.tablayout2);
        pagerAdapter = new PagerAdapter(getChildFragmentManager());

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ((AppCompatActivity) requireActivity()).getSupportActionBar().setTitle(getString(R.string.menu_home));
    }

    private void setupViewPager(androidx.viewpager.widget.ViewPager viewPager) {
        PagerAdapter pagerAdapter = new PagerAdapter(getChildFragmentManager());
        pagerAdapter.addFragment(new Dhaka(), getString(R.string.dhk));
        pagerAdapter.addFragment(new Chittagong(), getString(R.string.ctg));
        pagerAdapter.addFragment(new Rajshahi(), getString(R.string.raj));
        pagerAdapter.addFragment(new Khulna(), getString(R.string.khu));
        pagerAdapter.addFragment(new Borishal(), getString(R.string.bor));
        pagerAdapter.addFragment(new Sylhet(), getString(R.string.syl));
        pagerAdapter.addFragment(new Rangpur(), getString(R.string.rang));
        pagerAdapter.addFragment(new Mym(), getString(R.string.mym));
        viewPager.setAdapter(pagerAdapter);
    }

}
