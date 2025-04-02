public abstract class GameChar {
    private int ID;
    private String name;
    private String weaponName;
    private int damage;
    private int health;
    private int money;
    

    public GameChar(int ID,String name,String weaponName, int health, int damage, int money ) {
        this.ID = ID;
        this.name = name;
        this.weaponName = weaponName;
        this.health = health;
        this.damage = damage;
        this.money = money;
    }
    @Override
    public String toString() {
        return "Karakter ID: " + ID +
               "\t  " + name +
               "\t Silah: " + weaponName +
               "\t Hasar: " + damage +
               "\t Sağlık: " + health +
               "\t Para: " + money;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getweaponName(){
        return weaponName;
    }

    public void setweaponName(String weapoName){
        this.weaponName = weapoName;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    
}
