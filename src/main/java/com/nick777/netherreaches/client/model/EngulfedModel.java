package com.nick777.netherreaches.client.model;// Made with Blockbench 3.7.1
// Exported for Minecraft version 1.14
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.platform.GlStateManager;
import com.nick777.netherreaches.common.entity.creature.EngulfedEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.util.math.MathHelper;

public class EngulfedModel extends EntityModel<EngulfedEntity> {
    private final RendererModel leftLeg; //group
    private final RendererModel lowerLeftLeg_r1;
    private final RendererModel upperLeftLeg_r1;
    private final RendererModel rightLeg; // group
    private final RendererModel lowerRightLeg_r1;
    private final RendererModel upperRightLeg_r1;
    private final RendererModel head; // group
    private final RendererModel neck_r1;
    private final RendererModel mouth;
    private final RendererModel horns;
    private final RendererModel rightHorn_r1;
    private final RendererModel leftHorn_r1;
    private final RendererModel bb_main; // entire model group
    private final RendererModel body_r1; // body

    public EngulfedModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;

        this.leftLeg = new RendererModel(this);
        this.leftLeg.setRotationPoint(2.5F, 15.0F, 0.5F);
        this.leftLeg.cubeList.add(new ModelBox(leftLeg, 11, 45, -1.5F, 7.0F, -4.0F, 3, 2, 6, 0.0F, false));

        this.lowerLeftLeg_r1 = new RendererModel(this);
        this.lowerLeftLeg_r1.setRotationPoint(-2.0F, 2.5F, 0.75F);
        this.leftLeg.addChild(lowerLeftLeg_r1);
        setRotationAngle(lowerLeftLeg_r1, 1.0472F, 0.0F, 0.0F);
        this.lowerLeftLeg_r1.cubeList.add(new ModelBox(lowerLeftLeg_r1, 10, 13, 1.0F, 0.5F, -4.75F, 2, 3, 7, 0.0F, false));

        this.upperLeftLeg_r1 = new RendererModel(this);
        this.upperLeftLeg_r1.setRotationPoint(-1.5F, 0.0F, 0.0F);
        this.leftLeg.addChild(upperLeftLeg_r1);
        setRotationAngle(upperLeftLeg_r1, 0.6545F, 0.0F, 0.0F);
        this.upperLeftLeg_r1.cubeList.add(new ModelBox(upperLeftLeg_r1, 0, 10, 0.0F, -1.0F, -1.5F, 3, 7, 3, 0.0F, false));

        this.rightLeg = new RendererModel(this);
        this.rightLeg.setRotationPoint(-2.25F, 15.0F, 0.5F);
        this.rightLeg.cubeList.add(new ModelBox(rightLeg, 6, 35, -1.75F, 7.0F, -4.0F, 3, 2, 6, 0.0F, true));

        this.lowerRightLeg_r1 = new RendererModel(this);
        this.lowerRightLeg_r1.setRotationPoint(1.75F, 2.5F, 0.75F);
        this.rightLeg.addChild(lowerRightLeg_r1);
        setRotationAngle(lowerRightLeg_r1, 1.0472F, 0.0F, 0.0F);
        this.lowerRightLeg_r1.cubeList.add(new ModelBox(lowerRightLeg_r1, 11, 25, -3.0F, 0.5F, -4.75F, 2, 3, 7, 0.0F, true));

        this.upperRightLeg_r1 = new RendererModel(this);
        this.upperRightLeg_r1.setRotationPoint(1.25F, 0.0F, 0.0F);
        this.rightLeg.addChild(upperRightLeg_r1);
        setRotationAngle(upperRightLeg_r1, 0.6545F, 0.0F, 0.0F);
        this.upperRightLeg_r1.cubeList.add(new ModelBox(upperRightLeg_r1, 0, 20, -3.0F, -1.0F, -1.5F, 3, 7, 3, 0.0F, true));

        this.head = new RendererModel(this);
        this.head.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.head.cubeList.add(new ModelBox(head, 22, 20, -3.5F, -6.0F, -3.5F, 7, 5, 6, 0.0F, false));

        this.neck_r1 = new RendererModel(this);
        this.neck_r1.setRotationPoint(0.0F, -0.5F, 0.0F);
        this.head.addChild(neck_r1);
        setRotationAngle(neck_r1, 0.3054F, 0.0F, 0.0F);
        this.neck_r1.cubeList.add(new ModelBox(neck_r1, 30, 31, -2.0F, -2.5F, -2.0F, 4, 5, 4, 0.0F, false));

        this.mouth = new RendererModel(this);
        this.mouth.setRotationPoint(0.0F, -2.0F, -3.0F);
        this.head.addChild(mouth);
        this.mouth.cubeList.add(new ModelBox(mouth, 24, 42, -3.5F, 0.0F, -4.5F, 7, 1, 5, 0.0F, false));
        this.mouth.cubeList.add(new ModelBox(mouth, 0, 0, -3.5F, -2.0F, -4.5F, 7, 2, 5, 0.0F, false));

        this.horns = new RendererModel(this);
        this.horns.setRotationPoint(0.0F, -6.0F, 2.0F);
        this.head.addChild(horns);


        this.rightHorn_r1 = new RendererModel(this);
        this.rightHorn_r1.setRotationPoint(-3.5F, 0.0F, -0.5F);
        this.horns.addChild(rightHorn_r1);
        setRotationAngle(rightHorn_r1, 0.2182F, -0.3491F, 0.0F);
        this.rightHorn_r1.cubeList.add(new ModelBox(rightHorn_r1, 0, 32, 0.0F, 0.0F, -1.0F, 1, 1, 5, 0.0F, true));

        this.leftHorn_r1 = new RendererModel(this);
        this.leftHorn_r1.setRotationPoint(3.5F, 0.0F, -0.5F);
        this.horns.addChild(leftHorn_r1);
        setRotationAngle(leftHorn_r1, 0.2182F, 0.3491F, 0.0F);
        this.leftHorn_r1.cubeList.add(new ModelBox(leftHorn_r1, 0, 32, -1.0F, 0.0F, -1.0F, 1, 1, 5, 0.0F, false));

        this.bb_main = new RendererModel(this);
        this.bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);


        this.body_r1 = new RendererModel(this);
        this.body_r1.setRotationPoint(0.0F, -15.0F, 1.0F);
        this.bb_main.addChild(body_r1);
        setRotationAngle(body_r1, 0.0436F, 0.0F, 0.0F);
        this.body_r1.cubeList.add(new ModelBox(body_r1, 24, 0, -3.0F, -7.0F, -3.0F, 6, 14, 6, 0.0F, false));
    }

    @Override
    public void render(EngulfedEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);

        GlStateManager.pushMatrix();

        this.leftLeg.render(scale);
        this.rightLeg.render(scale);
        this.head.render(scale);
        this.bb_main.render(scale);

        GlStateManager.popMatrix();
    }

    public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(EngulfedEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
        this.head.rotateAngleX = headPitch * 0.017453292f + 0.17453292519943295f;
        this.head.rotateAngleY = netHeadYaw * 0.017453292f;
        this.bb_main.rotateAngleX = 0f;
        this.leftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.rightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + (float) Math.PI) * 1.4f * limbSwingAmount;
        this.head.rotationPointX = 0f;
    }
}