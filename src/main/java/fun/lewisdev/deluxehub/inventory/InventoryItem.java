package fun.lewisdev.deluxehub.inventory;

import lombok.Data;
import lombok.Getter;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

@Data
public class InventoryItem {

    public final ItemStack itemStack;
    public final List<ClickAction> clickActions;

    public InventoryItem(final ItemStack itemStack) {
        this.clickActions = new ArrayList<>();
        this.itemStack = itemStack;
    }

    public InventoryItem addClickAction(final ClickAction clickAction) {
        this.clickActions.add(clickAction);
        return this;
    }
}
