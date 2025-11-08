import java.util.Scanner;

public class Nhanvien {
    private String manv;
    private String honv;
    private String tennv;
    private double luong;

    static Scanner sc = new Scanner(System.in);

    // ---- Constructors ----
    public Nhanvien() {}

    public Nhanvien(String manv, String honv, String tennv, double luong) {
        this.manv = manv;
        this.honv = honv;
        this.tennv = tennv;
        this.luong = luong;
    }

    // ---- Getters & Setters ----
    public String getManv() { return manv; }
    public void setManv(String manv) { this.manv = manv; }

    public String getHonv() { return honv; }
    public void setHonv(String honv) { this.honv = honv; }

    public String getTennv() { return tennv; }
    public void setTennv(String tennv) { this.tennv = tennv; }

    public double getLuong() { return luong; }
    public void setLuong(double luong) { this.luong = luong; }

    // ---- Nhap / Xuat ----
    public void nhap() {
        System.out.print("Nhap ma nhan vien: ");
        manv = sc.nextLine();

        System.out.print("Nhap ho nhan vien: ");
        honv = sc.nextLine();

        System.out.print("Nhap ten nhan vien: ");
        tennv = sc.nextLine();

        System.out.print("Nhap luong: ");
        luong = Double.parseDouble(sc.nextLine());
    }

    public void xuat() {
        System.out.println("Ma NV: " + manv);
        System.out.println("Ho: " + honv);
        System.out.println("Ten: " + tennv);
        System.out.println("Luong: " + luong);
    }

    @Override
    public String toString() {
        return manv + "," + honv + "," + tennv + "," + luong;
    }
}
