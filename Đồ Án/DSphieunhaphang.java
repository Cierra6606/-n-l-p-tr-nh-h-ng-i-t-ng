import java.util.Arrays;
import java.util.Scanner;

public class DSphieunhaphang {
    private PhieuNhapHang[] ds; // mảng lưu các phiếu nhập
    private int soLuong; // số lượng phiếu hiện có
    private Scanner sc = new Scanner(System.in);

    // ====== Constructor ======
    public DSphieunhaphang() {
        ds = new PhieuNhapHang[0];
        soLuong = 0;
    }

    // ====== Thêm 1 phiếu nhập hàng ======
    public void themPhieuNhap(PhieuNhapHang p) {
        ds = Arrays.copyOf(ds, soLuong + 1);
        ds[soLuong] = p;
        soLuong++;
    }

    // ====== Xuất danh sách phiếu nhập hàng ======
    public void xuat() {
        if (soLuong == 0) {
            System.out.println("Chưa có phiếu nhập hàng nào!");
            return;
        }

        System.out.println("\n===== DANH SÁCH PHIẾU NHẬP HÀNG =====");
        for (int i = 0; i < soLuong; i++) {
            System.out.println("\n--- Phiếu nhập hàng thứ " + (i + 1) + " ---");
            ds[i].xuatThongTin();
        }
    }

    // ====== Tìm phiếu nhập hàng theo mã ======
    public PhieuNhapHang timPhieuNhapTheoMa(String ma) {
        for (int i = 0; i < soLuong; i++) {
            if (ds[i].getMaPNH().equalsIgnoreCase(ma)) {
                return ds[i];
            }
        }
        return null;
    }

    public void setDanhSach(PhieuNhapHang[] ds, int soLuong) {
        this.ds = ds;
        this.soLuong = soLuong;
    }
}
