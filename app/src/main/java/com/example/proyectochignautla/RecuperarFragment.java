package com.example.proyectochignautla;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RecuperarFragment extends Fragment {
    private TextView tx1;
    private RequestQueue rq;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recuperar, container, false);
    }
    @Override
    public void onViewCreated(@Nullable View view, @Nullable Bundle saveInstanceState) {
        TextView tx1 = view.findViewById(R.id.tx1);
        tx1.setMovementMethod(new ScrollingMovementMethod());
        rq = Volley.newRequestQueue(getContext());

        Button btnR = view.findViewById(R.id.btnR);

        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tx1.setText("");
                String url = "http://192.168.0.101:81/ejerciciopa/apiMostrar.php";
                JsonArrayRequest requerimiento = new JsonArrayRequest(Request.Method.GET,
                        url,
                        null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                for (int f = 0; f < response.length(); f++) {
                                    try {
                                        JSONObject objeto = new JSONObject(response.get(f).toString());
                                        tx1.append("--" + objeto.getString("id") + "\n");
                                        tx1.append("Nombre: " + objeto.getString("name") + "\n");
                                        tx1.append("Apellido Paterno: " + objeto.getString("motherlastname") + "\n");
                                        tx1.append("Apellido Materno: " + objeto.getString("phonenumber") + "\n");
                                        tx1.append("Edad: " + objeto.getString("age") + "\n");
                                        tx1.append("Area: " + objeto.getString("area") + "\n");
                                        tx1.append("Problema: " + objeto.getString("problem") + "\n");
                                        tx1.append("status: " + objeto.getString("status") + "\n");
                                        tx1.append("descripcion: " + objeto.getString("description") + "\n");
                                        tx1.append("__________________________________________________________ \n");

                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(v.getContext(), error.toString(), Toast.LENGTH_LONG).show();
                            }
                        });
                rq.add(requerimiento);

            }
        });

    }

}