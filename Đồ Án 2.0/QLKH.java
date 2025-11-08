import java.util.Scanner;

public class QLKH extends QLBH {
    Dskhachhang ds = new Dskhachhang();
    Scanner sc = new Scanner(System.in);

    @Override
    public void menuChinh() {
        int chon;
        do {
            System.out.println("\n=== MENU QUAN LY KHACH HANG ===");
            System.out.println("1. Xuat danh sach khach hang");
            System.out.println("2. Them khach hang moi");
            System.out.println("3. Xoa khach hang");
            System.out.println("4. Sua khach hang");
            System.out.println("5. Tim khach hang");
            System.out.println("6. Thong ke khach hang theo ma khach hang");
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
                case 0 -> System.out.println("Thoat quan ly khach hang.");
                default -> System.out.println("Chon sai, vui long nhap lai!");
            }
        } while (chon != 0);
    }
}