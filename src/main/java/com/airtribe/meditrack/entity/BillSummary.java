package com.airtribe.meditrack.entity;

public final class BillSummary {

    private final int id;
    private final double total;

    public BillSummary(int id, double total) {
        this.id = id;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public double getTotal() {
        return total;
    }
}
