package com.example.banqueapplication;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateValidatorUsingDateFormat implements DateValidator{ // This is the java class that will be implementing the dateValidator interface
    private String dateFormat;

    public DateValidatorUsingDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    } // Constructor with a string value representing the format of the date we want to use for example (DD/MM/YY)

    @Override
    public boolean isValid(String dateStr) { // This function check if the user input respect the format in the constructor or not return True of false
        DateFormat sdf = new SimpleDateFormat(this.dateFormat); //Getting the date format used
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr); //Trying to parse the date format with the input date in other words we're checking if it's respecting the format or not
        } catch (ParseException e) {
            return false; //In case of exceptions means the input doesn't respect the format
        }
        return true; // Here the input respect the date fromat used
    }
}
