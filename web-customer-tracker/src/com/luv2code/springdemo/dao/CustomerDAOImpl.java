package com.luv2code.springdemo.dao;


import com.luv2code.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        Query<Customer> theQuerry = getSession().createQuery("from Customer order by lastName", Customer.class);

        return theQuerry.getResultList();
    }

    @Override
    public void saveCustomer(Customer customer) {
        getSession().saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        return getSession().get(Customer.class,id);
    }

    @Override
    public void deleteCustomer(int id) {
        Query query = getSession().createQuery("delete from Customer where id=:customerId");
        query.setParameter("customerId", id);
        query.executeUpdate();
    }

    @Override
    public List<Customer> searchCustomers(String searchName) {

        Query query = null;
        if (searchName != null && searchName.trim().length()>0){
            query = getSession().createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName",
                    Customer.class);
            query.setParameter("theName", "%" + searchName.toLowerCase() + "%");
        }else {
            query = getSession().createQuery("from Customer", Customer.class);
        }

        return (List<Customer>) query.getResultList();
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}
