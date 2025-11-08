import java.io.*;
import java.util.*;

public class DsCTDH implements dieukien {
    int n;
    ChiTietDonHang[] ds;
    Scanner sc = new Scanner(System.in);

    public DsCTDH() {
        ds = new ChiTietDonHang[0];
        n = 0;
    }

    public void docFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            n = 0;
            ds = new ChiTietDonHang[0];
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String mahd = parts[0];
                    String msp = parts[1];
                    int sl = Integer.parseInt(parts[2]);
                    double dongia = Double.parseDouble(parts[3]);
                    ds = Arrays.copyOf(ds, n + 1);
                    ds[n] = new ChiTietDonHang(mahd, msp, sl, dongia);
                    n++;
                }
            }
            System.out.println("Đã đọc file thành công (" + n + " dòng dữ liệu)");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
    }

    public void ghifile(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < n; i++) {
                bw.write(ds[i].getMahd() + "," +
                        ds[i].getMsp() + "," +
                        ds[i].getSl() + "," +
                        ds[i].getDongia());
                bw.newLine();
            }
            System.out.println("Đã ghi file thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }

    public void xuat() {
        System.out.println("===== DANH SÁCH CHI TIẾT ĐƠN HÀNG =====");
        System.out.printf("%-10s %-10s %-10s %-10s\n", "Mã HĐ", "Mã SP", "Số lượng", "Đơn giá");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-10s %-10s %-10d %-10.2f\n",
                    ds[i].getMahd(), ds[i].getMsp(), ds[i].getSl(), ds[i].getDongia());
        }
    }

    @Override
    public void them() {
        ds = Arrays.copyOf(ds, n + 1);
        System.out.println("Nhập thông tin chi tiết đơn hàng thứ " + (n + 1) + ": ");
        ds[n] = new ChiTietDonHang();
        ds[n].nhap();
        n++;
        ghifile("DsCTDH.txt");
        System.out.println("Đã thêm chi tiết đơn hàng và cập nhật file!");
    }

    @Override
    public void xoa() {
        System.out.print("Nhập mã hóa đơn cần xóa: ");
        String mahd = sc.nextLine();
        System.out.print("Nhập mã sản phẩm cần xóa: ");
        String msp = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMahd().equalsIgnoreCase(mahd) &&
                    ds[i].getMsp().equalsIgnoreCase(msp)) {
                for (int j = i; j < n - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds = Arrays.copyOf(ds, n - 1);
                n--;
                ghifile("DsCTDH.txt");
                System.out.println("Đã xóa thành công và cập nhật file!");
                return;
            }
        }
        System.out.println("Không tìm thấy dữ liệu cần xóa!");
    }

    @Override
    public void timkiem() {
        System.out.print("Nhập mã hóa đơn cần tìm: ");
        String mahd = sc.nextLine();
        boolean found = false;
        System.out.printf("%-10s %-10s %-10s %-10s\n", "Mã HĐ", "Mã SP", "Số lượng", "Đơn giá");
        for (int i = 0; i < n; i++) {
            if (ds[i].getMahd().equalsIgnoreCase(mahd)) {
                System.out.printf("%-10s %-10s %-10d %-10.2f\n",
                        ds[i].getMahd(), ds[i].getMsp(), ds[i].getSl(), ds[i].getDongia());
                found = true;
            }
        }
        if (!found)
            System.out.println("Không tìm thấy hóa đơn nào có mã " + mahd);
    }

    @Override
    public void sua() {
        System.out.print("Nhập mã hóa đơn cần sửa: ");
        String mahd = sc.nextLine();
        System.out.print("Nhập mã sản phẩm cần sửa: ");
        String msp = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMahd().equalsIgnoreCase(mahd) &&
                    ds[i].getMsp().equalsIgnoreCase(msp)) {

                int chon;
                do {
                    System.out.println("=== SỬA THÔNG TIN CHI TIẾT ĐƠN HÀNG ===");
                    System.out.println("1. Sửa mã sản phẩm");
                    System.out.println("2. Sửa số lượng");
                    System.out.println("3. Sửa đơn giá");
                    System.out.println("0. Thoát sửa");
                    System.out.print("Chọn: ");
                    chon = Integer.parseInt(sc.nextLine());

                    switch (chon) {
                        case 1:
                            System.out.print("Nhập mã sản phẩm mới: ");
                            ds[i].setMsp(sc.nextLine());
                            break;
                        case 2:
                            System.out.print("Nhập số lượng mới: ");
                            ds[i].setSl(Integer.parseInt(sc.nextLine()));
                            break;
                        case 3:
                            System.out.print("Nhập đơn giá mới: ");
                            ds[i].setDongia(Double.parseDouble(sc.nextLine()));
                            break;
                        case 0:
                            System.out.println("Đã thoát sửa.");
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ!");
                    }
                } while (chon != 0);
                ghifile("DsCTDH.txt");
                System.out.println("Đã sửa và cập nhật file!");
                return;
            }
        }
        System.out.println("Không tìm thấy chi tiết đơn hàng cần sửa!");
    }

    public boolean kiemTraTrungMa(String mahd) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMahd().equalsIgnoreCase(mahd)) {
                return true;
            }
        }
        return false;
    }
}
