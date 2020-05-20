package com.berry.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "clingen")
public class ClinGen {
    @Id
    private String _id;
    @Field(value = "id")
    private int id;
    private String chr;
    private int start;
    private int end;
    private String symbol;
    private String haplo;
    private String triplo;

    public int getEnd() {
        return end;
    }

    public int getId() {
        return id;
    }

    public int getStart() {
        return start;
    }

    public String get_id() {
        return _id;
    }

    public String getChr() {
        return chr;
    }

    public String getHaplo() {
        return haplo;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getTriplo() {
        return triplo;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setChr(String chr) {
        this.chr = chr;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setHaplo(String haplo) {
        this.haplo = haplo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setTriplo(String triplo) {
        this.triplo = triplo;
    }
}
