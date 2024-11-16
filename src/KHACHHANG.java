import java.util.Scanner;

 public class KHACHHANG
 {
    private String TenKH;
    private int MaKH;
    private int sdtKH;
    private String emailKH;

    public KHACHHANG()
    {
        TenKH=" ";
        MaKH=0;
        sdtKH=0;
        emailKH=" ";
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

    // @Override public String toString()
    // {
    //     return "Khách Hàng: \n" +
    //        "Tên khách hàng:\t" + TenKH + "\n" +
    //        "Ma khách hàng:\t" + MaKH + "\n" +
    //        "So đien thoai:\t" + sdtKH + "\n" +
    //        "Email:\t" + emailKH + "\n";
    // }
    public void nhap()
    {   
        Scanner sc = new Scanner (System.in);
        System.out.print("Nhap Ten khach hang: ");
        TenKH= sc.nextLine();
        System.out.print("Nhap Ma khach hang: ");
        MaKH= sc.nextInt();
        sc.nextLine(); 
        System.out.print("Nhap so dien thoai khach hang: ");
        sdtKH=sc.nextInt();
        sc.nextLine(); // lệnh này loại bỏ ký tự xuống dòng \n
        System.out.print("Nhap email khach hang: ");
        emailKH= sc.nextLine();
    }
    public void xuat()
    {
        System.out.println("Ten khach hang: " + TenKH);
        System.out.println("Ma khach hang: " + MaKH);
        System.out.println("So dien thoai: " + sdtKH);
        System.out.println("email : " + emailKH);
    }
 }