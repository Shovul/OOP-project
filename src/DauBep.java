// package Restaurant;

import java.util.Scanner;

public class DauBep extends NhanVien implements iCook{
  protected int soLuongMonNau;
  protected static int soLuong = 0;
  // danh sach do an da nau
  public DauBep() {
    super();
    soLuongMonNau = 0;
    soLuong++;
  }
  public DauBep(int maNV, String hoTen, double luong, boolean fulltime, int ngayLamViec, int ngayNghi, int soLuongMonNau) {
    super(maNV, hoTen, luong, fulltime, ngayLamViec, ngayNghi);
    this.soLuongMonNau = soLuongMonNau;
    soLuong++;
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
    System.out.println("- So mon nau: " + soLuongMonNau);
  }
  
  @Override
  public int checkNgayNghi() {
    return ngayNghi > 5 ? ngayNghi-5 : 0;
  }
  @Override
  public void addThuong() {
    thuong += 100000;
  }
  @Override
  public double getTien() {
    return (ngayLamViec - checkNgayNghi())*luong + thuong*(soLuongMonNau/50);
  }

  public void nauMon(DoAn thucan, KhoNguyenLieu kho) {
    thucan.dungNguyenLieu(kho);
    soLuongMonNau++;
  }
  public void nauMon(Nuoc nuoc, KhoNguyenLieu kho) {
    nuoc.dungNguyenLieu(kho);
    soLuongMonNau++;
  }
  // public void nauMon(DSMon ds, KhoNguyenLieu kho) {
  //   for(int i=0; i<ds.getLength(); i++) {
  //     nauMon(ds.getDanhSachMon()[i], kho);
  //   }
  // }
  
  static public int getSoLuong() {
    return soLuong;
  }
}
