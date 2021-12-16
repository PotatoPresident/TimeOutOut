package eu.houbystudio.timeoutout.mixin;

import eu.houbystudio.timeoutout.TimeOutOut;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Debug(export = true)
@Mixin(targets = {
        "net/minecraft/network/ClientConnection$1",
        "net/minecraft/server/ServerNetworkIo$1"
})
public abstract class ChannelInitializerMixin {
    @ModifyArg(method = "initChannel(Lio/netty/channel/Channel;)V", at = @At(
            value = "INVOKE",
            target = "io/netty/handler/timeout/ReadTimeoutHandler.<init> (I)V"
    ))
    private int getReadTimeout(int timeout) {
        return TimeOutOut.getConfig().readTimeoutSeconds;
    }
}
