package com.example.proyectochignautla;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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

import org.json.JSONObject;


public class CreateFragment extends Fragment {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle saveInstansceState) {

        EditText edName = view.findViewById(R.id.etNombre);
        EditText edFl = view.findViewById(R.id.etApellidoPaterno);
        EditText edMl = view.findViewById(R.id.etApellidoMaterno);
        EditText edPhone = view.findViewById(R.id.etTelefono);
        EditText edAge = view.findViewById(R.id.etEdad);
        EditText edColony = view.findViewById(R.id.etColonia);
        EditText edStreet1 = view.findViewById(R.id.etCalle1);
        EditText edStreet2 = view.findViewById(R.id.etCalle1);
        EditText edArea = view.findViewById(R.id.etArea);
        EditText edProblem = view.findViewById(R.id.etProblema);
        EditText edDescrip = view.findViewById(R.id.etDescripcion);
        Button guardar = view.findViewById(R.id.btnGuardar);



        RequestQueue queue = Volley.newRequestQueue(view.getContext());

        guardar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){

                String eName = edName.getText().toString();
                String eFl = edFl.getText().toString();
                String eMl = edMl.getText().toString();
                String ePhone = edPhone.getText().toString();
                String eAge = edAge.getText().toString();
                String eColony = edColony.getText().toString();
                String eStreet1 = edStreet1.getText().toString();
                String eStreet2 = edStreet2.getText().toString();
                String eArea = edArea.getText().toString();
                String eProblem = edProblem.getText().toString();
                String eDescrip = edDescrip.getText().toString();

                String url ="http://172.16.26.136/ejerciciopa/wsAddPro.php?name="+eName+"&fatherlastname="+eFl+"&motherlastname="+eMl+"&phonenumber="+ePhone+"&age="+eAge+
                        "&colony="+eColony+"&street1="+eStreet1+"&street2="+eStreet2+"&area="+eArea+"&problem="+eProblem+"&description="+eDescrip;

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                        Request.Method.GET, url, null,
                        new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
                                Toast.makeText(view.getContext(), response.toString(), Toast.LENGTH_LONG).show();
                            }
                        },new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(view.getContext(), error.toString(), Toast.LENGTH_LONG).show();
                    }
                });
                queue.add(jsonObjectRequest);

            }
        });

    }
}