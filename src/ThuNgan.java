// package Restaurant;

import java.util.Scanner;

public class ThuNgan extends NhanVien {
  protected int soHoaDon;
  protected static int soLuong = 0;
  // danh sach cac hoa don?
  public ThuNgan() {
    super();
    soHoaDon = 0;
    soLuong++;
  }
  public ThuNgan(int maNV, String hoTen, double luong, boolean fulltime, int ngayLamViec, int ngayNghi, int soHoaDon) {
    super(maNV, hoTen, luong, fulltime, ngayLamViec, ngayNghi);
    this.soHoaDon = soHoaDon;
    soLuong++;
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
  
  // public void capNhatNhanVien() {
  //   System.out.println("1. Sua ma");
  //   System.out.println("2. Sua ho ten");
  //   System.out.println("3. Sua luong");
  //   System.out.println("4. Sua so ngay lam viec");
  //   System.out.println("5. Sua so ngay nghi");
  //   System.out.println("6. Sua tuyen dung (partime/fulltime");
  //   System.out.println("7. Sua thuong");
  //   System.out.println("8. Sua so hoa don");
  //   Scanner scanner = new Scanner(System.in);
  //   switch (hoTen) {
  //     case 1:
  //       System.out.println("Nhap ma");
  //       maNV = scanner.nextInt();
  //       break;
  //     case 2:
  //       System.out.println("Nhap ho ten");
  //       maNV = scanner.nextInt();
  //       break;
  //     case 3:
  //       System.out.println("Nhap luong");
  //       maNV = scanner.nextInt();
  //       break;
  //     case 4:
  //       System.out.println("Nhap so ngay lam viec");
  //       maNV = scanner.nextInt();
  //       break;
  //     case 5:
  //       System.out.println("Nhap so ngay nghi");
  //       maNV = scanner.nextInt();
  //       break;
  //     case 6:
  //       System.out.println("Nhap tuyen dung");
  //       maNV = scanner.nextInt();
  //       break;
  //     case 7:
  //       System.out.println("Nhap thuong");
  //       maNV = scanner.nextInt();
  //       break;
  //     case 8:
  //       System.out.println("Nhap ma");
  //       maNV = scanner.nextInt();
  //       break;
    
  //     default:
  //       break;
  //   }
  // }
  
  static public int getSoLuong() {
    return soLuong;
  }
}
