/*    */ package io.github.jackdebugjava.NukeStrikeReloaded;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ 
/*    */ public class GiveFlare
/*    */   implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
/* 18 */     if (cmd.getName().equalsIgnoreCase("giveflare"))
/*    */     {
/* 20 */       if (sender.hasPermission("ns.giveflare") || sender.isOp()) {
/*    */         
/* 22 */         ItemStack flare = new ItemStack(Material.REDSTONE_TORCH);
/* 23 */         ItemMeta meta = flare.getItemMeta();
/* 24 */         meta.setDisplayName("§cNuke Flare");
/* 25 */         meta.setLore(Arrays.asList(new String[] { "§7Right-Click to call in", "§7a nuke strike at your", "§7location" }));
/* 26 */         flare.setItemMeta(meta);
/*    */         
/* 28 */         if (args.length == 0)
/*    */         {
/* 30 */           if (sender instanceof Player)
/*    */           {
/* 32 */             Player p = (Player)sender;
/*    */             
/* 34 */             p.getInventory().addItem(new ItemStack[] { flare });
/*    */           }
/*    */           else
/*    */           {
/* 38 */             sender.sendMessage("§cYou must be a player to give yourself a flare!");
/*    */           
/*    */           }
/*    */         
/*    */         }
/* 43 */         else if (args.length == 1)
/*    */         {
/* 45 */           for (Player pl : Bukkit.getOnlinePlayers())
/*    */           {
/* 47 */             if (pl.getName().equalsIgnoreCase(args[0]))
/*    */             {
/* 49 */               pl.getInventory().addItem(new ItemStack[] { flare });
/*    */             }
/*    */           }
/*    */         
/*    */         }
/*    */       
/*    */       } else {
/*    */         
/* 57 */         sender.sendMessage("§cYou do not have permission to use this command!");
/*    */       } 
/*    */     }
/* 60 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\stant\Downloads\Nuke Strike.jar!\me\anderson\ns\GiveFlare.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */