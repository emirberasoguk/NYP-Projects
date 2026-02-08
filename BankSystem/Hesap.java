public class hesap {
    private String hesap_numarasi;
    private String hesap_sahibi;
    private double hesap_bakiyesi;
    public hesap(String hesap_numarasi, String hesap_sahibi, double hesap_bakiyesi){
        this.hesap_numarasi=hesap_numarasi;
        this.hesap_sahibi=hesap_sahibi;
        this.hesap_bakiyesi=hesap_bakiyesi;
    }
    public void para_yatir(double yatirilan_miktar){
        if(yatirilan_miktar>0){
            this.hesap_bakiyesi+=yatirilan_miktar;
            System.out.println("Başarıyla "+yatirilan_miktar+" TL yüklendi yeni Bakiye = "+ this.hesap_bakiyesi);
        }
        else{
            System.out.println("!!!!!Bankayı mı dolandıracan lan İT!!!!!");
        }
    }
    public void para_cek(double cekilecek_miktar){
        if(cekilecek_miktar<this.hesap_bakiyesi){
            if(cekilecek_miktar>0){
                this.hesap_bakiyesi-=cekilecek_miktar;
                System.out.println("Başarıyla "+cekilecek_miktar+" TL Çekildi" );// Buradan Devamkeeee
            }
            else{
                System.out.println("La ooollluummm sıfırdan küçük parayı nerene sokacan");
            }
        }
        else{
            System.out.println("!!!!!O  kadar Paran Yok Ki FAKIR SENİ!!!!!");
        }
    }
    public void bilgi_goster(){
        System.out.println("---===HESAP_BİLGİLERİ===---\nHesap Sahibi:"+this.hesap_sahibi+"\nHesap Numarası:"+this.hesap_numarasi+"\nBakiye:"+this.hesap_bakiyesi);
    }
    public String hesap_sahibi_alici(){
        return this.hesap_sahibi;
    }
}
