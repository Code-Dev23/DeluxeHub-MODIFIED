package fun.lewisdev.deluxehub.module.modules.player;

import fun.lewisdev.deluxehub.DeluxeHubPlugin;
import fun.lewisdev.deluxehub.module.Module;
import fun.lewisdev.deluxehub.module.ModuleType;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
public class BuildMode extends Module {

    private final Set<UUID> builders = new HashSet<>();

    public BuildMode(DeluxeHubPlugin plugin) {
        super(plugin, ModuleType.BUILD_MODE);
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        builders.remove(event.getPlayer().getUniqueId());
    }

    public boolean isBuilder(Player player) {
        return builders.contains(player.getUniqueId());
    }
    public boolean isBuilder(UUID uuid) {
        return builders.contains(uuid);
    }

    public void disableMode(Player player) {
        builders.remove(player.getUniqueId());
    }
    public void enableMode(Player player) {
        builders.add(player.getUniqueId());
    }
}