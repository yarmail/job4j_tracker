package ru.job4j.tracker;

import java.awt.*;

public class CloseProgramAction implements UserAction {
    private final Output out;

    public CloseProgramAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Exit program";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("---Exit program---");
        return false;
    }
}
