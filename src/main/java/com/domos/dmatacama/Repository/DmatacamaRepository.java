package com.domos.dmatacama.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.domos.dmatacama.Model.DmatacamaModel;

public interface DmatacamaRepository extends JpaRepository<DmatacamaModel, Long> {
}
