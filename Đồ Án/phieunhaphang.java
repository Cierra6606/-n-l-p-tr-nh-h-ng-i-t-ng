import java.time.LocalDate;
import java.util.*;

class PhieuNhapHang {
    private String maPNH;
    private LocalDate ngayNhap;
    private Nhanvien nv;
    private Nhacungcap ncc;
    private chitietphieunhaphang[] dsCT;
    private int soLuongCT;

    public PhieuNhapHang() {
        maPNH = "";
        ngayNhap = LocalDate.now();
        nv = new Nhanvien();
        ncc = new Nhacungcap();
        this.dsCT = new chitietphieunhaphang[0];
        this.soLuongCT = 0;
    }

    public PhieuNhapHang(String ma, LocalDate ngay, Nhanvien nv, Nhacungcap ncc) {
        this.maPNH = ma;
        this.ngayNhap = ngay;
        this.nv = nv;
        this.ncc = ncc;
        this.dsCT = new chitietphieunhaphang[0];
        this.soLuongCT = 0;
    }

    public void themChiTiet(String maHang, int soLuong, double donGia) {
        chitietphieunhaphang ct = new chitietphieunhaphang(this, maHang, soLuong, donGia);
        dsCT = Arrays.copyOf(dsCT, soLuongCT + 1);
        dsCT[soLuongCT] = ct;
        soLuongCT++;
    }

    public double tinhTongTien() {
        double tong = 0;
        for (int i = 0; i < soLuongCT; i++) {
            tong += dsCT[i].tinhTien();
        }
        return tong;
    }

    public void xuatThongTin() {
        System.out.println("Mã PNH: " + maPNH + " | Ngày: " + ngayNhap);
        System.out.println("Nhân viên: " + nv.getHonv());
        System.out.println("Nhà cung cấp: " + ncc.getMaNCC());
        System.out.println("--- Chi tiết ---");
        for (int i = 0; i < soLuongCT; i++) {
            System.out.println("  Mặt hàng: " + dsCT[i].getMaHang() + " - SL: " + dsCT[i].getSoLuong());
        }
        System.out.println("Tổng tiền: " + tinhTongTien());
    }

    public String getMaPNH() {
        return maPNH;
    }
}
