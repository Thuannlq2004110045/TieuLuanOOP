package tieuluancuoiky;

import java.util.Date;

public class HangThucPham extends HangHoa{
    private Date ngaySanXuat;
    private Date ngayHetHan;
    private String nhaCungCap;

    public void setNgaySanXuat(Date ngaySanXuat) {
        if(ngaySanXuat!=null){
        this.ngaySanXuat = ngaySanXuat;
        }else{
            System.out.println("Ngay san xuat khong duoc rong!!!");
        }
    }

    public Date getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        if(ngayHetHan!=null){
            if(ngayHetHan.after(ngaySanXuat)){
                this.ngayHetHan = ngayHetHan;
            }else{
                System.out.println("Ngay het han phai sau ngay san xuat!!");
            }
        }else{
            System.out.println("Ngay het han khong duoc rong!!!");
        }
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNhaCungCap(String nhaCungCap) {
        if(nhaCungCap!=null){
        this.nhaCungCap = nhaCungCap;
        }else{
            System.out.println("Nha cung cap khong duoc rong!!!");
        }
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public HangThucPham(){
        super();
        this.ngaySanXuat = null;
        this.ngayHetHan = null;
        this.nhaCungCap = null;
    }

    public HangThucPham(String maHang, String tenHang, int soLuongTon, double donGia, Date ngaySanXuat, Date ngayHetHan,
            String nhaCungCap) {
        super(maHang, tenHang, soLuongTon, donGia);
        this.setNgaySanXuat(ngaySanXuat);
        this.setNgayHetHan(ngayHetHan);
        this.setNhaCungCap(nhaCungCap);
    }

    @Override
    public String toString() {
        return "Hang Thuc Pham" + super.toString() + "[ngay Het Han = " + ngayHetHan + ", ngay San Xuat = " + ngaySanXuat + ", nha Cung Cap =" + nhaCungCap
                + "]";
    }

    @Override
    public double tinhVAT() {
        double vAT = 0;
        vAT = this.getDonGia() * 0.05;
        return vAT;
    }

    private boolean tinhHSD(){
        boolean daHetHan = false;
        Date ngayHienTai = new Date();
        if(this.ngayHetHan.before(ngayHienTai)){
            daHetHan = true;
        }
        return daHetHan;
    }
    @Override
    public void danhGiaBanBuon() {
        if(this.getSoLuongTon()>0 & tinhHSD()==true){
            System.out.println("Danh gia: kho ban");
        }else{
            System.out.println("khong danh gia");
        }
    }
}
