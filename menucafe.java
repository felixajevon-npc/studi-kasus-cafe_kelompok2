import java.util.Scanner;

public class menucafe {
   public static void menu() {
    Scanner sc = new Scanner(System.in);
    System.out.print("\nMasukkan nama pelanggan: ");
    String namaPelanggan = sc.nextLine();
    System.out.print("Masukkan nomor meja: ");
    int nomorMeja = sc.nextInt();

    int totalHarga = 0;

    while (true) {
        System.out.print(" ===== MENU UTAMA ===== ");    
        System.out.print(" 1. Kopi Hitam -- Rp 15000");    
        System.out.print(" 2. Latte -- Rp 22000 ");    
        System.out.print(" 3. Teh Tarik -- Rp 12000");
        System.out.print(" 4. Mie Goreng -- Rp 18000");

        System.out.print("Pilih menu (masukkan nomor menu atau 0 untuk selesai): ");
        int pilihMenu = sc.nextInt();
        
        if (pilihMenu == 0) break;

        String namaMenu = sc.nextLine();
        int hargaMenu = sc.nextInt();
        int jumlahItem = sc.nextInt();

        switch (pilihMenu) {
            case 1:
                namaMenu = "Kopi Hitam";
                hargaMenu = 15000;
                System.out.print("Masukkan jumlah item untuk Kopi Hitam: " + jumlahItem);
                break;
            case 2 :
                namaMenu = "Latte";
                hargaMenu = 22000;
                System.out.print("Masukkan jumlah item untuk Latte: " +jumlahItem);
            case 3 :
                namaMenu = "Teh Tarik";
                hargaMenu = 12000;
                System.out.print("Masukkan jumlah item untuk Teh Tarik: " +jumlahItem);
            case 4 :
                namaMenu = "Mie Goreng";
                hargaMenu = 18000;
                System.out.print("Masukkan jumlah item untuk Mie Goreng: " +jumlahItem);
                break;
            default:
            System.out.println("Selesai.");
                break;
        }
        totalHarga = jumlahItem*hargaMenu;
        System.out.println("Pesanan berhasil ditambahkan.");
        System.out.println("Total harga pesanan: " +totalHarga);
    }
   } 
}
