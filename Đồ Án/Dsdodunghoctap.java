import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dsdodunghoctap implements dieukien {
    static int n;
    static List<Dodunghoctap> ds;
    static Scanner sc = new Scanner(System.in);

    public void docFile(String filename) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            n = Integer.parseInt(br.readLine());
            ds = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                if (line == null || line.trim().isEmpty())
                    break;

                String[] parts = line.split(",");

                String maSP = parts[0];
                String tenSP = parts[1];
                int soLuong = Integer.parseInt(parts[2]);
                int donGia = Integer.parseInt(parts[3]);
                String donViTinh = parts[4];
                String maLoai = parts[5];
                String maSX = parts[6];

                if (parts.length == 9) {
                    String thongTin1 = parts[7];
                    String thongTin2 = parts[8];
                    if (thongTin2.matches("\\d+")) {
                        // Butviet
                        ds.add(new Butviet(maSP, tenSP, soLuong, donGia, donViTinh, maLoai, maSX, thongTin1,
                                Integer.parseInt(thongTin2)));
                    } else {
                        // Giayso
                        ds.add(new Giayso(maSP, tenSP, soLuong, donGia, donViTinh, maLoai, maSX, thongTin1, thongTin2));
                    }
                }
            }
            n = ds.size();
        }
        System.out.println("Doc du lieu tu file thanh cong!");
    }

    public void ghiFile(String filename) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(n + "");
            bw.newLine();
            for (int i = 0; i < n; i++) {
                if (ds.get(i) != null) {
                    bw.write(ds.get(i).toFileString());
                    bw.newLine();
                }
            }
        }
        System.out.println("Ghi du lieu vao file thanh cong!");
    }

    public void xuat() {
        System.out.println(
                "==========================================================================================================");
        System.out.printf("%-8s %-18s %6s %12s %-8s %-8s %-8s %-15s %-10s\n",
                "MaSP", "TenSP", "SL", "DonGia", "DVT", "MaLoai", "MaSX", "Loai/Do", "Ngoi/Kho");
        System.out.println(
                "==========================================================================================================");

        for (int i = 0; i < n; i++) {
            Dodunghoctap d = ds.get(i);
            if (d instanceof Butviet b) {
                System.out.printf("%-8s %-18s %6d %,12d %-8s %-8s %-8s %-15s %-10s\n",
                        d.maSP, d.tenSP, d.soLuong, d.donGia, d.donViTinh, d.maLoai, d.maSX,
                        b.loaibut, b.kichcongoi);
            } else if (d instanceof Giayso g) {
                System.out.printf("%-8s %-18s %6d %,12d %-8s %-8s %-8s %-15s %-10s\n",
                        d.maSP, d.tenSP, d.soLuong, d.donGia, d.donViTinh, d.maLoai, d.maSX,
                        g.doDay, g.khoGiay);
            }
        }
        System.out.println(
                "==========================================================================================================");
        System.out.println("Tong so: " + n + " san pham");
    }

    @Override
    public void them() {
        System.out.print("Chon loai (1-Butviet, 2-Giayso): ");
        int loai = Integer.parseInt(sc.nextLine());

        String ma;
        while (true) {
            System.out.print("Ma SP: ");
            ma = sc.nextLine().trim();
            if (tim(ma) == null)
                break;
            System.out.println("Ma da ton tai!");
        }

        System.out.print("Ten SP: ");
        String ten = sc.nextLine();
        System.out.print("So luong: ");
        int sl = Integer.parseInt(sc.nextLine());
        System.out.print("Don gia: ");
        int dg = Integer.parseInt(sc.nextLine());
        System.out.print("Don vi tinh: ");
        String dvt = sc.nextLine();
        System.out.print("Ma loai: ");
        String ml = sc.nextLine();
        System.out.print("Ma SX: ");
        String msx = sc.nextLine();

        if (loai == 1) {
            System.out.print("Loai but: ");
            String lb = sc.nextLine();
            System.out.print("Kich co ngoi: ");
            int kc = Integer.parseInt(sc.nextLine());
            ds.add(new Butviet(ma, ten, sl, dg, dvt, ml, msx, lb, kc));
        } else {
            System.out.print("Do day: ");
            String dd = sc.nextLine();
            System.out.print("Kho giay: ");
            String kg = sc.nextLine();
            ds.add(new Giayso(ma, ten, sl, dg, dvt, ml, msx, dd, kg));
        }
        n = ds.size();
        System.out.println("Them thanh cong!");
    }

    @Override
    public void xoa() {
        System.out.println("Nhap ma do dung hoc tap muon xoa: ");
        String ma = sc.nextLine();
        Dodunghoctap d = tim(ma);
        if (d != null) {
            ds.remove(d);
            n = ds.size();
            System.out.println("Da xoa " + ma);
            return;
        }
        System.out.println("Khong tim thay " + ma);
    }

    @Override
    public void timkiem() {
        System.out.println("Nhap ma do dung hoc tap de tim kiem: ");
        String ma = sc.nextLine();
        Dodunghoctap d = tim(ma);
        if (d != null) {
            d.xuat();
            return;
        }
        System.out.print("Khong tim thay ma do dung hoc tap");
    }

    @Override
    public void sua() {
        System.out.print("Nhap ma do dung hoc tap can sua: ");
        String ma = sc.nextLine();
        Dodunghoctap d = tim(ma);
        if (d != null) {
            int k;
            do {
                System.out.println("---Sua thong tin do dung hoc tap---");
                System.out.println("1. Sua ma SP");
                System.out.println("2. Sua ten SP");
                System.out.println("3. Sua so luong");
                System.out.println("4. Sua don gia");
                System.out.println("5. Sua don vi tinh");
                System.out.println("6. Sua ma loai");
                System.out.println("7. Sua ma SX");
                if (d instanceof Butviet) {
                    System.out.println("8. Sua loai but");
                    System.out.println("9. Sua kich co ngoi");
                } else if (d instanceof Giayso) {
                    System.out.println("8. Sua do day");
                    System.out.println("9. Sua kho giay");
                }
                System.out.println("0. Thoat");
                System.out.print("Nhap lua chon: ");
                k = sc.nextInt();
                sc.nextLine();

                switch (k) {
                    case 1:
                        System.out.println("Vui long nhap ma SP moi: ");
                        d.maSP = sc.nextLine();
                        break;
                    case 2:
                        System.out.println("Vui long nhap ten SP moi: ");
                        d.tenSP = sc.nextLine();
                        break;
                    case 3:
                        System.out.println("Vui long nhap so luong moi: ");
                        d.soLuong = sc.nextInt();
                        sc.nextLine();
                        break;
                    case 4:
                        System.out.println("Vui long nhap don gia moi: ");
                        d.donGia = sc.nextInt();
                        sc.nextLine();
                        break;
                    case 5:
                        System.out.println("Vui long nhap don vi tinh moi: ");
                        d.donViTinh = sc.nextLine();
                        break;
                    case 6:
                        System.out.println("Vui long nhap ma loai moi: ");
                        d.maLoai = sc.nextLine();
                        break;
                    case 7:
                        System.out.println("Vui long nhap ma SX moi: ");
                        d.maSX = sc.nextLine();
                        break;
                    case 8:
                        if (d instanceof Butviet b) {
                            System.out.println("Vui long nhap loai but moi: ");
                            b.loaibut = sc.nextLine();
                        } else if (d instanceof Giayso g) {
                            System.out.println("Vui long nhap do day moi: ");
                            g.doDay = sc.nextLine();
                        }
                        break;
                    case 9:
                        if (d instanceof Butviet b) {
                            System.out.println("Vui long nhap kich co ngoi moi: ");
                            b.kichcongoi = sc.nextInt();
                            sc.nextLine();
                        } else if (d instanceof Giayso g) {
                            System.out.println("Vui long nhap kho giay moi: ");
                            g.khoGiay = sc.nextLine();
                        }
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
        System.out.println("Khong tim thay ma do dung hoc tap nay!");
    }

    private Dodunghoctap tim(String ma) {
        for (Dodunghoctap d : ds) {
            if (d.maSP.equalsIgnoreCase(ma)) {
                return d;
            }
        }
        return null;
    }

    public void thongKe() {
        int tongSL = 0;
        long tongGT = 0;
        for (Dodunghoctap d : ds) {
            tongSL += d.soLuong;
            tongGT += (long) d.soLuong * d.donGia;
        }
        System.out.println("Tong so luong: " + tongSL);
        System.out.println("Tong gia tri: " + tongGT + " VND");
    }
}
