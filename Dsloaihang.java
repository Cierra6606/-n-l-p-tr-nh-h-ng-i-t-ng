package DOAN;

import java.util.*;
import java.io.*;
public class Dsloaihang {
    int solh;
    loaihang[] dslh = new loaihang[0];
    Scanner sc = new Scanner(System.in);

    // Hàm setter
    public void setDanhsach(loaihang[] dslh, int solh){
        this.solh = solh;
        this.dslh = dslh;
    }

    // Hàm thêm loại hàng
    public void themlh(){
        dslh = Arrays.copyOf(dslh, solh + 1);
        dslh[solh] = new loaihang();
        dslh[solh].nhap();
        System.out.println("=================");
        solh++;
        System.out.println("Da them vao loai hang moi thanh cong!");
    }

    // Hàm xóa loại hàng theo mã
    public void xoalh(String malh){
        boolean found = false;
        for(int i = 0; i < solh; i++){
            if(dslh[i].getMalh().equals(malh)){
                for(int j = i; j < solh - 1; j++){
                    dslh[j] = dslh[j + 1];
                }
                dslh = Arrays.copyOf(dslh, solh - 1);
                solh--;
                System.out.println("Da xoa loai hang co ma " + malh);
                found = true;
                break;
            }
            if (!found){
                System.out.println("===== Khong tim thay loai hang co ma" + malh + " =====");
            }
        }
    }

    // Hàm tìm kiếm loại hàng theo mã
    public void timkiemlh(String malh){
        for(int i = 0; i < solh; i++){
            if(dslh[i].getMalh().equals(malh)){
                System.out.println("================================");
                System.out.println("Thong tin loai hang tim thay:");
                dslh[i].xuat();
                return;
            }
            else{
                System.out.println("===== Khong tim thay loai hang co ma " + malh + " =====");
            }
        }
    }

    // Hàm tìm kiếm loại hàng theo tên
    public void timkiemlhten(String tenlh){
        for (int i = 0; i < solh; i++) {
            if (dslh[i].getTenlh().equalsIgnoreCase(tenlh)) {
                System.out.println("================================");
                System.out.println("Thong tin loai hang moi:");
                dslh[i].xuat();
                return;
            } else {
                System.out.println("===== Khong co loai hang ten " + tenlh + " =====");
            }
        }
    }

    // Hàm sửa loại hàng
    public void suaLH(String malh){
        for(int i = 0; i < solh; i++) {
            if (dslh[i].getMalh().equals(malh)) {
                int k;
                do {
                    System.out.println("\n----- Sua thong tin loai hang ");
                    System.out.println("1. Sua ma loai hang.");
                    System.out.println("2. Sua ten loai hang.");
                    System.out.println("3. Sua mo ta loai hang.");
                    k = sc.nextInt();
                    sc.nextLine();

                    switch (k) {
                        case 1:
                            System.out.println("Nhap ma moi: ");
                            dslh[i].setMalh(sc.nextLine());
                            break;
                        case 2:
                            System.out.println("Nhap ten moi: ");
                            dslh[i].setMalh(sc.nextLine());
                            break;
                        case 3:
                            System.out.println("Nhap mo ta moi: ");
                            dslh[i].setMota(sc.nextLine());
                            break;
                        
                        default:
                            System.out.println("Lua chon khong hop le!");
                            break;
                    }
                }   while (k != 0); 
                return;
            }
        }
    }

    // Hàm thống kê tổng số loại hàng
    public void thongkelh(){
        System.out.printf("%-15s %-15s %-15s%n", "Ma loai hang", "Ten loai hang", "Mo ta");
        System.out.println("--------------------------------------");
        for (int i = 0; i < solh; i++){
            System.out.printf("%-15s %-15s %-15s%n", dslh[i].getMalh(), dslh[i].getTenlh(), dslh[i].getMota());
        }
        System.out.printf("Tong so loai hang: %d%n", solh);
    }

    // Hàm ghi danh sách loại hàng vào file
    public void ghifile() {
        String filename = "loaihang.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < solh; i++) {
                bw.write(dslh[i].getMalh() + "," + dslh[i].getTenlh() + "," + dslh[i].getMota());
                bw.newLine();
            }
            System.out.println("===== Da ghi danh sach loai hang vao file " + filename + " =====");
        } catch (IOException e){
            System.out.println("===== Loi ghi file: " + e.getMessage() + " =====");
        }
    }

    // Hàm đọc danh sách loại hàng từ file
    public void docFileds(String filename) {
        filename = "loaihang.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            solh = 0;
            dslh= new loaihang[0];
            System.out.println("===== Danh sach loai hang =====");
            System.out.printf("%-15s %-15s %-15s\n", "Ma loai hang", "Ten loai hang", "Mo ta loai hang");
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    dslh = Arrays.copyOf(dslh, solh + 1);
                    dslh[solh] = new loaihang();
                    dslh[solh].setMalh(parts[0]);
                    dslh[solh].setTenlh(parts[1]);
                    dslh[solh].setMota(parts[2]);
                    System.out.printf("%-15s %-15s %-15s\n", parts[0], parts[1], parts[2]);
                    solh++;
                }
            }
            System.out.println("===== Da doc danh sach loai hang tu file " + filename + " =====");
        } catch (IOException e) {
            System.out.println("===== Loi khi doc file: " + e.getMessage() + " =====");
        }
    }
}
