package org.example.entity;

public class Bissextile {


    public boolean isDivisibleBy400(int year) {
        if( year%400 == 0) {
            return true;
        }
        return false;
    }

    public boolean isDivisibleBy4ButNot100(int year) {
        if(( year%4 == 0) && (year%100 != 0)){
            return true;
        }
        return false;
    }


    public boolean isDivisibleBy4000(int year) {
        if( year%4000 == 0) {
            return true;
        }
        return false;
    }
}
