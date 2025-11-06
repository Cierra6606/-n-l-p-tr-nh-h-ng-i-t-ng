package DOAN;

import java.util.*;

public class nhanvien {
    String manv;
    String honv;
    String tennv;
    int luong;

    // Ham thiet lap co tham so
    public nhanvien(String manv, String honv, String tennv, int luong) {
        this.manv = manv;
        this.honv = honv;
        this.tennv = tennv;
        this.luong = luong;
    }

    // Ham thiet lap khong tham so
    public nhanvien() {
        manv = "NV001";
        honv = "Nguyen Van";
        tennv = "Ta";
        luong = 5000;
    }

    // Ham thiet lap sao chep
    public nhanvien(nhanvien nv) {
        this.manv = nv.manv;
        this.honv = nv.honv;
        this.tennv = nv.tennv;
        this.luong = nv.luong;
    }

    // Ham nhap
    public void nhap(){
        try (Scanner sc = new Scanner(System.in)){
                System.out.print("Nhap ma nhan vien: ");
                manv = sc.nextLine();
                System.out.print("Nhap ho nhan vien: ");
                honv = sc.nextLine();
                System.out.print("Nhap ten nhan vien: ");
                tennv = sc.nextLine();
                System.out.print("Nhap luong nhan vien: ");
                luong = sc.nextInt();
            }
        }

    // Ham xuat
    public void xuat(){
        System.out.println("Ma nhan vien: " + manv);
        System.out.println("Ho nhan vien: " + honv);
        System.out.println("Ten nhan vien: " + tennv);
        System.out.println("Luong nhan vien: " + luong);
    }
    
    // ham get
    public String getManv(){
        return manv;
    }
    public String getHonv(){
        return honv;
    }
    public String getTennv(){
        return tennv;
    }
    public int getLuong(){
        return luong;
    }

    // Ham set
    public void setManv(String manv){
        this.manv = manv;
    }
    public void setHonv(String honv){
        this.honv = honv;
    }
    public void setTennv(String tennv){
        this.tennv = tennv;
    }
    public void setLuong(int luong){
        this.luong = luong;
    }
}