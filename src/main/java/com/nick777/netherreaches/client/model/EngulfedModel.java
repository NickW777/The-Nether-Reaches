package com.nick777.netherreaches.client.model;// Made with Blockbench 3.7.1
// Exported for Minecraft version 1.14
// Paste this class into your mod and generate all required imports


import com.nick777.netherreaches.common.entity.creature.EngulfedEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;

public class EngulfedModel extends EntityModel<EngulfedEntity> {
    private final RendererModel leftLeg;
    private final RendererModel lowerLeftLeg_r1;
    private final RendererModel upperLeftLeg_r1;
    private final RendererModel rightLeg;
    private final RendererModel lowerRightLeg_r1;
    private final RendererModel upperRightLeg_r1;
    private final RendererModel head;
    private final RendererModel neck_r1;
    private final RendererModel mouth;
    private final RendererModel horns;
    private final RendererModel rightHorn_r1;
    private final RendererModel leftHorn_r1;
    private final RendererModel bb_main;
    private final RendererModel body_r1;

    public EngulfedModel() {
        textureWidth = 64;
        textureHeight = 64;

        leftLeg = new RendererModel(this);
        leftLeg.setRotationPoint(2.5F, 15.0F, 0.5F);
        leftLeg.cubeList.add(new ModelBox(leftLeg, 11, 45, -1.5F, 7.0F, -4.0F, 3, 2, 6, 0.0F, false));

        lowerLeftLeg_r1 = new RendererModel(this);
        lowerLeftLeg_r1.setRotationPoint(-2.0F, 2.5F, 0.75F);
        leftLeg.addChild(lowerLeftLeg_r1);
        setRotationAngle(lowerLeftLeg_r1, 1.0472F, 0.0F, 0.0F);
        lowerLeftLeg_r1.cubeList.add(new ModelBox(lowerLeftLeg_r1, 10, 13, 1.0F, 0.5F, -4.75F, 2, 3, 7, 0.0F, false));

        upperLeftLeg_r1 = new RendererModel(this);
        upperLeftLeg_r1.setRotationPoint(-1.5F, 0.0F, 0.0F);
        leftLeg.addChild(upperLeftLeg_r1);
        setRotationAngle(upperLeftLeg_r1, 0.6545F, 0.0F, 0.0F);
        upperLeftLeg_r1.cubeList.add(new ModelBox(upperLeftLeg_r1, 0, 10, 0.0F, -1.0F, -1.5F, 3, 7, 3, 0.0F, false));

        rightLeg = new RendererModel(this);
        rightLeg.setRotationPoint(-2.25F, 15.0F, 0.5F);
        rightLeg.cubeList.add(new ModelBox(rightLeg, 6, 35, -1.75F, 7.0F, -4.0F, 3, 2, 6, 0.0F, true));

        lowerRightLeg_r1 = new RendererModel(this);
        lowerRightLeg_r1.setRotationPoint(1.75F, 2.5F, 0.75F);
        rightLeg.addChild(lowerRightLeg_r1);
        setRotationAngle(lowerRightLeg_r1, 1.0472F, 0.0F, 0.0F);
        lowerRightLeg_r1.cubeList.add(new ModelBox(lowerRightLeg_r1, 11, 25, -3.0F, 0.5F, -4.75F, 2, 3, 7, 0.0F, true));

        upperRightLeg_r1 = new RendererModel(this);
        upperRightLeg_r1.setRotationPoint(1.25F, 0.0F, 0.0F);
        rightLeg.addChild(upperRightLeg_r1);
        setRotationAngle(upperRightLeg_r1, 0.6545F, 0.0F, 0.0F);
        upperRightLeg_r1.cubeList.add(new ModelBox(upperRightLeg_r1, 0, 20, -3.0F, -1.0F, -1.5F, 3, 7, 3, 0.0F, true));

        head = new RendererModel(this);
        head.setRotationPoint(0.0F, 2.0F, 0.0F);
        head.cubeList.add(new ModelBox(head, 22, 20, -3.5F, -6.0F, -3.5F, 7, 5, 6, 0.0F, false));

        neck_r1 = new RendererModel(this);
        neck_r1.setRotationPoint(0.0F, -0.5F, 0.0F);
        head.addChild(neck_r1);
        setRotationAngle(neck_r1, 0.3054F, 0.0F, 0.0F);
        neck_r1.cubeList.add(new ModelBox(neck_r1, 30, 31, -2.0F, -2.5F, -2.0F, 4, 5, 4, 0.0F, false));

        mouth = new RendererModel(this);
        mouth.setRotationPoint(0.0F, -2.0F, -3.0F);
        head.addChild(mouth);
        mouth.cubeList.add(new ModelBox(mouth, 24, 42, -3.5F, 0.0F, -4.5F, 7, 1, 5, 0.0F, false));
        mouth.cubeList.add(new ModelBox(mouth, 0, 0, -3.5F, -2.0F, -4.5F, 7, 2, 5, 0.0F, false));

        horns = new RendererModel(this);
        horns.setRotationPoint(0.0F, -6.0F, 2.0F);
        head.addChild(horns);


        rightHorn_r1 = new RendererModel(this);
        rightHorn_r1.setRotationPoint(-3.5F, 0.0F, -0.5F);
        horns.addChild(rightHorn_r1);
        setRotationAngle(rightHorn_r1, 0.2182F, -0.3491F, 0.0F);
        rightHorn_r1.cubeList.add(new ModelBox(rightHorn_r1, 0, 32, 0.0F, 0.0F, -1.0F, 1, 1, 5, 0.0F, true));

        leftHorn_r1 = new RendererModel(this);
        leftHorn_r1.setRotationPoint(3.5F, 0.0F, -0.5F);
        horns.addChild(leftHorn_r1);
        setRotationAngle(leftHorn_r1, 0.2182F, 0.3491F, 0.0F);
        leftHorn_r1.cubeList.add(new ModelBox(leftHorn_r1, 0, 32, -1.0F, 0.0F, -1.0F, 1, 1, 5, 0.0F, false));

        bb_main = new RendererModel(this);
        bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);


        body_r1 = new RendererModel(this);
        body_r1.setRotationPoint(0.0F, -15.0F, 1.0F);
        bb_main.addChild(body_r1);
        setRotationAngle(body_r1, 0.0436F, 0.0F, 0.0F);
        body_r1.cubeList.add(new ModelBox(body_r1, 24, 0, -3.0F, -7.0F, -3.0F, 6, 14, 6, 0.0F, false));
    }

    @Override
    public void render(EngulfedEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        leftLeg.render(scale);
        rightLeg.render(scale);
        head.render(scale);
        bb_main.render(scale);
    }

    public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}