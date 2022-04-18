package tieuluancuoiky;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HangHoaTestDrive {
    public static void main(String[] args) {
        int luaChon;
        Scanner scanner = new Scanner(System.in);

        DanhSachHangHoa danhSachHangHoa = new DanhSachHangHoa();
        System.out.println("Kho hang hoa");
        danhSachHangHoa.themKhoHang();
        danhSachHangHoa.inDanhSach();
        do{
            System.out.println("---------------------------------------");
            System.out.println("1. Them hang hoa");
            System.out.println("2. In danh sach hang hoa");
            System.out.println("3. Xoa hang hoa theo ma");
            System.out.println("4. Sua hang hoa theo ma");
            System.out.println("5. Tim kiem hang hoa theo ma");
            System.out.println("6. Sap xep danh sach hang hoa tang dan theo don gia");
            System.out.println("7. Thong ke hang hoa");
            System.out.println("8. Bao cao hang hoa");
            System.out.println("9. Ghi danh sach ra File");
            System.out.println("10. Doc danh sach tu file");
            System.out.println("11. Thoat chuong trinh");
            System.out.println("");
            luaChon = scanner.nextInt();
            scanner.nextLine();
            System.out.println("---------->>");
            switch(luaChon)
            {
                case 1:
                String nhapTiep = " ";

                NhapHangHoa nhapHangHoa = new NhapHangHoa();

                do {
                    HangHoa hangHoa = nhapHangHoa.nhapHangHoa();
                    if(danhSachHangHoa.soSanhMaHang(hangHoa.getMaHang())== false) {
                    danhSachHangHoa.them(hangHoa);
                    }else{
                        System.out.println("Khong them duoc do trung ma hang!!");
                    }
                    System.out.println("Ban co muon nhap tiep hay khong Y/N");
                    nhapTiep = nhapHangHoa.scanner.nextLine();
                }while(nhapTiep.equalsIgnoreCase("Y"));
                break;

                case 2:
                danhSachHangHoa.inDanhSach();
                break;

                case 3:
                System.out.println("Nhap ma hang can xoa: ");
                String maHangXoa = scanner.nextLine();
                HangHoa hangHoaXoa = danhSachHangHoa.timHangHoaTheoMa(maHangXoa);
                danhSachHangHoa.xoaHangHoa(hangHoaXoa);
                break;

                case 4:
                NhapHangHoa suaHangHoa = new NhapHangHoa();
                System.out.println("Nhap ma hang can sua: ");
                String maHangSua = scanner.nextLine();
                HangHoa hangHoaSua = danhSachHangHoa.timHangHoaTheoMa(maHangSua);
                int viTriSua = danhSachHangHoa.timViTriHangHoa(hangHoaSua);
                hangHoaSua = suaHangHoa.suaHangHoa(maHangSua);
                danhSachHangHoa.suaHangHoa(viTriSua, hangHoaSua);
                break;

                case 5: 
                int luaChon1 = 0;
                do{
                    System.out.println("  ===================================================");
                    System.out.println(" =  1. Tim hang hoa theo ma.                        =");
                    System.out.println(" =  2. Tim hang thuc pham theo ma.                  =");
                    System.out.println(" =  3. Tim hang sanh su theo ma.                    =");
                    System.out.println(" =  4. Tim hang dien may theo ma.                   =");
                    System.out.println(" =  5. Thoat ra menu chinh.                         =");
                    System.out.println("  ===================================================");
                    System.out.print("Lua chon: ");
                    try {
                        luaChon1 = scanner.nextInt();
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("nhap so thoi ban nhe!!");
                    }
                    switch(luaChon1){
                        case 1:
                        System.out.println("Nhap ma hang can tim: ");
                        String maHangTim = scanner.nextLine();
                        HangHoa hangHoa = danhSachHangHoa.timHangHoaTheoMa(maHangTim);
                        System.out.println(hangHoa);
                        break;
                        case 2: 
                        System.out.println("Nhap ma hang thuc pham can tim: ");
                        String maHangThucPhamTim = scanner.nextLine();
                        HangHoa hangHoaThucPham = danhSachHangHoa.timHangThucPhamTheoMa(maHangThucPhamTim);
                        if(hangHoaThucPham!=null)
                        System.out.println(hangHoaThucPham);
                        else
                        System.out.println("Khong co hang thuc pham co ma " + maHangThucPhamTim);
                        break;
                        case 3:
                        System.out.println("Nhap ma hang sanh su can tim: ");
                        String maHangSanhSuTim = scanner.nextLine();
                        HangHoa hangHoaSanhSu = danhSachHangHoa.timHangSanhSuTheoMa(maHangSanhSuTim);
                        if(hangHoaSanhSu!=null)
                        System.out.println(hangHoaSanhSu);
                        else
                        System.out.println("Khong co hang sanh su co ma " + maHangSanhSuTim);
                        break;
                        case 4:
                        System.out.println("Nhap ma hang dien may can tim: ");
                        String maHangDienMayTim = scanner.nextLine();
                        HangHoa hangHoaDienMay = danhSachHangHoa.timHangDienMayTheoMa(maHangDienMayTim);
                        if(hangHoaDienMay!=null)
                        System.out.println(hangHoaDienMay);
                        else
                        System.out.println("Khong co hang dien may co ma " + maHangDienMayTim);
                        break;
                        case 5:
                        luaChon1 = 5;
                    }
                }while(luaChon1 <=4);
                break;

                case 6:
                danhSachHangHoa.sapXepHangTheoDonGia();
                danhSachHangHoa.inDanhSach();
                break;

                case 7:
                int luaChon3 = 0;
                do{
                    System.out.println("  ===================================================");
                    System.out.println(" =  1. Tong so luong hang hoa trong kho.           =");
                    System.out.println(" =  2. Tong so luong tung loai hang.                =");
                    System.out.println(" =  3. Thoat ra menu chinh.                         =");
                    System.out.println("  ===================================================");
                    System.out.print("Lua chon: ");
                    try {
                        luaChon3 = scanner.nextInt();
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("nhap so thoi ban nhe!!");
                    }
                    switch(luaChon3){
                        case 1:
                        System.out.println("Tong so luong hang hoa: " + danhSachHangHoa.tinhTongSoLuongHangHoa());
                        break;
                        case 2: 
                        danhSachHangHoa.tinhTongSLTungLoai();
                        break;
                        case 3:
                        luaChon3 = 3;
                    }
                }while(luaChon3 <=2);
                break;

                case 8:
                int luaChon4 = 0;
                do{
                    System.out.println("  ===================================================");
                    System.out.println(" =  1. Danh gia ban buon.                           =");
                    System.out.println(" =  2. Xuat danh sach VAT.                          =");
                    System.out.println(" =  3. Thoat ra menu chinh.                         =");
                    System.out.println("  ===================================================");
                    System.out.print("Lua chon: ");
                    try {
                        luaChon4 = scanner.nextInt();
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("nhap so thoi ban nhe!!");
                    }
                    switch(luaChon4){
                        case 1:
                        danhSachHangHoa.danhGiaBanBuonTungLoaiHang();
                        break;
                        case 2: 
                        danhSachHangHoa.xuatVATTungLoaiHang();
                        break;
                        case 3:
                        luaChon4 = 3;
                    }
                }while(luaChon4 <=2);
                break;

                case 9:
                System.out.println("Nhap ten file muon ghi: ");
                String tenFile = scanner.nextLine();
                danhSachHangHoa.ghiFileDanhSachHangHoa(tenFile);
                break;

                case 10:
                System.out.println("Nhap ten file muon doc: ");
                String File = scanner.nextLine();
                danhSachHangHoa.docFileDanhSachHangHoa(File);
                break;

                case 11: 
                System.exit(0);
            }
        }while(true);
    }
}
