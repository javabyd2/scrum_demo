package com.sda.scrum;

import java.util.Scanner;

public class Form {
    public static String getSiteName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Proszę podać adres strony: ");
        return scanner.nextLine();
    }
}
