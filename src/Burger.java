package Restaurant;

public class Burger extend Food {
  int salad, caChua, duaLeo, thitBo, banh, phomai;
  
  public Burger(int maTA, float giaThucAn, String tenThucAn, int soLuongBan, int salad, int caChua, int duaLeo, int thitBo, int banh, int phomai) {
    super(maTA, giaThucAn, tenThucAn, soLuongBan);
    this.salad = salad;
    this.caChua = caChua;
    this.duaLeo = duaLeo;
    this.thitBo = thitBo;
    this.banh = banh;
    this.phomai = phomai;
    // this.thitGa = thitGa;
    // this.thitHeo = thitHeo;
  }
  public Burger() {
    super();
    this.salad = 0;
    this.caChua = 0;
    this.duaLeo = 0;
    this.thitBo = 0;
    this.banh = 0;
    this.phomai = 0;
    // this.thitGa = 0;
    // this.thitHeo = 0;
  }
  public void xuat() {
    super.xuat();
    System.out.println("- Thanh phan mon an gom: ");
    if(salad != 0) {
      System.out.println("Salad: " + salad + " mieng");
    }
    if(caChua != 0) {
      System.out.println("Ca chua: " + caChua + " mieng");
    }
    if(duaLeo != 0) {
      System.out.println("Dua leo: " + duaLeo + " mieng");
    }
    if(thitBo != 0) {
      System.out.println("Thit bo: " + thitBo + " lat");
    }
    if(banh != 0) {
      System.out.println("Banh: " + banh + " mieng banh");
    }
    if(phomai != 0) {
      System.out.println("Phomai: " + phomai + " lat");
    }
  }
}
