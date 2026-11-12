
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
    // Ham tinh thanh tien
    public double tinhThanhTien() {
        return donGia * soLuong;
    }
    // Ham tinh phi van chuyen
    public double tinhPhiVanChuyen() {
        return tinhThanhTien() * 0.05;
    }
    // Ham tinh tong tien
    public double tinhTongTien() {
        return tinhThanhTien() + tinhPhiVanChuyen();
    }
    // Lay ma sach
    public String getMaSach() {
        return maSach;
    }
    // Lay so luong
    public int getSoLuong() {
        return soLuong;
    }
    // Hien thi thong tin sach
    public void hienThiThongTin() {
        System.out.println("\n----------------------------------");
        System.out.println("Ma sach        : " + maSach);
        System.out.println("Ten sach       : " + tenSach);
        System.out.println("Tac gia        : " + tacGia);
        System.out.println("Nam xuat ban   : " + namXuatBan);
        System.out.println("Don gia        : " + donGia + " VNĐ");
        System.out.println("So luong       : " + soLuong);
        System.out.println("Thanh tien     : " + tinhThanhTien() + " VNĐ");
        System.out.println("Phi van chuyen : " + tinhPhiVanChuyen() + " VNĐ");
        System.out.println("Tong tien      : " + tinhTongTien() + " VNĐ");
        System.out.println("----------------------------------");
    }
}
// CHUONG TRINH CHINH
public class baithuchanhtuan6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // ARRAYLIST LUU DANH SACH DOI TUONG SACH
        ArrayList<Sach> danhSachSach = new ArrayList<>();
        // ARRAYLIST LUU MA SACH
        ArrayList<String> danhSachMa = new ArrayList<>();
        int chon;
        // MENU CHINH
        do {
            System.out.println("\n========== QUAN LY THU VIEN ==========");
            System.out.println("1. Nhap danh sach sach");
            System.out.println("2. Hien thi danh sach sach");
            System.out.println("3. Tim sach theo ma");
            System.out.println("4. Xoa sach");
            System.out.println("5. Sua sach");
            System.out.println("6. Tinh tong so luong sach");
            System.out.println("7. Tinh tong gia tri sach");
            System.out.println("8. Thuc hanh mang int");
            System.out.println("9. Thuc hanh ArrayList ma sach");
            System.out.println("10. Thoat");
            System.out.println("======================================");
            System.out.print("Nhap lua chon: ");
            chon = scanner.nextInt();
            scanner.nextLine();
            switch (chon) {
                // 1. NHAP DANH SACH SACH
                case 1: {
                    int n;
                    System.out.print("Nhap so sach can them: ");
                    n = scanner.nextInt();
                    scanner.nextLine();
                    for (int i = 0; i < n; i++) {
                        System.out.println("\nNhap sach thu " + (i + 1));
                        Sach sach = new Sach();
                        sach.nhapThongTin(scanner);
                        danhSachSach.add(sach);
                        danhSachMa.add(sach.getMaSach());
                    }
                    System.out.println("Them sach thanh cong!");
                    break;
                }
                // 2. HIEN THI DANH SACH SACH
                case 2: {
                    if (danhSachSach.isEmpty()) {
                        System.out.println("Danh sach sach dang trong!");
                    } else {
                        for (int i = 0; i < danhSachSach.size(); i++) {
                            System.out.println("\nSach thu " + (i + 1));
                            danhSachSach.get(i).hienThiThongTin();
                        }
                    }
                    break;
                }
                // 3. TIM SACH
                case 3: {
                    System.out.print("Nhap ma sach can tim: ");
                    String maTim = scanner.nextLine();
                    boolean timThay = false;
                    for (int i = 0; i < danhSachSach.size(); i++) {
                        Sach sach = danhSachSach.get(i);
                        if (sach.getMaSach().equalsIgnoreCase(maTim)) {
                            System.out.println("Tim thay sach!");
                            sach.hienThiThongTin();
                            timThay = true;
                            break;
                        }
                    }
                    if (timThay == false) {
                        System.out.println("Khong tim thay sach!");
                    }
                    break;
                }
                // 4. XOA SACH
                case 4: {
                    System.out.print("Nhap ma sach can xoa: ");
                    String maXoa = scanner.nextLine();
                    boolean daXoa = false;
                    for (int i = 0; i < danhSachSach.size(); i++) {
                        if (danhSachSach.get(i).getMaSach()
                                .equalsIgnoreCase(maXoa)) {
                            danhSachSach.remove(i);
                            danhSachMa.remove(i);
                            daXoa = true;
                            System.out.println("Xoa sach thanh cong!");
                            break;
                        }
                    }
                    if (daXoa == false) {
                        System.out.println("Khong tim thay sach!");
                    }
                    break;
                }
                // 5. SUA SACH
                case 5: {
                    System.out.print("Nhap ma sach can sua: ");
                    String maSua = scanner.nextLine();
                    boolean daSua = false;
                    for (int i = 0; i < danhSachSach.size(); i++) {
                        Sach sach = danhSachSach.get(i);
                        if (sach.getMaSach().equalsIgnoreCase(maSua)) {
                            System.out.println("Nhap lai thong tin sach:");
                            sach.nhapThongTin(scanner);
                            danhSachMa.set(i, sach.getMaSach());
                            System.out.println("Sua sach thanh cong!");
                            daSua = true;
                            break;
                        }
                    }
                    if (daSua == false) {
                        System.out.println("Khong tim thay sach!");
                    }
                    break;
                }
                // 6. TINH TONG SO LUONG
                case 6: {
                    int tongSoLuong = 0;
                    for (int i = 0; i < danhSachSach.size(); i++) {
                        tongSoLuong += danhSachSach.get(i).getSoLuong();
                    }
                    System.out.println("Tong so luong sach: " + tongSoLuong);
                    break;
                }
                // 7. TINH TONG GIA TRI
                case 7: {
                    double tongGiaTri = 0;
                    for (int i = 0; i < danhSachSach.size(); i++) {
                        tongGiaTri += danhSachSach.get(i).tinhTongTien();
                    }
                    System.out.println("Tong gia tri sach: "
                            + tongGiaTri + " VNĐ");
                    break;
                }
                // 8. BAI 1: SU DUNG MANG INT
                case 8: {
                    int[] soLuong = new int[5];
                    int tong = 0;
                    System.out.println("\nNHAP SO LUONG 5 CUON SACH");
                    for (int i = 0; i < 5; i++) {
                        System.out.print("Nhap so luong sach thu " + (i + 1) + ": ");
                        soLuong[i] = scanner.nextInt();
                    }
                    int max = soLuong[0];
                    System.out.println("\nDANH SACH SO LUONG:");
                    for (int i = 0; i < 5; i++) {
                        System.out.println("Sach " + (i + 1) + ": " + soLuong[i]);
                        tong += soLuong[i];
                        if (soLuong[i] > max) {
                            max = soLuong[i];
                        }
                    }
                    System.out.println("Tong so luong: " + tong);
                    System.out.println("So luong lon nhat: " + max);
                    break;
                }
                // 9. BAI 2: ARRAYLIST STRING
                case 9: {
                    int luaChon;
                    do {
                        System.out.println("\n===== QUAN LY MA SACH =====");
                        System.out.println("1. Them ma sach");
                        System.out.println("2. Hien thi ma sach");
                        System.out.println("3. Tim ma sach");
                        System.out.println("4. Xoa ma sach");
                        System.out.println("0. Quay lai menu chinh");
                        System.out.print("Nhap lua chon: ");
                        luaChon = scanner.nextInt();
                        scanner.nextLine();
                        switch (luaChon) {
                            case 1: {
                                System.out.print("Nhap ma sach: ");
                                String ma = scanner.nextLine();
                                danhSachMa.add(ma);
                                System.out.println("Them thanh cong!");
                                break;
                            }
                            case 2: {
                                for (int i = 0; i < danhSachMa.size(); i++) {
                                    System.out.println(danhSachMa.get(i));
                                }
                                break;
                            }
                            case 3: {
                                System.out.print("Nhap ma can tim: ");
                                String ma = scanner.nextLine();
                                if (danhSachMa.contains(ma)) {
                                    System.out.println("Tim thay ma sach!");
                                } else {
                                    System.out.println("Khong tim thay!");
                                }
                                break;
                            }
                            case 4: {
                                System.out.print("Nhap ma can xoa: ");
                                String ma = scanner.nextLine();
                                if (danhSachMa.remove(ma)) {
                                    System.out.println("Xoa thanh cong!");
                                } else {
                                    System.out.println("Khong tim thay!");
                                }
                                break;
                            }
                            case 0: {
                                System.out.println("Quay lai menu chinh!");
                                break;
                            }
                            default: {
                                System.out.println("Lua chon khong hop le!");
                            }
                        }
                    } while (luaChon != 0);
                    break;
                }
                // 10. THOAT
                case 10: {
                    System.out.println("Da thoat chuong trinh!");
                    break;
                }
                default: {
                    System.out.println("Lua chon khong hop le!");
                }
            }
        } while (chon != 10);
        scanner.close();
    }
}
