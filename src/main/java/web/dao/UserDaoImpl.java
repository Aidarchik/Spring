
package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session session() {
        return sessionFactory.getCurrentSession();
    }

    ;

    public void add(User user) {
        session().save(user);
    }


    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = session().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public void create(User user) {
        session().save(user);
    }

    @Override
    public User read(Long id) {
        return session().get(User.class, id);
    }

    @Override
    public void update(User user) {
        session().update(user);
    }

    @Override
    public void delete(Long id) {
        User user = session().get(User.class, id);
        if (user != null) {
            session().delete(user);
        }
    }

    @Override
    public List<User> findAll() {
        return session()
                .createQuery("from User", User.class)
                .list();
    }
}
