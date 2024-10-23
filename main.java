import Restaurant.*;

public class main {
  public static void main(String[] args) {
    Employee[] eList = new Employee[10];
    eList[0] = new Waiter();
    eList[1] = new Cashier();
    eList[2] = new Chef();

    eList[0].nhap();
    eList[1].nhap();
    eList[2].nhap();
    eList[0].xuat();
    eList[1].xuat();
    eList[2].xuat();
  }
}