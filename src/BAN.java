import java.util.Scanner;

public class BAN
{
    int loai,MaBan;
    boolean trong;

    public BAN()
    {   
        loai=0;
        MaBan=0;
        trong=true;
    }
    public BAN(int loai, int MaBan, boolean trong)
    {
        this.loai=loai;
        this.MaBan=MaBan;
        this.trong=trong;
    }
    public BAN(BAN saochep)
    {
        this.loai= saochep.loai;
        this.MaBan=saochep.MaBan;
        this.trong=saochep.trong;
    }
    public int getloai()
    {   
        return loai;
    }
    public void setloai(int loai)
    {
        this.loai=loai;
    }
    public int getMaBan()
    {
        return MaBan;
    }
    public void setMaBan(int MaBan)
    {
        this.MaBan=MaBan;
    }
    public boolean gettrong()
    {
        return trong;
    }
    public void settrong(boolean trong)
    {
        this.trong=trong;
    }

    public void settrong() {
        trong = true;
    }
    public void setday() {
        trong = false;
    }

    public void nhap()
    {
        Scanner sc = new Scanner (System.in);
        System.out.println("Nhập mã bàn");
        MaBan = sc.nextInt();
        sc.nextLine();

        boolean hople = false; // Kiem tra xem lua chon ban` co hop le hong
        while(!hople)
        {
            System.out.println("Hãy chọn loại bàn");
            System.out.println("1. Bàn 2 chỗ");
            System.out.println("2. Bàn 4 chỗ");
            System.out.println("3. Bàn 8 chỗ");
            System.out.println("Nhập chọn loại bàn [1,2,3]");
            int luachon=sc. nextInt();
            sc.nextLine();
            switch(luachon)
                {
                case 1: 
                    System.out.println("Bạn đã chọn loài bàn 2 chỗ");
                    loai=1;
                    hople = true; 
                    break;
                case 2:
                    System.out.println("Bạn đã chọn loài bàn 4 chỗ");
                    loai=2;
                    hople = true; 
                    break;
                case 3:
                    System.out.println("Bạn đã chọn loài bàn 8 chỗ");
                    loai=3;
                    hople = true;
                    break;
                default:
                    System.out.println("Lỗi: chỉ có thể nhập lựa chọn [1,2,3]");
                    break;
                }
        }    
    }
    public void xuat()
    {
        System.out.print("Loại bàn đã đặt:");
        switch (loai) {
            case 1:
                System.out.print("bàn 2 chỗ");
                break;
            case 2:
                System.out.print("bàn 4 chỗ");
                break;
            case 3:
                System.out.print("bàn 8 chỗ");
                break;
        
            default:
                break;
        }
        System.out.println("Bàn hiện tại: "+ (trong? "trống" : "đã có người sử dụng"));
    }
    
}