package DOAN;

import java.util.*;
public class hangsanxuat {
    String mahsx;
    String tenhsx;
    String diachi;
    private static final Scanner hsx = new Scanner(System.in);

    // Hàm thiết lập có tham số
    public hangsanxuat(String mahsx, String tenhsx, String diachi){
        this.mahsx = mahsx;
        this.tenhsx = tenhsx;
        this.diachi = diachi;
    }

    // Hàm thiết lập không tham số
    public hangsanxuat(){
        mahsx = "HSX002";
        tenhsx = "Cty Vin";
        diachi = "Tp Ho Chi Minh";
    }

    // Hàm thiết lập sao chép
    public hangsanxuat(hangsanxuat hsx){
        mahsx = hsx.mahsx;
        tenhsx = hsx.tenhsx;
        diachi = hsx.diachi;
    }

    // Hàm nhập
    public void nhap(){
        System.out.print("Nhap ma hang san xuat: ");
        mahsx = hsx.nextLine();
        System.out.print("Nhap ten hang san xuat: ");
        tenhsx = hsx.nextLine();
        System.out.print("Nhap dia chi hang san xuat: ");
        diachi = hsx.nextLine();
    }

    // Hàm xuất
    public void xuat(){
        System.out.println("Ma hang san xuat: " + mahsx);
        System.out.println("Ten hang san xuat: " + tenhsx);
        System.out.println("Dia chi hang san xuat: " + diachi);
    }

    // Hàm getter
    public String getMahsx(){
        return mahsx;
    }
    public String getTenhsx(){
        return tenhsx;
    }
    public String getDiachi(){
        return diachi;
    }

    // Hàm setter
    public void setMahsx(String mahsx){
        this.mahsx = mahsx;
    }
    public void setTenhsx(String tenhsx){
        this.tenhsx = tenhsx;
    }
    public void setDiachi(String diachi){
        this.diachi = diachi;
    }
}
