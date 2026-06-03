package kobber.flamyflames;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.AddPackFindersEvent;

@Mod(FlamyFlames.MODID)
@EventBusSubscriber(modid = FlamyFlames.MODID)
public class FlamyFlames {
    public static final String MODID = "flamyflames";

    public FlamyFlames() {}

    @SubscribeEvent
    public static void onAddPackFinders(AddPackFindersEvent event) {
        event.addPackFinders(
                ResourceLocation.fromNamespaceAndPath(MODID, "flamyflames"),
                PackType.CLIENT_RESOURCES,
                Component.literal("Flamy Flames"),
                PackSource.BUILT_IN,
                true,
                Pack.Position.TOP
        );
    }
}
