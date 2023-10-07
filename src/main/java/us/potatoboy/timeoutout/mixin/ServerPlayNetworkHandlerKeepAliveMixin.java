package us.potatoboy.timeoutout.mixin;

import net.minecraft.server.network.ServerPlayNetworkHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import us.potatoboy.timeoutout.TimeOutOut;

@Mixin(ServerPlayNetworkHandler.class)
public final class ServerPlayNetworkHandlerKeepAliveMixin {

    @ModifyConstant(method = "tick", constant = {
            @Constant(longValue = 60L)
    })
    private long getKeepAlivePacketInterval(long interval) {
        return TimeOutOut.getConfig().keepAliveTimeoutSeconds * 1000L;
    }
}
