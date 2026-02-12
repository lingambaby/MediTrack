package com.airtribe.meditrack.entity;

import com.airtribe.meditrack.interfaces.Payable;
import com.airtribe.meditrack.constants.Constants;

public class Bill implements Payable {

    private double baseAmount;

    public Bill(double baseAmount) {
        this.baseAmount = baseAmount;
    }

    @Override
    public double calculateAmount() {
        return baseAmount + (baseAmount * Constants.TAX_RATE);
    }
}
