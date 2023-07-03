package com.example.dbpandroidfinal.Modelos;

public class Usuario {
    private String nomusu;
    private String clausu;
    private String idusu;

    public Usuario(String nomusu, String clausu, String idusu) {
        this.nomusu = nomusu;
        this.clausu = clausu;
        this.idusu = idusu;
    }
    public String getNomusu() {
        return nomusu;
    }

    public void setNomusu(String nomusu) {
        this.nomusu = nomusu;
    }

    public String getClausu() {
        return clausu;
    }

    public void setClausu(String clausu) {
        this.clausu = clausu;
    }

    public String getIdusu() {
        return idusu;
    }

    public void setIdusu(String idusu) {
        this.idusu = idusu;
    }

    public Usuario() {
    }

}
