package myplugin.wikiplugin.commands;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Menu implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String [] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("Only players in game can run this command.");
            return true;
        }

        Player player = (Player) sender;

        Inventory inv = Bukkit.createInventory(player, 9*5, "FermiumMC Wiki");

        inv.setItem(12, getItem(new ItemStack(Material.WHEAT_SEEDS), "&9Basic Commands", "&9Useful commands to get started"));
        inv.setItem(13, getItem(new ItemStack(Material.DIAMOND_AXE), "&9Dungeons", "&9Explore treacherous dungeons!"));
        inv.setItem(14, getItem(new ItemStack(Material.DIAMOND_SWORD), "&9Skills", "&9Learn about our skill system!"));
        inv.setItem(21, getItem(new ItemStack(Material.DIAMOND), "&9Admin Shop", "&9Learn about /shop!"));
        inv.setItem(22, getItem(new ItemStack(Material.CRAFTING_TABLE), "&9Custom Crafting", "&9Learn what you can craft!"));
        inv.setItem(23, getItem(new ItemStack(Material.STONE_AXE), "&9Jobs", "&9Learn about /jobs!"));
        inv.setItem(30, getItem(new ItemStack(Material.EMERALD), "&9Auction House", "&9Learn about /ah!"));
        inv.setItem(31, getItem(new ItemStack(Material.ENDER_PEARL), "&9Player Warps", "&9Learn about player warps!"));
        inv.setItem(32, getItem(new ItemStack(Material.EMERALD_BLOCK), "&9Player Shops", "&9Learn about player shops!"));

        player.openInventory(inv);

        return true;
    }

    private ItemStack getItem(ItemStack item, String name, String ... lore){
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));

        List<String> lores = new ArrayList<>();
        for (String s : lore) {
            lores.add(ChatColor.translateAlternateColorCodes('&', s));
        }

        meta.setLore(lores);

        item.setItemMeta(meta);
        return item;
    }

}
