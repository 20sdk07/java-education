import java.util.Scanner;

public class Game {

    
    private final Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("######## JAVA ADASINA HOŞGELDİNİZ ########");
        System.out.println("Bir zamanlar, Java Adası güçlü bir medeniyetin yuvasıydı. Ancak, bu medeniyetin açgözlülüğü adayı lanetledi.");
        System.out.println("Adanın lanetini kaldırmak için Üç Kutsal Hazine'yi bulmanız gerekiyor: Food, Firewood ve Water.");
        System.out.println("Her hazine, tehlikeli yaratıklar tarafından korunuyor. Cesaretinizi toplayın ve bu laneti kaldırın!");
        System.out.println("");
        System.out.println("lÜTFEN BİR İSİM GİRİNİZ :");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println("");
        System.out.println("Keşiş " + player.getName() + ", Java Adası'na hoş geldiniz!");
        System.out.println("Lütfen bir karakter seçiniz:");
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

            if (checkAwards(player)) {
                System.out.println("Tebrikler! Üç Kutsal Hazine'yi topladınız ve Java Adası'nın lanetini kaldırdınız!");
                System.out.println("Adanın halkı artık huzur içinde yaşayabilir. Siz bir kahramansınız!");
                System.out.println("######## OYUNU KAZANDINIZ ########");
                break;
            }

        }

       
    }

    private boolean checkAwards(Player player) {
        String[] awards = player.getInventory().getAwardList();
        boolean hasFood = false;
        boolean hasFirewood = false;
        boolean hasWater = false;

        for (String award : awards) {
            if (award == null) {
                continue; // Eğer ödül null ise, kontrolü atla
            }
            switch (award) {
                case "Food" -> hasFood = true;
                case "Firewood" -> hasFirewood = true;
                case "Water" -> hasWater = true;
            }
        }

        return hasFood && hasFirewood && hasWater; // Tüm ödüller varsa true döner
    }

}

