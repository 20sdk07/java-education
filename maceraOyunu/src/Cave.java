public class Cave extends BattleLoc {
    public Cave(Player player  ) {
        super(player, "Mağara", new Zombie(), "Food", 3);
    }

    @Override
    public boolean onLocation() {
        System.out.println("######## MAĞARAYA HOŞGELDİNİZ ########");
        return super.onLocation();
    }
    
}
