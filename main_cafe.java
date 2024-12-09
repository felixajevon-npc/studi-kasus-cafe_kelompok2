import java.util.Scanner;

public class main_cafe {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean ulang = true;

        while (ulang) {
            System.out.println("=== MENU UTAMA ===");
            System.out.println("1. Tambahkan Pesanan");
            System.out.println("2. Tampilkan Daftar Pesanan");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1-3) : ");
            int pilihMenu = sc.nextInt();
            System.out.println();

            if (pilihMenu < 1 || pilihMenu > 3) {
                System.out.println("Pilihan Menu Tidak Valid! Tolong Input Ulang.");
                continue;
            }

            switch (pilihMenu) {
                case 1:
                    tambahPesanan();
                    break;
                case 2:
                    // tampilkanDaftarKRS();
                    break;
                case 3:
                    System.out.print("Apakah Anda Yakin Ingin Keluar? (y/n): ");
                    sc.nextLine();
                    String konfirmasi = sc.nextLine();
                    if (konfirmasi.equalsIgnoreCase("y")) {
                        ulang = false;
                        System.out.println("Program Selesai.");
                    } else {
                        System.out.println("Kembali ke Menu Utama.");
                    }
                    break;
            }
        }
    }

    public static void tambahPesanan() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nMasukkan nama pelanggan: ");
        String namaPelanggan = sc.nextLine();
        System.out.print("Masukkan nomor meja: ");
        int nomorMeja = sc.nextInt();

        int totalHarga = 0;

        while (true) {
            System.out.println(" ===== MENU UTAMA ===== ");
            System.out.println(" 1. Kopi Hitam -- Rp 15000");
            System.out.println(" 2. Latte -- Rp 22000 ");
            System.out.println(" 3. Teh Tarik -- Rp 12000");
            System.out.println(" 4. Mie Goreng -- Rp 18000");

            System.out.print("Pilih menu (masukkan nomor menu atau 0 untuk selesai): ");
            int pilihMenu = sc.nextInt();

            if (pilihMenu == 0)
                break;

            String namaMenu = sc.nextLine();
            int hargaMenu = sc.nextInt();
            int jumlahItem = sc.nextInt();

            switch (pilihMenu) {
                case 1:
                    namaMenu = "Kopi Hitam";
                    hargaMenu = 15000;
                    System.out.print("Masukkan jumlah item untuk Kopi Hitam: ");
                    int jmlKopi = sc.nextInt();
                    break;
                case 2:
                    namaMenu = "Latte";
                    hargaMenu = 22000;
                    System.out.print("Masukkan jumlah item untuk Latte: ");
                case 3:
                    namaMenu = "Teh Tarik";
                    hargaMenu = 12000;
                    System.out.print("Masukkan jumlah item untuk Teh Tarik: ");
                case 4:
                    namaMenu = "Mie Goreng";
                    hargaMenu = 18000;
                    System.out.print("Masukkan jumlah item untuk Mie Goreng: ");
                    break;
                default:
                    System.out.println("Selesai.");
                    break;
            }
            totalHarga = jumlahItem * hargaMenu;
            System.out.println("Pesanan berhasil ditambahkan.");
            System.out.println("Total harga pesanan: " + totalHarga);
        }
    }
}
