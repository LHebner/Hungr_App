package com.techelevator.dao;

import com.techelevator.model.Invite;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InviteJDBCDAO implements InviteDAO {

    @Override
    public List<Invite> getInvites(String attendeeId) {
        return null;
    }
}
