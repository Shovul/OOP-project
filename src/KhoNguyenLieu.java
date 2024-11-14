// package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
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
    System.out.print("Nhap ten nguyen lieu muon xoa: ");
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
        sc.nextLine();
        kho[i].setTen(sc.nextLine());
        break;
      case 2:
        kho[i].setSoLuong(sc.nextInt());
        break;
      case 3:
        kho[i].themSoLuong(sc.nextInt());
        break;
      case 4:
        kho[i].nhap();
        break;
    
      default:
        quanLySua(i);
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
    Scanner sc = new Scanner(System.in);
    boolean flag = false;
    System.out.print("Nhap ten nguyen lieu can tim: ");
    String s = sc.nextLine();
    for(int i=0; i<length; i++) {
      if(kho[i].ten.equals(s)) {
        kho[i].xuat();
        flag = true;
        break;
      }
    }
    if(!flag) {
      System.out.println("Khong tin thay nguyen lieu");
    }
  }
  public void xuat() {
    for(int i=0; i<length; i++) {
      kho[i].xuat();
    }
  }
  
  public void addByFile(String filePath) {
    try {
      BufferedReader file = new BufferedReader(new FileReader(filePath));
      String line = file.readLine();
      while(line != null) {
        String[] arrayLine = line.split("/");
        kho = Arrays.copyOf(kho, length+1);
        kho[length] = new NguyenLieu();
        kho[length].setTen(arrayLine[0]);
        kho[length].setSoLuong(Integer.parseInt(arrayLine[1]));
        line = file.readLine();
        length++;
      }
      file.close();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public void printListInFile(String filePath) {
    try{
      FileWriter file = new FileWriter(filePath);
      for(int i=0; i<length; i++) {
        file.write(kho[i].getTen()+"/"+kho[i].getSoLuong()+"\n");
      }
      file.close();
    }
    catch(Exception e) {
      System.out.println(e);
    }
  }

  public void kiemTraSoLuongNguyenLieu(int n) {
    for(int i=0; i<length; i++) {
      if(kho[i].soLuong <= n) {
        kho[i].xuat();
      }
    }
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
