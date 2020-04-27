package com.asif.dsdr.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.asif.dsdr.R;

public class HomeFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        View.OnClickListener a = Navigation.createNavigateOnClickListener(R.id.action_nav_home_to_doctors);
        view.findViewById(R.id.doctor_on).setOnClickListener(a);

        View.OnClickListener b = Navigation.createNavigateOnClickListener(R.id.action_nav_home_to_ambulance4);
        view.findViewById(R.id.ambulance_e).setOnClickListener(b);

        View.OnClickListener d = Navigation.createNavigateOnClickListener(R.id.action_nav_home_to_dental);
        view.findViewById(R.id.dental).setOnClickListener(d);

        View.OnClickListener e = Navigation.createNavigateOnClickListener(R.id.action_nav_home_to_aboutUs);
        view.findViewById(R.id.developers).setOnClickListener(e);

        View.OnClickListener f = Navigation.createNavigateOnClickListener(R.id.action_nav_home_to_zillaChamber);
        view.findViewById(R.id.zilla).setOnClickListener(f);

    }

}

