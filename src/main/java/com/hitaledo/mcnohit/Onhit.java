//Nombre del paquete
package com.hitaledo.mcnohit;

//Importar Librerias
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
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
        Long tHit = 40L;
        int killDamage = 100;
        //Si el tipo de entidad es un jugador
        if (event.getEntityType() == EntityType.PLAYER){
            //Delay
            Bukkit.getScheduler().runTaskLater(plugin, () -> {
                //Establecer daño en 100
                event.setDamage(killDamage);
            }, tHit);
        }
    }
}
