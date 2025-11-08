// File: Giayso.java
public class Giayso extends Dodunghoctap {
    public String doDay;
    public String khoGiay;

    public Giayso(String maSP, String tenSP, int soLuong, int donGia,
            String donViTinh, String maLoai, String maSX,
            String doDay, String khoGiay) {
        super(maSP, tenSP, soLuong, donGia, donViTinh, maLoai, maSX);
        this.doDay = doDay;
        this.khoGiay = khoGiay;
    }

    @Override
    public void xuat() {
        String ten = tenSP.length() > 15 ? tenSP.substring(0, 12) + "..." : tenSP;
        System.out.printf("%-10s %-15s %8d %,12d %-8s %-8s %-8s %-12s %-10s\n",
                maSP, ten, soLuong, donGia, donViTinh, maLoai, maSX, doDay, khoGiay);
    }

    @Override
    public String toFileString() {
        return String.format("%s,%s,%d,%d,%s,%s,%s,%s,%s",
                maSP, tenSP, soLuong, donGia, donViTinh, maLoai, maSX, doDay, khoGiay);
    }

    public String getdoDay() {
        return doDay;
    }

    public String getkhoGiay() {
        return khoGiay;
    }

    public void setdoDay(String doDay) {
        this.doDay = doDay;
    }

    public void setkhoGiay(String khoGiay) {
        this.khoGiay = khoGiay;
    }
}