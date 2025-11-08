import java.io.*;
import java.util.*;

public class DsCTDH implements dieukien {
    static int n;
    static ChiTietDonHang[] ds;
    static Scanner sc = new Scanner(System.in);

    public DsCTDH() {
        ds = new ChiTietDonHang[0];
        n = 0;
    }

    public void docFile(String filename) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            n = Integer.parseInt(br.readLine());
            ds = new ChiTietDonHang[n];
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                if (line == null || line.trim().isEmpty())
                    break;

                String[] parts = line.split(",");
                String mahd = parts[0];
                String msp = parts[1];
                int sl = Integer.parseInt(parts[2]);
                double dongia = Double.parseDouble(parts[3]);

                ds[i] = new ChiTietDonHang(mahd, msp, sl, dongia);
            }
            System.out.println("Doc file thanh cong (" + n + " dong du lieu)");
        }
    }

    public void ghiFile(String filename) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(n + "");
            bw.newLine();
            for (int i = 0; i < n; i++) {
                if (ds[i] != null) {
                    bw.write(ds[i].getMahd() + "," +
                            ds[i].getMsp() + "," +
                            ds[i].getSl() + "," +
                            ds[i].getDongia());
                    bw.newLine();
                }
            }
        }
        System.out.println("Ghi file thanh cong!");
    }

    public void xuat() {
        for (int i = 0; i < n; i++) {
            System.out.println("------------------------");
            System.out.println("Thong tin chi tiet don hang thu " + (i + 1) + ": ");
            ds[i].xuat();
        }
    }

    @Override
    public void them() {
        ds = Arrays.copyOf(ds, n + 1);
        ds[n] = new ChiTietDonHang();
        ds[n].nhap();
        n++;
        System.out.println("Da them chi tiet don hang thanh cong!");
    }

    @Override
    public void xoa() {
        System.out.println("Nhap ma hoa don muon xoa: ");
        String mahd = sc.nextLine();
        System.out.println("Nhap ma san pham muon xoa: ");
        String msp = sc.nextLine();

        for (int i = 0; i < n; i++) {
            if (ds[i].getMahd().equals(mahd) && ds[i].getMsp().equals(msp)) {
                for (int j = i; j < n - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds = Arrays.copyOf(ds, n - 1);
                n--;
                System.out.println("Da xoa " + mahd + " - " + msp);
                return;
            }
        }
        System.out.println("Khong tim thay " + mahd + " - " + msp);
    }

    @Override
    public void timkiem() {
        System.out.println("Nhap ma hoa don de tim kiem: ");
        String mahd = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMahd().equalsIgnoreCase(mahd)) {
                ds[i].xuat();
                return;
            }
        }
        System.out.print("Khong tim thay ma hoa don");
    }

    @Override
    public void sua() {
        System.out.print("Nhap ma hoa don can sua: ");
        String mahd = sc.nextLine();
        System.out.print("Nhap ma san pham can sua: ");
        String msp = sc.nextLine();

        for (int i = 0; i < n; i++) {
            if (ds[i].getMahd().equalsIgnoreCase(mahd) && ds[i].getMsp().equalsIgnoreCase(msp)) {
                int k;
                do {
                    System.out.println("---Sua thong tin chi tiet don hang---");
                    System.out.println("1. Sua ma hoa don");
                    System.out.println("2. Sua ma san pham");
                    System.out.println("3. Sua so luong");
                    System.out.println("4. Sua don gia");
                    System.out.println("0. Thoat");
                    System.out.print("Nhap lua chon: ");
                    k = sc.nextInt();
                    sc.nextLine();

                    switch (k) {
                        case 1:
                            System.out.println("Vui long nhap ma hoa don moi: ");
                            ds[i].setMahd(sc.nextLine());
                            break;
                        case 2:
                            System.out.println("Vui long nhap ma san pham moi: ");
                            ds[i].setMsp(sc.nextLine());
                            break;
                        case 3:
                            System.out.println("Vui long nhap so luong moi: ");
                            ds[i].setSl(sc.nextInt());
                            sc.nextLine();
                            break;
                        case 4:
                            System.out.println("Vui long nhap don gia moi: ");
                            ds[i].setDongia(sc.nextDouble());
                            sc.nextLine();
                            break;
                        case 0:
                            System.out.println("Thoat sua thong tin.");
                            break;
                        default:
                            System.out.println("Lua chon khong hop le!");
                    }
                } while (k != 0);
                return;
            }
        }
        System.out.println("Khong tim thay chi tiet don hang nay!");
    }

    public boolean kiemTraTrungMa(String mahd) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMahd().equalsIgnoreCase(mahd)) {
                return true;
            }
        }
        return false;
    }
}