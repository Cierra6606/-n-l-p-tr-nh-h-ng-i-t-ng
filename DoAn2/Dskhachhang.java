import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Dskhachhang implements dieukien {
    static int n;
    static Khachhang[] ds;
    static Scanner sc = new Scanner(System.in);

    public void docFile(String filename) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            n = Integer.parseInt(br.readLine());
            ds = new Khachhang[n];
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                if (line == null || line.trim().isEmpty())
                    break;

                String[] parts = line.split(",");

                String makh = parts[0];
                String ho = parts[1];
                String ten = parts[2];
                String diachi = parts[3];
                int sdt = Integer.parseInt(parts[4]);

                Khachhang kh = new Khachhang();
                kh.setMakh(makh);
                kh.setHo(ho);
                kh.setTen(ten);
                kh.setDiaChi(diachi);
                kh.setSdt(sdt);

                ds[i] = kh;
            }
        }
        System.out.println("Doc du lieu tu file thanh cong!");
    }

    public void ghiFile(String filename) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(n + "");
            bw.newLine();
            for (int i = 0; i < n; i++) {
                if (ds[i] != null) {
                    bw.write(ds[i].getMakh() + ","
                            + ds[i].getHo() + ","
                            + ds[i].getTen() + ","
                            + ds[i].getDiaChi() + ","
                            + ds[i].getSdt());
                    bw.newLine();
                }
            }
        }
        System.out.println("Ghi du lieu vao file thanh cong!");
    }

    public void xuat() {
        for (int i = 0; i < n; i++) {
            System.out.println("------------------------");
            System.out.println("Thong tin khach hang thu " + (i + 1) + ": ");
            ds[i].xuat();
        }
    }

    @Override
    public void them() {
        ds = Arrays.copyOf(ds, n + 1);
        ds[n] = new Khachhang();
        ds[n].nhap();
        n++;
        System.out.println("Da them khach hang moi thanh cong!");
    }

    @Override
    public void xoa() {
        System.out.println("Nhap ma khach hang muon xoa: ");
        String makh = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMakh().equals(makh)) {
                for (int j = i; j < n - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds = Arrays.copyOf(ds, n - 1);
                n--;
                System.out.println("Da xoa " + makh);
                return;
            }
        }
        System.out.println("Khong tim thay " + makh);
    }

    @Override
    public void timkiem() {
        System.out.println("Nhap ma khach hang de tim kiem: ");
        String makh = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMakh().equalsIgnoreCase(makh)) {
                ds[i].xuat();
                return;
            }
        }
        System.out.print("Khong tim thay ma khach hang");
    }

    @Override
    public void sua() {
        System.out.print("Nhap ma khach hang can sua: ");
        String makh = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMakh().equalsIgnoreCase(makh)) {
                int k;
                do {
                    System.out.println("---Sua thong tin khach hang---");
                    System.out.println("1. Sua ma khach hang");
                    System.out.println("2. Sua ho khach hang");
                    System.out.println("3. Sua ten khach hang");
                    System.out.println("4. Sua dia chi");
                    System.out.println("5. Sua so dien thoai");
                    System.out.println("0. Thoat");
                    System.out.print("Nhap lua chon: ");
                    k = sc.nextInt();
                    sc.nextLine();

                    switch (k) {
                        case 1:
                            System.out.println("Vui long nhap ma khach hang moi: ");
                            ds[i].setMakh(sc.nextLine());
                            break;
                        case 2:
                            System.out.println("Vui long nhap ho moi: ");
                            ds[i].setHo(sc.nextLine());
                            break;
                        case 3:
                            System.out.println("Vui long nhap ten moi: ");
                            ds[i].setTen(sc.nextLine());
                            break;
                        case 4:
                            System.out.println("Vui long nhap dia chi moi: ");
                            ds[i].setDiaChi(sc.nextLine());
                            break;
                        case 5:
                            System.out.println("Vui long nhap so dien thoai moi: ");
                            ds[i].setSdt(sc.nextInt());
                            sc.nextLine();
                            break;
                        case 0:
                            System.out.println("Thoat sua thong tin.");
                            break;
                        default:
                            System.out.println("Lua chon khong hop le!");
                    }
                } while (k != 0);
                return;
            }
        }
        System.out.println("Khong tim thay ma khach hang nay!");
    }

    public void thongke() {
        System.out.println("=== THONG KE KHACH HANG ===");
        System.out.println("Tong so khach hang: " + n);

        System.out.println("Danh sach khach hang:");
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + ". " + ds[i].getMakh() + " - " +
                    ds[i].getHo() + " " + ds[i].getTen());
        }
    }
}