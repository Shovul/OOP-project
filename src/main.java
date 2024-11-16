// package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

public class main {
  static int n = 0;
  static boolean flag = true;
  static Scanner sc = new Scanner(System.in);
  static DSNhanVien danhsachNhanVien = new DSNhanVien();
  static DSMon danhsachMon = new DSMon();
  static KhoNguyenLieu khoNguyenLieu = new KhoNguyenLieu();
  static DSHoaDon danhsachHoaDon = new DSHoaDon();
  static DSKH danhsachKhachHang = new DSKH();
  static BufferedReader input;
  static int ngay;
  static HashMap<Integer, Double> doanhThu = new HashMap<>();
  static double sumOfTheMonth = 0;

  
  public static void quanLyNhanVien() {
    String infile = "dsnv.txt";
    String outfile = "";
    do {
      System.out.println("-- Quan ly nhan vien --");
      System.out.println("1. Xuat danh sach nhan vien ra man hinh");
      System.out.println("2. Tim kiem nhan vien");
      System.out.println("3. Them nhan vien");
      System.out.println("4. Xoa nhan vien");
      System.out.println("5. Sua nhan vien");
      System.out.println("6. Tìm nhân viên nghỉ >= ");
      System.out.println("7. Nhap danh sach nhan vien tu file");
      System.out.println("8. Xuat danh sach nhan vien ra file");
      System.out.println("9. Cap nhat danh sach nhan vien");
      System.out.println("10. Thoat quan ly nhan vien");
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
        case 6:
          System.out.println("Nhập số ngày nghỉ muốn kiểm tra: ");
          danhsachNhanVien.xemNhanVienNghiHon(sc.nextInt());
          break;
        case 7: {
          System.out.println("Nhap file chua thong tin nhan vien");
          infile = sc.nextLine();
          infile = sc.nextLine();
          danhsachNhanVien.addByFile(infile);
          break;
        }
        case 8: {
          System.out.println("Nhap file de in cac thong tin nhan vien");
          outfile = sc.nextLine();
          outfile = sc.nextLine();
          danhsachNhanVien.printListInFile(outfile);
          break;
        }
        case 9: {
          if(infile.equals("")) {
            System.out.println("!Chua nhap file input!");
            break;
          }
          System.out.println("Da cap nhap file thong tin nhan vien");
          danhsachNhanVien.printListInFile(infile);
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
  public static void quanLyMonAn() {
    String infile = "menu.txt";
    String outfile = "";
    do {
      System.out.println("-- Quan ly menu quan --");
      System.out.println("1. Xuat thong tin mon ra man hinh");
      System.out.println("2. Xuat menu ra man hinh");
      System.out.println("3. Tim kiem mon");
      System.out.println("4. Them mon");
      System.out.println("5. Xoa mon");
      System.out.println("6. Sua mon");
      System.out.println("7. Nhap danh sach menu tu file");
      System.out.println("8. Xuat danh sach menu ra file");
      System.out.println("9. Cap nhat danh sach menu");
      System.out.println("10. Thoat quan ly menu");
      n = sc.nextInt();
      switch (n) {
        case 1:
          danhsachMon.xuat();
          break;
        case 2:
          danhsachMon.xuatNgan();
          break;
        case 3:
          danhsachMon.timkiem();
          break;
        case 4:
          danhsachMon.them();
          break;
        case 5:
          danhsachMon.xoa();
          break;
        case 6:
          danhsachMon.sua();
          break;
        case 7: {
          System.out.println("Nhap file chua thong tin mon");
          infile = sc.nextLine();
          infile = sc.nextLine();
          danhsachMon.addByFile(infile);
          break;
        }
        case 8: {
          System.out.println("Nhap file de in cac thong tin mon");
          outfile = sc.nextLine();
          outfile = sc.nextLine();
          danhsachMon.printListInFile(outfile);
          break;
        }
        case 9: {
          if(infile.equals("")) {
            System.out.println("!Chua nhap file input!");
            break;
          }
          System.out.println("Da cap nhap file thong tin mon");
          danhsachMon.printListInFile(infile);
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
  public static void quanLyKhachHang() {
    String infile = "dskh.txt";
    String outfile = "";
    do {
      System.out.println("-- Quan ly Khach hang --");
      System.out.println("1. Xuat danh sach khach hang ra man hinh");
      System.out.println("2. Tim kiem khach hang");
      System.out.println("3. Them khach hang");
      System.out.println("4. Xoa khach hang");
      System.out.println("5. Sua thong tin khach hang");
      System.out.println("6. Nhap danh sach Khach hang tu file");
      System.out.println("7. Xuat danh sach Khach hang ra file");
      System.out.println("8. Cap nhat danh sach Khach hang");
      System.out.println("9. Thoat quan ly khach hang");
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
          System.out.println("Nhap ten file chua thong tin khach hang ");
          System.out.println("Vi du: dskh.txt ");
          infile = sc.nextLine();
          infile = sc.nextLine();
          danhsachKhachHang.Readfile(infile);
          break;
        }
        case 7: {
          System.out.println("Nhap ten file se in cac thong tin khach hang");
          System.out.println("Vi du: danhsachkhachhang.txt ");
          outfile = sc.nextLine();
          outfile = sc.nextLine();
          danhsachKhachHang.Writefile(outfile);
          break;
        }
        case 8: {
          if(infile.equals("")) {
            System.out.println("!Chua nhap file input!");
            break;
          }
          System.out.println("Da cap nhap file thong tin khach hang");
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
    String infile = "kho.txt";
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
    
    String infile = "donhang.txt";
    String outfile = "";
    do {
      System.out.println("-- Quan ly hoa don --");
      System.out.println("1. Xuat hoa don ra man hinh");
      System.out.println("2. Tim kiem hoa don");
      System.out.println("3. Them hoa don");
      System.out.println("4. Xoa hoa don");
      System.out.println("5. Sua hoa don");
      System.out.println("6. Nhap danh sach hoa don tu file");
      System.out.println("7. Xuat danh sach hoa don ra file");
      System.out.println("8. Cap nhat danh sach hoa don");
      System.out.println("9. Thoat quan ly hoa don");
      n = sc.nextInt();
      switch (n) {
        case 1:
          danhsachHoaDon.xuat();
          break;
        case 2:
          danhsachHoaDon.timkiem();
          break;
        case 3:
          danhsachHoaDon.them();
          break;
        case 4:
          danhsachHoaDon.xoa();
          break;
        case 5:
          danhsachHoaDon.sua();
          break;
        case 6: {
          System.out.println("Nhap file chua thong tin mon");
          infile = sc.nextLine();
          infile = sc.nextLine();
          danhsachHoaDon.addByFile(infile);
          break;
        }
        case 7: {
          System.out.println("Nhap file de in cac thong tin mon");
          outfile = sc.nextLine();
          outfile = sc.nextLine();
          danhsachHoaDon.printListInFile(outfile);
          break;
        }
        case 8: {
          if(infile.equals("")) {
            System.out.println("!Chua nhap file input!");
            break;
          }
          System.out.println("Da cap nhap file thong tin mon");
          danhsachHoaDon.printListInFile(infile);
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
  public static void main(String[] args) {
    try { 
      input = new BufferedReader(new FileReader("quanly.txt"));
      ngay = Integer.parseInt(input.readLine());
      String doanhThuNgay;
      String lines[];
      for(int i=0; i<ngay; i++) {
        doanhThuNgay = input.readLine();
        lines = doanhThuNgay.split(" ");
        doanhThu.put(Integer.parseInt(lines[0]), Double.parseDouble(lines[1]));
      }
      input.close();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }

    danhsachNhanVien.addByFile("dsnv.txt");
    khoNguyenLieu.addByFile("kho.txt");
    danhsachMon.addByFile("menu.txt");
    danhsachHoaDon.addByFile("hoadon.txt");
    danhsachKhachHang.Readfile("dskh.txt");
    do {
      ngay += 1;
      // System.out.print("\033[H\033[2J");  
      System.out.println("Ngay: " + ngay);
      System.out.println("-- Chon de quan ly --");
      System.out.println("1. Danh sach nhan vien");
      System.out.println("2. Danh sach mon an");
      System.out.println("3. Danh sach khach hang");
      System.out.println("4. Kho nguyen lieu");
      System.out.println("5. Danh sach don hang");
      System.out.println("6. Danh dau nhan vien nghi hom nay");
      System.out.println("7. In doanh thu ngay hom nay");
      System.out.println("8. In doanh thu thang nay");
      System.out.println("9. Ket thuc ngay");
      System.out.println("10. Thoat chuong trinh");
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
          System.out.print("Nhap ten nhan vien nghi: ");
          sc.nextLine();
          
          break;
        }
        case 7: {
          System.out.println("Doanh thu ngay hom nay:  " + danhsachHoaDon.tinhTong());
          break;
        }
        case 8: {
          if(ngay < 30) {
            System.out.println("Chua du 1 thang de tinh");
            break;
          }
          doanhThu.forEach((ngay, soLuong) -> {
            try {
              sumOfTheMonth += soLuong;
            }
            catch(Exception e) {
              e.printStackTrace();
            }
          });
          System.out.println("Doanh thu thang nay: " + sumOfTheMonth);
        }
        case 9: {
          try {
            FileWriter output = new FileWriter("quanly.txt");
            output.write(Integer.toString(ngay));
            doanhThu.forEach((ngay, soTien) -> {
              try {
                output.write(Integer.toString(ngay) + "/" + Double.toHexString(soTien));
              }
              catch(Exception e) {
                e.printStackTrace();
              }
            });
            output.write(Integer.toString(ngay) + "/" + danhsachHoaDon.tinhTong());
            flag = false;
            output.close();
            break;
          }
          catch(Exception ex) {
            System.out.println(ex);
          }
        }
        case 10: {
          flag = false;
          break;
        }
      }
    }while(flag);
  }
}