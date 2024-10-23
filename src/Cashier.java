package Restaurant;

import java.util.Scanner;

public class Cashier extends Employee {
  int soHoaDon;
  // danh sach cac hoa don?
  public Cashier() {
    super();
    soHoaDon = 0;
  }
  public Cashier(int maNV, String hoTen, float luong, boolean fulltime, int ngayLamViec, int ngayNghi, int soHoaDon) {
    super(maNV, hoTen, luong, fulltime, ngayLamViec, ngayNghi);
    this.soHoaDon = soHoaDon;
  }

  public void nhap() {
    super.nhap();
    Scanner scanner = new Scanner(System.in);
    soHoaDon = scanner.nextInt();
  }
  public void xuat() {
    super.xuat();
    System.out.println("- So hoa don: " + soHoaDon);
  }

  public void addThuong() {
    thuong += 40000;
  }
  public float getTien() {
    return (ngayLamViec - super.checkNgayNghi())*luong + thuong*(soHoaDon/30);
  }
}
