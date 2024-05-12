package fun.lewisdev.deluxehub.module.modules.visual.scoreboard;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class ScoreUpdateTask implements Runnable {

    private final ScoreboardManager scoreboardManager;

    @Override
    public void run() {
        List<UUID> toRemove = new ArrayList<>();
        scoreboardManager.getPlayers().forEach(uuid -> {
            if (scoreboardManager.updateScoreboard(uuid) == null) toRemove.add(uuid);
        });
        scoreboardManager.getPlayers().removeAll(toRemove);
    }

}
