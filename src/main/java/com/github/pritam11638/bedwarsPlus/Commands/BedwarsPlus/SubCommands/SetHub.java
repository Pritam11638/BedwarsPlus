package com.github.pritam11638.bedwarsPlus.Commands.BedwarsPlus.SubCommands;

import com.github.pritam11638.bedwarsPlus.Command.SubCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;

public class SetHub extends SubCommand {
    public SetHub() {
        super("set-hub", new Permission("bwp.admin"), "Sets the hub world and spawn location of the server.", null);
    }

    @Override
    public void perform(CommandSender sender, String[] args) {

    }
}
