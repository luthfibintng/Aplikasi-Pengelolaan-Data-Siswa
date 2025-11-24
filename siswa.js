ackage model;

public class Siswa extends User {
    private String namaLengkap;
    private String statusPendaftaran; 
    private String nisn;         // Baru
    private String tanggalLahir; // Baru

    // Constructor Diupdate
    public Siswa(String username, String password, String namaLengkap, String statusPendaftaran, String nisn, String tanggalLahir) {
        super(username, password);
        this.namaLengkap = namaLengkap;
        this.statusPendaftaran = statusPendaftaran;
        this.nisn = nisn;
        this.tanggalLahir = tanggalLahir;
    }

    // Getter & Setter Baru
    public String getNisn() { return nisn; }
    public void setNisn(String nisn) { this.nisn = nisn; }

    public String getTanggalLahir() { return tanggalLahir; }
    public void setTanggalLahir(String tanggalLahir) { this.tanggalLahir = tanggalLahir; }

    public String getNamaLengkap() { return namaLengkap; }
    public void setNamaLengkap(String namaLengkap) { this.namaLengkap = namaLengkap; }

    public String getStatusPendaftaran() { return statusPendaftaran; }
    public void setStatusPendaftaran(String statusPendaftaran) { this.statusPendaftaran = statusPendaftaran; }

    @Override
    public void displayRole() {
        System.out.println("Role: Calon Siswa / Siswa");
    }

    @Override
    public String toString() {
        return "NISN: " + nisn + " | Username: " + username + " |  Nama: " + namaLengkap + " | Tgl Lahir: " + tanggalLahir + " | Status: " + statusPendaftaran;
    }

    /**
     * Format File Diupdate:
     * SISWA;username;password;nama;status;nisn;tanggal_lahir
     */
    @Override
    public String toFileString() {
        return "SISWA;" + username + ";" + password + ";" + namaLengkap + ";" + statusPendaftaran + ";" + nisn + ";" + tanggalLahir;
    }
}
