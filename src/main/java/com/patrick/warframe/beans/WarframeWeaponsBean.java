package com.patrick.warframe.beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.patrick.warframe.facade_interface.WarframeFacade;
import com.patrick.warframe.searchobjects.WeaponSearchCriteria;
import com.patrick.warframe.wikiexports.WarframeWeapon;

@Named
@SessionScoped
public class WarframeWeaponsBean extends WarframeBaseBean {
	private static final long serialVersionUID = -2660474888912529624L;

	private Collection<WarframeWeapon> weapons;
	private Collection<WarframeWeapon> filteredWeapons;
	private WeaponSearchCriteria searchObject = new WeaponSearchCriteria();

	@Inject
	private WarframeFacade warframeFacade;

	@PostConstruct
	public void init() {
		weapons = warframeFacade.getWarframeWeapons();
		filteredWeapons = weapons;
	}

	public String getWeaponsPrettyPrint() {
		Gson gson = getPrettyPrintingGson();
		return gson.toJson(weapons);
	}

	public void filter() {
		filteredWeapons = weapons.stream()
				.filter(weapon -> StringUtils.isEmpty(searchObject.getWeaponName())
						|| StringUtils.contains(weapon.getName(), searchObject.getWeaponName()))
				.collect(Collectors.toList());
	}

	/**
	 * This is for debug purposes
	 * 
	 * @return
	 */
	private Collection<WarframeWeapon> getWeaponsWithoutImages() {
		return weapons.stream().filter(weapon -> StringUtils.isEmpty(weapon.imageLocation))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	public Collection<WarframeWeapon> getWeapons() {
		return weapons;
	}

	public void setWeapons(Collection<WarframeWeapon> weapons) {
		this.weapons = weapons;
	}

	public Collection<WarframeWeapon> getFilteredWeapons() {
		return filteredWeapons;
	}

	public void setFilteredWeapons(Collection<WarframeWeapon> filteredWeapons) {
		this.filteredWeapons = filteredWeapons;
	}

	public WeaponSearchCriteria getSearchObject() {
		return searchObject;
	}

	public void setSearchObject(WeaponSearchCriteria searchObject) {
		this.searchObject = searchObject;
	}
}
