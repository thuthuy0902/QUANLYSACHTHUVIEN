
import java.util.ArrayList;
import java.util.Scanner;
import java.time.Year;

// LOP SACH
class Sach {
    // 1. Khai bao cac thuoc tinh private
    private String maSach;
    private String tieuDe;
    private String tacGia;
    private int namXuatBan;
    private int soLuong;

    // 2. Constructor co tham so day du
    public Sach(String maSach, String tieuDe, String tacGia,
                int namXuatBan, int soLuong) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        setNamXuatBan(namXuatBan);
        setSoLuong(soLuong);
    }

    // 3. GETTER - Phuong thuc lay gia tri

    public String getMaSach() {
        return maSach;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public String getTacGia() {
        return tacGia;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    // 4. SETTER - Phuong thuc thay doi gia tri

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    // Kiem tra nam xuat ban
    public void setNamXuatBan(int namXuatBan) {
        int currentYear = Year.now().getValue();

        if (namXuatBan > 0 && namXuatBan <= currentYear) {
            this.namXuatBan = namXuatBan;
        } else {
            System.out.println("Nam xuat ban khong hop le!");
        }
    }

    // Kiem tra so luong
    public void setSoLuong(int soLuong) {
        if (soLuong >= 0) {
            this.soLuong = soLuong;
        } else {
            System.out.println("So luong khong duoc am!");
        }
    }

    // 5. Phuong thuc hien thi thong tin sach
    public void hienThiThongTin() {
        System.out.println("Ma sach: " + getMaSach());
        System.out.println("Tieu de: " + getTieuDe());
        System.out.println("Tac gia: " + getTacGia());
        System.out.println("Nam xuat ban: " + getNamXuatBan());
        System.out.println("So luong: " + getSoLuong());
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
