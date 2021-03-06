package de.binary101.core.constants.enums;

public enum DungeonEnum {
	Desecrated_Catacombs(0),
	Mines_of_Gloria(1),
	Ruins_of_Gnark(2),
	Cutthroat_Grotto(3),
	Emerald_Scale_Altar(4),
	Toxic_Tree(5),
	Magma_Stream(6),
	Frost_Blood_Temple(7),
	Pyramids_of_Madness(8),
	Black_Skull_Fortress(9),
	Circus_of_Horror(10),
	Hell(11),
	The_13th_Floor(12),
	Portal(13),
	Tower(14);

	private final Integer id;

	private DungeonEnum(Integer id) {
		this.id = id;
	}

	public static DungeonEnum fromInt(int value) {
		DungeonEnum result = null;
		for (DungeonEnum type : DungeonEnum.values()) {
			if (value == (type.id)) {
				result = type;
			}
		}
		return result;
	}

	public Integer getId() {
		return this.id;
	}
}
