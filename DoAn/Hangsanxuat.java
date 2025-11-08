import java.util.Scanner;

public class Hangsanxuat {
    private String mahsx;
    private String tenhsx;
    private String diachi;

    static Scanner sc = new Scanner(System.in);

    // --- Constructors ---
    public Hangsanxuat() {}

    public Hangsanxuat(String mahsx, String tenhsx, String diachi) {
        this.mahsx = mahsx;
        this.tenhsx = tenhsx;
        this.diachi = diachi;
    }

    // --- Getter & Setter ---
    public String getMahsx() { return mahsx; }
    public void setMahsx(String mahsx) { this.mahsx = mahsx; }

    public String getTenhsx() { return tenhsx; }
    public void setTenhsx(String tenhsx) { this.tenhsx = tenhsx; }

    public String getDiachi() { return diachi; }
    public void setDiachi(String diachi) { this.diachi = diachi; }

    // --- Nhap va Xuat ---
    public void nhap() {
        System.out.print("Nhap ma hang san xuat: ");
        mahsx = sc.nextLine();
        System.out.print("Nhap ten hang san xuat: ");
        tenhsx = sc.nextLine();
        System.out.print("Nhap dia chi hang san xuat: ");
        diachi = sc.nextLine();
    }

    public void xuat() {
        System.out.println("Ma HSX: " + mahsx);
        System.out.println("Ten HSX: " + tenhsx);
        System.out.println("Dia chi: " + diachi);
    }

    @Override
    public String toString() {
        return mahsx + "," + tenhsx + "," + diachi;
    }
}
