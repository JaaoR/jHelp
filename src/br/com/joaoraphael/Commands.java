package br.com.joaoraphael;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
    
    private final Main principal = Main.getMain();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
        
        if (sender instanceof Player){
            Player p = (Player) sender;
            
            if (cmd.getName().equalsIgnoreCase("ajuda")){
                if (principal.getConfig().getBoolean("enabled") == true){
                                    if (principal.getConfig().getBoolean("ativar_perm") == true){
                    if (p.hasPermission(principal.getConfig().getString("permissao"))){
                        for (String ajuda : principal.getConfig().getStringList("mensagens")){
                        p.sendMessage(ajuda.replace("&", "§"));
                        }

                        
                    }else{
                        p.sendMessage(principal.getConfig().getString("sem_permissão").replace("&", "§"));
                    }
                }else{
                        for (String ajuda : principal.getConfig().getStringList("mensagens")){
                        p.sendMessage(ajuda.replace("&", "§"));
                        }
                }
                }else{
                    p.sendMessage(principal.getConfig().getString("desativado").replace("&", "§"));
                }
                
                
                
            }
            
        }else{
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Esse comando só pode ser executado por jogadores.");
        }
        
        return false;
        
    }
}
