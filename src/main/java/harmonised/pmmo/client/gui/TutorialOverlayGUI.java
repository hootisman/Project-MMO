package harmonised.pmmo.client.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.joml.Matrix4f;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;

import harmonised.pmmo.client.utils.ClientUtils;
import harmonised.pmmo.config.Config;
import harmonised.pmmo.config.codecs.CodecTypes.SalvageData;
import harmonised.pmmo.core.Core;
import harmonised.pmmo.setup.datagen.LangProvider;
import harmonised.pmmo.util.RegistryUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.client.gui.screens.inventory.tooltip.TooltipRenderUtil;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.client.gui.overlay.ForgeGui;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.registries.ForgeRegistries;

public class TutorialOverlayGUI implements IGuiOverlay {
	private Minecraft mc;
	private Font fontRenderer;
	private List<ClientTooltipComponent> lines = new ArrayList<>();
	private BlockHitResult bhr;

	@Override
	public void render(ForgeGui gui, GuiGraphics guiGraphics, float partialTick, int screenWidth, int screenHeight) {
		if (mc == null)
			mc = Minecraft.getInstance();
		if (!(mc.hitResult instanceof BlockHitResult))
			return;
		else
			bhr = (BlockHitResult) mc.hitResult;
		if (fontRenderer == null)
			fontRenderer = mc.font;
		int renderLeft = (screenWidth / 8) * 5;
		int renderTop = (screenHeight / 4);
		int tooltipWidth = 3 * (screenWidth / 8);

		if (!mc.options.renderDebug) {
			// IDENTIFY LINES
			if (mc.level.getBlockState(bhr.getBlockPos()).getBlock()
					.equals(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(Config.SALVAGE_BLOCK.get())))) {
				lines = new ArrayList<>(ClientUtils.ctc(mc, LangProvider.SALVAGE_TUTORIAL_HEADER.asComponent()
						.withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD), tooltipWidth));
				if (mc.player.isCrouching()
						&& (!mc.player.getMainHandItem().isEmpty() || !mc.player.getOffhandItem().isEmpty())) {
					ItemStack salvageStack = mc.player.getMainHandItem().isEmpty() ? mc.player.getOffhandItem()
							: mc.player.getMainHandItem();
					gatherSalvageData(salvageStack)
							.forEach(line -> lines.addAll(ClientUtils.ctc(mc, line, tooltipWidth)));
				} else
					lines.addAll(ClientUtils.ctc(mc, LangProvider.SALVAGE_TUTORIAL_USAGE.asComponent(), tooltipWidth));
			} else
				return; // stop render if none of the viewing cases are met.

