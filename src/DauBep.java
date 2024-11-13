// package Restaurant;

import java.util.Scanner;

public class DauBep extends NhanVien{
  protected int soLuongMonNau;
  // danh sach do an da nau
  public DauBep() {
    super();
    soLuongMonNau = 0;
  }
  public DauBep(int maNV, String hoTen, double luong, boolean fulltime, int ngayLamViec, int ngayNghi, int soLuongMonNau) {
    super(maNV, hoTen, luong, fulltime, ngayLamViec, ngayNghi);
    this.soLuongMonNau = soLuongMonNau;
  }

  public int getSoLuongMon() {
    return soLuongMonNau;
  }
  public void setSoLuongMon(int n) {
    soLuongMonNau = n;
  }

  public void nhap() {
    super.nhap();
    Scanner scanner = new Scanner(System.in);
    System.out.print("Nhap so luong mon da nau: ");
    soLuongMonNau = scanner.nextInt();
  }
  public void xuat() {
    super.xuat();
    System.out.println("- So hoa don: " + soLuongMonNau);
  }
  
  @Override
  public int checkNgayNghi() {
    return ngayNghi > 5 ? ngayNghi-5 : 0;
  }
  public void addThuong() {
    thuong += 100000;
  }
  public double getTien() {
    return (ngayLamViec - checkNgayNghi())*luong + thuong*(soLuongMonNau/50);
  }
}
