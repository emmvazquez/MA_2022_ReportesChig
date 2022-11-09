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
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.navigationrail.NavigationRailMenuView;

import org.json.JSONObject;

public class RegisterFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle saveInstansceState) {

        EditText nombreregistro = view.findViewById(R.id.etNombreRegister);
        EditText apellidopaternoregistro = view.findViewById(R.id.etApellidoPaternoRegister);
        EditText apellidomaternoregistro = view.findViewById(R.id.etApellidoMaternoRegister);
        EditText telefonoregistro = view.findViewById(R.id.etTelefonoRegister);
        EditText correoregistro = view.findViewById(R.id.etCorreoRegister);
        EditText usuarioregistro = view.findViewById(R.id.etUsuarioRegister);
        EditText contrasenaregistro = view.findViewById(R.id.etContrasenaRegister);
        Button guardarregistro = view.findViewById(R.id.btnGuardarRegister);
        Button regresarregistro = view.findViewById(R.id.btnRegisterLogin);


        RequestQueue queue = Volley.newRequestQueue(view.getContext());

        guardarregistro.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String enombreregistro = nombreregistro.getText().toString();
                String eapellidopaternoregistro = apellidopaternoregistro.getText().toString();
                String eapellidomaternoregistro = apellidomaternoregistro.getText().toString();
                String etelefonoregistro = telefonoregistro.getText().toString();
                String ecorreoregistro = correoregistro.getText().toString();
                String eusuarioregistro = usuarioregistro.getText().toString();
                String econtrasenaregistro = contrasenaregistro.getText().toString();

                String url = "http://192.168.137.48/ejerciciopa/apiregistro.php?name=" + enombreregistro + "&fatherlastname=" + eapellidopaternoregistro +
                        "&motherlastname=" + eapellidomaternoregistro + "&phonenumber=" + etelefonoregistro + "&email=" + ecorreoregistro +
                        "&user=" + eusuarioregistro + "&pass=" + econtrasenaregistro;

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                        Request.Method.GET, url, null,
                        new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
                                Toast.makeText(view.getContext(), response.toString(), Toast.LENGTH_LONG).show();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(view.getContext(), error.toString(), Toast.LENGTH_LONG).show();
                    }
                });
                queue.add(jsonObjectRequest);
                //Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_loginFragment);
                //Toast.makeText(getActivity(), "Registro Creado Exitosamente", Toast.LENGTH_LONG).show();
            }
        });
        regresarregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_mainFragment);
            }
        });

    }
}