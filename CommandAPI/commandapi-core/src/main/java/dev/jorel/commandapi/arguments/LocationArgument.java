package dev.jorel.commandapi.arguments;

import org.bukkit.Location;

import dev.jorel.commandapi.CommandAPIHandler;

/**
 * An argument that represents the Bukkit Location object
 */
public class LocationArgument extends SafeOverrideableArgument<Location> {
	
	/**
	 * A Location argument. Represents Minecraft locations
	 */
	public LocationArgument() {
		this(LocationType.PRECISE_POSITION);
	}
	
	/**
	 * A Location argument. Represents Minecraft locations
	 * @param type the location type of this location, either LocationType.BLOCK_POSITION or LocationType.PRECISE_POSITION
	 */
	public LocationArgument(LocationType type) {
		super(type == LocationType.BLOCK_POSITION ? CommandAPIHandler.getNMS()._ArgumentPosition()
				: CommandAPIHandler.getNMS()._ArgumentVec3(),
				type == LocationType.BLOCK_POSITION
						? (Location l) -> l.getBlockX() + " " + l.getBlockY() + " " + l.getBlockZ()
						: (Location l) -> l.getX() + " " + l.getY() + " " + l.getZ());
		locationType = type;
	}
	
	private final LocationType locationType;

	/**
	 * Returns whether this argument is LocationType.BLOCK_POSITION or LocationType.PRECISE_POSITION 
	 * @return the location type of this argument
	 */
	public LocationType getLocationType() {
		return locationType;
	}
	
	@Override
	public Class<?> getPrimitiveType() {
		return Location.class;
	}
	
	@Override
	public CommandAPIArgumentType getArgumentType() {
		return CommandAPIArgumentType.LOCATION;
	}
}
