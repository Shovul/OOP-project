import Restaurant.*;

public class main {
  public static void main(String[] args) {
    Chef chef1 = new Chef();
    // Employee employee1 = new Employee();

    chef1.setName("Pham Nguyen Thanh Sang");
    
    System.err.println(chef1.getId());
    System.err.println(chef1.getFullname());
  }
}