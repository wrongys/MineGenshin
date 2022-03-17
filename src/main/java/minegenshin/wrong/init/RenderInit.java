package minegenshin.wrong.init;

import minegenshin.wrong.client.render.skill.RenderDilucBurst;
import minegenshin.wrong.client.render.skill.RenderWendyAttack;
import minegenshin.wrong.client.render.skill.RenderWendyBurst;
import minegenshin.wrong.entity.skill.diluc.EntityDilucBurst;
import minegenshin.wrong.entity.skill.wendy.EntityWendyAttack;
import minegenshin.wrong.entity.skill.wendy.EntityWendyBurst;
import net.minecraft.client.Minecraft;

public class RenderInit {

    public static void init(){
        Minecraft.getMinecraft().getRenderManager().entityRenderMap.put(EntityWendyBurst.class, new RenderWendyBurst(Minecraft.getMinecraft().getRenderManager()));
        Minecraft.getMinecraft().getRenderManager().entityRenderMap.put(EntityWendyAttack.class, new RenderWendyAttack(Minecraft.getMinecraft().getRenderManager()));
        Minecraft.getMinecraft().getRenderManager().entityRenderMap.put(EntityDilucBurst.class, new RenderDilucBurst(Minecraft.getMinecraft().getRenderManager()));

    }
}
