package minegenshin.wrong.client.model;// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDilucBurst extends ModelBiped {
    private final ModelRenderer zhengti;
    private final ModelRenderer bone6;
    private final ModelRenderer cube_r31;
    private final ModelRenderer cube_r32;
    private final ModelRenderer cube_r33;
    private final ModelRenderer cube_r34;
    private final ModelRenderer bone5;
    private final ModelRenderer cube_r27;
    private final ModelRenderer cube_r28;
    private final ModelRenderer cube_r29;
    private final ModelRenderer cube_r30;
    private final ModelRenderer bb_main;
    private final ModelRenderer bb_main_r2;
    private final ModelRenderer bb_main_r3;
    private final ModelRenderer bb_main_r1;
    private final ModelRenderer cube_r26;
    private final ModelRenderer shenti3_r1;
    private final ModelRenderer shenti2_r1;
    private final ModelRenderer chibangyou;
    private final ModelRenderer bone7;
    private final ModelRenderer cube_r19;
    private final ModelRenderer bone8;
    private final ModelRenderer cube_r20;
    private final ModelRenderer cube_r21;
    private final ModelRenderer bone9;
    private final ModelRenderer cube_r22;
    private final ModelRenderer cube_r23;
    private final ModelRenderer bone10;
    private final ModelRenderer cube_r24;
    private final ModelRenderer cube_r25;
    private final ModelRenderer chibangzuo;
    private final ModelRenderer bone4;
    private final ModelRenderer cube_r12;
    private final ModelRenderer bone3;
    private final ModelRenderer cube_r13;
    private final ModelRenderer cube_r14;
    private final ModelRenderer bone2;
    private final ModelRenderer cube_r15;
    private final ModelRenderer cube_r16;
    private final ModelRenderer bone;
    private final ModelRenderer cube_r17;
    private final ModelRenderer cube_r18;
    private final ModelRenderer weibu;
    private final ModelRenderer cube_r1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer cube_r3;
    private final ModelRenderer cube_r4;
    private final ModelRenderer cube_r5;
    private final ModelRenderer cube_r6;
    private final ModelRenderer cube_r7;
    private final ModelRenderer cube_r8;
    private final ModelRenderer bone12;
    private final ModelRenderer cube_r9;
    private final ModelRenderer cube_r10;
    private final ModelRenderer cube_r11;

    public ModelDilucBurst() {
        textureWidth = 256;
        textureHeight = 256;

        zhengti = new ModelRenderer(this);
        zhengti.setRotationPoint(0.0F, 19.0F, 3.0F);


        bone6 = new ModelRenderer(this);
        bone6.setRotationPoint(0.0F, 5.0F, -3.0F);
        zhengti.addChild(bone6);


        cube_r31 = new ModelRenderer(this);
        cube_r31.setRotationPoint(-4.35F, 8.0F, -22.0F);
        bone6.addChild(cube_r31);
        setRotationAngle(cube_r31, -0.9599F, 0.0F, 0.2618F);
        cube_r31.cubeList.add(new ModelBox(cube_r31, 0, 11, -1.0F, 0.0F, 0.0F, 1, 1, 6, 0.0F, false));

        cube_r32 = new ModelRenderer(this);
        cube_r32.setRotationPoint(-3.5F, 8.0F, -22.0F);
        bone6.addChild(cube_r32);
        setRotationAngle(cube_r32, -0.9599F, 0.0F, 0.0F);
        cube_r32.cubeList.add(new ModelBox(cube_r32, 6, 49, -0.5F, 0.0F, 0.0F, 1, 1, 6, 0.0F, false));

        cube_r33 = new ModelRenderer(this);
        cube_r33.setRotationPoint(-2.65F, 8.0F, -22.0F);
        bone6.addChild(cube_r33);
        setRotationAngle(cube_r33, -0.9599F, 0.0F, -0.2182F);
        cube_r33.cubeList.add(new ModelBox(cube_r33, 34, 69, 0.0F, 0.0F, 0.0F, 1, 1, 6, 0.0F, false));

        cube_r34 = new ModelRenderer(this);
        cube_r34.setRotationPoint(-3.0F, -2.0F, -19.0F);
        bone6.addChild(cube_r34);
        setRotationAngle(cube_r34, -0.4363F, 0.0F, 0.0F);
        cube_r34.cubeList.add(new ModelBox(cube_r34, 0, 20, -2.0F, -1.0F, 0.0F, 3, 12, 3, 0.0F, false));

        bone5 = new ModelRenderer(this);
        bone5.setRotationPoint(0.0F, 5.0F, -3.0F);
        zhengti.addChild(bone5);


        cube_r27 = new ModelRenderer(this);
        cube_r27.setRotationPoint(4.35F, 8.0F, -22.0F);
        bone5.addChild(cube_r27);
        setRotationAngle(cube_r27, -0.9599F, 0.0F, -0.2618F);
        cube_r27.cubeList.add(new ModelBox(cube_r27, 0, 84, 0.0F, 0.0F, 0.0F, 1, 1, 6, 0.0F, false));

        cube_r28 = new ModelRenderer(this);
        cube_r28.setRotationPoint(3.5F, 8.0F, -22.0F);
        bone5.addChild(cube_r28);
        setRotationAngle(cube_r28, -0.9599F, 0.0F, 0.0F);
        cube_r28.cubeList.add(new ModelBox(cube_r28, 0, 77, -0.5F, 0.0F, 0.0F, 1, 1, 6, 0.0F, false));

        cube_r29 = new ModelRenderer(this);
        cube_r29.setRotationPoint(2.65F, 8.0F, -22.0F);
        bone5.addChild(cube_r29);
        setRotationAngle(cube_r29, -0.9599F, 0.0F, 0.2182F);
        cube_r29.cubeList.add(new ModelBox(cube_r29, 80, 37, -1.0F, 0.0F, 0.0F, 1, 1, 6, 0.0F, false));

        cube_r30 = new ModelRenderer(this);
        cube_r30.setRotationPoint(3.0F, -2.0F, -19.0F);
        bone5.addChild(cube_r30);
        setRotationAngle(cube_r30, -0.4363F, 0.0F, 0.0F);
        cube_r30.cubeList.add(new ModelBox(cube_r30, 0, 40, -1.0F, -1.0F, 0.0F, 3, 12, 3, 0.0F, false));

        bb_main = new ModelRenderer(this);
        bb_main.setRotationPoint(0.0F, 5.0F, -3.0F);
        zhengti.addChild(bb_main);
        bb_main.cubeList.add(new ModelBox(bb_main, 50, 49, -7.0F, -11.0F, -8.0F, 14, 9, 20, 0.0F, false));
        bb_main.cubeList.add(new ModelBox(bb_main, 49, 49, -3.0F, -10.0F, 12.0F, 6, 6, 3, 0.0F, false));
        bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -1.0F, -15.0F, 15.0F, 2, 4, 7, 0.0F, false));
        bb_main.cubeList.add(new ModelBox(bb_main, 68, 20, -1.0F, -13.0F, 22.0F, 2, 1, 4, 0.0F, false));

        bb_main_r2 = new ModelRenderer(this);
        bb_main_r2.setRotationPoint(0.0F, -8.5F, 14.5F);
        bb_main.addChild(bb_main_r2);
        setRotationAngle(bb_main_r2, -0.5672F, 0.0F, 0.0F);
        bb_main_r2.cubeList.add(new ModelBox(bb_main_r2, 68, 0, -1.0F, -5.5F, -1.5F, 2, 8, 3, 0.0F, false));

        bb_main_r3 = new ModelRenderer(this);
        bb_main_r3.setRotationPoint(0.0F, -12.0F, 22.0F);
        bb_main.addChild(bb_main_r3);
        setRotationAngle(bb_main_r3, -0.4363F, 0.0F, 0.0F);
        bb_main_r3.cubeList.add(new ModelBox(bb_main_r3, 0, 56, -1.0F, 0.0F, 0.0F, 2, 1, 4, 0.0F, false));

        bb_main_r1 = new ModelRenderer(this);
        bb_main_r1.setRotationPoint(0.0F, -7.0F, 17.0F);
        bb_main.addChild(bb_main_r1);
        setRotationAngle(bb_main_r1, -0.4363F, 0.0F, 0.0F);


        cube_r26 = new ModelRenderer(this);
        cube_r26.setRotationPoint(0.0F, -7.0F, 17.0F);
        bb_main.addChild(cube_r26);
        setRotationAngle(cube_r26, -0.2618F, 0.0F, 0.0F);


        shenti3_r1 = new ModelRenderer(this);
        shenti3_r1.setRotationPoint(-1.0F, -5.5F, -28.5F);
        bb_main.addChild(shenti3_r1);
        setRotationAngle(shenti3_r1, 0.0436F, 0.0F, 0.0F);
        shenti3_r1.cubeList.add(new ModelBox(shenti3_r1, 0, 115, -4.0F, -1.5F, -19.5F, 10, 5, 19, 0.0F, false));

        shenti2_r1 = new ModelRenderer(this);
        shenti2_r1.setRotationPoint(-1.0F, -6.5F, -8.0F);
        bb_main.addChild(shenti2_r1);
        setRotationAngle(shenti2_r1, 0.0436F, 0.0F, 0.0F);
        shenti2_r1.cubeList.add(new ModelBox(shenti2_r1, 0, 40, -6.0F, -3.5F, -21.0F, 14, 8, 21, 0.0F, false));

        chibangyou = new ModelRenderer(this);
        chibangyou.setRotationPoint(0.0F, 5.0F, -3.0F);
        zhengti.addChild(chibangyou);


        bone7 = new ModelRenderer(this);
        bone7.setRotationPoint(0.0F, 0.0F, 0.0F);
        chibangyou.addChild(bone7);
        bone7.cubeList.add(new ModelBox(bone7, 146, 77, 60.0F, -6.0F, 0.0F, 19, 2, 8, 0.0F, false));

        cube_r19 = new ModelRenderer(this);
        cube_r19.setRotationPoint(66.0F, -5.0F, 0.0F);
        bone7.addChild(cube_r19);
        setRotationAngle(cube_r19, 0.1309F, 0.0F, 0.0F);
        cube_r19.cubeList.add(new ModelBox(cube_r19, 0, 78, -6.0F, 0.0F, -16.0F, 19, 1, 16, 0.0F, false));

        bone8 = new ModelRenderer(this);
        bone8.setRotationPoint(0.0F, 0.0F, 0.0F);
        chibangyou.addChild(bone8);


        cube_r20 = new ModelRenderer(this);
        cube_r20.setRotationPoint(54.0F, -5.0F, -1.0F);
        bone8.addChild(cube_r20);
        setRotationAngle(cube_r20, 0.1309F, 0.0F, 0.0F);
        cube_r20.cubeList.add(new ModelBox(cube_r20, 39, 115, -6.0F, 0.0F, -18.0F, 12, 1, 18, 0.0F, false));

        cube_r21 = new ModelRenderer(this);
        cube_r21.setRotationPoint(48.0F, -7.0F, 4.0F);
        bone8.addChild(cube_r21);
        setRotationAngle(cube_r21, 0.0F, 0.0F, 0.0436F);
        cube_r21.cubeList.add(new ModelBox(cube_r21, 119, 149, 0.0F, 0.0F, -5.0F, 12, 4, 10, 0.0F, false));

        bone9 = new ModelRenderer(this);
        bone9.setRotationPoint(0.0F, 0.0F, 0.0F);
        chibangyou.addChild(bone9);


        cube_r22 = new ModelRenderer(this);
        cube_r22.setRotationPoint(23.0F, -8.0F, 4.0F);
        bone9.addChild(cube_r22);
        setRotationAngle(cube_r22, 0.0F, 0.0F, 0.0436F);
        cube_r22.cubeList.add(new ModelBox(cube_r22, 68, 0, 0.0F, -1.0F, -6.0F, 25, 5, 12, 0.0F, false));

        cube_r23 = new ModelRenderer(this);
        cube_r23.setRotationPoint(34.0F, -7.0F, -2.0F);
        bone9.addChild(cube_r23);
        setRotationAngle(cube_r23, 0.1309F, 0.0F, 0.0436F);
        cube_r23.cubeList.add(new ModelBox(cube_r23, 0, 0, -11.0F, 1.0F, -18.0F, 25, 2, 18, 0.0F, false));

        bone10 = new ModelRenderer(this);
        bone10.setRotationPoint(0.0F, 0.0F, 0.0F);
        chibangyou.addChild(bone10);


        cube_r24 = new ModelRenderer(this);
        cube_r24.setRotationPoint(15.5F, -7.5F, -4.5F);
        bone10.addChild(cube_r24);
        setRotationAngle(cube_r24, 0.0873F, 0.0F, 0.0436F);
        cube_r24.cubeList.add(new ModelBox(cube_r24, 0, 95, -7.5F, 0.5F, -16.5F, 15, 3, 17, 0.0F, false));

        cube_r25 = new ModelRenderer(this);
        cube_r25.setRotationPoint(7.0F, -7.0F, 6.0F);
        bone10.addChild(cube_r25);
        setRotationAngle(cube_r25, 0.0F, 0.0F, 0.0436F);
        cube_r25.cubeList.add(new ModelBox(cube_r25, 98, 37, 0.0F, -3.0F, -10.0F, 16, 6, 15, 0.0F, false));

        chibangzuo = new ModelRenderer(this);
        chibangzuo.setRotationPoint(0.0F, 5.0F, -3.0F);
        zhengti.addChild(chibangzuo);


        bone4 = new ModelRenderer(this);
        bone4.setRotationPoint(0.0F, 0.0F, 0.0F);
        chibangzuo.addChild(bone4);
        bone4.cubeList.add(new ModelBox(bone4, 146, 87, -79.0F, -6.0F, 0.0F, 19, 2, 8, 0.0F, false));

        cube_r12 = new ModelRenderer(this);
        cube_r12.setRotationPoint(-66.0F, -5.0F, 0.0F);
        bone4.addChild(cube_r12);
        setRotationAngle(cube_r12, 0.1309F, 0.0F, 0.0F);
        cube_r12.cubeList.add(new ModelBox(cube_r12, 70, 78, -13.0F, 0.0F, -16.0F, 19, 1, 16, 0.0F, false));

        bone3 = new ModelRenderer(this);
        bone3.setRotationPoint(0.0F, 0.0F, 0.0F);
        chibangzuo.addChild(bone3);


        cube_r13 = new ModelRenderer(this);
        cube_r13.setRotationPoint(-54.0F, -5.0F, -1.0F);
        bone3.addChild(cube_r13);
        setRotationAngle(cube_r13, 0.1309F, 0.0F, 0.0F);
        cube_r13.cubeList.add(new ModelBox(cube_r13, 118, 58, -6.0F, 0.0F, -18.0F, 12, 1, 18, 0.0F, false));

        cube_r14 = new ModelRenderer(this);
        cube_r14.setRotationPoint(-48.0F, -7.0F, 4.0F);
        bone3.addChild(cube_r14);
        setRotationAngle(cube_r14, 0.0F, 0.0F, -0.0436F);
        cube_r14.cubeList.add(new ModelBox(cube_r14, 153, 153, -12.0F, 0.0F, -5.0F, 12, 4, 10, 0.0F, false));

        bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(0.0F, 0.0F, 0.0F);
        chibangzuo.addChild(bone2);


        cube_r15 = new ModelRenderer(this);
        cube_r15.setRotationPoint(-23.0F, -8.0F, 4.0F);
        bone2.addChild(cube_r15);
        setRotationAngle(cube_r15, 0.0F, 0.0F, -0.0436F);
        cube_r15.cubeList.add(new ModelBox(cube_r15, 68, 20, -25.0F, -1.0F, -6.0F, 25, 5, 12, 0.0F, false));

        cube_r16 = new ModelRenderer(this);
        cube_r16.setRotationPoint(-34.0F, -7.0F, -2.0F);
        bone2.addChild(cube_r16);
        setRotationAngle(cube_r16, 0.1309F, 0.0F, -0.0436F);
        cube_r16.cubeList.add(new ModelBox(cube_r16, 0, 20, -14.0F, 1.0F, -18.0F, 25, 2, 18, 0.0F, false));

        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.0F, 0.0F, 0.0F);
        chibangzuo.addChild(bone);


        cube_r17 = new ModelRenderer(this);
        cube_r17.setRotationPoint(-15.5F, -7.5F, -4.5F);
        bone.addChild(cube_r17);
        setRotationAngle(cube_r17, 0.0873F, 0.0F, -0.0436F);
        cube_r17.cubeList.add(new ModelBox(cube_r17, 64, 95, -7.5F, 0.5F, -16.5F, 15, 3, 17, 0.0F, false));

        cube_r18 = new ModelRenderer(this);
        cube_r18.setRotationPoint(-7.0F, -7.0F, 6.0F);
        bone.addChild(cube_r18);
        setRotationAngle(cube_r18, 0.0F, 0.0F, -0.0436F);
        cube_r18.cubeList.add(new ModelBox(cube_r18, 113, 100, -16.0F, -3.0F, -10.0F, 16, 6, 15, 0.0F, false));

        weibu = new ModelRenderer(this);
        weibu.setRotationPoint(0.0F, 5.0F, -5.0F);
        zhengti.addChild(weibu);


        cube_r1 = new ModelRenderer(this);
        cube_r1.setRotationPoint(-1.0F, -3.0F, -46.0F);
        weibu.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.2618F, 0.0F, 0.0F);
        cube_r1.cubeList.add(new ModelBox(cube_r1, 37, 134, -1.0F, -2.0F, -21.0F, 4, 3, 21, 0.0F, false));

        cube_r2 = new ModelRenderer(this);
        cube_r2.setRotationPoint(0.0F, 5.5566F, -76.3222F);
        weibu.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.3491F, 0.0F, 0.0F);
        cube_r2.cubeList.add(new ModelBox(cube_r2, 130, 0, -2.0F, -1.5F, -10.5F, 4, 3, 21, 0.0F, false));

        cube_r3 = new ModelRenderer(this);
        cube_r3.setRotationPoint(6.3546F, 2.1764F, -65.025F);
        weibu.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.3491F, -0.1745F, 0.0F);
        cube_r3.cubeList.add(new ModelBox(cube_r3, 93, 146, -1.0F, -2.0F, -20.0F, 3, 3, 20, 0.0F, false));

        cube_r4 = new ModelRenderer(this);
        cube_r4.setRotationPoint(3.0F, -3.0F, -46.0F);
        weibu.addChild(cube_r4);
        setRotationAngle(cube_r4, 0.2618F, -0.1745F, 0.0F);
        cube_r4.cubeList.add(new ModelBox(cube_r4, 145, 24, -1.0F, -2.0F, -20.0F, 3, 3, 20, 0.0F, false));

        cube_r5 = new ModelRenderer(this);
        cube_r5.setRotationPoint(9.597F, 9.0168F, -83.9931F);
        weibu.addChild(cube_r5);
        setRotationAngle(cube_r5, 0.3491F, -0.3927F, 0.0F);
        cube_r5.cubeList.add(new ModelBox(cube_r5, 67, 140, -1.0F, -2.0F, -20.0F, 3, 3, 20, 0.0F, false));

        cube_r6 = new ModelRenderer(this);
        cube_r6.setRotationPoint(-9.597F, 9.0168F, -83.9931F);
        weibu.addChild(cube_r6);
        setRotationAngle(cube_r6, 0.3491F, 0.3927F, 0.0F);
        cube_r6.cubeList.add(new ModelBox(cube_r6, 139, 126, -2.0F, -2.0F, -20.0F, 3, 3, 20, 0.0F, false));

        cube_r7 = new ModelRenderer(this);
        cube_r7.setRotationPoint(-6.3546F, 2.1764F, -65.025F);
        weibu.addChild(cube_r7);
        setRotationAngle(cube_r7, 0.3491F, 0.1745F, 0.0F);
        cube_r7.cubeList.add(new ModelBox(cube_r7, 0, 139, -2.0F, -2.0F, -20.0F, 3, 3, 20, 0.0F, false));

        cube_r8 = new ModelRenderer(this);
        cube_r8.setRotationPoint(-3.0F, -3.0F, -46.0F);
        weibu.addChild(cube_r8);
        setRotationAngle(cube_r8, 0.2618F, 0.1745F, 0.0F);
        cube_r8.cubeList.add(new ModelBox(cube_r8, 120, 77, -2.0F, -2.0F, -20.0F, 3, 3, 20, 0.0F, false));

        bone12 = new ModelRenderer(this);
        bone12.setRotationPoint(0.0F, 14.2382F, -96.702F);
        weibu.addChild(bone12);
        setRotationAngle(bone12, 0.4363F, 0.0F, 0.0F);


        cube_r9 = new ModelRenderer(this);
        cube_r9.setRotationPoint(1.0F, 0.0F, -4.0F);
        bone12.addChild(cube_r9);
        cube_r9.cubeList.add(new ModelBox(cube_r9, 49, 40, -7.0F, -1.5F, -6.0F, 12, 3, 6, 0.0F, false));
        cube_r9.cubeList.add(new ModelBox(cube_r9, 0, 69, -7.0F, -1.5F, 0.0F, 12, 3, 5, 0.0F, false));
        cube_r9.cubeList.add(new ModelBox(cube_r9, 54, 78, -3.0F, -1.5F, 5.0F, 4, 3, 11, 0.0F, false));

        cube_r10 = new ModelRenderer(this);
        cube_r10.setRotationPoint(2.0F, 0.0F, 12.0F);
        bone12.addChild(cube_r10);
        setRotationAngle(cube_r10, 0.0F, -0.3491F, 0.0F);
        cube_r10.cubeList.add(new ModelBox(cube_r10, 107, 121, -4.0F, -1.5F, -22.0F, 4, 3, 22, 0.0F, false));

        cube_r11 = new ModelRenderer(this);
        cube_r11.setRotationPoint(-2.0F, 0.0F, 12.0F);
        bone12.addChild(cube_r11);
        setRotationAngle(cube_r11, 0.0F, 0.3491F, 0.0F);
        cube_r11.cubeList.add(new ModelBox(cube_r11, 77, 115, 0.0F, -1.5F, -22.0F, 4, 3, 22, 0.0F, false));
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        zhengti.render(f5);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        this.zhengti.rotateAngleX = (float) (entityIn.rotationPitch * 0.017453292F);
        this.zhengti.rotateAngleY = (float) (-(entityIn.rotationYaw + 180) * 0.017453292F);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}