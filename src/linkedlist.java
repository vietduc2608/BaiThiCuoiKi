import java.text.SimpleDateFormat;
import java.util.Date;

public class linkedlist {
    private int size;
    private NodeHangHoa head, tail;
    HangHoa hangHoa = new HangHoa();
    SimpleDateFormat df = new SimpleDateFormat();

    public linkedlist(){
        HangHoa.autoId = 1;
        this.size = 0;
        this.tail = null;
        this.head = null;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty()
    {
        return this.head == null;
    }

    public void ThemHangHoa(HangHoa hangHoa)
    {
        if(isEmpty())
        {
            this.head = this.tail = new NodeHangHoa(hangHoa);
            return;
        }
        NodeHangHoa newNode = new NodeHangHoa(hangHoa);
        this.tail.setNext(newNode);
        this.tail = newNode;
    }
    public void ThemNhieuHangHoa(HangHoa...hangHoas)
    {
        for(HangHoa hangHoa : hangHoas)
        {
            ThemHangHoa(hangHoa);
        }
    }

    public boolean XoaHangHoa(int id){
        NodeHangHoa node = this.head;
        if(this.head.getHangHoa().getID() == id){
        this.head = this.head.getNext();
        return true;
        }
        while(node != null)
        {
            if(node.getNext().getHangHoa().getID() == id){
            node.setNext(node.getNext().getNext());
                System.out.println("Đã Xoá Thành Công");
                return true;
            }
        else{
            System.out.println("ID Không Tồn Tại!!");
        }
        node = node.getNext();
    }
        System.out.println("Xoá Không Thành Công!!!");
        return false;
}
    public boolean TimKiemTheoLoai(String l){
        System.out.println("===================================================THÔNG TIN HÀNG HOÁ==========================================");
        System.out.printf("%-20S %-20S %-20S %-20S %-20S %-20S\n", "mã hàng", "sản phẩm", "loại hàng", "số lượng", "giá hàng", "ngày nhập kho");
        boolean isFound = false;
        NodeHangHoa node = this.head;
        while(node != null)
        {
            if(node.getHangHoa().getLoai().contains(l)){
            System.out.printf("%-20d %-20S %-20S %20d %-7.3fVNĐ %20S\n", node.getHangHoa().ID, node.getHangHoa().tenHangHoa, node.getHangHoa().loai, node.getHangHoa().soLuong, node.getHangHoa().giaHang, df.format(node.getHangHoa().ngayNhap)); 
            isFound = true;
            }
            node = node.getNext();
        }
        if(!isFound)
        {
            System.out.println("Loại Muốn Tìm Không Hợp Lệ!!!");
            return false;
        }
        return true;
}
public void SapXepGiamDan(){
    NodeHangHoa nodeHh = this.head, nodeHh2 = null;
    HangHoa tempHangHoa;
    if(head == null)
    return;
    else{
        while(nodeHh != null){
            nodeHh2 = nodeHh.next;
            while(nodeHh2 != null){
                if(nodeHh.hangHoa.giaHang < nodeHh2.hangHoa.giaHang){
                    tempHangHoa = nodeHh.hangHoa;
                    nodeHh.hangHoa = nodeHh2.hangHoa;
                    nodeHh2.hangHoa = tempHangHoa;
                }
                nodeHh2 = nodeHh2.next;
            }
            nodeHh = nodeHh.next;
        }
    }
    showData();
}
public void SapXepTangDan(){
    NodeHangHoa nodeHh = this.head, nodeHh2 = null;
    HangHoa tempHangHoa;
    if(head == null)
    return;
    else{
        while(nodeHh != null){
            nodeHh2 = nodeHh.next;
            while(nodeHh2 != null){
                if(nodeHh.hangHoa.giaHang >  nodeHh2.hangHoa.giaHang){
                    tempHangHoa = nodeHh.hangHoa;
                    nodeHh.hangHoa = nodeHh2.hangHoa;
                    nodeHh2.hangHoa = tempHangHoa;
                }
                nodeHh2 = nodeHh2.next;
            }
            nodeHh = nodeHh.next;
        }
    }
    showData();
}

   public void DuLieuMoi(){
    try {
        String sDate1 = "26/8/2021";  
        String sDate2 = "20/10/2021";  
        String sDate3 = "01/03/2021";  
        String sDate4 = "07/07/2021";  
        String sDate5 = "25/12/2021";  
        String sDate6 = "01/02/2021";  
        String sDate7 = "30/04/2021";  
        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");  
        Date date1=formatter1.parse(sDate1);  
        Date date2=formatter1.parse(sDate2);  
        Date date3=formatter1.parse(sDate3);  
        Date date4=formatter1.parse(sDate4);  
        Date date5=formatter1.parse(sDate5);  
        Date date6=formatter1.parse(sDate6); 
        Date date7=formatter1.parse(sDate7);
        HangHoa hangHoa1 = new HangHoa(100, "Thịt", "Thực Phẩm", 12000, date1);
        HangHoa hangHoa2 = new HangHoa(200, "Chậu Hoa", "Sành Sứ", 9000, date2);
        HangHoa hangHoa3 = new HangHoa(1500, "Máy Điều Hoà", "Điện Máy", 55000, date3);
        HangHoa hangHoa4 = new HangHoa(1500, "Tivi", "Điện Máy", 15000, date4);
        HangHoa hangHoa5 = new HangHoa(1500, "Tủ Lạnh", "Điện Máy", 50000, date5);
        HangHoa hangHoa6 = new HangHoa(100, "Cá Hồi", "Thực Phẩm", 7000, date6);
        HangHoa hangHoa7 = new HangHoa(1500, "Nồi Cơm Điện", "Điện Máy", 15000, date7);
        HangHoa hangHoa8 = new HangHoa(2000, "Mỳ Gói", "Thực Phẩm", 230, date1);
        HangHoa hangHoa9 = new HangHoa(1000, "Ly Thuỷ Tinh", "Sành Sứ", 150, date2);
        HangHoa hangHoa10 = new HangHoa(1500, "Lò Vi Sóng", "Điện Máy", 20000, date3);
        HangHoa hangHoa11 = new HangHoa(1000, "Chén Đĩa", "Sành Sứ", 100, date2);
        HangHoa hangHoa12 = new HangHoa(300, "Rau Củ", "Thực Phẩm", 200, date6);
        HangHoa hangHoa13 = new HangHoa(1500, "Máy Vi Tính", "Điện Máy", 70000, date7);
        HangHoa hangHoa14 = new HangHoa(1500, "Quạt Điện", "Điện Máy", 900, date4);
        HangHoa hangHoa15 = new HangHoa(400, "Thịt Ba Chỉ", "Thực Phẩm", 25000, date5);
        HangHoa hangHoa16 = new HangHoa(500, "Sữa", "Thực Phẩm", 60, date2);
        HangHoa hangHoa17 = new HangHoa(1500, "Máy Nước Nóng", "Điện Máy", 3000, date3);
        HangHoa hangHoa18 = new HangHoa(1500, "Lọ Hoa", "Sành Sứ", 50, date1);
        HangHoa hangHoa19 = new HangHoa(1500, "Bếp Điện", "Điện Máy", 20000, date6);
        HangHoa hangHoa20 = new HangHoa(600, "Cá Thu", "Thực Phẩm", 100, date7);
        ThemHangHoa(hangHoa1);
        ThemHangHoa(hangHoa2);
        ThemHangHoa(hangHoa3);
        ThemHangHoa(hangHoa4);
        ThemHangHoa(hangHoa5);
        ThemHangHoa(hangHoa6);
        ThemHangHoa(hangHoa7);
        ThemHangHoa(hangHoa8);
        ThemHangHoa(hangHoa9);
        ThemHangHoa(hangHoa10);
        ThemHangHoa(hangHoa11);
        ThemHangHoa(hangHoa12);
        ThemHangHoa(hangHoa13);
        ThemHangHoa(hangHoa14);
        ThemHangHoa(hangHoa15);
        ThemHangHoa(hangHoa16);
        ThemHangHoa(hangHoa17);
        ThemHangHoa(hangHoa18);
        ThemHangHoa(hangHoa19);
        ThemHangHoa(hangHoa20);
    } catch (Exception e) {
        e.getCause();
    }
}
public void ThongKe(){
    NodeHangHoa node = this.head;
    int sLtemp = 0;
    float gTtemp = 0;
    while(node != null){
        sLtemp += node.getHangHoa().getSoLuong();
        gTtemp += node.getHangHoa().getGiaHang();
        node = node.getNext();
    }
    System.out.println("=================BẢNG THỐNG KÊ====================");
    System.out.printf("%-30S %-30S\n", "tổng số lượng", "tổng giá trị");
    System.out.printf("%-30d %-10.3fVNĐ\n", sLtemp, gTtemp);
}

    public void showData(){
        NodeHangHoa nHangHoa = this.head;
        System.out.println("===================================================THÔNG TIN HÀNG HOÁ==========================================");
        System.out.printf("%-20S %-20S %-20S %-20S %-20S %-20S\n", "mã hàng", "sản phẩm", "loại hàng", "số lượng", "giá hàng", "ngày nhập kho");
        while(nHangHoa != null){
            System.out.printf("%-20d %-20S %-20S %-20d %-7.3fVND %-20S\n",nHangHoa.getHangHoa().ID, nHangHoa.getHangHoa().tenHangHoa, nHangHoa.getHangHoa().loai, nHangHoa.getHangHoa().soLuong, nHangHoa.getHangHoa().giaHang, df.format(nHangHoa.getHangHoa().ngayNhap));
            nHangHoa = nHangHoa.getNext();
        }
    }
}
