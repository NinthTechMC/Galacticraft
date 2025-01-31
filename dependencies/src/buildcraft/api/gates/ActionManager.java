/**
 * Copyright (c) 2011-2014, SpaceToad and the BuildCraft Team
 * http://www.mod-buildcraft.com
 *
 * BuildCraft is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * http://www.mod-buildcraft.com/MMPL-1.0.txt
 */
package buildcraft.api.gates;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

import buildcraft.api.transport.IPipeTile;

public final class ActionManager {

	public static Map<String, ITrigger> triggers = new HashMap<String, ITrigger>();
	public static Map<String, IAction> actions = new HashMap<String, IAction>();
	private static List<ITriggerProvider> triggerProviders = new LinkedList<ITriggerProvider>();
	private static List<IActionProvider> actionProviders = new LinkedList<IActionProvider>();

	/**
	 * Deactivate constructor
	 */
	private ActionManager() {
	}

	public static void registerTriggerProvider(ITriggerProvider provider) {
		if (provider != null && !triggerProviders.contains(provider)) {
			triggerProviders.add(provider);
		}
	}

	public static void registerTrigger(ITrigger trigger) {
		triggers.put(trigger.getUniqueTag(), trigger);
	}

	public static void registerAction(IAction action) {
		actions.put(action.getUniqueTag(), action);
	}

	public static List<ITrigger> getNeighborTriggers(Block block, TileEntity entity) {
		List<ITrigger> result = new LinkedList<ITrigger>();

		for (ITriggerProvider provider : triggerProviders) {
			List<ITrigger> toAdd = provider.getNeighborTriggers(block, entity);

			if (toAdd != null) {
				for (ITrigger t : toAdd) {
					if (!result.contains(t)) {
						result.add(t);
					}
				}
			}
		}

		return result;
	}

	public static void registerActionProvider(IActionProvider provider) {
		if (provider != null && !actionProviders.contains(provider)) {
			actionProviders.add(provider);
		}
	}

	public static List<IAction> getNeighborActions(Block block, TileEntity entity) {
		List<IAction> result = new LinkedList<IAction>();

		for (IActionProvider provider : actionProviders) {
			List<IAction> toAdd = provider.getNeighborActions(block, entity);

			if (toAdd != null) {
				for (IAction t : toAdd) {
					if (!result.contains(t)) {
						result.add(t);
					}
				}
			}
		}

		return result;
	}

	public static List<ITrigger> getPipeTriggers(IPipeTile pipe) {
		List<ITrigger> result = new LinkedList<ITrigger>();

		for (ITriggerProvider provider : triggerProviders) {
			List<ITrigger> toAdd = provider.getPipeTriggers(pipe);

			if (toAdd != null) {
				for (ITrigger t : toAdd) {
					if (!result.contains(t)) {
						result.add(t);
					}
				}
			}
		}

		return result;
	}
}
