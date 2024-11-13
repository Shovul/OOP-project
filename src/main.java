// package src;

import java.util.Scanner;

public class main {
  static int n = 0;
  static boolean flag = true;
  static Scanner sc = new Scanner(System.in);

  public static void quanLyNhanVien() {
    DSNhanVien danhsachNhanVien = new DSNhanVien();
    String infile = "";
    String outfile = "";
    do {
      System.out.println("-- Quan ly nhan vien --");
      System.out.println("1. Xuat danh sach nhan vien ra man hinh");
      System.out.println("2. Tim kiem nhan vien");
      System.out.println("3. Them nhan vien");
      System.out.println("4. Xoa nhan vien");
      System.out.println("5. Sua nhan vien");
      System.out.println("6. Nhap danh sach nhan vien tu file");
      System.out.println("7. Xuat danh sach nhan vien ra file");
      System.out.println("8. Cap nhat danh sach nhan vien");
      System.out.println("9. Thoat quan ly");
      n = sc.nextInt();
      switch (n) {
        case 1:
          danhsachNhanVien.xuat();
          break;
        case 2:
          danhsachNhanVien.timkiem();
          break;
        case 3:
          danhsachNhanVien.them();
          break;
        case 4:
          danhsachNhanVien.xoa();
          break;
        case 5:
          danhsachNhanVien.sua();
          break;
        case 6: {
          System.out.println("Nhap file chua thong tin nhan vien");
          infile = sc.nextLine();
          infile = sc.nextLine();
          danhsachNhanVien.addByFile(infile);
          break;
        }
        case 7: {
          System.out.println("Nhap file de in cac thong tin nhan vien");
          outfile = sc.nextLine();
          outfile = sc.nextLine();
          danhsachNhanVien.printListInFile(outfile);
          break;
        }
        case 8: {
          if(infile.equals("")) {
            System.out.println("!Chua nhap file input!");
            break;
          }
          System.out.println("Da cap nhap file thong tin nhan vien");
          danhsachNhanVien.printListInFile(infile);
          break;
        }
        case 9: {
          flag = false;
          break;
        }
      }
    }while(flag);
    
    flag = true;
  }
  public static void quanLyMonAn() {
    
  }
  public static void quanLyKhachHang() {
    
  }
  public static void quanLyNguyenLieu() {
    
  }
  public static void quanLyDonHang() {
    
  }
  public static void main(String[] args) {
    do {
      System.out.println("Chon de quan ly");
      System.out.println("1. Danh sach nhan vien");
      System.out.println("2. Danh sach mon an");
      System.out.println("3. Danh sach khach hang");
      System.out.println("4. Kho nguyen lieu");
      System.out.println("5. Danh sach don hang");
      System.out.println("6. Thoat chuong trinh");
      n = sc.nextInt();
      switch (n) {
        case 1:
          quanLyNhanVien();
          break;
        case 2:
          quanLyMonAn();
          break;
        case 3:
          quanLyKhachHang();
          break;
        case 4:
          quanLyNguyenLieu();
          break;
        case 5:
          quanLyDonHang();
          break;
        case 6: {
          flag = false;
          break;
        }
      }
    }while(flag);
  }
}