package org.codejudge.sb.repository;

import org.codejudge.sb.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDriverRepository extends JpaRepository<Driver, Long> {
}
