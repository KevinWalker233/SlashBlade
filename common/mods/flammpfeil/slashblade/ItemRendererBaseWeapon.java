package mods.flammpfeil.slashblade;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.ForgeSubscribe;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

public class ItemRendererBaseWeapon implements IItemRenderer {

	static TextureManager engine(){
		return FMLClientHandler.instance().getClient().renderEngine;
	}

	static ResourceLocation bladeTexture = new ResourceLocation("flammpfeil.slashblade:blade.png");
	static ResourceLocation scabbardTexture = new ResourceLocation("flammpfeil.slashblade:scabbard.png");
    private static final ResourceLocation armoredCreeperTextures = new ResourceLocation("textures/entity/creeper/creeper_armor.png");
    private static final ResourceLocation RES_ITEM_GLINT = new ResourceLocation("textures/misc/enchanted_item_glint.png");

	static ModelBaseWeapon model = new ModelBaseWeapon();
	static ModelBase model2 = new ModelBaseWeaponCase();

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {

		switch (type) {
		case ENTITY:
			return true;
		case EQUIPPED:
			return true;
		case INVENTORY:
			return true;
		default:
			return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {
		switch (helper) {
		case ENTITY_ROTATION:
			return true;
		default:
			return false;
		}
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {

		boolean isBroken = false;
		if(item.hasTagCompound()){
			NBTTagCompound tag = item.getTagCompound();

			isBroken = tag.getBoolean("isBroken");
		}
		model.isBroken = isBroken;

    	model.isEntity = true;

		switch (type) {
		case ENTITY:
			float scale = 0.05f;
			GL11.glScalef(scale,scale,scale);
			GL11.glTranslatef(10, 20,0);
			GL11.glRotatef(140.0f, 0, 0,1.0f);
			engine().bindTexture(bladeTexture);
			model.render(null, 0, 0, 0, 0, 0, 1.0f);


            if (item.hasEffect(0))
            {
				GL11.glPushAttrib(GL11.GL_ALL_ATTRIB_BITS);
                GL11.glDepthFunc(GL11.GL_EQUAL);
                GL11.glDisable(GL11.GL_LIGHTING);
                engine().bindTexture(RES_ITEM_GLINT);
                GL11.glEnable(GL11.GL_BLEND);
                GL11.glBlendFunc(GL11.GL_SRC_COLOR, GL11.GL_ONE);
                float f7 = 0.76F;
                GL11.glColor4f(0.5F * f7, 0.25F * f7, 0.8F * f7, 1.0F);
                GL11.glMatrixMode(GL11.GL_TEXTURE);
                GL11.glPushMatrix();
                float f8 = 0.125F;
                GL11.glScalef(f8, f8, f8);
                float f9 = (float)(Minecraft.getSystemTime() % 3000L) / 3000.0F * 8.0F;
                GL11.glTranslatef(f9, 0.0F, 0.0F);
                GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
    			model.render(null, 0, 0, 0, 0, 0, 1.0f);
                GL11.glPopMatrix();
                GL11.glPushMatrix();
                GL11.glScalef(f8, f8, f8);
                f9 = (float)(Minecraft.getSystemTime() % 4873L) / 4873.0F * 8.0F;
                GL11.glTranslatef(-f9, 0.0F, 0.0F);
                GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
    			model.render(null, 0, 0, 0, 0, 0, 1.0f);
                GL11.glPopMatrix();
                GL11.glMatrixMode(GL11.GL_MODELVIEW);
                GL11.glDisable(GL11.GL_BLEND);
                GL11.glEnable(GL11.GL_LIGHTING);
                GL11.glDepthFunc(GL11.GL_LEQUAL);
				GL11.glPopAttrib();
            }



			GL11.glTranslatef(-4, 7,2);
			engine().bindTexture(scabbardTexture);
			model2.render(null,0, 0, 0, 0, 0, 1.0f);
			return;

		case INVENTORY:
			scale = 0.7f;
			GL11.glScalef(scale,scale,scale);
			GL11.glTranslatef(1, 2,0);
			GL11.glRotatef(-50.0f, 0, 0,1.0f);
			engine().bindTexture(bladeTexture);
			model.render(null, 0, 0, 0, 0, 0, 1.0f);

            if (item.hasEffect(0))
            {
				GL11.glPushAttrib(GL11.GL_ALL_ATTRIB_BITS);
                GL11.glDepthFunc(GL11.GL_EQUAL);
                GL11.glDisable(GL11.GL_LIGHTING);
                engine().bindTexture(RES_ITEM_GLINT);
                GL11.glEnable(GL11.GL_BLEND);
                GL11.glBlendFunc(GL11.GL_SRC_COLOR, GL11.GL_ONE);
                float f7 = 0.76F;
                GL11.glColor4f(0.5F * f7, 0.25F * f7, 0.8F * f7, 1.0F);
                GL11.glMatrixMode(GL11.GL_TEXTURE);
                GL11.glPushMatrix();
                float f8 = 0.125F;
                GL11.glScalef(f8, f8, f8);
                float f9 = (float)(Minecraft.getSystemTime() % 3000L) / 3000.0F * 8.0F;
                GL11.glTranslatef(f9, 0.0F, 0.0F);
                GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
    			model.render(null, 0, 0, 0, 0, 0, 1.0f);
                GL11.glPopMatrix();
                GL11.glPushMatrix();
                GL11.glScalef(f8, f8, f8);
                f9 = (float)(Minecraft.getSystemTime() % 4873L) / 4873.0F * 8.0F;
                GL11.glTranslatef(-f9, 0.0F, 0.0F);
                GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
    			model.render(null, 0, 0, 0, 0, 0, 1.0f);
                GL11.glPopMatrix();
                GL11.glMatrixMode(GL11.GL_MODELVIEW);
                GL11.glDisable(GL11.GL_BLEND);
                GL11.glEnable(GL11.GL_LIGHTING);
                GL11.glDepthFunc(GL11.GL_LEQUAL);
				GL11.glPopAttrib();
            }

			GL11.glTranslatef(-4, 7,2);
			engine().bindTexture(scabbardTexture);
			model2.render(null,0, 0, 0, 0, 0, 1.0f);
			return;
		case EQUIPPED:
			if(data[1] instanceof EntityPlayer){
				return;
			}
		default:
			break;
		}
    	model.isEntity = false;

    	{
			float scale = 0.05f;
			model.isBroken = false;
			//scale = 0.7f;
			GL11.glScalef(scale,scale,scale);
			GL11.glRotatef(-45.0f, 0, 0,1.0f);

			ticks += 0.1f;
			ticks %= 10.0f;

			GL11.glTranslatef(12.5f,11.0f,0.0f);


			GL11.glRotatef(85.0f, 0, 0,1.0f);
			engine().bindTexture(bladeTexture);
			model.render(null, 0, 0, 0, 0, 0, 1.0f);


			//GL11.glTranslatef(-4, 7,2);
			GL11.glTranslatef(-0.5f, 7,-0.25f);
			GL11.glScalef(1.4f,0.9f,1.4f);
			engine().bindTexture(scabbardTexture);
			model2.render(null,0, 0, 0, 0, 0, 1.0f);
    	}
	}
	static float ticks = 0.0f;


	@ForgeSubscribe
	public void RenderPlayerEventPre(RenderPlayerEvent.Pre event){
		float partialRenderTick = event.partialRenderTick;
		EntityPlayer player = event.entityPlayer;
		render(player,partialRenderTick);
	}

    static private float interpolateRotation(float par1, float par2, float par3)
    {
        float f3;

        for (f3 = par2 - par1; f3 < -180.0F; f3 += 360.0F)
        {
            ;
        }

        while (f3 >= 180.0F)
        {
            f3 -= 360.0F;
        }

        return par1 + par3 * f3;
    }

	static public void render(EntityPlayer player,float partialRenderTick)
	{
		if(player == null)
			return;
		ItemStack item = player.getCurrentEquippedItem();

		if(item == null || item.itemID != SlashBlade.weapon.itemID)
			return;

		boolean isEnchanted = item.isItemEnchanted();
		boolean isBewitched = item.hasDisplayName() && isEnchanted;

		float progress = player.prevSwingProgress + (player.swingProgress - player.prevSwingProgress) * partialRenderTick;

		int charge = player.getItemInUseDuration();

		boolean isBroken = false;
		int combo = 0;
		if(item.hasTagCompound()){
			NBTTagCompound tag = item.getTagCompound();

			isBroken = tag.getBoolean("isBroken");

			combo = tag.getInteger("comboSeq");
		}


		if(combo <= 2){
		}else{
			progress *= 1.2f;
		}

		model.isBroken = isBroken;
		model.isEntity = false;

		float rotate = 0.0f;
		float x = 0;
		float y = 0;
		float z = 0;

		GL11.glPushMatrix();{
	        float f1 = interpolateRotation(player.prevRenderYawOffset, player.renderYawOffset, partialRenderTick);
			GL11.glRotatef(f1, 0.0F, -1.0F, 0.0F);
			GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);



			GL11.glTranslatef(SlashBlade.offsetX,SlashBlade.offsetY,SlashBlade.offsetZ);

			//-----------------------------------------------------------------------------------------------------------------------
			GL11.glPushMatrix();{
				/*
				if(item.hasTagCompound()){
					NBTTagCompound tag = item.getTagCompound();

					int combo = tag.getInteger("comboSeq");
					if(combo == 3){
					}else{
					}
				}
				*/


				GL11.glRotatef(progress * 220.0f, -1.0f, 1.75f, 0f);
				//if(progress > 0.5f)
				//	progress = 1.0f - progress;
				//progress *= 2;

				GL11.glTranslatef(0.3f,0.5f,-0.3f);

				GL11.glRotatef(60.0f, 1, 0, 0);
				GL11.glRotatef(-20.0f, 0, 0, 1);

				GL11.glRotatef(90.0f, 0, 1.0f, 0);
				float scale = (float)(0.075f);
				GL11.glScalef(scale*0.7f, scale, scale*0.5f);
				GL11.glTranslatef(-1f,-5.5f,-0.5f);

				engine().bindTexture(bladeTexture);

				model.render(null, x, y, z, 0, 0, 1.0f);

				if(isEnchanted && (0 < progress && !(combo <= 2))){
					GL11.glPushAttrib(GL11.GL_ALL_ATTRIB_BITS);
					GL11.glEnable(GL11.GL_BLEND);
					GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
					model.render(null, x, y, z, 0, 0, 1.0f);
					GL11.glPopAttrib();
				}

			}GL11.glPopMatrix();

			//-----------------------------------------------------------------------------------------------------------------------

			GL11.glPushMatrix();{

				if(combo <= 2){
					GL11.glRotatef(progress * 220, -1.0f, 1.75f, 0f);
				}else{
					GL11.glTranslatef(0.0f,0.0f,-0.0f);
				}

				GL11.glTranslatef(0.3f,0.5f,-0.3f);

				GL11.glRotatef(60.0f, 1, 0, 0);
				GL11.glRotatef(-20.0f, 0, 0, 1);

				GL11.glRotatef(90.0f, 0, 1.0f, 0);

				float scale = (float)(0.075f);
				GL11.glScalef(scale, scale, scale);
				GL11.glTranslatef(-1f,1.0f,-0.5f);

				engine().bindTexture(scabbardTexture);
				model2.render(null, x, y, z, 0, 0, 1.0f);


				if(isEnchanted && (ItemSlashBlade.RequiredChargeTick < charge || (0 < progress && combo == 5))){
					GL11.glPushMatrix();
					GL11.glPushAttrib(GL11.GL_ALL_ATTRIB_BITS);


					float offsetX = -1.0f;
					float offsetY = 0.0f;
					float offsetZ = -0.5f;
					float scaleX = 1.05f;
					float scaleY = 1.0125f;
					float scaleZ = 1.05f;
					GL11.glPushMatrix();
					GL11.glTranslatef(-offsetX,-offsetY,-offsetZ);
					GL11.glScalef(scaleX, scaleY, scaleZ);
					GL11.glTranslatef(offsetX,offsetY,offsetZ);

	                GL11.glEnable(GL11.GL_BLEND);
	                float f4 = 3.0F;
	                GL11.glColor4f(f4, f4, f4, 3.0F);
	                GL11.glDisable(GL11.GL_LIGHTING);
	                GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);

					model2.render(null, x, y, z, 0, 0, 1.0f);

	                GL11.glEnable(GL11.GL_LIGHTING);
	                GL11.glDisable(GL11.GL_BLEND);
					GL11.glPopMatrix();

					offsetX = -1.0f;
					offsetY = 0.0f;
					offsetZ = -0.5f;
					scaleX = 1.5f;
					scaleY = 1.025f;
					scaleZ = 1.5f;

					GL11.glTranslatef(-offsetX,-offsetY,-offsetZ);
					GL11.glScalef(scaleX, scaleY, scaleZ);
					GL11.glTranslatef(offsetX,offsetY,offsetZ);

	                float ff1 = (float)player.ticksExisted + partialRenderTick;
	                engine().bindTexture(armoredCreeperTextures);
	                GL11.glMatrixMode(GL11.GL_TEXTURE);
	                GL11.glLoadIdentity();
	                float f2 = ff1 * 0.01F;
	                float f3 = ff1 * 0.01F;
	                GL11.glTranslatef(f2, f3, 0.0F);
	                GL11.glMatrixMode(GL11.GL_MODELVIEW);
	                GL11.glEnable(GL11.GL_BLEND);
	                f4 = 1.0F;
	                GL11.glColor4f(f4, f4, f4, 1.0F);
	                GL11.glDisable(GL11.GL_LIGHTING);
	                GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);

					model2.render(null, x, y, z, 0, 0, 1.0f);

	                GL11.glMatrixMode(GL11.GL_TEXTURE);
	                GL11.glLoadIdentity();
	                GL11.glMatrixMode(GL11.GL_MODELVIEW);
	                GL11.glEnable(GL11.GL_LIGHTING);
	                GL11.glDisable(GL11.GL_BLEND);

					GL11.glPopAttrib();
					GL11.glPopMatrix();
				}
			}GL11.glPopMatrix();

			//-----------------------------------------------------------------------------------------------------------------------
		}GL11.glPopMatrix();
	}
}
