import java.util.Scanner;

public class Game {

    
    private final Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("MACERA OYUNUNA HOŞGELDİNİZ !");
        System.out.println("");
        System.out.println("lÜTFEN BİR İSİM GİRİNİZ :");
        // String playerName = scanner.nextLine();
        Player player = new Player("SADOO");
        System.out.println("");
        System.out.println("Keşiş " + player.getName() + " JAVA ADASINA HOŞ GELDİNİZ ");
        System.out.println("");
        System.out.println("Lütfen bir karakter seçiniz ");
        player.selectChar();

        Location location = null;
        while (true) {
            System.out.println("");
            player.Char();
            System.out.println("");
            System.out.println("                    ---------------------------------------------BÖLGELER----------------------------------------------------");
            System.out.println("");
            System.out.println(" 0 -     Çıkış     --> Eğer çıkış yaparsanız oyunu kaybedersiniz. Yeni oyun için elinizdekilerin tanamını kaybedersiniz");
            System.out.println("");
            System.out.println(" 1 -   Güvenli Ev    --> Güvenli evde hiçbir düşman yoktur savaştan geldikten sonra canınızı yenilersiniz. ");
            System.out.println("");
            System.out.println(" 2 -  Eşya dükkanı  --> Mağazada size özel eşyalarla canvarları daha kolay yenebilir ya da onlardan daha fazla korunabilrisiniz" );
            System.out.println("");
            System.out.println(" 3 -  Mağara\t      --> Mağaraya gir. Dikkatli ol burada zombi çıkabilir." );
            System.out.println("");
            System.out.println(" 4 -  Orman\t      --> Ormana git. Dikkatli ol burada ayı çıkabilir." );
            System.out.println("");
            System.out.println(" 5 -  Nehir\t      --> Nehre gir. Dikkatli ol buruda vampir çıkabilir." );
            System.out.println("");
            System.out.println(" 6 -  Envanter        --> Envanterinizi görüntüleyin.");
            System.out.println("");
            System.out.println("                    ---------------------------------------------------------------------------------------------------------");
            System.out.println("");
            System.out.print(" Lütfen gitmek istediğiniz bölgeyi seçiniz : ");

            int selectLoc = input.nextInt();
            switch (selectLoc) {
                case 0 -> location = null;
                case 1 -> location = new SafeHouse(player);
                case 2 -> location = new ToolStore(player);
                case 3 -> location = new Cave(player);
                case 4 -> location = new Forest(player);
                case 5 -> location = new River(player);
                case 6 -> {
                    player.showInventory(); // Envanteri göster
                    continue; // Menüye geri dön
                }
                default -> System.out.println("Geçersiz bölge !");
            }

            if (location == null) {
                System.out.println("Bu kadar da kolaysın. Oyun bitti");
                break;
            }

            if (!location.onLocation()) {
                System.out.println("Düşamanın sana unutamayacağın bir ders verdi");
                System.out.println("GAME OVER"); 
                break;
            }

        }

       
    }



}

