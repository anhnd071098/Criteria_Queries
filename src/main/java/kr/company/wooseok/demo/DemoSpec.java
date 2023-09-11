package kr.company.wooseok.demo;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;

public class DemoSpec {
    public static Specification<Demo> getEmployeesByNameSpec(String name) {
        return (root, query, criteriaBuilder) -> {
            Predicate equalPredicate = criteriaBuilder.equal(root.get(Demo_.name), name);
            return equalPredicate;
        };
    }

    public static Specification<Demo> getEmployeesByStatusSpec(Boolean status) {
        return (root, query, criteriaBuilder) -> {
            Predicate equalPredicate = criteriaBuilder.equal(root.get(Demo_.status), status);
            return equalPredicate;
        };
    }
}
