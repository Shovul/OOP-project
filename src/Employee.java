package Restaurant;

abstract class Employee {
  protected int maNV, ngayLamViec, ngayNghi;
  protected String hoTen;
  protected float luong, thuong = 0;
  protected boolean fulltime;
  protected static int soLuongNV = 0;

  public Employee(int maNV, String hoTen, int luong, boolean fulltime, int ngayLamViec, int ngayNghi) {
    this.maNV = maNV;
    this.hoTen = hoTen;
    this.luong = luong;
    this.fulltime = fulltime;
    this.ngayLamViec = ngayLamViec;
    this.ngayNghi = ngayNghi;
    soLuongNV++;
  }
  public Employee() {
    this.maNV = -1;
    this.ngayLamViec = 0;
    this.ngayNghi = 0;
    this.hoTen = "none";
    this.luong = 0;
    this.thuong = 0;
    this.fulltime = true;
    soLuongNV++;
  }

  public void setMaNV(int maNV) {
    this.maNV = maNV;
  }
  public void setTen(String hoTen) {
    this.hoTen = hoTen;
  }
  public void setNgayLamViec(int ngayLamViec) {
    this.ngayLamViec = ngayLamViec;
  }
  public void setNgayNghi(int ngayNghi) {
    this.ngayNghi = ngayNghi;
  }
  public void setLuong(int luong) {
    this.luong = luong;
  }
  public void setFulltime() {
    fulltime = true;
  }
  public void setParttime() {
    fulltime = false;
  }

  public int getMaNV() {
    return maNV;
  }
  public String getTen() {
    return hoTen;
  }
  public float getLuong() {
    return luong;
  }
  public boolean getFulltime() {
    return fulltime;
  }
  public boolean getPartTime() {
    return !fulltime;
  }
  public int getNgayLamViec() {
    return ngayLamViec;
  }
  public int getNgayNghi() {
    return ngayNghi;
  }
  public float getThuong() {
    return thuong;
  }

  public int checkNgayNghi(int ngayNghi) {
    if (ngayNghi > 3) {
      return ngayNghi-3;
    }
    else return 0;
  }
  public float getTien() {
    return (ngayLamViec-checkngayNghi(ngayNghi))*luong + thuong; 
  }

  public void addNgayNghi() {
    ngayNghi++;
  }
  public void addNgayLamViec(int n) {
    ngayLamViec += n;
  }
  public void addNgayLamViec() {
    ngayLamViec++;
  }
  public void addThuong() {
    thuong += 100000;
  }

  static public int getEmployeeCount() {
    return soLuongNV;
  }
}
