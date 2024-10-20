package com.github.pritam11638.bedwarsPlus.Commands.BedwarsPlus;

import com.github.pritam11638.bedwarsPlus.Command.MainCommand;
import com.github.pritam11638.bedwarsPlus.Commands.BedwarsPlus.SubCommands.SetHub;
import org.bukkit.permissions.Permission;

import java.awt.*;

public class BedwarsPlusCommand extends MainCommand {
    public BedwarsPlusCommand() {
        super(Color.RED + "[Bedwars+] Please provide an argument.", Color.RED + "[Bedwars+] You don't have the permission to use this command.");
        setupSubCommands();

        createHelpSubCommand(new Permission("bwp.admin"));
    }

    public void setupSubCommands() {
        addSubCommand(new SetHub());
    }
}
