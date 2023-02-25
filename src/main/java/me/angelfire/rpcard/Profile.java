package me.angelfire.rpcard;

import java.io.File;
import java.util.UUID;

import org.bukkit.Bukkit;

import me.angelfire.rpcard.json.ProfileSerializationManager;
import me.angelfire.rpcard.utils.FileUtils;

public class Profile {

	private String playername;
	private int age;
	private String titre;
	private String religion;
	private String profession;
	private String origine;
	private String race;
	private String nomRp;
	private String deadoralive;
	private UUID uuid;


	public Profile(String playername, String deadoralive, Integer age, String titre, String religion, String profession, String origine, String race, String nomRp, UUID uuid) {
		super();
		this.playername = playername;
		this.deadoralive = deadoralive;
		this.age = age;
		this.titre = titre;
		this.religion = religion;
		this.profession = profession;
		this.origine = origine;
		this.race = race;
		this.nomRp = nomRp;
		this.uuid = uuid;

	}




	public int getAge() {
		return age;
	}

	public String getPlayername() {
		return playername;
	}


	public String getTitre() {
		return titre;
	}


	public String getReligion() {
		return religion;
	}


	public String getProfession() {
		return profession;
	}


	public String getOrigine() {
		return origine;
	}


	public String getRace() {
		return race;
	}


	public String getNomRp() {
		return nomRp;
	}


	public String getDeadoralive() {
		return deadoralive;
	}

	public UUID getUuid() {
		return uuid;
	}




	public static Profile createProfile(UUID uuid, String playername, String deadoralive, Integer age, String titre, String religion, String profession, String origine, String race, String nomRp) {
		return new Profile( playername, deadoralive,  age,  titre,  religion,  profession,  origine,  race,  nomRp, uuid);

	}

	public static Profile getProfile(String pname) {
		File savedir = new File(RpCard.INSTANCE.getDataFolder(), "/profiles/"+ pname.toString());
		final File file = new File(savedir, pname + ".json");
		final String json = FileUtils.loadContent(file);
		final ProfileSerializationManager profileSerializationManager = RpCard.INSTANCE.getProfileSerializationManager();
		final Profile profile = profileSerializationManager.deserialize(json);
		return createProfile(Bukkit.getPlayer(pname).getUniqueId(), pname, profile.getDeadoralive(), profile.getAge(), profile.getTitre(), profile.getReligion(), profile.getProfession(), profile.getOrigine(), profile.getRace(), profile.getNomRp());
	}

}
