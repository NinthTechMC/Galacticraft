package codechicken.nei;

import codechicken.core.inventory.ContainerExtended;
import codechicken.core.inventory.SlotDummy;
import codechicken.nei.api.INEIGuiAdapter;
import codechicken.nei.guihook.GuiContainerManager;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class NEIDummySlotHandler extends INEIGuiAdapter
{
    @Override
    public boolean handleDragNDrop(GuiContainer gui, int mousex, int mousey, ItemStack draggedStack, int button)
    {
        // PISTON: method access
        Slot slot = GuiContainerManager.getSlotAtPosition(gui, mousex, mousey);
        if(slot instanceof SlotDummy && slot.isItemValid(draggedStack) && gui.inventorySlots instanceof ContainerExtended)
        {
            ((SlotDummy)slot).slotClick(draggedStack, button, NEIClientUtils.shiftKey());
            NEICPH.sendDummySlotSet(slot.slotNumber, slot.getStack());
            return true;
        }
        return false;
    }
}