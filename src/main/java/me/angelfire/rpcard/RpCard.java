package me.angelfire.rpcard;

import org.bukkit.plugin.java.JavaPlugin;

import me.angelfire.rpcard.commands.Rpf;
import me.angelfire.rpcard.json.ProfileSerializationManager;


public final class RpCard extends JavaPlugin {

	public static RpCard INSTANCE;
	private ProfileSerializationManager profileSerializationManager;

	@Override
    public void onEnable() {
    	INSTANCE  = this;
    	this.profileSerializationManager  = new ProfileSerializationManager();
        saveDefaultConfig();
    	getCommand("rpcard").setExecutor(new Rpf());

    }


	@Override
    public void onDisable() {
        // Plugin shutdown logic
    }



	public void setProfileSerializationManager(ProfileSerializationManager profileSerializationManager) {
		this.profileSerializationManager = profileSerializationManager;
	}


	public ProfileSerializationManager getProfileSerializationManager() {
		return profileSerializationManager;
	}
}
