class chitietphieunhaphang {
    private String maPNH;
    private String maHang;
    private int soLuong;
    // gia tiền của mỗi đơn vị hàng hóa
    private double donGia;

    public chitietphieunhaphang(String maPNH, String maHang, int soLuong, double donGia) {
        this.maPNH = maPNH;
        this.maHang = maHang;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getMaPNH() {
        return maPNH;
    }

    public String getMaHang() {
        return maHang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    // tính tổng tiền của đơn đó
    public double Thanhtien() {
        return soLuong * donGia;
    }

    public void setMaPNH(String maPNH) {
        this.maPNH = maPNH;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
}
