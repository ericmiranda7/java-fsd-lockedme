package com.lockedme;

import com.lockedme.domain.File;
import com.lockedme.logic.FileManager;
import com.lockedme.ui.UI;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File[] files = {new File("big-doc.pdf", "c:/", 20), new File("work_presentation.ppt", "d:/", 50), new File("google.txt", "c:/", 10)};
        UI ui = new UI(new Scanner(System.in), new FileManager(files));



        ui.start();
    }
}
