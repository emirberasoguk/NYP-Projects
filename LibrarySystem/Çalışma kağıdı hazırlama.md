# 🧠 Java Çalışma Kağıdı

### 🧩 **Soru 28:**

**ArrayList’in yalnızca nesneleri tutması kuralını ve “sarmalayıcı” (wrapper) sınıfların bu bağlamdaki rolünü açıklayın.**

**Kısa Özet:**  
ArrayList sadece nesne tutar; ilkel (primitive) türler doğrudan saklanamaz.

**Kısa Cevap:**  
ArrayList yalnızca nesneleri depolayabilir. Primitive türleri kullanmak için bunların wrapper (ör. `Integer`, `Double`) sınıfları kullanılır.

**Detaylı Cevap:**  
Java’daki `ArrayList` sınıfı, yalnızca **nesne referanslarını** saklayabilir. Bu nedenle `int`, `double` gibi ilkel türler `ArrayList` içinde doğrudan kullanılamaz.  
Bu sorunu çözmek için **wrapper sınıflar** devreye girer (`Integer`, `Double`, `Boolean` vb.).  
Java 5 ile gelen **autoboxing/unboxing** sayesinde, `ArrayList<Integer> list = new ArrayList<>(); list.add(5);` gibi ifadeler otomatik olarak `int` → `Integer` dönüşümünü yapar.

___

### 🧩 **Soru 29:**

**ArrayList’in başlıca işlemlerini kavramsal düzeyde karşılaştırın.**

**Kısa Özet:**  
ArrayList dinamik dizidir; ekleme, kaldırma, erişim ve gezinme işlemleri farklı maliyetlere sahiptir.

**Kısa Cevap:**  
Ekleme ve kaldırma orta performanslıdır, rasgele erişim hızlıdır, dizilere göre dinamik boyut avantajı vardır.

**Detaylı Cevap:**  
ArrayList işlemleri:

-   **Ekleme (add):** Ortalama O(1), ancak yeniden boyutlandırma gerekirse O(n).
    
-   **Kaldırma (remove):** O(n) — öğeler kaydırılır.
    
-   **Erişim (get):** O(1) — indeksle erişim.
    
-   **Arama (contains):** O(n).
    
-   **Gezinti (for-each, iterator):** O(n).  
    Dizilere göre en büyük avantajı **dinamik boyutlanabilmesi** ve **hazır metotlar** sunmasıdır.
    

___

### 🧩 **Soru 30:**

**ArrayList’te mantıksal boyut ile kapasite ayrımını açıklayın.**

**Kısa Özet:**  
Mantıksal boyut eleman sayısı, kapasite ise rezerve edilen alan miktarıdır.

**Kısa Cevap:**  
Size (mantıksal boyut) eleman sayısını, capacity (kapasite) ise depolama alanını temsil eder.

**Detaylı Cevap:**  
ArrayList’in arkasında bir dizi bulunur.

-   **Size:** Gerçekte kaç eleman bulunduğunu gösterir.
    
-   **Capacity:** Şu anda bellekte kaç eleman için yer ayrıldığını gösterir.  
    Liste dolduğunda kapasite artırılır (genellikle %50 civarı). Bu da performans maliyeti doğurur.  
    Bu nedenle yüksek hacimli işlemlerde kapasite önceden belirlenebilir (`new ArrayList<>(1000)`).
    

___

### 🧩 **Soru 31:**

**Vector sınıfının büyüyüp küçülebilme özelliğini ve “size” – “capacity” ayrımını açıklayın.**

**Kısa Özet:**  
Vector de dinamik büyüyen bir listedir; “size” mevcut eleman sayısı, “capacity” ayrılmış alanı gösterir.

**Kısa Cevap:**  
Vector, kapasitesini doldukça artırır (genellikle iki kat). “Size” doluluk oranını, “capacity” rezerve edilen alanı gösterir.

**Detaylı Cevap:**  
Vector, eski bir Java koleksiyonudur. ArrayList gibi dinamik olarak genişler.

-   **size():** O anki eleman sayısı.
    
-   **capacity():** Mevcut dizinin alabileceği maksimum eleman sayısı.  
    Varsayılan olarak kapasite dolunca otomatik artar. Ancak fazla büyütmek bellek kullanımını artırır.  
    Modern projelerde `ArrayList` tercih edilir çünkü Vector **synchronized** olduğu için yavaştır.
    

___

### 🧩 **Soru 32:**

**Dizi ve ArrayList/Vector arasında seçim yaparken nasıl karar verilir?**

**Kısa Özet:**  
Statik vs dinamik yapı, performans ve kullanım kolaylığına göre seçim yapılır.

