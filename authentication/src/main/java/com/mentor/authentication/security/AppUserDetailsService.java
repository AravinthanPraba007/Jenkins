package com.mentor.authentication.security;


import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mentor.authentication.exception.UserAlreadyExistsException;
import com.mentor.authentication.model.Mentor;
import com.mentor.authentication.model.Role;
import com.mentor.authentication.model.Trainee;
import com.mentor.authentication.model.User;
import com.mentor.authentication.repository.MentorRepository;
import com.mentor.authentication.repository.MentorSkillsRepository;
import com.mentor.authentication.repository.RoleRepository;
import com.mentor.authentication.repository.TraineeRepository;
import com.mentor.authentication.repository.UserRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	MentorRepository mentorRepository;
	
	@Autowired
	TraineeRepository traineeRepository;

	@Autowired
	RoleRepository roleRepository;

	
	@Autowired
	MentorSkillsRepository mentorSkillsRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(AppUserDetailsService.class);

	public AppUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Bean
	public PasswordEncoder encodePassword() {
		LOGGER.info("Start");
		return new BCryptPasswordEncoder();
	}

	/*@Override
	public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		LOGGER.info("Start of loadUserByUsername");
		LOGGER.debug("UserRepository:{}", userRepository);
		userRepository.findByUserID(user);
		LOGGER.debug("User:{}", user);

		if (user == null) {
			throw new UsernameNotFoundException("Username not found");
		}

		else {
			AppUser appUser = new AppUser(userRepository.findByUserID(user));
			return appUser;
		}
	}*/
	@Override
	public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		LOGGER.info("Start of loadUserByUsername");
		LOGGER.debug("UserRepository:{}", userRepository);
		userRepository.findByUserID(user);
		LOGGER.debug("User:{}", user);

		if (user == null) {
			throw new UsernameNotFoundException("Username not found");
		}

		else {
			AppUser appUser = new AppUser(userRepository.findByUserID(user));
			return appUser;
		}
	}

	/*public String signup(User signedUser) throws UserAlreadyExistsException {
		LOGGER.info("Start of signup");
		LOGGER.debug("signed user" + signedUser);
		User userCheck = userRepository.findByName(signedUser.getUsername());
		if (userCheck == null) {
			User user = new User();
			user.setUsername(signedUser.getUsername());
			user.setFirstname(signedUser.getFirstname());
			user.setLastname(signedUser.getLastname());
			user.setAge(signedUser.getAge());
			user.setGender(signedUser.getGender());
			user.setBloodgroup(signedUser.getBloodgroup());
			user.setContactNo(signedUser.getContactNo());
			user.setEmail(signedUser.getEmail());
			user.setWeight(signedUser.getWeight());
			user.setPassword(encodePassword().encode(signedUser.getPassword()));
			user.setArea(signedUser.getArea());
			user.setState(signedUser.getState());
			user.setPincode(signedUser.getPincode());
			Role role = roleRepository.findByName("USER");
			Set<Role> roles = new HashSet<>();
			roles.add(role);
			user.setRoleList(roles);
			userRepository.save(user);
			return "true";

		} else {
			return "false";

		}

	}*/
	
	public String signupMentor(Mentor signedMentor) throws UserAlreadyExistsException {
		LOGGER.info("Start of signupTrainee");
		System.err.println("signed Trainee" + signedMentor);
		Mentor mentorCheck = mentorRepository.findByUserID(signedMentor.getUserID());
		if (mentorCheck == null) {
			signedMentor.setPassword(encodePassword().encode(signedMentor.getPassword()));
//			mentorRepository.save(signedMentor);
			mentorRepository.save(signedMentor);
			User user = new User();
			user.setUserID(signedMentor.getUserID());
			user.setPassword(encodePassword().encode(signedMentor.getPassword()));
			Role role = roleRepository.findByName("MENTOR");
			Set<Role> roles = new HashSet<>();
			roles.add(role);
			user.setRoleList(roles);
			userRepository.save(user);
			return "true";

		} else {
			return "false";

		}
	}
	
	public String signupTrainee(Trainee signedTrainee) throws UserAlreadyExistsException {
		LOGGER.info("Start of signupTrainee");
		System.err.println("signed Trainee" + signedTrainee);
		Trainee traineeCheck = traineeRepository.findByUserID(signedTrainee.getUserID());
		if (traineeCheck == null) {
			signedTrainee.setPassword(encodePassword().encode(signedTrainee.getPassword()));
//			mentorRepository.save(signedMentor);
			traineeRepository.save(signedTrainee);
			User user = new User();
			user.setUserID(signedTrainee.getUserID());
			user.setPassword(encodePassword().encode(signedTrainee.getPassword()));
			Role role = roleRepository.findByName("TRAINEE");
			Set<Role> roles = new HashSet<>();
			roles.add(role);
			user.setRoleList(roles);
			userRepository.save(user);
			return "true";

		} else {
			return "false";

		}

}
}








/*public String signupMentor(Mentor signedMentor,Long skillId) throws UserAlreadyExistsException {
	LOGGER.info("Start of signupMentor");
	System.err.println("signed Mentor" + signedMentor);
	Mentor mentorCheck = mentorRepository.findByUserID(signedMentor.getUserID());
	Skills skills=skillRepository.findBySkillID(skillId);
	if(mentorCheck == null) {
		signedMentor.setPassword(encodePassword().encode(signedMentor.getPassword()));
		mentorRepository.save(signedMentor);
		Mentor mentor=mentorRepository.findByMentorId(signedMentor.getId());
	MentorSkills mskills=new MentorSkills();
	mskills.setMentorId(mentor);
	mskills.setSkillId(skills);
	Set<MentorSkills> list=mentor.getMentorSkillsList();
	System.err.println("***"+list);
	list.add(mskills);
	System.err.println("***"+list);
	mentor.setMentorSkillList(list);
	 mentorRepository.save(mentor);
	 mentorSkillsRepository.save(mskills);
	
		return "true";
	}
	else {
		return "false";

	}
}*/
