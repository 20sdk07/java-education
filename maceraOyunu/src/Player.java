import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int money;
    private String name;
    private String charName;
    private final Scanner input = new Scanner(System.in);
    private Inventory inventory;
    private int originHealth ;


    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {

        GameChar[] charlist = {new Samurai(), new Archer(), new Knight()};
        System.out.println("\t\t\t\t------------Karakterler---------------------------");
        System.out.println("");
        for (GameChar gameChar : charlist) {
            System.out.println("Karakter ID " + gameChar.getID() +
                    "\t  " + gameChar.getName() +
                    "\t Silah :" +gameChar.getweaponName()+
                    "\t Hasar : " + gameChar.getDamage() +
                    "\t Sağlık : " + gameChar.getHealth() +
                    "\t Zırh : " + this.inventory.getArmor().getBlock() +
                    "\t Para : " + gameChar.getMoney());
        }
        System.out.println();
        System.out.println("\t\t\t\t--------------------------------------------------");
        System.out.println();
        System.out.println("Lüfen seçmek istediğiniz karakterin ID numarasını giriniz  : ");

        int selectChar = input.nextInt();
        switch (selectChar) {
            case 1 -> initPlayer(new Samurai());
            case 2 -> initPlayer(new Archer());
            case 3 -> initPlayer(new Knight());
            default -> initPlayer(new Samurai());


        }
        
    }
    public void Char() {
        System.out.println("Karakter: " + this.getName() +
            "\nSilah:    " + this.getInventory().getWeapon().getName() +
            "\nHasar:    " + this.getTotalDamage() +
            "\nZırh:     " + this.getInventory().getArmor().getBlock() +
            "\nSağlık:   " + this.getHealth() +
            "\nPara:     " + this.getMoney());  
    }

    public void selectLoc() {


    }


    public void initPlayer(GameChar gameChar) {
        this.setName(gameChar.getName());
        this.setDamage(gameChar.getDamage());
        this.setOriginHealth(gameChar.getHealth());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());

    }

    public int getTotalDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        if (this.health < 0) {
            this.health = 0;
        }
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }
    public Inventory getInventory() {
        return inventory;
    }
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Scanner getInput() {
        return input;
    }

    public int getOriginHealth() {
        return originHealth;
    }

    public void setOriginHealth(int originHealth) {
        this.originHealth = originHealth;
    }
  
    public void showInventory() { 
        System.out.println("######## ENVANTER ########");
        System.out.println("Silah: " + this.getInventory().getWeapon().getName() + " (Hasar: " + this.getInventory().getWeapon().getDamage() + ")");
        System.out.println("Zırh: " + this.getInventory().getArmor().getName() + " (Bloklama: " + this.getInventory().getArmor().getBlock() + ")");
        System.out.println("Para: " + this.getMoney());
        System.out.println("Ödüller:");
        String[] awards = this.getInventory().getAwardList();
        boolean hasAwards = false;
        for (String award : awards) {
            if (award != null) {
                System.out.println("- " + award);
                hasAwards = true;
            }
        }
        if (!hasAwards) {
            System.out.println("Henüz ödül kazanmadınız.");
        }
        System.out.println("###########################");
    }
}

