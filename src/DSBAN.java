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
        System.out.println("Hay nhap so luong ban");
        n=sc.nextInt();
        sc.nextLine();
        dsban = new BAN[n];
        for(int i=0; i<n ; i++)
        {
            dsban[i]=new BAN();
            System.out.println("Nhap thong tin ban thu " + (i+1) +" : ");
            dsban[i].nhap();
        }
    }
    public void xuat()
    {   
        for(int i=0;i<n ; i++)
        {
        System.out.println("Vay thong tin dat ban la:" );
        dsban[i].xuat();
        }
    }
    @Override public void them()
    {
        dsban = Arrays.copyOf(dsban, n+1);
        dsban[n] = new BAN();
        System.out.println("Hay nhap thong tin ban mà ban muon them:");
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
    
}

