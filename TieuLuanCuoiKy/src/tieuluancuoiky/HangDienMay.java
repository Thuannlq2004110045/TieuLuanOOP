package tieuluancuoiky;

public class HangDienMay extends HangHoa{
    private int thoiGianBaoHanh;
    private double congSuat;

    public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
        if(thoiGianBaoHanh >=0){
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        }else{
            System.out.println("thoi gian bao hanh phai > 0 thang");
        }
    }

    public int getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }

    public void setCongSuat(double congSuat) {
        if(congSuat>0){
        this.congSuat = congSuat;
        }else{
            System.out.println("Cong suat phai > 0 KW");
        }
    }

    public HangDienMay() {
        super();
        this.thoiGianBaoHanh = 0;
        this.congSuat = 0;
    }

    public HangDienMay(String maHang, String tenHang, int soLuongTon, double donGia, int thoiGianBaoHanh,
            double congSuat) {
        super(maHang, tenHang, soLuongTon, donGia);
        this.setThoiGianBaoHanh(thoiGianBaoHanh);
        this.setCongSuat(congSuat);
    }

    @Override
    public String toString() {
        return "Hang Dien May" + super.toString() + "[cong Suat = " + congSuat + ", thoi Gian Bao Hanh = " + thoiGianBaoHanh + "]";
    }

    @Override
    public double tinhVAT() {
        double vAT = 0;
        vAT = this.getDonGia() * 0.1;
        return vAT;
    }

    @Override
    public void danhGiaBanBuon() {
        if(this.getSoLuongTon() >0 & this.getSoLuongTon()<3){
            System.out.println("Danh gia: ban duoc");
        }else{
            System.out.println("khong danh gia");
        }
    }
}
