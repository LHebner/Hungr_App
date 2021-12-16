package com.techelevator.dao;

import com.techelevator.model.Invite;
import com.techelevator.model.User;
import com.techelevator.services.RestYelpService;

import java.util.List;

public interface InviteDAO {

    List<Invite> getInvites(String attendeeId);

    List<User> findAll();

    List<Invite> getAllInvites();

    void createInvite(Invite invite);

}
