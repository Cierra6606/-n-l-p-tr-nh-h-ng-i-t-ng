package DOAN;

import java.io.*;
import java.util.*;

public class Dshangsanxuat {
    int sohsx = 0;
    hangsanxuat[] dshsx = new hangsanxuat[0];

    // Hàm setter
    public void setDanhsach(hangsanxuat[] dshsx, int sohsx){
        this.sohsx = sohsx;
        this.dshsx = dshsx;
    }

    // Hàm thêm hãng sản xuất
    public void themhsx(){
        dshsx = Arrays.copyOf(dshsx, sohsx + 1);
        dshsx[sohsx] = new hangsanxuat();
        dshsx[sohsx].nhap();
        System.out.println("=================================");
        sohsx++;
        System.out.println("Da them hang san xuat moi thanh cong!");
    }

    // Hàm xóa hãng sản xuất theo mã
    public void xoahsx(String mahsx){
        boolean found = false;
        for(int i = 0; i < sohsx; i++){
            if (dshsx[i].getMahsx().equals(mahsx)){
                for(int j = i; j < sohsx - 1; j++){
                    dshsx[j] = dshsx[j + 1];
                }
                dshsx = Arrays.copyOf(dshsx, sohsx - 1);
                sohsx--;
                System.out.println("Da xoa hang san xuat co ma" + mahsx);
                found = true;
                break;
            }
            if (!found){
                System.out.println("===== Khong  tim thay hang san xuat co ma " + mahsx + " =====");
            }
        }
    }

    // Hàm tìm kiếm hãng sản xuất theo mã
    public void timhsx(String mahsx){
        for(int i = 0; i < sohsx; i++){
            if(dshsx[i].getMahsx().equals(mahsx)){
                System.out.println("==========================");
                System.out.println("Thong tin hang san xuat tim thay:");
                dshsx[i].xuat();
                return;
            }
            else{
                System.out.println("===== Khong tim thay hang san xuat co ma" + mahsx + " =====");
            }
        }
    }

    // Hàm tìm kiếm hãng sản xuất theo tên
    public void timhsxten(String tenhsx) {
        for (int i = 0; i < sohsx; i++){
            if (dshsx[i].getTenhsx().equalsIgnoreCase(tenhsx)) {
                System.out.println("==========================");
                System.out.println("Thong tin hang san xuat tim thay:");
                dshsx[i].xuat();
                return;
            }
            else{
                System.out.println("===== Khong tim thay hang san xuat co ten " + tenhsx + " =====");
            }
        }
    }

    // Hàm thống kê tổng số hãng sản xuất
    public void thongkehsx(){
        System.out.printf("%-15s %-15s %-15s%n", "Ma hang san xuat", "Ten hang san xuat", "Dia chi hang san xuat");
        System.out.println("-----------------------------------");
        for (int i = 0; i < sohsx; i++) {
            System.out.printf("%-15s %-15s %-15s%n", dshsx[i].getMahsx(), dshsx[i].getTenhsx(), dshsx[i].getDiachi());
        }
        System.out.print("\nTong so hang san xuat: " + sohsx);
    }

    // Hàm ghi hãng sản xuất vào file
    public void ghifile() {
        String filename = "hangsanxuat.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < sohsx; i++) {
                bw.write(dshsx[i].getMahsx() + "," + dshsx[i].getTenhsx() + "," + dshsx[i].getDiachi());
                bw.newLine();
            }
            System.out.println("===== Da ghi danh sach hang san xuat vao file " + filename + " =====");
        } catch (IOException e){
            System.out.println("===== Loi ghi file: " + e.getMessage() + " =====");
        }
    }

    // Hàm đọc hãng sản xuất vào file
    public void docFileds(String filename) {
        filename = "loaihang.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            sohsx = 0;
            dshsx= new hangsanxuat[0];
            System.out.println("===== Danh sach loai hang =====");
            System.out.printf("%-15s %-15s %-15s\n", "Ma hang san xuat", "Ten hang san xuat", "Dia chi hang san xuat");
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    dshsx = Arrays.copyOf(dshsx, sohsx + 1);
                    dshsx[sohsx] = new hangsanxuat();
                    dshsx[sohsx].setMahsx(parts[0]);
                    dshsx[sohsx].setTenhsx(parts[1]);
                    dshsx[sohsx].setDiachi(parts[2]);
                    System.out.printf("%-15s %-15s %-15s\n", parts[0], parts[1], parts[2]);
                    sohsx++;
                }
            }
            System.out.println("===== Da doc danh sach hang san xuat tu file " + filename + " =====");
        } catch (IOException e) {
            System.out.println("===== Loi khi doc file: " + e.getMessage() + " =====");
        }
    }
}
