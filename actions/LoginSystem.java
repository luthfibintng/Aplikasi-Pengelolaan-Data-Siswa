package actions;

import Main.Aplikasi;
import model.User;

public class LoginSystem {
    // Mengembalikan object User jika berhasil login, atau null jika gagal
    public User eksekusi() {
        System.out.print("Username: ");
        String u = Aplikasi.scanner.nextLine();
        System.out.print("Password: ");
        String p = Aplikasi.scanner.nextLine();

        for (User user : Aplikasi.userList) {
            if (user.getUsername().equals(u) && user.checkPassword(p)) {
                return user; // Login Sukses
            }
        }
        return null; // Login Gagal
    }
}