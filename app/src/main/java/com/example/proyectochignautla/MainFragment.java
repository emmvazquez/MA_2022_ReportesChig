package com.example.proyectochignautla;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class MainFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        EditText usuario = view.findViewById(R.id.etUser);
        EditText contrasena = view.findViewById(R.id.etPassword);
        Button btnMainHome = view.findViewById(R.id.btnMainHome);
        Button btnMainRegister = view.findViewById(R.id.btnMainRegister);


        btnMainHome.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_homeFragment);
            }
        });

        btnMainRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_recuperarFragment);
            }
        });

    }
}