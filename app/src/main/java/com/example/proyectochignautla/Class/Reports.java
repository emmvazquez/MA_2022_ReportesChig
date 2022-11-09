package com.example.proyectochignautla.adapters;

public class Reports {
    String area;
    String problem;
    String created_at;
    String status;
    int imagen;


    public Reports(String area, String problem, String created_at, String status, int imagen) {
        this.area = area;
        this.problem = problem;
        this.created_at = created_at;
        this.status = status;
        this.imagen = imagen;
    }

    public String getArea() { return area; }

    public void setArea(String area) { this.area = area; }

    public String getProblem() { return problem; }

    public void setProblem(String problem) { this.problem = problem; }

    public String getCreated_at() { return created_at; }

    public void setCreated_at(String created_at) { this.created_at = created_at; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public int getImagen() { return imagen; }

    public void setImagen(int imagen) { this.imagen = imagen; }
}

