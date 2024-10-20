package com.github.pritam11638.bedwarsPlus.Command;


import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;

import java.util.List;

public abstract class SubCommand {
    String name;
    Permission permission;
    String helpString;
    List<String> tabCompletes;

    public SubCommand(String nameT, Permission permissionT, String helpStringT, List<String> tabCompletesT) {
        name = nameT;
        permission = permissionT;
        helpString = helpStringT;
        tabCompletes = tabCompletesT;
    }

    public String getName() {
        return name;
    }

    public Permission getPermission() {
        return permission;
    }

    public String getHelpString() {
        return helpString;
    }

    public List<String> getTabCompletes() {
        return tabCompletes;
    }

    public abstract void perform(CommandSender sender, String[] args);
}
