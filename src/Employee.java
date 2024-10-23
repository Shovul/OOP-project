package Restaurant;

import java.util.Scanner;

public abstract class Employee {
  protected int maNV, ngayLamViec, ngayNghi;
  protected String hoTen;
  protected float luong, thuong;
  protected boolean fulltime;
  protected static int soLuongNV = 0;

  public Employee(int maNV, String hoTen, float luong, boolean fulltime, int ngayLamViec, int ngayNghi) {
    this.maNV = maNV;
    this.hoTen = hoTen;
    this.luong = luong;
    this.fulltime = fulltime;
    this.ngayLamViec = ngayLamViec;
    this.ngayNghi = ngayNghi;
    soLuongNV++;
  }
  public Employee() {
    this.maNV = -1;
    this.ngayLamViec = 0;
    this.ngayNghi = 0;
    this.hoTen = "none";
    this.luong = 0;
    this.thuong = 0;
    this.fulltime = true;
    soLuongNV++;
  }

  public void setMaNV(int maNV) {
    this.maNV = maNV;
  }
  public void setTen(String hoTen) {
    this.hoTen = hoTen;
  }
  public void setNgayLamViec(int ngayLamViec) {
    this.ngayLamViec = ngayLamViec;
  }
  public void setNgayNghi(int ngayNghi) {
    this.ngayNghi = ngayNghi;
  }
  public void setLuong(int luong) {
    this.luong = luong;
  }
  public void setFulltime() {
    fulltime = true;
  }
  public void setParttime() {
    fulltime = false;
  }

  public int getMaNV() {
    return maNV;
  }
  public String getTen() {
    return hoTen;
  }
  public float getLuong() {
    return luong;
  }
  public boolean getFulltime() {
    return fulltime;
  }
  public boolean getPartTime() {
    return !fulltime;
  }
  public int getNgayLamViec() {
    return ngayLamViec;
  }
  public int getNgayNghi() {
    return ngayNghi;
  }
  public float getThuong() {
    return thuong;
  }

  public void xuat() {
    System.out.println("Nhan vien " + hoTen + ", ma so: " + maNV);
    System.out.println("- Luong: " + luong + "vnd");
    System.out.println("- Thuong: " + thuong + "vnd");
    System.out.println("- Ngay lam viec: " + ngayLamViec);
    System.out.println("- Ngay nghi: " + ngayNghi);
    System.out.println(fulltime ? "Lam viec full-time" : "Lam viec part-time");
  }
  public void nhap() {
    Scanner scanner = new Scanner(System.in);
    String temp;

    System.out.print("Nhap ten nhan vien: ");
    hoTen = scanner.nextLine();
    System.out.print("Nhap ma so nhan vien: ");
    maNV = scanner.nextInt();
    System.out.print("Nhap tien luong nhan vien: ");
    luong = scanner.nextFloat();
    System.out.print("Nhap tien thuong nhan vien: ");
    thuong = scanner.nextFloat();
    System.out.print("Nhap ngay lam viec nhan vien: ");
    ngayLamViec = scanner.nextInt();
    System.out.print("Nhap ngay nghi nhan vien: ");
    ngayNghi = scanner.nextInt();
    do {
    System.out.print("Nhan vien lam viec fulltime hay partime?\n(Nhap parttime/ part-time/ part time/ p/ pt): de xac nhan la lam viec part-time\n(Nhap fulltime/ full-time/ full time/ ft/ f): de xac nhan la lam viec full-time");
    temp = scanner.nextLine();
    if (temp.equalsIgnoreCase("parttime") || temp.equalsIgnoreCase("part-time") || temp.equalsIgnoreCase("part time") || temp.equalsIgnoreCase("p") || temp.equalsIgnoreCase("pt")) {
      fulltime = false;
    }
    else if (temp.equalsIgnoreCase("fulltime") || temp.equalsIgnoreCase("full-time") || temp.equalsIgnoreCase("full time") || temp.equalsIgnoreCase("f") || temp.equalsIgnoreCase("ft")) {
      fulltime = true;
    }
    else {
      temp = "";
    }
    } while (temp.equals(""));
  }

  public int checkNgayNghi() {
    return ngayNghi > 3 ? ngayNghi - 3 : 0;
  }

  public void addNgayNghi() {
    ngayNghi++;
  }
  public void addNgayLamViec(int n) {
    ngayLamViec += n;
  }
  public void addNgayLamViec() {
    ngayLamViec++;
  }
  public void addThuong(float thuong) {
    this.thuong += thuong;
  }

  public abstract float getTien();
  public abstract void addThuong();
  static public int getEmployeeCount() {
    return soLuongNV;
  }
}
