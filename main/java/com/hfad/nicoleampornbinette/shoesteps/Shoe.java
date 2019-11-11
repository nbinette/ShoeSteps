package com.hfad.nicoleampornbinette.shoesteps;

import java.sql.Timestamp;

public class Shoe {
    String name;
    String dateBought;
    String dateDeleted;
    int steps;
    double miles;

    /**
    * Fresh kicks!
    *
    */
    public Shoe(String name, String dateBought) {
        this.name = name;
        this.dateBought = dateBought;
        this.dateDeleted = null;
        this.steps = 0;
        this.miles = 0.0;

    }

    /**
     * Getters
     */
    public String getName() {
        return this.name;
    }

    public String getDate() {
        return this.dateBought.toString();
    }

    /**
    * Time to get new shoes!
    *
    */
    public void deleteShoes(String dateDeleted) {
        this.dateDeleted = dateDeleted;
    }

    /**
    * Update steps; convert steps to miles
    * According to wwww.thewalkingsite.com there
    * are 2000 steps in 1 mile
    *
    */
    public void countSteps(int steps) {
        this.steps = steps;
        this.miles = steps/2000;
    }
}
