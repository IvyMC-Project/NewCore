package io.github.ivymc.ivycore.events.impl;

import io.github.ivymc.ivycore.events.Event;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;

public record ItemUseEvent(
        ServerWorld world,
        ServerPlayerEntity player,
        ItemStack itemStack
) implements Event {
    @Override
    public Class<ItemUseEvent> getType() {
        return ItemUseEvent.class;
    }
}
