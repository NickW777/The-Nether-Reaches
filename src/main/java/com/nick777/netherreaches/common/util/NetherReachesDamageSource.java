package com.nick777.netherreaches.common.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import static com.nick777.netherreaches.NetherReaches.MODID;

public class NetherReachesDamageSource extends DamageSource {

    public NetherReachesDamageSource(String damageType) {
        super(damageType);
    }
    @Override
    public ITextComponent getDeathMessage(LivingEntity entity) {
        return new TranslationTextComponent("death."+ MODID + "." + damageType, entity.getDisplayName());
    }
}