**Kısa Cevap:**  
Sabit boyut ve performans önceliği varsa dizi, dinamik büyüme ve kolaylık gerekliyse ArrayList/Vector kullanılır.

**Detaylı Cevap:**

-   **Dizi:**
    
    -   Sabit boyut, daha az bellek kullanımı.
        
    -   Hızlı erişim (O(1)).
        
    -   Boyut sabit, genişletilemez.
        
-   **ArrayList:**
    
    -   Dinamik, kolay ekleme/çıkarma.
        
    -   Nesne tabanlı çalışır.
        
-   **Vector:**
    
    -   ArrayList gibidir ama thread-safe’dir.  
        Kısaca: _“Performans + sabit boyut → Array, Dinamiklik + kolaylık → ArrayList.”_
        

___

### 🧩 **Soru 33:**

**Dizilerle birlikte ArrayList/Vector kullanımı örnek bir stratejiyle açıklayın.**

**Kısa Özet:**  
Dizi sabit veriyi tutabilir, ArrayList dinamik veriyi yönetebilir.

**Kısa Cevap:**  
Diziler veriyi saklamak, ArrayList ise işlem yapmak için birlikte kullanılabilir.

**Detaylı Cevap:**  
Bir uygulamada sabit büyüklükteki veriler (örneğin günlük ölçümler) dizi ile tutulabilir,  
bu verilerin dinamik olarak filtrelenmiş veya işlenmiş hâli ArrayList’e aktarılabilir.  
Örnek:

```java
int[] data = {1,2,3,4};
List<Integer> list = Arrays.stream(data).boxed().collect(Collectors.toList());
```

Bu şekilde dizi → liste dönüşümü yapılır.  
Büyük projelerde bu geçiş **veri akışı yönetimi** ve **API uyumu** açısından kullanılır.

___

### 🧩 **Soru 34:**

**char ile String arasındaki fark nedir?**

**Kısa Özet:**  
char tek karakterdir, String karakter dizisidir.

**Kısa Cevap:**  
`char` ilkel türdür, `String` bir sınıftır. String üzerinde metotlar çağrılabilir, char üzerinde çağrılamaz.

**Detaylı Cevap:**

-   `char`: 16-bit Unicode karakterdir (`'A'`, `'b'`).
    
-   `String`: `char[]` temelli bir sınıftır (`"Merhaba"`).  
    String nesneleri immutable’dır, yani değiştirilemez.  
    Örnek:
    

```java
char c = 'A';
String s = "A";
System.out.println(s.toLowerCase()); // Geçerli
// c.toLowerCase() geçersiz, çünkü char ilkel türdür.
```

___

### 🧩 **Soru 35:**

**substring ve concat farkını açıklayın.**

**Kısa Özet:**  
substring alt metin çıkarır, concat metinleri birleştirir.

**Kısa Cevap:**  
`substring` bir metnin parçasını döndürür, `concat` iki metni birleştirir.

**Detaylı Cevap:**

-   `substring(begin, end)` → belirtilen aralıktaki alt metni verir.
    
-   `concat(String s)` → mevcut metne yeni metin ekler.  
    Örnek:
    

```java
String s = "Java";
System.out.println(s.substring(1,3)); // "av"
System.out.println(s.concat(" Rocks")); // "Java Rocks"
```

`+` operatörü de `concat` gibi çalışır.

___

### 🧩 **Soru 36:**

**compareTo metodu ne döndürür?**

**Kısa Özet:**  
String’leri alfabetik olarak karşılaştırır.

**Kısa Cevap:**  
compareTo negatif, sıfır veya pozitif değer döndürür.

**Detaylı Cevap:**  
`str1.compareTo(str2)` →

-   <0 → `str1`, `str2`’den önce gelir.
    
-   0 → eşit.
    
-   > 0 → `str1`, `str2`’den sonra gelir.  
    > Karşılaştırma Unicode değerlerine göre yapılır:
    

```java
"Apple".compareTo("Banana") // -1 civarı
```

___

### 🧩 **Soru 37:**

**Bir String’i char\[\] dizisine çeviren metodun ismi nedir?**

**Kısa Özet:**  
String karakterlerini diziye dönüştürür.

**Kısa Cevap:**  
`toCharArray()` metodu kullanılır.

**Detaylı Cevap:**  
`String` sınıfının `toCharArray()` metodu, metni karakter dizisine dönüştürür:

```java
String s = "Hello";
char[] chars = s.toCharArray();
```

Bu sayede karakter düzeyinde işlemler (sayma, şifreleme, karşılaştırma) yapılabilir.

___

