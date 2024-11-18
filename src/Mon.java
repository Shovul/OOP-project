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
    
    System.out.print("Nhập tên món: ");
    tenThucAn =  scanner.nextLine();
    System.out.print("Nhập mã món: ");
    maThucAn = scanner.nextInt();
    System.out.print("Nhập giá món: ");
    giaThucAn = scanner.nextDouble();
  }
  public void xuat() {
    System.out.println("Món " + tenThucAn + ", mã thức ăn: " + maThucAn);
    System.out.println("- Giá 1 món: " + giaThucAn + "vnd");
  }

  abstract void dungNguyenLieu(KhoNguyenLieu n);
}
