package actions;

import main.Aplikasi;
import model.Siswa;
import model.User;
import util.DataManager;

public class EditSiswa {
    public void eksekusi() {
        // Tampilkan daftar dulu biar gampang milih
        new LihatSiswa().eksekusi(); 
        
        System.out.println("\n--- EDIT DATA SISWA ---");
        System.out.print("Masukkan Username siswa yang akan diedit: ");
        String targetUser = Aplikasi.scanner.nextLine();
        
        Siswa found = null;
        for (User u : Aplikasi.userList) {
            if (u instanceof Siswa && u.getUsername().equals(targetUser)) {
                found = (Siswa) u;
                break;
            }
        }


      
