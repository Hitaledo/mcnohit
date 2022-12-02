//Nombre del paquete
package com.hitaledo.mcnohit;
//Importar Librerias
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.Bukkit;
//Clase publica Onhit implementa un Listener
public class Onhit implements Listener{
    //Clase principal
    private App plugin;
    public Onhit(App plugin){
        this.plugin = plugin;
    }
    //Funcion onhit con el evento EntityDamage
    @EventHandler
    public void onhit(EntityDamageEvent event){
        //Variables
        long tHit = 2L;
        BukkitScheduler scheduler = Bukkit.getScheduler();
        //Si el tipo de entidad es un jugador
        if (event.getEntityType() == EntityType.PLAYER){
            //Esperar
            scheduler.runTaskLater(plugin, () -> {
            //Establecer daño en 100
            event.setDamage(100);
            },
            //delay
            tHit);
        }
    }
}
