
import java.util.ArrayList;
import java.util.Scanner;
// LOP SACH
class Sach {
    private String maSach;
    private String tenSach;
    private String tacGia;
    private int namXuatBan;
    private double donGia;
    private int soLuong;
    // Ham nhap thong tin sach
    public void nhapThongTin(Scanner scanner) {
        System.out.println("\n=== NHAP THONG TIN SACH ===");
        System.out.print("Nhap ma sach: ");
        maSach = scanner.nextLine();
        System.out.print("Nhap ten sach: ");
        tenSach = scanner.nextLine();
        System.out.print("Nhap tac gia: ");
        tacGia = scanner.nextLine();
        System.out.print("Nhap nam xuat ban: ");
        namXuatBan = scanner.nextInt();
        System.out.print("Nhap don gia: ");
        donGia = scanner.nextDouble();
        System.out.print("Nhap so luong: ");
        soLuong = scanner.nextInt();
        scanner.nextLine();
    }
    // Tinh thanh tien
    public double tinhThanhTien() {
        return donGia * soLuong;
    }
    // Tinh phi van chuyen
    public double tinhPhiVanChuyen() {
        return tinhThanhTien() * 0.05;
    }
    // Tinh tong tien
    public double tinhTongTien() {
        return tinhThanhTien() + tinhPhiVanChuyen();
    }
    // Lay ma sach de tim kiem
    public String getMaSach() {
        return maSach;
    }
    // Hien thi thong tin sach
    public void hienThiThongTin() {
        System.out.println("\n--------------------------------------");
        System.out.println("Ma sach        : " + maSach);
        System.out.println("Ten sach       : " + tenSach);
        System.out.println("Tac gia        : " + tacGia);
        System.out.println("Nam xuat ban   : " + namXuatBan);
        System.out.println("Don gia        : " + donGia + " VNĐ");
        System.out.println("So luong       : " + soLuong);
        System.out.println("Thanh tien     : " + tinhThanhTien() + " VNĐ");
        System.out.println("Phi van chuyen : " + tinhPhiVanChuyen() + " VNĐ");
        System.out.println("Tong tien nhap : " + tinhTongTien() + " VNĐ");
        System.out.println("--------------------------------------");
    }
    // Lay so luong sach
    public int getSoLuong() {
        return soLuong;
    }
}
// CHUONG TRINH CHINH
public class baithuchanhtuan3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Tao danh sach chua nhieu sach
        ArrayList<Sach> danhSachSach = new ArrayList<>();
        int chon;
        // MENU LAP DEN KHI CHON THOAT
        do {
            System.out.println("\n========== QUAN LY THU VIEN ==========");
            System.out.println("1. Nhap danh sach n sach");
            System.out.println("2. Hien thi danh sach sach");
            System.out.println("3. Tinh tong so luong va tong gia tri sach");
            System.out.println("4. Tim sach theo ma sach");
            System.out.println("0. Thoat");
            System.out.println("=====================================");
            System.out.print("Nhap lua chon: ");
            chon = scanner.nextInt();
            scanner.nextLine();
            switch (chon) {
                // BAI 1: NHAP N SACH BANG VONG LAP
                case 1: {
                    int n;
                    System.out.print("Nhap so luong sach can nhap: ");
                    n = scanner.nextInt();
                    scanner.nextLine();
                    for (int i = 0; i < n; i++) {
                        System.out.println("\nNhap sach thu " + (i + 1));
                        Sach sach = new Sach();
                        sach.nhapThongTin(scanner);
                        danhSachSach.add(sach);
                    }
                    System.out.println("\nDa nhap thanh cong " + n + " sach!");
                    break;
                }
                // HIEN THI DANH SACH SACH
                case 2: {
                    if (danhSachSach.isEmpty()) {
                        System.out.println("Danh sach sach dang trong!");
                    } else {
                        System.out.println("\n===== DANH SACH SACH =====");
                        for (int i = 0; i < danhSachSach.size(); i++) {
                            System.out.println("\nSach thu " + (i + 1));
                            danhSachSach.get(i).hienThiThongTin();
                        }
                    }
                    break;
                }
                // BAI 2: TINH TONG SO LUONG VA TONG GIA TRI
                case 3: {
                    int tongSoLuong = 0;
                    double tongGiaTri = 0;
                    double tongPhiVanChuyen = 0;
                    for (int i = 0; i < danhSachSach.size(); i++) {
                        Sach sach = danhSachSach.get(i);
                        tongSoLuong += sach.getSoLuong();
                        tongGiaTri += sach.tinhThanhTien();
                        tongPhiVanChuyen += sach.tinhPhiVanChuyen();
                    }
                    System.out.println("\n===== THONG KE SACH =====");
                    System.out.println("Tong so dau sach: " + danhSachSach.size());
                    System.out.println("Tong so luong sach: " + tongSoLuong);
                    System.out.println("Tong gia tri sach: " + tongGiaTri + " VNĐ");
                    System.out.println("Tong phi van chuyen: " + tongPhiVanChuyen + " VNĐ");
                    System.out.println("Tong tien nhap kho: "
                            + (tongGiaTri + tongPhiVanChuyen) + " VNĐ");

                    break;
                }
                // BAI 4: TIM SACH THEO MA
                case 4: {
                    System.out.print("Nhap ma sach can tim: ");
                    String maCanTim = scanner.nextLine();
                    boolean timThay = false;
                    for (int i = 0; i < danhSachSach.size(); i++) {
                        Sach sach = danhSachSach.get(i);
                        if (sach.getMaSach().equalsIgnoreCase(maCanTim)) {
                            System.out.println("\nDa tim thay sach!");
                            sach.hienThiThongTin();
                            timThay = true;
                        }
                    }
                    if (timThay == false) {
                        System.out.println("Khong tim thay sach co ma: " + maCanTim);
                    }

                    break;
                }
                // THOAT CHUONG TRINH
                case 0: {
                    System.out.println("Da thoat chuong trinh!");
                    break;
                }
                // LUA CHON KHONG HOP LE
                default: {
                    System.out.println("Lua chon khong hop le! Vui long nhap lai.");
                }
            }
        } while (chon != 0);
        scanner.close();
    }
}