// package Restaurant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;


public class DSNhanVien implements iDanhSach{
  protected NhanVien[] DSNV;
  protected int length;

  //constructor
  public DSNhanVien() {
    DSNV = new NhanVien[0];
    length = 0;
  }
  public DSNhanVien(int length, NhanVien[] DS) {
    DSNV = DS;
    this.length = length;
  }
  public DSNhanVien(int length) {
    DSNV = new NhanVien[length];
    this.length = length;
  }

  //them nhanh vien
  public void them() {
    DSNV = Arrays.copyOf(DSNV, length+1);
    
    System.out.println("1. Thêm đầu bếp");
    System.out.println("2. Thêm thu ngân");
    System.out.println("3. Thêm bồi bàn");
    System.out.println("Nhập 1, 2 hoặc 3: ");
    Scanner scanner = new Scanner(System.in);
    int choose = scanner.nextInt();
    switch (choose){
      case 1:
        DSNV[length] = new DauBep();
        ((DauBep)DSNV[length]).nhap();
        length++;
        break;
      case 2:
        DSNV[length] = new ThuNgan();
        ((ThuNgan)DSNV[length]).nhap();
        length++;
        break;
      case 3:
        DSNV[length] = new BoiBan();
        ((BoiBan)DSNV[length]).nhap();
        length++;
        break;
    
      default:
        break;
    }
  }

  //xoa nhan vien theo mã nhan vien
  public void xoa() {
    System.out.println("1. Xóa theo mã");
    System.out.println("2. Xóa theo tên");
    Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt();
    String ten;
    switch (n) {
      case 1:
        System.out.print("Nhập mã nhân viên muốn xóa: ");
        n = sc.nextInt();
        xoa(n);
        break;
      case 2:
        System.out.print("Nhập tên nhân viên muốn xóa: ");
        ten = sc.nextLine();
        ten = sc.nextLine();
        xoa(ten);
        break;
    
      default:
        break;
    }
  }
  public void xoa(int maNV) {
    for(int i=0; i<length; i++) {
      if(DSNV[i].maNV == maNV) {
        for(int j=i; j<length-1; j++) {
          DSNV[j] = DSNV[j+1];
        }
        DSNV = Arrays.copyOf(DSNV, length--);
        System.out.println("Đã xóa nhân viên");
        return;
      }
    }
    System.out.println("Không tìm thấy nhân viên mã " + maNV);
}
  public void xoa(String hoTen) {
    for(int i=0; i<length; i++) {
      if(DSNV[i].hoTen.equalsIgnoreCase(hoTen)) {
        for(int j=i; j<length-1; j++) {
          DSNV[j] = DSNV[j+1];
        }
        DSNV = Arrays.copyOf(DSNV, length--);
        System.out.println("Đã xóa nhân viên");
        return;
      }
    }
    System.out.println("Không tìm thấy nhân viên " + hoTen);
  }

