package duan1_trieundqph05989.DAO;

import java.util.List;

import duan1_trieundqph05989.entity.Phieukham;

public interface PhieukhamDAO {
	public List<Phieukham> getAlls(String mapik);

    public boolean insert(Phieukham phieukham);

    public boolean update(Phieukham phieukham);

    public boolean delete(int mapik);

    public Phieukham getPhieukhamById(int mapik);

}
