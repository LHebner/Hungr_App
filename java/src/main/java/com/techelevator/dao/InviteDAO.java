package com.techelevator.dao;

import com.techelevator.model.Invite;
import com.techelevator.services.RestYelpService;

import java.util.List;

public interface InviteDAO {

    List<Invite> getInvites(String attendeeId);



}
