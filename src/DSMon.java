import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class DSMon implements iDanhSach {
  protected Mon[] danhSachMon;
  protected int length;

  public DSMon() {
    danhSachMon = new Mon[0];
    length = 0;
  }
  public DSMon(DSMon ds) {
    danhSachMon = ds.danhSachMon;
    this.length = ds.length;
  }
  public DSMon(int length) {
    danhSachMon = new Mon[length];
    this.length = length;
  }

  public int getLength() {
    return length;
  }
  public Mon[] getDanhSachMon() {
    return danhSachMon;
  }
  public void them() {
    danhSachMon = Arrays.copyOf(danhSachMon, length+1);
    
    System.out.println("1. Thêm đồ ăn");
    System.out.println("2. Thêm nước");
    System.out.println("Nhập 1 hoặc 2: ");
    Scanner scanner = new Scanner(System.in);
    int choose = scanner.nextInt();
    switch (choose) {
      case 1:
        danhSachMon[length] = new DoAn();
        ((DoAn)danhSachMon[length]).nhap();
        length++;
        break;
      case 2:
        danhSachMon[length] = new Nuoc();
        ((Nuoc)danhSachMon[length]).nhap();
        length++;
        break;

      default:
        break;
    }
  }
  //xoa mon an theo ma mon an
  public void xoa(int maThucAn) {
    for(int i=0; i<length; i++) {
      if(danhSachMon[i].maThucAn == maThucAn) {
        for(int j=i; j<length-1; j++) {
          danhSachMon[j] = danhSachMon[j+1];
        }
        danhSachMon = Arrays.copyOf(danhSachMon, length--);
        return;
      }
    }
    System.out.println("Không thể tìm thấy món ăn");
  }
  public void xoa(String tenThucAn) {
    for(int i=0; i<length; i++) {
      if(danhSachMon[i].tenThucAn.equals(tenThucAn)) {
        for(int j=i; j<length-1; j++) {
          danhSachMon[j] = danhSachMon[j+1];
        }
        danhSachMon = Arrays.copyOf(danhSachMon, length--);
        return;
      }
    }
    System.out.println("Không thể tìm thấy món ăn");
  }
  public void xoa() {
    System.out.println("1. Xóa theo mã");
    System.out.println("2. Xóa theo tên");
    Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt();
    String ten;
    switch (n) {
      case 1:
        System.out.print("Nhập mã đồ ăn muốn xóa: ");
        n = sc.nextInt();
        xoa(n);
        break;
      case 2:
        System.out.print("Nhập tên đồ ăn muốn xóa: ");
        ten = sc.nextLine();
        ten = sc.nextLine();
        xoa(ten);
        break;
    
      default:
        break;
    }
  }

  //sua thong tin mon an
  public void sua() {
    System.out.println("1. Sửa theo mã");
    System.out.println("2. Sửa theo tên");
    Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt();
    String ten;
    switch (n) {
      case 1:
        System.out.print("Nhập mã món muốn sửa: ");
        n = sc.nextInt();
        sua(n);
        break;
      case 2:
        System.out.print("Nhập tên món muốn sửa: ");
        ten = sc.nextLine();
        ten = sc.nextLine();
        sua(ten);
        break;
    
      default:
        break;
    }
  }
  public void sua(int maThucAn) {
    for(int i=0; i<length; i++) {
      if(danhSachMon[i].maThucAn == maThucAn) {
        if(danhSachMon[i] instanceof DoAn)
          quanLySuaDoAn(i);
        else 
          quanLySuaNuoc(i);
        return;
      }
    }
    System.out.println("Không thể tìm thấy món ăn");
  }
  public void sua(String tenThucAn) {
    for(int i=0; i<length; i++) {
      if(danhSachMon[i].tenThucAn.equals(tenThucAn)) {
        if(danhSachMon[i] instanceof DoAn)
          quanLySuaDoAn(i);
        else 
          quanLySuaNuoc(i);
        return;
      }
    }
    System.out.println("Không thể tìm thấy món ăn");
  }
  private void quanLySuaDoAn(int i) {
    Scanner sc = new Scanner(System.in);
    int n;
    
    System.out.println(danhSachMon[i].tenThucAn);
    System.out.println("1. Sửa mã");
    System.out.println("2. Sửa tên");
    System.out.println("3. Sửa giá");
    System.out.println("4. Sửa nguyên liệu");
    System.out.println("5. Sửa tất cả thông tin");
    n = sc.nextInt();
    switch (n) {
      case 1:
        danhSachMon[i].setMaThucAn(sc.nextInt());
        break;
      case 2:
        sc.nextLine();
        danhSachMon[i].setTenThucAn(sc.nextLine());
        break;
      case 3:
        danhSachMon[i].setGiaThucAn(sc.nextDouble());
        break;
      case 4:
        System.out.print("Nhập số lượng nguyên liệu: ");
        ((DoAn)danhSachMon[i]).setSoNguyenLieu(sc.nextInt());
        break;
      case 5:
        danhSachMon[i].nhap();
        break;
    
      default:
        quanLySuaDoAn(i);
        break;
    }
  }
  private void quanLySuaNuoc(int i) {
    Scanner sc = new Scanner(System.in);
    int n;
    
    System.out.println(danhSachMon[i].tenThucAn);
    System.out.println("1. Sửa mã");
    System.out.println("2. Sửa tên");
    System.out.println("3. Sửa giá");
    System.out.println("4. Sửa size");
    System.out.println("5. Sửa tất cả thông tin");
    n = sc.nextInt();
    switch (n) {
      case 1:
        danhSachMon[i].setMaThucAn(sc.nextInt());
        break;
      case 2:
        sc.nextLine();
        danhSachMon[i].setTenThucAn(sc.nextLine());
        break;
      case 3:
        danhSachMon[i].setGiaThucAn(sc.nextDouble());
        break;
      case 4:
        ((Nuoc)danhSachMon[i]).setSize(sc.next().charAt(0));
        break;
      case 5:
        danhSachMon[i].nhap();
        break;
    
      default:
        quanLySuaNuoc(i);
        break;
    }
  }

  //tim kiem mon an
  public void timkiem() {
    System.out.println("1. Tìm kiếm theo mã");
    System.out.println("2. Tìm kiếm theo tên");
    Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt();
    String ten;
    switch (n) {
      case 1:
        System.out.print("Nhập mã món ăn muốn tìm kiếm: ");
        n = sc.nextInt();
        timkiem(n);
        break;
      case 2:
        System.out.print("Nhập tên món ăn muốn tìm kiếm: ");
        ten = sc.nextLine();
        ten = sc.nextLine();
        timkiem(ten);
        break;
    
      default:
        break;
    }
  }
  public void timkiem(int maThucAn) {
    for(int i=0; i<length; i++) {
      if(danhSachMon[i].maThucAn == maThucAn) {
        danhSachMon[i].xuat();
        return;
      }
    }
    System.out.println("Không thể tìm thấy món ăn");
  }
  public void timkiem(String tenThucAn) {
    for(int i=0; i<length; i++) {
      if(danhSachMon[i].tenThucAn.equals(tenThucAn)) {
        danhSachMon[i].xuat();
        return;
      }
    }
    
    System.out.println("Không thể tìm thấy món ăn");
  }

  //in danh sach
  public void xuatNgan() {
    for(int i=0; i<length; i++) {
      System.out.println("====================");
      System.out.print(danhSachMon[i].getTenThucAn() + "\t\tGiá: ");
      System.out.println(danhSachMon[i].getGiaThucAn());
    }
  }
  public void xuat() {
    for(int i=0; i<length; i++) {
      System.out.println("====================");
      danhSachMon[i].xuat();
    }
  }

  public Mon getMon(String tenMon) {
    for(int i=0; i<length; i++) {
      if(danhSachMon[i].tenThucAn.equalsIgnoreCase(tenMon)) {
        return danhSachMon[i];
      }
    }
    Scanner sc = new Scanner(System.in);
    System.out.print("Nhập lại tên món: ");
    return getMon(sc.nextLine());
  }
  
  public void addByFile(String filePath) {
    try {
      BufferedReader file = new BufferedReader(new FileReader(filePath));
      String line = file.readLine();
      while(line != null) {
        String[] arrayLine = line.split("/");
        danhSachMon = Arrays.copyOf(danhSachMon, length+1);
        if (arrayLine[0].equalsIgnoreCase("doan")) {
          danhSachMon[length] = new DoAn();
          ((DoAn)danhSachMon[length]).setSoNguyenLieu(Integer.parseInt(arrayLine[1]));

          String[] ingreArray = arrayLine[2].split(",");
          
          int j=0;
          for(int i = 0; i<((DoAn)danhSachMon[length]).getSoNguyenLieu(); i++) {
            ((DoAn)danhSachMon[length]).setNguyenLieuLam(i, ingreArray[j], Integer.parseInt(ingreArray[j+1]));
            j += 2;
          }
          danhSachMon[length].setMaThucAn(Integer.parseInt(arrayLine[3]));
          danhSachMon[length].setTenThucAn(arrayLine[4]);
          danhSachMon[length].setGiaThucAn(Double.parseDouble(arrayLine[5]));
        }
        else {
          danhSachMon[length] = new Nuoc();
          ((Nuoc)danhSachMon[length]).setSize(arrayLine[1].charAt(0));
          ((Nuoc)danhSachMon[length]).setLoaiNuoc(arrayLine[2], Integer.parseInt(arrayLine[3]));
          danhSachMon[length].setMaThucAn(Integer.parseInt(arrayLine[4]));
          danhSachMon[length].setTenThucAn(arrayLine[5]);
          danhSachMon[length].setGiaThucAn(Double.parseDouble(arrayLine[6]));
        }
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
        if(danhSachMon[i] instanceof DoAn) {
          file.write("doan/"+((DoAn)danhSachMon[i]).getSoNguyenLieu()+"/");
          for(int j=0; j<((DoAn)danhSachMon[i]).getSoNguyenLieu()-1; j++) {
            file.write(((DoAn)danhSachMon[i]).getNguyenLieu()[j].getTen()+",");
            file.write(((DoAn)danhSachMon[i]).getNguyenLieu()[j].getSoLuong()+",");
          }
          file.write(((DoAn)danhSachMon[i]).getNguyenLieu()[((DoAn)danhSachMon[i]).getSoNguyenLieu()-1].getTen()+",");
          file.write(((DoAn)danhSachMon[i]).getNguyenLieu()[((DoAn)danhSachMon[i]).getSoNguyenLieu()-1].getSoLuong()+"/");
        }
        if(danhSachMon[i] instanceof Nuoc) {
          file.write("nuoc/"+((Nuoc)danhSachMon[i]).getSize()+"/"+((Nuoc)danhSachMon[i]).getLoaiNuoc().ten+"/"+((Nuoc)danhSachMon[i]).getLoaiNuoc().soLuong+"/");
        }
        file.write(danhSachMon[i].getMaThucAn()+"/"+danhSachMon[i].getTenThucAn()+"/"+danhSachMon[i].getGiaThucAn()+"\n");
      }
      file.close();
    }
    catch(Exception e) {
      System.out.println(e);
    }
  }
}
