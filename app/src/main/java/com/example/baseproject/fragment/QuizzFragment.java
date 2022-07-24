package com.example.baseproject.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.baseproject.R;

public class QuizzFragment extends Fragment {

    private NavController mNavigationController;
    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_quizz, container, false);
        mView.findViewById(R.id.btn_true).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation
                        .findNavController(mView)
                        .navigate(QuizzFragmentDirections
                                .actionQuizzFragmentToCongratFragment(100));
            }
        });

        mView.findViewById(R.id.btn_false).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(mView).navigate(R.id.action_quizzFragment_to_failFragment);
            }
        });
        setHasOptionsMenu(true);
        return mView;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.my_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.onBoadFragment) {
            Navigation.findNavController(mView).navigate(R.id.action_quizzFragment_to_onBoadFragment);
            return true;
        }
        return NavigationUI.onNavDestinationSelected(item, NavHostFragment.findNavController(this)) || super.onOptionsItemSelected(item);
    }
}