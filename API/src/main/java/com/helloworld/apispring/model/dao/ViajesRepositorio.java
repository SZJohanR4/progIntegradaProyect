/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.model.dao;


import com.helloworld.apispring.model.entity.Usuario;
import java.util.Date;
import com.helloworld.apispring.model.entity.Viajes;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author eser
 */
@Repository
@Transactional
public class ViajesRepositorio {
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public List<Viajes> getAllViajes(){
       Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Viajes.class);
//       criteria.add(Restrictions.lt("rank", 10));
//       criteria.add(Restrictions.eq("confederation", "UEFA"));
        return criteria.list();
    }    
        
    public List<Viajes> viajeListFilters(){
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Viajes.class);
       criteria.add(Restrictions.eq("Fecha", "fecha de hoy"));

        return criteria.list();
    }
    
    public long crearViaje(Viajes viaje) {
      getSessionFactory().getCurrentSession().save(viaje);
              return viaje.getIdViajes();
    }
    
 public List<Viajes> getViajeCriterios(String Origen,String Destino, Date fecha,String asientos) {
        Criteria cr = getSessionFactory().getCurrentSession().createCriteria(Viajes.class);
        cr.add(Restrictions.eq("Origen", Origen));
        cr.add(Restrictions.eq("Destino", Destino));
        cr.add(Restrictions.eq("Fecha", fecha));
        cr.add(Restrictions.eq("NroAsientosViaje", asientos));
        return cr.list();

    }
 
  public List<Viajes> getViajeCriterios_auto_user(Integer user,Integer auto, Integer viaje) {
        Criteria cr = getSessionFactory().getCurrentSession().createCriteria(Viajes.class);
        cr.add(Restrictions.eq("IdViajes", viaje));
        cr.add(Restrictions.eq("Usuario_idUsuario", user));
        cr.add(Restrictions.eq("Auto_idAuto", auto));

        return cr.list();

    }
    
}
