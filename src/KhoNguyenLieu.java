// package src;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class KhoNguyenLieu implements iDanhSach{
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
  public void xoa() {
    Scanner sc = new Scanner(System.in);
    String ten = sc.nextLine();
    for(int i=0; i<length; i++) {
      if(kho[i].ten.equals(ten)) {
        for(int j=i; j<length-1; j++) {
          kho[j] = kho[j+1];
        }
      }
    }
    kho = Arrays.copyOf(kho, length--);
  }
  private void quanLySua(int i) {
    System.out.println("1. Sua ten nguyen lieu");
    System.out.println("2. Sua so luong nguyen lieu");
    System.out.println("3. Them so luong nguyen lieu");
    System.out.println("4. Sua toan bo nguyen lieu");
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    switch (n) {
      case 1:
        kho[i].set
        break;
      case 2:
        
        break;
      case 3:
        
        break;
      case 4:
        
        break;
    
      default:
        break;
    }
  } 
  public void sua() {
    System.out.print("Nhap ten nguyen lieu muon sua: ");
    Scanner sc = new Scanner(System.in);

    boolean flag = false;
    String ten = sc.nextLine();
    for(int i=0; i<length; i++) {
      if(kho[i].ten.equals(ten)) {
        quanLySua(i);
        flag = true;
        break;
      }
    }
    if(!flag) {
      System.out.println("Kho tim thay nguyen lieu");
    } 
  }
  public void timkiem() {
    
  }
  public void xuat() {

  }

  public void giamNguyenLieu(NguyenLieu n) {
    for(int i=0; i<length; i++) {
      if(kho[i].ten.equals(n.ten)) {
        kho[i].soLuong -= n.soLuong;
      }
    }
  }
  public void giamNguyenLieu(NguyenLieu n, char size) {
    for(int i=0; i<length; i++) {
      if(kho[i].ten.equals(n.ten)) {
        if(size == 's') {
          kho[i].soLuong -= n.soLuong;
        }
        else if(size == 'm') {
          kho[i].soLuong -= n.soLuong*2;
        }
        else {
          kho[i].soLuong -= n.soLuong*3;
        }
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
