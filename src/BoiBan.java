// package Restaurant;

import java.util.Scanner;

public class BoiBan extends NhanVien {
  protected int soBanPhucVu;
  protected static int soLuong = 0;
  // danh sach khach phuc vu?
  public BoiBan() {
    super();
    soBanPhucVu = 0;
    soLuong++;
  }
  public BoiBan(int maNV, String hoTen, double luong, boolean fulltime, int ngayLamViec, int ngayNghi, int soBanPhucVu) {
    super(maNV, hoTen, luong, fulltime, ngayLamViec, ngayNghi);
    this.soBanPhucVu = soBanPhucVu;
    soLuong++;
  }
  
  public int getSoBanPhucVu() {
    return soBanPhucVu;
  }
  public void setSoBanPhucVu(int n) {
    soBanPhucVu = n;
  }
  
  public void nhap() {
    super.nhap();
    Scanner scanner = new Scanner(System.in);
    System.out.print("Nhập số bàn đã phục vụ: ");
    soBanPhucVu = scanner.nextInt();
  }
  public void xuat() {
    super.xuat();
    System.out.println("- Số bàn phục vụ: " + soBanPhucVu);
  }
  @Override
  public int checkNgayNghi() {
    return ngayNghi > 2 ? ngayNghi - 2 : 0;
  }
  public void addThuong() {
    thuong += 30000;
  }
  public double getTien() {
    return (ngayLamViec - checkNgayNghi())*luong + thuong*(soBanPhucVu/120);
  }
  
  static public int getSoLuong() {
    return soLuong;
  }
}
