// File: Butviet.java
public class Butviet extends Dodunghoctap {
    public String loaibut;
    public int kichcongoi;

    public Butviet(String maSP, String tenSP, int soLuong, int donGia,
            String donViTinh, String maLoai, String maSX,
            String loaibut, int kichcongoi) {
        super(maSP, tenSP, soLuong, donGia, donViTinh, maLoai, maSX);
        this.loaibut = loaibut;
        this.kichcongoi = kichcongoi;
    }

    @Override
    public void xuat() {
        String ten = tenSP.length() > 15 ? tenSP.substring(0, 12) + "..." : tenSP;
        System.out.printf("%-10s %-15s %8d %,12d %-8s %-8s %-8s %-12s %10d\n",
                maSP, ten, soLuong, donGia, donViTinh, maLoai, maSX, loaibut, kichcongoi);
    }

    @Override
    public String toFileString() {
        return String.format("%s,%s,%d,%d,%s,%s,%s,%s,%d",
                maSP, tenSP, soLuong, donGia, donViTinh, maLoai, maSX, loaibut, kichcongoi);
    }

    public String getloaibut() {
        return loaibut;
    }

    public int getkichcongoi() {
        return kichcongoi;
    }

    public void setloaibut(String loaibut) {
        this.loaibut = loaibut;
    }

    public void setkichcongoi(int kichcongoi) {
        this.kichcongoi = kichcongoi;
    }
}