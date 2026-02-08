import java.util.Scanner;

public class EnBuyukSayiyiBulmaca {

	public static void main(String[] args) {
	int sayi1;
	int sayi2;
	int sayi3;
	int buyuk;
	Scanner scanner = new Scanner(System.in);
	System.out.println("Dürzücümmm!!!\nNasilsin?????\nSen Bana Uc Sayi Ver Ben Sana En Buyugunu Vericem Zaten.........\n");
	System.out.print("Birinci Sayi \n: ");
	sayi1= scanner.nextInt();
	System.out.print("Ikinci Sayi \n: ");
	sayi2= scanner.nextInt();
	System.out.print("Ucuncu Sayi \n: ");
	sayi3= scanner.nextInt();
	scanner.close();
	buyuk = sayi1;
		if(buyuk<sayi2){
			buyuk=sayi2;
			if(buyuk<sayi3){
				buyuk=sayi3;
			}
		}
		if(buyuk<sayi3){
			buyuk=sayi3;
		}
		System.out.println("En Buyuk Sayi Bu\n= "+ buyuk);
	}
	
}
