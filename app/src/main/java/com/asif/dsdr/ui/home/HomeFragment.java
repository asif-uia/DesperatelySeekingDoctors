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

        View.OnClickListener c = Navigation.createNavigateOnClickListener(R.id.action_nav_home_to_maintanance);
        view.findViewById(R.id.maintainance_s).setOnClickListener(c);
    }

}

