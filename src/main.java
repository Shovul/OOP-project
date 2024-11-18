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
      System.out.println("9. Thoat quan ly nhan vien");
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
    DSMon danhsachMon = new DSMon();
    String infile = "";
    String outfile = "";
    do {
      System.out.println("-- Quan ly menu quan --");
      System.out.println("1. Xuat menu ra man hinh");
      System.out.println("2. Tim kiem mon");
      System.out.println("3. Them mon");
      System.out.println("4. Xoa mon");
      System.out.println("5. Sua mon");
      System.out.println("6. Nhap danh sach menu tu file");
      System.out.println("7. Xuat danh sach menu ra file");
      System.out.println("8. Cap nhat danh sach menu");
      System.out.println("9. Thoat quan ly menu");
      n = sc.nextInt();
      switch (n) {
        case 1:
          danhsachMon.xuat();
          break;
        case 2:
          danhsachMon.timkiem();
          break;
        case 3:
          danhsachMon.them();
          break;
        case 4:
          danhsachMon.xoa();
          break;
        case 5:
          danhsachMon.sua();
          break;
        case 6: {
          System.out.println("Nhap file chua thong tin mon");
          infile = sc.nextLine();
          infile = sc.nextLine();
          danhsachMon.addByFile(infile);
          break;
        }
        case 7: {
          System.out.println("Nhap file de in cac thong tin mon");
          outfile = sc.nextLine();
          outfile = sc.nextLine();
          danhsachMon.printListInFile(outfile);
          break;
        }
        case 8: {
          if(infile.equals("")) {
            System.out.println("!Chua nhap file input!");
            break;
          }
          System.out.println("Da cap nhap file thong tin mon");
          danhsachMon.printListInFile(infile);
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
  public static void quanLyKhachHang() 
  {
    DSKH danhsachKhachHang = new DSKH();
    String infile = "";
    String outfile = "";
    do {
      System.out.println("-- Quản lý khách hàng --");
      System.out.println("1. Xuất danh sách khách hàng ra màn hình");
      System.out.println("2. Tìm kiếm khách hàng");
      System.out.println("3. Thêm khách hàng");
      System.out.println("4. Xóa khách hàng");
      System.out.println("5. Sửa thông tin của khách hàng");
      System.out.println("6. Nhập danh sách khách hàng từ file");
      System.out.println("7. Xuất danh sách khách hàng ra file");
      System.out.println("8. Cập nhật danh sách khách hàng");
      System.out.println("9. Thoát quản lý khách hàng");
      n = sc.nextInt();
      switch (n) {
        case 1:
          danhsachKhachHang.xuat();
          break;
        case 2:
          danhsachKhachHang.timkiem();
          break;
        case 3:
          danhsachKhachHang.them();
          break;
        case 4:
          danhsachKhachHang.xoa();
          break;
        case 5:
          danhsachKhachHang.sua();
          break;
        case 6: {
          System.out.println("Nhập tên file chứa thông tin khách hàng ");
          System.out.println("Ví dụ: dskh.txt ");
          infile = sc.nextLine();
          infile = sc.nextLine();
          danhsachKhachHang.Readfile(infile);
          break;
        }
        case 7: {
          System.out.println("Nhập tên file sẽ in ra danh sách khách hàng");
          System.out.println("Ví dụ: danhsachkhachhang.txt ");
          outfile = sc.nextLine();
          outfile = sc.nextLine();
          danhsachKhachHang.Writefile(outfile);
          break;
        }
        case 8: {
          if(infile.equals("")) {
            System.out.println("!Chưa nhập file input!");
            break;
          }
          System.out.println("Đã cập nhật file thông tin khách hàng");
          danhsachKhachHang.Writefile(infile);
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
  public static void quanLyNguyenLieu() {
    KhoNguyenLieu khoNguyenLieu = new KhoNguyenLieu();
    String infile = "";
    String outfile = "";
    do {
      System.out.println("-- Quan ly kho nguyen lieu --");
      System.out.println("1. Xuat kho nguyen lieu ra man hinh");
      System.out.println("2. Tim kiem nguyen lieu");
      System.out.println("3. Them nguyen lieu");
      System.out.println("4. Xoa nguyen lieu");
      System.out.println("5. Sua nguyen lieu");
      System.out.println("6. Nhap danh sach kho nguyen lieu tu file");
      System.out.println("7. Xuat danh sach kho nguyen lieu ra file");
      System.out.println("8. Cap nhat danh sach kho nguyen lieu");
      System.out.println("9. Kiem tra so luong nguyen lieu");
      System.out.println("10. Thoat quan ly kho nguyen lieu");
      n = sc.nextInt();
      switch (n) {
        case 1:
          khoNguyenLieu.xuat();
          break;
        case 2:
          khoNguyenLieu.timkiem();
          break;
        case 3:
          khoNguyenLieu.them();
          break;
        case 4:
          khoNguyenLieu.xoa();
          break;
        case 5:
          khoNguyenLieu.sua();
          break;
        case 6: {
          System.out.println("Nhap file chua thong tin mon");
          infile = sc.nextLine();
          infile = sc.nextLine();
          khoNguyenLieu.addByFile(infile);
          break;
        }
        case 7: {
          System.out.println("Nhap file de in cac thong tin mon");
          outfile = sc.nextLine();
          outfile = sc.nextLine();
          khoNguyenLieu.printListInFile(outfile);
          break;
        }
        case 8: {
          if(infile.equals("")) {
            System.out.println("!Chua nhap file input!");
            break;
          }
          System.out.println("Da cap nhap file thong tin mon");
          khoNguyenLieu.printListInFile(infile);
          break;
        }
        case 9: {
          System.out.print("Kiem tra so luong nguyen lieu <= ");
          khoNguyenLieu.kiemTraSoLuongNguyenLieu(sc.nextInt());
          break;
        }
        case 10: {
          flag = false;
          break;
        }
      }
    }while(flag);
    
    flag = true;
  }
  public static void quanLyDonHang() {
    
  }
  public static void main(String[] args) {
    do {
      // System.out.print("\033[H\033[2J");  
      System.out.println("Chon de quan ly");
      System.out.println("1. Danh sach nhan vien");
      System.out.println("2. Danh sach mon an");
      System.out.println("3. Danh sach khách hàng");
      System.out.println("4. Kzho nguyen lieu");
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