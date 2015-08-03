package de.binary101.core.data.area.tavern;

import de.binary101.core.constants.enums.ItemTypeEnum;
import de.binary101.core.data.item.Item;
import lombok.Getter;

public class Quest {
	
	@Getter private int index;
	@Getter private int duration;
	@Getter private long silver;
	@Getter private int exp;
	@Getter private Item item;
	@Getter private int monsterId;
	@Getter private Boolean isRedQuest;
	
	public double getExpPerSecond() {
		return this.exp / this.duration;
	}
	
	public double getSilverPerSecond() {
		return this.silver / this.duration;
	}
	
	public Quest(int index, int duration, long silver, int exp, Item item, int monsterId) {
		this.index = index;
		this.duration = duration;
		this.silver = silver;
		this.exp = exp;
		this.item = item;
		this.monsterId = monsterId;
		this.isRedQuest = checkForRedQuest(monsterId);
	}
	
	private Boolean checkForRedQuest(int monsterId) {
		Boolean result;
		
		switch (monsterId) {
		case 148:
        case 152:
        case 155:
        case 157:
        case 139:
        case 145:
			result = true;
			break;
		default:
			result = false;
			break;
		}
		
		return result;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Quest " + this.index + ":\n");
		builder.append("	Dauer: " + this.duration + "\n");
		builder.append("	Silber: " + this.silver + "\n");
		builder.append("	Exp: " + this.exp + "\n");
		if (this.item.getType() != ItemTypeEnum.None) {
			builder.append("	Item: " + this.item.toString() + "\n");
		}
		builder.append("	MonsterId: " + this.monsterId + "\n");
		
		return builder.toString();
	}
}
