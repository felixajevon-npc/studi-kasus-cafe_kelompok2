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

            if (pilihMenu < 1 || pilihMenu > 4) {
                System.out.println("Pilihan Menu Tidak Valid! Tolong Input Ulang.");
                continue;
            }

            switch (pilihMenu) {
                case 1:
                    // tambahDataKRS();
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
}
