package duan1_trieundqph05989.DAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;


import duan1_trieundqph05989.DAO.PhongkhamDAO;
import duan1_trieundqph05989.entity.Phongkham;
import duan1_trieundqph05989.util.HibernateUtils;

public class PhongkhamDAOimpl implements PhongkhamDAO {

	@Override
	public List<Phongkham> getAlls(int maphongkham) {
		List<Phongkham> list = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
       
        try {
//        	String sql = "FROM Phieukham pk where pk.phongkham.mapk = :phongkham";
//    	String sql = "From Phongkham pk  where pk.maphongkham=:maphongkham";
        	String sql = "From Phongkham";

            session.beginTransaction();
            Query query = session.createQuery(sql);
//            query.setParameter( "maphongkham", maphongkham);
            list = query.list();
            for (Phongkham pk : list) {
            	System.out.println(pk.getTenphongkham());
            	System.out.println(pk.getMaphongkham());
            	System.out.println(pk.getNhanvien().getManv());
            	System.out.println(pk.getNhanvien().getTennv());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
	}

	@Override
	public boolean insert(Phongkham phongkham) {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(phongkham);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return false;
	}

	@Override
	public boolean update(Phongkham phongkham) {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.update(phongkham);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
		return false;
	}

	@Override
	public boolean delete(int mapk) {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.delete(mapk);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
		return false;
	}

	@Override
	public Phongkham getphongkhamById(int mapk) {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Phongkham phongkham = (Phongkham) session.get(Phongkham.class, mapk);
        session.close();
        return phongkham;
	}

}
