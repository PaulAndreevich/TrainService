package com.example.blocks;

import java.io.Serializable;

public class Carrige implements Serializable{
    protected boolean light;
    protected Carrige next, prev;

	/* Constructor */

    public Carrige(boolean value) {
        next = null;
        prev = null;
        light = value;
    }

    /* Constructor */
    public Carrige(boolean d, Carrige n, Carrige p) {
        light = d;
        next = n;
        prev = p;
    }

	/* Function to set link to next Carrige */

    public void setLinkNext(Carrige n) {
        next = n;
    }

	/* Function to set link to previous Carrige */

    public void setLinkPrev(Carrige p) {
        prev = p;
    }

	/* Funtion to get link to next Carrige */

    public Carrige getLinkNext() {
        return next;
    }

	/* Function to get link to previous Carrige */

    public Carrige getLinkPrev() {
        return prev;
    }

	/* Function to set data to Carrige */

    public void setLight(boolean d) {
        light = d;
    }

    /* Function to get data from Carrige */
    public boolean getLight() {
        return light;
    }
}