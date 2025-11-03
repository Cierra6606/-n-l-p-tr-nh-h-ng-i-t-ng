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
}

    // Get
    public String getMSP() {return MSP;}
    public String getTen() {return Ten;}
    public int getSL() {return SL;}
    public int getDonGia() {return DonGia;}
    public String getDVTinh() {return DVTinh;}
    // set
    public void setMSP(String MSP) {this.MSP = MSP;}
    public void setTen(String Ten) {this.Ten = Ten;}
    public void setSL(int SL) {this.SL = SL;}
    public void setDonGia(int DonGia) {this.DonGia = DonGia;}
    public void setDVTinh(String DVTinh) {this.DVTinh = DVTinh;}
}

