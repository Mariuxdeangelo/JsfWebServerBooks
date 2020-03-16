package Books;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
@Transactional
public class CategoryService {
    @PersistenceContext(unitName = "BooksPU")
    private EntityManager _em;

    protected EntityManager getEntityManager() {
        return _em;
    }

    public Category create(Category entity) {
        getEntityManager().persist(entity);
        return entity;
    }

    public Category read(Object id) {
        return getEntityManager().find(Category.class, id);
    }

    public Category update (Category entity) {
        return getEntityManager().merge(entity);
    }

    public void delete  (Category entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    /**
     * Convenience method, to create or update automatically
     */
    public Category save(Category entity) {
return getEntityManager().merge(entity);
    }

    public List<Category> findAll() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Category.class));
        return getEntityManager().createQuery(cq).getResultList();
    }

}
