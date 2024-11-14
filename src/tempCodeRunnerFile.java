import java.util.Scanner;

public class BAN;
{
    int loai,soluong,MaBan;
    boolean trong;

    public BAN()
    {   
        loai=0;
        soluong=0;
        MaBan=0;
        trong=true;
    }
    public BAN(int loai, int soluong, int MaBan, boolean trong)
    {
        this.loai=loai;
        this.soluong=soluong;
        this.MaBan=MaBan;
        this.trong=trong;
    }
    public int getloai()
    {   
        return loai;
    }
    public void setloai(int loai)
    {
        this.loai=loai;
    }
    public int getsoluong()
    {
        return soluong;
    }
    public void setsoluong(int soluong)
    {
        this.soluong=soluong;
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
    public void nhap()
    {
        Scanner sc = new Scanner (System.in);
        System.out.println("Nhap So luong ban");
        soluong=nextInt();
        sc.nextLine();
        System.out.println("Nhap ma ban");
        MaBan= nextInt();
        sc.nextLine();
        System.out.println("Hay chon loai ban");
        System.out.println("1:Ban 2 cho");
        System.out.println("2:Ban 4 cho");
        System.out.println("3:Ban 8 cho");
        System.out.println("Nhap chon loai ban [1,2,3]");
        int luachon= nextInt();
        sc.nextLine();
        switch(luachon)
        {
            case 1: 
                System.out.println("Ban dang chon loai ban 2 cho");
                loai=2;
                break;
            case 2:
                System.out.println("Ban dang chon loai ban 4 cho");
                loai=4;
                break;
            case 3:
                System.out.println("Ban dang chon loai ban 8 cho");
                loai=8;
                break;
            default:
                System.out.println("Loi: chi co the nhap lua chon [1,2,3]");
                break;
        }    
    }
    public void xuat()
    {
        System.out.println("Thong tin dat ban: ");
        System.out.println("Loai ban da dat:" + loai);
        System.out.println("So luong ban: " + soluong);
        System.out.println("Ban hien tai: "+ (trong? "Trong" : "Da co nguoi su dung");

    }
}