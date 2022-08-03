package me.angelfire.rpcard.commands;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import com.google.common.base.CharMatcher;

import me.angelfire.rpcard.Profile;
import me.angelfire.rpcard.RpCard;
import me.angelfire.rpcard.json.ProfileSerializationManager;
import me.angelfire.rpcard.utils.FileUtils;

public class Rpf implements CommandExecutor, TabCompleter{


	private File savedir;
	public Rpf () {
		this.savedir = new File(RpCard.INSTANCE.getDataFolder(), "/profiles");
		RpCard.INSTANCE.getConfig();
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
    	if (args.length == 0) return false;
		final ProfileSerializationManager profileSerializationManager = RpCard.INSTANCE.getProfileSerializationManager();
		        if (args[0].equalsIgnoreCase("set")) {
		    		Player player = (Player) sender;
		    		final File file = new File(savedir, player.getName() + ".json");
		        	if(args[1].equalsIgnoreCase("genre")) {
		        		if (args[2].equalsIgnoreCase("garçon")) {
		        			if(file.exists()) {
		        		final String json = FileUtils.loadContent(file);
	        			final Profile profile = profileSerializationManager.deserialize(json);
	        			final Profile profile1 = Profile.createProfile(player.getUniqueId(), player.getName(), profile.getDeadoralive(), profile.getAge(), profile.getTitre(), profile.getReligion(), profile.getProfession(), profile.getOrigine(), profile.getRace(), profile.getNomRp());
	        			final String json1 = profileSerializationManager.serialize(profile1);
	        			FileUtils.save(file, json1);
		        		}
		        		else {
		        			player.sendMessage(ChatColor.RED + "Profil non existant ! Création en cours...");
		        			final File file1 = new File(savedir, player.getName() + ".json");
		        			final Profile profile = Profile.createProfile(player.getUniqueId(), player.getName(), "None", -1, "None", "None", "None", "None", "None", "None");
		        			final String json = profileSerializationManager.serialize(profile);
		        			FileUtils.save(file1, json);
		        			player.sendMessage(ChatColor.GREEN + "Profil créé");
						}
		        	}
		        		else if (args[2].equalsIgnoreCase("fille")) {
			        		if(file.exists()) {
				        		final String json = FileUtils.loadContent(file);
			        			final Profile profile = profileSerializationManager.deserialize(json);
			        			final Profile profile1 = Profile.createProfile(player.getUniqueId(), player.getName(), profile.getDeadoralive(), profile.getAge(), profile.getTitre(), profile.getReligion(), profile.getProfession(), profile.getOrigine(), profile.getRace(), profile.getNomRp());
			        			final String json1 = profileSerializationManager.serialize(profile1);
			        			FileUtils.save(file, json1);
				        		}
				        		else {
				        			player.sendMessage(ChatColor.RED + "Profil non existant ! Création en cours...");
				        			final File file1 = new File(savedir, player.getName() + ".json");
				        			final Profile profile = Profile.createProfile(player.getUniqueId(), player.getName(), "None", -1, "None", "None", "None", "None", "None", "None");
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
	        			final Profile profile1 = Profile.createProfile(player.getUniqueId(), player.getName(), profile.getDeadoralive(), Integer.parseInt(args[2]), profile.getTitre(), profile.getReligion(), profile.getProfession(), profile.getOrigine(), profile.getRace(), profile.getNomRp());
	        			final String json1 = profileSerializationManager.serialize(profile1);
	        			FileUtils.save(file, json1);
		        		}
		        		else {
		        			player.sendMessage(ChatColor.RED + "Profil non existant ! Création en cours...");
		        			final File file1 = new File(savedir, player.getName() + ".json");
		        			final Profile profile = Profile.createProfile(player.getUniqueId(), player.getName(), "None", Integer.parseInt(args[2]), "None", "None", "None", "None", "None", "None");
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
			        			final Profile profile1 = Profile.createProfile(player.getUniqueId(), player.getName(), "Vivant", profile.getAge(), profile.getTitre(), profile.getReligion(), profile.getProfession(), profile.getOrigine(), profile.getRace(), profile.getNomRp());
			        			final String json1 = profileSerializationManager.serialize(profile1);
			        			FileUtils.save(file, json1);
				        		}
				        		else {
				        			player.sendMessage(ChatColor.RED + "Profil non existant ! Création en cours...");
				        			final File file1 = new File(savedir, player.getName() + ".json");
				        			final Profile profile = Profile.createProfile(player.getUniqueId(), player.getName(), "Vivant", -1, "None", "None", "None", "None", "None", "None");
				        			final String json = profileSerializationManager.serialize(profile);
				        			FileUtils.save(file1, json);
				        			player.sendMessage(ChatColor.GREEN + "Profil créé");
								}
		        		}
		        		else if (args[2].equalsIgnoreCase("mort")) {
			        		if(file.exists()) {
				        		final String json = FileUtils.loadContent(file);
			        			final Profile profile = profileSerializationManager.deserialize(json);
			        			final Profile profile1 = Profile.createProfile(player.getUniqueId(), player.getName(), "Mort", profile.getAge(), profile.getTitre(), profile.getReligion(), profile.getProfession(), profile.getOrigine(), profile.getRace(), profile.getNomRp());
			        			final String json1 = profileSerializationManager.serialize(profile1);
			        			FileUtils.save(file, json1);
				        		}
				        		else {
				        			player.sendMessage(ChatColor.RED + "Profil non existant ! Création en cours...");
				        			final File file1 = new File(savedir, player.getName() + ".json");
				        			final Profile profile = Profile.createProfile(player.getUniqueId(), player.getName(), "Mort", -1, "None", "None", "None", "None", "None", "None");
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
		        			final Profile profile1 = Profile.createProfile(player.getUniqueId(), player.getName(), "Vivant", profile.getAge(), profile.getTitre(), profile.getReligion(), profile.getProfession(), profile.getOrigine(), args[2].toString(), profile.getNomRp());
		        			final String json1 = profileSerializationManager.serialize(profile1);
		        			FileUtils.save(file, json1);
			        		}
			        		else {
			        			player.sendMessage(ChatColor.RED + "Profil non existant ! Création en cours...");
			        			final File file1 = new File(savedir, player.getName() + ".json");
			        			final Profile profile = Profile.createProfile(player.getUniqueId(), player.getName(), "Vivant", -1, "None", "None", "None", "None", args[2].toString(), "None");
			        			final String json = profileSerializationManager.serialize(profile);
			        			FileUtils.save(file1, json);
			        			player.sendMessage(ChatColor.GREEN + "Profil créé");
							}
		        	}
		        	else if (args[1].equalsIgnoreCase("titre")) {
		        		if(file.exists()) {
			        		final String json = FileUtils.loadContent(file);
		        			final Profile profile = profileSerializationManager.deserialize(json);
		        			final Profile profile1 = Profile.createProfile(player.getUniqueId(), player.getName(), "Vivant", profile.getAge(), args[2].toString(), profile.getReligion(), profile.getProfession(), profile.getOrigine(), profile.getRace(), profile.getNomRp());
		        			final String json1 = profileSerializationManager.serialize(profile1);
		        			FileUtils.save(file, json1);
			        		}
			        		else {
			        			player.sendMessage(ChatColor.RED + "Profil non existant ! Création en cours...");
			        			final File file1 = new File(savedir, player.getName() + ".json");
			        			final Profile profile = Profile.createProfile(player.getUniqueId(), player.getName(), "Vivant", -1, args[2].toString(), "None", "None", "None", "None", "None");
			        			final String json = profileSerializationManager.serialize(profile);
			        			FileUtils.save(file1, json);
			        			player.sendMessage(ChatColor.GREEN + "Profil créé");
							}
		        	}
		        	else if (args[1].equalsIgnoreCase("religion")) {
		        		if(file.exists()) {
			        		final String json = FileUtils.loadContent(file);
		        			final Profile profile = profileSerializationManager.deserialize(json);
		        			final Profile profile1 = Profile.createProfile(player.getUniqueId(), player.getName(), "Vivant", profile.getAge(), profile.getTitre(), args[2].toString(), profile.getProfession(), profile.getOrigine(), profile.getRace(), profile.getNomRp());
		        			final String json1 = profileSerializationManager.serialize(profile1);
		        			FileUtils.save(file, json1);
			        		}
			        		else {
			        			player.sendMessage(ChatColor.RED + "Profil non existant ! Création en cours...");
			        			final File file1 = new File(savedir, player.getName() + ".json");
			        			final Profile profile = Profile.createProfile(player.getUniqueId(), player.getName(), "Vivant", -1, "None", args[2].toString(), "None", "None", "None", "None");
			        			final String json = profileSerializationManager.serialize(profile);
			        			FileUtils.save(file1, json);
			        			player.sendMessage(ChatColor.GREEN + "Profil créé");
							}
		        	}
		        	else if (args[1].equalsIgnoreCase("métier")) {
		        		if(file.exists()) {
			        		final String json = FileUtils.loadContent(file);
		        			final Profile profile = profileSerializationManager.deserialize(json);
		        			final Profile profile1 = Profile.createProfile(player.getUniqueId(), player.getName(), "Vivant", profile.getAge(), profile.getTitre(), profile.getReligion(), args[2].toString(), profile.getOrigine(), profile.getRace(), profile.getNomRp());
		        			final String json1 = profileSerializationManager.serialize(profile1);
		        			FileUtils.save(file, json1);
			        		}
			        		else {
			        			player.sendMessage(ChatColor.RED + "Profil non existant ! Création en cours...");
			        			final File file1 = new File(savedir, player.getName() + ".json");
			        			final Profile profile = Profile.createProfile(player.getUniqueId(), player.getName(), "Vivant", -1, "None", "None", args[2].toString(), "None", "None", "None");
			        			final String json = profileSerializationManager.serialize(profile);
			        			FileUtils.save(file1, json);
			        			player.sendMessage(ChatColor.GREEN + "Profil créé");
							}
		        	}
		        	else if (args[1].equalsIgnoreCase("origine")) {
		        		if(file.exists()) {
			        		final String json = FileUtils.loadContent(file);
		        			final Profile profile = profileSerializationManager.deserialize(json);
		        			final Profile profile1 = Profile.createProfile(player.getUniqueId(), player.getName(), "Vivant", profile.getAge(), profile.getTitre(), profile.getReligion(), profile.getProfession(), args[2].toString(), profile.getRace(), profile.getNomRp());
		        			final String json1 = profileSerializationManager.serialize(profile1);
		        			FileUtils.save(file, json1);
			        		}
			        		else {
			        			player.sendMessage(ChatColor.RED + "Profil non existant ! Création en cours...");
			        			final File file1 = new File(savedir, player.getName() + ".json");
			        			final Profile profile = Profile.createProfile(player.getUniqueId(), player.getName(), "Vivant", -1, "None", "None", "None", args[2].toString() , "None", "None");
			        			final String json = profileSerializationManager.serialize(profile);
			        			FileUtils.save(file1, json);
			        			player.sendMessage(ChatColor.GREEN + "Profil créé");
							}
		        	}
		        }
		        if (args[0].equalsIgnoreCase("see")) {
		        	String charsToRemove = "[]";

		        	if (args.length == 1) {
			    		Player player = (Player) sender;
			    		final File file = new File(savedir, player.getName() + ".json");

		        		if(file.exists()) {

		            		final String json = FileUtils.loadContent(file);
		        			final Profile profile = profileSerializationManager.deserialize(json);
		        			String filtered2 = CharMatcher.anyOf(charsToRemove).removeFrom(profile.getNomRp().toString());
		        			String filtered4 = CharMatcher.anyOf(charsToRemove).removeFrom(profile.getDeadoralive().toString());
		        			String filtered5 = CharMatcher.anyOf(charsToRemove).removeFrom(profile.getTitre().toString());
		        			String filtered6 = CharMatcher.anyOf(charsToRemove).removeFrom(profile.getReligion().toString());
		        			String filtered7 = CharMatcher.anyOf(charsToRemove).removeFrom(profile.getProfession().toString());
		        			String filtered8 = CharMatcher.anyOf(charsToRemove).removeFrom(profile.getOrigine().toString());
		        			String filtered9 = CharMatcher.anyOf(charsToRemove).removeFrom(profile.getRace().toString());
		        			Integer age = profile.getAge();
		        			String filtered10 = CharMatcher.anyOf(charsToRemove).removeFrom(age.toString());
		        			String wiki = RpCard.INSTANCE.getConfig().getString("liens.wiki");
		        			player.sendMessage("§lJoueur" + filtered2 + " :");
		        			player.sendMessage("Race : " + filtered9);
		        			if (RpCard.INSTANCE.getConfig().get("age_enabled").equals("true")) {
			        			player.sendMessage("Age : " + filtered10);
							}
		        			player.sendMessage("Status : " + filtered4);
		        			player.sendMessage("Titre : " + filtered5);
		        			player.sendMessage("Religion : " + filtered6);
		        			player.sendMessage("Métier : " + filtered7);
		        			player.sendMessage("Origine : " + filtered8);
		        			player.sendMessage(wiki + player.getName());



		            		}
		        		else {
		        			player.sendMessage(ChatColor.RED + "Profil non existant ! Création en cours...");
		        			final Profile profile = Profile.createProfile(player.getUniqueId(), player.getName(), "Vivant", -1, "None", "None", "None", "None", "None", "None");
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
		        			String filtered2 = CharMatcher.anyOf(charsToRemove).removeFrom(profile.getNomRp().toString());
		        			String filtered4 = CharMatcher.anyOf(charsToRemove).removeFrom(profile.getDeadoralive().toString());
		        			String filtered5 = CharMatcher.anyOf(charsToRemove).removeFrom(profile.getTitre().toString());
		        			String filtered6 = CharMatcher.anyOf(charsToRemove).removeFrom(profile.getReligion().toString());
		        			String filtered7 = CharMatcher.anyOf(charsToRemove).removeFrom(profile.getProfession().toString());
		        			String filtered8 = CharMatcher.anyOf(charsToRemove).removeFrom(profile.getOrigine().toString());
		        			String filtered9 = CharMatcher.anyOf(charsToRemove).removeFrom(profile.getRace().toString());
		        			Integer age = profile.getAge();
		        			String filtered10 = CharMatcher.anyOf(charsToRemove).removeFrom(age.toString());
		        			String wiki = RpCard.INSTANCE.getConfig().getString("liens.wiki");
		        			sender.sendMessage("§lJoueur" + filtered2 + " :");
		        			sender.sendMessage("Race : " + filtered9);
		        			if (RpCard.INSTANCE.getConfig().get("age_enabled").equals("true")) {
			        			sender.sendMessage("Age : " + filtered10);
							}
		        			sender.sendMessage("Status : " + filtered4);
		        			sender.sendMessage("Titre : " + filtered5);
		        			sender.sendMessage("Religion : " + filtered6);
		        			sender.sendMessage("Métier : " + filtered7);
		        			sender.sendMessage("Origine : " + filtered8);
		        			sender.sendMessage(wiki + profile.getPlayername());
		            	}
		            	else {
		        			sender.sendMessage(ChatColor.RED + "Profil non existant ! Création en cours...");
		        			final File file1 = new File(savedir, args[1] + ".json");
		        			final Profile profile = Profile.createProfile(Bukkit.getPlayerUniqueId(args[1]), args[1], "Vivant", -1, "None", "None", "None", "None", "None", "None");
		        			final String json = profileSerializationManager.serialize(profile);

		        			FileUtils.save(file1, json);
		        			sender.sendMessage(ChatColor.GREEN + "Profil créé");

		        		}
					}
		        }
		        return false;
		    }



		    @Override
		    public List<String> onTabComplete(final CommandSender sender, @NotNull Command cmd, @NotNull String alias, @NotNull String[] args) {
		        if (args.length == 1) return Arrays.asList("set", "see");
		        if (args[0].equalsIgnoreCase("set") && args.length == 2) return Arrays.asList("genre", "race", "age", "status", "titre", "religion", "métier", "origine");
		        if (args[1].equalsIgnoreCase("status") && args.length == 3) return Arrays.asList("vivant", "mort");
		        if (args[1].equalsIgnoreCase("genre") && args.length == 3) return Arrays.asList("garçon");
				return null;
		        }





}
