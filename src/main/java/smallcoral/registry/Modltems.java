package smallcoral.registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.tutorial.TutorialManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import smallcoral.coral_mod.CoralMod;

import java.util.IdentityHashMap;

public class Modltems {
    public static Item registerItem(String name, Item item, ItemGroup...itemGroups){
        Item registeredItem = Registry.register(Registries.ITEM, new Identifier(CoralMod.MOD_ID, name), item);
        /*注意这里的CoralMod是你自己的Mod名字。不要记错了（（*/
        for (ItemGroup itemGroup: itemGroups){
            ItemGroupEvents.modifyEntriesEvent(itemGroup).register(entries -> entries.add(registeredItem));
        }
        return registeredItem;
    }
}
