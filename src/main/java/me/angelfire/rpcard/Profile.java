package me.angelfire.rpcard;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.bukkit.entity.Player;

public class Profile {
	
	private String girlOrBoy;
	private String playername;
	private int age;
	private String titre;
	private String religion;
	private String profession;
	private String origine;
	private String race;
	private String nomRp;
	private String deadoralive;
	
	
	public Profile(String playername, String girlOrBoy, String deadoralive, Integer age, String titre, String religion, String profession, String origine, String race, String nomRp) {
		super();
		this.girlOrBoy = girlOrBoy;
		this.playername = playername;
		this.deadoralive = deadoralive;
		this.age = age;
		this.titre = titre;
		this.religion = religion;
		this.profession = profession;
		this.origine = origine;
		this.race = race;
		this.nomRp = nomRp;

	}


	

	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getGirlOrBoy() {
		return girlOrBoy;
	}
	
	public String getPlayername() {
		return playername;
	}


	public String getTitre() {
		return titre;
	}




	public void setTitre(String titre) {
		this.titre = titre;
	}




	public String getReligion() {
		return religion;
	}




	public void setReligion(String religion) {
		this.religion = religion;
	}




	public String getProfession() {
		return profession;
	}




	public void setProfession(String profession) {
		this.profession = profession;
	}




	public String getOrigine() {
		return origine;
	}




	public void setOrigine(String origine) {
		this.origine = origine;
	}




	public String getRace() {
		return race;
	}




	public void setRace(String race) {
		this.race = race;
	}




	public String getNomRp() {
		return nomRp;
	}




	public void setNomRp(String nomRp) {
		this.nomRp = nomRp;
	}




	public void setGirlOrBoy(String girlOrBoy) {
		this.girlOrBoy = girlOrBoy;
	}




	public void setPlayername(String playername) {
		this.playername = playername;
	}
	
	public void setDeadoralive(String deadoralive) {
		this.deadoralive = deadoralive;
	}


	
	public String getDeadoralive() {
		return deadoralive;
	}




	public static Profile createProfile(String playername, String girlOrBoy, String deadoralive, Integer age, String titre, String religion, String profession, String origine, String race, String nomRp) {
		return new Profile( playername,  girlOrBoy,  deadoralive,  age,  titre,  religion,  profession,  origine,  race,  nomRp);

	}

}
