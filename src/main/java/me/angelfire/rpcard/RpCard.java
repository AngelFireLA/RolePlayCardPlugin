package me.angelfire.rpcard;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import me.angelfire.rpcard.commands.Rpf;
import me.angelfire.rpcard.json.ProfileSerializationManager;


public final class RpCard extends JavaPlugin {
	
	public static RpCard INSTANCE;
	private ProfileSerializationManager profileSerializationManager;
	
	FileConfiguration config = getConfig();
	





	@Override
    public void onEnable() {;
    	INSTANCE  = this;
    	this.profileSerializationManager  = new ProfileSerializationManager();
        saveDefaultConfig();
    	getCommand("rpcard").setExecutor(new Rpf(this));

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
	
	public FileConfiguration getConfig() {
		return config;
	}
}
