import java.util.Arrays;
import java.util.Scanner;

public class Dskhachhang {
    int n;
    Khachhang[] ds;
    Scanner sc = new Scanner(System.in);

    public void xuat() {
        for (int i = 0; i < n; i++) {
            System.out.println("---------------------------");
            System.out.println("Thong tin khach hang thu " + (i + 1) + ": ");
            ds[i].xuat();
        }
    }
    
    public void themKH() {
    	ds = Arrays.copyOf(ds, n+1);
    	ds[n] = new Khachhang();
    	ds[n].nhap();
    	n++;
    	System.out.println("Đã thêm khách hàng mới thành công!");
    }

    public void xoaKH() {
    	System.out.println("Nhập mã khách hàng muốn xóa");
    	String makh = sc.nextLine();
    	for(int i = 0; i<n; i++) {
    		if (ds[i].getMakh().equalsIgnoreCase(makh)) {
    			for(int j = i; j < n -1; j++) {
    				ds[j]= ds[j+1];
    			}
    		ds = Arrays.copyOf(ds, n-1);
    		n--;
    		System.out.println("Đã xóa khách hàng thành công");
    		return;
    		}
    	}
    	System.out.println("Không tìm thấy mã khách hàng muốn xóa");
    }

    public void timKiemKH() {
        System.out.print("Nhap ma khach hang can tim: ");
        String makh = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMakh().equalsIgnoreCase(makh)) {
                System.out.println("Thong tin khach hang:");
                ds[i].xuat();
                return;
            }
        }
        System.out.println("Khong tim thay nha cung cap voi ma nay.");
    }

    public void suaKH(String makh) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMakh().equals(makh)) {
                int k;
                do {
                    System.out.println("\n--- Sua thong tin khach hang ---");
                    System.out.println("1. Sua ma khach hang");
                    System.out.println("2. Sua ho khach hang");
                    System.out.println("3. Sua ten khach hang");
                    System.out.println("4. Sua dia chi");
                    System.out.println("5. Sua so dien thoai");
                    System.out.println("0. Thoat sua");
                    System.out.print("Nhap lua chon: ");
                    k = sc.nextInt();
                    sc.nextLine(); // bỏ dòng thừa

                    switch (k) {
                        case 1:
                            System.out.print("Nhap ma moi: ");
                            ds[i].setMakh(sc.nextLine());
                            break;
                        case 2:
                            System.out.print("Nhap ho moi: ");
                            ds[i].setHo(sc.nextLine());
                            break;
                        case 3:
                            System.out.print("Nhap ten moi: ");
                            ds[i].setTen(sc.nextLine());
                            break;
                        case 4:
                            System.out.print("Nhap dia chi moi: ");
                            ds[i].setDiaChi(sc.nextLine());
                            break;
                        case 5:
                            System.out.print("Nhap so dien thoai moi: ");
                            ds[i].setSdt(sc.nextInt());
                            break;
                        case 0:
                            System.out.println("Da thoat sua thong tin.");
                            break;
                        default:
                            System.out.println("Lua chon khong hop le!");
                            break;
                    }
                } while (k != 0);
                return;
            }
        }
        System.out.println("Khong tim thay khach hang voi ma nay.");
    }
}