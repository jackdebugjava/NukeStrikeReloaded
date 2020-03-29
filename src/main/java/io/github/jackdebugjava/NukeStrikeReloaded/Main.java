/*    */ package io.github.jackdebugjava.NukeStrikeReloaded;
/*    */ 
/*    */ import io.github.jackdebugjava.NukeStrikeReloaded.Event.FlareThrow;
/*    */ import io.github.jackdebugjava.NukeStrikeReloaded.Event.NukeHit;
/*    */ import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ import org.bukkit.plugin.PluginDescriptionFile;
/*    */ import org.bukkit.plugin.PluginManager;
/*    */ import org.bukkit.plugin.java.JavaPlugin;
/*    */ 
/*    */ public class Main extends JavaPlugin {
/* 13 */   public static String prefix = "§e§lBH §7§l» §r§e";
/*    */ 
/*    */   
/*    */   public static Main instance;
/*    */ 
/*    */   
/*    */   public void onEnable() {
/* 20 */     getConfig().options().copyDefaults(true);
/*    */     
/* 22 */     instance = this;
/*    */     
/* 24 */     PluginManager pm = Bukkit.getServer().getPluginManager();
/* 25 */     PluginDescriptionFile pdf = getDescription();
/*    */     
/* 27 */     pm.registerEvents((Listener)new FlareThrow(), (Plugin)this);
/* 28 */     pm.registerEvents((Listener)new NukeHit(), (Plugin)this);
/*    */     
/* 30 */     getCommand("giveflare").setExecutor((CommandExecutor) new GiveFlare());
/*    */     
/* 32 */     Bukkit.getConsoleSender().sendMessage(String.valueOf(prefix) + "§aNuke Strike §cv" + pdf.getVersion() + " §aenabled!");
/*    */     
/* 34 */     Flare.flareRecipe();
/*    */     
/* 36 */     saveConfig();
/*    */   }
/*    */   
/*    */   public static Main getInstance() {
/* 40 */     return instance;
/*    */   }
/*    */ }