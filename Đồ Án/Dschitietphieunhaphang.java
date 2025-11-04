import java.util.Scanner;
import java.util.Arrays;

public class Dschitietphieunhaphang {
    int n;
    chitietphieunhaphang[] ds;
    Scanner sc = new Scanner(System.in);

    public void xuat() {
        for (int i = 0; i < n; i++) {
            System.out.println("---------------------------");
            System.out.println("Thong tin chi tiet phieu nhap hang thu " + (i + 1) + ": ");
            System.out.println("Ma PNH: " + ds[i].getMaPNH());
            System.out.println("Ma Hang: " + ds[i].getMaHang());
            System.out.println("So Luong: " + ds[i].getSoLuong());
            System.out.println("Thanh Tien: " + ds[i].Thanhtien());
        }
    }

    public void nhap() {
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin chi tiet phieu nhap hang thu " + (i + 1) + ": ");
            System.out.print("Ma PNH: ");
            String maPNH = sc.nextLine();
            System.out.print("Ma Hang: ");
            String maHang = sc.nextLine();
            System.out.print("So Luong: ");
            int soLuong = sc.nextInt();
            System.out.print("Don Gia: ");
            double donGia = sc.nextDouble();
            sc.nextLine(); // Consume newline
            ds[i] = new chitietphieunhaphang(maPNH, maHang, soLuong, donGia);
        }
    }

    public void themChiTietPNH() {
        ds = Arrays.copyOf(ds, n + 1);
        System.out.println("Nhap thong tin chi tiet phieu nhap hang thu " + (n + 1) + ": ");
        System.out.print("Ma PNH: ");
        String maPNH = sc.nextLine();
        System.out.print("Ma Hang: ");
        String maHang = sc.nextLine();
        System.out.print("So Luong: ");
        int soLuong = sc.nextInt();
        System.out.print("Don Gia: ");
        double donGia = sc.nextDouble();
        sc.nextLine();
        ds[n] = new chitietphieunhaphang(maPNH, maHang, soLuong, donGia);
        n++;
        System.out.println("Da them chi tiet phieu nhap hang moi thanh cong!");
    }

    public void xoaChiTietPNH(String maPNH) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaPNH().equals(maPNH)) {
                for (int j = i; j < n - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds = Arrays.copyOf(ds, n - 1);
                n--;
                System.out.println("Da xoa chi tiet phieu nhap hang co ma PNH " + maPNH);
                return;
            }
        }
        System.out.println("Khong tim thay chi tiet phieu nhap hang co ma PNH " + maPNH);
    }

    public void timKiemChiTietPNH() {
        System.out.print("Nhap ma PNH can tim: ");
        String maPNH = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaPNH().equalsIgnoreCase(maPNH)) {
                System.out.println("Thong tin chi tiet phieu nhap hang:");
                System.out.println("Ma PNH: " + ds[i].getMaPNH());
                System.out.println("Ma Hang: " + ds[i].getMaHang());
                System.out.println("So Luong: " + ds[i].getSoLuong());
                System.out.println("Thanh Tien: " + ds[i].Thanhtien());
                return;
            }
        }
        System.out.println("Khong tim thay chi tiet phieu nhap hang co ma PNH " + maPNH);
    }

    public void suaNCC(String maPNH) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaPNH().equals(maPNH)) {
                int k;
                do {
                    System.out.println("\n--- Sua thong tin chi tiet phieu nhap hang ---");
                    System.out.println("1. Sua ma phieu nhap hang");
                    System.out.println("2. Sua ma hang");
                    System.out.println("3. Sua so luong");
                    System.out.println("0. Thoat sua");
                    System.out.print("Nhap lua chon: ");
                    k = sc.nextInt();
                    sc.nextLine(); // bỏ dòng thừa

                    switch (k) {
                        case 1:
                            System.out.print("Nhap ma phieu nhap hang moi: ");
                            ds[i].setMaPNH(sc.nextLine());
                            break;
                        case 2:
                            System.out.print("Nhap ma hang moi: ");
                            ds[i].setMaHang(sc.nextLine());
                            break;
                        case 3:
                            System.out.print("Nhap so luong moi: ");
                            ds[i].setSoLuong(sc.nextInt());
                            break;
                        case 0:
                            System.out.println("Da thoat sua thong tin.");
                            break;
                        default:
                            System.out.println("Lua chon khong hop le!");
                            break;
                    }
                } while (k != 0);
                return;
            }
        }
        System.out.println("Khong tim thay phieu nhap hang voi ma nay.");
    }

    public void setDanhSach(chitietphieunhaphang[] ds, int n) {
        this.ds = ds;
        this.n = n;
    }
}
