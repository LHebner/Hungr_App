package com.techelevator.dao;

import com.techelevator.model.Restaurant;
import com.techelevator.services.RestYelpService;
import com.techelevator.services.YelpDAO;
import com.techelevator.services.YelpService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


@Component
@CrossOrigin
public class RestaurantJDBCDAO  {

    private final String BASE_URL = "https://api.yelp.com/v3/";
//    private final String TOKEN;

    private JdbcTemplate jdbcTemplate;

//    public YelpJDBCDAO(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }



//    @Override
//    public RestYelpService addRestaurantToList(String show) {
//        String sql = "INSERT INTO anime (title) VALUES (?) returning title_id" ;
//        int titleId = jdbcTemplate.queryForObject(sql, int.class, show);
//        return new RestYelpService(, titleId);
//    }
}
