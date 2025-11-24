package util;

import java.io.*;
import java.util.ArrayList;
import model.*;

public class DataManager {
    private static final String FILE_ADMIN = "admin.txt";
    private static final String FILE_SISWA = "siswa.txt";

    public static void saveToFile(ArrayList<User> users) {
        try {
            BufferedWriter writerAdmin = new BufferedWriter(new FileWriter(FILE_ADMIN));
            BufferedWriter writerSiswa = new BufferedWriter(new FileWriter(FILE_SISWA));

            for (User u : users) {
                if (u instanceof Admin) {
                    writerAdmin.write(u.toFileString());
                    writerAdmin.newLine();
                } else if (u instanceof Siswa) {
                    writerSiswa.write(u.toFileString());
                    writerSiswa.newLine();
                }
            }
            writerAdmin.close();
            writerSiswa.close();
        } catch (IOException e) {
            System.out.println("Gagal menyimpan data: " + e.getMessage());
        }
    }

    public static ArrayList<User> loadFromFile() {
        ArrayList<User> data = new ArrayList<>();
        System.out.println("--- MEMUAT DATABASE ---"); 

        // 1. Load Admin
        File fileAdmin = new File(FILE_ADMIN);
        if (!fileAdmin.exists()) {
            createDefaultAdmin(data);
        } else {
            readData(fileAdmin, data);
        }

        // 2. Load Siswa
        File fileSiswa = new File(FILE_SISWA);
        if (fileSiswa.exists()) {
            readData(fileSiswa, data);
        } else {
            try { fileSiswa.createNewFile(); } 
            catch (IOException e) {}
        }
        
        System.out.println("Total User Terload: " + data.size()); // Debugging info
        return data;
    }

    private static void readData(File file, ArrayList<User> list) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Abaikan baris kosong
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(";");
                
                // Ambil tipe dan bersihkan dari spasi/karakter aneh
                String type = parts[0].trim().toUpperCase(); 

                // Perbaikan Logika Deteksi (Menggunakan contains biar aman dari BOM)
                if (type.contains("ADMIN") && parts.length >= 3) {
                    String u = parts[1].trim();
                    String p = parts[2].trim();
                    list.add(new Admin(u, p));
                    // System.out.println("Loaded Admin: " + u); // Uncomment jika ingin melihat detail

                } else if (type.contains("SISWA") && parts.length >= 7) {
                    String u = parts[1].trim();
                    String p = parts[2].trim();
                    String n = parts[3].trim();
                    String s = parts[4].trim();
                    String nisn = parts[5].trim();
                    String tgl = parts[6].trim();
                    
                    list.add(new Siswa(u, p, n, s, nisn, tgl));
                    // System.out.println("Loaded Siswa: " + u); // Uncomment jika ingin melihat detail
                }
            }
        } catch (IOException e) {
            System.out.println("Error baca file " + file.getName() + ": " + e.getMessage());
        }
    }

    private static void createDefaultAdmin(ArrayList<User> data) {
        try {
            System.out.println("File admin tidak ditemukan, membuat default...");
            Admin defaultAdmin = new Admin("admin", "admin123");
            data.add(defaultAdmin);
            
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_ADMIN));
            writer.write(defaultAdmin.toFileString());
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.out.println("Gagal membuat default admin.");
        }
    }
}