package dev.xyzbtw.utils;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.rusherhack.client.api.RusherHackAPI;
import org.rusherhack.client.api.utils.InventoryUtils;

import java.util.Collections;
import java.util.Set;

import static org.rusherhack.client.api.Globals.mc;

public class InventoryUtil {
    public static boolean isHolding(Item item) {
        return mc.player.isHolding(item);
    }
    public static void stealOnePearl(){
        if(!(mc.player.containerMenu instanceof ChestMenu menu)) return;;

        int slotCount = menu.getContainer().getContainerSize();
        for(int i = 0; i < slotCount; i++){
            if(menu.getContainer().getItem(i).isEmpty() || !menu.getContainer().getItem(i).getItem().equals(Items.ENDER_PEARL)) continue;
            mc.gameMode.handleInventoryMouseClick(mc.player.containerMenu.containerId, i, 0, ClickType.PICKUP, mc.player);
            mc.gameMode.handleInventoryMouseClick(mc.player.containerMenu.containerId, slotCount + 36 - 8, 1,ClickType.PICKUP, mc.player);
            mc.gameMode.handleInventoryMouseClick(mc.player.containerMenu.containerId, i, 0, ClickType.PICKUP, mc.player);
        }
    }
    public static boolean isInventoryEmpty() {
        boolean empty = true;
        for (int i = 0; i < mc.player.getInventory().getContainerSize(); i++) {
            if (!mc.player.getInventory().getItem(i).isEmpty()) {
                empty = false;
            }
        }
        return empty;
    }
    public static boolean isChestEmpty(){
        if(!(mc.player.containerMenu instanceof ChestMenu menu)) return false;

        for (int i = 0; i < menu.getContainer().getContainerSize(); i++) {
            if (!menu.getContainer().getItem(i).isEmpty()) {
                return false;
            }
        }
        return true;
    }
    public static boolean isSlotShulker(Item item) {
        for(Item shulks : shulks){
            if(shulks.equals(item)){
                return true;
            }
        }
        return false;
    }
    static Item[] shulks = {
            Items.SHULKER_BOX,
            Items.BLACK_SHULKER_BOX,
            Items.BLUE_SHULKER_BOX,
            Items.BROWN_SHULKER_BOX,
            Items.CYAN_SHULKER_BOX,
            Items.GRAY_SHULKER_BOX,
            Items.GREEN_SHULKER_BOX,
            Items.LIGHT_BLUE_SHULKER_BOX,
            Items.LIGHT_GRAY_SHULKER_BOX,
            Items.LIME_SHULKER_BOX,
            Items.MAGENTA_SHULKER_BOX,
            Items.ORANGE_SHULKER_BOX,
            Items.PINK_SHULKER_BOX,
            Items.WHITE_SHULKER_BOX,
            Items.YELLOW_SHULKER_BOX,
            Items.RED_SHULKER_BOX,
            Items.PURPLE_SHULKER_BOX
    };
    public static boolean isChestFull(){
        if(!(mc.player.containerMenu instanceof ChestMenu menu)) return false;

        for (int i = 0; i < menu.getContainer().getContainerSize(); i++) {
            if (menu.getContainer().getItem(i).isEmpty()) {
                return false;
            }
        }
        return true;
    }
    public static void clickSlot(int slotId, boolean shiftClick) {
        if(mc.player == null || mc.gameMode == null) {
            return;
        }

        mc.gameMode.handleInventoryMouseClick(mc.player.containerMenu.containerId, slotId, 0, shiftClick ? ClickType.QUICK_MOVE : ClickType.PICKUP, mc.player);
    }
}
