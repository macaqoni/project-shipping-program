import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static Scanner masukan;
    static ArrayList<ArrayList<String>> paket = new ArrayList<ArrayList<String>>();

    public static void main(String[] args) {
        String lokasi, resi;
        int berat, tarif;
        String Pilihan = null;
        String MenuStaff = null;
        String Inputpassword = null;
        String MenuCust = null;
        masukan = new Scanner(System.in);
        while (Pilihan != "3") {
            System.out.println("METRO PAKET");
            System.out.println("Ekspedisi Kilat Flat Rate JABODETABEK");
            System.out.println("-MENU-");
            System.out.println("1. Untuk Staf Ekspedisi");
            System.out.println("2. Untuk Customer");
            System.out.println("3. Keluar");
            System.out.print("Silahkan Pilih Sesuai Dengan Angka di Atas = ");
            Pilihan = masukan.nextLine();

            switch (Pilihan) {
                case "1":
                    System.out.println("Menu Staf Ekspedisi");
                    System.out.print("Silakan Masukkan Password Staf Ekspedisi: ");
                    Inputpassword = masukan.nextLine();
                    
                    if (Inputpassword.equals("metropaket123")) {
                    System.out.println("1. Masukkan Resi Baru");
                    System.out.println("2. Update Lokasi Paket");
                    System.out.println("3. Lihat Semua Resi");
                    MenuStaff = masukan.nextLine();
                    } else {
                    System.out.println("Password Anda Salah! Silakan Kembali ke Menu Utama.");
                    break;
                    }
                    
                    switch (MenuStaff) {
                        case "1":
                            System.out.print("Buat Resi Baru: ");
                            resi = masukan.nextLine();
                            System.out.print("Gudang Pemberangkatan: ");
                            lokasi = masukan.nextLine();
                            ArrayList<String> data = new ArrayList<>();
                            data.add(resi);
                            data.add(lokasi);
                            paket.add(data);
                            System.out.println("Resi telah dimasukkan dalam sistem. ");
                            System.out.println("Resi: " + resi);
                            System.out.println("Gudang Pemberangkatan: " + lokasi);
                            break;
                        case "2":
                            System.out.println("Update Lokasi Paket");
                            System.out.print("Masukkan resi produk: ");
                            resi = masukan.nextLine();
                            int IdUpdate = 100;
                            for (int i = 0; i < paket.size(); i++) {
                                for (int j = 0; j < paket.get(i).size(); j++) {
                                    if (j == 0 && paket.get(i).get(j).equalsIgnoreCase(resi)) {
                                        IdUpdate = i;
                                    }
                                }
                            }
                            if (IdUpdate != 100) {
                                System.out.print("Update lokasi paket saat ini: ");
                                lokasi = masukan.nextLine();
                                paket.get(IdUpdate).set(1, lokasi);
                                break;
                            } else {
                                System.out.println("Resi yang dicari tidak ada. ");
                                break;
                            }
                        case "3":
                            System.out.println("Lihat Resi");
                            for (int i = 0; i < paket.size(); i++) {
                                for (int j = 0; j < paket.get(i).size(); j++) {
                                    if (j == 0) {
                                        System.out.println("Resi: " + paket.get(i).get(j));
                                    } else if (j == 1) {
                                        System.out.println("Lokasi: " + paket.get(i).get(j));
                                    }
                                }
                                System.out.println();
                            }
                    }
                    break;
                case "2":
                    System.out.println("Menu Customer");
                    System.out.println("1. Tracking Resi Anda");
                    System.out.println("2. Hitung Estimasi Ongkos Kirim Paket");
                    MenuCust = masukan.nextLine();
                    switch (MenuCust) {
                        case "1":
                            System.out.println("Tracking Resi Anda");
                            System.out.println("Masukkan nomor resi anda: ");
                            resi = masukan.nextLine();
                            int IdTrack = 100;
                            for (int i = 0; i < paket.size(); i++) {
                                for (int j = 0; j < paket.get(i).size(); j++) {
                                    if (j == 0 && paket.get(i).get(j).equalsIgnoreCase(resi)) {
                                        IdTrack = i;
                                    }
                                }
                            }
                            if (IdTrack != 100) {
                                System.out.println("Resi dan lokasi paket anda: " + paket.get(IdTrack));
                                paket.get(IdTrack);
                            } else {
                                System.out.print("Resi yang dicari tidak ada. ");
                            }
                            break;
                        case "2":
                            System.out.println("Hitung Estimasi Tarif Kiriman Paket Anda");
                            System.out.println("Ekspedisi tersedia untuk area JABODETABEK.");
                            System.out.println("Jakarta, Bogor, Depok, Tangerang, Bekasi");
                            System.out.print("Masukkan berat paket anda dalam KG: ");
                            berat = masukan.nextInt();
                            tarif = berat * 8000;
                            System.out.println("Tarif kiriman paket anda adalah Rp" + tarif);
                    }
                    break;
                case "3":
                    System.out.println("Anda telah keluar program. Terima kasih.");
                    System.exit(0);
                    break;
                    default:
            }
        }
    }
}
            