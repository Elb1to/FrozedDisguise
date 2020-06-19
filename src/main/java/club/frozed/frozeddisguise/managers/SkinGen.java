package club.frozed.frozeddisguise.managers;

import club.frozed.frozeddisguise.utils.Messages;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class SkinGen {

    public static List<String> skins;
    public static Inventory menu;
    public static HashMap<String, String> data;

    public static String generate() {
        Random random = new Random();
        return SkinGen.skins.get(random.nextInt(SkinGen.skins.size()));
    }

    static {
        SkinGen.data = new HashMap<>();
        SkinGen.skins = Arrays.asList(
                "_rsu:Killer", "E_Girl:E-girl", "burningbridge:Link", "BackupDancer:L", "Arro:Arabian", "bennyknight:Badman", "Cheggthemegg:Ricardo Milos",
                "DonaldTrumpinho:Trump", "CocoDeMedellin:BlackGoku", "SheAGoldDigger:BlueGoku", "DJ_Blazes:Enderman", "Marcel:Marcel", "Zwergoor:Emoji",
                "HikakinGames:Youtuber", "loudoggydog3010:XXX", "Killer0dead:Rem", "SolluxCaptor:Nezuko", "weebh0e:Shinobu");

        SkinGen.menu = Bukkit.createInventory(null, 18, Messages.CC("&8Select an Skin"));
        for (String skin : SkinGen.skins) {
            ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
            SkullMeta skullmeta = (SkullMeta) skull.getItemMeta();
            String nick = skin.split(":")[0];
            String display = skin.split(":")[1];
            skullmeta.setOwner(nick);
            skullmeta.setDisplayName(ChatColor.AQUA + display);
            skull.setItemMeta(skullmeta);
            SkinGen.menu.addItem(skull);
            SkinGen.data.put(skull.getItemMeta().getDisplayName(), nick + ":" + display);
        }
    }

}
