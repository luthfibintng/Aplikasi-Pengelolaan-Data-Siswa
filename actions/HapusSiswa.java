package actions;

import main.Aplikasi;
import model.Siswa;
import model.User;
import util.DataManager;

public class HapusSiswa {
    public void eksekusi() {
        // Panggil LihatSiswa dulu biar admin tau siapa yg mau dihapus
        new LihatSiswa().eksekusi(); 
        
        System.out.print("Username siswa yang akan dihapus: ");
        String targetUser = Aplikasi.scanner.nextLine();
        
        User target = null;
        for (User u : Aplikasi.userList) {
            if (u instanceof Siswa && u.getUsername().equals(targetUser)) {
                target = u;
                break;
            }
        }
      
