
import java.util.Scanner;

public class Nhanvien {
    private String manv;
    private String honv;
    private String tennv;
    private double luong;

    // Ham thiet lap co tham so
    public Nhanvien(String manv, String honv, String tennv, double luong) {
        this.manv = manv;
        this.honv = honv;
        this.tennv = tennv;
        this.luong = luong;
    }

    // Ham thiet lap khong tham so
    public Nhanvien() {
    }

    // Ham thiet lap sao chep
    public Nhanvien(Nhanvien nv) {
        this.manv = nv.manv;
        this.honv = nv.honv;
        this.tennv = nv.tennv;
        this.luong = nv.luong;
    }

    // Ham nhap
    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma nhan vien: ");
        manv = sc.nextLine();
        System.out.print("Nhap ho nhan vien: ");
        honv = sc.nextLine();
        System.out.print("Nhap ten nhan vien: ");
        tennv = sc.nextLine();
        System.out.print("Nhap luong nhan vien: ");
        luong = sc.nextDouble();
    }

    // ham get
    public String getManv() {
        return manv;
    }

    public String getHonv() {
        return honv;
    }

    public String getTennv() {
        return tennv;
    }

    public Double getLuong() {
        return luong;
    }

    // Ham set
    public void setManv(String manv) {
        this.manv = manv;
    }

    public void setHonv(String honv) {
        this.honv = honv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    // Ham xuat
    public void Xuat() {
        System.out.println("Ma nhan vien: " + manv);
        System.out.println("Ho nhan vien: " + honv);
        System.out.println("Ten nhan vien: " + tennv);
        System.out.println("Luong nhan vien: " + luong);
    }
}