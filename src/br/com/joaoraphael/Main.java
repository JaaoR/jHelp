package br.com.joaoraphael;

import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    ConsoleCommandSender cs = Bukkit.getConsoleSender();
    public String separador = "-=-=-=-=-=-=-=-=-=-";
    @Override
    public void onEnable() {
        
        if (!new File(getDataFolder(), "config.yml").exists()){
            saveDefaultConfig();
        }
            RegisterCommands();
            cs.sendMessage(separador);
            cs.sendMessage("§aPlugin: jHelp");
            cs.sendMessage("§aDesenvolvido por: Jaao (@_jaoraphael)");
            cs.sendMessage("§aStatus: habilitado");
            cs.sendMessage(separador);
    }

    @Override
    public void onDisable() {
            cs.sendMessage(separador);
            cs.sendMessage("§cPlugin: jHelp");
            cs.sendMessage("§cDesenvolvido por: Jaao (@_jaoraphael)");
            cs.sendMessage("§cStatus: desabilitado");
            cs.sendMessage(separador);
        
    }
    
    public static Main getMain(){
        return (Main) Bukkit.getPluginManager().getPlugin("jHelp");
    }
    
    public void RegisterCommands(){
        getCommand("ajuda").setExecutor(new Commands());

    }
    
    
    
}
