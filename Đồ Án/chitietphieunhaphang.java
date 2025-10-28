class chitietphieunhaphang {
    private PhieuNhapHang phieu; // liên kết ngược lại tới phiếu nhập
    private String maHang;
    private int soLuong;
    private double donGia;

    public chitietphieunhaphang(PhieuNhapHang phieu, String maHang, int soLuong, double donGia) {
        this.phieu = phieu;
        this.maHang = maHang;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public PhieuNhapHang getPhieu() {
        return phieu;
    }

    public String getMaHang() {
        return maHang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public double tinhTien() {
        return soLuong * donGia;
    }
}
