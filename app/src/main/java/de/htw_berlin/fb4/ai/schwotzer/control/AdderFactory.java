package de.htw_berlin.fb4.ai.schwotzer.control;

import adder.Adder;
import adder.AdderImpl;

public class AdderFactory {
    public static Adder createAdder() {
        return new AdderImpl();
    }
}
