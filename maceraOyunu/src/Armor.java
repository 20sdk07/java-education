public class Armor {
    private String name;
    private int id;
    private int block;
    private int price;

    public Armor(int id, String name, int block, int price) {
        this.block = block;
        this.price = price;
        this.name = name;
        this.id = id;
    }
    
    public static Armor[] armors() {
        Armor[] armorList = new Armor[3];
        armorList[0] = new Armor(1, "Hafif Zırh   ", 1, 15);
        armorList[1] = new Armor(2, "Orta Zırh    ", 3, 35);
        armorList[2] = new Armor(3, "Ağır Zırh    ", 5, 45);
        return armorList;
    }

    public static Armor getArmorObjByID(int id) {
        for (Armor a : Armor.armors()) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }


    public String getName() {
        return name;
    }
    
    public int getId() {
        return id;
    }

    public int getBlock() {
        return block;
    }

    public int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}
