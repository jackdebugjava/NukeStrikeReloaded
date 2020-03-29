/*     */ package io.github.jackdebugjava.NukeStrikeReloaded.Event;
/*     */ 
/*     */ import io.github.jackdebugjava.NukeStrikeReloaded.Main;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Color;
/*     */ import org.bukkit.FireworkEffect;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.entity.EntityType;
/*     */ import org.bukkit.entity.Firework;
/*     */ import org.bukkit.entity.Giant;
/*     */ import org.bukkit.entity.Item;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.block.Action;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.meta.FireworkMeta;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.potion.PotionEffect;
/*     */ import org.bukkit.potion.PotionEffectType;
/*     */ import org.bukkit.util.Vector;
/*     */ 
/*     */ public class FlareThrow
/*     */   implements Listener
/*     */ {
/*  28 */   public int task = 0;
/*     */   
/*     */   @SuppressWarnings("deprecation")
@EventHandler
/*     */   public void on(PlayerInteractEvent e) {
/*  32 */     Player p = e.getPlayer();
/*  33 */     Action action = e.getAction();
/*     */     
/*  35 */     if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK)
/*     */     {
/*  37 */       if (p.getItemInHand().getType() == Material.REDSTONE_TORCH) {
/*     */         
/*  39 */         ItemStack flare = p.getItemInHand();
/*     */         
/*  41 */         if (flare.hasItemMeta() && flare.getItemMeta().hasLore())
/*     */         {
/*  43 */           for (String lore : p.getItemInHand().getItemMeta().getLore()) {
/*     */             
/*  45 */             if (lore.contains("nuke")) {
/*     */               
/*  47 */               e.setCancelled(true);
/*     */               
/*  49 */               int amount = p.getItemInHand().getAmount() - 1;
/*     */               
/*  51 */               if (amount == 0) {
/*     */                 
/*  53 */                 p.setItemInHand(null);
/*     */               }
/*     */               else {
/*     */                 
/*  57 */                 p.getItemInHand().setAmount(amount);
/*     */               } 
/*     */               
/*  60 */               final Item item = p.getWorld().dropItem(p.getEyeLocation(), new ItemStack(Material.REDSTONE_TORCH));
/*     */ 
/*     */               
/*  63 */               Vector v = p.getEyeLocation().getDirection().multiply(0.8D);
/*  64 */               item.setVelocity(v);
/*     */               
/*  66 */               this.task = Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin)Main.getInstance(), new Runnable()
/*     */                   {
/*     */                     
/*     */                     public void run()
/*     */                     {
/*  71 */                       if (item != null && !item.isDead())
/*     */                       {
/*  73 */                         final Firework f = (Firework)item.getWorld().spawnEntity(item.getLocation(), EntityType.FIREWORK);
/*     */                         
/*  75 */                         FireworkMeta fm = f.getFireworkMeta();
/*  76 */                         fm.addEffect(FireworkEffect.builder().flicker(false).trail(false).with(FireworkEffect.Type.BALL)
/*  77 */                             .withColor(Color.RED).withFade(Color.RED).build());
/*  78 */                         fm.setPower(10);
/*  79 */                         f.setFireworkMeta(fm);
/*     */                         
/*  81 */                         Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), new Runnable()
/*     */                             {
/*     */                               
/*     */                               public void run()
/*     */                               {
/*  86 */                                 f.detonate();
/*     */                               }
/*     */                             }, 
/*  89 */                             2L);
/*     */                       }
/*     */                       else
/*     */                       {
/*  93 */                         Bukkit.getScheduler().cancelTask(FlareThrow.this.task);
/*     */                       }
/*     */                     
/*     */                     }
/*  97 */                   }, 10L, amount);
/*     */               
/*  99 */               Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), new Runnable()
/*     */                   {
/*     */                     
/*     */                     public void run()
/*     */                     {
/* 104 */                       Location loc = item.getLocation();
/* 105 */                       Giant g = (Giant)loc.getWorld().spawnEntity(loc.add(0.0D, 50.0D, 0.0D), EntityType.GIANT);
/*     */                       
/* 107 */                       g.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 2147483647, 0));
/* 108 */                       g.setMaxHealth(1.0D);
/* 109 */                       g.setHealth(1.0D);
/* 110 */                       g.setCustomName("Dinnerbone");
/* 111 */                       g.getEquipment().setItemInHand(new ItemStack(Material.TNT));
/* 112 */                       g.getEquipment().setItemInHandDropChance(0.0F);
/*     */                     }
/* 115 */                   });
/*     */             } 
/*     */           } 
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\stant\Downloads\Nuke Strike.jar!\me\anderson\ns\Event\FlareThrow.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */