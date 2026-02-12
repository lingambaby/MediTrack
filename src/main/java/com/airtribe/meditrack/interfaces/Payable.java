package com.airtribe.meditrack.interfaces;

public interface Payable {

    double calculateAmount();

    default void printReceipt() {
        System.out.println("Payment successful");
    }
}