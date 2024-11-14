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

  public void setNguyenLieu(String ten) {
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

  public void xuat() {
    System.out.println("So luong " + ten + ": " + soLuong);
  }
  public void nhap() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Nhap ten nguyen lieu: ");
    ten = scanner.nextLine();
    System.out.print("Nhap so luong nguyen lieu: ");
    soLuong = scanner.nextInt();
  }
}
