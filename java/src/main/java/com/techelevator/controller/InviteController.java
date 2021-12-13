package com.techelevator.controller;

import java.util.List;
import java.security.Principal;

import com.techelevator.services.RestYelpService;
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

	private InviteDAO inviteDAO;
	
	public InviteController(InviteDAO inviteDAO) {
		this.inviteDAO = inviteDAO;
    }



}