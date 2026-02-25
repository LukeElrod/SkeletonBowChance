package com.lukeelrod.bowchance;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.IntValue BOW_CHANCE = BUILDER
            .comment("The percent chance for a skeleton to spawn with a bow.")
            .defineInRange("bowChance", 50, 0, 100);

    static final ModConfigSpec SPEC = BUILDER.build();
}
