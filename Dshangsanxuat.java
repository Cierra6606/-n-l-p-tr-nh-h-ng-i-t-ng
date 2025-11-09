import java.io.*;
import java.util.*;

public class Dshangsanxuat implements dieukien {
    static int n;
    static Hangsanxuat[] ds;
    static Scanner sc = new Scanner(System.in);

    // --- Doc file ---
    public void docFile(String filename) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            n = Integer.parseInt(br.readLine());
            ds = new Hangsanxuat[n];
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                if (line == null || line.trim().isEmpty()) break;

                String[] parts = line.split(",");
                ds[i] = new Hangsanxuat(parts[0], parts[1], parts[2]);
            }
        }
        System.out.println("Doc du lieu hang san xuat thanh cong!");
    }

    // --- Ghi file ---
    public void ghiFile(String filename) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(n + "");
            bw.newLine();
            for (int i = 0; i < n; i++) {
                if (ds[i] != null) {
                    bw.write(ds[i].toString());
                    bw.newLine();
                }
            }
        }
        System.out.println("Ghi du lieu hang san xuat thanh cong!");
    }

    // --- Xuat danh sach ---
    public void xuat() {
        for (int i = 0; i < n; i++) {
            System.out.println("-------------------------");
            System.out.println("Hang san xuat thu " + (i + 1) + ":");
            ds[i].xuat();
        }
    }

    // --- Them ---
    @Override
    public void them() {
        ds = Arrays.copyOf(ds, n + 1);
        ds[n] = new Hangsanxuat();
        ds[n].nhap();
        n++;
        System.out.println("Da them hang san xuat moi!");
    }

    // --- Xoa ---
    @Override
    public void xoa() {
        System.out.print("Nhap ma hang san xuat can xoa: ");
        String mahsx = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMahsx().equalsIgnoreCase(mahsx)) {
                for (int j = i; j < n - 1; j++) ds[j] = ds[j + 1];
                ds = Arrays.copyOf(ds, n - 1);
                n--;
                System.out.println("Da xoa hang san xuat " + mahsx);
                return;
            }
        }
        System.out.println("Khong tim thay ma hang san xuat nay!");
    }

    // --- Tim kiem ---
    @Override
    public void timkiem() {
        System.out.print("Nhap ma hang san xuat can tim: ");
        String mahsx = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMahsx().equalsIgnoreCase(mahsx)) {
                ds[i].xuat();
                return;
            }
        }
        System.out.println("Khong tim thay hang san xuat!");
    }

    // --- Sua ---
    @Override
    public void sua() {
        System.out.print("Nhap ma hang san xuat can sua: ");
        String mahsx = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMahsx().equalsIgnoreCase(mahsx)) {
                int chon;
                do {
                    System.out.println("=== SUA HANG SAN XUAT ===");
                    System.out.println("1. Sua ma HSX");
                    System.out.println("2. Sua ten HSX");
                    System.out.println("3. Sua dia chi");
                    System.out.println("0. Thoat");
                    System.out.print("Chon: ");
                    chon = Integer.parseInt(sc.nextLine());

                    switch (chon) {
                        case 1 -> {
                            System.out.print("Nhap ma moi: ");
                            ds[i].setMahsx(sc.nextLine());
                        }
                        case 2 -> {
                            System.out.print("Nhap ten moi: ");
                            ds[i].setTenhsx(sc.nextLine());
                        }
                        case 3 -> {
                            System.out.print("Nhap dia chi moi: ");
                            ds[i].setDiachi(sc.nextLine());
                        }
                        case 0 -> System.out.println("Thoat sua.");
                        default -> System.out.println("Lua chon khong hop le!");
                    }
                } while (chon != 0);
                return;
            }
        }
        System.out.println("Khong tim thay hang san xuat can sua!");
    }

    // --- Thong ke ---
    public void thongke() {
        System.out.println("=== THONG KE THEO DO DAI TEN HANG ===");
        int ngan = 0, trungbinh = 0, dai = 0;

        for (int i = 0; i < n; i++) {
            int len = ds[i].getTenhsx().length();
            if (len <= 5) ngan++;
            else if (len <= 10) trungbinh++;
            else dai++;
        }

        System.out.println("Ten ngan (<=5 ky tu): " + ngan);
        System.out.println("Ten trung binh (6-10 ky tu): " + trungbinh);
        System.out.println("Ten dai (>10 ky tu): " + dai);
    }

}
