package com.lockedme;

import com.lockedme.domain.File;
import com.lockedme.logic.FileManager;
import com.lockedme.ui.UI;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File[] files = {new File("wogoo", "f:/", 2), new File("z_true.jpg", "e:/", 3), new File("big-doc.pdf", "c:/", 20),  new File("google.txt", "c:/", 10), new File("work_presentation.ppt", "d:/", 50)};
        UI ui = new UI(new Scanner(System.in), new FileManager(files));



        ui.start();
    }
}
