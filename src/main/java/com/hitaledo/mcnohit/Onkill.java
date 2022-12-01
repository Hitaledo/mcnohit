//Nombre del paquete
package com.hitaledo.mcnohit;
//Importar Librerias
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import java.io.File;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
//Clase publica Onkill implementa un Listener
public class Onkill implements Listener{
    private App plugin;
    public Onkill(App plugin){
        this.plugin = plugin;
    }
    @EventHandler
    //Funcion onkill con el evento PlayerDeath
    public void onkill(PlayerDeathEvent event){
        //Configurar el archivo de datos
        File data = plugin.data;
        FileConfiguration dataConfig = plugin.dataConfig;
        //Asignar variable kills segun el archivo
        Integer kills = dataConfig.getInt(event.getEntity().getName());
        //Si no existen los datos
        if(!dataConfig.contains(event.getEntity().getName())){
            //Establece los datos en 1
            dataConfig.set(event.getEntity().getName(), 1);
        //De lo contrario
        }else{
            //Sumar uno a kills
            kills += 1;
            //Establece los datos en kills
            dataConfig.set(event.getEntity().getName(), kills);
        }
        //Tratar de
        try{
            //Guardar los datos
            dataConfig.save(data);
        //En el caso de que no se pueda
        }catch(Exception e){
            //Imprimir el error
            e.printStackTrace();
            //Mensaje de error
            plugin.getLogger().info(ChatColor.RED + "Ocurrio un error al guardar los datos");
        }
        //Establecer variable mensaje original
        String originalMessage = event.getDeathMessage();
        //Establecer variable mensaje añadido
        String addedMessage = " Por " + kills + " vez";
        //Establecer variable nuevo mensaje
        String newMessage = originalMessage + addedMessage;
        //Establecer el mensaje de kill a nuevo mensaje
        event.setDeathMessage(newMessage);
    }   
}
