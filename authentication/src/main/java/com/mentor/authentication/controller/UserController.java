package com.mentor.authentication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentor.authentication.exception.UserAlreadyExistsException;
import com.mentor.authentication.model.Mentor;
import com.mentor.authentication.model.MentorSkills;
import com.mentor.authentication.model.Trainee;
import com.mentor.authentication.repository.MentorRepository;
import com.mentor.authentication.repository.MentorSkillsRepository;
import com.mentor.authentication.repository.RoleRepository;
import com.mentor.authentication.repository.UserRepository;
import com.mentor.authentication.security.AppUserDetailsService;
import com.mentor.authentication.service.UserService;

@RequestMapping("/signup")
@RestController
public class UserController {

	@Autowired
	AppUserDetailsService appUserDetailsService;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	MentorRepository mentorRepository;
	
	@Autowired
	MentorSkillsRepository mentorSkillsRepository;
	
	@Autowired
	UserService userService;

	/*@PostMapping("")
	public String signup(@RequestBody User user) throws UserAlreadyExistsException {
		return appUserDetailsService.signup(user);

	}*/
	
	@PostMapping("/mentor")
	public String signupMentor(@RequestBody Mentor mentor) throws UserAlreadyExistsException {
		return appUserDetailsService.signupMentor(mentor);

	}
	
	@PostMapping("/trainee")
	public String signupTrainee(@RequestBody Trainee trainee) throws UserAlreadyExistsException {
		return appUserDetailsService.signupTrainee(trainee);

	}
	

	@PostMapping("/mentor/{name}/{skillName}")
	public void addSkills(@RequestBody MentorSkills mentorSkills,@PathVariable("name") String name,@PathVariable("skillName") String skillName) throws UserAlreadyExistsException {
		System.err.println("entereddddddddddd");
		System.err.println("mentorskills"+mentorSkills);
		
		System.err.println("name"+name);
		
		System.err.println("skillname"+skillName);
		
		
		userService.addSkills(mentorSkills,name,skillName);

	}
	
	@GetMapping("/mentors")
	public List<Mentor> getMentors() {
		return mentorRepository.findAll();
	}
	
	@GetMapping("/mentorskill")
	public List<MentorSkills> getMentorSkills() {
		return mentorSkillsRepository.findAll();
	}
}
