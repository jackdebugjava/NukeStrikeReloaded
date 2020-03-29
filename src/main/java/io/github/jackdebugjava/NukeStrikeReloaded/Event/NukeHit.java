/*    */ package io.github.jackdebugjava.NukeStrikeReloaded.Event;
/*    */ 
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Giant;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDeathEvent;
/*    */ 
/*    */ public class NukeHit
/*    */   implements Listener
/*    */ {
/*    */   @SuppressWarnings("deprecation")
@EventHandler
/*    */   public void on(EntityDeathEvent e) {
/* 14 */     if (e.getEntity() instanceof Giant) {
/*    */       
/* 16 */       Giant g = (Giant)e.getEntity();
/*    */       
/* 18 */       if (g.getEquipment().getItemInHand().getType() == Material.TNT) {
/*    */         
/* 20 */         g.getWorld().createExplosion(g.getLocation(), 25.0F);
/*    */         
/* 22 */         g.remove();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\stant\Downloads\Nuke Strike.jar!\me\anderson\ns\Event\NukeHit.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */