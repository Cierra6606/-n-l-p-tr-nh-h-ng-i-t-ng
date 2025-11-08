import java.util.*;

class Nhacungcap {
    private String maNCC;
    private String tenNCC;
    private String diaChi;
    private int soDienThoai;
    Scanner sc = new Scanner(System.in);

    public Nhacungcap() {
        maNCC = "";
        tenNCC = "";
        diaChi = "";
        soDienThoai = 0;
    }

    public Nhacungcap(String maNCC, String tenNCC, String diaChi, int soDienThoai) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public int getSoDienThoai() {
        return soDienThoai;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setSoDienThoai(int soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
}
