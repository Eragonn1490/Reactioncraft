package Reactioncraft.NetMod.ltd.genuine.database;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;

public class ExclusionList implements Iterable {

	public static final ExclusionList instance = new ExclusionList();

	private static List<String> list = new ArrayList<String>();

	private ExclusionList() {}

	public void addExclusion(String name) {
		list.add(name);
	}

	public void removeExclusion(String name) {
		list.remove(name);
	}

	public boolean isExcluded(String name) {
		return list.contains(name);
	}

	public void addExclusion(Entity entity) {
		list.add(EntityList.getEntityString(entity));
	}

	public void removeExclusion(Entity entity) {
		list.remove(EntityList.getEntityString(entity));
	}

	public boolean isExcluded(Entity entity) {
		return list.contains(EntityList.getEntityString(entity));
	}

	@Override
	public Iterator iterator() {
		return list.iterator();
	}
}
