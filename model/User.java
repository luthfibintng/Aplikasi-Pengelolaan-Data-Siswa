package model;


public abstract class User {
    protected String username;
    protected String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter
    public String getUsername() {
        return username;
    }

    // Getter Password diperlukan untuk menyimpan kembali ke file
    public String getPassword() {
        return password;
    }

    // Setter password untuk menerima perubahan password dari Admin
    public void setPassword(String password) {
        this.password = password;
}

    // Method untuk validasi login
    public boolean checkPassword(String inputPass) {
        return this.password.equals(inputPass);
    }

    // Abstract Method: Harus diimplementasikan oleh Admin dan Siswa
    public abstract void displayRole();
    
    // Abstract Method Baru: Mengubah objek menjadi format String CSV (dipisahkan titik koma)
    public abstract String toFileString();
}