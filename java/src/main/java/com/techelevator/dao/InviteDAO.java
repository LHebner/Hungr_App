package com.techelevator.dao;

import com.techelevator.model.Invite;

import java.util.List;

public interface InviteDAO {

    List<Invite> getInvites(String attendeeId);

}
