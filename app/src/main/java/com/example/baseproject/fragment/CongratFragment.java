package com.example.baseproject.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.baseproject.R;

public class CongratFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_congrat, container, false);
        int value = CongratFragmentArgs.fromBundle(getArguments()).getPoint();
        TextView textViewScore = view.findViewById(R.id.tv_score);
        textViewScore.setText(value + " Score");
        view.findViewById(R.id.btn_reset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(view);
                navController.navigateUp();
                // or using popToBackStack will be oke
            }
        });

        return view;
    }
}