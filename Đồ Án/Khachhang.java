
import java.util.Scanner;

public class Khachhang {
	private String makh;
	private String hokh;
	private String tenkh;
	private String diachi;
	private int sdt;

	public Khachhang() {
	}

	public Khachhang(String makh, String hokh, String tenkh, String diachi, int sdt) {
		this.setMakh(makh);
		this.hokh = hokh;
		this.tenkh = tenkh;
		this.diachi = diachi;
		this.setSdt(sdt);
	}

	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập mã khách hàng: ");
		setMakh(sc.next());
		System.out.print("Nhập họ khách hàng: ");
		hokh = sc.next();
		System.out.print("Nhập tên khách hàng: ");
		tenkh = sc.next();
		System.out.print("Nhập địa chỉ khách hàng: ");
		diachi = sc.next();
		System.out.print("Nhập số điện thoại khách hàng: ");
		setSdt(sc.nextInt());
	}

	public void xuat() {
		System.out.println(
				"Khách hàng có mã " + makh + " tên " + hokh + " " + tenkh + " địa chỉ " + diachi + " số điện thoại " + sdt);
	}

	public String getHo() {
		return hokh;
	}
	public void setHo(String hokh) {
		this.hokh = hokh;
	}

	public String getTen() {
		return tenkh;
	}
	void setTen(String tenkh) {
		this.tenkh = tenkh;
	}

	public String getDiaChi() {
		return diachi;
	}
	public void setDiaChi(String diachi) {
		this.diachi = diachi;
	}

	public Integer getSdt() {
		return sdt;
	}
	void setSdt(int sdt) {
		this.sdt = sdt;
	}

	public String getMakh() {
		return makh;
	}
	public void setMakh(String makh) {
		this.makh = makh;
	}


}