package com.example.hotel.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.hotel.Home;
import com.example.hotel.R;
import com.example.hotel.RoomDetails;
import com.example.hotel.Staf;
import com.example.hotel.ViewData;
import com.example.hotel.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {



    Activity context;


    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);

        context=getActivity();


        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void onStart()
    {
      super.onStart();

        Button btn =(Button) context.findViewById(R.id.button);
        Button emp = (Button) context.findViewById(R.id.employeeadd);
        Button rbt =(Button) context.findViewById(R.id.Rbtn);
        Button viewbt =(Button) context.findViewById(R.id.View);
        ImageButton img3 = (ImageButton) context.findViewById(R.id.imageView3);
        ImageButton img2 = (ImageButton) context.findViewById(R.id.imageView2);
        ImageButton img6 = (ImageButton) context.findViewById(R.id.imageView6);
        ImageButton img7 = (ImageButton) context.findViewById(R.id.imageView7);


                viewbt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent= new Intent(context, ViewData.class);
                        startActivity(intent);

                    }
                });

        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(context, ViewData.class);
                startActivity(intent);

            }
        });






        rbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context, RoomDetails.class);
                startActivity(intent);
            }
        });

        emp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context,Staf.class);
                startActivity(intent);
            }
        });

        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context,Staf.class);
                startActivity(intent);
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context, Home.class);
                startActivity(intent);
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context, Home.class);
                startActivity(intent);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context, RoomDetails.class);
                startActivity(intent);
            }
        });
    }




}
