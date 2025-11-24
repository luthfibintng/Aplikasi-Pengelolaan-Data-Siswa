package Main;
import java.util.ArrayList;
import java.util.Scanner;
import model.*;
import menu.MenuUtama;
import util.DataManager;


public class Aplikasi {
    // Global Variable agar bisa diakses oleh MenuAdmin dan MenuSiswa
    public static ArrayList<User> userList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // 1. Load data dari file
        userList = DataManager.loadFromFile();

        // 2. Jalankan Menu Utama
        MenuUtama.tampilkan();
    }
    
    // Utility global untuk clear screen
    public static void cls() {
        for (int i = 0; i < 3; i++) System.out.println();
    }

    // Utility global untuk pause
    public static void pressEnter() {
        System.out.print("\nTekan Enter untuk lanjut...");
        scanner.nextLine();
    }
}