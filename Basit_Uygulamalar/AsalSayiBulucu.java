import java.util.Scanner;
public class asal_sayi_bulucu{
	
	public static void main(String[] args){

		int aranan_sayi,menu;
		boolean dongu = true,asal_mi=true;
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n****************************************\nAsal Sayi Bulucu Programına Hos Geldiniz\n");

		while(dongu){
			System.out.println("\n****************************************\nMENU\n*****************************************\n-1-CIKIS\n-2-Asal sayi Bulucu\n");
			menu = scanner.nextInt();
			
			switch(menu){
				case 1:
					System.out.println("\n***************************************\nCIKIS YAPILIYOR\n---------------\n----------\n------\n---\n-\n\n**\n***\n**\n");
					dongu = false;
					break;
				case 2:
					System.out.print("\nHadi Asal Olabilecegini Dusundugun Sayiyi yaz bakalım\n: ");
					aranan_sayi = scanner.nextInt();
					
					if(aranan_sayi>2){
					
						for(int i=2;i<aranan_sayi;i++){
						
							if(aranan_sayi%i==0){
								System.out.println("\nAsal Sayi Degildir!!!\n");
								asal_mi=false;
								dongu = false;
								break;
							}
						}

						if(asal_mi){
							System.out.println("Sayi Asaldir!!!");
						}
						
					}
					break;
				default:
					System.out.println("\n***************************************\nHATALI GIRIS\n---------------\n----------\n------\n---\n-\n\n**\n***\n**\n");
			}
		}
	scanner.close();
	}
}
