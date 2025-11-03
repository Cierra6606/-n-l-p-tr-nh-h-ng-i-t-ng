package DOAN;

import java.util.*;
import java.io.*;
class Dsnhanvien{
    private int soNV = 0;
    private nhanvien[] dsNV = new nhanvien[0];
    private static final Scanner sc = new Scanner(System.in);

    // Ham set danh sach nhan vien
    public void setDanhSach(nhanvien[] dsNV, int soNV){
        this.dsNV = dsNV;
        this.soNV = soNV;
    }

    // Ham nhap danh sach nhan vien
    public void nhapDS(){
        System.out.print("Nhap so luong nhan vien: ");
        soNV = sc.nextInt();
        dsNV = new nhanvien[soNV];
    }
    
    // Ham hien thi danh sach nhan vien
    public void xuatDS(){
        System.out.println("===== Danh sach nhan vien =====");
        System.out.printf("%-15s %-15s %-15s %-20s\n",  "Ma nhan vien", "Ho nhan vien", "Ten nhan vien", "Luong");
        for(int i=0; i<soNV; i++){
            System.out.printf("%-15s %-15s %-10s %10d\n", dsNV[i].manv, dsNV[i].honv, dsNV[i].tennv, dsNV[i].luong);
        }
    }

    // Ham them nhan vien
    public void themNV(){
        dsNV = Arrays.copyOf(dsNV, soNV + 1);
        dsNV[soNV] = new nhanvien();
        dsNV[soNV].nhap();
        System.out.println("================================");
        soNV++;
        System.out.println("Da them nhan vien moi thanh cong!");
    }

    // Ham xoa nhan vien theo ma
    public void xoaNV(String manv){
        boolean found = false;
        for(int i=0; i<soNV; i++){
            if(dsNV[i].getManv().equals(manv)){
                for(int j=i; j<soNV-1; j++){
                    dsNV[j] = dsNV[j+1];
                }
                dsNV = Arrays.copyOf(dsNV, soNV-1);
                soNV--;
                System.out.println("Da xoa nhan vien co ma " + manv);
                found = true;
                break;
            }
            if (!found) {
                System.out.println("Khong tim thay nhan vien co ma " + manv);
            }
        }

    }

    // Ham tim kiem nhan vien theo ma
    public void timKiemNV(String manv){
        for(int i=0; i<soNV; i++){
            if(dsNV[i].getManv().equals(manv)){
                System.out.println("================================");
                System.out.println("Thong tin nhan vien tim thay:");
                dsNV[i].xuat();
                return;
            } else {
                System.out.println("Khong tim thay nhan vien co ma " + manv);
            }
        }
    }

    // Hàm tìm kiếm nhân vien theo tên
    public void timkienNVten(String tennv) {
        for (int i = 0; i < soNV; i++) {
            if (dsNV[i].getTennv().equalsIgnoreCase(tennv)) {
                System.out.println("================================");
                System.out.println("Thong tin nhan vien tim thay:");
                dsNV[i].xuat();
                return;
            } else {
                System.out.println("Khong tim thay nhan vien co ten " + tennv);
            }
        }
    }

    // Hàm sửa nhân viên theo mã
    public void suaNV(String manv){
        for(int i = 0; i < soNV; i++) {
            if (dsNV[i].getManv().equals(manv)) {
                System.out.println("===== Nhap thong tin moi cho nhan vien: =====");
                dsNV[i].nhap();
                System.out.println("===== Da sua thong tin nhan vien co ma " + manv + " =====");
            } else {
                System.out.println("===== Khong tim thay nhan vien co ma " + manv + " =====");
            }
        }
    }

    // Hàm thống kê lương nhân viên
    public void thongkeluong() {
        int tongluong = 0;
        for (int i = 0; i < soNV; i++) {
            tongluong += dsNV[i].getLuong();
        }
        System.out.println("Thong ke tong luong cua tat ca nhan vien: " + tongluong);
    }

    // Hàm ghifile danh sách nhân viên
    public void ghiFileds(String filename) {
        filename = "nhanvien.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < soNV; i++) {
                bw.write(dsNV[i].getManv() + "," + dsNV[i].getHonv() + "," + dsNV[i].getTennv() + "," + dsNV[i].getLuong());
                bw.newLine();
            }
            System.out.println("Da ghi danh sach nhan vien vao file " + filename);
        } catch (IOException e) {
            System.out.println("Loi khi ghi file: " + e.getMessage());
        }
    }

    // Hàm docfile danh sách nhân viên
    public void docFileds(String filename) {
        filename = "nhanvien.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            soNV = 0;
            dsNV = new nhanvien[0];
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    dsNV = Arrays.copyOf(dsNV, soNV + 1);
                    dsNV[soNV] = new nhanvien();
                    dsNV[soNV].setManv(parts[0]);
                    dsNV[soNV].setHonv(parts[1]);
                    dsNV[soNV].setTennv(parts[2]);
                    dsNV[soNV].setLuong(Integer.parseInt(parts[3]));
                    System.out.printf("%-15s %-15s %-15s %10d\n", parts[0], parts[1], parts[2], Integer.parseInt(parts[3]));
                    soNV++;
                }
            }
            System.out.println("===== Da doc danh sach nhan vien tu file " + filename + " =====");
        } catch (IOException e) {
            System.out.println("===== Loi khi doc file: " + e.getMessage() + " =====");
        }
    }
}