### 🧩 **Soru 38:**

**“+” ile birleştirmenin (concatenation) ne tür durumlarda tercih edildiğini ve metin ile sayısal değerlerin birlikte yazdırılmasında nasıl kullanıldığını açıklayın.**

**Kısa Özet:**  
Metinleri birleştirmek veya metin-sayı karışık çıktı almak için kullanılır.

**Kısa Cevap:**  
“+” operatörü metinleri birleştirir, sayılarla birlikte kullanıldığında sayıyı otomatik olarak string’e çevirir.

**Detaylı Cevap:**  
Java’da `+` operatörü iki `String` arasında kullanılırsa **concatenation** işlemi yapar.  
Eğer bir operand `String`, diğeri sayısal bir türse, sayı **otomatik olarak string’e çevrilir (autoboxing)**.  
Örnek:

```java
int x = 10;
System.out.println("Sonuç: " + x); // "Sonuç: 10"
```

Arka planda bu işlem `StringBuilder` kullanarak birleştirme yapar.  
Yoğun birleştirme işlemlerinde performans için `StringBuilder` tercih edilir.

___

### 🧩 **Soru 39:**

**equals ile == karşılaştırmalarının farklarını açıklayın.**

**Kısa Özet:**  
`==` adresi, `equals()` içeriği karşılaştırır.

**Kısa Cevap:**  
`==` iki nesnenin hafızadaki adreslerini karşılaştırır, `equals()` içerik eşitliğini kontrol eder.

**Detaylı Cevap:**  
Java’da:

```java
String a = new String("Test");
String b = new String("Test");
System.out.println(a == b); // false
System.out.println(a.equals(b)); // true
```

`==` bellekteki referans adresini kontrol eder.  
`equals()` metodu `String` sınıfında override edilmiştir, bu nedenle metin içeriğini karşılaştırır.  
**Not:** İlkel türlerde (`int`, `double`) `==` değer karşılaştırması yapar.

___

### 🧩 **Soru 40:**

**Kaçış (escape) karakterlerinin işlevi nedir?**

**Kısa Özet:**  
Metin içinde özel karakterleri göstermek için kullanılır.

