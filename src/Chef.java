package Restaurant;

import java.util.Scanner;

public class Chef extends Employee{
  int soLuongMonNau;
  // danh sach do an da nau
  public Chef() {
    super();
    soLuongMonNau = 0;
  }
  public Chef(int maNV, String hoTen, float luong, boolean fulltime, int ngayLamViec, int ngayNghi, int soLuongMonNau) {
    super(maNV, hoTen, luong, fulltime, ngayLamViec, ngayNghi);
    this.soLuongMonNau = soLuongMonNau;
  }

  public void nhap() {
    super.nhap();
    Scanner scanner = new Scanner(System.in);
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
  public float getTien() {
    return (ngayLamViec - checkNgayNghi())*luong + thuong*(soLuongMonNau/50);
  }
}
