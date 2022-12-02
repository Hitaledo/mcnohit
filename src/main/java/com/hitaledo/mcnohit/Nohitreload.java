//Nombre del paquete
package com.hitaledo.mcnohit;
//Importar Librerias
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
//Clase publica Reload implementa CommandExecutor
public class Nohitreload implements CommandExecutor{
    //Clase principal
    private App plugin;
    public Nohitreload(App plugin){
        this.plugin = plugin;
    }
    //Booleano publico onCommand
    public boolean onCommand(CommandSender sender, Command nohitreload, String label, String[] args) {
        //Recargar configuracion
        plugin.reloadConfig();
        //Mostrar mensaje
        plugin.getLogger().info("Se ha recargado el plugin " + plugin.pluginName + " correctamente!");
        //Devolver comando
        return true;
    }
}
