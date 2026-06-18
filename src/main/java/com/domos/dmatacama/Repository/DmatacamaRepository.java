package com.domos.dmatacama.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.domos.dmatacama.Model.DmatacamaModel;

@Repository
public interface DmatacamaRepository extends JpaRepository<DmatacamaModel, Long> {
}
