package com.example.banqueapplication;





import java.time.LocalDate;

public class History { // This is the class i'll be using to store the history cache during the execution time

    private Integer Num; // Number (Primary Key) of Transaction
    private String Montant; // Value of transaction
    private LocalDate Date ; // Date of transaction

    public History(Integer num, String montant, LocalDate date) { //Constructor of the history classes
        Num = num;
        Montant = montant;
        Date = date;
    }
    // Getters and setters
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

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }
}
