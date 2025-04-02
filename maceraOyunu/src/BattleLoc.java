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
        int obsNumber = this.randomObstacleNumber();
        System.out.println("");
        System.out.println("Şuan " + this.getName() + " bölgesindesiniz. Burayı temizlerseniz " + this.getAward() + " kazanacaksınız.");
        System.out.println("Dikkatli olun! Burada " + obsNumber + " tane " + obstacle.getName() + " ile karşı karşıyasınız.");
        System.out.println("");
        System.out.println("Canavarın sağlık puanı : " + obstacle.getHealth());
        System.out.println("Canavarın hasar puanı : " + obstacle.getDamage());
        System.out.println("Canavarın ödülü : " + obstacle.getAward());
        System.out.println("");
        System.out.println("\t---<S>avaş---ya da----Kaç---");
        System.out.println("Eğer ('s', 'S') tuşuna basarsanız savaş başlayacak. Farklı bir tuşa basarsanız kaçmış olacaksınız.");
        String selCase = input.nextLine().toUpperCase();

        if (selCase.equals("S")) {
            System.out.println();
            System.out.println("Savaş başlıyor...!");
            boolean result = combat(obsNumber);
            if (result) {
                System.out.println("Bölgedeki tüm düşmanları temizlediniz!");
                this.getPlayer().getInventory().addAward(this.getAward());
                return true; // Oyuncu savaşı kazandı, oyuna devam edebilir
            } else {
                System.out.println("Savaşı kaybettiniz!");
                return false; // Oyuncu savaşı kaybetti, oyun biter
            }
        } else {
            System.out.println("Kaçılıyor... Seni korkak!");
            return true; // Oyuncu kaçtı, oyuna devam edebilir
        }
    }

    public boolean combat(int obsNumber) {
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
                    System.out.println("Siz vurdunuz...");
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
                    System.out.println("Kaçtınız!");
                    return true; // Oyuncu savaştan kaçtı
                }
            }

            if (this.getPlayer().getHealth() <= 0) {
                System.out.println("Öldünüz!");
                return false; // Oyuncu öldü
            }

            System.out.println("Düşmanı yendiniz!");
            System.out.println("Ödül alındı: " + this.getObstacle().getAward());
            this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
            System.out.println("Güncel Paranız: " + this.getPlayer().getMoney());
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