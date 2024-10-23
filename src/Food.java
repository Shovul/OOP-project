package Restaurant;

public abstract class Food {
  float giaThucAn;
  String tenThucAn;
  int soLuongBan, maTA;
  static int daBan;
  static float tongTien;
  // danh sach kho hang
  
  public Food(int maTA, float giaThucAn, String tenThucAn, int soLuongBan) {
    this.giaThucAn = giaThucAn;
    this.tenThucAn = tenThucAn;
    this.maTA = maTA;
    this.soLuongBan = soLuongBan;
  }
  public Food() {
    this.giaThucAn = 0;
    this.tenThucAn = "";
    this.maTA = 0;
    this.soLuongBan = 0;
  }

  public void setTenThucAn(String tenThucAn) {
    this.tenThucAn = tenThucAn;
  }
  public void setGiaThucAn(float giaThucAn) {
    this.giaThucAn = giaThucAn;
  }
  public void setSoLuongBan(int soLuongBan) {
    this.soLuongBan = soLuongBan;
  }
  public void setMaTA(int maTA) {
    this.maTA = maTA;
  }

  public String getTenThucAn() {
    return tenThucAn;
  }
  public float getGiaThucAn() {
    return giaThucAn;
  }
  public int getsoLuongBan() {
    return soLuongBan;
  }
  public int getMaTA() {
    return maTA;
  }

  public void nhap() {
    Scanner scanner = new Scanner();
    
    System.out.print("Nhap thuc an");
    giaThucAn = scanner.nextFloat();
    tenThucAn =  scanner.nextLine();
    maTA = scanner.nextInt();
    soLuongBan = scanner.nextInt();
  }
  public void xuat() {
    System.out.println("Mon " + tenThucAn + ", ma thuc an: " + maTA);
    System.out.println("- Gia 1 mon: " + giaThucAn);
    System.out.println("- So luong ban: " + soLuongBan);
  }

  public void sell() {
    soLuongBan++;
    daBan++;
    tongTien += giaThucAn;
  }
  public void sell(int amount) {
    soLuongBan += amount;
    daBan += amount;
    tongTien += giaThucAn*amount;
  }

  abstract void nguyenLieu();
  static public int getTongTien() {
    return tongTien;
  }
  static public int getDaBan() {
    return daBan;
  }
}
