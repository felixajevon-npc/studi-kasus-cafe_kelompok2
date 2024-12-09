import java.util.Scanner;

public class main_cafe {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. Tambahkan Pesanan");
            System.out.println("2. Tampilkan Daftar Pesanan");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1-3) : ");
            int pilihMenu = sc.nextInt();

            if (pilihMenu < 1 || pilihMenu > 3) {
                System.out.println("Pilihan Menu Tidak Valid!");
                continue;
            }

            switch (pilihMenu) {
                case 1:
                    tambahPesanan();
                    break;
                case 2:

                    break;
                case 3:
                    System.out.print("\nApakah Anda Yakin Ingin Keluar? (y/n): ");
                    sc.nextLine();
                    String konfirmasi = sc.nextLine();
                    if (konfirmasi.equalsIgnoreCase("y")) {
                        loop = false;
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

        boolean inputValidMeja = false;
        int nomorMeja = -1;

        while (!inputValidMeja) {
            System.out.print("\nMasukkan nomor meja : ");

            if (sc.hasNextInt()) {
                nomorMeja = sc.nextInt();
                if (nomorMeja > 0) {
                    inputValidMeja = true;
                } else {
                    System.out.println("Nomor meja tidak boleh negatif atau 0.");
                }
            } else {
                System.out.println("Input harus angka.");
                sc.next();
            }
        }

        int totalHarga = 0;

        while (true) {
            System.out.println("\n===== MENU UTAMA =====");
            System.out.println("1. Kopi Hitam -- Rp 15000");
            System.out.println("2. Latte -- Rp 22000");
            System.out.println("3. Teh Tarik -- Rp 12000");
            System.out.println("4. Mie Goreng -- Rp 18000");
            System.out.print("Pilih menu (masukkan nomor menu atau 0 untuk selesai): ");

            if (!sc.hasNextInt()) {
                System.out.println("Input tidak valid.");
                sc.next();
                continue;
            }

            int pilihMenu = sc.nextInt();
            sc.nextLine();

            if (pilihMenu == 0) {
                break;
            }

            String namaMenu = "";
            int hargaMenu = 0;

            switch (pilihMenu) {
                case 1:
                    namaMenu = "Kopi Hitam";
                    hargaMenu = 15000;
                    break;
                case 2:
                    namaMenu = "Latte";
                    hargaMenu = 22000;
                    break;
                case 3:
                    namaMenu = "Teh Tarik";
                    hargaMenu = 12000;
                    break;
                case 4:
                    namaMenu = "Mie Goreng";
                    hargaMenu = 18000;
                    break;
                default:
                    System.out.println("Pilihan menu tidak valid.");
                    continue;
            }

            System.out.print("Masukkan jumlah item untuk " + namaMenu + ": ");

            if (!sc.hasNextInt()) {
                System.out.println("Jumlah item harus berupa angka.");
                sc.next();
                continue;
            }

            int jumlahItem = sc.nextInt();
            sc.nextLine();

            if (jumlahItem <= 0) {
                System.out.println("Jumlah item harus lebih dari 0. Silakan coba lagi.");
                continue;
            }

            totalHarga += jumlahItem * hargaMenu;
            System.out.println(jumlahItem + " x " + namaMenu + " berhasil ditambahkan.");
        }

        System.out.println("\nPesanan untuk " + namaPelanggan + " (Meja " + nomorMeja + ") berhasil disimpan.");
        System.out.printf("Total harga pesanan: Rp %,d%n", totalHarga);
        System.out.println();
    }
}
