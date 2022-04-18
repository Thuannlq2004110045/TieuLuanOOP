package tieuluancuoiky;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NhapHangHoa {
    
    public static Scanner scanner = new Scanner(System.in);
    SimpleDateFormat simpleDateFormat =  new SimpleDateFormat("dd/MM/yyyy");

    public HangHoa nhapHangHoa(){
        HangHoa hangHoa = null;

        String maHang = null;
        System.out.println("Nhap ma hang hoa: ");
        maHang = scanner.nextLine();
        String tenHang = null;
        System.out.println("Nhap ten hang: ");
        tenHang = scanner.nextLine();
        int soLuongTon = 0;
        System.out.println("Nhap so luong ton kho: ");
        try {
            soLuongTon = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Nhap so thoi ban nhe!!!");
            e.printStackTrace();
        }
        double donGia = 0;
        System.out.println("Nhap don gia: ");
        try {
            donGia = scanner.nextDouble();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Nhap so thoi ban nhe!!");
            e.printStackTrace();
        }

        int loai = 0;
        System.out.println("Ban nhap loai nao? Hang thuc pham -> 1 , Hang sanh su -> 2, Hang dien may -> 3: ");
        try {
            loai = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Nhap so thoi ban nhe!!!");
        }
        if(loai == 1){
            System.out.println("Hang thuc pham ");
            Date ngaySanXuat = null;
            System.out.println("Nhap ngay san xuat: ");
            try {
                ngaySanXuat = chuyenChuoiSangNgay(scanner.nextLine());
            } catch (InputMismatchException e) {
                System.out.println("Nhap so thoi ban nhe!! ");
                e.printStackTrace();
            }

            Date ngayHetHan = null;
            System.out.println("Nhap ngay het han: ");
            try {
                ngayHetHan = chuyenChuoiSangNgay(scanner.nextLine());
            } catch (InputMismatchException e) {
                System.out.println("Nhap so thoi ban nhe!!");
                e.printStackTrace();
            }
            String nhaCungCap = null;
            System.out.println("Nhap nha cung cap: ");
            nhaCungCap = scanner.nextLine();
            hangHoa = new HangThucPham(maHang, tenHang, soLuongTon, donGia, ngaySanXuat, ngayHetHan, nhaCungCap);
        }else if(loai == 2){
            System.out.println("Hang sanh su ");
            String nhaSanXuat = null;
            System.out.println("Nhap nha san xuat: ");
            nhaSanXuat = scanner.nextLine();
            Date ngayNhapKho = null;
            System.out.println("Nhap ngay nhap kho: ");
            try {
                ngayNhapKho = chuyenChuoiSangNgay(scanner.nextLine());
            } catch (InputMismatchException e) {
                System.out.println("nhap so thoi ban nhe");
                e.printStackTrace();
            }
            hangHoa = new HangSanhSu(maHang, tenHang, soLuongTon, donGia, nhaSanXuat, ngayNhapKho);
        }else{
            System.out.println("Hang dien may ");
            int thoiGianBaoHanh = 0;
            System.out.println("Thoi gian bao hanh bao nhieu thang: ");
            try {
                thoiGianBaoHanh = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Nhap so thoi ban nhe!!");
                e.printStackTrace();
            }
            double congSuat =  0;
            System.out.println("Nhap cong suat: ");
            try {
                congSuat = scanner.nextDouble();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Nhap so thoi ban nhe!!!");
                e.printStackTrace();
            }
            hangHoa = new HangDienMay(maHang, tenHang, soLuongTon, donGia, thoiGianBaoHanh, congSuat);
        }
        return hangHoa;
    }

    /**đổi chuỗi (theo chuẩn ngày Việt Nam) sang ngày java */
    public static Date chuyenChuoiSangNgay(String chuoiNgay) {
        //ngày việt nam
        Date date = null;
        /**
         * dd: ngày
         * mm: tháng
         * yyyy: năm
         */
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = simpleDateFormat.parse(chuoiNgay);
        } catch (ParseException e) {
            System.out.println("Nhap ngay/thang/nam bang chuoi nhe!");
            e.printStackTrace();
        }
        return date;
    }

    public HangHoa suaHangHoa(String maHang){
        HangHoa hangHoa = null;

        String tenHang = null;
        System.out.println("Nhap ten hang: ");
        tenHang = scanner.nextLine();
        int soLuongTon = 0;
        System.out.println("Nhap so luong ton kho: ");
        try {
            soLuongTon = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Nhap so thoi ban nhe!!!");
            e.printStackTrace();
        }
        double donGia = 0;
        System.out.println("Nhap don gia: ");
        try {
            donGia = scanner.nextDouble();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Nhap so thoi ban nhe!!");
            e.printStackTrace();
        }

        System.out.println("Ban nhap loai nao? Hang thuc pham -> 1 , Hang sanh su -> 2, Hang dien may -> 3: ");
        int loai = scanner.nextInt();
        scanner.nextLine();
        if(loai == 1){
            System.out.println("Hang thuc pham ");
            Date ngaySanXuat = null;
            System.out.println("Nhap ngay san xuat: ");
            try {
                ngaySanXuat = chuyenChuoiSangNgay(scanner.nextLine());
            } catch (InputMismatchException e) {
                System.out.println("Nhap so thoi ban nhe!! ");
                e.printStackTrace();
            }
            

            Date ngayHetHan = null;
            System.out.println("Nhap ngay het han: ");
            try {
                ngayHetHan = chuyenChuoiSangNgay(scanner.nextLine());
            } catch (InputMismatchException e) {
                System.out.println("Nhap chuoi thoi ban nhe!!");
                e.printStackTrace();
            }
            System.out.println("Nhap nha cung cap: ");
            String nhaCungCap = scanner.nextLine();
            hangHoa = new HangThucPham(maHang, tenHang, soLuongTon, donGia, ngaySanXuat, ngayHetHan, nhaCungCap);
        }else if(loai == 2){
            System.out.println("Hang sanh su ");
            System.out.println("Nhap nha san xuat: ");
            String nhaSanXuat = scanner.nextLine();
            Date ngayNhapKho = null;
            System.out.println("Nhap ngay nhap kho: ");
            try {
                ngayNhapKho = chuyenChuoiSangNgay(scanner.nextLine());
            } catch (InputMismatchException e) {
                System.out.println("nhap so thoi ban nhe");
                e.printStackTrace();
            }
            hangHoa = new HangSanhSu(maHang, tenHang, soLuongTon, donGia, nhaSanXuat, ngayNhapKho);
        }else{
            System.out.println("Hang dien may ");
            int thoiGianBaoHanh = 0;
            System.out.println("Thoi gian bao hanh bao nhieu thang: ");
            try {
                thoiGianBaoHanh = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Nhap so thoi ban nhe!!");
                e.printStackTrace();
            }
            double congSuat =  0;
            System.out.println("Nhap cong suat: ");
            try {
                congSuat = scanner.nextDouble();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Nhap so thoi ban nhe!!!");
                e.printStackTrace();
            }
            hangHoa = new HangDienMay(maHang, tenHang, soLuongTon, donGia, thoiGianBaoHanh, congSuat);
        }
        return hangHoa;
    }
}

