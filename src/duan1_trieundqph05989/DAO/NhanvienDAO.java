package duan1_trieundqph05989.DAO;

import java.util.List;

import duan1_trieundqph05989.entity.Nhanvien;

public interface NhanvienDAO {
	public List<Nhanvien> getAlls(int tenphongkham);

    public boolean insert(Nhanvien nhanvien);

    public boolean update(Nhanvien nhanvien);

    public boolean delete(String manv);

    public Nhanvien getNhanVienById(String manv);
}
