package ru.netology.homework8_3.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.stream.Collectors;

@org.springframework.stereotype.Repository
public class Repository {

    private static final String SCRIPT_FILE = "query.sql";

    private final String query;

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public Repository() {
        this.query = read(SCRIPT_FILE);
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getProductName(String name) {
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(query, Map.of("NameCustomer", name));
        StringBuilder sb = new StringBuilder();
        while (sqlRowSet.next()) {
            if (sb.length() > 0) sb.append(", ");
            sb.append(sqlRowSet.getString("product_name"));
        }
        return sb.toString();
    }
}
