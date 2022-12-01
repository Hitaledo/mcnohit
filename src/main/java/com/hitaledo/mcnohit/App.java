//Nombre del paquete
package com.hitaledo.mcnohit;
//Importar Librerias
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
//Clase publica App extiende plugin de java
public class App extends JavaPlugin {
    //Declarar variables
    String pluginName = "Minecraft NO HIT";
    File data;
    FileConfiguration dataConfig;
    //Cuando se activa el plugin
    public void onEnable(){
        //Mensaje de activacion
        getLogger().info("Se ha activado el plugin " + pluginName + " correctamente!");
        //Registrar archivo de datos
        data = new File(getDataFolder(), "data.yml");
        //Cargar configuracion de datos
        dataConfig = YamlConfiguration.loadConfiguration(data);
        //Tratar de
        try{
            //Guardar los datos
            dataConfig.save(data);
        //En el caso de que no se pueda
        }catch(Exception e){
            //Imprimir el error
            e.printStackTrace();
            //Mensaje de error
            getLogger().info(ChatColor.RED + "Ocurrio un error al guardar los datos");
        }        
        //Registrar Evento Onhit
        getServer().getPluginManager().registerEvents(new Onhit(), this);
        //Registrar Evento Onkill
        getServer().getPluginManager().registerEvents(new Onkill(this), this);
        //Registrar Comando Deathcont
        getCommand("deathcont").setExecutor(new Deathcont(this));
    }
    //Cuando se desactiva el plugin
    public void onDisable(){
        //Mensaje de desactivacion
        getLogger().info("Se ha desactivado el plugin " + pluginName + " correctamente!");
    }
}