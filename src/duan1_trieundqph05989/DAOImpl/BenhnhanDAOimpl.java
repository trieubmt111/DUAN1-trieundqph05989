package duan1_trieundqph05989.DAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;


import duan1_trieundqph05989.DAO.BenhnhanDAO;
import duan1_trieundqph05989.entity.Benhnhan;
import duan1_trieundqph05989.util.HibernateUtils;

public class BenhnhanDAOimpl implements BenhnhanDAO {
		@Override
		public List<Benhnhan> getAlls() {
			 List<Benhnhan> list = null;
		        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		        try {
		            String sql = "FROM Benhnhan";
		            session.beginTransaction();
		            Query query = session.createQuery(sql);
		            list = query.list();
		        } catch (Exception e) {
		            e.printStackTrace();
		        } finally {
		            session.close();
		        }
		        return list;
		}

		@Override
		public boolean insert(Benhnhan benhnhan) {
			 Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		        try {
		            session.beginTransaction();
		            session.save(benhnhan);
		            session.getTransaction().commit();
		            return true;
		        } catch (Exception e) {
		            session.getTransaction().rollback();
		            e.printStackTrace();
		        }
		        return false;
		}

		@Override
		public boolean update(Benhnhan benhnhan) {
			Session session = HibernateUtils.getSessionFactory().getCurrentSession();
	        try {
	            session.beginTransaction();
	            session.update(benhnhan);
	            session.getTransaction().commit();
	            return true;
	        } catch (Exception e) {
	            session.getTransaction().rollback();
	            e.printStackTrace();
	        }
	        return false;
		}

		@Override
		public boolean delete(String mabn) {
			Session session = HibernateUtils.getSessionFactory().getCurrentSession();
	        try {
	            session.beginTransaction();
	            session.delete(mabn);
	            session.getTransaction().commit();
	            return true;
	        } catch (Exception e) {
	            session.getTransaction().rollback();
	            e.printStackTrace();
	        }
	        return false;
		}

		@Override
		public Benhnhan getBenhnhanById(String mabn) {
			Session session = HibernateUtils.getSessionFactory().getCurrentSession();
	        session.beginTransaction();
	        Benhnhan benhnhan = (Benhnhan) session.get(Benhnhan.class, mabn);
	        session.close();
	        return benhnhan;
		}

//		@Override
//		public List<Benhnhan> searchByName(String tenbn) {
//			  List<Benhnhan> list = null;
//		        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//		        try {
//		            String sql = "FROM Salary s WHERE s.nameEmployee LIKE '%" + name + "%'";
//		            session.beginTransaction();
//		            Query query = session.createQuery(sql);
//		            list = query.list();
//		        } catch (Exception e) {
//		            e.printStackTrace();
//		        } finally {
//		            session.close();
//		        }
//		        return list;
//		    }

	}
