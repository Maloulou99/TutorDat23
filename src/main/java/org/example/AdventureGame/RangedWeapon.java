package org.example.AdventureGame;
public class RangedWeapon extends Weapon{

    private int ammo;

    public RangedWeapon(String itemName, String itemDescription, int ammo, int damage) {
        super(itemName, itemDescription,damage);
        this.ammo = ammo;
    }


    //Override use metode  i weapon
    public AttackEnum attack() {
        if (ammo > 0) {
            ammo -= 1; // Reducer antallet af ammo med 1 for hvert skud.
            return AttackEnum.FIRED;
        } else {
            return AttackEnum.NO_AMMO;
        }
    }


    public int getAmmo() {
        return ammo;
    }
}
