package secondtryATM;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Account a = new Account();
        Transaksi t = new Transaksi();
        Scanner s = new Scanner(System.in);

        System.out.println("==== Selamat Datang Di ATM ====");
        System.out.println("Masukkan PIN Anda : ");
        int enteredPin = s.nextInt();

        if (enteredPin == a.pin){
            while (true){
                System.out.println("Menu ATM : ");
                System.out.println("1. Tarik Tunai");
                System.out.println("2. Transfer");
                System.out.println("3. Cek Saldo");
                System.out.println("4. Beli Pulsa");
                System.out.println("5. keluar");
                System.out.println("Pilih Opsi : ");
                int choice = s.nextInt();

                switch (choice){
                    case 1:
                        System.out.println("1. Tarik Tunai");
                        System.out.println("A. Rp50.000");
                        System.out.println("B. Rp100.000");
                        System.out.println("Pilih Jumlah (A/B) :");
                        char tariktunaiopsi = s.next().charAt(0);
                        int jumtarik = 0;

                        if (tariktunaiopsi == 'A'){
                            jumtarik = 50_000;
                        } else if (tariktunaiopsi == 'B') {
                            jumtarik = 100_000;
                        } else {
                            System.out.println("Pilihan tidak valid");
                        }
                        if (jumtarik > 0 && jumtarik <= a.saldo) {
                            a.saldo -= jumtarik;
                            System.out.println("Penarikan sebesar Rp" + jumtarik);
                            System.out.println("Transaksi sukses!!");
                            System.out.println("Saldo yang tersisa : Rp " + a.saldo);
                        } else {
                            System.out.println("Saldo tidak mencukupi.");
                        }
                        break;
                    case 2:
                        System.out.println("2. Transfer");
                        System.out.println("A. BCA (Biaya Transfer: Rp0)");
                        System.out.println("B. BRI (Biaya Transfer: Rp2.500)");
                        System.out.println("C. BNI (Biaya Transfer: Rp3.500)");
                        System.out.print("Pilih bank (A/B/C): ");
                        char opbank = s.next().charAt(0);
                        int biayaadmin = 0;

                        if (opbank == 'A') {
                            biayaadmin = t.bca;
                        } else if (opbank == 'B') {
                            biayaadmin = t.bri;
                        } else if (opbank == 'C') {
                            biayaadmin = t.bni;
                        } else {
                            System.out.println("Pilihan bank tidak valid");
                        }

                        System.out.print("Masukkan jumlah transfer: ");
                        int jumtrans = s.nextInt();

                        if (jumtrans > 0 && jumtrans <= a.saldo) {
                            a.saldo -= (jumtrans + biayaadmin);
                            System.out.println("Transfer berjumlah : Rp  " + jumtrans);
                            System.out.println("Transfer sukses!!");
                            System.out.println("Saldo yang tersisa : Rp " + a.saldo);
                        } else {
                            System.out.println("Saldo tidak mencukupi.");
                        }
                        break;
                    case 3:
                        System.out.println("3. Cek Saldo");
                        System.out.println("Saldo Anda saat ini: Rp" + a.saldo);
                        break;
                    case 4:
                        System.out.println("4. Beli Pulsa");
                        System.out.print("Masukkan nominal pulsa yang ingin dibeli: ");
                        int jumpul = s.nextInt();

                        if (jumpul > 0 && jumpul <= a.saldo) {
                            a.saldo -= jumpul;
                            System.out.println("Pulsa sebesar Rp" + jumpul);
                            System.out.println("Telah terkirim!!");
                            System.out.println("Saldo yang tersisa : Rp " + a.saldo);
                        } else {
                            System.out.println("Saldo tidak mencukupi.");
                        }
                        break;
                    case 5:
                        System.out.println("Terima kasih");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Pilihan tidak valid");
                        break;
                }
            }
        } else {
            System.out.println("Pin Salah !!");
        }
    }
}