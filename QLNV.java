import java.util.*;

public class QLNV extends QLBH {
    Dsnhanvien dsNV = new Dsnhanvien();
    Scanner sc = new Scanner(System.in);

    @Override
    public void menuChinh() {
        int chon;
        do {
            System.out.println("\n=== MENU QUAN LY  NHAN VIEN ===");
            System.out.println("1. Xuat danh sach nhan vien.");
            System.out.println("2. Them nhan vien moi.");
            System.out.println("3. Xoa nhan vien.");
            System.out.println("4. Sua nhan vien.");
            System.out.println("5. Tim nhan vien.");
            System.out.println("6. Thong ke nhan vien theo luong nhan vien.");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1 -> dsNV.xuat();
                case 2 -> dsNV.them();
                case 3 -> dsNV.xoa();
                case 4 -> dsNV.sua();
                case 5 -> dsNV.timkiem();
                case 6 -> dsNV.thongke();
                case 0 -> System.out.println("Thoat quan ly nhan vien.");
                default -> System.out.println("Chon sai, vui long nhap lai!");
            }
        } while (chon != 0);
    }
}