			// RENDER
			guiGraphics.pose().pushPose();
			RenderSystem.enableBlend();
			if (!lines.isEmpty()) {
				int i = 0;
				int j = lines.size() == 1 ? -2 : 0;

				for (ClientTooltipComponent clienttooltipcomponent : lines) {
					int k = clienttooltipcomponent.getWidth(mc.font);
					if (k > i) {
						i = k;
					}

					j += clienttooltipcomponent.getHeight();
				}

				int l = renderLeft;
				int i1 = renderTop;
				guiGraphics.pose().pushPose();
				Tesselator tesselator = Tesselator.getInstance();
				BufferBuilder bufferbuilder = tesselator.getBuilder();
				RenderSystem.setShader(GameRenderer::getPositionColorShader);
				bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
				Matrix4f matrix4f = guiGraphics.pose().last().pose();
				TooltipRenderUtil.renderTooltipBackground(guiGraphics, l, i1, i, j, 400);
				RenderSystem.enableDepthTest();
				RenderSystem.enableBlend();
				RenderSystem.defaultBlendFunc();
				BufferUploader.drawWithShader(bufferbuilder.end());
				MultiBufferSource.BufferSource multibuffersource$buffersource = MultiBufferSource
						.immediate(Tesselator.getInstance().getBuilder());
				guiGraphics.pose().translate(0.0F, 0.0F, 400.0F);
				int k1 = i1;

				for (int l1 = 0; l1 < lines.size(); ++l1) {
					ClientTooltipComponent clienttooltipcomponent1 = lines.get(l1);
					clienttooltipcomponent1.renderText(mc.font, l, k1, matrix4f, multibuffersource$buffersource);
					k1 += clienttooltipcomponent1.getHeight() + (l1 == 0 ? 2 : 0);
				}

				multibuffersource$buffersource.endBatch();
				k1 = i1;

				for (int i2 = 0; i2 < lines.size(); ++i2) {
					ClientTooltipComponent clienttooltipcomponent2 = lines.get(i2);
					clienttooltipcomponent2.renderImage(mc.font, l, k1, guiGraphics);
					k1 += clienttooltipcomponent2.getHeight() + (i2 == 0 ? 2 : 0);
				}

			}
			guiGraphics.pose().popPose();
		}
	}

	protected static void fillGradient(Matrix4f pMatrix, BufferBuilder pBuilder, int pX1, int pY1, int pX2, int pY2,
			int pBlitOffset, int pColorA, int pColorB) {
		float f = (float) (pColorA >> 24 & 255) / 255.0F;
		float f1 = (float) (pColorA >> 16 & 255) / 255.0F;
		float f2 = (float) (pColorA >> 8 & 255) / 255.0F;
		float f3 = (float) (pColorA & 255) / 255.0F;
		float f4 = (float) (pColorB >> 24 & 255) / 255.0F;
		float f5 = (float) (pColorB >> 16 & 255) / 255.0F;
		float f6 = (float) (pColorB >> 8 & 255) / 255.0F;
		float f7 = (float) (pColorB & 255) / 255.0F;
		pBuilder.vertex(pMatrix, (float) pX2, (float) pY1, (float) pBlitOffset).color(f1, f2, f3, f).endVertex();
		pBuilder.vertex(pMatrix, (float) pX1, (float) pY1, (float) pBlitOffset).color(f1, f2, f3, f).endVertex();
		pBuilder.vertex(pMatrix, (float) pX1, (float) pY2, (float) pBlitOffset).color(f5, f6, f7, f4).endVertex();
		pBuilder.vertex(pMatrix, (float) pX2, (float) pY2, (float) pBlitOffset).color(f5, f6, f7, f4).endVertex();
	}

	private List<MutableComponent> gatherSalvageData(ItemStack stack) {
		List<MutableComponent> outList = new ArrayList<>();
		for (Map.Entry<ResourceLocation, SalvageData> entry : Core.get(LogicalSide.CLIENT).getLoader().ITEM_LOADER
				.getData(RegistryUtil.getId(stack)).salvage().entrySet()) {
			outList.add(MutableComponent.create(
					new ItemStack(ForgeRegistries.ITEMS.getValue(entry.getKey())).getDisplayName().getContents()));
			SalvageData data = entry.getValue();
			if (!data.levelReq().isEmpty()) {
				outList.add(LangProvider.SALVAGE_LEVEL_REQ.asComponent().withStyle(ChatFormatting.UNDERLINE));
				for (Map.Entry<String, Integer> req : data.levelReq().entrySet()) {
					outList.add(Component.translatable("pmmo." + req.getKey())
							.append(Component.literal(": " + req.getValue())));
				}
			}
			outList.add(LangProvider.SALVAGE_CHANCE.asComponent(data.baseChance(), data.maxChance())
					.withStyle(ChatFormatting.UNDERLINE));
			outList.add(LangProvider.SALVAGE_MAX.asComponent(data.salvageMax()).withStyle(ChatFormatting.UNDERLINE));
			if (!data.chancePerLevel().isEmpty()) {
				outList.add(LangProvider.SALVAGE_CHANCE_MOD.asComponent().withStyle(ChatFormatting.UNDERLINE));
				for (Map.Entry<String, Double> perLevel : data.chancePerLevel().entrySet()) {
					outList.add(Component.translatable("pmmo." + perLevel.getKey())
							.append(Component.literal(": " + perLevel.getValue())));
				}
			}
			if (!data.xpAward().isEmpty()) {
				outList.add(LangProvider.SALVAGE_XP_AWARD.asComponent().withStyle(ChatFormatting.UNDERLINE));
				for (Map.Entry<String, Long> award : data.xpAward().entrySet()) {
					outList.add(Component.translatable("pmmo." + award.getKey())
							.append(Component.literal(": " + award.getValue())));
				}
			}
		}
		return outList;
	}
}
