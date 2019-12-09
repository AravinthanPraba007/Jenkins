package com.mentor.authentication.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentor.authentication.exception.UserAlreadyExistsException;
import com.mentor.authentication.model.Mentor;
import com.mentor.authentication.model.MentorSkills;
import com.mentor.authentication.model.Technology;
import com.mentor.authentication.repository.MentorRepository;
import com.mentor.authentication.repository.MentorSkillsRepository;
import com.mentor.authentication.repository.TechnologyRepository;

@Service
public class UserService {
	
	@Autowired
	TechnologyRepository technologyRepository;
	@Autowired
	MentorRepository mentorRepository;
	@Autowired
	MentorSkillsRepository mentorSkillsRepository;
	
	public void addSkills(MentorSkills mentorSkills,String mentorName,String skillName) throws UserAlreadyExistsException {
		/*LOGGER.info("Start of signupMentor");
		System.err.println("signed Mentor" + signedMentor);
		//Mentor mentorCheck = mentorRepository.findByUserID(signedMentor.getUserID());
*/		Technology skills=technologyRepository.findBySkillName(skillName);
		Mentor mentor=mentorRepository.findByUserID(mentorName);
//		MentorSkills mskills=new MentorSkills();
		mentorSkills.setMentorId(mentor);
		mentorSkills.setSkillId(skills);
		Set<MentorSkills> list=mentor.getMentorSkillsList();
		System.err.println("***"+list);
		list.add(mentorSkills);
		System.err.println("***"+list);
		mentor.setMentorSkillList(list);
		 mentorRepository.save(mentor);
		 mentorSkillsRepository.save(mentorSkills);

		}
		

}
