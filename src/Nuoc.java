import java.util.Scanner;

public class Nuoc extends Mon{
  char size;
  NguyenLieu loaiNuoc;
  public Nuoc() {
    super();
    size = "";
    loaiNuoc = new NguyenLieu();
  }
  public Nuoc(int maThucAn, float giaThucAn, String tenThucAn, int soLuongBan, char size, NguyenLieu loaiNuoc) {
    super(maThucAn, giaThucAn, tenThucAn, soLuongBan);
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
  public void setLoaiNuoc(NguyenLieu loaiNuoc) {
    this.loaiNuoc = loaiNuoc;
  }

  public void nhap() {
    super.nhap();
    Scanner scanner = new Scanner(System.in);
  }
  public void xuat() {
    super.xuat();
    System.out.println("Loai: " + loaiNuoc);
    System.out.println("Kich co: " + size);
  }

  public void dungNguyenLieu(KhoNguyenLieu kho) {
    if(kho.coNguyenLieu(loaiNuoc)) {
      giamNguyenLieu(loaiNuoc);
    }
  }
  
}