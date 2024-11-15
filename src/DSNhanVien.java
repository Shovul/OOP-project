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
    
    System.out.println("1. Them dau bep");
    System.out.println("2. Them thu ngan");
    System.out.println("3. Them boi ban");
    System.out.println("Nhap 1, 2 hoac 3: ");
    Scanner scanner = new Scanner(System.in);
    int choose = scanner.nextInt();
    switch (choose){
      case 1:
        DSNV[length] = new DauBep();
        DSNV[length].nhap();
        length++;
        break;
      case 2:
        DSNV[length] = new ThuNgan();
        DSNV[length].nhap();
        length++;
        break;
      case 3:
        DSNV[length] = new BoiBan();
        DSNV[length].nhap();
        length++;
        break;
    
      default:
        them();
        break;
    }
  }

  //xoa nhan vien theo ma nhan vien
  public void xoa() {
    System.out.println("1. Xoa theo ma");
    System.out.println("2. Xoa theo ten");
    Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt();
    String ten;
    switch (n) {
      case 1:
        System.out.print("Nhap ma nhan vien muon xoa: ");
        n = sc.nextInt();
        xoa(n);
        break;
      case 2:
        System.out.print("Nhap ten nhan vien muon xoa: ");
        ten = sc.nextLine();
        ten = sc.nextLine();
        xoa(ten);
        break;
    
      default:
        break;
    }
  }
  public void xoa(int maNV) {
    boolean flag = false;
    for(int i=0; i<length; i++) {
      if(DSNV[i].maNV == maNV) {
        for(int j=i; j<length-1; j++) {
          DSNV[j] = DSNV[j+1];
        }
        DSNV = Arrays.copyOf(DSNV, length--);
        System.out.println("Da xoa nhan vien");
        flag = true;
        break;
      }
    }
    if(!flag) {
      System.out.println("Khong the tim nhan vien");
    }
  }
  public void xoa(String hoTen) {
    boolean flag = false;
    for(int i=0; i<length; i++) {
      if(DSNV[i].hoTen.equals(hoTen)) {
        for(int j=i; j<length-1; j++) {
          DSNV[j] = DSNV[j+1];
        }
        DSNV = Arrays.copyOf(DSNV, length--);
        System.out.println("Da xoa nhan vien");
        flag = true;
        break;
      }
    }
    if(!flag) {
      System.out.println("Khong the tim nhan vien");
    }
  }

  //sua thong tin nhan vien
  public void sua() {
    System.out.println("1. Sua theo ma");
    System.out.println("2. Sua theo ten");
    Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt();
    String ten;
    switch (n) {
      case 1:
        System.out.print("Nhap ma nhan vien muon sua: ");
        n = sc.nextInt();
        sua(n);
        break;
      case 2:
        System.out.print("Nhap ten nhan vien muon sua: ");
        ten = sc.nextLine();
        ten = sc.nextLine();
        sua(ten);
        break;
    
      default:
        break;
    }
  }
  public void sua(int maNV) {
    int i;
    boolean flag = false;
    for(i=0; i<length; i++) {
      if(DSNV[i].maNV == maNV) {
        if(DSNV[i] instanceof DauBep)
          quanLySuaDauBep(i);
        else if(DSNV[i] instanceof BoiBan)
          quanLySuaBoiBan(i);
        else
          quanLySuaThuNgan(i);
        flag = true;
        break;
      }
    }
    if(!flag) {
      System.out.println("Khong the tim nhan vien");
    }
  }
  public void sua(String hoTen) {
    int i;
    boolean flag = false;
    for(i=0; i<length; i++) {
      if(DSNV[i].hoTen.equals(hoTen)) {
        if(DSNV[i] instanceof DauBep)
          quanLySuaDauBep(i);
        else if(DSNV[i] instanceof BoiBan)
          quanLySuaBoiBan(i);
        else
          quanLySuaThuNgan(i);
        flag = true;
        break;
      }
    }
    if(!flag) {
      System.out.println("Khong the tim nhan vien");
    }
  }
  private void quanLySuaDauBep(int i) {
    Scanner sc = new Scanner(System.in);
    int n;
    
    System.out.println("Dau bep: " + DSNV[i].hoTen);
    System.out.println("1. Sua ma");
    System.out.println("2. Sua ho ten");
    System.out.println("3. Sua luong");
    System.out.println("4. Sua thanh part time");
    System.out.println("5. Sua thanh full time");
    System.out.println("6. Sua so ngay lam viec");
    System.out.println("7. Sua so ngay nghi");
    System.out.println("8. Them thuong");
    System.out.println("9. Sua thuong");
    System.out.println("10. Sua so luong mon da nau");
    System.out.println("11. Sua tat ca thong tin");
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
    
    System.out.println("Boi ban: " + DSNV[i].hoTen);
    System.out.println("1. Sua ma");
    System.out.println("2. Sua ho ten");
    System.out.println("3. Sua luong");
    System.out.println("4. Sua thanh part time");
    System.out.println("5. Sua thanh full time");
    System.out.println("6. Sua so ngay lam viec");
    System.out.println("7. Sua so ngay nghi");
    System.out.println("8. Them thuong");
    System.out.println("9. Sua thuong");
    System.out.println("10. Sua so luong ban phuc vu");
    System.out.println("11. Sua tat ca thong tin");
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
    
    System.out.println("1. Sua ma");
    System.out.println("2. Sua ho ten");
    System.out.println("3. Sua luong");
    System.out.println("4. Sua thanh part time");
    System.out.println("5. Sua thanh full time");
    System.out.println("6. Sua so ngay lam viec");
    System.out.println("7. Sua so ngay nghi");
    System.out.println("8. Them thuong");
    System.out.println("9. Sua thuong");
    System.out.println("10. Sua so luong khach");
    System.out.println("11. Sua tat ca thong tin");
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
    System.out.println("1. Tim kiem theo ma");
    System.out.println("2. Tim kiem theo ten");
    Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt();
    String ten;
    switch (n) {
      case 1:
        System.out.print("Nhap ma nhan vien muon tim kiem: ");
        n = sc.nextInt();
        timkiem(n);
        break;
      case 2:
        System.out.print("Nhap ten nhan vien muon tim kiem: ");
        ten = sc.nextLine();
        ten = sc.nextLine();
        timkiem(ten);
        break;
    
      default:
        break;
    }
  }
  public void timkiem(int maNV) {
    boolean flag = false;
    for(int i=0; i<length; i++) {
      if(DSNV[i].maNV == maNV) {
        DSNV[i].xuat();
        flag = true;
        break;
      }
    }
    if(!flag) {
      System.out.println("Khong the tim nhan vien");
    }
  }
  public void timkiem(String hoTen) {
    boolean flag = false;
    for(int i=0; i<length; i++) {
      if(DSNV[i].hoTen.equals(hoTen)) {
        DSNV[i].xuat();
        flag = true;
        break;
      }
    }
    if(!flag) {
      System.out.println("Khong the tim nhan vien");
    }
  }

  //in danh sach
  public void xuat() {
    for(int i=0; i<length; i++) {
      DSNV[i].xuat();
    }
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
        else if (arrayLine[0].equalsIgnoreCase("bb")) {
          DSNV[length] = new BoiBan();
          ((BoiBan)DSNV[length]).setSoBanPhucVu(Integer.parseInt(arrayLine[1]));
        }
        DSNV[length].setMaNV(Integer.parseInt(arrayLine[2]));
        DSNV[length].setTen(arrayLine[3]);
        DSNV[length].setLuong(Double.parseDouble(arrayLine[4]));
        if(arrayLine[5].equalsIgnoreCase("ft")) {
          DSNV[length].setFulltime();
        }
        else if(arrayLine[5].equalsIgnoreCase("pt")){
          DSNV[length].setParttime();
        }
        DSNV[length].setNgayLamViec(Integer.parseInt(arrayLine[6]));
        DSNV[length].setNgayNghi(Integer.parseInt(arrayLine[7]));
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
          file.write("db/"+((DauBep)DSNV[length]).getSoLuongMon()+"/");
        }
        if(DSNV[i] instanceof BoiBan) {
          file.write("bb/"+((BoiBan)DSNV[length]).getSoBanPhucVu()+"/");
        }
        if(DSNV[i] instanceof ThuNgan) {
          file.write("tt/"+((ThuNgan)DSNV[length]).getHoaDon()+"/");
        }
        file.write(DSNV[i].getMaNV()+"/"+DSNV[i].getTen()+"/"+DSNV[i].getLuong()+"/"+printFulltime(DSNV[i].getFulltime())+"/"+DSNV[i].getNgayLamViec()+"/"+DSNV[i].getNgayNghi()+"\n");
      }
      file.close();
    }
    catch(Exception e) {
      System.out.println(e);
    }
  }
}
