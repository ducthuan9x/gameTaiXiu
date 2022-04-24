package Game;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class TaiXiu {
    public static void main(String[] args) {

        double taiKhoan=100000;
        Scanner sc=new Scanner(System.in);
        Locale lc=new Locale("en","us","us");
        NumberFormat num=NumberFormat.getCurrencyInstance(lc);
        int choice=0;
        int luaChonTaiXiu=0;
        double cuoc=0;
        do {
            System.out.println("------Mời Chọn-----");
            System.out.println("--->Chọn 1 để chơi<---");
            System.out.println("nhấn phím bất kỳ để thoát");
            choice= sc.nextInt();
            if(choice==1){
                System.out.println("---- START-----");
                System.out.println("Tài khoản của bạn = "+ num.format(taiKhoan));

                do {
                    System.out.println("số tiền cược");
                    cuoc=sc.nextDouble();
                    num.format(cuoc);
                }while (cuoc<0||cuoc>taiKhoan);
//   chon tài hoặc xỉu


                do {

                        System.out.println("---- chon Tài hoặc Xỉu");
                        System.out.println("chon ---> 1= XỈU <-- " +
                                "    ---> 2= TÀI <--");
                        luaChonTaiXiu=sc.nextInt();

                }while (luaChonTaiXiu!=1&&luaChonTaiXiu!=2);
            }
//    tung xúc sắc

            Random xucSac=new Random();

            int giaTri1= xucSac.nextInt(5)+1;
            int giaTri2= xucSac.nextInt(5)+1;
            int giaTri3= xucSac.nextInt(5)+1;

//   tính tổng xúc sắc
            int tong=0;
            tong=giaTri1+giaTri2+giaTri3;
            System.out.println("kết quả = "+giaTri1 +","+giaTri2 +","+giaTri3);

            if(tong==3||tong==18){
                System.out.println("BOSS WIN");
                taiKhoan-=taiKhoan;
                System.out.println("Tài khoản của bạn còn lại = "+num.format(taiKhoan));
            }
            else if(tong>=4||tong<11){
                System.out.println("XỈU WIN");
                if(luaChonTaiXiu==1){
                    taiKhoan+=cuoc;
                    System.out.println("Tài khoản của bạn = "+num.format(taiKhoan));
                }
                else {
                    taiKhoan-=cuoc;
                    System.out.println("Tài khoản của bạn = "+num.format(taiKhoan));
                }
            }
            else {
                System.out.println("TÀI WIN");
                if(luaChonTaiXiu==1){
                    taiKhoan-=cuoc;
                    System.out.println("Tài khoản của bạn = "+num.format(taiKhoan));
                }
                else {
                    taiKhoan+=cuoc;
                    System.out.println("Tài khoản của bạn = "+num.format(taiKhoan));
                }
            }

        }while (choice==1);
    }
}
