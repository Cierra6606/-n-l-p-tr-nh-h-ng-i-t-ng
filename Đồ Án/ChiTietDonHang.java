

public class ChiTietDonHang{
	Hoadon mahd;
	Hoadon tongtien;
	Dodunghoctap MSP;
	Dodunghoctap SL;
	Dodunghoctap DonGia;
	
	
	public ChiTietDonHang(Dodunghoctap MSP,Dodunghoctap SL,Dodunghoctap DonGia, Hoadon mahd, Hoadon tongtien) {
		this.MSP = MSP; 
		this.SL = SL;
		this.DonGia = DonGia;
		this.mahd = mahd;
		this.tongtien = tongtien;
	}
	
	public void xuat() {
		System.out.println("--Chi tiết đơn hàng--");
		System.out.println("Mã sản phẩm: " +MSP.getMSP());
		System.out.println("Mã hóa đơn: " +mahd.getMahd());
		System.out.println("Số lượng: " +SL.getSL());
		System.out.println("Đơn giá: " +DonGia.getDonGia());
		System.out.println("Tổng tiền: " +tongtien.getTongtien());
	}
	public static void main(String[] args) {
        Butviet sp = new Butviet("SP001", "Bút bi Thiên Long", 10, 5000, "cây", 10, "bút bi");
        Khachhang kh = new Khachhang("KH01", "Nguyen", "An","123", 987654321);
        Nhanvien nv = new Nhanvien("NV01", "Tran", "Binh", 5000000);
        Hoadon hd = new Hoadon("HD001", "20/10/2025", 50000, kh, nv);
        ChiTietDonHang ctdh = new ChiTietDonHang(sp, sp, sp, hd, hd);
        ctdh.xuat();
    }
}
