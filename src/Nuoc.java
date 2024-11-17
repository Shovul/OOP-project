import java.util.Scanner;

public class Nuoc extends Mon{
  char size;
  NguyenLieu loaiNuoc;
  public Nuoc() {
    super();
    size = '0';
    loaiNuoc = new NguyenLieu();
  }
  public Nuoc(int maThucAn, String tenThucAn, double giaThucAn, char size, NguyenLieu loaiNuoc) {
    super(maThucAn, tenThucAn, giaThucAn);
    this.size = size;
    this.loaiNuoc = loaiNuoc;
  }

  public char getSize() {
    return size;
  } 
  public NguyenLieu getLoaiNuoc() {
    return loaiNuoc;
  }
  public void setSize(char s) {
    size = s;
  }
  public void setLoaiNuoc(String ten, int dungTich) {
    loaiNuoc.setTen(ten);
    loaiNuoc.setSoLuong(dungTich);
  }

  public void nhap() {
    super.nhap();
    Scanner scanner = new Scanner(System.in);
    System.out.print("Nhập size của nước: ");
    size = scanner.next().charAt(0);
    loaiNuoc.nhap();
  }
  public void xuat() {
    super.xuat();
    System.out.println("Loại: " + loaiNuoc.ten);
    System.out.println("Dung tích: " + loaiNuoc.soLuong + "ml");
    System.out.println("Kích cỡ: " + size);
  }

  public void dungNguyenLieu(KhoNguyenLieu kho) {
    if(kho.coNguyenLieu(loaiNuoc)) {
      kho.giamNguyenLieu(loaiNuoc, size);
    }
  }
  
}
