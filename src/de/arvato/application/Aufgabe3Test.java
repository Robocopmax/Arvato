package de.arvato.application;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class Aufgabe3Test {

    List<Flear> flea1;
    List<Flear> flea2;
    List<Flear> flea3;
    List<Flear> flea4;
    List<Flear> flea5;
    List<Flear> flea6;
    List<Flear> flea7;
    List<Flear> flea8;
    List<Flear> flea9;
    List<Flear> flea10;

    @Before
    public void setup(){
        //Generate example list
        flea1 = List.of(
        new Flear("Alex", 56, 8),
        new Flear("Addam", 55, 7));

        flea10 = List.of(
        new Flear("Alex", 56, 8),
        new Flear("Addam", 55, 7),
        new Flear("Joy", 80, 5),
        new Flear("Michael", 21, 6),
        new Flear("Noe", 50, 10),
        new Flear("Samuel", 25, 4),
        new Flear("Viola", 20, 6),
        new Flear("Xavior", (float)2.5, 1),
        new Flear("Droggelbecher", 70, 3),
        new Flear("Joel", (float)7.5, 2));
        

        
    }
        
    @Test
    public void test2Entires() {
        int re = Aufgabe3.getOptimalValue(55, flea1);
        assertTrue(re == 7);
    }

}
    