// ==================================================================
// This file is part of Smart Render.
//
// Smart Render is free software: you can redistribute it and/or
// modify it under the terms of the GNU General Public License as
// published by the Free Software Foundation, either version 3 of the
// License, or (at your option) any later version.
//
// Smart Render is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with Smart Render. If not, see <http://www.gnu.org/licenses/>.
// ==================================================================

package net.smart.render;

import cpw.mods.fml.common.*;

public class SmartRenderInfo
{
	private static final Mod Mod = SmartRenderMod.class.getAnnotation(Mod.class);

	public static final String ModId = Mod.modid();
	public static final String ModName = Mod.name();
	public static final String ModVersion = Mod.version();
}