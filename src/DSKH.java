import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;


public class DSKH implements iDanhSach
{
    KHACHHANG[] dskh;
    int n;
    public DSKH()
    {
        n=0;
        dskh = new KHACHHANG[0];
    }
    public DSKH(int n, KHACHHANG[] dskh)
    {
        this.n=n;
        this.dskh = new KHACHHANG[n]; 
    }
    public void nhap()
    {   
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong khách hàng");
        n = sc. nextInt();
        dskh = new KHACHHANG[n];
        sc.nextLine(); // loại bỏ kí tự /n 
        for (int i=0 ; i < n; i++)
        {
            dskh[i]=new KHACHHANG();
            System.out.println("Nhap thông tin khách hàng thu " + (i+1) +" : ");
            dskh[i].nhap();
        }
    }
    public void xuat()
    {
        for (int i=0; i<n ; i++)
        {   
            System.out.println("Vay thông tin khách hàng thu " + (i+1) +" là: ");
            dskh[i].xuat();
        }
    }
    @Override public void them()
    {
        dskh = Arrays.copyOf(dskh, n+1);
        dskh[n] = new KHACHHANG();
        System.out.println("Hay nhap thông tin khách hàng mà ban muon them:");
        dskh[n].nhap();
        n++;
    }
    public void them(KHACHHANG x)
    {
        dskh = Arrays.copyOf(dskh, n+1);
        dskh[n] = new KHACHHANG(x); // gọi hàm thiết lập sao chép
        n++;
    }
    @Override public void xoa()
    {   
        Scanner sc = new Scanner(System.in);
        int luachon;
        boolean timkiem = false; 
        do{
        System.out.println("Ban muon xoa khach hang theo thong tin nao?");
        System.out.println("1: Xoa theo ma khach hang");
        System.out.println("2: Xoa theo ten khach hang");
        System.out.println("3: Quay lai lua chon truoc");
        System.out.println("Hay nhap lua chon [1, 2, 3]");
        luachon= sc.nextInt();
        sc.nextLine();
        switch(luachon)
        { 
            case 1: 
                System.out.println("Hay nhap ma khách hàng can xóa:");
                int maKH = sc.nextInt();   
                sc.nextLine();
                for(int i=0; i<n ; i++)
                {
                    if(dskh[i].getMaKH()== maKH)
                    {
                        for (int j=i ; j < n-1 ; j++)
                        {
                            dskh[j] = dskh[j+1];
                        }
                        dskh=Arrays.copyOf(dskh, n-1);
                        n--;
                        System.out.println("Xoa thanh cong!");
                        timkiem = true; // đã tìm thấy mã khách để xóa
                        break;
                    }
                }
                if (timkiem==false)
                {   
                    System.out.println("Xoa khong thanh cong ! ");
                    System.out.println("Không có khách hàng nào có ma: " + maKH);
                }
                break;
            case 2:
                System.out.println("Hay nhap ten khách hàng can xóa:");
                String tenKH= sc.nextLine();
                for (int i=0; i< n; i++)
                {
                    if(dskh[i].getTenKH().equals(tenKH))
                    {
                        for (int j=i ; j < n-1 ; j++)
                        {
                            dskh[j] = dskh[j+1];
                        }
                        dskh=Arrays.copyOf(dskh, n-1);
                        n--;
                        System.out.println("Xoa thanh cong!");
                        timkiem = true; 
                        break;
                    }
                }
                 if (timkiem==false)
                {   
                    System.out.println("Xoa khong thanh cong ! ");
                    System.out.println("Không có khách hàng nào có ten: " + tenKH);
                }
                break;
            case 3:
                    System.out.println("Chuong trinh se thoat ra!");
                    break;
            default:
                        System.out.println("Lua chon khong hop le. Vui long chon lai");
                        break;
            }
        } while(luachon!=3);
    }
      
