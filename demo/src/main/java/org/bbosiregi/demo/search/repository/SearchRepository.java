package org.bbosiregi.demo.search.repository;

import org.bbosiregi.demo.search.entity.Search;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchRepository extends JpaRepository<Search, Long> {
}
