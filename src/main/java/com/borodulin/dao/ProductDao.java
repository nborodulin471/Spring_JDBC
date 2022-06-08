package com.borodulin.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductDao {
    private static final String SCRIPT_FILE_NAME = "get-product-name.sql";
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Optional<String> getProductName(String name) {
        try {
            return Optional.of(
                    namedParameterJdbcTemplate.queryForObject(
                            UtilDao.read(SCRIPT_FILE_NAME), Map.of("name", name), String.class));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}
