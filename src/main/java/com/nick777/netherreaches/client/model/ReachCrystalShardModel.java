package com.nick777.netherreaches.client.model;
// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelBox;

public class ReachCrystalShardModel extends Model {
	private final RendererModel crystal_shard;

	public ReachCrystalShardModel() {
		textureWidth = 12;
		textureHeight = 8;

		crystal_shard = new RendererModel(this);
		crystal_shard.setRotationPoint(0.0F, 19.0F, 0.0F);
		crystal_shard.cubeList.add(new ModelBox(crystal_shard, 0, 0, -1.3125F, 0.0F, -2.75F, 2, 1, 4, 0.0F, false));
		crystal_shard.cubeList.add(new ModelBox(crystal_shard, 0, 0, -0.3125F, 0.0F, -1.75F, 2, 1, 3, 0.0F, false));
		crystal_shard.cubeList.add(new ModelBox(crystal_shard, 0, 0, -0.3125F, -4.0F, -0.75F, 1, 7, 1, 0.0F, false));
		crystal_shard.cubeList.add(new ModelBox(crystal_shard, 0, 0, -1.3125F, -2.0F, -1.75F, 2, 4, 2, 0.0F, false));
		crystal_shard.cubeList.add(new ModelBox(crystal_shard, 0, 0, 0.6875F, -1.0F, -0.75F, 1, 3, 1, 0.0F, false));
		crystal_shard.cubeList.add(new ModelBox(crystal_shard, 0, 0, -0.3125F, -2.0F, 0.25F, 1, 4, 1, 0.0F, false));
		crystal_shard.cubeList.add(new ModelBox(crystal_shard, 0, 0, -0.3125F, 0.0F, 1.25F, 1, 1, 1, 0.0F, false));
		crystal_shard.cubeList.add(new ModelBox(crystal_shard, 0, 0, -2.3125F, 0.0F, -0.75F, 1, 1, 1, 0.0F, false));
	}

	public void renderShard(float rotation, float scale) {
		crystal_shard.rotateAngleY = rotation;
		crystal_shard.render(scale);
	}

	public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

}