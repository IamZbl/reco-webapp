package com.reco.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.reco.dao.ProductDao;
import com.reco.model.Product;

public class ProductDaoImpl implements ProductDao {
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session openSession() {
		Session session = sessionFactory.getCurrentSession();
		if (session != null) {
			return session;
		}
		return sessionFactory.openSession();
	}

	public void save(Product product) {
		System.out.println("save ");
		try {

			openSession().save(product);

		} finally {
			openSession().flush();
		}

	}

	public void update(Product product) {
		System.out.println("update");
		try {

			openSession().update(product);

		} finally {
			openSession().flush();
		}

	}

	public void delete(Product product) {
		openSession().delete(product);
	}

	public Product findByProductCode(String productCode) {

		Query query = openSession().createQuery(
				"from Product where productCode = :code ");
		query.setParameter("code", productCode);
		return (Product) query.list().get(0);

	}

	public List<Product> findByProductRecommendation(Float milage,
			Integer year, String category, Float engine) {
		System.out.println("findByProductRecommendation started");
		try {
			Query query = openSession()
					.createQuery(
							"from Product where (engine >= :engine or year >=:year  or milage >= :milage) and category = :category");
			query.setParameter("engine", engine);
			query.setParameter("milage", milage);
			query.setParameter("year", year);
			query.setParameter("category", category);
			System.out.println("findByProductRecommendation done");
			return (List<Product>) query.list();
		} finally {
			openSession().flush();
		}

	}

	public List<Product> fetchAllProducts() {
		System.out.println("fetchAllProducts started");
		try {
			Query query = openSession().createQuery("from Product");

			System.out.println("fetchAllProducts done");
			return (List<Product>) query.list();
		} finally {
			openSession().flush();
		}
	}

}
