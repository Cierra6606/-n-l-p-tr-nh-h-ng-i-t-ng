import java.util.Scanner;

public class QLSP extends QLBH {
    private Dsdodunghoctap ds = new Dsdodunghoctap();
    private Scanner sc = new Scanner(System.in);

    @Override
    public void menuChinh() {
        ds.docFile("dodunghoctap.txt");

        int chon;
        do {
            System.out.println("\n=== QUAN LY SAN PHAM ===");
            System.out.println("1. Xuat danh sach");
            System.out.println("2. Them san pham");
            System.out.println("3. Sua san pham");
            System.out.println("4. Xoa san pham");
            System.out.println("5. Tim kiem theo ma");
            System.out.println("6. Thong ke");
            System.out.println("0. Thoat & Luu");
            System.out.print("Chon chuc nang: ");
            try {
                chon = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                chon = -1;
            }

            switch (chon) {
                case 1 -> ds.xuat();
                case 2 -> ds.them();
                case 3 -> ds.sua();
                case 4 -> ds.xoa();
                case 5 -> ds.timKiem();
                case 6 -> ds.thongKe();
                case 0 -> {
                    ds.ghiFile("dodunghoctap.txt");
                    System.out.println("Da luu file. Tam biet!");
                }
                default -> System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);
    }
}
