package minegenshin.wrong.init;

import minegenshin.wrong.client.render.skill.NoContentRender.RenderDilucBurst1;
import minegenshin.wrong.client.render.skill.NoContentRender.RenderDilucBurst2;
import minegenshin.wrong.client.render.skill.NoContentRender.RenderDilucBurst3;
import minegenshin.wrong.client.render.skill.RenderDilucBurst;
import minegenshin.wrong.client.render.skill.RenderWendyAttack;
import minegenshin.wrong.client.render.skill.RenderWendyBurst;
import minegenshin.wrong.entity.skill.diluc.EntityDilucBurst;
import minegenshin.wrong.entity.skill.diluc.EntityDilucSkillParticle1;
import minegenshin.wrong.entity.skill.diluc.EntityDilucSkillParticle2;
import minegenshin.wrong.entity.skill.diluc.EntityDilucSkillParticle3;
import minegenshin.wrong.entity.skill.wendy.EntityWendyAttack;
import minegenshin.wrong.entity.skill.wendy.EntityWendyBurst;
import net.minecraft.client.Minecraft;

public class RenderInit {

    public static void init(){
        Minecraft.getMinecraft().getRenderManager().entityRenderMap.put(EntityWendyBurst.class, new RenderWendyBurst(Minecraft.getMinecraft().getRenderManager()));
        Minecraft.getMinecraft().getRenderManager().entityRenderMap.put(EntityWendyAttack.class, new RenderWendyAttack(Minecraft.getMinecraft().getRenderManager()));
        Minecraft.getMinecraft().getRenderManager().entityRenderMap.put(EntityDilucBurst.class, new RenderDilucBurst(Minecraft.getMinecraft().getRenderManager()));
        Minecraft.getMinecraft().getRenderManager().entityRenderMap.put(EntityDilucSkillParticle1.class, new RenderDilucBurst1(Minecraft.getMinecraft().getRenderManager()));
        Minecraft.getMinecraft().getRenderManager().entityRenderMap.put(EntityDilucSkillParticle2.class, new RenderDilucBurst2(Minecraft.getMinecraft().getRenderManager()));
        Minecraft.getMinecraft().getRenderManager().entityRenderMap.put(EntityDilucSkillParticle3.class, new RenderDilucBurst3(Minecraft.getMinecraft().getRenderManager()));

    }
}
