import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
		System.out.print("Nhap ma khach hang: ");
		makh = sc.nextLine();
		System.out.print("Nhap ho khach hang: ");
		hokh = sc.nextLine();
		System.out.print("Nhap ten khach hang: ");
		tenkh = sc.nextLine();
		System.out.print("Nhap dia chi khach hang: ");
		diachi = sc.nextLine();
		System.out.print("Nhap so dien thoai khach hang: ");
		sdt = sc.nextInt();
	}

	public void xuat() {
		System.out.println("Khach hang co ma " + makh + " ten " + hokh + " " + tenkh + " dia chi " + diachi
				+ " so dien thoai " + sdt);
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

	public void setTen(String tenkh) {
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

	public void setSdt(int sdt) {
		this.sdt = sdt;
	}

	public String getMakh() {
		return makh;
	}

	public void setMakh(String makh) {
		this.makh = makh;
	}
}