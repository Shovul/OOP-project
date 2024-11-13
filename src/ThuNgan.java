// package Restaurant;

import java.util.Scanner;

public class ThuNgan extends NhanVien {
  protected int soHoaDon;
  // danh sach cac hoa don?
  public ThuNgan() {
    super();
    soHoaDon = 0;
  }
  public ThuNgan(int maNV, String hoTen, double luong, boolean fulltime, int ngayLamViec, int ngayNghi, int soHoaDon) {
    super(maNV, hoTen, luong, fulltime, ngayLamViec, ngayNghi);
    this.soHoaDon = soHoaDon;
  }

  public int getHoaDon() {
    return soHoaDon;
  }
  public void setHoaDon(int n) {
    soHoaDon = n;
  }

  public void nhap() {
    super.nhap();
    Scanner scanner = new Scanner(System.in);
    System.out.print("Nhap so don da phuc vu: ");
    soHoaDon = scanner.nextInt();
  }
  public void xuat() {
    super.xuat();
    System.out.println("- So hoa don: " + soHoaDon);
  }

  public void addThuong() {
    thuong += 40000;
  }
  public double getTien() {
    return (ngayLamViec - super.checkNgayNghi())*luong + thuong*(soHoaDon/30);
  }
}
