import java.io.*;
import java.util.*;

public class Dsdodunghoctap {
    private List<Dodunghoctap> dsDodung = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    // ===== ĐỌC FILE =====
    public void docFile(String filename) {
        dsDodung.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] t = line.split(",", -1);
                if (t.length < 7)
                    continue;

                String ma = t[0].trim();
                String ten = t[1].trim();
                int sl = Integer.parseInt(t[2].trim());
                int dg = Integer.parseInt(t[3].trim());
                String dvt = t[4].trim();
                String ml = t[5].trim();
                String msx = t[6].trim();

                if (t.length == 9) {
                    String i1 = t[7].trim();
                    String i2 = t[8].trim();
                    if (i2.matches("\\d+"))
                        dsDodung.add(new Butviet(ma, ten, sl, dg, dvt, ml, msx, i1, Integer.parseInt(i2)));
                    else
                        dsDodung.add(new Giayso(ma, ten, sl, dg, dvt, ml, msx, i1, i2));
                }
            }
            System.out.println("Doc file thanh cong: " + dsDodung.size() + " san pham.\n");
        } catch (Exception e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }

    // ===== GHI FILE =====
    public void ghiFile(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Dodunghoctap d : dsDodung) {
                bw.write(d.toFileString());
                bw.newLine();
            }
            System.out.println("Da luu file thanh cong!");
        } catch (Exception e) {
            System.out.println("Loi ghi file!");
        }
    }

    // ===== NHẬP THÊM =====
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
            dsDodung.add(new Butviet(ma, ten, sl, dg, dvt, ml, msx, lb, kc));
        } else {
            System.out.print("Do day: ");
            String dd = sc.nextLine();
            System.out.print("Kho giay: ");
            String kg = sc.nextLine();
            dsDodung.add(new Giayso(ma, ten, sl, dg, dvt, ml, msx, dd, kg));
        }
        System.out.println("Them thanh cong!\n");
    }

    // ===== SỬA =====
    public void sua() {
        System.out.print("Nhap ma SP can sua: ");
        String ma = sc.nextLine().trim();
        Dodunghoctap d = tim(ma);
        if (d == null) {
            System.out.println("Khong tim thay!");
            return;
        }

        System.out.print("Ten moi (" + d.tenSP + "): ");
        String s = sc.nextLine().trim();
        if (!s.isEmpty())
            d.tenSP = s;

        System.out.print("So luong (" + d.soLuong + "): ");
        s = sc.nextLine().trim();
        if (!s.isEmpty())
            d.soLuong = Integer.parseInt(s);

        System.out.print("Don gia (" + d.donGia + "): ");
        s = sc.nextLine().trim();
        if (!s.isEmpty())
            d.donGia = Integer.parseInt(s);

        if (d instanceof Butviet b) {
            System.out.print("Loai but (" + b.loaibut + "): ");
            s = sc.nextLine().trim();
            if (!s.isEmpty())
                b.loaibut = s;
            System.out.print("Kich co (" + b.kichcongoi + "): ");
            s = sc.nextLine().trim();
            if (!s.isEmpty())
                b.kichcongoi = Integer.parseInt(s);
        } else if (d instanceof Giayso g) {
            System.out.print("Do day (" + g.doDay + "): ");
            s = sc.nextLine().trim();
            if (!s.isEmpty())
                g.doDay = s;
            System.out.print("Kho giay (" + g.khoGiay + "): ");
            s = sc.nextLine().trim();
            if (!s.isEmpty())
                g.khoGiay = s;
        }

        System.out.println("Sua thanh cong!\n");
    }

    // ===== XÓA =====
    public void xoa() {
        System.out.print("Nhap ma SP can xoa: ");
        String ma = sc.nextLine().trim();
        Dodunghoctap d = tim(ma);
        if (d == null) {
            System.out.println("Khong tim thay!");
            return;
        }
        System.out.print("Xac nhan xoa (y/n): ");
        if (sc.nextLine().equalsIgnoreCase("y")) {
            dsDodung.remove(d);
            System.out.println("Da xoa!\n");
        } else {
            System.out.println("Huy xoa.\n");
        }
    }

    // ===== TÌM KIẾM =====
    public void timKiem() {
        System.out.print("Nhap ma SP can tim: ");
        String ma = sc.nextLine().trim();
        Dodunghoctap d = tim(ma);
        if (d == null)
            System.out.println("Khong tim thay!");
        else {
            xuatTieuDe();
            d.xuat();
        }
    }

    // ===== THỐNG KÊ =====
    public void thongKe() {
        int tongSL = dsDodung.stream().mapToInt(d -> d.soLuong).sum();
        long tongGT = dsDodung.stream().mapToLong(d -> (long) d.soLuong * d.donGia).sum();
        System.out.println("Tong so luong: " + tongSL);
        System.out.println("Tong gia tri: " + tongGT + " VND\n");
    }

    // ===== TÌM MÃ =====
    private Dodunghoctap tim(String ma) {
        for (Dodunghoctap d : dsDodung)
            if (d.maSP.equalsIgnoreCase(ma))
                return d;
        return null;
    }

    private void xuatTieuDe() {
        System.out.printf("%-8s %-18s %6s %12s %-8s %-8s %-8s %-15s %-10s\n",
                "MaSP", "TenSP", "SL", "DonGia", "DVT", "MaLoai", "MaSX", "Loai/Do", "Ngoi/Kho");
        System.out.println(
                "----------------------------------------------------------------------------------------------------------");
    }

    public void xuat() {
        System.out.println("\n=== DANH SACH SAN PHAM ===");
        if (dsDodung.isEmpty()) {
            System.out.println("Danh sach trong!");
        } else {
            xuatTieuDe();
            for (Dodunghoctap d : dsDodung) {
                System.out.printf("%-8s %-18s %6d %,12d %-8s %-8s %-8s %-15s %-10s\n",
                        d.maSP, d.tenSP, d.soLuong, d.donGia,
                        d.donViTinh, d.maLoai, d.maSX,
                        (d instanceof Butviet b ? b.loaibut : ((Giayso) d).doDay),
                        (d instanceof Butviet b ? b.kichcongoi : ((Giayso) d).khoGiay));
            }
        }
        System.out.println(
                "----------------------------------------------------------------------------------------------------------");
        System.out.println("Tong: " + dsDodung.size() + " san pham.\n");
    }
}
