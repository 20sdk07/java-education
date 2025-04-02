public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("");
        System.out.println("  ######## MAĞAZAYA HOŞGELDİNİZ ######## ");
        System.out.println();
        boolean showMenu = true;
       while (showMenu) {
            System.out.println("1- Eşyalar   : Karakterin canavarla savaşırken canavara her vurşunda ekstra hasar vermesini sağlar .");
             System.out.println("2- Zırhlar   : Karakterin canavarla savaşırken canavarın sana her vuruşunda hasarı savurur.");
            System.out.println("3- çıkış yap : Ana menüye dönersin");
            System.out.println("");
            System.out.print("Ne yapmak istersiniz ?");
            int selectCase = input.nextInt();
            while (selectCase < 1 || selectCase > 3) {
                System.out.print("Geçersiz bir seçim yaptınız lütfen tekrar deneyiniz ");
                selectCase = input.nextInt();

            }
            
            switch (selectCase) {
                case 1 -> {
                    printWeapon();
                    buyWeapon();
                }
                case 2 -> {
                    printArmor();
                    buyArmor();
                }
                case 3 -> {
                    System.out.println("");
                    System.out.println("Ana menüye dönüyorsunuz...");
                    System.out.println("Yine bekleriz :)");
                    showMenu = false;
                }
            }
        }
        return true;

    }

    public void printWeapon() {
        System.out.println("------------ Eşyalar ------------ ");
        System.out.println(" ");
        for (Weapon w : Weapon.weapons()){
            System.out.println(w.getId()+" - "+ w.getName() + "Para : "+ w.getPrice() + "  Hasar : " + w.getDamage() );
        }
        System.err.println("0 - Çıkış yap");
        
    } 
    
    public void buyWeapon(){

        System.out.println("");
        System.out.println("Satın almak istediğiniz eşyayı seçiniz : ");
        int selectWeaponID = input.nextInt();
        System.out.println();
        while (selectWeaponID < 0 || selectWeaponID >Weapon.weapons().length) {
            System.out.println("Geçersiz bir seçim yaptınız lütfen tekrar deneyiniz ");
            selectWeaponID = input.nextInt();
        }
        if (selectWeaponID != 0) {
            Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);

            if(selectedWeapon !=null){
                if(selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("Yeterli paranız bulunmamaktadır. ");
                    System.out.println();
                }else {
                // satın alma işlemi
                System.out.println(selectedWeapon.getName()+ "Harika eşya envantere eklendi !");
                int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Kalan paranız : "+ this.getPlayer().getMoney());
                System.out.println("Önceki Eşyanız : "+ this.getPlayer().getInventory().getWeapon().getName());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
                System.out.println("Yeni eşyanız önceki silaha entegre edildi : " + this.getPlayer().getInventory().getWeapon().getName());
                System.out.println(" ");
                    
                }
            }
        }
        
    }

    

    public void printArmor() {
        System.out.println("------------ Zırhlar ------------- ");
        System.out.println(" ");
        for (Armor a : Armor.armors()){
            System.out.println(a.getId()+" - "+ a.getName() + "Para : "+
             a.getPrice() + "  Zırh : " + a.getBlock() );
        }
        System.err.println("0 - Çıkış yap");


    }

    public void buyArmor() {
        System.out.println("");
        System.out.println("Satın almak istediğiniz eşyayı seçiniz : ");
        int selectArmorID = input.nextInt();
        while (selectArmorID < 0 || selectArmorID > Armor.armors().length) {
            System.out.println("Geçersiz bir seçim yaptınız lütfen tekrar deneyiniz ");
            selectArmorID = input.nextInt();
        }

        Armor selectedArmor = Armor.getArmorObjByID(selectArmorID);
        if (selectedArmor != null) {
            if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("Yeterli paranız bulunmamaktadır. ");
            } else {
                // satın alma işlemi
                System.out.println(selectedArmor.getName() + " harika eşya envantere eklendi!");
                int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Kalan paranız : " + this.getPlayer().getMoney());
                System.out.println("Önceki Eşyanız : " + this.getPlayer().getInventory().getArmor().getName());
                this.getPlayer().getInventory().setArmor(selectedArmor);
                System.out.println("Yeni Eşyanız önceki eşyaya entegre edildi : " + this.getPlayer().getInventory().getArmor().getName());
            }
        }
    }
}
