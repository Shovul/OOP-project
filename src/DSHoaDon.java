import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Arrays;
import javax.management.monitor.Monitor;

public class DSHoaDon implements iDanhSach {
    private HoaDon[] dshd;
    private int length;

    //Constructor
    public DSHoaDon(){
        length = 0;
        dshd = new HoaDon[0];
    }
    public DSHoaDon(int length, HoaDon[] ds){
        dshd = ds;
        this.length = length;
    }
    public DSHoaDon(int length){
        dshd = new HoaDon[length];
        this.length = length;
    }

    //them hoa don
    public void them(){
        dshd = Arrays.copyOf(dshd, length + 1);

        dshd[length] = new HoaDon();
        dshd[length].Nhap();
        length++;
        
    }

    //xoa hoa don theoo ma hoa don
    public void xoa() {
        System.out.print("Nhập mã hóa đơn: ");
        Scanner sc = new Scanner(System.in);
        xoa(sc.nextInt());
    }
    public void xoa(int MaHD){
        for(int i = 0; i < length; i++){
            if(dshd[i].getMaHD() == MaHD){
                for(int j = i; j < length - 1; j++){
                    dshd[j] = dshd[j + 1];
                }
                dshd = Arrays.copyOf(dshd, length--);
                return;
            }
        }
        System.out.println("Không tìm thấy hóa đơn #" + MaHD);
    }

    //sua thong tin hoa  don
    public void sua() {
        System.out.print("Nhập mã hóa đơn: ");
        Scanner sc = new Scanner(System.in);
        sua(sc.nextInt());
    }
    public void sua(int MaHD){
        boolean flag = true;
        for(int i = 0; i < length; i++){
            if(dshd[i].getMaHD() == MaHD){
                quanlySua(i);
                return;
            }
        }
        System.out.println("Không tìm thấy hóa đơn #" + MaHD);
    } 
    private void quanlySua(int i) {
        System.out.println("1. Sửa mã hóa đơn");
        System.out.println("2. Sửa ngày in hóa đơn");
        System.out.println("3. Sửa tên thu ngân");
        System.out.println("4. Sửa tên khách hàng");
        System.out.println("5. Sửa danh sách món gọi");
        System.out.println("6. Sửa toàn bộ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        switch (n) {
            case 1:
                dshd[i].setMaHD(sc.nextInt());
                break;
            case 2:
                dshd[i].setNgayInDon(sc.nextLine());
                break;
            case 3:
                dshd[i].setThuNgan(sc.nextLine());
                break;
            case 4:
                dshd[i].setKhach(sc.nextLine());
                break;
            case 5:
                dshd[i].nhapMon();
                break;
            case 6:
                dshd[i].Nhap();
                break;
        
            default:
                break;
        }
    }

    //tim kiem va tra ve hoa don
    public void timkiem() {
        System.out.print("Nhập mã hóa đơn: ");
        Scanner sc = new Scanner(System.in);
        timkiem(sc.nextInt());
    }
    public void timkiem(int MaHD){
        for(int i = 0; i < length; i++){
            if(dshd[i].getMaHD() == MaHD){
                dshd[i].Xuat();
                return;
            }
        }
        System.out.println("Không tìm thấy hóa đơn #" + MaHD);
    }

    //in danh sach
    public void xuat(){
        for(int i = 0; i < length; i++){
            System.out.println("====================");
            dshd[i].Xuat();
        }
    }

    public double tinhTong() {
        double sum = 0;
        for(int i=0; i<length; i++) {
            sum += dshd[i].getTongTien();
        }
        return sum;
    }
//nhap hoa don thong qua file
    public void addByFile(String fileName){
        try {
            BufferedReader file = new BufferedReader(new FileReader(fileName));
            String line = file.readLine();
            while(line != null){
                String[] arrayLine = line.split("/");
                
                //khoi tao va thiet lap thuoc tinh cho hoa don
                dshd = Arrays.copyOf(dshd, length+1);
                dshd[length] = new HoaDon();
                dshd[length].setMaHD(Integer.parseInt(arrayLine[0]));
                dshd[length].setNgayInDon(arrayLine[1]);
                dshd[length].setKhach(arrayLine[2]);
                dshd[length].setThuNgan(arrayLine[3]);
                dshd[length].setBan(Integer.parseInt(arrayLine[4]));

                DSMon menu = new DSMon();
                menu.addByFile("menu.txt");
                for(int i = 5; i < arrayLine.length; i++){
                    Mon mon = menu.getMon(arrayLine[i++]);
                    
                    int soLuong = Integer.parseInt(arrayLine[i]);

                    if(mon instanceof Nuoc && (arrayLine[i+1].charAt(0) == 's' || arrayLine[i+1].charAt(0) == 'm' || arrayLine[i+1].charAt(0) == 'l')) {
                        ((Nuoc)mon).setSize(arrayLine[++i].charAt(0));
                        dshd[length].setMon(((Nuoc)mon), soLuong);
                    }
                    else {
                        
                        dshd[length].setMon(((DoAn)mon), soLuong);
                    }
                }

                //tinh tong tien
                dshd[length].tinhTongTien();
                line = file.readLine();
                dshd = Arrays.copyOf(dshd, length+1);
                length++;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //ghi danh sach hoa don ra file, cap nhat danh sach sau khi thay doi
    public void printListInFile(String fileName){
        try {
            FileWriter file = new FileWriter(fileName);
            for(int i = 0; i < length; i++){
                file.write(dshd[i].getMaHD() + "/" + dshd[i].getNgayInDon() + "/" + dshd[i].getKhach().getTenKH() + "/" + dshd[i].getThuNgan().getTen() + "/" + dshd[i].getBan().getMaBan());

                //ghi tung mon trong DSmon
                dshd[i].getDSmon().forEach((mon, soLuong) -> {
                    try {
                        file.write("/" + mon.getTenThucAn() + "/"  + soLuong);
                        if (mon instanceof Nuoc) {
                            file.write("/" + ((Nuoc)mon).getSize());
                        }
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                file.write("\n");
            }
            file.close();
        } 
        catch (Exception e) {
            System.out.println("Lỗi khi ghi file: " +e.getMessage());
        }
    }

}

