package io.github.ivymc.ivycore.events.impl;

import io.github.ivymc.ivycore.events.Event;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;

public class ItemUseEvent implements Event {
    private final ServerWorld word;
    private final ServerPlayerEntity player;
    private final ItemStack itemStack;

    @Override
    public Class<? extends Event> getType() {
        return ItemUseEvent.class;
    }

    public ItemUseEvent(ServerWorld world, ServerPlayerEntity player, ItemStack itemStack) {
        this.word = world;
        this.player = player;
        this.itemStack = itemStack;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public ServerPlayerEntity getPlayer() {
        return player;
    }

    public ServerWorld getWorld() {
        return word;
    }
}
