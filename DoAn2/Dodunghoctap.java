// File: Dodunghoctap.java
public abstract class Dodunghoctap {
    public String maSP, tenSP, donViTinh, maLoai, maSX;
    public int soLuong, donGia;

    public Dodunghoctap(String maSP, String tenSP, int soLuong, int donGia,
            String donViTinh, String maLoai, String maSX) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.donViTinh = donViTinh;
        this.maLoai = maLoai;
        this.maSX = maSX;
    }

    public abstract void xuat();

    public abstract String toFileString();

    public Dodunghoctap() {
    }

    public String getMaSP() {
        return maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public String getMaSX() {
        return maSX;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public void setdonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public void setmaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public void setmaSX(String maSX) {
        this.maSX = maSX;
    }
}