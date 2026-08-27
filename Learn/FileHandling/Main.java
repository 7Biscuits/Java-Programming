// package FileHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    static void createFile(String fileName) {
        File file = new File(fileName + ".txt");
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void writeFile(String fileName, String text) {
        try {
            FileWriter writer = new FileWriter(fileName + ".txt");
            writer.write(text);
            writer.close();
            System.out.println("text has been successfully written.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void readFile(String fileName) {
        try {
            File file = new File(fileName + ".txt");
            Scanner reader = new Scanner(file);

            while (reader.hasNext()) {
                System.out.println(reader.nextLine());
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        createFile("file");
        writeFile("file", "hello, world");
        readFile("file");
    }
}
