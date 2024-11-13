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
  public void xuat() {
    
  }
  public void them() {

  }
  public void xoa() {

  }
  public void sua() {

  }
  public void timkiem() {

  }
}
