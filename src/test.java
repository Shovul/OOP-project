public class test {
  public static void main(String[] args) {
    DSMon ds = new DSMon();
    ds.addByFile("menu.txt");
    HoaDon hd = new HoaDon();
    hd.Nhap(ds);
    hd.Xuat();
  }
}
