package com.example.proyectochignautla.Class;

public class Reports {
    Integer id;
    String area;
    String problem;
    String created_at;
    String status;


    public Reports() {
        this.id = id;
        this.area = area;
        this.problem = problem;
        this.created_at = created_at;
        this.status = status;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getArea() { return area; }

    public void setArea(String area) { this.area = area; }

    public String getProblem() { return problem; }

    public void setProblem(String problem) { this.problem = problem; }

    public String getCreated_at() { return created_at; }

    public void setCreated_at(String created_at) { this.created_at = created_at; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }
}