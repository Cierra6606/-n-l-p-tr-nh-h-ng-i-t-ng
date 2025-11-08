import java.util.*;

public class QLHSX extends QLBH {
    Dshangsanxuat dsNV = new Dshangsanxuat();
    Scanner sc = new Scanner(System.in);

    @Override
    public void menuChinh() {
        int chon;
        do {
            System.out.println("\n=== MENU QUAN LY HANG SAN XUAT ===");
            System.out.println("1. Xuat danh sach hang san xuat.");
            System.out.println("2. Them hang san xuat moi.");
            System.out.println("3. Xoa hang san xuat.");
            System.out.println("4. Sua hang san xuat.");
            System.out.println("5. Tim hang san xuat.");
            System.out.println("6. Thong ke hang san xuat theo do dai ten hang san xuat.");
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
                case 0 -> System.out.println("Thoat quan ly hang san xuat.");
                default -> System.out.println("Chon sai, vui long nhap lai!");
            }
        } while (chon != 0);
    }
}


