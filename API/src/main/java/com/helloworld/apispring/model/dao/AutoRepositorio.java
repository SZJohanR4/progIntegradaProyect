/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.model.dao;

import com.helloworld.apispring.model.entity.Auto;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AutoRepositorio {
    
     @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public List<Auto> getAllAutos(){
       Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Auto.class);
//       criteria.add(Restrictions.lt("rank", 10));
//       criteria.add(Restrictions.eq("confederation", "UEFA"));
        return criteria.list();
    } 

    public long crearAuto(Auto carroNew) {
      getSessionFactory().getCurrentSession().save(carroNew);
              return carroNew.getIdAuto();
    }
    
}
