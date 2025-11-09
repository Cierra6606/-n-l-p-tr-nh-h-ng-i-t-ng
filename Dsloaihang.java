import java.io.*;
import java.util.*;

public class Dsloaihang implements dieukien {
    static int n;
    static Loaihang[] ds;
    static Scanner sc = new Scanner(System.in);

    // ---- Doc file ----
    public void docFile(String filename) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            n = Integer.parseInt(br.readLine());
            ds = new Loaihang[n];
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                if (line == null || line.trim().isEmpty()) break;

                String[] parts = line.split(",");
                Loaihang lh = new Loaihang(
                    parts[0], // malh
                    parts[1], // tenlh
                    parts[2]  // mota
                );
                ds[i] = lh;
            }
        }
        System.out.println("Doc du lieu tu file thanh cong!");
    }

    // ---- Ghi file ----
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
        System.out.println("Ghi du lieu vao file thanh cong!");
    }

    // ---- Xuat danh sach ----
    public void xuat() {
        for (int i = 0; i < n; i++) {
            System.out.println("------------------------");
            System.out.println("Thong tin loai hang thu " + (i + 1) + ": ");
            ds[i].xuat();
        }
    }

    // ---- Them ----
    @Override
    public void them() {
        ds = Arrays.copyOf(ds, n + 1);
        ds[n] = new Loaihang();
        ds[n].nhap();
        n++;
        System.out.println("Da them loai hang moi thanh cong!");
    }

    // ---- Xoa ----
    @Override
    public void xoa() {
        System.out.print("Nhap ma loai hang muon xoa: ");
        String malh = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMalh().equalsIgnoreCase(malh)) {
                for (int j = i; j < n - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds = Arrays.copyOf(ds, n - 1);
                n--;
                System.out.println("Da xoa loai hang " + malh);
                return;
            }
        }
        System.out.println("Khong tim thay loai hang " + malh);
    }

    // ---- Tim kiem ----
    @Override
    public void timkiem() {
        System.out.print("Nhap ma loai hang can tim: ");
        String malh = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMalh().equalsIgnoreCase(malh)) {
                ds[i].xuat();
                return;
            }
        }
        System.out.println("Khong tim thay ma loai hang nay!");
    }

    // ---- Sua ----
    @Override
    public void sua() {
        System.out.print("Nhap ma loai hang can sua: ");
        String malh = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMalh().equalsIgnoreCase(malh)) {
                int k;
                do {
                    System.out.println("------ Sua thong tin loai hang ------");
                    System.out.println("1. Sua ma loai hang");
                    System.out.println("2. Sua ten loai hang");
                    System.out.println("3. Sua mo ta");
                    System.out.println("0. Thoat");
                    System.out.print("Chon: ");
                    k = Integer.parseInt(sc.nextLine());

                    switch (k) {
                        case 1:
                            System.out.print("Nhap ma moi: ");
                            ds[i].setMalh(sc.nextLine());
                            break;
                        case 2:
                            System.out.print("Nhap ten moi: ");
                            ds[i].setTenlh(sc.nextLine());
                            break;
                        case 3:
                            System.out.print("Nhap mo ta moi: ");
                            ds[i].setMota(sc.nextLine());
                            break;
                        case 0:
                            System.out.println("Thoat sua.");
                            break;
                        default:
                            System.out.println("Lua chon khong hop le!");
                    }
                } while (k != 0);
                return;
            }
        }
        System.out.println("Khong tim thay loai hang can sua!");
    }

    // ---- Thong ke ----
    public void thongkeMota() {
        String[] motaArr = new String[n];
        int[] dem = new int[n];
    
        for (int i = 0; i < n; i++) {
            String mota = ds[i].getMota();
            boolean found = false;
            for (int j = 0; j < i; j++) {
                if (motaArr[j].equals(mota)) {
                    dem[j]++;
                    found = true;
                    break;
                }
            }
            if (!found) {
                motaArr[i] = mota;
                dem[i] = 1;
            }
        }

        System.out.println("=== So loai hang theo mo ta ===");
        for (int i = 0; i < n; i++) {
            if (motaArr[i] != null) {
                System.out.printf("- %-20s: %d loai hang%n", motaArr[i], dem[i]);
            }
        }
    }
}
