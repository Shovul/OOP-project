import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HoaDon {
    private int MaHD;
    private String NgayInDon;
    private KHACHHANG Khach;
    private HashMap<Mon, Integer> DSmon;//hashmap lưu món ăn và số lượng
    private double TongTien = 0; //lưu tổng tiền của hóa đơn

    public HoaDon(){
        MaHD = 0;
        NgayInDon = "";
        Khach = new KHACHHANG();
        TongTien = 0;
        DSmon = new HashMap<>();
    }

    public HoaDon(int MaHD, String NgayInDon, KHACHHANG Khach, HashMap<Mon, Integer> DSmon, double TongTien){
        this.MaHD = MaHD;
        this.NgayInDon = NgayInDon;
        this.TongTien = TongTien;
        this.Khach = Khach;
        this.DSmon = DSmon;
        tinhTongTien();
    }

    public void tinhTongTien(){
        DSmon.forEach((mon, soLuong) -> { TongTien += mon.giaThucAn * soLuong; });
    }

    public void Nhap(){
        DSMon menu = new DSMon();
        menu.addByFile("menu.txt");

        Scanner hd = new Scanner(System.in);
        System.out.print("Nhập mã hóa đơn: ");
        MaHD = hd.nextInt();
        hd.nextLine();
        System.out.print("Nhập ngày in đơn (DD-MM-YYYY): ");//dd-MM-yy
        NgayInDon = hd.nextLine();
        Khach = new KHACHHANG();
        System.out.print("Nhập tên khách hàng: ");
        Khach.setTenKH(hd.nextLine());
        System.out.print("Nhập số lượng món: ");
        int soLuongMon = hd.nextInt();
        hd.nextLine();
        for(int i = 0; i < soLuongMon; i++){
            System.out.print("Nhập tên món thứ " + (i + 1) + ":");
            Mon mon = menu.getMon(hd.nextLine());
            if(mon instanceof Nuoc) {
                System.out.print("Nhập size " + mon.tenThucAn + ": ");
                ((Nuoc)mon).setSize(hd.next().charAt(0));
            }
            mon.xuat();
            System.out.print("Nhập số lượng: ");
            int soLuong = hd.nextInt();
            hd.nextLine();

            DSmon.put(mon, soLuong); // thêm món và số lượng vào hashmap
        }
        tinhTongTien();
    }

    public void Xuat(){
        System.out.println("Mã hóa đơn: " + MaHD);
        System.out.println("Ngày in đơn: " + NgayInDon);
        System.out.println("Tên khách hàng: " + Khach.getTenKH());
        System.out.println("Danh sách món: ");
        DSmon.forEach((mon, soLuong) -> {
            System.out.print("Mon " + mon.getTenThucAn() + " ");
            if(mon instanceof Nuoc) {
                System.out.println(((Nuoc)mon).getSize());
            }
            System.out.println("Gia: " + mon.getGiaThucAn() + "vnd");
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
    public void setTenKhach(String ten) {
        Khach.setTenKH(ten);
    }

    public HashMap<Mon, Integer> getDSmon(){
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
    public void setMon(Nuoc mon, int soLuong){
        if(DSmon.containsKey(mon))
        {
            DSmon.merge(mon, soLuong, (soLuongCu, soLuongMoi) -> soLuongCu + soLuongMoi);
        }
        else{
            DSmon.put(mon, soLuong);
        }
    }
    public void setMon(Mon mon, int soLuong){
        if(DSmon.containsKey(mon))
        {
            DSmon.merge(mon, soLuong, (soLuongCu, soLuongMoi) -> soLuongCu + soLuongMoi);
        }
        else{
            DSmon.put(mon, soLuong);
        }
    }
}
