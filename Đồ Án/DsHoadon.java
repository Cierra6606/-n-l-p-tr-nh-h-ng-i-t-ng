import java.util.Arrays;
import java.util.Scanner;

public class DsHoadon {
	int n;
	Hoadon[] ds;
	Scanner sc = new Scanner(System.in);

	public void xuat() {
		for (int i = 0; i < n; i ++) {
			System.out.println("------------------------");
			System.out.println("Thong tin hoa don thu"+(i+1) +": ");
			ds[i].xuat();
		}	
	}
	
	public void themHD() {
		ds = Arrays.copyOf(ds, n+1);
		ds[n] = new Hoadon();
		ds[n].nhap();
		n++;
		System.out.println("da them hoa don moi thanh cong!");
	}
	
	
	public void xoaHD () {
		System.out.println("nhap ma hoa don muon xoa");
		String mahd = sc.nextLine();
		for (int i = 0; i < n; i++) {
			if (ds[i].getMahd().equals(mahd)) {
				for (int j = i; j < n -1 ; j++) {
					ds[j] = ds[j +1];
				}
				ds = Arrays.copyOf(ds, n - 1 );
				n--;
				System.out.println("da xoa" +mahd);
				return;
			}
		}
		System.out.println("khong tim thay" +mahd);
	}
	
	public void timkiem () {
		System.out.println("nhập mã hóa đơn để tìm kiếm");
		String mahd = sc.nextLine();
		for (int i = 0; i <n; i++) {
			if (ds[i].getMahd().equalsIgnoreCase(mahd)){
				ds[i].xuat();
				return;
			}	
		}
		System.out.print("không tìm thấy mã hóa đơn");
	}
	
	public void suaHD() {
		System.out.print("nhập mã hóa đơn cần sửa");
		String mahd = sc.nextLine();
		for (int i = 0; i < n; i++) {
			if (ds[i].getMahd().equalsIgnoreCase(mahd)) {
				int k;
				do {
					System.out.println("---Sửa thông tin hóa đơn---");
					System.out.println("1.Sửa mã hóa đơn");
					System.out.println("2.Sửa mã khách hàng");
					System.out.println("2.Sửa mã khách hàng");
					System.out.println("3.Sửa mã nhân viên");
					System.out.println("4.Sửa ngày xuất hóa đơn");
					System.out.println("5.Sửa tổng tiền");
					System.out.print("Nhập lựa chọn: ");
                    k = sc.nextInt();
                    
                switch (k){
                case 1:
                	System.out.println("Vui lòng nhập mã hóa đơn mới");
                	ds[i].setMahd(sc.nextLine());
                case 2:
                	System.out.println("Vui lòng nhập mã khách hàng mới");
                	String makh = sc.nextLine();
                	Khachhang kh = new Khachhang();
                	kh.setMakh(makh);
                	ds[i].setMaKh(kh);
                case 3:
                	System.out.println("Vui lòng nhập mã nhân viên mới");
                	String manv = sc.nextLine();
                	Nhanvien nv = new Nhanvien();
                	nv.setManv(manv);
                	ds[i].setMaNv(nv);
                case 4:
                	System.out.println("Vui lòng nhập ngày xuất mới");
                	ds[i].setNgayxuathd(sc.nextLine());
                case 5:
                	System.out.println("Vui lòng nhập tổng tiền mới");
                	ds[i].setTongtien(sc.nextDouble());
                }
				}while (k !=0); 
				return;
			}
		}
		System.out.println("Không tìm thấy mã hóa đơn này!");
	}
}
