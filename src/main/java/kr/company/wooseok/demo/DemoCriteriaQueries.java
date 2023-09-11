package kr.company.wooseok.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class DemoCriteriaQueries {
    @Autowired
    EntityManager em;

    public List<Demo> getListDemoBySearch(Demo search) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Demo> cq = cb.createQuery(Demo.class);

        Root<Demo> demo = cq.from(Demo.class);
        if (search.getKeyWord() != null && !search.getKeyWord().equals("")) {
            if (search.getSearchItem().equals("name")) {
                Predicate namePredicate = cb.like(demo.get("name"), "%" + search.getKeyWord() + "%");
                cq.where(namePredicate);
            } else if (search.getSearchItem().equals("status")) {
                Predicate statusPredicate = cb.equal(demo.get("status"), search.isStatus());
                cq.where(statusPredicate);
            } else {
                Predicate namePredicate = cb.like(demo.get("name"), "%" + search.getKeyWord() + "%");
                /*Predicate statusPredicate = cb.equal(demo.get("status"), search.isStatus());
                Predicate finalPredicate = cb.or(namePredicate, statusPredicate);
                cq.where(finalPredicate);*/
                cq.where(namePredicate);
            }
        }
        if (search.getSortBy() != null && !search.getSortBy().equals("")) {
            if (search.getSortType().equals("ASC")) {
                cq.orderBy(cb.asc(demo.get(search.getSortBy())));
            } else {
                cq.orderBy(cb.desc(demo.get(search.getSortBy())));
            }
        }
        int limit = (search.getPage() - 1) * search.getSize();
        List<Demo> query = em
                .createQuery(cq)
                .setMaxResults(search.getSize())
                .setFirstResult(limit)
                .getResultList();
        return query;
    }

    /*public CriteriaQuery<Demo> commonSearch(Demo search) {
        CriteriaQuery<Demo> cq = cb.createQuery(Demo.class);

    }*/

    public int countDemo(Demo search) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Demo> demo = cq.from(Demo.class);
        if (search.getKeyWord() != null && !search.getKeyWord().equals("")) {
            if (search.getSearchItem().equals("name")) {
                Predicate namePredicate = cb.like(demo.get("name"), "%" + search.getKeyWord() + "%");
                cq.where(namePredicate);
            } else if (search.getSearchItem().equals("status")) {
                Predicate statusPredicate = cb.equal(demo.get("status"), search.isStatus());
                cq.where(statusPredicate);
            } else {
                Predicate namePredicate = cb.like(demo.get("name"), "%" + search.getKeyWord() + "%");
                /*Predicate statusPredicate = cb.equal(demo.get("status"), search.isStatus());
                Predicate finalPredicate = cb.or(namePredicate, statusPredicate);
                cq.where(finalPredicate);*/
                cq.where(namePredicate);
            }
        }
        cq.select(cb.count(demo));
        Long result = em.createQuery(cq).getSingleResult();
        int total = result.intValue();
        return total;
    }
}
