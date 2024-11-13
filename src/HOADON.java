import java. util.Scanner;

public class HOADON{
    private int MaHD;
    private String NgayInDon;
    public  KHACHHANG tenKH;
    private double TongTien;
    public  DSMon dsMon;
    
    public HOADON()

    {
        MaHD = 0;
        NgayInDon = "01-01-2024";
        tenKH = NULL;
        TongTien = 0.0;
        dsMon = "";
    }

    public HOADON(int MaHD, String NgayInDon, KHACHHANG tenKH, DSMon dsMon, double TongTien){
        this.MaHD = MaHD;
        this.NgayInDon = NgayInDon;
        this.tenKH = tenKH;
        this.dsMon = dsMon;
        this.TongTien = 0.0;
    }

    public void themMon(String tenMon, int Soluong, double DonGia){
        DSMon mon = new dsMon(tenMon, Soluong, DonGia);
        DSMon.add(mon);
        TongTien += mon.tinhTien();
    }

    public int tinhTongSL(){
        int TongSL = 0;
        for(DSMon mon:dsMon){
            TongSL += mon.getSoluong();
        }
        return TongSL;
    }

    public void HienThiHD(){
        System.out.println("Mã Hóa Đơn: " +MaHD);
        System.out.println("Ngày: " +NgayInDon);
        System.out.println("Tên Khách Hàng: " +tenKH);
        System.out.println("Danh sách món: ");
        for(DSMon mon:dsMon){
            System.out.println("_"+mon.gettenMon()+"|Số lượng: "+mon.getSoluong()+"|Đơn giá: "+mon.getDonGia()+"VNĐ|Thành tiền: "+mon.tinhTien()+"VNĐ");
        }
        System.out.println("Tổng số lượng: " +tinhTongSL());
        System.out.println("Thành tiền: " +TongTien+"VNĐ");
    }

    public int getMaHD(){
        return MaHD;
    }

    public void setMaHD(int MaHD){
        this.MaHD = MaHD;
    }

    public String getNgayInDon(){
        return NgayInDon;
    }

    public void setNgayInDon(String NgayInDon){
        this.NgayInDon = NgayInDon;
    }

    public String gettenKH(){
        return tenKH;
    }

    public void settenKH(String tenKH){
        this.tenKH = tenKH;
    }

    public double getTongTien(){
        return TongTien;
    }

    public void setTongTien(double TongTien){
        this.TongTien = TongTien;
    }

    public String getdsMon(){
        return dsMon;
    }
    
    public void setdsMon(String dsMon){
        this.dsMon = dsMon;
    }

    public String getSoluong(){
        return Soluong;
    }
    
    public void setSoluong(String Soluong){
        this.Soluong = Soluong;
    }

    public String getDonGia(){
        return DonGia;
    }
    
    public void setDonGia(String DonGia){
        this.DonGia = DonGia;
    }

    public double tinhTien(){
        return Soluong*DonGia;
    }

}
