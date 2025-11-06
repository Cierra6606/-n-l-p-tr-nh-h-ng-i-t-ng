package DOAN;

import java.util.*;

public class QLnhanvien {
    public static void main(String[] args) {
        Dsnhanvien dsnv = new Dsnhanvien();
        nhanvien[] nv = new nhanvien[5];
        nv[0] = new nhanvien("NV001", "Nguyen", "An", 5000);
        nv[1] = new nhanvien("NV002", "Tran", "Binh", 6000);
        nv[2] = new nhanvien("NV003", "Le", "Cuong", 5500);
        nv[3] = new nhanvien("NV004", "Pham", "Duc", 7000);
        nv[4] = new nhanvien("NV005", "Hoang", "Hung", 6500);
        dsnv.setDanhSach(nv, 5);

        Scanner sc = new Scanner(System.in);
        int n;
        do {
            System.out.println("\n===== QUAN LY NHAN VIEN =====");
            System.out.println("1. Them nhan vien");
            System.out.println("2. Hien thi danh sach nhan vien");
            System.out.println("3. Tim kiem nhan vien theo ma");
            System.out.println("4. Xoa nhan vien theo ma");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");
            n = sc.nextInt();
            sc.nextLine(); // bỏ dòng trống

            switch (n) {
                case 1:
                    dsnv.themNV();
                    break;
                case 2:
                    dsnv.xuatDS();
                    break;
                case 3:
                    System.out.print("Nhap ma nhan vien can tim: ");
                    String maTim = sc.nextLine();
                    dsnv.timKiemNV(maTim);
                    break;
                case 4:
                    System.out.print("Nhap ma nhan vien can xoa: ");
                    String maXoa = sc.nextLine();
                    dsnv.xoaNV(maXoa);
                    break;
                case 0:
                    System.out.println("Da thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (n != 0);
    }
}
