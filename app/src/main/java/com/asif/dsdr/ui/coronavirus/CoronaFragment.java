package com.asif.dsdr.ui.coronavirus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.asif.dsdr.R;
import com.google.android.material.tabs.TabLayout;

public class CoronaFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_corona, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewPager viewPager = view.findViewById(R.id.pager);
        setupViewPager(viewPager);
        TabLayout tabLayout = view.findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        PagerAdapter pagerAdapter = new PagerAdapter(getChildFragmentManager());
        pagerAdapter.addFragment(new coronaSymptom(), "করোনার লক্ষণ");
        pagerAdapter.addFragment(new coronaPrevent(), "প্রতিরোধে করণীয়");
        pagerAdapter.addFragment(new coronaNutri(), "প্রয়োজনীয় পুষ্টিবার্তা");
        pagerAdapter.addFragment(new childrenCorona(), "শিশুর করোনাভাইরাস");
        viewPager.setAdapter(pagerAdapter);
    }
}
