package fun.lewisdev.deluxehub.module.modules.visual.tablist;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class TablistUpdateTask implements Runnable {

    private final TablistManager tablistManager;

    @Override
    public void run() {
        List<UUID> toRemove = new ArrayList<>();
        tablistManager.getPlayers().forEach(uuid -> {
            if (!tablistManager.updateTablist(uuid)) toRemove.add(uuid);
        });
        tablistManager.getPlayers().removeAll(toRemove);
    }

}
