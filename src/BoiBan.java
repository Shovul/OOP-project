// package Restaurant;

import java.util.Scanner;

public class BoiBan extends NhanVien {
  protected int soKhachPhucVu;
  protected static int soLuong = 0;
  // danh sach khach phuc vu?
  public BoiBan() {
    super();
    soKhachPhucVu = 0;
    soLuong++;
  }
  public BoiBan(int maNV, String hoTen, double luong, boolean fulltime, int ngayLamViec, int ngayNghi, int soKhachPhucVu) {
    super(maNV, hoTen, luong, fulltime, ngayLamViec, ngayNghi);
    this.soKhachPhucVu = soKhachPhucVu;
    soLuong++;
  }
  
  public int getSoKhachPhucVu() {
    return soKhachPhucVu;
  }
  public void setSoKhachPhucVu(int n) {
    soKhachPhucVu = n;
  }
  
  public void nhap() {
    super.nhap();
    Scanner scanner = new Scanner(System.in);
    System.out.print("Nhap so khach da phuc vu: ");
    soKhachPhucVu = scanner.nextInt();
  }
  public void xuat() {
    super.xuat();
    System.out.println("- So hoa don: " + soKhachPhucVu);
  }
  @Override
  public int checkNgayNghi() {
    return ngayNghi > 2 ? ngayNghi - 2 : 0;
  }
  public void addThuong() {
    thuong += 30000;
  }
  public double getTien() {
    return (ngayLamViec - checkNgayNghi())*luong + thuong*(soKhachPhucVu/120);
  }
  
  static public int getSoLuong() {
    return soLuong;
  }
}
