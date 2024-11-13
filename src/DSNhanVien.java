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
    switch (choose) {
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
  public void xoa(int maNV) {
    for(int i=0; i<length; i++) {
      if(DSNV[i].maNV == maNV) {
        for(int j=i; j<length-1; j++) {
          DSNV[j] = DSNV[j+1];
        }
        DSNV = Arrays.copyOf(DSNV, length--);
        break;
      }
    }
  }

  //sua thong tin nhan vien
  public void sua(int maNV) {
    for(int i=0; i<length; i++) {
      if(DSNV[i].maNV == maNV) {
        DSNV[i].nhap();
      }
    }
  }

  //tim kiem va tra ve nhan vien
  public void timkiem(int maNV) {
    for(int i=0; i<length; i++) {
      if(DSNV[i].maNV == maNV) {
        DSNV[i].xuat();
        break;
      }
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
        System.out.println(arrayLine);
        DSNV = Arrays.copyOf(DSNV, length+1);
        if (arrayLine[0].equalsIgnoreCase("db")) {
          DSNV[length] = new DauBep();
        }
        else if (arrayLine[0].equalsIgnoreCase("tn")) {
          DSNV[length] = new ThuNgan();
        }
        else if (arrayLine[0].equalsIgnoreCase("bb")) {
          DSNV[length] = new BoiBan();
        }
        DSNV[length].setMaNV(Integer.parseInt(arrayLine[1]));
        DSNV[length].setTen(arrayLine[2]);
        DSNV[length].setLuong(Double.parseDouble(arrayLine[3]));
        if(arrayLine[4].equalsIgnoreCase("ft")) {
          DSNV[length].setFulltime();
        }
        else if(arrayLine[4].equalsIgnoreCase("pt")){
          DSNV[length].setParttime();
        }
        DSNV[length].setNgayLamViec(Integer.parseInt(arrayLine[5]));
        DSNV[length].setNgayNghi(Integer.parseInt(arrayLine[6]));
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
        file.write("db/"+DSNV[i].getMaNV()+"/"+DSNV[i].getTen()+"/"+DSNV[i].getLuong()+"/"+printFulltime(DSNV[i].getFulltime())+"/"+DSNV[i].getNgayLamViec()+"/"+DSNV[i].getNgayNghi()+"/\n");
      }
      file.close();
    }
    catch(Exception e) {
      System.out.println(e);
    }
  }
  
}
