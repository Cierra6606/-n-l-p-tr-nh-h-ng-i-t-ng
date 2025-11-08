import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class DsHoadon implements dieukien {
	static int n;
	static Hoadon[] ds;
	static Scanner sc = new Scanner(System.in);

	public void docFile(String filename) throws Exception {
	    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
	        n = Integer.parseInt(br.readLine());
	        ds = new Hoadon[n];
	        for (int i = 0; i < n; i++) {
	            String line = br.readLine();
	            if (line == null || line.trim().isEmpty()) break;

	            // Giả sử file có cấu trúc: mahd, makh, manv, tongtien, ngayxuathd
	            String[] parts = line.split(",");

	            String mahd = parts[0];
	            String makh = parts[1];
	            String manv = parts[2];
	            double tongtien = Double.parseDouble(parts[3]);
	            String ngay = parts.length > 4 ? parts[4] : "";

	            Khachhang kh = new Khachhang();
	            kh.setMakh(makh);
	            Nhanvien nv = new Nhanvien();
	            nv.setManv(manv);

	            Hoadon hd = new Hoadon();
	            hd.setMahd(mahd);
	            hd.setMaKh(kh);
	            hd.setMaNv(nv);
	            hd.setTongtien(tongtien);

	            if (!ngay.isEmpty()) {
	                hd.setNgayxuathd(java.time.LocalDate.parse(ngay));
	            }

	            ds[i] = hd;
	        }
	    }
	    System.out.println("Đọc dữ liệu từ file thành công!");
	}

	public void ghiFile(String filename) throws Exception {
	    try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
	        bw.write(n + "");
	        bw.newLine();
	        for (int i = 0; i < n; i++) {
	            if (ds[i] != null) {
	                String ngay = ds[i].getNgayxuathd() != null ? ds[i].getNgayxuathd().toString() : "";
	                bw.write(ds[i].getMahd() + "," 
	                        + ds[i].getMaKh().getMakh() + "," 
	                        + ds[i].getMaNv().getManv() + "," 
	                        + ds[i].getTongtien() + "," 
	                        + ngay);
	                bw.newLine();
	            }
	        }
	    }
	    System.out.println("Ghi dữ liệu vào file thành công!");
	}

	public void xuat() {
		for (int i = 0; i < n; i ++) {
			System.out.println("------------------------");
			System.out.println("Thong tin hoa don thu"+(i+1) +": ");
			ds[i].xuat();
		}	
	}
	@Override 
	public void them() {
		ds = Arrays.copyOf(ds, n+1);
		ds[n] = new Hoadon();
		ds[n].nhap();
		n++;
		System.out.println("da them hoa don moi thanh cong!");
	}
	
	@Override 
	public void xoa() {
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
	
	@Override 
	public void timkiem() {
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
	
	@Override 
	public void sua() {
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
					System.out.println("4.Sửa tổng tiền");
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
                	System.out.println("Vui lòng nhập tổng tiền mới");
                	ds[i].setTongtien(sc.nextDouble());
                }
				}while (k !=0); 
				return;
			}
		}
		System.out.println("Không tìm thấy mã hóa đơn này!");
	}
	
	
	public void thongkeDaydu() {
	    System.out.println("============================================================");
	    System.out.println("                 THỐNG KÊ HÓA ĐƠN THEO THÁNG                ");
	    System.out.println("============================================================");

	    for (int nam = 2020; nam <= 2025; nam++) {
	        boolean coDuLieu = false;
	        System.out.println("\nNăm " + nam + ":");
	        System.out.println("------------------------------------------------------------");
	        System.out.println("Tháng | Số hóa đơn | Tổng doanh thu");
	        System.out.println("------------------------------------------------------------");

	        for (int thang = 1; thang <= 12; thang++) {
	            int soLuong = 0;
	            double tongTien = 0;

	            for (int i = 0; i < n; i++) {
	                if (ds[i].getNgayxuathd() != null &&
	                    ds[i].getNgayxuathd().getMonthValue() == thang &&
	                    ds[i].getNgayxuathd().getYear() == nam) {
	                    soLuong++;
	                    tongTien += ds[i].getTongtien();
	                }
	            }

	            if (soLuong > 0) {
	                System.out.println("  " + thang + "   |     " + soLuong + "      |   " + tongTien);
	                coDuLieu = true;
	            }
	        }

	        if (!coDuLieu) {
	            System.out.println("Không có hóa đơn nào trong năm " + nam + ".");
	        }
	    }
	    
	    System.out.println("\n============================================================");
	    System.out.println("                 THỐNG KÊ HÓA ĐƠN THEO QUÝ                  ");
	    System.out.println("============================================================");

	    for (int nam = 2020; nam <= 2025; nam++) {
	        boolean coDuLieu = false;
	        System.out.println("\nNăm " + nam + ":");
	        System.out.println("------------------------------------------------------------");
	        System.out.println("Quý  | Số hóa đơn | Tổng doanh thu");
	        System.out.println("------------------------------------------------------------");

	        for (int quy = 1; quy <= 4; quy++) {
	            int soLuong = 0;
	            double tongTien = 0;

	            for (int i = 0; i < n; i++) {
	                if (ds[i].getNgayxuathd() != null && ds[i].getNgayxuathd().getYear() == nam) {
	                    int month = ds[i].getNgayxuathd().getMonthValue();
	                    int quyHienTai = (month - 1) / 3 + 1;
	                    if (quyHienTai == quy) {
	                        soLuong++;
	                        tongTien += ds[i].getTongtien();
	                    }
	                }
	            }

	            if (soLuong > 0) {
	                System.out.println("  " + quy + "   |     " + soLuong + "      |   " + tongTien);
	                coDuLieu = true;
	            }
	        }

	        if (!coDuLieu) {
	            System.out.println("Không có hóa đơn nào trong năm " + nam + ".");
	        }
	    }

	    System.out.println("\n============================================================");
	    System.out.println("                 THỐNG KÊ HÓA ĐƠN THEO NĂM                  ");
	    System.out.println("============================================================");

	    for (int nam = 2020; nam <= 2025; nam++) {
	        int soLuong = 0;
	        double tongTien = 0;

	        for (int i = 0; i < n; i++) {
	            if (ds[i].getNgayxuathd() != null && ds[i].getNgayxuathd().getYear() == nam) {
	                soLuong++;
	                tongTien += ds[i].getTongtien();
	            }
	        }

	        if (soLuong > 0) {
	            System.out.println("Năm " + nam + " | Số hóa đơn: " + soLuong + " | Tổng doanh thu: " + tongTien);
	        }
	    }
	    System.out.println("\n=== THỐNG KÊ THEO MÃ KH ===");
	    for (int i = 0; i < n; i++) {
	        String maKH = ds[i].getMaKh().getMakh();
	        int soLuong = 0;
	        double tongTien = 0;

	        // kiểm tra trùng mã KH
	        boolean daDem = false;
	        for (int j = 0; j < i; j++) {
	            if (ds[j].getMaKh().equals(maKH)) {
	                daDem = true;
	                break;
	            }
	        }
	        if (daDem) continue;

	        // đếm số hóa đơn và tổng tiền cho mã KH này
	        for (int j = 0; j < n; j++) {
	            if (ds[j].getMaKh().equals(maKH)) {
	                soLuong++;
	                tongTien += ds[j].getTongtien();
	            }
	        }

	        System.out.println("Mã KH: " + maKH +
	                           " | Số hóa đơn: " + soLuong +
	                           " | Tổng doanh thu: " + tongTien);
	    }
	}
}
