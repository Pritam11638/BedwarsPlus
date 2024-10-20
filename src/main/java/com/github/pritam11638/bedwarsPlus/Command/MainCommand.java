package com.github.pritam11638.bedwarsPlus.Command;

import org.bukkit.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.permissions.Permission;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class MainCommand implements CommandExecutor, TabCompleter {
    Set<SubCommand> subCommands = new HashSet<>();

    String noArgsMessage;
    String noPermissionMessage;

    public MainCommand(String noArgsMessageT, String noPermissionMessageT) {
        noArgsMessage = noArgsMessageT;
        noPermissionMessage = noPermissionMessageT;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (args.length == 0) {
            boolean returnV = perform();
            if (!returnV) {
                sender.sendMessage(noArgsMessage);
            }
            return true;
        }

        for (SubCommand subCommand : subCommands) {
            if (args[0].equalsIgnoreCase(subCommand.getName())) {
                if (!sender.hasPermission(subCommand.getPermission())) {
                    sender.sendMessage(noPermissionMessage);
                    return true;
                }

                String[] newArgs = new String[args.length - 1];

                System.arraycopy(args, 1, newArgs, 0, args.length - 1);

                subCommand.perform(sender, newArgs);
                return true;
            }
        }
        return true;
    }

    public void addSubCommand(SubCommand subCommand) {
        subCommands.add(subCommand);
    }

    public void createHelpSubCommand(Permission permission) {
        SubCommand helpSubCommand = new SubCommand("help", permission, "Shows the help page", new ArrayList<>()) {
            @Override
            public void perform(CommandSender sender, String[] args) {
                for (SubCommand subCommand : subCommands) {
                    sender.sendMessage(Color.GREEN + subCommand.getName() + Color.WHITE + " - " + Color.YELLOW +  subCommand.getHelpString());
                }
            }
        };

        subCommands.add(helpSubCommand);
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        ArrayList<String> tabCompletes = new ArrayList<>();

        if (args.length == 0) return null;

        if (args.length == 1) {
            for (SubCommand subCommand : subCommands) {
                if (sender.hasPermission(subCommand.getPermission())) {
                    tabCompletes.add(subCommand.getName());
                }
            }
        }

        if (args.length > 1) {
            for (SubCommand subCommand : subCommands) {
                if (args[0].equalsIgnoreCase(subCommand.getName())) {
                    if (subCommand.getTabCompletes() != null && !subCommand.getTabCompletes().isEmpty()) {
                        tabCompletes.addAll(subCommand.getTabCompletes());
                    }
                }
            }
        }

        return tabCompletes;
    }

    public boolean perform() {
        return false;
    }
}
