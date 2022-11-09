package com.example.proyectochignautla.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectochignautla.Class.Reports;
import com.example.proyectochignautla.R;

import java.util.ArrayList;

public class ReportsAdapter2 extends RecyclerView.Adapter<ReportsAdapter2.ViewHolder> {
    ArrayList<Reports> ListaReportes;

    public ReportsAdapter2(ArrayList<Reports> listaReportes) {
        ListaReportes = listaReportes;
    }

    @NonNull
    @Override
    public ReportsAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReportsAdapter2.ViewHolder holder, int position) {
        holder.earea.setText(ListaReportes.get(position).getArea().toString());
        holder.eproblem.setText(ListaReportes.get(position).getProblem().toString());
        holder.estatus.setText(ListaReportes.get(position).getStatus().toString());
        holder.ecreated_at.setText(ListaReportes.get(position).getCreated_at().toString());
    }

    @Override
    public int getItemCount() { return ListaReportes.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView earea, eproblem, ecreated_at, estatus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            earea = (TextView) itemView.findViewById(R.id.areaRC);
            eproblem = (TextView) itemView.findViewById(R.id.problemaRC);
            ecreated_at = (TextView) itemView.findViewById(R.id.created_atRC);
            estatus = (TextView) itemView.findViewById(R.id.statusRC);
        }
    }
}
