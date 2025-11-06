package DOAN;

import java.util.*;
public class loaihang {
    String malh;
    String tenlh;
    String mota;
    // Hàm nhập loại hàng
    public void nhap() {
        try (Scanner lh = new Scanner(System.in)) {
        System.out.print("Nhap ma loai hang: ");
        malh = lh.nextLine();
        System.out.print("Nhap ten loai hang: ");
        tenlh = lh.nextLine();
        System.out.print("Nhap mo ta loai hang: ");
        mota = lh.nextLine();
        }
    }

    // Hàm xuất loại hàng
    public void xuat() {
        System.out.println("Ma loai hang: " + malh);
        System.out.println("Ten loai hang: " + tenlh);
        System.out.println("Mo ta loai hang: " + mota);
    }

    // Hàm thiết lập có tham số
    public loaihang(String malh, String tenlh, String mota){
        this.malh = malh;
        this.tenlh = tenlh;
        this.mota = mota;
    }

    // Hàm thiết lập không tham số
    public loaihang(){
        malh = "LH001";
        tenlh = "But bi";
        mota = "But viet xanh";
    }

    // Hàm thiết lập sao chép
    public loaihang(loaihang lh){
        malh = lh.malh;
        tenlh = lh.tenlh;
        mota = lh.mota;
    }

    // Hàm getter
    public String getMalh(){
        return malh;
    }
    public String getTenlh(){
        return tenlh;
    }
    public String getMota(){
        return mota;
    }

    // Hàm setter
    public void setMalh(String malh){
        this.malh = malh;
    }
    public void setTenlh(String tenlh){
        this.tenlh = tenlh;
    }
    public void setMota(String mota){
        this.mota = mota;
    }
}
