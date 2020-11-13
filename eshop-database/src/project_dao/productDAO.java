package project_dao;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import project_entity.Product;
import util.HibernateUtil;

public class productDAO {
    
    public boolean addProduct(Product item) {
		Transaction transaction = null;
                Product check = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
                        
			transaction = session.beginTransaction();
                        
                        check = session.get(Product.class, item.getBarcode());
                        if(check != null){
                            return(false);
                        }
                        
			session.save(item);
			transaction.commit();
                        
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
                        return(false);
		}
                return(true);
	}
    
        public List<Product> getAllProducts() {

		Transaction transaction = null;
		List<Product> listOfProducts = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			transaction = session.beginTransaction();
			listOfProducts = session.createQuery("from Product").getResultList();
			transaction.commit();
                        
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfProducts;
	}
}
