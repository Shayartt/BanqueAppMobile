package com.example.banqueapplication;

public class History {
    private Integer Num;
    private String Montant;
    private String Date ;

    public History(Integer num, String montant, String date) {
        Num = num;
        Montant = montant;
        Date = date;
    }

    public Integer getNum() {
        return Num;
    }

    public void setNum(Integer num) {
        Num = num;
    }

    public String getMontant() {
        return Montant;
    }

    public void setMontant(String montant) {
        Montant = montant;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
