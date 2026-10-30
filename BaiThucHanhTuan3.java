import java.util.Scanner;

class Sach {
    private String maSach;
    private String tenSach;
    private String tacGia;
    private int namXuatBan;
    private double donGia;
    private int soLuong;

    public void nhapThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== NHẬP THÔNG TIN SÁCH ===");
        System.out.print("Nhập mã sách: ");
        maSach = scanner.nextLine();
        System.out.print("Nhập tên sách: ");
        tenSach = scanner.nextLine();
        System.out.print("Nhập tác giả: ");
        tacGia = scanner.nextLine();
        System.out.print("Nhập năm xuất bản: ");
        namXuatBan = scanner.nextInt();
        System.out.print("Nhập đơn giá: ");
        donGia = scanner.nextDouble();
        System.out.print("Nhập số lượng: ");
        soLuong = scanner.nextInt();
    }

    public double tinhThanhTien() {
        return donGia * soLuong;
    }

    public double tinhPhiVanChuyen() {
        return tinhThanhTien() * 0.05;
    }

    public double tinhTongTien() {
        return tinhThanhTien() + tinhPhiVanChuyen();
    }

    public void hienThiThongTin() {
        System.out.println("\n========================================");
        System.out.println("       THÔNG TIN VÀ GIÁ TRỊ NHẬP KHO     ");
        System.out.println("========================================");
        System.out.println("Mã sách        : " + maSach);
        System.out.println("Tên sách       : " + tenSach);
        System.out.println("Tác giả        : " + tacGia);
        System.out.println("Năm xuất bản   : " + namXuatBan);
        System.out.println("Đơn giá        : " + donGia + " VNĐ");
        System.out.println("Số lượng       : " + soLuong);
        System.out.println("----------------------------------------");
        System.out.println("Thành tiền     : " + tinhThanhTien() + " VNĐ");
        System.out.println("Phí vận chuyển : " + tinhPhiVanChuyen() + " VNĐ");
        System.out.println("Tổng tiền nhập : " + tinhTongTien() + " VNĐ");
        System.out.println("========================================");
    }
}

public class BaiThucHanhTuan3 {
    public static void main(String[] args) {
        Sach sachMoi = new Sach();
        sachMoi.nhapThongTin();
        sachMoi.hienThiThongTin();
    }
}