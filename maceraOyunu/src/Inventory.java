public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private String[] awardList;

    public Inventory() {
        this.weapon = new Weapon(-1, "Düz vuruş", 0, 0);
        this.armor = new Armor(-1, "Paçavra", 0, 0);
        this.awardList = new String[3]; // Ödüller için sabit boyutlu bir dizi
    }

    public void addAward(String award) {
        for (int i = 0; i < awardList.length; i++) {
            if (awardList[i] == null) { // Boş bir yer bul ve ödülü ekle
                awardList[i] = award;
                System.out.println("Ödül envantere eklendi: " + award);
                return;
            }
        }
        System.out.println("Tüm ödüller zaten toplandı!");
    }

    

    public String[] getAwardList() {
        return awardList;
    }

    public void setAwardList(String[] awardList) {
        this.awardList = awardList;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}
