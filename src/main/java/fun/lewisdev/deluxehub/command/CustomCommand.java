package fun.lewisdev.deluxehub.command;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CustomCommand {

    private String permission;
    private List<String> aliases, actions;

    public CustomCommand(String command, List<String> actions) {
        this.aliases = new ArrayList<>();
        this.aliases.add(command);
        this.actions = actions;
    }

    public void addAliases(List<String> aliases) {
        this.aliases.addAll(aliases);
    }
}
