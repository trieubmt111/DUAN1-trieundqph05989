package duan1_trieundqph05989.DAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import duan1_trieundqph05989.DAO.PhieukhamDAO;
import duan1_trieundqph05989.entity.Phieukham;
import duan1_trieundqph05989.util.HibernateUtils;

public class PhieukhamDAOimpl implements PhieukhamDAO {

	@Override
	public List<Phieukham> getAlls(int mapik) {
		 List<Phieukham> list = null;
	        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
	        try {
//	        	String sql = "From Phieukham phk where phk.nhanVien.phongkham.maphongkham = :maphongkham";
	        	String sql = "From Phieukham pk where pk.phongkham.maphongkham=:maphongkham";
	        	session.beginTransaction();
		            Query query = session.createQuery(sql);
		            query.setParameter("maphongkham", mapik);
		            list = query.list();
		            for(Phieukham pk : list) {
		            	System.out.println(pk.getBenhnhan().getMabn());
		             	System.out.println(pk.getBenhnhan().getTenbn());
		        
		            	System.out.println(pk.getPhongkham().getNhanvien().getManv());
		            	System.out.println(pk.getNgaykham());
		            	System.out.println(pk.getPhongkham().getNhanvien().getTennv());
		            	System.out.println(pk.getNgaykham());
		            	System.out.println(pk.getHuongdieutri());
		    
//		           
		            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	        return list;
		
	}

 @Override
	public boolean insert(Phieukham phieukham) {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(phieukham);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
		return false;
	}

	@Override
	public boolean update(Phieukham phieukham) {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.update(phieukham);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
		return false;
	}

	@Override
	public boolean delete(int mapik) {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.delete(mapik);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
		return false;
	}

	@Override
	public Phieukham getPhieukhamById(int mapik) {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Phieukham phieukham = (Phieukham) session.get(Phieukham.class, mapik);
        session.close();
        return phieukham;
	}

	

		

}
