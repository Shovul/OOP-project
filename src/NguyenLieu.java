// package src;

import java.util.Scanner;

public class NguyenLieu {
  // protected int maNL;
  protected String ten;
  protected int soLuong;

  public NguyenLieu() {
    ten = "";
    soLuong = 0;
    // maNL = 0;
  }
  public NguyenLieu(int maNL, String ten, int soLuong) {
    // this.maNL = maNL;
    this.ten = ten;
    this.soLuong = soLuong;
  }

  public void setTen(String ten) {
    this.ten = ten;
  }
  public void setSoLuong(int sl) {
    soLuong = sl;
  }
  // public void setMaNguyenLieu(int ma) {
  //   maNL = ma;
  // }
  // public int getMaNguyenLieu() {
  //   return maNL;
  // }
  public String getTen() {
    return ten;
  }
  public int getSoLuong() {
    return soLuong;
  }
  public void themSoLuong(int them) {
    soLuong += them;
  }

  public void xuat() {
    System.out.println("Số lượng" + ten + ": " + soLuong);
  }
  public void nhap() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Nhập tên nguyên liệu: ");
    ten = scanner.nextLine();
    System.out.print("Nhập số lượng nguyên liệu: ");
    soLuong = scanner.nextInt();
  }
}
