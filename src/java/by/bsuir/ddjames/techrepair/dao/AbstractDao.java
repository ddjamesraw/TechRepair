package by.bsuir.ddjames.techrepair.dao;

import java.io.Serializable;
import java.util.List;

public interface AbstractDao <Entity extends Serializable> {
	Entity getById (Long entityId);
	List<Entity> getAll ();
	Long create (Entity obj);
	void delete (Entity obj);
	void update (Entity obj);
}
