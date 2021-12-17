package com.techelevator.dao;

import com.techelevator.model.Invite;
import com.techelevator.model.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class InviteJDBCDAO implements InviteDAO {

    private JdbcTemplate jdbcTemplate;

    public InviteJDBCDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Invite> getInvites(String attendeeId) {
        List<Invite> invites = new ArrayList<>();
        return invites;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            User user = mapRowToUser(results);
            users.add(user);
        }
        return users;
    }

    @Override
    public void createInvite(Invite invite) {
        String sql = "INSERT INTO invite (host_id, host_name, invitee_id, restaurant_id, restaurant_name, dinner_date)"
                + " VALUES (?,?,?,?,?,?)";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, invite.getHostId(), invite.getHostName(),
                    invite.getAttendeeId(), invite.getRestaurantId(), invite.getRestaurantName(), invite.getDate());
        } catch (Exception exception) {
            System.out.println("Error creating invite: "+ exception);
        }
    }

    @Override
    public List<Invite> getAllInvites() {
        List<Invite> invites = new ArrayList<>();
        String sql = "SELECT * FROM invite";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Invite invite = mapRowToInvite(results);
            invites.add(invite);
        }
        return invites;
    }

    private HttpEntity<String> makeAuthEntity(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return entity;
    }

    private User mapRowToUser(SqlRowSet rs) {
        User user = new User();
        user.setId(rs.getLong("user_id"));
        user.setUsername(rs.getString("username"));
        return user;
    }

    private Invite mapRowToInvite(SqlRowSet rs) {
        Invite invite = new Invite();
        invite.setAttendeeId(rs.getInt("invitee_id"));
        invite.setRestaurantId(rs.getString("restaurant_id"));
        invite.setRestaurantName(rs.getString("restaurant_name"));
        invite.setHostName(rs.getString("host_name"));
        invite.setDate(rs.getDate("dinner_date"));
        invite.setId(rs.getLong("invite_id"));
        invite.setHostId(rs.getInt("host_id"));
        return invite;
    }
}
