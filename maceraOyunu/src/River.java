public class River extends BattleLoc{
    public River(Player player) {
        super(player, "Nehir", new Vampire(), "Water", 3);
    }
    
    @Override
    public boolean onLocation() {
        System.out.println();
        System.out.println("######## NEHRE HOŞGELDİNİZ ########");
        return super.onLocation();
    }
    
}
