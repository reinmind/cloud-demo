package com.reinmind;

import com.reinmind.generator.TableGenerator;

import java.io.FileNotFoundException;

public class ITextApplication {
    public static void main(String[] args) throws FileNotFoundException {
        new TableGenerator().generate();
    }
}
