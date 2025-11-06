import java.io.*;
import java.util.*;

public abstract class QLBH {
    // ---- CÁC DANH SÁCH DÙNG CHUNG ----
    protected static Dsnhanvien dsNhanVien = new Dsnhanvien();
    protected static Dskhachhang dsKhachHang = new Dskhachhang();
    protected static Dshoadon dsHoaDon = new Dshoadon();
    protected static Dsphieunhaphang dsPhieuNhapHang = new Dsphieunhaphang();
    protected static Dsdodunghoctap dsDoDungHocTap = new Dsdodunghoctap();
    protected static Dsloaihang dsLoaiHang = new Dsloaihang();
    protected static Dshangsanxuat dsHangSanXuat = new Dshangsanxuat();
    protected static Dschitiethoadon dsChiTietHoaDon = new Dschitiethoadon();
    protected static Dschitietphieunhap dsChiTietPhieuNhap = new Dschitietphieunhap();
    protected static Dssanpham dsSanPham = new Dssanpham();
    protected static Dsnhacungcap dsNhaCungCap = new Dsnhacungcap();

    // ---- HÀM ĐỌC TẤT CẢ FILE ----
    public void docTatCaFile() {
        try {
            dsNhanVien.docFile("nhanvien.txt");
            dsKhachHang.docFile("khachhang.txt");
            dsHoaDon.docFile("hoadon.txt");
            dsPhieuNhapHang.docFile("phieunhaphang.txt");
            dsDoDungHocTap.docFile("dodunghoctap.txt");
            dsLoaiHang.docFile("loaihang.txt");
            dsHangSanXuat.docFile("hangsanxuat.txt");
            dsChiTietHoaDon.docFile("chitiethoadon.txt");
            dsChiTietPhieuNhap.docFile("chitietphieunhap.txt");
            dsSanPham.docFile("sanpham.txt");
            dsNhaCungCap.docFile("nhacungcap.txt");
            System.out.println("Đọc tất cả dữ liệu thành công!");
        } catch (Exception e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
    }
    // ---- MENU CHÍNH ĐỂ RỖNG ----
    public abstract void menuChinh();
}
