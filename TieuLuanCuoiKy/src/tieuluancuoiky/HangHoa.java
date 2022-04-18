package tieuluancuoiky;

import java.io.Serializable;

public abstract class HangHoa implements Serializable{
    private String maHang;
    private String tenHang;
    private int soLuongTon;
    private double donGia;
    

    protected String getMaHang() {
        return maHang;
    }

    private void setMaHang(String maHang) {
        if(maHang!=null){
            this.maHang = maHang;
        }else{
            System.out.println("ma hang khong duoc rong");
        }
    }

    protected String getTenHang() {
        return tenHang;
    }

    protected void setTenHang(String tenHang) {
        if(tenHang!=null){
        this.tenHang = tenHang;
        }else{
            System.out.println("Ten hang khong duoc rong!!");
        }
    }

    protected int getSoLuongTon() {
        return soLuongTon;
    }

    protected void setSoLuongTon(int soLuongTon) {
        if(soLuongTon>=0){
        this.soLuongTon = soLuongTon;
        }else{
            System.out.println("So luong ton phai > = 0");
        }
    }

    protected double getDonGia() {
        return donGia;
    }

    protected void setDonGia(double donGia) {
        if(donGia>0){
        this.donGia = donGia;
        }else{
            System.out.println("don gia phai > 0");
        }
    }

    protected HangHoa(String maHang, String tenHang, int soLuongTon, double donGia) {
        this.setMaHang(maHang);
        this.setTenHang(tenHang);
        this.setSoLuongTon(soLuongTon);
        this.setDonGia(donGia);
    }

    protected HangHoa(){}

    @Override
    public String toString() {
        return " [don Gia = " + donGia + ", ma Hang = " + maHang + ", so Luong Ton = " + soLuongTon + ", ten Hang = "
                + tenHang + "]";
    };

    public abstract double tinhVAT();

    public abstract void danhGiaBanBuon();
}
