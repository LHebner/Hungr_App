package com.techelevator.controller;

import java.util.ArrayList;
import java.util.List;
import java.security.Principal;

import com.techelevator.model.Invite;
import com.techelevator.model.User;
import com.techelevator.security.jwt.TokenProvider;
import com.techelevator.services.RestYelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.InviteDAO;
import com.techelevator.dao.UserDAO;
import com.techelevator.model.Restaurant;

import javax.validation.Valid;


@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class InviteController {

	private final TokenProvider tokenProvider;
	private InviteDAO inviteDAO;
	@Autowired
	private UserDAO userDAO;
	
	public InviteController(TokenProvider tokenProvider, InviteDAO inviteDAO, UserDAO userDAO) {
		this.tokenProvider = tokenProvider;
		this.inviteDAO = inviteDAO;
		this.userDAO = userDAO;
    }

	@RequestMapping(path = "/users", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		List<User> users = inviteDAO.findAll();
		return users;
	}

	@RequestMapping(path = "/users/{id}", method = RequestMethod.GET)
	public User getUserById(Long id) {
		return userDAO.getUserById(id);
	}

	@RequestMapping(path = "/invites", method = RequestMethod.GET)
	public List<Invite> getAllInvites() {
		List<Invite> invites = inviteDAO.getAllInvites();
		return invites;
	}

	@RequestMapping(path = "/invites", method = RequestMethod.POST)
	public void createInvite(@RequestBody Invite invite) {
		inviteDAO.createInvite(invite);
	}
}