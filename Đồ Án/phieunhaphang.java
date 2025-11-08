import java.time.LocalDate;
import java.util.*;

class PhieuNhapHang {
    private String maPNH;
    private LocalDate ngayNhap;
    private String nv;
    private String ncc;
    private double tongTien;

    public PhieuNhapHang() {
        maPNH = "";
        ngayNhap = LocalDate.now();
        nv = "";
        ncc = "";
        tongTien = 0;
    }

    public PhieuNhapHang(String maPhieu, LocalDate ngay, String nv, String ncc) {
        this.maPNH = maPhieu;
        this.ngayNhap = ngay;
        this.nv = nv;
        this.ncc = ncc;
    }

    public PhieuNhapHang(String maPhieu, LocalDate ngay, String nv, String ncc, double tongTien) {
        this.maPNH = maPhieu;
        this.ngayNhap = ngay;
        this.nv = nv;
        this.ncc = ncc;
        this.tongTien = tongTien;
    }

    public String getMaPNH() {
        return maPNH;
    }

    public LocalDate getNgayNhap() {
        return ngayNhap;
    }

    public String getNv() {
        return nv;
    }

    public String getNcc() {
        return ncc;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setMaPNH(String maPNH) {
        this.maPNH = maPNH;
    }

    public void setNgayNhap(LocalDate ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public void setNv(String nv) {
        this.nv = nv;
    }

    public void setNcc(String ncc) {
        this.ncc = ncc;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
}