  //sua thong tin nhan vien
  public void sua() {
    System.out.println("1. Sửa theo mã");
    System.out.println("2. Sửa theo tên");
    Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt();
    String ten;
    switch (n) {
      case 1:
        System.out.print("Nhập mã nhân viên muốn sửa: ");
        n = sc.nextInt();
        sua(n);
        break;
      case 2:
        System.out.print("Nhập tên nhân viên muốn sửa: ");
        ten = sc.nextLine();
        ten = sc.nextLine();
        sua(ten);
        break;
    
      default:
        break;
    }
  }
  public void sua(int maNV) {
    for(int i=0; i<length; i++) {
      if(DSNV[i].maNV == maNV) {
        if(DSNV[i] instanceof DauBep)
          quanLySuaDauBep(i);
        else if(DSNV[i] instanceof BoiBan)
          quanLySuaBoiBan(i);
        else
          quanLySuaThuNgan(i);
        return;
      }
    }
    System.out.println("Không tìm thấy nhân viên mã " + maNV);
  }
  public void sua(String hoTen) {
    for(int i=0; i<length; i++) {
      if(DSNV[i].hoTen.equals(hoTen)) {
        if(DSNV[i] instanceof DauBep)
          quanLySuaDauBep(i);
        else if(DSNV[i] instanceof BoiBan)
          quanLySuaBoiBan(i);
        else
          quanLySuaThuNgan(i);
        return;
      }
    }
    System.out.println("Không tìm thấy nhân viên " + hoTen);
  }
  private void quanLySuaDauBep(int i) {
    Scanner sc = new Scanner(System.in);
    int n;
    
    System.out.println("Đầu bếp: " + DSNV[i].hoTen);
    System.out.println("1. Sửa mã");
    System.out.println("2. Sửa họ tên");
    System.out.println("3. Sửa lương");
    System.out.println("4. Sửa thành part time");
    System.out.println("5. Sửa thành full time");
    System.out.println("6. Sửa số ngày làm việc");
    System.out.println("7. Sửa số ngày nghỉ");
    System.out.println("8. Thêm thưởng");
    System.out.println("9. Sửa thưởng");
    System.out.println("10. Sửa số lượng món đã nấu");
    System.out.println("11. Sửa tất cả thông tin");
    n = sc.nextInt();
    switch (n) {
      case 1:
        DSNV[i].setMaNV(sc.nextInt());
        break;
      case 2:
        sc.nextLine();
        DSNV[i].setTen(sc.nextLine());
        break;
      case 3:
        DSNV[i].setLuong(sc.nextDouble());
        break;
      case 4:
        DSNV[i].setParttime();
        break;
      case 5:
        DSNV[i].setFulltime();
        break;
      case 6:
        DSNV[i].setNgayLamViec(sc.nextInt());
        break;
      case 7:
        DSNV[i].setNgayNghi(sc.nextInt());
        break;
      case 8:
        DSNV[i].addThuong(sc.nextDouble());
        break;
      case 9:
        DSNV[i].setThuong(sc.nextDouble());
        break;
      case 10:
        ((DauBep)DSNV[i]).setSoLuongMon(sc.nextInt());
        break;
      case 11:
        DSNV[i].nhap();
        break;
    
      default:
        quanLySuaDauBep(i);
        break;
    }
  }
  private void quanLySuaBoiBan(int i) {
    Scanner sc = new Scanner(System.in);
    int n;
    
    System.out.println("Bồi bàn: " + DSNV[i].hoTen);
    System.out.println("1. Sửa mã");
    System.out.println("2. Sửa họ tên");
    System.out.println("3. Sửa lương");
    System.out.println("4. Sửa thành part time");
    System.out.println("5. Sửa thành full time");
    System.out.println("6. Sửa số ngày làm việc");
    System.out.println("7. Sửa số ngày nghỉ");
    System.out.println("8. Thêm thưởng");
    System.out.println("9. Sửa thưởng");
    System.out.println("10. Sửa số lượng bàn phục vụ");
    System.out.println("11. Sửa tất cả thông tin");
    n = sc.nextInt();
    switch (n) {
      case 1:
        DSNV[i].setMaNV(sc.nextInt());
        break;
      case 2:
        sc.nextLine();
        DSNV[i].setTen(sc.nextLine());
        break;
      case 3:
        DSNV[i].setLuong(sc.nextDouble());
        break;
      case 4:
        DSNV[i].setParttime();
        break;
      case 5:
        DSNV[i].setFulltime();
        break;
      case 6:
        DSNV[i].setNgayLamViec(sc.nextInt());
        break;
      case 7:
        DSNV[i].setNgayNghi(sc.nextInt());
        break;
      case 8:
        DSNV[i].addThuong(sc.nextDouble());
        break;
      case 9:
        DSNV[i].setThuong(sc.nextDouble());
        break;
      case 10:
        ((BoiBan)DSNV[i]).setSoBanPhucVu(sc.nextInt());
        break;
      case 11:
        DSNV[i].nhap();
        break;
    
      default:
        quanLySuaBoiBan(i);
        break;
    }
  }
  private void quanLySuaThuNgan(int i) {
    Scanner sc = new Scanner(System.in);
    int n;
    
    System.out.println("1. Sửa mã");
    System.out.println("2. Sửa họ tên");
    System.out.println("3. Sửa lương");
    System.out.println("4. Sửa thành part time");
    System.out.println("5. Sửa thành full time");
    System.out.println("6. Sửa số ngày làm việc");
    System.out.println("7. Sửa số ngày nghỉ");
    System.out.println("8. Thêm thưởng");
    System.out.println("9. Sua thuong");
    System.out.println("10. Sửa số lượng khách");
    System.out.println("11. Sửa tất cả thông tin");
    n = sc.nextInt();
    switch (n) {
      case 1:
        DSNV[i].setMaNV(sc.nextInt());
        break;
      case 2:
        sc.nextLine();
        DSNV[i].setTen(sc.nextLine());
        break;
      case 3:
        DSNV[i].setLuong(sc.nextDouble());
        break;
      case 4:
        DSNV[i].setParttime();
        break;
      case 5:
        DSNV[i].setFulltime();
        break;
      case 6:
        DSNV[i].setNgayLamViec(sc.nextInt());
        break;
      case 7:
        DSNV[i].setNgayNghi(sc.nextInt());
        break;
      case 8:
        DSNV[i].addThuong(sc.nextDouble());
        break;
      case 9:
        DSNV[i].setThuong(sc.nextDouble());
        break;
      case 10:
        ((ThuNgan)DSNV[i]).setHoaDon(sc.nextInt());
        break;
      case 11:
        DSNV[i].nhap();
        break;
    
      default:
        quanLySuaThuNgan(i);
        break;
    }
  }