    public void xoa(int maKH)
    {   
        boolean timkiem = false;
        for(int i=0; i < n; i++)
        {
            if(dskh[i].getMaKH()== maKH)
            {
                for (int j=i ; j < n-1 ; j++)
                {
                    dskh[j] = dskh[j+1];
                }
                dskh=Arrays.copyOf(dskh, n-1);
                n--;
                timkiem = true;
                System.out.println("Xoa thanh cong!");
                break;
            }
        }
        if (timkiem==false)
        {   
            System.out.println("Xoa khong thanh cong ! ");
            System.out.println("Không có khách hàng nào có ma: " + maKH);
        }
    }
    public void xoa(String tenKH)
    {
        Scanner sc = new Scanner(System.in);
        boolean timkiem = false;
        for (int i=0; i< n; i++)
                {
                    if(dskh[i].getTenKH().equals(tenKH))
                    {
                        for (int j=i ; j < n-1 ; j++)
                        {
                            dskh[j] = dskh[j+1];
                        }
                        dskh=Arrays.copyOf(dskh, n-1);
                        n--;
                        System.out.println("Xoa thanh cong!");
                        timkiem = true; 
                        break;
                    }
                }
         if (timkiem==false)
        {   
            System.out.println("Xoa khong thanh cong ! ");
            System.out.println("Không có khách hàng nào có ten: " + tenKH);
        }
    }
    @Override public void sua()
    {   
        Scanner sc = new Scanner (System.in);
        boolean timkiem = false;
        int luachon;
        do{
        System.out.println("Ban muon sua thong tin khach hang theo thong tin nao?");
        System.out.println("1: Sua theo ten khach hang");
        System.out.println("2: Sua theo ma khach hang");
        System.out.println("3: Quay lai lua chon truoc");
        System.out.println("Hay nhap lua chon [1, 2, 3]");
        luachon= sc.nextInt();
        sc.nextLine();
        switch(luachon)
        {   
            case 1: // theo ten     
                System.out.println("Hay nhap ten khach hang ban can sua");
                String tenKH=sc.nextLine();
                for(int l = 0; l < n; l++)
                {
                    if(dskh[l].getTenKH().equals(tenKH))
                    {
                    suaThongTinKhachHang(dskh[l]);
                    timkiem = true; 
                    break;       
                   }
                }
                if (timkiem==false)
                {   
                    System.out.println("Sua khong thanh cong ! ");
                    System.out.println("Không có khách hàng nào có ten: " + tenKH);
                }
                break;
            case 2: // theo ma
                System.out.println("Hay nhap ma khach hang ban can sua");
                int maKH =sc. nextInt();
                sc.nextLine();
                for(int i=0 ; i < n; i++)
                {
                    if(dskh[i].getMaKH()== maKH)
                    {
                    suaThongTinKhachHang(dskh[i]);
                    timkiem = true; 
                    break;
                    }  
                }        
                if (timkiem==false)
                {   
                    System.out.println("Sua khong thanh cong ! ");
                    System.out.println("Không có khách hàng nào có ma: " + maKH);
                }
            default:
                System.out.println("Lua chon khong hop le. Vui long chon lai.");
                break;
            }
        }while(luachon!=3);
    }
    public void suaThongTinKhachHang(KHACHHANG kh)
    {
        Scanner sc = new Scanner (System.in);
        System.out.println("Khach hang: " + kh.getTenKH());
        System.out.println("Hay chon thong tin ma ban muon sua: ");
        System.out.println("1: Sua ten khach hang ");
        System.out.println("2: Sua ma khach hang ");
        System.out.println("3: Sua so dien thoai ");
        System.out.println("4: Sua dia chi email ");
        System.out.println("5: Sua toan bo thong tin [Ten/Ma/SDT/Email]");
        System.out.println("6: Quay lai lua chon truoc");
        System.out.println("Nhap lua chon [1 ,2 ,3 ,4 ,5 ,6]:");
        int luachon=sc.nextInt();
        sc.nextLine();
        switch(luachon)
        {
        case 1:// sua ten
        System.out.println("Hay nhap ten moi");
        kh.setTenKH(sc.nextLine());
        System.out.println("Ten khach hang da duoc cap nhat");
        break;
        case 2: // sua ma
        System.out.println("Nhap ma khach hang moi");
        kh.setMaKH(sc.nextInt());
        System.out.println("Ma khach hang da duoc cap nhat");
        break;
        case 3: // sua sdt
        System.out.println("Nhap so dien thoai moi");
        kh.setsdtKH(sc.nextInt());
        sc.nextLine();
        System.out.println("So dien thoai da duoc cap nhat");
        break;
        case 4: // sua dia chi
        System.out.println("Nhap dia chi email moi");
        kh.setemailKH(sc.nextLine());
        System.out.println("Dia chi email da duoc cap nhat");
        break;
        case 5: // sua toan bo thong tin
        System.out.println("Hay nhap ten moi");
        kh.setTenKH(sc.nextLine());
        System.out.println("Ten khach hang da duoc cap nhat");
        System.out.println("Nhap ma khach hang moi");
        kh.setMaKH(sc.nextInt());
        System.out.println("Ma khach hang da duoc cap nhat");
        System.out.println("Nhap so dien thoai moi");
        kh.setsdtKH(sc.nextInt());
        sc.nextLine();
        System.out.println("So dien thoai da duoc cap nhat");
        System.out.println("Nhap dia chi email moi");
        kh.setemailKH(sc.nextLine());
        System.out.println("Dia chi email da duoc cap nhat");
        System.out.println("Toan bo thong tin da duoc cap nhat!");
        break;
        case 6:
        System.out.println("Chuong trinh se thoat ra!");
        break;
        default:
        System.out.println("Lua chon khong hop le. Vui long chon lai");
        suaThongTinKhachHang(kh);
        break;
        }          
    }
    public void sua(int maKH)
    {   
        Scanner sc = new Scanner(System.in);
        boolean timkiem = false;

        for(int i=0 ; i < n; i++)
        {
            if(dskh[i].getMaKH()== maKH)
            {
                System.out.println("Hay chon thong tin ma ban muon sua: ");
                System.out.println("1: Sua ten khach hang ");
                System.out.println("2: Sua so dien thoai ");
                System.out.println("3: Sua dia chi email ");
                System.out.println("4: Sua toan bo thong tin [Ten/SDT/Email]");
                System.out.println("Nhap lua chon [1 ,2 ,3, 4]:");

                int luachon = sc.nextInt();
                sc.nextLine();
                switch(luachon)
                {
                    case 1: // Sua ten
                        System.out.println("Hay nhap ten moi");
                        dskh[i].setTenKH(sc.nextLine());
                        System.out.println("Ten khach hang da duoc cap nhat");
                        break;
                    case 2: // Sua sdt
                        System.out.println("Hay nhap So dien thoai moi");
                        dskh[i].setsdtKH(sc.nextInt());
                        sc.nextLine();
                        System.out.println("So dien thoai khach hang da duoc cap nhat");
                        break;
                    case 3: // sua email
                        System.out.println("Hay nhap dia chi Email moi");
                        dskh[i].setemailKH(sc.nextLine());
                        System.out.println("Ten khach hang da duoc cap nhat");
                        break;
                    case 4: // sua toan bo
                        System.out.println("Hay nhap ten moi");
                        dskh[i].setTenKH(sc.nextLine());
                        System.out.println("Ten khach hang da duoc cap nhat");
                        System.out.println("Hay nhap So dien thoai moi");
                        dskh[i].setsdtKH(sc.nextInt());
                        System.out.println("So dien thoai khach hang da duoc cap nhat");
                         System.out.println("Hay nhap dia chi Email moi");
                        dskh[i].setemailKH(sc.nextLine());
                        System.out.println("Ten khach hang da duoc cap nhat");
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
            System.out.println("Không có khách hàng nào có ma: " + maKH);
        }
    }
    public void sua(String tenKH)
    {
        Scanner sc = new Scanner(System.in);
        boolean timkiem=false;
        for(int i = 0; i < n; i++)
                {
                    if(dskh[i].getTenKH().equals(tenKH))
                    {
                        System.out.println("Hay chon thong tin ma ban muon sua: ");
                        System.out.println("1: Sua ma khach hang ");
                        System.out.println("2: Sua so dien thoai ");
                        System.out.println("3: Sua dia chi email ");
                        System.out.println("4: Sua toan bo thong tin [Ma/SDT/Email]");
                        System.out.println("5: Quay lai lua chon truoc");
                        System.out.println("Nhap lua chon [1 ,2 ,3, 4, 5]:");
                        int luachon=sc.nextInt();
                        sc.nextLine();
                        switch(luachon)
                        {
                            case 1: // sua ma
                                System.out.println("Nhap ma khach hang moi");
                                dskh[i].setMaKH(sc.nextInt());
                                System.out.println("Ma khach hang da duoc cap nhat");
                                break;
                            case 2: // sua sdt
                                System.out.println("Nhap so dien thoai moi");
                                dskh[i].setsdtKH(sc.nextInt());
                                System.out.println("So dien thoai da duoc cap nhat");
                                break;
                            case 3: // sua dia chi
                                System.out.println("Nhap dia chi email moi");
                                dskh[i].setemailKH(sc.nextLine());
                                System.out.println("Dia chi email da duoc cap nhat");
                                break;
                            case 4: // sua toan bo thong tin
                                System.out.println("Nhap ma khach hang moi");
                                dskh[i].setMaKH(sc.nextInt());
                                System.out.println("Ma khach hang da duoc cap nhat");
                                System.out.println("Nhap so dien thoai moi");
                                dskh[i].setsdtKH(sc.nextInt());
                                System.out.println("So dien thoai da duoc cap nhat");
                                System.out.println("Nhap dia chi email moi");
                                dskh[i].setemailKH(sc.nextLine());
                                System.out.println("Dia chi email da duoc cap nhat");
                                break;
                            case 5:
                                System.out.println("Chuong trinh se thoat ra!");
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
                    System.out.println("Không có khách hàng nào có ten: " + tenKH);
                }
    }
    @Override public void timkiem()
    {
        Scanner sc = new Scanner(System.in);
        int luachon;
        boolean timkiem = false;

        do{
        System.out.println("Chon cach tim kiem:");
        System.out.println("1. Tim kiem theo ma khách hàng");
        System.out.println("2. Tim kiem theo ten khách hàng");
        System.out.println("3. Quay lai lua chon truoc");

        System.out.print("Nhap lua chon [1, 2, 3]: ");

        luachon = sc.nextInt();
        sc.nextLine();
        switch(luachon)
        {
            case 1: // theo ma
                System.out.println("Nhap ma khach hang can tim");
                int maKH= sc.nextInt();
                sc.nextLine();
                for (int i=0; i < n; i++)
                {
                    if(dskh[i].getMaKH()== maKH)
                    {
                        System.out.println("Da tim thay khach hang co ma la " + maKH);
                        dskh[i].xuat();
                        timkiem = true;
                        break;
                    }
                }
                break;
            case 2:
                System.out.println("Nhap ten khach hang can tim");
                String tenKH= sc.nextLine();
                for (int i=0; i < n; i++)
                {
                    if(dskh[i].getTenKH().equals(tenKH))
                    {
                        System.out.println("Da tim thay khach hang co ten la " + tenKH);
                        dskh[i].xuat();
                        timkiem = true;
                        break;
                    }
                }
                break;
            case 3:
                System.out.println("Chuong trinh se thoat ra!");
                break;
            default:
                System.out.println("Lua chon khong hop le, vui long nhap lai");
                break;
        }
        if (timkiem==false)
        {   
            System.out.println("Tim kiem khong thanh cong ! ");
            System.out.println("Không tim thay khach hang");
        }
        } while(luachon!=3);
    }

    public void timkiem(int maKH)
    {
        Scanner sc = new Scanner(System.in);
        boolean timkiem = false;
        for (int i = 0; i < n; i++) 
        {
            if (dskh[i].getMaKH()== maKH) 
            {   
                System.out.println("Da tim thay khach hang co ma la" + maKH);
                dskh[i].xuat();  
                timkiem = true;
                break;
            }
        }
        if (timkiem==false)
        {   
            System.out.println("Tim kiem khong thanh cong ! ");
            System.out.println("Không tim thay khach hang");
        }
    }
    public void timkiem(String tenKH)
    {
        Scanner sc = new Scanner(System.in);
        boolean timkiem= false;

        for (int i=0; i < n; i++)
            {
                if(dskh[i].getTenKH().equals(tenKH))
                    {
                        System.out.println("Da tim thay khach hang co ten la " + tenKH);
                        dskh[i].xuat();
                        timkiem = true;
                        break;
                    }
            }
        if (timkiem==false)
        {   
            System.out.println("Tim kiem khong thanh cong ! ");
            System.out.println("Không tim thay khach hang");
        }
    }
    public void Readfile(String danhsachkhachhang)
    {
        try
        {   
            BufferedReader file = new BufferedReader(new FileReader(danhsachkhachhang));
            String line = file.readLine();
            while(line!=null)
                {   
                   String[] arr = line.split(",");
                    // if (arr.length == 4) // Kiểm tra xem dữ liệu có đủ 4 phần tử không
                    // { 
                        dskh = Arrays.copyOf(dskh, n + 1);
                        dskh[n] = new KHACHHANG();
                        dskh[n].setTenKH(arr[0]);
                        
                        // Chuyển chuỗi arr[1] thành kiểu int trước khi gán cho MaKH
                        dskh[n].setMaKH(Integer.parseInt(arr[1]));
                        dskh[n].setsdtKH(Integer.parseInt(arr[2]));
                        dskh[n].setemailKH(arr[3]);
                        n++;
                    // } else {
                    //     System.out.println("Du lieu khong hop le o dong: " + line);
                    // }
                    line = file.readLine();
                        }
            file.close();
        } catch (Exception ex)
        {
                  ex.printStackTrace();
        }
    }
    public void Writefile(String danhsachkhachhang)
    {
    try
    {
        FileWriter file= new FileWriter(danhsachkhachhang);
        for (int i=0; i<n ; i++)
        {
            file.write(dskh[i].getTenKH()+ "," + dskh[i].getMaKH() + ","+ dskh[i].getsdtKH() +"," + dskh[i].getemailKH()+"\n");
        }
        file.close();
    }
    catch(Exception e){
      System.out.println(e);}
    }
    
}