package com.elab.dsdr.ui.emergencyHotline;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.elab.dsdr.R;
import com.google.android.material.tabs.TabLayout;

public class HotlineMain extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hot_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewPager viewPager = view.findViewById(R.id.pager3);
        setupViewPager(viewPager);

        TabLayout tabLayout = view.findViewById(R.id.tablayout3);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        PagerAdapter pagerAdapter = new PagerAdapter(getChildFragmentManager());
        pagerAdapter.addFragment(new emergency_defaultHotline(), getString(R.string.emergence_hot));
        pagerAdapter.addFragment(new testLab(), getString(R.string.test_lab));
        pagerAdapter.addFragment(new special_hspt(), getString(R.string.special_hospital));
        pagerAdapter.addFragment(new icu(), getString(R.string.icu_hot));

        viewPager.setAdapter(pagerAdapter);
    }
}
