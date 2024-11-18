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
  static DSBAN danhsachBan = new DSBAN();
  static BufferedReader input;
  static int ngay;
  static HashMap<Integer, Double> doanhThu = new HashMap<>();
  static double sumOfTheMonth = 0;
  static String hoadonHomNay;

  
  public static void quanlyNhanVien() {
    String infile = "dsnv.txt";
    String outfile = "";
    do {
      System.out.println("-- Quản lý nhân viên --");
      System.out.println("1. Xuất danh sách nhân viên ra màn hình");
      System.out.println("2. Tìm kiếm nhân viên");
      System.out.println("3. Thêm nhân viên");
      System.out.println("4. Xóa nhân viên");
      System.out.println("5. Sửa nhân viên");
      System.out.println("6. Tìm nhân viên nghỉ >= ");
      System.out.println("7. Nhập danh sách nhân viên từ file");
      System.out.println("8. Xuất danh sách nhân viên ra file");
      System.out.println("9. Cập nhật danh sách nhân viên");
      System.out.println("10. Thoát quản lý nhân viên");
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
          System.out.println("Nhập file chứa thông tin nhân viên");
          infile = sc.nextLine();
          infile = sc.nextLine();
          danhsachNhanVien.addByFile(infile);
          break;
        }
        case 8: {
          System.out.println("Nhập file để in các thông tin nhân viên");
          outfile = sc.nextLine();
          outfile = sc.nextLine();
          danhsachNhanVien.printListInFile(outfile);
          break;
        }
        case 9: {
          if(infile.equals("")) {
            System.out.println("!Chưa nhập file input!");
            break;
          }
          System.out.println("Đã cập nhật file thông tin nhân viên");
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
  public static void quanlyMonAn() {
    String infile = "menu.txt";
    String outfile = "";
    do {
      System.out.println("-- Quản lý menu quán --");
      System.out.println("1. Xuất thông tin món ra màn hình");
      System.out.println("2. Xuất menu ra màn hình");
      System.out.println("3. Tìm kiếm món");
      System.out.println("4. Thêm món");
      System.out.println("5. Xóa món");
      System.out.println("6. Sửa món");
      System.out.println("7. Nhập danh sách menu từ file");
      System.out.println("8. Xuất danh sách menu ra file");
      System.out.println("9. Cập nhật danh sách menu");
      System.out.println("10. Thoát quản lý menu");
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
          System.out.println("Nhập file chưa thông tin món");
          infile = sc.nextLine();
          infile = sc.nextLine();
          danhsachMon.addByFile(infile);
          break;
        }
        case 8: {
          System.out.println("Nhập file để in các thông tin món");
          outfile = sc.nextLine();
          outfile = sc.nextLine();
          danhsachMon.printListInFile(outfile);
          break;
        }
        case 9: {
          if(infile.equals("")) {
            System.out.println("!Chưa nhập file input!");
            break;
          }
          System.out.println("Đã cập nhật file thông tin món");
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
  public static void quanlyKhachHang() {
    String infile = "dskh.txt";
    String outfile = "";
    do {
      System.out.println("-- Quản lý khách hàng --");
      System.out.println("1. Xuất danh sách khách hàng ra màn hình");
      System.out.println("2. Tìm kiếm khách hàng");
      System.out.println("3. Thêm khách hàng");
      System.out.println("4. Xóa khách hàng");
      System.out.println("5. Sửa thông tin khách hàng");
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
          danhsachKhachHang.xuat();
          break;
        case 5:
          danhsachKhachHang.sua();
          break;
        case 6: {
          System.out.println("Nhập tên file chưa thông tin khách hàng ");
          System.out.println("Vi du: dskh.txt ");
          infile = sc.nextLine();
          infile = sc.nextLine();
          danhsachKhachHang.Readfile(infile);
          break;
        }
        case 7: {
          System.out.println("Nhập tên file sẽ in các thông tin khách hàng");
          System.out.println("Vi du: danhsachkhachhang.txt ");
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
  public static void quanlyNguyenLieu() {
    String infile = "kho.txt";
    String outfile = "";
    do {
      System.out.println("-- Quản lý kho nguyên liệu --");
      System.out.println("1. Xuất kho nguyên liệu ra màn hình");
      System.out.println("2. Tìm kiếm nguyên liệu");
      System.out.println("3. Thêm nguyên liệu");
      System.out.println("4. Xóa nguyên liệu");
      System.out.println("5. Sửa nguyên liệu");
      System.out.println("6. Nhập danh sách kho nguyên liệu từ file");
      System.out.println("7. Xuất danh sách kho nguyên liệu ra file");
      System.out.println("8. Cập nhật danh sách kho nguyên liệu");
      System.out.println("9. Kiểm tra số lượng nguyên liệu");
      System.out.println("10. Thoát quản lý kho nguyên liệu");
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
          System.out.println("Nhập file chưa thông tin món");
          infile = sc.nextLine();
          infile = sc.nextLine();
          khoNguyenLieu.addByFile(infile);
          break;
        }
        case 7: {
          System.out.println("Nhập file để in các thông tin món");
          outfile = sc.nextLine();
          outfile = sc.nextLine();
          khoNguyenLieu.printListInFile(outfile);
          break;
        }
        case 8: {
          if(infile.equals("")) {
            System.out.println("!Chưa nhập file input!");
            break;
          }
          System.out.println("Đã cập nhật file thông tin món");
          khoNguyenLieu.printListInFile(infile);
          break;
        }
        case 9: {
          System.out.print("Kiểm tra số lượng nguyên liệu <= ");
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
  public static void quanlyDonHang() {
    
    String infile = hoadonHomNay;
    String outfile = "";
    do {
      System.out.println("-- Quản lý hóa đơn --");
      System.out.println("1. Xuất hóa đơn ra màn hình");
      System.out.println("2. Tìm kiếm hóa đơn");
      System.out.println("3. Thêm hóa đơn");
      System.out.println("4. Xóa hóa đơn");
      System.out.println("5. Sửa hóa đơn");
      System.out.println("6. Nhập danh sách hóa đơn từ file");
      System.out.println("7. Xuất danh sách hóa đơn ra file");
      System.out.println("8. Cập nhật danh sách hóa đơn");
      System.out.println("9. Thoát quản lý hóa đơn");
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
          System.out.println("Nhập file chưa thông tin món");
          infile = sc.nextLine();
          infile = sc.nextLine();
          danhsachHoaDon.addByFile(infile);
          break;
        }
        case 7: {
          System.out.println("Nhập file để in các thông tin món");
          outfile = sc.nextLine();
          outfile = sc.nextLine();
          danhsachHoaDon.printListInFile(outfile);
          break;
        }
        case 8: {
          if(infile.equals("")) {
            System.out.println("!Chưa nhập file input!");
            break;
          }
          System.out.println("Đã cập nhật file thông tin món");
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
  public static void quanlyBan() {
    
    String infile = "ban.txt";
    String outfile = "";
    do {
      System.out.println("-- Quản lý bàn --");
      System.out.println("1. Xuất bàn ra màn hình");
      System.out.println("2. Tìm kiếm bàn");
      System.out.println("3. Thêm bàn");
      System.out.println("4. Xóa bàn");
      System.out.println("5. Sửa bàn");
      System.out.println("6. Nhập danh sách bàn từ file");
      System.out.println("7. Xuất danh sách bàn ra file");
      System.out.println("8. Cập nhật danh sách bàn");
      System.out.println("9. Thoát quản lý bàn");
      n = sc.nextInt();
      switch (n) {
        case 1:
          danhsachBan.xuat();
          break;
        case 2:
          danhsachBan.timkiem();
          break;
        case 3:
          danhsachBan.them();
          break;
        case 4:
          danhsachBan.xoa();
          break;
        case 5:
          danhsachBan.sua();
          break;
        case 6: {
          System.out.println("Nhập file chưa thông tin món");
          infile = sc.nextLine();
          infile = sc.nextLine();
          danhsachBan.addByFile(infile);
          break;
        }
        case 7: {
          System.out.println("Nhập file để in các thông tin món");
          outfile = sc.nextLine();
          outfile = sc.nextLine();
          danhsachBan.printListInFile(outfile);
          break;
        }
        case 8: {
          if(infile.equals("")) {
            System.out.println("!Chưa nhập file input!");
            break;
          }
          System.out.println("Đã cập nhật file thông tin món");
          danhsachBan.printListInFile(infile);
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
          lines = doanhThuNgay.split("/");
        doanhThu.put(Integer.parseInt(lines[0]), Double.parseDouble(lines[1]));
      }
      input.close();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
    

    ngay += 1;
    hoadonHomNay = "donhang" + Integer.toString(ngay) + ".txt";
    try {
      FileWriter file = new FileWriter(hoadonHomNay);
      file.close();
    }
    catch(Exception e) {
      e.printStackTrace();
    }

    do {
      danhsachNhanVien = new DSNhanVien();
      danhsachMon = new DSMon();
      khoNguyenLieu = new KhoNguyenLieu();
      danhsachHoaDon = new DSHoaDon();
      danhsachKhachHang = new DSKH();
      DSBAN danhsachBan = new DSBAN();
      danhsachNhanVien.addByFile("dsnv.txt");
      khoNguyenLieu.addByFile("kho.txt");
      danhsachMon.addByFile("menu.txt");
      danhsachHoaDon.addByFile(hoadonHomNay);
      danhsachKhachHang.Readfile("dskh.txt");
      danhsachBan.addByFile("ban.txt");
      // System.out.print("\033[H\033[2J");  
      System.out.println("Ngay: " + ngay);
      System.out.println("-- Chọn để quản lý --");
      System.out.println("1. Danh sách nhân viên");
      System.out.println("2. Danh sách món ăn");
      System.out.println("3. Danh sách khách hàng");
      System.out.println("4. Kho nguyên liệu");
      System.out.println("5. Danh sách đơn hàng");
      System.out.println("6. Danh sách bàn");
      System.out.println("7. Đánh dấu nhân viên nghỉ hôm nay");
      System.out.println("8. Đánh dấu nhân viên làm việc hôm nay");
      System.out.println("9. Đánh dấu bàn đã được trống");
      System.out.println("10. In doanh thu ngày hôm nay");
      System.out.println("11. In doanh thu tháng nay");
      System.out.println("12. Kết thúc ngày");
      System.out.println("13. Thoát chương trình");
      n = sc.nextInt();
      switch (n) {
        case 1:
          quanlyNhanVien();
          break;
        case 2:
          quanlyMonAn();
          break;
        case 3:
          quanlyKhachHang();
          break;
        case 4:
          quanlyNguyenLieu();
          break;
        case 5:
          quanlyDonHang();
          break;
        case 6:
          quanlyBan();
          break;
        case 7: {
          System.out.print("Nhập tên nhân viên nghỉ: ");
          sc.nextLine();
          danhsachNhanVien.danhDauNghi(sc.nextLine());
          danhsachNhanVien.printListInFile("dsnv.txt");
          
          break;
        }
        case 8: {
          System.out.print("Nhập tên nhân viên làm việc: ");
          sc.nextLine();
          danhsachNhanVien.danhDauLam(sc.nextLine());
          danhsachNhanVien.printListInFile("dsnv.txt");
          
          break;
        }
        case 9: {
          System.out.print("Nhập mã bàn đã được trống: ");
          int ban = sc.nextInt();
          danhsachBan.setBanTrong(ban);
          danhsachBan.printListInFile("ban.txt");
          
          break;
        }
        case 10: {
          System.out.println("Doanh thu ngày hôm nay:  " + danhsachHoaDon.tinhTong());
          break;
        }
        case 11: {
          if(ngay < 30) {
            System.out.println("Chưa đủ 1 tháng để tính doanh thu");
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
          System.out.println("Doanh thu tháng nay: " + (sumOfTheMonth - danhsachNhanVien.tinhLuongNhanVien()));
        }
        case 12: {
          try {
            FileWriter output = new FileWriter("quanly.txt");
            output.write(Integer.toString(ngay) + "\n");
            doanhThu.forEach((ngay, soTien) -> {
              try {
                output.write(Integer.toString(ngay) + "/" + Double.toString(soTien) + "\n");
              }
              catch(Exception e) {
                e.printStackTrace();
              }
            });
            output.write(Integer.toString(ngay) + "/" + danhsachHoaDon.tinhTong() + "\n");
            flag = false;
            output.close();
            break;
          }
          catch(Exception ex) {
            System.out.println(ex);
          }
        }
        case 13: {
          flag = false;
          break;
        }
      }
    }while(flag);
  }
}