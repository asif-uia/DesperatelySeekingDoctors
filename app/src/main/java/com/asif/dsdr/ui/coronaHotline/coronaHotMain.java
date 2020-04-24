package com.asif.dsdr.ui.coronaHotline;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.asif.dsdr.R;
import com.asif.dsdr.ui.coronacell.PagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class coronaHotMain extends Fragment {
    private PagerAdapter pagerAdapter;
    private ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_corona_hot_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pagerAdapter = new PagerAdapter(getFragmentManager());
        viewPager = view.findViewById(R.id.pager3);

        setupViewPager(viewPager);

        TabLayout tabLayout = view.findViewById(R.id.tablayout3);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        PagerAdapter pagerAdapter = new PagerAdapter(getFragmentManager());
        pagerAdapter.addFragment(new Tab1(), getString(R.string.emergence_hot));
        pagerAdapter.addFragment(new corona_special_hspt(), getString(R.string.corona_hosptl));
        pagerAdapter.addFragment(new corona_icu(), getString(R.string.icu_hot));

        viewPager.setAdapter(pagerAdapter);
    }
}
