package com.example.bulletfix.mixin;

import com.mrcrayfish.guns.entity.ProjectileEntity;
import java.util.function.Predicate;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.mod.common.world.RaycastUtilsKt;

@Mixin(
        value = {ProjectileEntity.class},
        remap = false
)
public abstract class MixinProjectileEntity<T> {
  @Inject(
          method = {"Lcom/mrcrayfish/guns/entity/ProjectileEntity;rayTraceBlocks(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/level/ClipContext;Ljava/util/function/Predicate;)Lnet/minecraft/world/phys/BlockHitResult;"},
          at = {@At("HEAD")},
          cancellable = true
  )
  private static void injectRayTraceBlocks(Level world, ClipContext context, Predicate<BlockState> ignorePredicate, CallbackInfoReturnable<BlockHitResult> cir) {
    cir.setReturnValue(RaycastUtilsKt.clipIncludeShips(world, context));
  }
}
