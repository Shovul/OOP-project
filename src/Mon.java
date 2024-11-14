// package Restaurant;

import java.util.Scanner;

public abstract class Mon {
  int maThucAn;
  String tenThucAn;
  double giaThucAn;
  
  public Mon(int maThucAn, String tenThucAn, double giaThucAn) {
    this.giaThucAn = giaThucAn;
    this.tenThucAn = tenThucAn;
    this.maThucAn = maThucAn;
  }
  public Mon() {
    this.giaThucAn = 0;
    this.tenThucAn = "";
    this.maThucAn = 0;
  }

  public void setTenThucAn(String tenThucAn) {
    this.tenThucAn = tenThucAn;
  }
  public void setGiaThucAn(double giaThucAn) {
    this.giaThucAn = giaThucAn;
  }
  public void setMaThucAn(int maThucAn) {
    this.maThucAn = maThucAn;
  }

  public String getTenThucAn() {
    return tenThucAn;
  }
  public double getGiaThucAn() {
    return giaThucAn;
  }
  public int getMaThucAn() {
    return maThucAn;
  }

  public void nhap() {
    Scanner scanner = new Scanner(System.in);
    
    System.out.print("Nhap ten mon: ");
    tenThucAn =  scanner.nextLine();
    System.out.print("Nhap ma mon: ");
    maThucAn = scanner.nextInt();
    System.out.print("Nhap gia mon: ");
    giaThucAn = scanner.nextDouble();
  }
  public void xuat() {
    System.out.println("Mon " + tenThucAn + ", ma thuc an: " + maThucAn);
    System.out.println("- Gia 1 mon: " + giaThucAn);
  }

  abstract void dungNguyenLieu(KhoNguyenLieu n);
}
