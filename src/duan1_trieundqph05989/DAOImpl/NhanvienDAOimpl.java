package duan1_trieundqph05989.DAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;


import duan1_trieundqph05989.DAO.NhanvienDAO;
import duan1_trieundqph05989.entity.Nhanvien;
import duan1_trieundqph05989.util.HibernateUtils;

public class NhanvienDAOimpl implements NhanvienDAO {

	@Override
	public List<Nhanvien> getAlls(int tenphongkham) {
		List<Nhanvien> list = null;
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		try {
	            String sql = "FROM NhanVien";
	       

			session.beginTransaction();
			Query query = session.createQuery(sql);
	            query.setParameter( "maphongkham", tenphongkham);
			list = query.list();
//	            for (Nhanvien pk : list) {
//					System.out.println(pk.getTenNv());
//					System.out.println(pk.getManv());
//					
//	            }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public boolean insert(Nhanvien nhanvien) {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.save(nhanvien);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Nhanvien nhanvien) {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.update(nhanvien);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean delete(String manv) {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.delete(manv);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Nhanvien getNhanVienById(String manv) {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Nhanvien nhanvien = (Nhanvien) session.get(Nhanvien.class, manv);
		session.close();
		return nhanvien;
	}

}
