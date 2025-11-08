import java.util.Scanner;

public class QLHD extends QLBH {
    DsHoadon ds = new DsHoadon();
    Scanner sc = new Scanner(System.in);

    @Override
    public void menuChinh() {
        int chon;
        do {
            System.out.println("\n=== MENU QUAN LY HOA DON ===");
            System.out.println("1. Xuat danh sach hoa don");
            System.out.println("2. Them hoa don moi");
            System.out.println("3. Xoa hoa don");
            System.out.println("4. Sua hoa don");
            System.out.println("5. Tim hoa don");
            System.out.println("6. Thong ke hoa don theo ma khach hang");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1 -> ds.xuat();
                case 2 -> ds.them();
                case 3 -> ds.xoa();
                case 4 -> ds.sua();
                case 5 -> ds.timkiem();
                case 6 -> ds.thongkeDaydu();
                case 0 -> System.out.println("Thoat quan ly hoa don.");
                default -> System.out.println("Chon sai, vui long nhap lai!");
            }
        } while (chon != 0);
    }
}
