package com.company;


public class Main {

    public static void main(String[] args) {
        Problem pb = new Problem();
        Solution sol = new Solution(pb);
        System.out.println(pb);
        sol.Algorithm();
        System.out.println(sol);
    }
}
