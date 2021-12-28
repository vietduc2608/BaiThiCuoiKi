import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Date ngayNhap = new Date();
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        //String strDate = df.format(ngayNhap);
        linkedlist listHangHoa = new linkedlist();
        int yes;
        listHangHoa.DuLieuMoi();
        do{
            System.out.println("===========================MENU===========================");
            System.out.println("=1====================Thêm Hàng Hoá=======================");
            System.out.println("=2=====================Xoá Hàng Hoá=======================");
            System.out.println("=3=====================Sửa Hàng Hoá=======================");
            System.out.println("=4===================Sắp Xếp Hàng Hoá=====================");
            System.out.println("=5===============Xem Danh Sách Hàng Hoá===================");
            System.out.println("=6==================Thống Kê Hàng Hoá=====================");
            System.out.println("=7==================Tìm Kiếm Hàng Hoá=====================");
            System.out.println("=0=========================THOÁT==========================");
            System.out.println("Nhập Lựa Chọn Của Bạn: ");
            int lc = sc.nextInt();
            switch(lc)
            {
                case 0:
                    break;
                case 1:
                do {
                String loai = null; 
                sc.nextLine();
                System.out.println("Chọn Loại: [1: Thực Phẩm; 2: Sành Sứ; 3: Điện Máy]");
                int n = sc.nextInt();
                switch(n)
                {
                    case 1: loai = "Thực Phẩm";
                    break;
                    case 2: loai = "Sành Sứ";
                    break;
                    case 3: loai = "Điện Máy";
                    break;
                    default: 
                        System.out.println("Loại Không Hợp Lệ!!!");
                    break;
                }
                sc.nextLine();
                System.out.println("Nhập Tên Hàng: ");
                String tenHangHoa = sc.nextLine();
                System.out.println("Nhập Số Lượng: ");
                int soLuong = sc.nextInt();
                System.out.println("Nhập Giá: ");
                float giaHang = sc.nextFloat();
                sc.nextLine();
                try {
                    System.out.println("Nhập Ngày Nhập Kho: ");
                    ngayNhap = df.parse(sc.nextLine());
                } catch (Exception e) {
                    System.out.println("Ngày Không Hợp Lệ");
                }
                HangHoa hangHoa = new HangHoa(soLuong, tenHangHoa, loai, giaHang, ngayNhap);
                listHangHoa.ThemHangHoa(hangHoa);
                System.out.println("Ban co muon nhap tiep (1: tiep, 0: thoat):");
                yes = sc.nextInt();
               } while (yes == 1);
                    break;
                case 2:
                System.out.println("Nhập Mã Cần Xoá: ");
                int ma = sc.nextInt();
                listHangHoa.XoaHangHoa(ma);
                listHangHoa.showData();
                    break;
                case 3:
                    break;
                case 4:
                System.out.println("Lựa chọn của bạn: [1:Sắp Xếp Tăng Dần, 2:Sắp xêp giảm dần]");
                int lll = sc.nextInt();
                String llc = null;
                switch(lll){
                    case 1: llc = "Sắp Xếp Tăng Dần";
                    listHangHoa.SapXepTangDan();
                    break;
                    case 2: llc = "Sắp Xếp Giảm Dần";
                    listHangHoa.SapXepGiamDan();
                    break;
                    default:
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
                }     
                    break;
                case 5: 
                listHangHoa.showData();
                    break;
                case 6:
                listHangHoa.ThongKe();
                    break;
                case 7:
                    sc.nextLine();  
                    System.out.println("Nhập Loại Muốn Tìm: [1: Thực Phẩm; 2: Sành Sứ; 3: Điện Máy]");
                    int l = sc.nextInt();
                    String l1 = null;
                    switch(l){
                        case 1: l1 = "Thực Phẩm";
                        break;
                        case 2: l1 = "Sành Sứ";
                        break;
                        case 3: l1 = "Điện Máy";
                        break;
                        default: System.out.println("Loại Không Hợp Lệ");
                        break;
                    }
                    listHangHoa.TimKiemTheoLoai(l1); 
                    break;
                default:
                    System.out.println("Lựa Chọn Không Hợp Lệ!!!");              
                break;
            }
        }while(true);   
    }
    
}
