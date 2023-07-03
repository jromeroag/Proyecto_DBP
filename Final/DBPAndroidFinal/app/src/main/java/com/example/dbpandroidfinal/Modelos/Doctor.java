package com.example.dbpandroidfinal.Modelos;

public class Doctor {
    private int iddoc;
    private String nomdoc;
    private String apedoc;
    private String espdoc;
    private int celdoc;

    public Doctor(int iddoc, String nomdoc, String apedoc, String espdoc, int celdoc) {
        this.iddoc = iddoc;
        this.nomdoc = nomdoc;
        this.apedoc = apedoc;
        this.espdoc = espdoc;
        this.celdoc = celdoc;
    }

    public int getIddoc() {
        return iddoc;
    }

    public void setIddoc(int iddoc) {
        this.iddoc = iddoc;
    }

    public String getNomdoc() {
        return nomdoc;
    }

    public void setNomdoc(String nomdoc) {
        this.nomdoc = nomdoc;
    }

    public String getApedoc() {
        return apedoc;
    }

    public void setApedoc(String apedoc) {
        this.apedoc = apedoc;
    }

    public String getEspdoc() {
        return espdoc;
    }

    public void setEspdoc(String espdoc) {
        this.espdoc = espdoc;
    }

    public int getCeldoc() {
        return celdoc;
    }

    public void setCeldoc(int celdoc) {
        this.celdoc = celdoc;
    }
}

