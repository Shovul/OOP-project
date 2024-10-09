package Restaurant;

abstract class Food {
  float giaThucAn;
  String tenThucAn;
  int soLuongBan, MaTA;
  static int daBan;
  static float tongTien;
  
  public Food(float giaThucAn, String tenThucAn) {
    this.giaThucAn = giaThucAn;
    this.tenThucAn = tenThucAn;
  }
  public Food() {
    this.giaThucAn = 0;
    this.tenThucAn = "";
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

  public String getTenThucAn() {
    return tenThucAn;
  }
  public float getGiaThucAn() {
    return giaThucAn;
  }
  public int getsoLuongBan() {
    return soLuongBan;
  }

  public void sell() {
    soLuongBan++;
    daBan++;
    tongTien += giaThucAn;
  }
  public void sell(int amount) {
    while (amount > 0) {
      soLuongBan++;
      daBan++;
      tongTien += giaThucAn;
      amount--;
    }
  }
}
