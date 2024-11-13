// package src;

import java.util.Arrays;
import java.util.HashMap;

public class KhoNguyenLieu {
  protected NguyenLieu[] kho;
  protected int length;

  public KhoNguyenLieu() {
    kho = new NguyenLieu[0];
    length = 0;
  }
  public KhoNguyenLieu(int length, NguyenLieu[] kho) {
    this.length = length;
    kho = kho;
  }
  public KhoNguyenLieu(int length) {
    this.length = length;
    kho = new NguyenLieu[length];
  }

  public void them() {
    kho = Arrays.copyOf(kho, length+1);
    kho[length] = new NguyenLieu();
    kho[length].nhap();
    length++;
  }

  public void giamNguyenLieu(NguyenLieu n) {
    for(int i=0; i<length; i++) {
      if(kho[i].ten.equals(n.ten)) {
        kho[i].soLuong -= n.soLuong;
      }
    }
  }

  public boolean coNguyenLieu(NguyenLieu n) {
    for(int i=0; i<length; i++) {
      if(kho[i].ten.equals(n.ten)) {
        if(kho[i].soLuong > 0) {
          return true;
        }
        else {
          return false;
        }
      }
    }
    return false;
  }
}