  //tim kiem nhan vien
  public void timkiem() {
    System.out.println("1. Tim kiem theo mã");
    System.out.println("2. Tim kiem theo tên");
    Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt();
    String ten;
    switch (n) {
      case 1:
        System.out.print("Nhập mã nhân viên muốn tìm kiếm: ");
        n = sc.nextInt();
        timkiem(n);
        break;
      case 2:
        System.out.print("Nhập tên nhân viên muốn tìm kiếm: ");
        ten = sc.nextLine();
        ten = sc.nextLine();
        timkiem(ten);
        break;
    
      default:
        break;
    }
  }
  public void timkiem(int maNV) {
    for(int i=0; i<length; i++) {
      if(DSNV[i].maNV == maNV) {
        DSNV[i].xuat();
        return;
      }
    }
    System.out.println("Không tìm thấy nhân viên mã " + maNV);
  }
  public void timkiem(String hoTen) {
    for(int i=0; i<length; i++) {
      if(DSNV[i].hoTen.equals(hoTen)) {
        DSNV[i].xuat();
        return;
      }
    }
    System.out.println("Không tìm thấy nhân viên " + hoTen);
  }

  //in danh sach
  public void xuat() {
    for(int i=0; i<length; i++) {
      System.out.println("====================");
      DSNV[i].xuat();
    }
  }
  public void xuatNgan() {
    for(int i=0; i<length; i++) {
      System.out.println("====================");
      System.out.println(DSNV[i].getTen() + "\t" + DSNV[i].getLuong());
    }
  }

  public double tinhLuongNhanVien() {
    double sum = 0;
    for(int i=0; i<length; i++) {
      sum += DSNV[i].getTien();
    }
    return sum;
  }
  public void danhdauNghi(String ten) {
    for(int i=0; i<length; i++) {
      if(DSNV[i].getTen().equalsIgnoreCase(ten)) {
        DSNV[i].addNgayNghi();
        return;
      }
    }
    System.out.println("Không tìm thấy nhân viên " + ten);
  }

  public void tangSoMonNau(String ten, Mon mon, KhoNguyenLieu kho, int n) {
    for(int i=0; i<length; i++) {
      if(DSNV[i].hoTen.equalsIgnoreCase(ten) && DSNV[i] instanceof DauBep) {
        if (mon instanceof Nuoc) {
          ((DauBep)DSNV[i]).nauMon((Nuoc)mon, kho, n);
        }
        else {
          ((DauBep)DSNV[i]).nauMon((DoAn)mon, kho, n);
        }
        return;
      }
    }
    System.out.println("Không tìm thấy nhân viên " + ten);
    Scanner sc = new Scanner(System.in);
    tangSoMonNau(sc.nextLine(), mon, kho, n);
  }
  public ThuNgan tangSoHoaDon(String ten) {
    for(int i=0; i<length; i++) {
      if(DSNV[i].hoTen.equalsIgnoreCase(ten) && DSNV[i] instanceof ThuNgan) {
        ((ThuNgan)DSNV[i]).setHoaDon(((ThuNgan)DSNV[i]).getHoaDon() + 1);
        return (ThuNgan)DSNV[i];
      }
    }
    System.out.println("Không tìm thấy nhân viên " + ten);
    Scanner sc = new Scanner(System.in);
    return tangSoHoaDon(sc.nextLine());
  }
  public void tangSoBanPhucVu(String ten) {
    for(int i=0; i<length; i++) {
      if(DSNV[i].hoTen.equalsIgnoreCase(ten) && DSNV[i] instanceof BoiBan) {
        ((BoiBan)DSNV[i]).setSoBanPhucVu(((BoiBan)DSNV[i]).getSoBanPhucVu() + 1);
        return;
      }
    }
    System.out.println("Không tìm thấy nhân viên " + ten);
    Scanner sc = new Scanner(System.in);
    tangSoBanPhucVu(sc.nextLine());
  }

