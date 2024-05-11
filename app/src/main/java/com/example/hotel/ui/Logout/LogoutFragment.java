package com.example.hotel.ui.Logout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.hotel.Home;
import com.example.hotel.MainActivity;
import com.example.hotel.R;
import com.example.hotel.RoomView;
import com.example.hotel.ViewData;
import com.example.hotel.databinding.FragmentHomeBinding;
import com.example.hotel.databinding.FragmentLogoutBinding;
import com.example.hotel.ui.home.HomeFragment;
import com.example.hotel.ui.home.HomeViewModel;


public class LogoutFragment extends Fragment {

    private FragmentLogoutBinding binding;
    Activity context;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LogoutViewModel logoutViewModel
                =
                new ViewModelProvider(this).get(LogoutViewModel.class);

        binding = FragmentLogoutBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        context = getActivity();

        return binding.getRoot();

    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void onStart() {
        super.onStart();

        Button yesbtn = (Button) context.findViewById(R.id.yes);
        Button Canclebtn = (Button) context.findViewById(R.id.cancle);

        yesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);


            }
        });


        Canclebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, Home.class);
                startActivity(intent);

            }
        });


    }
}