package com.lockedme.ui;

import com.lockedme.logic.FileManager;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class UI {
    private Scanner scanner;
    private FileManager fileManager;

    public UI(Scanner scanner, FileManager fileManager) {
        this.scanner = scanner;
        this.fileManager = fileManager;
    }

    public void start() {
        this.startManager();
    }

    private void startManager() {
        String choice;

        while (true) {
            System.out.println("Welcome to LockedMe, an online file storage and management service !");
            System.out.println("Developer name -- Eric Miranda I026");
            System.out.println("=== === ===");

            System.out.println("What would you like to do ?");
            System.out.println("[1]. List all files");
            System.out.println("[2]. Add a file");
            System.out.println("[3]. Delete a file");
            System.out.println("[4]. Search");
            System.out.println("[5]. Exit application");

            System.out.println("Please choose an option number: ");

            choice = this.scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println(this.fileManager.listAll());
                    break;
                case "2":
                    System.out.println("Please enter [file_name], [file_path] and [file_size] as comma seperated values");
                    String fileDetails = this.scanner.nextLine();
                    String[] splitDetails = fileDetails.split(",");
                    for (int i = 0; i < splitDetails.length; i++) {
                        splitDetails[i] = splitDetails[i].trim();
                    }
                    this.fileManager.addFile(splitDetails[0], splitDetails[1], Integer.parseInt(splitDetails[2]));
                    break;
                case "3":
                    System.out.println("Name of the file to be deleted: ");
                    String fileName = this.scanner.nextLine();
                    try {
                        fileManager.deleteFile(fileName);
                        System.out.println("File \"" + fileName + "\" deleted successfully.");
                    } catch (FileNotFoundException e) {
                        System.out.println("Sorry, the specified file does not exist.");
                    }
                    break;
                case "4":
                    System.out.println("Enter name of file to be searched for: ");
                    try {
                        System.out.println(this.fileManager.searchFile(this.scanner.nextLine()));
                    } catch (FileNotFoundException e) {
                        System.out.println("No results found.");
                    }
                    break;
                case "5":
                    System.out.println("Exiting, have a nice day !...");
                    return;
            }

            System.out.println("Enter any key to continue...");
            this.scanner.nextLine();
        }
    }
}