  public void xemNhanVienNghiHon(int ngay) {
    for(int i=0; i<length; i++) {
      if(DSNV[i].getNgayNghi() >= ngay) {
        System.out.println("====================");
        System.out.println(DSNV[i].getTen() + "\t" + DSNV[i].getNgayNghi());
        DSNV[i].addNgayLamViec();
      }
    }
  }

  public void danhDauNghi(String ten) {
    for(int i=0; i<length; i++) {
      if(DSNV[i].hoTen.equalsIgnoreCase(ten)) {
        DSNV[i].addNgayNghi();
        return;
      }
    }
    System.out.println("Không tìm thấy nhân viên " + ten);
  }
  public void danhDauLam(String ten) {
    for(int i=0; i<length; i++) {
      if(DSNV[i].hoTen.equalsIgnoreCase(ten)) {
        DSNV[i].addNgayLamViec();
        return;
      }
    }
    System.out.println("Không tìm thấy nhân viên " + ten);
  }


  //nhap nhan vien thong qua file
  public void addByFile(String filePath) {
    try {
      BufferedReader file = new BufferedReader(new FileReader(filePath));
      String line = file.readLine();
      while(line != null) {
        String[] arrayLine = line.split("/");
        DSNV = Arrays.copyOf(DSNV, length+1);
        if (arrayLine[0].equalsIgnoreCase("db")) {
          DSNV[length] = new DauBep();
          ((DauBep)DSNV[length]).setSoLuongMon(Integer.parseInt(arrayLine[1]));
        }
        else if (arrayLine[0].equalsIgnoreCase("tn")) {
          DSNV[length] = new ThuNgan();
          ((ThuNgan)DSNV[length]).setHoaDon(Integer.parseInt(arrayLine[1]));
        }
        else {
          DSNV[length] = new BoiBan();
          ((BoiBan)DSNV[length]).setSoBanPhucVu(Integer.parseInt(arrayLine[1]));
        }
        DSNV[length].setMaNV(Integer.parseInt(arrayLine[2]));
        DSNV[length].setTen(arrayLine[3]);
        DSNV[length].setLuong(Double.parseDouble(arrayLine[4]));
        DSNV[length].setThuong(Double.parseDouble(arrayLine[5]));
        if(arrayLine[6].equalsIgnoreCase("ft")) {
          DSNV[length].setFulltime();
        }
        else if(arrayLine[6].equalsIgnoreCase("pt")){
          DSNV[length].setParttime();
        }
        DSNV[length].setNgayLamViec(Integer.parseInt(arrayLine[7]));
        DSNV[length].setNgayNghi(Integer.parseInt(arrayLine[8]));
        line = file.readLine();
        length++;
      }
      file.close();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  private String printFulltime(boolean fulltime) {
    if(fulltime) {
      return "ft";
    }
    else {
      return "pt";
    }
  }

  //in danh sach nhan vien ra file, dung de update danh sach sau khi thay doi
  public void printListInFile(String filePath) {
    try{
      FileWriter file = new FileWriter(filePath);
      for(int i=0; i<length; i++) {
        if(DSNV[i] instanceof DauBep) {
          file.write("db/"+((DauBep)DSNV[i]).getSoLuongMon()+"/");
        }
        if(DSNV[i] instanceof BoiBan) {
          file.write("bb/"+((BoiBan)DSNV[i]).getSoBanPhucVu()+"/");
        }
        if(DSNV[i] instanceof ThuNgan) {
          file.write("tn/"+((ThuNgan)DSNV[i]).getHoaDon()+"/");
        }
        file.write(DSNV[i].getMaNV()+"/"+DSNV[i].getTen()+"/"+DSNV[i].getLuong()+"/"+DSNV[i].getThuong()+"/"+printFulltime(DSNV[i].getFulltime())+"/"+DSNV[i].getNgayLamViec()+"/"+DSNV[i].getNgayNghi()+"\n");
      }
      file.close();
    }
    catch(Exception e) {
      System.out.println(e);
    }
  }
}
