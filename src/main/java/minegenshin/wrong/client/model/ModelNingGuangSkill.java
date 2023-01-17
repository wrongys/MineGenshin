package minegenshin.wrong.client.model;// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelNingGuangSkill extends ModelBase {
    private final ModelRenderer main;
    private final ModelRenderer zhuti1;
    private final ModelRenderer bone1;
    private final ModelRenderer bone2;
    private final ModelRenderer bone3;
    private final ModelRenderer zhuti2;
    private final ModelRenderer bone4;
    private final ModelRenderer bone5;
    private final ModelRenderer bone6;

    public ModelNingGuangSkill() {
        textureWidth = 128;
        textureHeight = 128;

        main = new ModelRenderer(this);
        main.setRotationPoint(0.0F, 24.0F, 0.0F);


        zhuti1 = new ModelRenderer(this);
        zhuti1.setRotationPoint(-5.0F, -6.0F, 0.0F);
        main.addChild(zhuti1);


        bone1 = new ModelRenderer(this);
        bone1.setRotationPoint(0.0F, -5.0F, 0.0F);
        zhuti1.addChild(bone1);
        bone1.cubeList.add(new ModelBox(bone1, 48, 30, -5.0F, -14.0F, -2.0F, 5, 1, 5, 0.0F, false));
        bone1.cubeList.add(new ModelBox(bone1, 73, 54, -4.0F, -15.0F, -1.0F, 3, 1, 3, 0.0F, false));
        bone1.cubeList.add(new ModelBox(bone1, 12, 78, -3.0F, -16.0F, 0.0F, 1, 1, 1, 0.0F, false));
        bone1.cubeList.add(new ModelBox(bone1, 0, 48, -5.0F, -12.0F, -2.0F, 5, 2, 5, 0.0F, false));
        bone1.cubeList.add(new ModelBox(bone1, 73, 50, -4.0F, -13.0F, -1.0F, 3, 1, 3, 0.0F, false));

        bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(0.0F, 0.0F, 0.0F);
        zhuti1.addChild(bone2);
        bone2.cubeList.add(new ModelBox(bone2, 64, 20, -7.0F, -9.0F, -4.0F, 4, 2, 4, 0.0F, false));
        bone2.cubeList.add(new ModelBox(bone2, 72, 26, -6.0F, -7.0F, -3.0F, 3, 2, 3, 0.0F, false));
        bone2.cubeList.add(new ModelBox(bone2, 12, 64, -7.0F, -9.0F, 1.0F, 4, 2, 4, 0.0F, false));
        bone2.cubeList.add(new ModelBox(bone2, 68, 70, -6.0F, -7.0F, 1.0F, 3, 2, 3, 0.0F, false));
        bone2.cubeList.add(new ModelBox(bone2, 61, 54, -2.0F, -9.0F, 1.0F, 4, 2, 4, 0.0F, false));
        bone2.cubeList.add(new ModelBox(bone2, 56, 70, -2.0F, -7.0F, 1.0F, 3, 2, 3, 0.0F, false));
        bone2.cubeList.add(new ModelBox(bone2, 57, 60, -2.0F, -9.0F, -4.0F, 4, 2, 4, 0.0F, false));
        bone2.cubeList.add(new ModelBox(bone2, 70, 38, -2.0F, -7.0F, -3.0F, 3, 2, 3, 0.0F, false));
        bone2.cubeList.add(new ModelBox(bone2, 48, 24, -5.0F, -4.0F, -2.0F, 5, 1, 5, 0.0F, false));
        bone2.cubeList.add(new ModelBox(bone2, 66, 5, -4.5F, -3.0F, -1.5F, 4, 1, 4, 0.0F, false));
        bone2.cubeList.add(new ModelBox(bone2, 20, 73, -4.0F, -2.0F, -1.0F, 3, 1, 3, 0.0F, false));
        bone2.cubeList.add(new ModelBox(bone2, 78, 10, -3.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, false));
        bone2.cubeList.add(new ModelBox(bone2, 54, 66, -3.5F, -1.0F, -0.5F, 2, 1, 2, 0.0F, false));

        bone3 = new ModelRenderer(this);
        bone3.setRotationPoint(0.0F, -1.0F, 0.0F);
        zhuti1.addChild(bone3);
        bone3.cubeList.add(new ModelBox(bone3, 55, 40, -6.0F, -24.0F, -1.0F, 6, 2, 3, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 73, -4.0F, -21.0F, -1.0F, 3, 1, 3, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 59, 66, -5.0F, -22.0F, -1.0F, 5, 1, 3, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 66, -7.0F, -26.0F, -2.0F, 2, 2, 5, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 69, 10, -3.0F, -27.0F, -1.0F, 3, 3, 3, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 36, -5.0F, -34.0F, -2.0F, 5, 7, 5, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 54, 0, -8.0F, -31.0F, -2.0F, 3, 3, 5, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 15, 54, 0.0F, -34.0F, -2.0F, 2, 5, 5, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 9, -7.0F, -38.0F, -2.0F, 12, 4, 5, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 40, 41, -4.0F, -40.0F, -2.0F, 5, 2, 5, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 29, 4, -14.0F, -44.0F, -2.0F, 10, 2, 5, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 27, -13.0F, -42.0F, -2.0F, 9, 4, 5, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 45, 64, -9.0F, -28.0F, -2.0F, 2, 2, 5, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 75, 68, -5.0F, -28.0F, -3.0F, 5, 1, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 72, 47, -6.0F, -23.0F, -2.0F, 6, 1, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 72, 16, -6.0F, -23.0F, 2.0F, 6, 1, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 66, 75, -5.0F, -28.0F, 3.0F, 5, 1, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 8, 78, -1.0F, -29.0F, -3.0F, 1, 1, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 78, 7, -2.0F, -25.0F, -2.0F, 1, 1, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 78, 5, -2.0F, -25.0F, 2.0F, 1, 1, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 75, 77, -1.0F, -27.0F, -2.0F, 1, 3, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 71, 77, -1.0F, -27.0F, 2.0F, 1, 3, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 67, 77, -3.0F, -27.0F, -2.0F, 1, 3, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 63, 77, -3.0F, -27.0F, 2.0F, 1, 3, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 77, 70, -1.0F, -29.0F, 3.0F, 1, 1, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 76, 21, -1.0F, -30.0F, -3.0F, 3, 1, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 76, 19, -1.0F, -30.0F, 3.0F, 3, 1, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 51, 76, 1.0F, -34.0F, -3.0F, 1, 4, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 47, 76, 1.0F, -34.0F, 3.0F, 1, 4, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 29, 2, -7.0F, -35.0F, -3.0F, 12, 1, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 29, 0, -7.0F, -35.0F, 3.0F, 12, 1, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 24, 56, 0.0F, -38.0F, -3.0F, 4, 1, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 24, 54, 0.0F, -38.0F, 3.0F, 4, 1, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 44, 52, -4.0F, -40.0F, -3.0F, 4, 1, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 44, 50, -4.0F, -40.0F, 3.0F, 4, 1, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 48, 24, 0.0F, -40.0F, -3.0F, 1, 2, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 59, 77, -7.0F, -38.0F, 3.0F, 1, 3, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 24, 36, 0.0F, -40.0F, 3.0F, 1, 2, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 55, 77, 4.0F, -38.0F, -3.0F, 1, 3, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 37, 77, 4.0F, -38.0F, 3.0F, 1, 3, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 33, 77, -7.0F, -38.0F, -3.0F, 1, 3, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 43, 76, -5.0F, -43.0F, -3.0F, 1, 4, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 77, 58, -11.0F, -41.0F, 3.0F, 1, 1, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 65, 70, -11.0F, -42.0F, 3.0F, 2, 1, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 29, 77, -9.0F, -42.0F, 3.0F, 1, 3, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 15, 50, -12.0F, -39.0F, 3.0F, 4, 1, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 59, -13.0F, -42.0F, 3.0F, 1, 4, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 77, 31, -14.0F, -43.0F, 3.0F, 1, 1, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 49, 11, -14.0F, -44.0F, 3.0F, 10, 1, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 55, 0, -5.0F, -43.0F, 3.0F, 1, 4, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 48, 38, -14.0F, -44.0F, -3.0F, 10, 1, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 16, 75, -14.0F, -43.0F, -3.0F, 1, 1, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 49, 18, -13.0F, -42.0F, -3.0F, 1, 4, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 15, 48, -12.0F, -39.0F, -3.0F, 4, 1, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 25, 77, -9.0F, -42.0F, -3.0F, 1, 3, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 9, 66, -11.0F, -42.0F, -3.0F, 2, 1, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 29, 73, -11.0F, -41.0F, -3.0F, 1, 1, 1, 0.0F, false));

        zhuti2 = new ModelRenderer(this);
        zhuti2.setRotationPoint(5.0F, -6.0F, 0.0F);
        main.addChild(zhuti2);


        bone4 = new ModelRenderer(this);
        bone4.setRotationPoint(0.0F, -5.0F, 0.0F);
        zhuti2.addChild(bone4);
        bone4.cubeList.add(new ModelBox(bone4, 20, 48, 0.0F, -14.0F, -2.0F, 5, 1, 5, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 72, 64, 1.0F, -15.0F, -1.0F, 3, 1, 3, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 20, 70, 2.0F, -16.0F, 0.0F, 1, 1, 1, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 20, 41, 0.0F, -12.0F, -2.0F, 5, 2, 5, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 72, 43, 1.0F, -13.0F, -1.0F, 3, 1, 3, 0.0F, false));

        bone5 = new ModelRenderer(this);
        bone5.setRotationPoint(0.0F, 0.0F, 0.0F);
        zhuti2.addChild(bone5);
        bone5.cubeList.add(new ModelBox(bone5, 60, 45, 3.0F, -9.0F, -4.0F, 4, 2, 4, 0.0F, false));
        bone5.cubeList.add(new ModelBox(bone5, 34, 70, 3.0F, -7.0F, -3.0F, 3, 2, 3, 0.0F, false));
        bone5.cubeList.add(new ModelBox(bone5, 25, 60, 3.0F, -9.0F, 1.0F, 4, 2, 4, 0.0F, false));
        bone5.cubeList.add(new ModelBox(bone5, 70, 33, 3.0F, -7.0F, 1.0F, 3, 2, 3, 0.0F, false));
        bone5.cubeList.add(new ModelBox(bone5, 0, 60, -2.0F, -9.0F, 1.0F, 4, 2, 4, 0.0F, false));
        bone5.cubeList.add(new ModelBox(bone5, 11, 70, -1.0F, -7.0F, 1.0F, 3, 2, 3, 0.0F, false));
        bone5.cubeList.add(new ModelBox(bone5, 45, 58, -2.0F, -9.0F, -4.0F, 4, 2, 4, 0.0F, false));
        bone5.cubeList.add(new ModelBox(bone5, 15, 36, -1.0F, -7.0F, -3.0F, 3, 2, 3, 0.0F, false));
        bone5.cubeList.add(new ModelBox(bone5, 48, 18, 0.0F, -4.0F, -2.0F, 5, 1, 5, 0.0F, false));
        bone5.cubeList.add(new ModelBox(bone5, 65, 0, 0.5F, -3.0F, -1.5F, 4, 1, 4, 0.0F, false));
        bone5.cubeList.add(new ModelBox(bone5, 43, 72, 1.0F, -2.0F, -1.0F, 3, 1, 3, 0.0F, false));
        bone5.cubeList.add(new ModelBox(bone5, 9, 69, 2.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, false));
        bone5.cubeList.add(new ModelBox(bone5, 49, 13, 1.5F, -1.0F, -0.5F, 2, 1, 2, 0.0F, false));

        bone6 = new ModelRenderer(this);
        bone6.setRotationPoint(0.0F, -1.0F, 0.0F);
        zhuti2.addChild(bone6);
        bone6.cubeList.add(new ModelBox(bone6, 54, 13, 0.0F, -24.0F, -1.0F, 6, 2, 3, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 69, 60, 1.0F, -21.0F, -1.0F, 3, 1, 3, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 0, 55, 0.0F, -22.0F, -1.0F, 5, 1, 3, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 63, 26, 5.0F, -26.0F, -2.0F, 2, 2, 5, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 25, 67, 0.0F, -27.0F, -1.0F, 3, 3, 3, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 28, 29, 0.0F, -34.0F, -2.0F, 5, 7, 5, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 49, 50, 5.0F, -31.0F, -2.0F, 3, 3, 5, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 35, 50, -2.0F, -34.0F, -2.0F, 2, 5, 5, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 0, 0, -5.0F, -38.0F, -2.0F, 12, 4, 5, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 34, 11, -1.0F, -40.0F, -2.0F, 5, 2, 5, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 23, 22, 4.0F, -44.0F, -2.0F, 10, 2, 5, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 0, 18, 4.0F, -42.0F, -2.0F, 9, 4, 5, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 36, 61, 7.0F, -28.0F, -2.0F, 2, 2, 5, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 54, 75, 0.0F, -28.0F, -3.0F, 5, 1, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 63, 18, 0.0F, -23.0F, -2.0F, 6, 1, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 60, 51, 0.0F, -23.0F, 2.0F, 6, 1, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 32, 75, 0.0F, -28.0F, 3.0F, 5, 1, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 24, 66, 0.0F, -29.0F, -3.0F, 1, 1, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 45, 64, 1.0F, -25.0F, -2.0F, 1, 1, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 63, 26, 1.0F, -25.0F, 2.0F, 1, 1, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 21, 77, 0.0F, -27.0F, -2.0F, 1, 3, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 17, 77, 0.0F, -27.0F, 2.0F, 1, 3, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 4, 77, 2.0F, -27.0F, -2.0F, 1, 3, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 77, 0, 2.0F, -27.0F, 2.0F, 1, 3, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 63, 20, 0.0F, -29.0F, 3.0F, 1, 1, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 34, 68, -2.0F, -30.0F, -3.0F, 3, 1, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 63, 33, -2.0F, -30.0F, 3.0F, 3, 1, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 0, 48, -2.0F, -34.0F, -3.0F, 1, 4, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 20, 41, -2.0F, -34.0F, 3.0F, 1, 4, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 23, 20, -5.0F, -35.0F, -3.0F, 12, 1, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 23, 18, -5.0F, -35.0F, 3.0F, 12, 1, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 35, 43, -4.0F, -38.0F, -3.0F, 4, 1, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 43, 32, -4.0F, -38.0F, 3.0F, 4, 1, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 43, 30, 0.0F, -40.0F, -3.0F, 4, 1, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 35, 41, 0.0F, -40.0F, 3.0F, 4, 1, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 34, 13, -1.0F, -40.0F, -3.0F, 1, 2, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 0, 77, 6.0F, -38.0F, 3.0F, 1, 3, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 28, 31, -1.0F, -40.0F, 3.0F, 1, 2, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 52, 71, -5.0F, -38.0F, -3.0F, 1, 3, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 65, 0, -5.0F, -38.0F, 3.0F, 1, 3, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 60, 45, 6.0F, -38.0F, -3.0F, 1, 3, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 0, 36, 4.0F, -43.0F, -3.0F, 1, 4, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 60, 53, 10.0F, -41.0F, 3.0F, 1, 1, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 29, 58, 9.0F, -42.0F, 3.0F, 2, 1, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 37, 60, 8.0F, -42.0F, 3.0F, 1, 3, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 23, 29, 8.0F, -39.0F, 3.0F, 4, 1, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 0, 18, 12.0F, -42.0F, 3.0F, 1, 4, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 45, 60, 13.0F, -43.0F, 3.0F, 1, 1, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 48, 36, 4.0F, -44.0F, 3.0F, 10, 1, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 0, 9, 4.0F, -43.0F, 3.0F, 1, 4, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 35, 48, 4.0F, -44.0F, -3.0F, 10, 1, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 16, 57, 13.0F, -43.0F, -3.0F, 1, 1, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 0, 0, 12.0F, -42.0F, -3.0F, 1, 4, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 29, 11, 8.0F, -39.0F, -3.0F, 4, 1, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 57, 58, 8.0F, -42.0F, -3.0F, 1, 3, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 13, 55, 9.0F, -42.0F, -3.0F, 2, 1, 1, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 35, 50, 10.0F, -41.0F, -3.0F, 1, 1, 1, 0.0F, false));
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        main.render(f5);
    }


    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
    }
}