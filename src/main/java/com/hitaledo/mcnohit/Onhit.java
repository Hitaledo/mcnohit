//Nombre del paquete
package com.hitaledo.mcnohit;
//Importar Librerias
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
//Clase publica Onhit implementa un Listener
public class Onhit implements Listener{
    @EventHandler
    //Funcion onhit con el evento EntityDamage
    public void onhit(EntityDamageEvent event){
        //Si el tipo de entidad es un jugador
        if (event.getEntityType() == EntityType.PLAYER){
            //Establecer daño en 100
            event.setDamage(100);
        }
    }
}
