
import java.util.ArrayList;
import java.util.Scanner;

// LOP SACH
class Sach {
    // Khai bao cac thuoc tinh
    private String maSach;
    private String tieuDe;
    private String tacGia;
    private int namXuatBan;
    private int soLuong;

    // Ham khoi tao
    public Sach(String maSach, String tieuDe, String tacGia,
                int namXuatBan, int soLuong) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.soLuong = soLuong;
    }

    // Phuong thuc hien thi thong tin sach
    public void hienThiThongTin() {
        System.out.println("Ma sach: " + maSach);
        System.out.println("Tieu de: " + tieuDe);
        System.out.println("Tac gia: " + tacGia);
        System.out.println("Nam xuat ban: " + namXuatBan);
        System.out.println("So luong: " + soLuong);
        System.out.println("---------------------------");
    }
}
// LOP TEST
public class Test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Tao danh sach sach bang ArrayList
        ArrayList<Sach> danhSach = new ArrayList<>();

        // Nhap so luong sach
        System.out.print("Nhap so luong sach: ");
        int n = sc.nextInt();
        sc.nextLine();

        // Nhap thong tin tung cuon sach
        for (int i = 0; i < n; i++) {
            System.out.println("\nNhap thong tin sach thu " + (i + 1));

            System.out.print("Nhap ma sach: ");
            String maSach = sc.nextLine();

            System.out.print("Nhap tieu de: ");
            String tieuDe = sc.nextLine();

            System.out.print("Nhap tac gia: ");
            String tacGia = sc.nextLine();

            System.out.print("Nhap nam xuat ban: ");
            int namXuatBan = sc.nextInt();

            System.out.print("Nhap so luong: ");
            int soLuong = sc.nextInt();
            sc.nextLine();

            // Tao doi tuong Sach
            Sach s = new Sach(maSach, tieuDe, tacGia,
                              namXuatBan, soLuong);

            // Them sach vao danh sach
            danhSach.add(s);
        }
        // Hien thi danh sach sach
        System.out.println("\n===== DANH SACH SACH TRONG THU VIEN =====");

        for (int i = 0; i < danhSach.size(); i++) {
            System.out.println("Thong tin sach thu " + (i + 1));
            danhSach.get(i).hienThiThongTin();
        }
        sc.close();
    }
}
