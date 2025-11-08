import java.util.Scanner;

class Dsnhanvien {
    int n;
    Nhanvien[] ds;
    Scanner sc = new Scanner(System.in);

    public void Nhap() {
        System.out.println("Nhap so luong nhan vien: ");
        n = sc.nextInt();
        ds = new Nhanvien[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin nhan vien thu " + (i + 1) + ": ");
            ds[i] = new Nhanvien();
            ds[i].Nhap();
        }
    }

    public void Xuat() {
        for (int i = 0; i < n; i++) {
            System.out.println("---------------------------");
            System.out.println("Thong tin nhan vien thu " + (i + 1) + ": ");
            ds[i].Xuat();
        }
    }

}