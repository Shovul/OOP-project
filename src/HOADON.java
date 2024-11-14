import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HoaDon {
    private int MaHD;
    private String NgayInDon;
    private KHACHHANG Khach;
    private Map<Mon, int> DSmon;//hashmap lưu món ăn và số lượng
    private double TongTien; //lưu tổng tiền của hóa đơn

    public HoaDon(){
        MaHD = 00000;
        NgayInDon = "01-01-2024";
        Khach = null;
        TongTien = 0.0;
        DSmon = new HashMap<>();
    }

    public HoaDon(int MaHD, String NgayInDon, KHACHHANG Khach, Map<Mon, int> DSmon, double TongTien){
        this.MaHD = MaHD;
        this.NgayInDon = NgayInDon;
        this.TongTien = TongTien;
        this.Khach = Khach;
        this.DSmon = DSmon;
        tinhTongTien();
    }

    public void tinhTongTien(){
        double TongTien = 0;
        DSmon.forEach((mon, soLuong) -> TongTien += mon.giaThucAn * soLuong);
    }

    public void Nhap(){
        Scanner hd = new Scanner(System.in);
        System.out.println("Nhập mã hóa đơn: ");
        MaHD = hd.nextInt();
        System.out.println("Nhập ngày in đơn: ");//dd-MM-yy
        NgayInDon = hd.nextLine();
        Khach = new KHACHHANG();
        Khach.Nhap();
        System.out.println("Nhập số lượng món: ");
        int soLuongMon = hd.nextInt();
        for(int i = 0; i < soLuongMon; i++){
            System.out.println("Nhập thông tin món thứ " + (i + 1) + ":");
            Mon mon = new Mon();
            mon.Nhap();
        
            System.out.println("Nhập số lượng: ");
            int soLuong = hd.nextInt();

            DSmon.put(mon, soLuong); // thêm món và số lượng vào hashmap
        }
        tinhTongTien();
    }

    public void Xuat(){
        System.out.println("Mã hóa đơn: " + MaHD);
        System.out.println("Ngày in đơn: " + NgayInDon);
        System.out.println("Tên khách hàng: " + Khach);
        System.out.println("Danh sách món: ");
        DSmon.forEach((mon, soLuong) -> {
            mon.Xuat();
            System.out.println("Số lượng: " +soLuong);
            System.out.println("Thành tiền: " + mon.giaThucAn*soLuong);
        });
        System.out.println("Tổng tiền: " + TongTien);
        
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

    public KHACHHANG getKhach(){
        return Khach;
    }
    public void setkhach(KHACHHANG Khach){
        this.Khach = Khach;
    }

    public HashMap<Mon, int> getDSmon(){
        return DSmon;
    }
    public void setMon(DoAn mon, int soLuong){
        if(DSmon.containsKey(mon))
        {
            DSmon.merge(mon, soLuong, (soLuongCu, soLuongMoi) -> soLuongCu + soLuongMoi);
        }
        else{
            DSmon.put(mon, soLuong);
        }
    }
}
