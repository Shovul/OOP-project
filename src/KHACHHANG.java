import java.util.Scanner;

 public class KHACHHANG
 {
    private String TenKH;
    private int MaKH;
    private int sdtKH;
    private String emailKH;

    public KHACHHANG()
    {
        TenKH="";
        MaKH=0;
        sdtKH=0;
        emailKH="";
    }
    public KHACHHANG(String TenKH, int MaKH , int sdtKH, String emailKH)
    {
        this.TenKH=TenKH;
        this.MaKH=MaKH;
        this.sdtKH=sdtKH;
        this.emailKH=emailKH;
    }
    public KHACHHANG(KHACHHANG saochep) // Hàm thiết lập sao chép
    {   
        this.TenKH=saochep.TenKH;
        this.MaKH=saochep.MaKH;
        this.sdtKH=saochep.sdtKH;
        this.emailKH=saochep.emailKH;
    }
    public String getTenKH()
    {
        return TenKH;
    }
    public void setTenKH(String TenKH)
    {  
        this.TenKH=TenKH;
    }
    public int getMaKH()
    {
        return MaKH;
    }
    public void setMaKH(int MaKH)
    {
        this.MaKH=MaKH;
    }
    public int getsdtKH()
    {
        return sdtKH;
    }
    public void setsdtKH(int sdtKH)
    {
        this.sdtKH=sdtKH;
    }
    public String getemailKH()
    {
        return emailKH;
    }
    public void setemailKH(String emailKH)
    {
        this.emailKH=emailKH;
    }
    public void nhap()
    {   
        Scanner sc = new Scanner (System.in);
        System.out.print("Nhập tên khách hàng: ");
        TenKH= sc.nextLine();
        System.out.print("Nhập mã khách hàng: ");
        MaKH= sc.nextInt();
        sc.nextLine(); 
        System.out.print("Nhập số điện thoại của khách hàng: ");
        sdtKH=sc.nextInt();
        sc.nextLine(); // lệnh này loại bỏ ký tự xuống dòng \n
        System.out.print("Nhập địa chỉ email của khách hàng: ");
        emailKH= sc.nextLine();
    }
    public void xuat()
    {
        System.out.println("Tên khách hàng: " + TenKH);
        System.out.println("Mã khách hàng: " + MaKH);
        System.out.println("Số điện thoại: " + sdtKH);
        System.out.println("email : " + emailKH);
    }
 }