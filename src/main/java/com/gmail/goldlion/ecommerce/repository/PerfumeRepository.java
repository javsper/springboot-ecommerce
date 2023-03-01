package com.gmail.goldlion.ecommerce.repository;

import com.gmail.goldlion.ecommerce.domain.Perfume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerfumeRepository extends JpaRepository<Perfume, Long> {

    List<Perfume> findByPerfumerInAndPerfumeGenderInOrderByPriceDesc(List<String> perfumers, List<String> genders);

    List<Perfume> findByPerfumerInOrPerfumeGenderInOrderByPriceDesc(List<String> perfumers, List<String> genders);

    List<Perfume> findByPriceBetweenOrderByPriceDesc(Integer startingPrice, Integer endingPrice);

    List<Perfume> findByPerfumerOrderByPriceDesc(String perfumer);

    List<Perfume> findByPerfumeGenderOrderByPriceDesc(String perfumeGender);
}
