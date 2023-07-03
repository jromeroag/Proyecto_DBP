package com.example.dbpandroidfinal.Modelos;

public class Citas {
    private int id;
    private String doctor;
    private String especialidad;
    private String paciente;
    private String fecha;

    public Citas(String doctor, String especialidad) {
        this.id = id;
        this.doctor = doctor;
        this.especialidad = especialidad;
        this.paciente = paciente;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
