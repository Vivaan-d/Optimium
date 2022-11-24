package mods.vivaanmc.optimium.client.gui.options;

import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public enum OptionImpact implements TextProvider {
    LOW(Formatting.GREEN, "optimium.option_impact.low"),
    MEDIUM(Formatting.YELLOW, "optimium.option_impact.medium"),
    HIGH(Formatting.GOLD, "optimium.option_impact.high"),
    VARIES(Formatting.WHITE, "optimium.option_impact.varies");

    private final Text text;

    OptionImpact(Formatting color, String text) {
        this.text = Text.translatable(text).formatted(color);
    }

    @Override
    public Text getLocalizedName() {
        return this.text;
    }
}
