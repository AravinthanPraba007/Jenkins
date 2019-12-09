package com.mentor.authentication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mentor.authentication.model.MentorSkills;

@Repository
public interface MentorSkillsRepository extends JpaRepository<MentorSkills, Long> {
	
	@Query("FROM MentorSkills ms WHERE ms.mentorId=?1")
	public List<MentorSkills> getBySkillID(Long id);
}
