package io.github.ivymc.ivycore.mixin;

import com.llamalad7.mixinextras.injector.ModifyReceiver;
import io.github.ivymc.ivycore.events.impl.ItemUseEvent;
import io.github.ivymc.ivycore.registry.RegistryManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.network.ServerPlayerInteractionManager;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import oshi.util.tuples.Pair;

@Mixin(ServerPlayerInteractionManager.class)
public class ServerPlayerInteractionManagerMixin {

    @ModifyReceiver(method = "interactItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;use(Lnet/minecraft/world/World;Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/Hand;)Lnet/minecraft/util/TypedActionResult;"))
    public ItemStack onItemUse(ItemStack itemStack,World world, PlayerEntity user, Hand hand) {
        if (!(user instanceof ServerPlayerEntity player)) return itemStack;

        ServerWorld serverWorld = player.getWorld();

        try {
            RegistryManager.ITEM_USE_REGISTRY.invoke(new Pair<>(RegistryManager.ITEM_USE_REGISTRY.getListValues(), new ItemUseEvent(serverWorld, player, itemStack)));
        } catch (Exception ignored) {}

        return itemStack;
    }
}
