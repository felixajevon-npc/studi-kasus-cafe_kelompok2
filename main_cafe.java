import java.util.Scanner;

public class main_cafe {
    public static int pelangganCount = 0;
    public static String[][] pelanggan = new String[50][2];
    public static int[][] pesanan = new int[50][20];
    public static int[][] jumlah = new int[50][20];

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
                    tampilDaftarPesanan();
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

        if (pelangganCount >= pelanggan.length) {
            System.out.println("Tidak dapat menambahkan pelanggan lagi.");
            return;
        }

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
        int pesananCount = 0;

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

            if (pesananCount >= pesanan[pelangganCount].length) {
                System.out.println("Tidak dapat menambahkan lebih banyak pesanan. Batas maksimum tercapai.");
                break;
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
                System.out.println("Jumlah item harus lebih dari 0.");
                continue;
            }

            totalHarga += jumlahItem * hargaMenu;

            pesanan[pelangganCount][pesananCount] = pilihMenu;
            jumlah[pelangganCount][pesananCount] = jumlahItem;
            pesananCount++;

            System.out.println(jumlahItem + " x " + namaMenu + " berhasil ditambahkan.");
        }

        pelanggan[pelangganCount][0] = namaPelanggan;
        pelanggan[pelangganCount][1] = String.valueOf(nomorMeja);
        pelangganCount++;

        System.out.println("\nPesanan untuk " + namaPelanggan + " (Meja " + nomorMeja + ") berhasil disimpan.");
        System.out.printf("Total harga pesanan: Rp %,d%n", totalHarga);
        System.out.println();
    }

    public static void tampilDaftarPesanan() {
        System.out.println();
        System.out.println("===== DAFTAR PESANAN =====");
        for (int i = 0; i < pelanggan.length; i++) {
            if (pelanggan[i][0] == null) {
                break;
            }
            System.out.println("Nama Pelanggan : " + pelanggan[i][0]);
            System.out.println("Nomor Meja : " + pelanggan[i][1]);
            System.out.println("Detail Pesanan : ");

            int totalHarga = 0;
            for (int j = 0; j < 20; j++) {
                if (pesanan[i][j] == 0) {
                    break;
                }
                String namaMenu = "";
                int hargaMenu = 0;

                switch (pesanan[i][j]) {
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
                        System.out.println("Menu tidak valid.");
                        continue;
                }

                totalHarga += hargaMenu * jumlah[i][j];
                System.out.println("- " + namaMenu + " x " + jumlah[i][j] + " = Rp " + (hargaMenu * jumlah[i][j]));
            }
            System.out.printf("Total Harga : Rp %,d%n", totalHarga);
            System.out.println("--------------------------------------------------");
        }
    }
}
