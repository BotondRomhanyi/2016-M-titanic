package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            List<Categories> categories = new ArrayList<>();

            //1.feladat
            try (BufferedReader reader = new BufferedReader(new FileReader("titanic.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    Categories code = new Categories(line);
                    categories.add(code);
                }
            }

            //2.feladat
            System.out.println("2. Feladat: " + categories.size() + " db");

            //3.feladat
            int personCounter = 0;
            for (Categories category : categories) {
                personCounter += category.survivor + category.missing;
            }
            System.out.println("3. Feladat: " + personCounter + " fő");

            //4.feladat
            System.out.print("4. Feladat: Kulcsszó: ");
            Scanner scanner = new Scanner(System.in);
            String keyword = scanner.nextLine();
            boolean match = false;
            for (Categories category : categories) {
                if (category.name.contains(keyword)) match = true;
            }
            System.out.print(match ? "\t Van" : "\t Nincs");
            System.out.println(" találat!");

            //5.feladat
            System.out.println("5. Feladat:");
            for (Categories category : categories) {
                if (category.name.contains(keyword)) System.out.println("\t" + category.name + " " + (category.survivor + category.missing));
            }

            //6.feladat
            System.out.println("6. Feladat:");
            for (Categories category : categories) {
                if (((float) category.missing / (category.survivor + category.missing) > 0.6)) System.out.println("\t" + category.name);
            }

            //7.feladat
            int max = 0;
            String maxCategory = null;
            for (Categories category : categories) {
                if (category.missing > max) {
                    maxCategory = category.name;
                    max = category.missing;
                }
            }
            System.out.println("7. Feladat: " + maxCategory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}