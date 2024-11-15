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
        System.out.print("Nhap ma hoa don: ");
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
                break;
            }
        }
    }

    //sua thong tin hoa  don
    public void sua() {
        System.out.print("Nhap ma hoa don: ");
        Scanner sc = new Scanner(System.in);
        sua(sc.nextInt());
    }
    public void sua(int MaHD){
        for(int i = 0; i < length; i++){
            if(dshd[i].getMaHD() == MaHD){
                dshd[i].Nhap();
                break;
            }
        }
    } 

    //tim kiem va tra ve hoa don
    public void timkiem() {
        System.out.print("Nhap ma hoa don: ");
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
        System.out.println("khong tim thay hoa don voi ma " + MaHD);
    }

    //in danh sach
    public void xuat(){
        for(int i = 0; i < length; i++){
            System.out.println("====================");
            dshd[i].Xuat();
        }
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
                dshd[length].setTenKhach(arrayLine[2]);

                DSMon menu = new DSMon();
                menu.addByFile("menu.txt");
                for(int i = 3; i < arrayLine.length; i++){
                    Mon mon = menu.getMon(arrayLine[i++]);
                    
                    int soLuong = Integer.parseInt(arrayLine[i]);

                    if(mon instanceof Nuoc && (arrayLine[i+1].charAt(0) == 's' || arrayLine[i+1].charAt(0) == 'm' || arrayLine[i+1].charAt(0) == 'l')) {
                        ((Nuoc)mon).setSize(arrayLine[++i].charAt(0));
                    }
                    dshd[length].setMon(mon, soLuong);
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
                file.write(dshd[i].getMaHD() + "/" + dshd[i].getNgayInDon() + "/" + dshd[i].getKhach().getTenKH());

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
            System.out.println("Loi khi ghi file: " +e.getMessage());
        }
    }

}

