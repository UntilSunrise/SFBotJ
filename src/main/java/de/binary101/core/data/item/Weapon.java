package de.binary101.core.data.item;

import lombok.Getter;

public class Weapon extends Item {
	
	@Getter int minDmg, maxDmg;

	public Weapon(Integer[] itemData) {
		super(itemData);
		
		this.minDmg = itemData[2];
		this.maxDmg = itemData[3];
	}

	@Override
	public String toString() {
		return String.format("Type:%s MinDmg:%s MaxDmg:%s Str:%s Dex:%s Int:%s Sta:%s Luc:%s Epic:%s Value:%s", this.getType(), this.minDmg, this.maxDmg, this.getStrength(), this.getDexterity(), this.getIntelligence(), this.getStamina(), this.getLuck(), this.getEpicValue(), this.getSilverPrice());
	}
}
