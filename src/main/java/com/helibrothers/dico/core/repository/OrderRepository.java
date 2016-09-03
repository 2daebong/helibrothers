package com.helibrothers.dico.core.repository;

import com.helibrothers.dico.domain.Order;
import com.helibrothers.dico.domain.OrderSearch;
import com.helibrothers.dico.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LeeDaebeom-Mac on 2016. 8. 31..
 */
@Repository
public class OrderRepository {

    @PersistenceContext
    EntityManager em;

    public void save(Order order) {
        em.persist(order);
    }

    public Order findOne(Long id) {
        return em.find(Order.class, id);
    }

    public List<Order> findAll(OrderSearch orderSearch) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Order> cq = cb.createQuery(Order.class);
        Root<Order> o = cq.from(Order.class);

        List<Predicate> criteria = new ArrayList<Predicate>();

        // 주문 상태 검색
        if(orderSearch.getOrderStatusCd() != null) {
            Predicate status = cb.equal(o.get("status"), orderSearch.getOrderStatusCd());
            criteria.add(status);
        }

        // 회원 이름 검색
        if (StringUtils.hasText(orderSearch.getUserName())) {
            // 회원과 조인
            Join<Order, User> m = o.join("user", JoinType.INNER);
            Predicate name = cb.like(m.<String>get("name"), "%" + orderSearch.getUserName() + "%");
            criteria.add(name);
        }
        cq.where(cb.and(criteria.toArray(new Predicate[criteria.size()])));
        TypedQuery<Order> query = em.createQuery(cq).setMaxResults(1000);
        return query.getResultList();
    }
}
