package duan1_trieundqph05989.DAO;

import java.util.List;

import duan1_trieundqph05989.entity.Phongkham;



public interface PhongkhamDAO {
	public List<Phongkham> getAlls(int mapk);

    public boolean insert(Phongkham phongkham);

    public boolean update(Phongkham phongkham);

    public boolean delete(int mapk);

    public Phongkham getphongkhamById(int mapk);
}
