package fun.lewisdev.deluxehub.command.commands;

import cl.bgmp.minecraft.util.commands.CommandContext;
import cl.bgmp.minecraft.util.commands.annotations.Command;
import cl.bgmp.minecraft.util.commands.exceptions.CommandException;
import fun.lewisdev.deluxehub.DeluxeHubPlugin;
import fun.lewisdev.deluxehub.Permissions;
import fun.lewisdev.deluxehub.config.Messages;
import fun.lewisdev.deluxehub.module.ModuleType;
import fun.lewisdev.deluxehub.module.modules.player.BuildMode;
import fun.lewisdev.deluxehub.module.modules.world.LobbySpawn;
import fun.lewisdev.deluxehub.utility.TextUtil;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Set;
import java.util.UUID;

@RequiredArgsConstructor
public class BuildModeCommand {

    private final DeluxeHubPlugin plugin;

    @Command(
            aliases = {"buildmode", "build", "buildermode"},
            desc = "Build mode"
    )
    public void lobby(final CommandContext args, final CommandSender sender) throws CommandException {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You can't execute this command from console.");
            return;
        }
        Player player = (Player) sender;
        if (!(player.hasPermission(Permissions.COMMAND_CLEARCHAT.getPermission()))) {
            Messages.NO_PERMISSION.send(player);
            return;
        }
        player.setGameMode(GameMode.CREATIVE);

        BuildMode buildMode = ((BuildMode) plugin.getModuleManager().getModule(ModuleType.BUILD_MODE));
        if(buildMode.isBuilder(player)) {
            buildMode.disableMode(player);
            Messages.BUILD_MODE_DISABLED.send(player);
            return;
        }
        buildMode.enableMode(player);
        Messages.BUILD_MODE_ENABLED.send(player);
    }
}