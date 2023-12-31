package com.isptec.fabiovictorino;

import java.util.*;

public class SME {
    public int processNumber;
    public String dateReception;
    public String local;
    public String assignature;

    public SME(int processNumber, String dateReception, String local, String assignature) {
        this.processNumber = processNumber;
        this.dateReception = dateReception;
        this.local = local;
        this.assignature = assignature;
    }

    public int getProcessNumber() {
        return processNumber;
    }

    public String getDateReception() {
        return dateReception;
    }

    public String getLocal() {
        return local;
    }

    public String getAssignature() {
        return assignature;
    }

    @Override
    public String toString() {
        return "SME{" +
                "processNumber=" + processNumber +
                ", dateReception='" + dateReception + '\'' +
                ", local='" + local + '\'' +
                ", assignature='" + assignature + '\'' +
                '}';
    }
}
