package org.samo_lego.taterzens.forge;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.samo_lego.taterzens.Taterzens;
import org.samo_lego.taterzens.forge.event.EventHandler;
import org.samo_lego.taterzens.forge.platform.ForgePlatform;
import org.samo_lego.taterzens.npc.TaterzenNPC;
import org.samo_lego.taterzens.storage.TaterConfig;

import static org.samo_lego.taterzens.Taterzens.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@Mod(MOD_ID)
public class TaterzensForge {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE_REGISTER = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MOD_ID);

    public TaterzensForge() {
        var evtBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(new EventHandler());
        ENTITY_TYPE_REGISTER.register(evtBus);

        new Taterzens(new ForgePlatform());
    }
}