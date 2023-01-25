package com.acme.testing;

import com.acme.utils.MyDate;

public class PassByExperiment {
    public static void main(String[] args) {


    }

    public static void passObject(MyDate d) {
        d.year = 2009;
    }

    public static void passPrimitive(int i) {
        i = 2010;
    }

    public static void passString(String s) {
        int yearSlash = s.lastIndexOf('/');
        s = s.substring(0, yearSlash + 1); // 0 to yearSlash index included
        s += "2012";
        System.out.println("New date String: " + s);;
    }
}
