package com.company;

import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

public class Dane {
    LocalDate data;

    public LocalDate getData() {
        return data;
    }

    public void setData() {
       data =  LocalDate.now();
    }

    @Override
    public String toString() {
        return "Dane{" +
                "data=" + data +
                '}';
    }

    public Dane() {
        this.data = LocalDate.now();
    }
}
