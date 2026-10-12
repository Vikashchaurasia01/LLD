package com.lld.client;

import com.lld.adaptee.WeightMachineForbabies;
import com.lld.adapter.WeightMachineAdapter;
import com.lld.adapter.WeightMachineAdapterImpl;

public class Main {
    public static void main(String[] args) {
        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineForbabies());

        System.out.println(weightMachineAdapter.getWeightInKg());
    }
}
