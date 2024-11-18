import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HoaDon {
    private int MaHD;
    private String NgayInDon;
    private ThuNgan thuNgan;
    private KHACHHANG Khach;
    private BAN banDat;
    private HashMap<Mon, Integer> danhsachMon;//hashmap lưu món ăn và số lượng
    private double TongTien = 0; //lưu tổng tiền của hóa đơn

    public HoaDon(){
        MaHD = 0;
        NgayInDon = "";
        Khach = new KHACHHANG();
        banDat = new BAN();
        thuNgan = new ThuNgan();
        TongTien = 0;
        danhsachMon = new HashMap<>();
    }

    public HoaDon(int MaHD, String NgayInDon, KHACHHANG Khach, BAN banDat, ThuNgan thuNgan, HashMap<Mon, Integer> danhsachMon, double TongTien){
        this.MaHD = MaHD;
        this.NgayInDon = NgayInDon;
        this.TongTien = TongTien;
        this.Khach = Khach;
        this.banDat = banDat;
        this.thuNgan = thuNgan;
        this.danhsachMon = danhsachMon;
        tinhTongTien();
    }

    public void tinhTongTien(){
        danhsachMon.forEach((mon, soLuong) -> { TongTien += mon.giaThucAn * soLuong; });
    }

    public void Nhap(){
        Scanner hd = new Scanner(System.in);
        
        DSNhanVien danhsachNhanVien = new DSNhanVien();
        danhsachNhanVien.addByFile("dsnv.txt");
        DSMon menu = new DSMon();
        menu.addByFile("menu.txt");
        KhoNguyenLieu kho = new KhoNguyenLieu();
        kho.addByFile("kho.txt");
        DSKH danhsachKhachHang = new DSKH();
        danhsachKhachHang.Readfile("dskh.txt");
        DSBAN danhsachBan = new DSBAN();
        danhsachBan.addByFile("ban.txt");

        System.out.print("Tên thu ngân tiếp khách: ");
        thuNgan = danhsachNhanVien.tangSoHoaDon(hd.nextLine());
        System.out.print("Tên phục vụ bàn: ");
        danhsachNhanVien.tangSoBanPhucVu(hd.nextLine());
        System.out.print("Tên đầu bếp nấu: ");
        String daubep = hd.nextLine();
        System.out.println("1. Bàn 2 chỗ");
        System.out.println("2. Bàn 4 chỗ");
        System.out.println("3. Bàn 8 chỗ");
        System.out.print("Nhập loại bàn muốn đặt: ");
        banDat = danhsachBan.orderBan(hd.nextInt());
        if(banDat == null) {
            System.out.println("Hết bàn loại này!");
            return;
        }

        System.out.print("Nhập mã hóa đơn: ");
        MaHD = hd.nextInt();
        hd.nextLine();
        System.out.print("Nhập ngày in đơn (DD-MM-YYYY): ");//dd-MM-yy
        do {
            NgayInDon = hd.nextLine();
        }while(NgayInDon.charAt(2) != '-' && NgayInDon.charAt(5) != '-' && NgayInDon.length() != 10);
        Khach = new KHACHHANG();
        System.out.print("Nhập tên khách hàng: ");
        Khach.setTenKH(hd.nextLine());
        danhsachKhachHang.them(Khach);
        System.out.print("Nhập số lượng món: ");
        int soLuongMon = hd.nextInt();
        hd.nextLine();
        for(int i = 0; i < soLuongMon; i++){
            System.out.print("Nhập tên món thứ " + (i + 1) + ": ");
            Mon mon = menu.getMon(hd.nextLine());
            if(mon instanceof Nuoc) {
                if(!kho.coNguyenLieu(((Nuoc)mon).getLoaiNuoc())) {
                    System.out.println("Hết món");
                    return;
                }
                System.out.print("Nhập size " + mon.tenThucAn + ": ");
                char size = '@';
                do {
                    size = hd.next().charAt(0);
                }while(size != 's' && size != 'm' && size != 'l');
                ((Nuoc)mon).setSize(size);
            }
            else {
                for(int j=0; j<((DoAn)mon).getSoNguyenLieu(); j++) {
                    if(!kho.coNguyenLieu(((DoAn)mon).getNguyenLieu()[i])) {
                        System.out.println("Hết món");
                        return;
                    }
                }
            }
            System.out.println(mon.getTenThucAn() + " " + mon.getGiaThucAn());
            System.out.print("Nhập số lượng: ");
            int soLuong = hd.nextInt();
            hd.nextLine();

            danhsachMon.put(mon, soLuong); // thêm món và số lượng vào hashmap
        }
        danhsachMon.forEach((mon, soLuong) -> {
            danhsachNhanVien.tangSoMonNau(daubep, mon, kho, soLuong);
        });
        danhsachKhachHang.Writefile("dskh.txt");
        danhsachNhanVien.printListInFile("dsnv.txt");
        kho.printListInFile("kho.txt");
        danhsachBan.printListInFile("ban.txt");
        tinhTongTien();
    }

    public void Xuat(){
        System.out.println("Mã hóa đơn: " + MaHD);
        System.out.println("Ngày in đơn: " + NgayInDon);
        System.out.println("Tên khách hàng: " + Khach.getTenKH());
        System.out.println("Tên thu ngân: " + thuNgan.getTen());
        System.out.println("Mã bàn: " + banDat.getMaBan() + "Loại: " + banDat.getloai());
        System.out.println("Danh sách món: ");
        danhsachMon.forEach((mon, soLuong) -> {
            System.out.print("Mon " + mon.getTenThucAn() + " ");
            if(mon instanceof Nuoc) {
                System.out.println(((Nuoc)mon).getSize());
            }
            System.out.println("Giá: " + mon.getGiaThucAn() + "vnd");
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

    public void setThuNgan(String ten) {
        thuNgan.setTen(ten);
    }
    public ThuNgan getThuNgan() {
        return thuNgan;
    }
    public KHACHHANG getKhach(){
        return Khach;
    }
    public void setkhach(KHACHHANG Khach){
        this.Khach = Khach;
    }
    public void setKhach(String ten) {
        Khach.setTenKH(ten);
    }
    public void setBan(int maHD) {
        banDat.setMaBan(maHD);
    }
    public BAN getBan() {
        return banDat;
    }

    public double getTongTien() {
        return TongTien;
    }

    public HashMap<Mon, Integer> getDSmon(){
        return danhsachMon;
    }
    public void setMon(DoAn mon, int soLuong){
        if(danhsachMon.containsKey(mon))
        {
            danhsachMon.merge(mon, soLuong, (soLuongCu, soLuongMoi) -> soLuongCu + soLuongMoi);
        }
        else{
            danhsachMon.put(mon, soLuong);
        }
    }
    public void setMon(Nuoc mon, int soLuong){
        if(danhsachMon.containsKey(mon))
        {
            danhsachMon.merge(mon, soLuong, (soLuongCu, soLuongMoi) -> soLuongCu + soLuongMoi);
        }
        else{
            danhsachMon.put(mon, soLuong);
        }
    }
    public void nhapMon() {
        DSMon menu = new DSMon();
        menu.addByFile("menu.txt");
        Scanner sc = new Scanner(System.in);
        danhsachMon = new HashMap<>();
        
        System.out.print("Nhập số lượng món: ");
        int soLuongMon = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < soLuongMon; i++){
            System.out.print("Nhập tên món thứ " + (i + 1) + ": ");
            Mon mon = menu.getMon(sc.nextLine());
            if(mon instanceof Nuoc) {
                System.out.print("Nhập size " + mon.tenThucAn + ": ");
                char size = '@';
                do {
                    size = sc.next().charAt(0);
                }while(size != 's' || size != 'm' ||size != 'l');
                ((Nuoc)mon).setSize(size);
            }
            System.out.println(mon.getTenThucAn() + " " + mon.getGiaThucAn());
            System.out.print("Nhập số lượng: ");
            int soLuong = sc.nextInt();
            sc.nextLine();

            danhsachMon.put(mon, soLuong);
        }
    }
}
