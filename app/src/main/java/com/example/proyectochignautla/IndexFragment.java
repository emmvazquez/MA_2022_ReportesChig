package com.example.proyectochignautla;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.proyectochignautla.Class.Reports;
import com.example.proyectochignautla.adapters.ReportsAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class IndexFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Reports> ListaReportes;
    ReportsAdapter reportsAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_index, container, false);
        ListaReportes = new ArrayList<>();
        recyclerView = (RecyclerView) vista.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setHasFixedSize(true);
        Data();
        return vista;
    }

    public void Data() {
        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(getActivity());
        String url = "https://hostchignautla.000webhostapp.com/apiConsultar.php";


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Reports reports = null;
                JSONArray jsonArray = response.optJSONArray("reports");
                try {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        reports = new Reports();
                        JSONObject jsonObject = null;
                        jsonObject = jsonArray.getJSONObject(i);
                        reports.setArea("Area: " + jsonObject.optString("area"));
                        reports.setProblem("Problema: " + jsonObject.optString("problem"));
                        reports.setStatus("Status: " + jsonObject.optString("status"));
                        reports.setCreated_at("Fecha: " + jsonObject.optString("created_at"));

                        ListaReportes.add(reports);
                    }
                    ReportsAdapter reportsAdapter = new ReportsAdapter(ListaReportes);
                    recyclerView.setAdapter(reportsAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), error.toString(), Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(jsonObjectRequest);


    }


    /*public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstaState) {



    }*/
}













