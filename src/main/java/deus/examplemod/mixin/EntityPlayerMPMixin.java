package deus.examplemod.mixin;


import deus.examplemod.guis.interfaces.mixin.IEntityPlayer;
import deus.examplemod.guis.supercraftingtable.ExampleBlockTileEntity;
import net.minecraft.core.crafting.ICrafting;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.net.packet.Packet100OpenWindow;
import net.minecraft.core.player.inventory.ContainerChest;
import net.minecraft.core.player.inventory.IInventory;
import net.minecraft.core.world.World;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.entity.player.EntityPlayerMP;
import net.minecraft.server.net.handler.NetServerHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = EntityPlayerMP.class, remap = false)
public abstract class EntityPlayerMPMixin extends EntityPlayer implements IEntityPlayer, ICrafting
{
	@Shadow
	protected abstract void getNextWindowId();

	@Shadow
	private int currentWindowId;

	@Shadow
	public NetServerHandler playerNetServerHandler;

	@Shadow
	public abstract void displayGUIChest(IInventory iinventory);

	@Shadow
	public MinecraftServer mcServer;

	public EntityPlayerMPMixin(World world)
	{
		super(world);
	}


	@Override
	public void guiLib$openExampleGui(ExampleBlockTileEntity exampleBlockTileEntity) {
		this.getNextWindowId();

		this.playerNetServerHandler.sendPacket(
			new Packet100OpenWindow(
				this.currentWindowId,
				24,
				exampleBlockTileEntity.getInvName(),
				exampleBlockTileEntity.getSizeInventory()
			));

		NetServerHandler.logger.info(this.username + " interacted with log pile at (" + this.x + ", " + this.y + ", " + this.z + ")");

		this.craftingInventory = new ContainerChest(this.inventory, exampleBlockTileEntity);
		this.craftingInventory.windowId = this.currentWindowId;
		this.craftingInventory.onContainerInit(this);
	}
}
