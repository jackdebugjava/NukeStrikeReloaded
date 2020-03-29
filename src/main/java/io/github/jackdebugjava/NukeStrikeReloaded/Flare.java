/*    */ package io.github.jackdebugjava.NukeStrikeReloaded;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.Recipe;
/*    */ import org.bukkit.inventory.ShapedRecipe;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ 
/*    */ public class Flare
/*    */ {
/*    */   public static void flareRecipe() {
/* 15 */     ItemStack flare = new ItemStack(Material.REDSTONE_TORCH);
/* 16 */     ItemMeta meta = flare.getItemMeta();
/* 17 */     meta.setDisplayName("§cNuke Flare");
/* 18 */     meta.setLore(Arrays.asList(new String[] { "§7Right-Click to call in", "§7a nuke strike at your", "§7location" }));
/* 19 */     flare.setItemMeta(meta);
/*    */     
/* 21 */     @SuppressWarnings("deprecation")
ShapedRecipe recipe = new ShapedRecipe(flare);
/*    */     
/* 23 */     recipe.shape(new String[] { "@*@", 
/* 24 */           "@^@", 
/* 25 */           "@|@" });
/*    */     
/* 27 */     recipe.setIngredient('*', Material.FIREWORK_ROCKET);
/* 28 */     recipe.setIngredient('^', Material.REDSTONE);
/* 29 */     recipe.setIngredient('|', Material.STICK);
/* 30 */     Bukkit.getServer().addRecipe((Recipe)recipe);
/*    */   }
/*    */ }


/* Location:              C:\Users\stant\Downloads\Nuke Strike.jar!\me\anderson\ns\Flare.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */