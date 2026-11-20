
import java.util.ArrayList;
import java.util.Scanner;
// LOP CHA SACH
class Sach {
    protected String maSach;
    protected String ngayNhap;
    protected double donGia;
    protected int soLuong;
    protected String nhaXuatBan;

    static Scanner sc = new Scanner(System.in);
    // Ham nhap thong tin chung
    public void nhap() {
        System.out.print("Nhap ma sach: ");
        maSach = sc.nextLine();

        System.out.print("Nhap ngay nhap (dd/mm/yyyy): ");
        ngayNhap = sc.nextLine();

        System.out.print("Nhap don gia: ");
        donGia = Double.parseDouble(sc.nextLine());

        System.out.print("Nhap so luong: ");
        soLuong = Integer.parseInt(sc.nextLine());

        System.out.print("Nhap nha xuat ban: ");
        nhaXuatBan = sc.nextLine();
    }

    // Ham xuat thong tin chung
    public void xuat() {
        System.out.println("Ma sach: " + maSach);
        System.out.println("Ngay nhap: " + ngayNhap);
        System.out.println("Don gia: " + donGia);
        System.out.println("So luong: " + soLuong);
        System.out.println("Nha xuat ban: " + nhaXuatBan);
    }

    public double thanhTien() {
        return 0;
    }
}

// LOP SACH GIAO KHOA
class SachGiaoKhoa extends Sach {
    private String tinhTrang;

    @Override
    public void nhap() {
        super.nhap();

        System.out.print("Nhap tinh trang (moi/cu): ");
        tinhTrang = sc.nextLine();
    }

    @Override
    public void xuat() {
        super.xuat();

        System.out.println("Tinh trang: " + tinhTrang);
        System.out.println("Thanh tien: " + thanhTien());
    }

    @Override
    public double thanhTien() {
        if (tinhTrang.equalsIgnoreCase("moi")) {
            return soLuong * donGia;
        } else {
            return soLuong * donGia * 0.5;
        }
    }

    public boolean laNhaXuatBan(String x) {
        return nhaXuatBan.equalsIgnoreCase(x);
    }
}

// LOP SACH THAM KHAO
class SachThamKhao extends Sach {
    private double thue;

    @Override
    public void nhap() {
        super.nhap();

        System.out.print("Nhap thue: ");
        thue = Double.parseDouble(sc.nextLine());
    }

    @Override
    public void xuat() {
        super.xuat();

        System.out.println("Thue: " + thue);
        System.out.println("Thanh tien: " + thanhTien());
    }

    @Override
    public double thanhTien() {
        return soLuong * donGia + thue;
    }

    public double getDonGia() {
        return donGia;
    }
}
// LOP MAIN
public class Main {
    public static void main(String[] args) {
        // KHAI BAO DANH SACH
        ArrayList<SachGiaoKhoa> dsSGK = new ArrayList<>();
        ArrayList<SachThamKhao> dsSTK = new ArrayList<>();
        int n, m;
        // NHAP SACH GIAO KHOA
        System.out.print("Nhap so sach giao khoa: ");
        n = Integer.parseInt(Sach.sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("\nNhap sach giao khoa thu " + (i + 1));
            SachGiaoKhoa s = new SachGiaoKhoa();
            s.nhap();
            dsSGK.add(s);
        }
        // NHAP SACH THAM KHAO
        System.out.print("\nNhap so sach tham khao: ");
        m = Integer.parseInt(Sach.sc.nextLine());
        for (int i = 0; i < m; i++) {
            System.out.println("\nNhap sach tham khao thu " + (i + 1));

            SachThamKhao s = new SachThamKhao();
            s.nhap();
            dsSTK.add(s);
        }
        // XUAT SACH GIAO KHOA
        System.out.println("\n===== DANH SACH SACH GIAO KHOA =====");
        for (SachGiaoKhoa s : dsSGK) {
            s.xuat();
            System.out.println("--------------------");
        }
        // XUAT SACH THAM KHAO
        System.out.println("\n===== DANH SACH SACH THAM KHAO =====");
        for (SachThamKhao s : dsSTK) {
            s.xuat();
            System.out.println("--------------------");
        }
        // TINH TONG THANH TIEN SACH GIAO KHOA
        double tongSGK = 0;
        for (SachGiaoKhoa s : dsSGK) {
            tongSGK += s.thanhTien();
        }
        System.out.println("\nTong thanh tien sach giao khoa: " + tongSGK);
        // TINH TONG THANH TIEN SACH THAM KHAO
        double tongSTK = 0;
        for (SachThamKhao s : dsSTK) {
            tongSTK += s.thanhTien();
        }
        System.out.println("Tong thanh tien sach tham khao: " + tongSTK);
        // TINH TRUNG BINH CONG DON GIA SACH THAM KHAO
        double tongDonGia = 0;
        for (SachThamKhao s : dsSTK) {
            tongDonGia += s.getDonGia();
        }
        if (m > 0) {
            System.out.println("Trung binh cong don gia sach tham khao: "
                    + (tongDonGia / m));
        } else {
            System.out.println("Khong co sach tham khao.");
        }
        // XUAT SACH GIAO KHOA CUA NHA XUAT BAN X
        System.out.println("\n===== SACH GIAO KHOA CUA NHA XUAT BAN X =====");
        System.out.print("Nhap ten nha xuat ban X: ");
        String x = Sach.sc.nextLine();
        boolean timThay = false;
        for (SachGiaoKhoa s : dsSGK) {
            if (s.laNhaXuatBan(x)) {
                s.xuat();
                System.out.println("--------------------");
                timThay = true;
            }
        }
        if (!timThay) {
            System.out.println("Khong tim thay sach cua nha xuat ban " + x);
        }
    }
}