**Kısa Cevap:**  
Escape karakteri (`\`) özel sembolleri temsil eder, örneğin `\n`, `\t`, `\"`.

**Detaylı Cevap:**  
Kaçış karakteri `\`, normalde yazılamayan veya özel anlam taşıyan karakterleri eklemeyi sağlar.  
Örnekler:

-   `\n` → yeni satır
    
-   `\t` → tab boşluğu
    
-   `\\` → ters eğik çizgi
    
-   `\"` → çift tırnak  
    Örnek:
    

```java
System.out.println("Merhaba\nDünya");
```

Çıktı iki satır olur.

___

### 🧩 **Soru 41:**

**Aşağıdaki metotların ne işe yaradığını açıklayın: equals, equalsIgnoreCase, startsWith, endsWith, contains.**

**Kısa Özet:**  
String içeriklerini farklı şekillerde karşılaştırır veya arar.

**Kısa Cevap:**

-   `equals`: Tam eşitlik
    
-   `equalsIgnoreCase`: Büyük/küçük harf duyarsız eşitlik
    
-   `startsWith`: Belirli önekle başlar mı
    
-   `endsWith`: Belirli sonekle biter mi
    
-   `contains`: Alt metin içerir mi
    

**Detaylı Cevap:**

```java
String s = "Java Programlama";
s.equals("java programlama"); // false
s.equalsIgnoreCase("java programlama"); // true
s.startsWith("Java"); // true
s.endsWith("lama"); // true
s.contains("gram"); // true
```

Bu metotlar kullanıcı girişlerini doğrulamada ve metin aramada sıkça kullanılır.

___

### 🧩 **Soru 42:**

**indexOf metodunun döndürdüğü değerin anlamı nedir?**

**Kısa Özet:**  
Aranan alt metnin başlangıç indeksini döndürür.

**Kısa Cevap:**  
Bulursa ilk indeksini, bulamazsa `-1` döner.

**Detaylı Cevap:**  
`indexOf()` bir karakterin veya alt metnin bulunduğu ilk pozisyonu verir:

```java
String s = "Merhaba";
System.out.println(s.indexOf('a')); // 4
System.out.println(s.indexOf("ha")); // 3
System.out.println(s.indexOf("x")); // -1
```

Bu değer, koşul kontrolünde veya substring işlemlerinde kullanılabilir.

___

### 🧩 **Soru 43:**

**Sayısal metin ve metinden sayıya dönüşümlerde kullanılan yöntemler nelerdir?**

**Kısa Özet:**  
Metni sayıya `parse`, sayıyı metne `String.valueOf()` veya `toString()` ile dönüştürürüz.

**Kısa Cevap:**

-   Sayıya: `Integer.parseInt("5")`
    
-   Metne: `String.valueOf(5)` veya `Integer.toString(5)`
    

**Detaylı Cevap:**

```java
String s = "42";
int x = Integer.parseInt(s);
String str = String.valueOf(x);
```

Sayısal dönüşümler yapılırken **NumberFormatException** hatasına dikkat edilmelidir.  
Kullanıcı girdileri mutlaka doğrulanmalıdır.

___

### 🧩 **Soru 44:**

**Bir koşul ifadesinin “doğruluk değeri” ne anlama gelir?**

**Kısa Özet:**  
Koşulun sonucu `true` veya `false` olur.

**Kısa Cevap:**  
Doğruluk değeri, koşulun mantıksal sonucudur (boolean türünde).

**Detaylı Cevap:**  
Bir `if`, `while`, `for` koşulu, **boolean** türünde değerlendirilir.  
Örnek:

```java
int x = 10;
if (x > 5) // true
```

`x > 5` ifadesi `true` dönerse blok çalışır.  
Bu durum, programın akışını yönlendiren temel mekanizmadır.

___

### 🧩 **Soru 45:**

**if ile if–else arasındaki fark nedir?**

**Kısa Özet:**  
`if` tek başına koşulu test eder, `if–else` alternatif bir yol tanımlar.

**Kısa Cevap:**  
`if` koşul doğruysa blok çalışır; `if–else` yanlışsa başka bir blok çalıştırır.

**Detaylı Cevap:**

```java
if (x > 0)
   System.out.println("Pozitif");
else
   System.out.println("Negatif veya sıfır");
```

`if` yalnızca koşul doğruysa yürütülür, `else` ise aksi durumda çalışır.  
Karar yapısında **kontrol akışını** ikiye ayırır.

___

### 🧩 **Soru 46:**

**“Ardışık bağımsız if” ile “if–else zinciri” arasındaki fark nedir?**

**Kısa Özet:**  
Bağımsız `if`’ler tüm koşulları test eder, `if–else if` zinciri ilk doğru koşulda durur.

**Kısa Cevap:**  
Bağımsız `if`: tüm koşullar ayrı ayrı kontrol edilir.  
`if–else if`: yalnızca bir blok çalışır.

**Detaylı Cevap:**

```java
if (x > 0) ...
if (x > 5) ... // Bağımsız
```

Her ikisi de çalışabilir.  
Ama:

```java
if (x > 0) ...
else if (x > 5) ...
```

İlk koşul doğruysa diğerleri test edilmez.  
Bu fark, performans ve mantık açısından önemlidir.

___

### 🧩 **Soru 47:**

**Koşullarda mantıksal VE/VEYA/DEĞİL (&&, ||, !) operatörlerinin denetim akışına etkisini açıklayın.**

**Kısa Özet:**  
Bu operatörler birden fazla koşulu birleştirir.

**Kısa Cevap:**

-   `&&`: Tüm koşullar doğruysa
    
-   `||`: En az biri doğruysa
    
-   `!`: Koşulun tersini alır
    

**Detaylı Cevap:**

```java
if (x > 0 && y > 0) // her ikisi de doğruysa
if (x > 0 || y > 0) // biri doğruysa
if (!(x > 0)) // koşulun tersi
```

`&&` ve `||` operatörleri **kısa devre (short-circuit)** mantığıyla çalışır;  
örneğin `&&`'de ilk koşul false ise ikinciyi kontrol etmez.  
Bu performans ve güvenlik açısından avantaj sağlar.

___

### 🧩 **Soru 48:**

**Koşul ifadelerinde “öncelik” kavramı neyi ifade eder?**

**Kısa Özet:**  
Birden fazla operatör varsa, hangisinin önce değerlendirileceğini belirler.

**Kısa Cevap:**  
Operatör önceliği, ifadelerde işlemlerin sırasını belirler; yüksek öncelikli işlemler önce yapılır.

**Detaylı Cevap:**  
Java’da işlem sırası matematikteki gibidir.  
Örnek:

```java
int a = 5 + 3 * 2; // a = 11
```

`*` işlemi `+`’dan daha yüksek önceliğe sahip olduğu için önce çarpma yapılır.  
Karar ifadelerinde karmaşıklığı önlemek için **parantez kullanımı** önerilir:

```java
if ((x > 5 && y < 10) || z == 3)
```

___

### 🧩 **Soru 49:**

**switch deyimi hangi tür değerlerle kullanılabilir?**

**Kısa Özet:**  
Sabit değerler içeren karşılaştırmalarda kullanılır.

**Kısa Cevap:**  
`byte`, `short`, `int`, `char`, `String` ve `enum` türleriyle kullanılabilir.

**Detaylı Cevap:**  
Java 7’den itibaren `String` de desteklenir.  
Örnek:

```java
switch (day) {
   case "Monday": ...
   case "Tuesday": ...
   default: ...
}
```

Her `case` sabit bir değer olmalıdır (değişken veya aralık olamaz).  
`break` komutu, akışı bir sonraki case’e düşmeden sonlandırır.

___

### 🧩 **Soru 50:**

**switch deyiminde “break” ve “default” anahtar sözcüklerinin işlevlerini açıklayın.**

**Kısa Özet:**  
`break` akışı durdurur, `default` eşleşme olmazsa çalışır.

**Kısa Cevap:**  
`break` sonraki case’lerin çalışmasını engeller, `default` hiçbir case eşleşmezse devreye girer.

**Detaylı Cevap:**

```java
switch (x) {
  case 1: System.out.println("Bir"); break;
  case 2: System.out.println("İki"); break;
  default: System.out.println("Diğer");
}
```

Eğer `break` unutulursa, “fall-through” olur ve alttaki case’ler de yürür.  
`default` genellikle en sonda yer alır ancak zorunlu değildir.

___

### 🧩 **Soru 51:**

**while döngüsünün çalışma mantığı nedir?**

**Kısa Özet:**  
Koşul doğru olduğu sürece tekrarlanır.

**Kısa Cevap:**  
`while`, her tur öncesinde koşulu test eder ve koşul doğru oldukça döngü devam eder.

**Detaylı Cevap:**

```java
int i = 0;
while (i < 5) {
   System.out.println(i);
   i++;
}
```

Eğer koşul başta false ise döngü hiç çalışmaz.  
Bu nedenle **ön testli döngü** olarak bilinir.

___

### 🧩 **Soru 52:**

**do–while döngüsünün farkı nedir?**

**Kısa Özet:**  
Koşul sonda test edilir, en az bir kez çalışır.

**Kısa Cevap:**  
`do–while`, koşul yanlış olsa bile döngü gövdesini bir kez çalıştırır.

**Detaylı Cevap:**

```java
int x = 5;
do {
   System.out.println(x);
} while (x < 0);
```

Bu örnekte koşul yanlış olsa bile çıktı verir.  
Bu yüzden kullanıcıdan veri alma gibi durumlarda sıkça tercih edilir.

___

### 🧩 **Soru 53:**

**for döngüsünün yapısı ve avantajı nedir?**

**Kısa Özet:**  
Başlatma, koşul ve artırma tek satırda toplanır.

**Kısa Cevap:**  
`for` döngüsü sayaç temellidir; başlangıç, bitiş ve adım net biçimde belirlenir.

**Detaylı Cevap:**

```java
for (int i = 0; i < 5; i++) {
   System.out.println(i);
}
```

Tüm bileşenleri tek satırda olduğu için okunabilirlik yüksektir.  
Ayrıca `for-each` versiyonu da vardır:

```java
for (int x : list)
```

___

### 🧩 **Soru 54:**

**for ve while döngülerinin farkları nelerdir?**

**Kısa Özet:**  
`for` genellikle sayaçlı, `while` koşul temelli döngüler içindir.

**Kısa Cevap:**  
`for`: tekrar sayısı belli olduğunda,  
`while`: tekrar sayısı belirsiz olduğunda tercih edilir.

**Detaylı Cevap:**

-   **for**: sayaç değişkeni içerir, kodu kısaltır.
    
-   **while**: koşul dışında kontrol sağlanır, esnektir.  
    Örnek:
    

```java
while (!input.equals("exit")) { ... }
```

`while` genelde kullanıcı etkileşiminde, `for` sayma işlemlerinde kullanılır.

___

### 🧩 **Soru 55:**

**break ve continue ifadelerinin farkını açıklayın.**

**Kısa Özet:**  
`break` döngüyü bitirir, `continue` sıradaki adıma geçer.

**Kısa Cevap:**  
`break` döngüyü tamamen sonlandırır, `continue` yalnızca mevcut turu atlar.

**Detaylı Cevap:**

```java
for (int i = 0; i < 5; i++) {
   if (i == 2) continue; // 2 atlanır
   if (i == 4) break; // döngü biter
   System.out.println(i);
}
```

Bu tür kontroller özellikle arama ve filtreleme algoritmalarında faydalıdır.

___

### 🧩 **Soru 56:**

**İç içe döngü (nested loop) nedir ve ne zaman kullanılır?**

**Kısa Özet:**  
Bir döngü içinde başka bir döngü bulunmasıdır.

**Kısa Cevap:**  
Çok boyutlu veri yapılarında veya tekrar eden işlemlerde kullanılır.

**Detaylı Cevap:**

```java
for (int i = 0; i < 3; i++) {
   for (int j = 0; j < 2; j++) {
      System.out.println(i + "," + j);
   }
}
```

İç içe döngüler matris işlemleri, tablo üretimi veya desen çizimlerinde yaygındır.  
Ancak karmaşıklığı artırır; büyük veri üzerinde dikkatli kullanılmalıdır.

___

### 🧩 **Soru 57:**

**JVM (Java Virtual Machine) nedir ve görevleri nelerdir?**

**Kısa Özet:**  
Java programlarının çalıştığı sanal ortamdır.

**Kısa Cevap:**  
JVM, derlenen bytecode’u yorumlayarak her platformda çalışmasını sağlar.

**Detaylı Cevap:**  
JVM’in görevleri:

1.  **Bytecode’u çalıştırmak**
    
2.  **Bellek yönetimi (Garbage Collector)**
    
3.  **Güvenlik denetimi**
    
4.  **Platform bağımsızlık**  
    Java’nın “Write once, run anywhere” ilkesini mümkün kılar.  
    Derlenen `.class` dosyalarını alır, uygun donanımda çalıştırır.

___

### 🧩 Soru 58:
**Kısa Özet:**  
Java’da “extends” anahtar kelimesi ne işe yarar?

**Kısa Cevap:**  
Bir sınıfın başka bir sınıfı miras almasını (kalıtım yapmasını) sağlar.

**Detaylı Cevap:**  
`extends`, bir sınıfın başka bir sınıftan türetilmesini sağlar. Alt sınıf (subclass), üst sınıfın (superclass) özelliklerini ve metotlarını devralır.  
Örnek:
```java
class Animal {}
class Dog extends Animal {}
```

## Burada `Dog`, `Animal` sınıfının tüm özelliklerini miras alır. Bu, kod tekrarını azaltır ve yeniden kullanılabilirliği artırır.

### 🧩 Soru 59:

**Kısa Özet:**  
Java’da “super” anahtar kelimesinin amacı nedir?

**Kısa Cevap:**  
Üst sınıfa (superclass) erişim sağlar.

**Detaylı Cevap:**  
`super`, alt sınıfın üst sınıftaki metot, değişken veya constructor’a erişmesini sağlar.  
Örnek:

```java
class Animal {
    Animal() { System.out.println("Animal created"); }
}
class Dog extends Animal {
    Dog() {
        super(); // Animal constructor'ını çağırır
        System.out.println("Dog created");
    }
}
```

___

### 🧩 Soru 60:

**Kısa Özet:**  
Polymorphism (çok biçimlilik) nedir?

**Kısa Cevap:**  
Aynı metot isminin farklı şekillerde davranabilmesidir.

**Detaylı Cevap:**  
Polymorphism, bir nesnenin farklı biçimlerde davranabilmesini sağlar.  
Örnek:

```java
Animal a = new Dog();
a.makeSound(); // Dog’un makeSound() metodunu çalıştırır.
```

## Bu, “runtime polymorphism” olarak bilinir ve OOP’nin temel prensiplerinden biridir.

### 🧩 Soru 61:

**Kısa Özet:**  
Constructor (yapıcı metot) nedir?

**Kısa Cevap:**  
Bir sınıftan nesne oluşturulduğunda çalışan özel metottur.

**Detaylı Cevap:**  
Constructor, sınıf ismiyle aynı isme sahip olur ve geri dönüş tipi olmaz.  
Örnek:

```java
class Person {
    Person() {
        System.out.println("Kişi oluşturuldu");
    }
}
```

## Nesne oluşturulunca (`new Person()`) otomatik çağrılır. Parametreli constructor’lar da tanımlanabilir.

### 🧩 Soru 62:

**Kısa Özet:**  
Method overloading nedir?

**Kısa Cevap:**  
Aynı isimde ama farklı parametrelerle metot tanımlamaktır.

**Detaylı Cevap:**  
Overloading, compile-time polymorphism örneğidir.  
Örnek:

```java
void print(int a) {}
void print(String s) {}
```

## Bu iki metot farklı parametre tipleriyle tanımlandığı için Java hangisinin çağrılacağını derleme zamanında belirler.

### 🧩 Soru 63:

**Kısa Özet:**  
Method overriding nedir?

**Kısa Cevap:**  
Üst sınıftaki bir metodun alt sınıfta yeniden tanımlanmasıdır.

**Detaylı Cevap:**  
Overriding, “runtime polymorphism” sağlar.  
Örnek:

```java
class Animal { void sound() { System.out.println("Animal sound"); } }
class Dog extends Animal { void sound() { System.out.println("Bark"); } }
```

## Burada `Dog` sınıfı `Animal`’ın metodunu yeniden yazar.

### 🧩 Soru 64:

**Kısa Özet:**  
“this” anahtar kelimesi ne işe yarar?

**Kısa Cevap:**  
Sınıfın kendi örneğini (instance) temsil eder.

**Detaylı Cevap:**  
`this`, sınıf içindeki değişkenleri veya metotları ifade eder.  
Örnek:

```java
class Student {
    int id;
    Student(int id) {
        this.id = id; // parametre ile sınıf değişkenini ayırır
    }
}
```

## Ayrıca constructor chaining yapmak için de kullanılabilir: `this()`.

### 🧩 Soru 65:

**Kısa Özet:**  
Access modifier nedir?

**Kısa Cevap:**  
Sınıf, değişken veya metotlara erişim seviyesini belirleyen ifadelerdir.

**Detaylı Cevap:**  
Java’da dört ana erişim belirleyici vardır:

-   **public**: Her yerden erişilebilir.
    
-   **protected**: Aynı paket + alt sınıflardan erişilebilir.
    
-   **default** (belirtilmezse): Sadece aynı paketten erişim.
    
-   **private**: Sadece aynı sınıf içinde erişim.
    

___

### 🧩 Soru 66:

**Kısa Özet:**  
Encapsulation (kapsülleme) nedir?

**Kısa Cevap:**  
Verilerin doğrudan erişime kapatılması ve metotlarla kontrol edilmesidir.

**Detaylı Cevap:**  
Encapsulation, değişkenlerin `private` yapılması ve `getter`/`setter` metotlarıyla erişilmesidir.  
Örnek:

```java
class Person {
    private String name;
    public void setName(String n) { name = n; }
    public String getName() { return name; }
}
```

## Bu yaklaşım, veriyi gizler ve kontrolü geliştiriciye verir.

### 🧩 Soru 67:

**Kısa Özet:**  
Abstract class nedir?

**Kısa Cevap:**  
Soyut sınıf; doğrudan nesne oluşturulamayan, alt sınıflara temel olan sınıftır.

**Detaylı Cevap:**  
`abstract` anahtar kelimesiyle tanımlanır. İçinde soyut (gövdesiz) metotlar olabilir.  
Örnek:

```java
abstract class Animal {
    abstract void makeSound();
}
class Dog extends Animal {
    void makeSound() { System.out.println("Bark"); }
}
```

Bu yapı, ortak davranışları tanımlarken farklı implementasyonlara izin verir.

___

### 🧩 Soru 68:
**Kısa Özet:**  
Interface nedir?

**Kısa Cevap:**  
Bir sınıfın uygulamak zorunda olduğu metotların tanımlandığı şablondur.

**Detaylı Cevap:**  
Interface, sadece metot imzaları ve sabit değişkenler içeren bir yapıdır. Gövdesiz metotlar tanımlar ve `implements` ile sınıflar tarafından uygulanır.  
Örnek:
```java
interface Animal {
    void makeSound();
}
class Dog implements Animal {
    public void makeSound() { System.out.println("Bark"); }
}
```

Bir sınıf birden fazla interface’i uygulayabilir, bu da Java’da çoklu kalıtımı dolaylı yoldan sağlar.

___


### 🧩 Soru 69:

**Kısa Özet:**  
Abstract class ile interface arasındaki fark nedir?

**Kısa Cevap:**  
Abstract class’ta hem soyut hem somut metotlar olabilir, interface tamamen soyuttur.

**Detaylı Cevap:**

| Özellik | Abstract Class | Interface |
| --- | --- | --- |
| Metotlar | Soyut + somut | Genelde soyut (Java 8 sonrası default ve static metot da olabilir) |
| Kalıtım | Tek sınıf | Çoklu interface |
| Anahtar Kelime | `extends` | `implements` |
| Nesne Oluşturma | Olamaz | Olamaz |

## Interface “ne yapılacağını”, abstract class ise “nasıl yapılabileceğini” tanımlar.

### 🧩 Soru 70:

**Kısa Özet:**  
Exception nedir?

**Kısa Cevap:**  
Program çalışırken oluşan beklenmeyen hatalardır.

**Detaylı Cevap:**  
Exception (istisna), program akışını bozan olaylardır.  
İki türü vardır:

-   **Checked Exceptions:** Derleme zamanında kontrol edilir (`IOException`, `SQLException`).
    
-   **Unchecked Exceptions:** Çalışma zamanında oluşur (`NullPointerException`, `ArithmeticException`).  
    Java bu hataları yakalamak için `try-catch` bloklarını kullanır.
    

___

### 🧩 Soru 71:

**Kısa Özet:**  
try-catch yapısı ne işe yarar?

**Kısa Cevap:**  
Hataları yakalayıp programın çökmesini engeller.

**Detaylı Cevap:**  
Bir kod bloğu hata oluşturduğunda, `catch` bloğu devreye girer:

```java
try {
    int x = 5 / 0;
} catch (ArithmeticException e) {
    System.out.println("Sıfıra bölünemez!");
}
```

## İsteğe bağlı olarak `finally` bloğu da eklenebilir; hata olsa bile her zaman çalışır.

### 🧩 Soru 72:

**Kısa Özet:**  
throw ve throws farkı nedir?

**Kısa Cevap:**  
`throw` bir istisnayı fırlatır, `throws` metot bildirir.

**Detaylı Cevap:**

-   `throw` → belirli bir noktada hata fırlatır:
    

```java
throw new IOException("Dosya bulunamadı");
```

-   `throws` → metodun hata fırlatabileceğini belirtir:
    

```java
void readFile() throws IOException {}
```

## Yani `throw` çalıştırırken, `throws` tanımlarken kullanılır.

### 🧩 Soru 73:

**Kısa Özet:**  
File I/O (girdi/çıktı) işlemleri nasıl yapılır?

**Kısa Cevap:**  
Dosyalara veri yazmak veya okumak için Java I/O sınıfları kullanılır.

**Detaylı Cevap:**  
Örneğin bir dosyaya yazmak için:

```java
FileWriter fw = new FileWriter("data.txt");
fw.write("Merhaba Java");
fw.close();
```

Okumak için:

```java
BufferedReader br = new BufferedReader(new FileReader("data.txt"));
String line = br.readLine();
```

## Java 7 sonrası `try-with-resources` ile otomatik kapatma yapılabilir.

### 🧩 Soru 74:

**Kısa Özet:**  
Thread nedir?

**Kısa Cevap:**  
Program içinde aynı anda çalışan küçük işlemler (alt süreçler)dir.

**Detaylı Cevap:**  
Thread (iş parçacığı), programın aynı anda birden fazla işi yürütmesini sağlar (çoklu görev).  
Örnek:

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread çalışıyor");
    }
}
new MyThread().start();
```

## Alternatif olarak `Runnable` arayüzü de kullanılabilir.

### 🧩 Soru 75:

**Kısa Özet:**  
synchronized anahtar kelimesi ne işe yarar?

**Kısa Cevap:**  
Çoklu thread’lerin aynı kaynağa aynı anda erişmesini engeller.

**Detaylı Cevap:**  
Birden fazla thread aynı değişkeni değiştirmeye çalıştığında veri tutarsızlığı olabilir.  
`synchronized`, aynı anda yalnızca bir thread’in erişmesine izin verir:

```java
synchronized void printData() {
    // güvenli erişim
}
```

## Bu özellikle çoklu iş parçacıklı ortamlarda veri bütünlüğünü korur.

### 🧩 Soru 76:

**Kısa Özet:**  
Garbage Collection nedir?

**Kısa Cevap:**  
Kullanılmayan nesnelerin bellekte otomatik olarak temizlenmesidir.

**Detaylı Cevap:**  
Java, “Automatic Garbage Collector” kullanır.  
Artık referansı olmayan nesneler otomatik olarak silinir:

```java
obj = null; // Nesneye erişim kaybolur, GC temizler.
```

## Elle çağırmak için `System.gc()` kullanılabilir, ama JVM ne zaman çalıştıracağına kendisi karar verir.

### 🧩 Soru 77:

**Kısa Özet:**  
Java neden platformdan bağımsızdır?

**Kısa Cevap:**  
Çünkü Java kodu “bytecode” olarak derlenir ve JVM üzerinde çalışır.

**Detaylı Cevap:**  
Java kaynak kodu `.java` → `.class` (bytecode) biçimine derlenir.  
Bu bytecode, her işletim sisteminde bulunan JVM (Java Virtual Machine) tarafından çalıştırılır.  
Bu sayede aynı Java kodu Windows, Linux veya macOS’ta değişmeden çalışabilir — yani _“Write Once, Run Anywhere”_ ilkesi uygulanır.
