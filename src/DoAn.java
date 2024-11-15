// package Restaurant;

import java.util.Arrays;
import java.util.Scanner;

public class DoAn extends Mon {
  NguyenLieu[] nguyenlieuLam;
  int soNguyenLieu;
  
  public DoAn(int maThucAn, String tenThucAn, double giaThucAn, NguyenLieu[] nlLam, int soNguyenLieu) {
    super(maThucAn, tenThucAn, giaThucAn);
    nguyenlieuLam = nlLam;
    this.soNguyenLieu = soNguyenLieu;
  }
  public DoAn() {
    super();
    nguyenlieuLam = new NguyenLieu[0];
    soNguyenLieu = 0;
  }
  public DoAn(int maThucAn, String tenThucAn, double giaThucAn, int soNguyenLieu) {
    super();
    this.soNguyenLieu = soNguyenLieu;
    nguyenlieuLam = new NguyenLieu[soNguyenLieu];
  }
  
  public void setNguyenLieuLam(int i, String ten, int soLuong) {
      nguyenlieuLam[i] =new NguyenLieu();
      nguyenlieuLam[i].setTen(ten);
      nguyenlieuLam[i].setSoLuong(soLuong);
  }
  public void setNguyenLieuLam(int soLuongNguyenLieu, NguyenLieu[] nguyenlieu) {
    soNguyenLieu = soLuongNguyenLieu;
    nguyenlieuLam = nguyenlieu;
  }
  public void setSoNguyenLieu(int soLuongNguyenLieu) {
    soNguyenLieu = soLuongNguyenLieu;
    nguyenlieuLam = new NguyenLieu[soNguyenLieu];
  }
  public NguyenLieu[] getNguyenLieu() {
    return nguyenlieuLam;
  }
  public int getSoNguyenLieu() {
    return soNguyenLieu;
  }

  public void xuat() {
    super.xuat();
    for(int i=0; i<soNguyenLieu; i++) {
      nguyenlieuLam[i].xuat();
    }
  }
  public void nhap() {
    super.nhap();
    Scanner scanner = new Scanner(System.in);
    System.out.print("Nhap so thanh phan cua " + tenThucAn + ": ");
    soNguyenLieu = scanner.nextInt();
    nguyenlieuLam = new NguyenLieu[soNguyenLieu];
    for(int i=0; i<soNguyenLieu; i++) {
      nguyenlieuLam[i] = new NguyenLieu();
      nguyenlieuLam[i].nhap();
    }
  }

  public void dungNguyenLieu(KhoNguyenLieu kho) {
    boolean available = true;
    for(int i=0; i<soNguyenLieu; i++) {
      if(!kho.coNguyenLieu(nguyenlieuLam[i])) {
        available = false;
        break;
      }
    }
    if(available) {
      for(int i=0; i<soNguyenLieu; i++) {
        kho.giamNguyenLieu(nguyenlieuLam[i]);
      }
    }
  }
}
