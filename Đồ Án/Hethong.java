import java.util.*;

public class Hethong {
    public void khoiDong() {
        Scanner sc = new Scanner(System.in);
        int chon;
        QLBH ql;

        do {
            System.out.println("\n=== MENU CHINH HE THONG ===");
            System.out.println("1. Quan ly nha cung cap");
            System.out.println("2. Quan ly san pham");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    ql = new QLNCC();
                    ql.menuChinh();
                    break;
                case 2:
                    ql = new QLSP();
                    ql.menuChinh();
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);
    }
}
