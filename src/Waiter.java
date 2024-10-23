package Restaurant;

import java.util.Scanner;

public class Waiter extends Employee {
  int soKhachPhucVu;
  // danh sach khach phuc vu?
  public Waiter() {
    super();
    soKhachPhucVu = 0;
  }
  public Waiter(int maNV, String hoTen, float luong, boolean fulltime, int ngayLamViec, int ngayNghi, int soKhachPhucVu) {
    super(maNV, hoTen, luong, fulltime, ngayLamViec, ngayNghi);
    this.soKhachPhucVu = soKhachPhucVu;
  }
  
  public void nhap() {
    super.nhap();
    Scanner scanner = new Scanner(System.in);
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
  public float getTien() {
    return (ngayLamViec - checkNgayNghi())*luong + thuong*(soKhachPhucVu/120);
  }
}
