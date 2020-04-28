package com.nick777.netherreaches.common.effect;

import com.nick777.netherreaches.common.util.NetherReachesDamageSource;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.util.DamageSource;

public class ShockEffect extends Effect {
    private static final String ATTACK_SPEED_ID = "f4dfb9fb-09bd-478d-914d-c52afec2e42d";
    private static final String MOVEMENT_SPEED_ID = "e310a059-3b41-4ae0-a79b-d18db46c418e";
    private static final DamageSource SHOCK_DAMAGE = new NetherReachesDamageSource("shocked").setMagicDamage();
    public ShockEffect() {
        super(EffectType.HARMFUL,0x0);
        addAttributesModifier(SharedMonsterAttributes.ATTACK_SPEED, ATTACK_SPEED_ID,-0.5, AttributeModifier.Operation.ADDITION);
        addAttributesModifier(SharedMonsterAttributes.MOVEMENT_SPEED, MOVEMENT_SPEED_ID,-1.0, AttributeModifier.Operation.ADDITION);
    }

    @Override
    public void performEffect(LivingEntity entity, int amplifier) {
            entity.attackEntityFrom(SHOCK_DAMAGE, 2f);
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return duration == 80;
    }
}
