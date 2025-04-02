public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player ) {
        super(player, "Güvenli Ev");
    }

    @Override
    public boolean onLocation() {
        System.out.println();
        System.out.println("######## GÜVENLİ EVE HOŞGELDİNİZ ########");
        this.getPlayer().setHealth(this.getPlayer().getOriginHealth());
        System.out.println();
        System.out.println("Canınız Ywnilendi ");
        
        return true;
    }
}
