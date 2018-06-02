package com.sda.scrum;

import java.util.Scanner;

public class Form {
    public static String getSiteName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Proszę podać adres strony (np.: https://pl.lipsum.com): ");
        return scanner.nextLine();
    }
}
