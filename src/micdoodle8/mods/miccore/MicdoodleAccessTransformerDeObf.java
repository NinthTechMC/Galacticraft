package micdoodle8.mods.miccore;

import cpw.mods.fml.common.asm.transformers.AccessTransformer;

import java.io.IOException;

public class MicdoodleAccessTransformerDeObf extends AccessTransformer
{
	public MicdoodleAccessTransformerDeObf() throws IOException
	{
		// PISTON: my mcmod tool doesn't work well with files outside of assets
		// so putting this inside assets
		super("assets/micdoodlecore_at.deobf");
	}
}