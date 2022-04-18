package tieuluancuoiky;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DanhSachHangHoa {
    private List<HangHoa> danhSach = new ArrayList<>();

    private int soLuongHangThucPham;
    private int soLuongHangSanhSu;
    private int soLuongHangDienMay;

    public int getSoLuongHangThucPham() {
        return soLuongHangThucPham;
    }

    public int getSoLuongHangSanhSu() {
        return soLuongHangSanhSu;
    }

    public int getSoLuongHangDienMay() {
        return soLuongHangDienMay;
    }

    public boolean soSanhMaHang(String maHang) {
        boolean daTrungMaHang = false;
        for (HangHoa hangHoa : danhSach) {
            if(maHang.equals(hangHoa.getMaHang())) {
                daTrungMaHang = true;
            }
        }
        return daTrungMaHang;
    }

    public void them(HangHoa hangHoa){
        this.danhSach.add(hangHoa);
    }

    public void  inDanhSach() {
        for (HangHoa hangHoa : danhSach) {
            System.out.println(hangHoa);
            System.out.println("");
        }
    }

    public void xoaHangHoa(HangHoa hangHoa) {
        this.danhSach.remove(hangHoa);
    }

    public int timViTriHangHoa(HangHoa hangHoa) {
        int viTri = -1;
        viTri = this.danhSach.indexOf(hangHoa);
        return viTri;
    }

    public void suaHangHoa(int viTri, HangHoa hangHoa) {
        this.danhSach.set(viTri, hangHoa);
    }

    public HangHoa timHangHoaTheoMa(String maHang) {
        HangHoa hangHoa = null;
        for (HangHoa hangHoa1 : danhSach) {
            if (hangHoa1.getMaHang().toString().equalsIgnoreCase(maHang)) {
                hangHoa = hangHoa1;
            }
        }
        return hangHoa;
    }

    public HangThucPham timHangThucPhamTheoMa(String maHang) {
        HangThucPham hangThucPham = null;
        for (HangHoa hangHoa : danhSach) {
            if (hangHoa.getMaHang().toString().equalsIgnoreCase(maHang) && hangHoa instanceof HangThucPham) {
                hangThucPham = (HangThucPham) hangHoa;
            }
        }
        return hangThucPham;
    }

    public HangSanhSu timHangSanhSuTheoMa(String maHang) {
        HangSanhSu hangSanhSu = null;
        for (HangHoa hangHoa : danhSach) {
            if (hangHoa.getMaHang().toString().equalsIgnoreCase(maHang) && hangHoa instanceof HangSanhSu) {
                hangSanhSu = (HangSanhSu) hangHoa;
            }
        }
        return hangSanhSu;
    }

    public HangDienMay timHangDienMayTheoMa(String maHang) {
        HangDienMay hangDienMay = null;
        for (HangHoa hangHoa : danhSach) {
            if (hangHoa.getMaHang().toString().equalsIgnoreCase(maHang) && hangHoa instanceof HangDienMay) {
                hangDienMay = (HangDienMay) hangHoa;
            }
        }
        return hangDienMay;
    }

    public void sapXepHangTheoDonGia() {
        Collections.sort(danhSach, new Comparator<HangHoa>() {
            @Override
            public int compare(HangHoa h1, HangHoa h2) {
                if(h1.getDonGia() < h2.getDonGia()){
                    return -1;
                }else{
                    if (h1.getDonGia() == h2.getDonGia()) {
                        return 0;
                    }else {
                        return 1;
                    }
                }
            }
        });
    }



    public void themKhoHang(){
        danhSach.add(new HangThucPham("1", "gao", 0, 10000.0, NhapHangHoa.chuyenChuoiSangNgay("20/2/2022"), NhapHangHoa.chuyenChuoiSangNgay("20/3/2022"), "gao Sai Gon"));
        danhSach.add(new HangSanhSu("2", "binh hoa", 60, 7000.0, "lo gom bat trang"  ,NhapHangHoa.chuyenChuoiSangNgay("20/3/2022")));
        danhSach.add(new HangDienMay("3", "may lanh", 2, 7000000.0, 12  , 220));
        danhSach.add(new HangThucPham("4", "ca chua", 10, 5000.0, NhapHangHoa.chuyenChuoiSangNgay("2/2/2022"), NhapHangHoa.chuyenChuoiSangNgay("2/5/2022"), "nha may cung cap ca chua"));
        danhSach.add(new HangSanhSu("5", "chen", 100, 15000.0, "lo gom bat trang"  ,NhapHangHoa.chuyenChuoiSangNgay("16/4/2022")));
        danhSach.add(new HangDienMay("6", "tu lanh", 40, 8000000.0, 24  , 220));
        danhSach.add(new HangThucPham("7", "cam", 2, 12000.0, NhapHangHoa.chuyenChuoiSangNgay("1/2/2022"), NhapHangHoa.chuyenChuoiSangNgay("1/3/2022"), "nha may cung cap cam TPHCM"));
        danhSach.add(new HangSanhSu("8", "am tra", 9, 20000.0, "lo gom bat trang"  ,NhapHangHoa.chuyenChuoiSangNgay("30/3/2022")));
        danhSach.add(new HangDienMay("9", "noi com dien", 35, 700000.0, 12  , 280));
        danhSach.add(new HangThucPham("10", "thanh long", 99, 15000.0, NhapHangHoa.chuyenChuoiSangNgay("13/2/2022"), NhapHangHoa.chuyenChuoiSangNgay("31/3/2022"), "nong trai"));
    }

    public void tinhTongSLTungLoai() {

        for (HangHoa hangHoa : danhSach) {
            if (hangHoa instanceof HangThucPham) {
                this.soLuongHangThucPham++;
            } else if(hangHoa instanceof HangSanhSu){
                this.soLuongHangSanhSu++;
            }else{
                this.soLuongHangDienMay++;
            }
        }
        System.out.println("Tong so luong hang thuc pham: " + this.soLuongHangThucPham);
        System.out.println("Tong so luong hang sanh su: " + this.soLuongHangSanhSu);
        System.out.println("Tong so luong hang dien may: " + this.soLuongHangDienMay);
    }

    public int tinhTongSoLuongHangHoa(){
        int sumSoLuongHH =0;
        for(HangHoa hangHoa : danhSach){
            sumSoLuongHH+=1;
        }
        return sumSoLuongHH;
    }

    public void danhGiaBanBuonTungLoaiHang(){
        for (HangHoa hangHoa : danhSach) {
            if (hangHoa instanceof HangThucPham) {
                System.out.println(hangHoa);
                hangHoa.danhGiaBanBuon();
                System.out.println("");
            } else if(hangHoa instanceof HangSanhSu){
                System.out.println(hangHoa);
                hangHoa.danhGiaBanBuon();
                System.out.println("");
            }else if(hangHoa instanceof HangDienMay){
                System.out.println(hangHoa);
                hangHoa.danhGiaBanBuon();
                System.out.println("");
            }
        }
    }

    public void xuatVATTungLoaiHang(){
        double vATThucPham = 0;
        double vATSanhSu = 0;
        double vATDienMay = 0;

        for (HangHoa hangHoa : danhSach) {
            if (hangHoa instanceof HangThucPham) {
                vATThucPham = hangHoa.tinhVAT();
                System.out.println(hangHoa + " ---> VAT: " + vATThucPham);
                System.out.println("");
            } else if(hangHoa instanceof HangSanhSu){
                vATSanhSu = hangHoa.tinhVAT();
                System.out.println(hangHoa + " ---> VAT: " + vATSanhSu);
                System.out.println("");
            }else if(hangHoa instanceof HangDienMay){
                vATDienMay = hangHoa.tinhVAT();
                System.out.println(hangHoa + " ---> VAT: " + vATDienMay);
                System.out.println("");
            }
        }
    }
    
    public void ghiFileDanhSachHangHoa(String tenFile){
        try {
            FileOutputStream outFile = new FileOutputStream(tenFile);
            ObjectOutputStream objOut = new ObjectOutputStream(outFile);
            objOut.writeObject(danhSach);
            objOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void docFileDanhSachHangHoa(String tenFile){
        try {
            FileInputStream inFile = new FileInputStream(tenFile);
            ObjectInputStream objIn = new ObjectInputStream(inFile);
            danhSach = (List) objIn.readObject();
            objIn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
