package edu;

public class Exercise01 {
    public static void main(String[] args) {
        String account = "01-123-456";
        int balance = 0;
        int deposit = 0;
        int withdraw = 0;
        float rate = 3.3f;
        float interest = 0.0f;

        deposit = 500000;
        balance += deposit;

        withdraw = 200000;
        balance += withdraw;

        interest = balance * rate;

        System.out.println(balance);
    }
}
