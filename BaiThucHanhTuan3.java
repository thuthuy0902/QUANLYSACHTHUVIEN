import java.util.Scanner;
import java.time.Year;

class Sach {
    private String maSach;
    private String tenSach;
    private String tacGia;
    private int namXuatBan;
    private double donGia;
    private int soLuong;
    private int loaiSach; // Biến lưu lựa chọn loại sách (Bài 4)

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

        // Bài 4: Chọn loại sách dùng switch-case (hoặc menu lựa chọn)
        System.out.println("\n--- CHỌN LOẠI SÁCH ---");
        System.out.println("1. Sách giáo khoa");
        System.out.println("2. Sách tham khảo");
        System.out.println("3. Sách chuyên ngành");
        System.out.println("4. Sách khác");
        System.out.print("Nhập lựa chọn của bạn (1-4): ");
        loaiSach = scanner.nextInt();
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

    // Bài 1: Kiểm tra tính hợp lệ (giá > 0, số lượng >= 0, năm xuất bản hợp lệ từ 1900 đến năm hiện tại)
    public boolean kiemTraHopLe() {
        int namHienTai = Year.now().getValue();
        if (donGia > 0 && soLuong >= 0 && namXuatBan >= 1900 && namXuatBan <= namHienTai) {
            return true;
        }
        return false;
    }

    // Bài 2: Phân loại giá sách
    public String phanLoaiGia() {
        if (donGia < 50000) {
            return "Sách giá thấp";
        } else if (donGia <= 100000) {
            return "Sách giá trung bình";
        } else if (donGia <= 200000) {
            return "Sách giá cao";
        } else {
            return "Sách giá đặc biệt";
        }
    }

    // Bài 3: Phân loại tồn kho
    public String phanLoaiTonKho() {
        if (soLuong == 0) {
            return "Hết sách";
        } else if (soLuong <= 5) {
            return "Sắp hết";
        } else if (soLuong <= 20) {
            return "Còn ít";
        } else {
            return "Còn nhiều";
        }
    }

    // Bài 4: Xử lý loại sách dùng switch-case
    public String layTenLoaiSach() {
        switch (loaiSach) {
            case 1:
                return "Sách giáo khoa";
            case 2:
                return "Sách tham khảo";
            case 3:
                return "Sách chuyên ngành";
            case 4:
                return "Sách khác";
            default:
                return "Không xác định";
        }
    }

    public void hienThiThongTin() {
        System.out.println("\n========================================");
        System.out.println("       THÔNG TIN VÀ RA QUYẾT ĐỊNH KHO     ");
        System.out.println("========================================");
        System.out.println("Mã sách        : " + maSach);
        System.out.println("Tên sách       : " + tenSach);
        System.out.println("Tác giả        : " + tacGia);
        System.out.println("Năm xuất bản   : " + namXuatBan);
        System.out.println("Đơn giá        : " + donGia + " VNĐ");
        System.out.println("Số lượng       : " + soLuong);
        System.out.println("Loại sách      : " + layTenLoaiSach());
        System.out.println("----------------------------------------");
        
        // Hiển thị kết quả cấu trúc điều kiện (Bài 1, 2, 3)
        System.out.println("Kiểm tra hợp lệ: " + (kiemTraHopLe() ? "Hợp lệ" : "Không hợp lệ (Sai đơn giá/số lượng/năm XB)"));
        System.out.println("Phân loại giá  : " + phanLoaiGia());
        System.out.println("Trạng thái kho : " + phanLoaiTonKho());
        
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