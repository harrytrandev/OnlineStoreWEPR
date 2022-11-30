package com.onlinestorewepr.dao;

import com.onlinestorewepr.entity.Category;
import com.onlinestorewepr.entity.Product;
import com.onlinestorewepr.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class ProductDAO {
   public void insert(Product product) {
      Transaction transaction = null;
      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
         transaction = session.beginTransaction();

         session.save(product);

         transaction.commit();
      } catch (Exception e) {
         e.printStackTrace();
         if (transaction != null) {
            transaction.rollback();
         }
      }
   }

   public void update(Product product) {
      Transaction transaction = null;
      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
         transaction = session.beginTransaction();

         session.update(product);

         transaction.commit();
      } catch (Exception e) {
         e.printStackTrace();
         if (transaction != null) {
            transaction.rollback();
         }
      }
   }

   public void delete(int id) {
      Transaction transaction = null;
      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
         transaction = session.beginTransaction();

         Product product = session.get(Product.class, id);
         if (product != null) {
            session.delete(product);
         }

         transaction.commit();
      } catch (Exception e) {
         e.printStackTrace();
         if (transaction != null) {
            transaction.rollback();
         }
      }
   }

   public List<Product> getAll() {
      List<Product> products = null;
      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
         CriteriaBuilder builder = session.getCriteriaBuilder();
         CriteriaQuery<Product> criteriaQuery = builder.createQuery(Product.class);
         criteriaQuery.from(Product.class);
         products = session.createQuery(criteriaQuery).getResultList();
      } catch (Exception e) {
         e.printStackTrace();
      }
      return products;
   }

   public Product get(int id) {
      Product product = null;
      try (Session session = HibernateUtil.getSessionFactory().openSession()) {

         product = session.get(Product.class, id);

      } catch (Exception e) {
         e.printStackTrace();
      }
      return product;
   }

   public Product findByName(String name) {
      Product product = null;

      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
         String HQL = "SELECT c FROM Product c WHERE c.name = :name";
         Query query = session.createQuery(HQL);
         query.setParameter("name", name);
         List<Product> products = query.getResultList();
         if (!products.isEmpty()) {
            product = products.get(0);
         }
      } catch (Exception e) {
         e.printStackTrace();
      }

      return product;
   }
//Lấy tất cả sản phẩm có cùng ID category
    public List<Product> getbyCategory(int CategoryID) {
      List<Product> products = null;

      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
         String HQL = "SELECT c FROM Product c WHERE category.id = :CategoryID";
         Query query = session.createQuery(HQL);
         query.setParameter("CategoryID", CategoryID);
         products = query.getResultList();

         /*products = query.setMaxResults(1).getResultList();*/

      } catch (Exception e) {
         e.printStackTrace();
      }

      return products;
   }
  /* public List<Product> getbyCategory(int[] CategoryID) {
      List<Product> products = null;

      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
         String HQL = "SELECT c FROM Product c WHERE category.id = :CategoryID";
         Query query = session.createQuery(HQL);
         for (int i = 0;i< CategoryID.length;i++){
            query.setParameter("CategoryID", CategoryID[i]);
            HQL = HQL + "or category.id = :CategoryID";
         }

         products = query.getResultList();
*//*
         products = query.setMaxResults(1).getResultList();
*//*
      } catch (Exception e) {
         e.printStackTrace();
      }

      return products;
   }*/
   //Lấy tất cả sản phẩm có cùng brand
   public List<Product> getbyBrand(String brand) {
      List<Product> products = null;

      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
         String HQL = "SELECT c FROM Product c WHERE c.brand = :brand";
         Query query = session.createQuery(HQL);
         query.setParameter("brand", brand);
         products = query.getResultList();
/*
         products = query.setMaxResults(1).getResultList();
*/
      } catch (Exception e) {
         e.printStackTrace();
      }

      return products;
   }
/*lấy các brand*/
   public List<String> getBrand() {
      List<Product> products = null;
      List<String> brand = null;
      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
         String HQL = "select distinct c.brand from Product c";
         Query query = session.createQuery(HQL);
         brand = query.getResultList();
/*
         products = query.setMaxResults(1).getResultList();
*/
      } catch (Exception e) {
         e.printStackTrace();
      }

      return brand;
   }
   /*lấy các size*/
   public List<String> getSize() {
      List<Product> products = null;
      List<String> size = null;
      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
         String HQL = "select distinct c.size from Product c";
         Query query = session.createQuery(HQL);
         size = query.getResultList();
/*
         products = query.setMaxResults(1).getResultList();
*/
      } catch (Exception e) {
         e.printStackTrace();
      }

      return size;
   }
   /*Lọc sản phẩm theo tên*/
   public List<Product> searchByName(String txtSearch) {
      List<Product> products = null;
      System.out.println(txtSearch);
      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
         String HQL = "SELECT c FROM Product c WHERE c.name LIKE :txtSearch";
         Query query = session.createQuery(HQL);
         query.setParameter("txtSearch", "%"+txtSearch+"%");
         products = query.getResultList();
         System.out.println(products);
/*
         products = query.setMaxResults(1).getResultList();
*/
      } catch (Exception e) {
         e.printStackTrace();
      }

      return products;
   }
   public static void main(String[] args) {
      ProductDAO donHangDAO = new ProductDAO();
      List<Product> products = donHangDAO.getbyCategory(1);
      for (Product p : products) {
         System.out.println(p.getName());
      }
   }

}
