import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner; 

public class DSBAN implements iDanhSach
{
    BAN[] dsban;
    int n;

    public DSBAN()
    {
        dsban= new BAN[0];
        n=0;
    }
    public DSBAN(BAN[] dsban, int n)
    {
        this.dsban= new BAN[n];
        this.n=n;
    }
    public void nhap()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hãy nhập số lượng bàn");
        n=sc.nextInt();
        sc.nextLine();
        dsban = new BAN[n];
        for(int i=0; i<n ; i++)
        {
            dsban[i]=new BAN();
            System.out.println("Nhập thông tin bàn thứ " + (i+1) +" : ");
            dsban[i].nhap();
        }
    }
    public void xuat()
    {   
        for(int i=0; i<n ; i++)
        {
            dsban[i].xuat();
        }
    }
    @Override public void them()
    {
        dsban = Arrays.copyOf(dsban, n+1);
        dsban[n] = new BAN();
        System.out.println("Hãy nhập thông tin bàn bạn muốn thêm:");
        dsban[n].nhap();
        n++;
    }
    public void them(BAN x)
    {
        dsban= Arrays.copyOf(dsban, n+1);
        dsban[n] = new BAN(x);
        n++;
    }
    @Override public void xoa()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hay nhap ma ban can xoa:");
        int maBan = sc.nextInt();   
        sc.nextLine();
        boolean timkiem = false; // cờ để kiểm tra xem tim thấy mã khách hàng không
        for(int i=0; i<n ; i++)
        {
            if(dsban[i].getMaBan()== maBan)
            {
                for (int j=i ; j < n-1 ; j++)
                {
                    dsban[j] = dsban[j+1];
                }
                dsban=Arrays.copyOf(dsban, n-1);
                n--;
                timkiem = true; // đã tim thấy mã khách để xóa
                break;
            }
        }
        if (timkiem==false)
        {   
            System.out.println("Xoa khong thanh cong ! ");
            System.out.println("Không có ban nào có ma: " + maBan);
        }
    }
    public void xoa(int maBan)
    {   
        boolean timkiem = false;
        for(int i=0; i < n; i++)
        {
            if(dsban[i].getMaBan()== maBan)
            {
                for (int j=i ; j < n-1 ; j++)
                {
                    dsban[j] = dsban[j+1];
                }
                dsban=Arrays.copyOf(dsban, n-1);
                n--;
                timkiem = true;
                break;
            }
        }
        if (timkiem==false)
        {   
            System.out.println("Xoa khong thanh cong ! ");
            System.out.println("Không có ban nào có ma: " + maBan);
        }
    }
    @Override public void sua()
    {
        Scanner sc = new Scanner (System.in);
        System.out.println("Nhap ma ban ban muon sua");
        int maBan = sc.nextInt();
        sc.nextLine();

        boolean timkiem = false;

        for(int i=0 ; i < n; i++)
        {
            if(dsban[i].getMaBan()== maBan)
            {
                System.out.println("Hay chon thong tin ma ban muon sua: ");
                System.out.println("1: Sua loai ban ");
                System.out.println("2: Sua vi tri (Trong/ConCho) ");
                System.out.println("3: Sua toan bo thong tin [Loai/ViTri/]");
                System.out.println("Nhap lua chon [1 ,2 ,3]:");

                int luachon = sc.nextInt();
                sc.nextLine();
                switch(luachon)
                {
                    case 1: // Sua loai ban
                        System.out.println("Hay nhap loai ban moi");
                        dsban[i].setloai(sc.nextInt());
                        sc.nextLine();
                        System.out.println("Loai ban da duoc cap nhat");
                        break;
                    case 2: // Sua trang thai
                        System.out.println("Hay nhap trang thai ban[True/False]");
                        dsban[i].settrong(sc.nextBoolean());
                        System.out.println("Trang thai ban da duoc cap nhat");
                        break;
                    case 3: // sua toan bo
                        System.out.println("Hay nhap loai ban moi");
                        dsban[i].setloai(sc.nextInt());
                        sc.nextLine();
                        System.out.println("Loai ban da duoc cap nhat");
                        System.out.println("Hay nhap trang thai ban[True/False]");
                        dsban[i].settrong(sc.nextBoolean());
                        System.out.println("Trang thai ban da duoc cap nhat");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le. Vui long chon lai");
                        break;
                }
            timkiem = true; 
            break;
            }  
        }        
        if (timkiem==false)
        {   
            System.out.println("Sua khong thanh cong ! ");
            System.out.println("Không có ban nào có ma: " + maBan);
        }
    }
    public void sua(int maBan)
    {
        Scanner sc = new Scanner(System.in);

         boolean timkiem = false;

        for(int i=0 ; i < n; i++)
        {
            if(dsban[i].getMaBan()== maBan)
            {
                System.out.println("Hay chon thong tin ma ban muon sua: ");
                System.out.println("1: Sua loai ban ");
                System.out.println("2: Sua vi tri (Trong/ConCho) ");
                System.out.println("3: Sua toan bo thong tin [Loai/ViTri/]");
                System.out.println("Nhap lua chon [1 ,2 ,3]:");

                int luachon = sc.nextInt();
                sc.nextLine();
                switch(luachon)
                {
                    case 1:
                        System.out.println("Hay nhap loai ban moi");
                        dsban[i].setloai(sc.nextInt());
                        sc.nextLine();
                        System.out.println("Loai ban da duoc cap nhat");
                        break;
                    case 2: 
                        System.out.println("Hay nhap trang thai ban[True/False]");
                        dsban[i].settrong(sc.nextBoolean());
                        System.out.println("Trang thai ban da duoc cap nhat");
                        break;
                    case 3: 
                        System.out.println("Hay nhap loai ban moi");
                        dsban[i].setloai(sc.nextInt());
                        sc.nextLine();
                        System.out.println("Loai ban da duoc cap nhat");
                        System.out.println("Hay nhap trang thai ban[True/False]");
                        dsban[i].settrong(sc.nextBoolean());
                        System.out.println("Trang thai ban da duoc cap nhat");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le. Vui long chon lai");
                        break;
                }
            timkiem = true; 
            break;
            }  
        }        
        if (timkiem==false)
        {   
            System.out.println("Sua khong thanh cong ! ");
            System.out.println("Không có ban nào có ma: " + maBan);
        }
    }
    @Override public void timkiem()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Chon cach tim kiem:");
        System.out.println("1. tim kiem theo ma ban");
        System.out.println("2. tim kiem theo loai ban");
        System.out.print("Nhap lua chon [1, 2]: ");

        int luachon = sc.nextInt();
        sc.nextLine();

        boolean timkiem = false;

        switch(luachon)
        {
            case 1: // theo ma
                System.out.println("Nhap ma ban can tim");
                int maBan= sc.nextInt();
                sc.nextLine();
                for (int i=0; i < n; i++)
                {
                    if(dsban[i].getMaBan()== maBan)
                    {
                        System.out.println("Da tim thay ban co ma la " + maBan);
                        dsban[i].xuat();
                        timkiem = true;
                        break;
                    }
                }
                break;
            case 2:
                System.out.println("Nhap loai ban can tim");
                int Loai= sc.nextInt();
                sc.nextLine();
                for (int i=0; i < n; i++)
                {
                    if(dsban[i].getloai()==Loai)
                    {
                        System.out.println("Da tim thay loai ban" + Loai);
                        dsban[i].xuat();
                        timkiem = true;
                        break;
                    }
                }
                break;
            default:
            System.out.println("Lua chon khong hop le, vui long nhap lai");
            return;
        }
        if (timkiem==false)
        {   
            System.out.println("Tim kiem khong thanh cong ! ");
            System.out.println("Không tim thay ban");
        }
    }
    public void timkiem(int maBan)
    {
        Scanner sc = new Scanner(System.in);
        boolean timkiem = false;
        for (int i = 0; i < n; i++) 
        {
            if (dsban[i].getMaBan()== maBan) 
            {   
                System.out.println("Da tim thay ban co ma la" + maBan);
                dsban[i].xuat();  
                timkiem = true;
                break;
            }
        }
        if (timkiem==false)
        {   
            System.out.println("Tim kiem khong thanh cong ! ");
            System.out.println("Không tim thay ban");
        }
    }

    public void setBanTrong(int ma) {
        for(int i=0; i<n; i++) {
            if(dsban[i].getMaBan() == ma) {
                dsban[i].settrong();
            }
        }
    }
    
  public void addByFile(String filePath) {
    try {
      BufferedReader file = new BufferedReader(new FileReader(filePath));
      String line = file.readLine();
      while(line != null) {
        String[] arrayLine = line.split("/");
        dsban = Arrays.copyOf(dsban, n+1);

        dsban[n] = new BAN();
        dsban[n].setMaBan(Integer.parseInt(arrayLine[0]));
        if(arrayLine[1].equalsIgnoreCase("empty")) {
          dsban[n].settrong();
        }
        else if(arrayLine[1].equalsIgnoreCase("full")){
          dsban[n].setday();
        }
        dsban[n].setloai(Integer.parseInt(arrayLine[2]));
        line = file.readLine();
        n++;
      }
      file.close();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  private String printVacant(boolean trongCho) {
    if(trongCho) {
      return "empty";
    }
    else {
      return "full";
    }
  }

  public BAN orderBan(int loai) {
    for(int i=0; i<n; i++) {
        if((dsban[i].getloai() == 1 && dsban[i].gettrong()) || (dsban[i].getloai() == 2 && dsban[i].gettrong()) || (dsban[i].getloai() == 3 && dsban[i].gettrong())) {
            dsban[i].setday();
            return dsban[i];
        }
    }
    return null;
  }

  //in danh sach nhan vien ra file, dung de update danh sach sau khi thay doi
  public void printListInFile(String filePath) {
        try{
            FileWriter file = new FileWriter(filePath);
            for(int i = 0;i<n; i++) {
                file.write(dsban[i].getMaBan()+"/"+printVacant(dsban[i].gettrong())+"/"+dsban[i].getloai()+"\n");
            }
            file.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}

