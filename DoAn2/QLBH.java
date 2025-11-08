import java.io.*;

public abstract class QLBH {
    // ---- CÁC DANH SÁCH DÙNG CHUNG ----
    // protected static Dsnhanvien dsNhanVien = new Dsnhanvien();
    protected static Dskhachhang dsKhachHang = new Dskhachhang();
    protected static DsHoadon dsHoaDon = new DsHoadon();
    protected static Dsphieunhaphang dsPhieuNhapHang = new Dsphieunhaphang();
    protected static Dsdodunghoctap dsDoDungHocTap = new Dsdodunghoctap();
    // protected static Dsloaihang dsLoaiHang = new Dsloaihang();
    // protected static Dshangsanxuat dsHangSanXuat = new Dshangsanxuat();
    protected static DsCTDH dsChiTietHoaDon = new DsCTDH();
    protected static Dschitietphieunhaphang dsChiTietPhieuNhap = new Dschitietphieunhaphang();
    protected static Dsnhacungcap dsNhaCungCap = new Dsnhacungcap();

    // ---- HÀM ĐỌC TẤT CẢ FILE ----
    public static void docTatCaFile() {
        try {
            // dsNhanVien.docFile("nhanvien.txt");
            dsKhachHang.docFile("DsKH.txt");
            dsHoaDon.docFile("DsHD.txt");
            dsPhieuNhapHang.docFile("Dsphieunhaphang.txt");
            dsDoDungHocTap.docFile("dodunghoctap.txt");
            // dsLoaiHang.docFile("loaihang.txt");
            // dsHangSanXuat.docFile("hangsanxuat.txt");
            dsChiTietHoaDon.docFile("DsCTHD.txt");
            dsChiTietPhieuNhap.docFile("Dschitietphieunhaphang.txt");
            dsNhaCungCap.docFile("Dsnhacungcap.txt");
            System.out.println("Doc tat ca file thanh cong");
        } catch (Exception e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }

    public void tongTien() {
        for (PhieuNhapHang pnh : dsPhieuNhapHang.getDs()) {
            double tongTien = 0;
            for (chitietphieunhaphang ct : dsChiTietPhieuNhap.getDs()) {
                if (ct.getMaPNH().equals(pnh.getMaPNH())) {
                    tongTien += ct.getSoLuong() * ct.getDonGia();
                }
            }
            pnh.setTongTien(tongTien);
        }
    }

    // ---- MENU CHÍNH ĐỂ RỖNG ----
    public abstract void menuChinh();
}