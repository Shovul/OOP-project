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
        System.out.println("Nhập số lượng khách hàng");
        n = sc. nextInt();
        dskh = new KHACHHANG[n];
        sc.nextLine(); // loại bỏ kí tự /n 
        for (int i=0 ; i < n; i++)
        {
            dskh[i]=new KHACHHANG();
            System.out.println("Nhập thông tin khách hàng thứ " + (i+1) +" : ");
            dskh[i].nhap();
        }
        
    }
    public void xuat()
    {
        for (int i=0; i<n ; i++)
        {   
            System.out.println("Vậy thông tin khách hàng thứ " + (i+1) +" là: ");
            dskh[i].xuat();
        }
    }
    @Override public void them()
    {
        dskh = Arrays.copyOf(dskh, n+1);
        dskh[n] = new KHACHHANG();
        System.out.println("Hãy nhập thông tin khách hàng mà bạn muốn thêm: ");
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
        System.out.println("Bạn muốn xóa khách hàng theo thông tin nào?");
        System.out.println("1: Xóa theo mã khách hàng");
        System.out.println("2: Xóa theo tên khách hàng");
        System.out.println("3: Quay lại lựa chọn trước");
        System.out.println("Hãy nhập lựa chọn [1, 2, 3]");
        luachon= sc.nextInt();
        sc.nextLine();
        switch(luachon)
        { 
            case 1: 
                System.out.println("Hãy nhập mã khách hàng cần xóa:");
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
                        System.out.println("Xóa thành công!");
                        timkiem = true; // đã tìm thấy mã khách để xóa
                        break;
                    }
                }
                if (timkiem==false)
                {   
                    System.out.println("Xóa không thành công ! ");
                    System.out.println("Không có khách hàng nào có mã: " + maKH);
                }
                break;
            case 2:
                System.out.println("Hãy nhập tên khách hàng cần xóa:");
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
                        System.out.println("Xóa thành công!");
                        timkiem = true; 
                        break;
                    }
                }
                 if (timkiem==false)
                {   
                    System.out.println("Xóa không thành công ! ");
                    System.out.println("Không có khách hàng nào có tên: " + tenKH);
                }
                break;
            case 3:
                    System.out.println("Chương trình sẽ thoát ra!");
                    break;
            default:
                        System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại lựa chọn");
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
                System.out.println("Xóa thành công!");
                break;
            }
        }
        if (timkiem==false)
        {   
            System.out.println("Xóa không thành công! ");
            System.out.println("Không có khách hàng nào có mã: " + maKH);
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
                        System.out.println("Xóa thành công!");
                        timkiem = true; 
                        break;
                    }
                }
         if (timkiem==false)
        {   
            System.out.println("Xóa không thành công!");
            System.out.println("Không có khách hàng nào có tên: " + tenKH);
        }
    }
    @Override public void sua()
    {   
        Scanner sc = new Scanner (System.in);
        boolean timkiem = false;
        int luachon;
        do{
        System.out.println("Bạn muốn sửa thông tin khách hàng theo thông tin nào?");
        System.out.println("1: Sửa theo tên khách hàng");
        System.out.println("2: Sua theo mã khách hàng");
        System.out.println("3: Quay lại lựa chọn trước");
        System.out.println("Hãy nhập lựa chọn trước [1, 2, 3]");
        luachon= sc.nextInt();
        sc.nextLine();
        switch(luachon)
        {   
            case 1: // theo ten     
                System.out.println("Hãy nhập tên khách hàng cần sửa");
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
                    System.out.println("Sửa không thành công ! ");
                    System.out.println("Không có khách hàng nào có tên: " + tenKH);
                }
                break;
            case 2: // theo ma
                System.out.println("Hãy nhập mã khách hàng cần sửa");
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
                    System.out.println("Sửa không thành công ! ");
                    System.out.println("Không có khách hàng nào có mã: " + maKH);
                }
            default:
                System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại");
                break;
            }
        }while(luachon!=3);
    }
    public void suaThongTinKhachHang(KHACHHANG kh)
    {
        Scanner sc = new Scanner (System.in);
        System.out.println("Khách hàng: " + kh.getTenKH());
        System.out.println("Hãy chọn thông tin mà bạn muốn sửa ");
        System.out.println("1: Sửa tên khách hàng ");
        System.out.println("2: Sửa mã khách hàng ");
        System.out.println("3: Sửa số điện thoại ");
        System.out.println("4: Sửa địa chỉ email ");
        System.out.println("5: Sửa toàn bộ thông tin [Tên/Mã/SDT/Email]");
        System.out.println("6: Quay lại lựa chọn trước");
        System.out.println("Hãy nhập lựa chọn [1 ,2 ,3 ,4 ,5 ,6]:");
        int luachon=sc.nextInt();
        sc.nextLine();
        switch(luachon)
        {
        case 1:// sua ten
        System.out.println("Hãy nhập tên khách hàng mới");
        kh.setTenKH(sc.nextLine());
        System.out.println("Tên khách hàng đã được cập nhật!");
        break;
        case 2: // sua ma
        System.out.println("Hãy nhập mã khách hàng mới");
        kh.setMaKH(sc.nextInt());
        System.out.println("Mã khách hàng đã được cập nhật!");
        break;
        case 3: // sua sdt
        System.out.println("Hãy nhập số điện thoại mới");
        kh.setsdtKH(sc.nextInt());
        sc.nextLine();
        System.out.println("Số điện thoại của khách hàng đã được cập nhật!");
        break;
        case 4: // sua dia chi
        System.out.println("Hãy nhập địa chỉ email mới");
        kh.setemailKH(sc.nextLine());
        System.out.println("Địa chỉ email của khách hàng đã được cập nhật!");
        break;
        case 5: // sua toan bo thong tin
        System.out.println("Hãy nhập tên khách hàng mới");
        kh.setTenKH(sc.nextLine());
        System.out.println("Tên khách hàng đã được cập nhật!");
        System.out.println("Hãy nhập mã khách hàng mới");
        kh.setMaKH(sc.nextInt());
        System.out.println("Mã khách hàng đã được cập nhật!");
        System.out.println("Hãy nhập số điện thoại mới");
        kh.setsdtKH(sc.nextInt());
        sc.nextLine();
        System.out.println("Số điện thoại của khách hàng đã được cập nhật!");
        System.out.println("Hãy nhập địa chỉ email mới");
        kh.setemailKH(sc.nextLine());
        System.out.println("Địa chỉ email của khách hàng đã được cập nhật!");
        System.out.println("Toàn bộ thông tin đã được cập nhật!");
        break;
        case 6:
        System.out.println("Chương trình sẽ thoát ra!");
        break;
        default:
        System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại");
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
                System.out.println("Hãy chọn thông tin mà bạn muốn sửa: ");
                System.out.println("1: Sửa tên khách hàng ");
                System.out.println("2: Sửa số điện thoại ");
                System.out.println("3: Sửa địa chỉ email ");
                System.out.println("4: Sửa toàn bộ thông tin [Tên/SDT/Email]");
                System.out.println("Hãy nhập lựa chọn [1 ,2 ,3, 4]:");

                int luachon = sc.nextInt();
                sc.nextLine();
                switch(luachon)
                {
                    case 1: // Sua ten
                        System.out.println("Hãy nhập tên khách hàng mới");
                        dskh[i].setTenKH(sc.nextLine());
                        System.out.println("Tên khách hàng đã được cập nhật");
                        break;
                    case 2: // Sua sdt
                        System.out.println("Hãy nhập Số điện thoại mới");
                        dskh[i].setsdtKH(sc.nextInt());
                        sc.nextLine();
                        System.out.println("Số điện thoại của khách hàng đã được cập nhật");
                        break;
                    case 3: // sua email
                        System.out.println("Hãy nhập địa chỉ Email mới");
                        dskh[i].setemailKH(sc.nextLine());
                        System.out.println("Địa chỉ email của khách hàng đã được cập nhật");
                        break;
                    case 4: // sua toan bo
                        System.out.println("Hãy nhập tên khách hàng mới");
                        dskh[i].setTenKH(sc.nextLine());
                        System.out.println("Tên khách hàng đã được cập nhật");
                        System.out.println("Hãy nhập Số điện thoại mới");
                        dskh[i].setsdtKH(sc.nextInt());
                        System.out.println("Số điện thoại của khách hàng đã được cập nhật");
                         System.out.println("Hãy nhập địa chỉ Email mới");
                        dskh[i].setemailKH(sc.nextLine());
                        System.out.println("Địa chỉ email của khách hàng đã được cập nhật");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại");
                        break;
                }
            timkiem = true; 
            break;
            }  
        }        
        if (timkiem==false)
        {   
            System.out.println("Sửa không thành công ! ");
            System.out.println("Không có khách hàng nào có mã: " + maKH);
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
                        System.out.println("Hãy chọn thông tin mà bạn muốn sửa: ");
                        System.out.println("1: Sửa mã khách hàng ");
                        System.out.println("2: Sửa số điện thoại ");
                        System.out.println("3: Sửa địa chỉ email ");
                        System.out.println("4: Sửa toàn bộ thông tin [Mã/SDT/Email]");
                        System.out.println("5: Quay lại lựa chọn trước");
                        System.out.println("Hãy nhập lựa chọn [1 ,2 ,3, 4, 5]:");
                        int luachon=sc.nextInt();
                        sc.nextLine();
                        switch(luachon)
                        {
                            case 1: // sua ma
                                System.out.println("Nhập mã khách hàng mới");
                                dskh[i].setMaKH(sc.nextInt());
                                System.out.println("Mã khách hàng đã được cập nhật!");
                                break;
                            case 2: // sua sdt
                                System.out.println("Nhập số điện thoại mới");
                                dskh[i].setsdtKH(sc.nextInt());
                                System.out.println("Số điện thoại của khách hàng đã được cập nhật!");
                                break;
                            case 3: // sua dia chi
                                System.out.println("Nhập địa chỉ email mới");
                                dskh[i].setemailKH(sc.nextLine());
                                System.out.println("Địa chỉ email của khách hàng đã được cập nhật!");
                                break;
                            case 4: // sua toan bo thong tin
                                System.out.println("Nhập mã khách hàng mới");
                                dskh[i].setMaKH(sc.nextInt());
                                System.out.println("Mã khách hàng đã được cập nhật");
                                System.out.println("Nhập số điện thoại mới");
                                dskh[i].setsdtKH(sc.nextInt());
                                System.out.println("Số điện thoại của khách hàng đã được cập nhật!");
                                System.out.println("Nhập địa chỉ email mới");
                                dskh[i].setemailKH(sc.nextLine());
                                System.out.println("Địa chỉ email của khách hàng đã được cập nhật!");
                                break;
                            case 5:
                                System.out.println("Chương trình sẽ thoát ra!");
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại");
                                break;
                        }
                    timkiem = true; 
                    break;       
                   }
                }
                if (timkiem==false)
                {   
                    System.out.println("Sửa không thành công ! ");
                    System.out.println("Không có khách hàng nào có tên: " + tenKH);
                }
    }
    @Override public void timkiem()
    {
        Scanner sc = new Scanner(System.in);
        int luachon;
        boolean timkiem = false;

        do{
        System.out.println("Hãy chọn cách tìm kiếm:");
        System.out.println("1. Tìm kiếm theo mã khách hàng");
        System.out.println("2. Tìm kiếm theo tên khách hàng");
        System.out.println("3. Quay lại lựa chọn trước");
        System.out.print("Hãy nhập lựa chọn [1, 2, 3]: ");

        luachon = sc.nextInt();
        sc.nextLine();
        switch(luachon)
        {
            case 1: // theo ma
                System.out.println("Nhập mã khách hàng cần tìm kiếm");
                int maKH= sc.nextInt();
                sc.nextLine();
                for (int i=0; i < n; i++)
                {
                    if(dskh[i].getMaKH()== maKH)
                    {
                        System.out.println("Đã tìm thấy khách hàng có mã là " + maKH);
                        dskh[i].xuat();
                        timkiem = true;
                        break;
                    }
                }
                break;
            case 2:
                System.out.println("Nhập tên khách hàng cần tìm kiếm");
                String tenKH= sc.nextLine();
                for (int i=0; i < n; i++)
                {
                    if(dskh[i].getTenKH().equals(tenKH))
                    {
                        System.out.println("Đã tìm thấy khách hàng có tên là " + tenKH);
                        dskh[i].xuat();
                        timkiem = true;
                        break;
                    }
                }
                break;
            case 3:
                System.out.println("Chương trình sẽ thoát ra!");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại");
                break;
        }
        if (timkiem==false)
        {   
            System.out.println("Tìm kiếm không thành công ! ");
            System.out.println("Không tìm thấy khách hàng");
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
                System.out.println("Đã tìm thấy khách hàng có mã là" + maKH);
                dskh[i].xuat();  
                timkiem = true;
                break;
            }
        }
        if (timkiem==false)
        {   
            System.out.println("Tìm kiếm không thành công ! ");
            System.out.println("Không tìm thấy khách hàng");
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
                        System.out.println("Đã tìm thấy khách hàng có tên là " + tenKH);
                        dskh[i].xuat();
                        timkiem = true;
                        break;
                    }
            }
        if (timkiem==false)
        {   
            System.out.println("Tìm kiếm không thành công ! ");
            System.out.println("Không tìm thấy khách hàng");
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