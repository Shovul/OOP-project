// package Restaurant;

import java.util.Scanner;

public abstract class Mon {
  int maThucAn;
  String tenThucAn;
  double giaThucAn;
  int soLuong;
  
  public Mon(int maThucAn, String tenThucAn, double giaThucAn, int soLuong) {
    this.giaThucAn = giaThucAn;
    this.tenThucAn = tenThucAn;
    this.maThucAn = maThucAn;
    this.soLuong = soLuong;
  }
  public Mon() {
    this.giaThucAn = 0;
    this.tenThucAn = "";
    this.maThucAn = 0;
    this.soLuong = 0;
  }

  public void setTenThucAn(String tenThucAn) {
    this.tenThucAn = tenThucAn;
  }
  public void setGiaThucAn(double giaThucAn) {
    this.giaThucAn = giaThucAn;
  }
  public void setmaThucAn(int maThucAn) {
    this.maThucAn = maThucAn;
  }
  public void setsoLuong(int soLuong){
    this.soLuong = soLuong;
  }

  public String getTenThucAn() {
    return tenThucAn;
  }
  public double getGiaThucAn() {
    return giaThucAn;
  }
  public int getmaThucAn() {
    return maThucAn;
  }
  public int getsoLuong(){
    return soLuong;
  }

  public void nhap() {
    Scanner scanner = new Scanner(System.in);
    
    System.out.print("Nhap ten thuc an: ");
    tenThucAn =  scanner.nextLine();
    System.out.print("Nhap ma thuc an: ");
    maThucAn = scanner.nextInt();
    System.out.print("Nhap gia thuc an: ");
    giaThucAn = scanner.nextDouble();
    System.out.println("Nhap so luong: ");
    soLuong = scanner.nextInt();
  }
  public void xuat() {
    System.out.println("Mon " + tenThucAn + ", ma thuc an: " + maThucAn);
    System.out.println("- Gia 1 mon: " + giaThucAn);
    System.out.println("So Luong mon: " + soLuong);
  }

  abstract void dungNguyenLieu(KhoNguyenLieu n);
}
