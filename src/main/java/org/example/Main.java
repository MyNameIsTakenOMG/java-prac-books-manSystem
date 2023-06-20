package org.example;

import org.example.entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        ControlPanel controlPanel = new ControlPanel(new ManSystem(),new Scanner(System.in));

        controlPanel.start();
    }
}