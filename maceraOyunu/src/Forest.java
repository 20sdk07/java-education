public class Forest extends BattleLoc{
    public Forest(Player player) {
        super(player, "Orman", new Bear(), "Firewood", 2);
    }
    
    @Override
    public boolean onLocation() {
        System.out.println("######## ORMANA HOŞGELDİNİZ ########");
        return super.onLocation();
    }
    
}
