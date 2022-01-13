package me.angelfire.rpcard.commands;

import java.io.File;
import java.io.ObjectInputFilter.Config;
import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.google.common.base.CharMatcher;

import me.angelfire.rpcard.Profile;
import me.angelfire.rpcard.RpCard;
import me.angelfire.rpcard.json.ProfileSerializationManager;
import me.angelfire.rpcard.utils.FileUtils;

public class Rpf implements @Nullable CommandExecutor, TabCompleter{
	
	
	private File savedir;
	private RpCard plugin;
	private FileConfiguration config;

	
	
	public Rpf (RpCard plugin) {
		this.plugin = plugin;
		this.savedir = new File(plugin.getDataFolder(), "/profiles");
		this.config = plugin.getConfig();
	}
	
	public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		
		Player player = (Player) sender;
		final File file = new File(savedir, player.getName() + ".json");
		final ProfileSerializationManager profileSerializationManager = plugin.getProfileSerializationManager();
    	if (args.length == 0) return false;
    			
		        if (args[0].equalsIgnoreCase("set")) {
		        	if(args[1].equalsIgnoreCase("genre")) {
		        		if (args[2].equalsIgnoreCase("garçon")) {
		        			if(file.exists()) {
		        		final String json = FileUtils.loadContent(file);
	        			final Profile profile = profileSerializationManager.deserialize(json);
	        			final Profile profile1 = Profile.createProfile(player.getName(), "garçon", profile.getDeadoralive(), profile.getAge(), profile.getTitre(), profile.getReligion(), profile.getProfession(), profile.getOrigine(), profile.getRace(), profile.getNomRp());
	        			final String json1 = profileSerializationManager.serialize(profile1);
	        			FileUtils.save(file, json1);
		        		}
		        		else {
		        			player.sendMessage(ChatColor.RED + "Profil non existant ! Création en cours...");
		        			final File file1 = new File(savedir, player.getName() + ".json");	
		        			final Profile profile = Profile.createProfile(player.getName(), "garçon", "None", -1, "None", "None", "None", "None", "None", "None");
		        			final String json = profileSerializationManager.serialize(profile);
		        			FileUtils.save(file1, json);
		        			player.sendMessage(ChatColor.GREEN + "Profil créé");
						}
		        	}
		        		else if (args[2].equalsIgnoreCase("fille")) {
			        		if(file.exists()) {
				        		final String json = FileUtils.loadContent(file);
			        			final Profile profile = profileSerializationManager.deserialize(json);
			        			final Profile profile1 = Profile.createProfile(player.getName(), "fille", profile.getDeadoralive(), profile.getAge(), profile.getTitre(), profile.getReligion(), profile.getProfession(), profile.getOrigine(), profile.getRace(), profile.getNomRp());
			        			final String json1 = profileSerializationManager.serialize(profile1);
			        			FileUtils.save(file, json1);
				        		}
				        		else {
				        			player.sendMessage(ChatColor.RED + "Profil non existant ! Création en cours...");
				        			final File file1 = new File(savedir, player.getName() + ".json");	
				        			final Profile profile = Profile.createProfile(player.getName(), "fille", "None", -1, "None", "None", "None", "None", "None", "None");
				        			final String json = profileSerializationManager.serialize(profile);
				        			FileUtils.save(file1, json);
				        			player.sendMessage(ChatColor.GREEN + "Profil créé");
								}
		        		}
		        	}
		        		
		        	else if(args[1].equalsIgnoreCase("age")) {
		        		if (isInt(args[2])) {
		        		if(file.exists()) {
		        		final String json = FileUtils.loadContent(file);
	        			final Profile profile = profileSerializationManager.deserialize(json);
	        			final Profile profile1 = Profile.createProfile(player.getName(), profile.getGirlOrBoy(), profile.getDeadoralive(), Integer.parseInt(args[2]), profile.getTitre(), profile.getReligion(), profile.getProfession(), profile.getOrigine(), profile.getRace(), profile.getNomRp());
	        			final String json1 = profileSerializationManager.serialize(profile1);
	        			FileUtils.save(file, json1);
		        		}
		        		else {
		        			player.sendMessage(ChatColor.RED + "Profil non existant ! Création en cours...");
		        			final File file1 = new File(savedir, player.getName() + ".json");
		        			final Profile profile = Profile.createProfile(player.getName(), "Inconnu", "None", Integer.parseInt(args[2]), "None", "None", "None", "None", "None", "None");
		        			final String json = profileSerializationManager.serialize(profile);
		        			FileUtils.save(file1, json);
		        			player.sendMessage(ChatColor.GREEN + "Profil créé");
						}
		        		}
		        		else {
		        			player.sendMessage("Please answer a full number");
		        		}
		        	}
		        	else if (args[1].equalsIgnoreCase("status")) {
		        		if (args[2].equalsIgnoreCase("vivant")) {
			        		if(file.exists()) {
				        		final String json = FileUtils.loadContent(file);
			        			final Profile profile = profileSerializationManager.deserialize(json);
			        			final Profile profile1 = Profile.createProfile(player.getName(), profile.getGirlOrBoy(), "Vivant", profile.getAge(), profile.getTitre(), profile.getReligion(), profile.getProfession(), profile.getOrigine(), profile.getRace(), profile.getNomRp());
			        			final String json1 = profileSerializationManager.serialize(profile1);
			        			FileUtils.save(file, json1);
				        		}
				        		else {
				        			player.sendMessage(ChatColor.RED + "Profil non existant ! Création en cours...");
				        			final File file1 = new File(savedir, player.getName() + ".json");
				        			final Profile profile = Profile.createProfile(player.getName(), "Inconnu", "Vivant", -1, "None", "None", "None", "None", "None", "None");
				        			final String json = profileSerializationManager.serialize(profile);
				        			FileUtils.save(file1, json);
				        			player.sendMessage(ChatColor.GREEN + "Profil créé");
								}
		        		}
		        		else if (args[2].equalsIgnoreCase("mort")) {
			        		if(file.exists()) {
				        		final String json = FileUtils.loadContent(file);
			        			final Profile profile = profileSerializationManager.deserialize(json);
			        			final Profile profile1 = Profile.createProfile(player.getName(), profile.getGirlOrBoy(), "Mort", profile.getAge(), profile.getTitre(), profile.getReligion(), profile.getProfession(), profile.getOrigine(), profile.getRace(), profile.getNomRp());
			        			final String json1 = profileSerializationManager.serialize(profile1);
			        			FileUtils.save(file, json1);
				        		}
				        		else {
				        			player.sendMessage(ChatColor.RED + "Profil non existant ! Création en cours...");
				        			final File file1 = new File(savedir, player.getName() + ".json");
				        			final Profile profile = Profile.createProfile(player.getName(), "Inconnu", "Mort", -1, "None", "None", "None", "None", "None", "None");
				        			final String json = profileSerializationManager.serialize(profile);
				        			FileUtils.save(file1, json);
				        			player.sendMessage(ChatColor.GREEN + "Profil créé");
								}
		        		}
		        		
		        	}
		        	else if (args[1].equalsIgnoreCase("race")) {
		        		if(file.exists()) {
			        		final String json = FileUtils.loadContent(file);
		        			final Profile profile = profileSerializationManager.deserialize(json);
		        			final Profile profile1 = Profile.createProfile(player.getName(), profile.getGirlOrBoy(), "Vivant", profile.getAge(), profile.getTitre(), profile.getReligion(), profile.getProfession(), profile.getOrigine(), args[2].toString(), profile.getNomRp());
		        			final String json1 = profileSerializationManager.serialize(profile1);
		        			FileUtils.save(file, json1);
			        		}
			        		else {
			        			player.sendMessage(ChatColor.RED + "Profil non existant ! Création en cours...");
			        			final File file1 = new File(savedir, player.getName() + ".json");
			        			final Profile profile = Profile.createProfile(player.getName(), "Inconnu", "Vivant", -1, "None", "None", "None", "None", args[2].toString(), "None");
			        			final String json = profileSerializationManager.serialize(profile);
			        			FileUtils.save(file1, json);
			        			player.sendMessage(ChatColor.GREEN + "Profil créé");
							}
		        	}
		        	else if (args[1].equalsIgnoreCase("titre")) {
		        		if(file.exists()) {
			        		final String json = FileUtils.loadContent(file);
		        			final Profile profile = profileSerializationManager.deserialize(json);
		        			final Profile profile1 = Profile.createProfile(player.getName(), profile.getGirlOrBoy(), "Vivant", profile.getAge(), args[2].toString(), profile.getReligion(), profile.getProfession(), profile.getOrigine(), profile.getRace(), profile.getNomRp());
		        			final String json1 = profileSerializationManager.serialize(profile1);
		        			FileUtils.save(file, json1);
			        		}
			        		else {
			        			player.sendMessage(ChatColor.RED + "Profil non existant ! Création en cours...");
			        			final File file1 = new File(savedir, player.getName() + ".json");
			        			final Profile profile = Profile.createProfile(player.getName(), "Inconnu", "Vivant", -1, args[2].toString(), "None", "None", "None", "None", "None");
			        			final String json = profileSerializationManager.serialize(profile);
			        			FileUtils.save(file1, json);
			        			player.sendMessage(ChatColor.GREEN + "Profil créé");
							}
		        	}
		        	else if (args[1].equalsIgnoreCase("religion")) {
		        		if(file.exists()) {
			        		final String json = FileUtils.loadContent(file);
		        			final Profile profile = profileSerializationManager.deserialize(json);
		        			final Profile profile1 = Profile.createProfile(player.getName(), profile.getGirlOrBoy(), "Vivant", profile.getAge(), profile.getTitre(), args[2].toString(), profile.getProfession(), profile.getOrigine(), profile.getRace(), profile.getNomRp());
		        			final String json1 = profileSerializationManager.serialize(profile1);
		        			FileUtils.save(file, json1);
			        		}
			        		else {
			        			player.sendMessage(ChatColor.RED + "Profil non existant ! Création en cours...");
			        			final File file1 = new File(savedir, player.getName() + ".json");
			        			final Profile profile = Profile.createProfile(player.getName(), "Inconnu", "Vivant", -1, "None", args[2].toString(), "None", "None", "None", "None");
			        			final String json = profileSerializationManager.serialize(profile);
			        			FileUtils.save(file1, json);
			        			player.sendMessage(ChatColor.GREEN + "Profil créé");
							}
		        	}
		        	else if (args[1].equalsIgnoreCase("métier")) {
		        		if(file.exists()) {
			        		final String json = FileUtils.loadContent(file);
		        			final Profile profile = profileSerializationManager.deserialize(json);
		        			final Profile profile1 = Profile.createProfile(player.getName(), profile.getGirlOrBoy(), "Vivant", profile.getAge(), profile.getTitre(), profile.getReligion(), args[2].toString(), profile.getOrigine(), profile.getRace(), profile.getNomRp());
		        			final String json1 = profileSerializationManager.serialize(profile1);
		        			FileUtils.save(file, json1);
			        		}
			        		else {
			        			player.sendMessage(ChatColor.RED + "Profil non existant ! Création en cours...");
			        			final File file1 = new File(savedir, player.getName() + ".json");
			        			final Profile profile = Profile.createProfile(player.getName(), "Inconnu", "Vivant", -1, "None", "None", args[2].toString(), "None", "None", "None");
			        			final String json = profileSerializationManager.serialize(profile);
			        			FileUtils.save(file1, json);
			        			player.sendMessage(ChatColor.GREEN + "Profil créé");
							}
		        	}
		        	else if (args[1].equalsIgnoreCase("origine")) {
		        		if(file.exists()) {
			        		final String json = FileUtils.loadContent(file);
		        			final Profile profile = profileSerializationManager.deserialize(json);
		        			final Profile profile1 = Profile.createProfile(player.getName(), profile.getGirlOrBoy(), "Vivant", profile.getAge(), profile.getTitre(), profile.getReligion(), profile.getProfession(), args[2].toString(), profile.getRace(), profile.getNomRp());
		        			final String json1 = profileSerializationManager.serialize(profile1);
		        			FileUtils.save(file, json1);
			        		}
			        		else {
			        			player.sendMessage(ChatColor.RED + "Profil non existant ! Création en cours...");
			        			final File file1 = new File(savedir, player.getName() + ".json");
			        			final Profile profile = Profile.createProfile(player.getName(), "Inconnu", "Vivant", -1, "None", "None", "None", args[2].toString() , "None", "None");
			        			final String json = profileSerializationManager.serialize(profile);
			        			FileUtils.save(file1, json);
			        			player.sendMessage(ChatColor.GREEN + "Profil créé");
							}
		        	}
		        }
		        if (args[0].equalsIgnoreCase("see")) {
		        	String charsToRemove = "[]";
		    		
		        	if (args.length == 1) {
		        		
		        		if(file.exists()) {
		        			
		            		final String json = FileUtils.loadContent(file);
		        			final Profile profile = profileSerializationManager.deserialize(json);
		        			String filtered2 = CharMatcher.anyOf(charsToRemove).removeFrom(profile.getNomRp().toString());
		        			String filtered3 = CharMatcher.anyOf(charsToRemove).removeFrom(profile.getGirlOrBoy().toString());
		        			String filtered4 = CharMatcher.anyOf(charsToRemove).removeFrom(profile.getDeadoralive().toString());
		        			String filtered5 = CharMatcher.anyOf(charsToRemove).removeFrom(profile.getTitre().toString());
		        			String filtered6 = CharMatcher.anyOf(charsToRemove).removeFrom(profile.getReligion().toString());
		        			String filtered7 = CharMatcher.anyOf(charsToRemove).removeFrom(profile.getProfession().toString());
		        			String filtered8 = CharMatcher.anyOf(charsToRemove).removeFrom(profile.getOrigine().toString());
		        			String filtered9 = CharMatcher.anyOf(charsToRemove).removeFrom(profile.getRace().toString());
		        			Integer age = profile.getAge();
		        			String filtered10 = CharMatcher.anyOf(charsToRemove).removeFrom(age.toString());
		        			String wiki = plugin.getConfig().getString("lien.wiki");
		        			player.sendMessage("§lJoueur" + filtered2 + " :");
		        			player.sendMessage("Race : " + filtered9);
		        			player.sendMessage("Age : " + filtered10);
		        			player.sendMessage("Status : " + filtered4);
		        			player.sendMessage("Genre : " + filtered3);
		        			player.sendMessage("Titre : " + filtered5);
		        			player.sendMessage("Religion : " + filtered6);
		        			player.sendMessage("Métier : " + filtered7);
		        			player.sendMessage("Origine : " + filtered8);
		        			player.sendMessage(wiki + player.getName());

		        			

		            		}
		        		else {
		        			player.sendMessage(ChatColor.RED + "Profil non existant ! Création en cours...");
		        			final Profile profile = Profile.createProfile(player.getName(), "Inconnu", "Vivant", -1, "None", "None", "None", "None", "None", "None");
		        			final String json = profileSerializationManager.serialize(profile);

		        			FileUtils.save(file, json);
		        			player.sendMessage(ChatColor.GREEN + "Profil créé");
		        		}
		        	}
		        	else if (args.length == 2) {
		        		final File file2 = new File(savedir, args[1] + ".json");
		            	if(file2.exists()) {
		            		final String json = FileUtils.loadContent(file2);
		        			final Profile profile = profileSerializationManager.deserialize(json);
		        			String filtered9 = CharMatcher.anyOf(charsToRemove).removeFrom(profile.getDeadoralive().toString());
		        			Integer age = profile.getAge();
		        			String filtered10 = CharMatcher.anyOf(charsToRemove).removeFrom(age.toString());
		        			player.sendMessage("§lJoueur :");
		        			player.sendMessage("Age : " + filtered10);
		        			player.sendMessage("Status : " + filtered9);
		            	}
		            	else {
		        			player.sendMessage(ChatColor.RED + "Profil non existant ! Création en cours...");
		        			final File file1 = new File(savedir, player.getName() + ".json");	
		        			final Profile profile = Profile.createProfile(player.getName(), "Inconnu", "Vivant", -1, "None", "None", "None", "None", "None", "None");
		        			final String json = profileSerializationManager.serialize(profile);

		        			FileUtils.save(file1, json);
		        			player.sendMessage(ChatColor.GREEN + "Profil créé");
		        			
		        		}
					}
		        }
		        return false;
		    }
				
	

		    @Override
		    public List<String> onTabComplete(final CommandSender sender, @NotNull Command cmd, @NotNull String alias, @NotNull String[] args) {
		        if (args.length == 1) return Arrays.asList("set", "see");
		        if (args[0].equalsIgnoreCase("set") && args.length == 2) return Arrays.asList("genre", "race", "age", "vivant", "staus", "titre", "religion", "métier", "origine");
		        if (args[1].equalsIgnoreCase("alive") && args.length == 3) return Arrays.asList("true", "false");
				return null; 
		        }
		    
		    

	

}
