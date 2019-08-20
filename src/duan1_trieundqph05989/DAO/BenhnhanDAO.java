package duan1_trieundqph05989.DAO;

import java.util.List;

import duan1_trieundqph05989.entity.Benhnhan;



public interface BenhnhanDAO {
	public List<Benhnhan> getAlls();

    public boolean insert(Benhnhan benhnhan);

    public boolean update(Benhnhan benhnhan);

    public boolean delete(String mabn);

    public Benhnhan getBenhnhanById(String mabn);
}
