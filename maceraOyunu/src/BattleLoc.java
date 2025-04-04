import java.util.Random;

public abstract class BattleLoc extends Location{
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;
    

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
        
    }
    
    @Override
    public boolean onLocation() {
        System.out.println("######## " + this.getName().toUpperCase() + " BÖLGESİNE HOŞGELDİNİZ ########");
        System.out.println("Bu bölgeyi temizlerseniz " + this.getAward() + " kazanacaksınız.");
        System.out.println("Ancak dikkatli olun! Burada " + this.randomObstacleNumber() + " tane " + this.getObstacle().getName() + " sizi bekliyor.");
        System.out.println("");
        System.out.println("Hazır mısınız? ('S' tuşuna basarak savaşa başlayabilirsiniz, başka bir tuşa basarak kaçabilirsiniz.)");
        String selCase = input.nextLine().toUpperCase();

        if (selCase.equals("S")) {
            System.out.println("Savaş başlıyor...!");
            boolean result = combat(this.randomObstacleNumber());
            return handleCombatResult(result); // Savaş sonucunu işleyen metodu çağır
        } else {
            System.out.println("Kaçmayı seçtiniz. Bir sonraki sefere daha cesur olun!");
            return true; // Oyuncu kaçtı, oyuna devam edebilir
        }
    }

    public boolean combat(int obsNumber) {
        Random random = new Random();

        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOrijinalHealth());
            playerStats();
            obstacleStats(i);

            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.println("\t---<V>ur---ya da----Kaç---");
                System.out.println("Eğer ('v', 'V') tuşuna basarsanız vuracaksınız. Farklı bir tuşa basarsanız kaçmış olacaksınız.");
                String selCombat = input.nextLine().toUpperCase();

                if (selCombat.equals("V")) {
                    System.out.println("----------------------------------------------------------");

                    // Vuruş sırasını rastgele belirle
                    boolean playerFirst = random.nextBoolean(); // true: oyuncu önce vurur, false: düşman önce vurur

                    if (playerFirst) {
                        System.out.println("Siz önce vurdunuz...");
                        this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                        afterIHit();

                        if (this.getObstacle().getHealth() > 0) {
                            System.out.println("Canavar size vurdu...");
                            int damage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                            if (damage < 0) damage = 0;
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - damage);
                            afterHitMe();
                        }
                    } else {
                        System.out.println("Canavar önce vurdu...");
                        int damage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (damage < 0) damage = 0;
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - damage);
                        afterHitMe();

                        if (this.getPlayer().getHealth() > 0) {
                            System.out.println("Siz vurdunuz...");
                            this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                            afterIHit();
                        }
                    }
                } else {
                    System.out.println("Kaçtınız!");
                    return true; // Oyuncu savaştan kaçtı
                }
            }

            if (this.getPlayer().getHealth() <= 0) {
                System.out.println("Öldünüz!");
                return false; // Oyuncu öldü
            }
        }

        return true; // Tüm düşmanlar yenildi
    }

    public void afterIHit(){
        System.out.println("");
        System.out.println( "#"+this.getObstacle().getName()+" canı : " + this.getObstacle().getHealth());
        
    }
    public void afterHitMe(){
        System.out.println("#Karakter canı : " + this.getPlayer().getHealth());
        System.err.println("----------------------------------------------------------");
        System.out.println("");
    }

    public void playerStats() {
        System.out.println("----------------------------");
        System.out.println("Karakter Bilgileri : ");
        System.out.println("Sağlık : " + this.getPlayer().getHealth());
        System.out.println("Hasar : " + this.getPlayer().getTotalDamage());
        System.out.println("Silah : " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Zırh : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama değeri : " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Para : " + this.getPlayer().getMoney());
        System.out.println("****************************");
    }
    public void obstacleStats(int i) {
        System.out.println( i +"."+this.getObstacle().getName()+" Bilgileri : ");
        System.out.println("Sağlık : " + this.getObstacle().getHealth());
        System.out.println("Hasar : " + this.getObstacle().getDamage());
        System.out.println("----------------------------");
        System.out.println("");
    }
    
    private boolean handleCombatResult(boolean result) {
        if (result) {
            System.out.println("Bölgedeki tüm düşmanları temizlediniz!");
            this.getPlayer().getInventory().addAward(this.getAward());
            System.out.println("Kazandığınız ödüller: ");
            for (String award : this.getPlayer().getInventory().getAwardList()) {
                if (award != null) {
                    System.out.println("- " + award);
                }
            }
            System.out.println("Bu bölgeyi temizlediniz. Ancak yolculuğunuz henüz bitmedi!");
            return true; // Oyuncu savaşı kazandı, oyuna devam edebilir
        } else {
            System.out.println("Savaşı kaybettiniz!");
            return false; // Oyuncu savaşı kaybetti, oyun biter
        }
    }

    public int randomObstacleNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
        
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
    

   
}