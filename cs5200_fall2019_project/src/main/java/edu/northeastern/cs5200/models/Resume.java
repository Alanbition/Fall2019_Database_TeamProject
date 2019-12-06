package edu.northeastern.cs5200.models;

import java.util.List;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
@Entity
public class Resume {
	private String skill;
	@OneToMany(mappedBy="thisResumeEducationBackground", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<EducationBackground> resumeEducationBackgrounds;
	//For Education_Backgroud
	public void resumeEducationBackgrounds(EducationBackground eb) {
		this.resumeEducationBackgrounds.add(eb);
		if (eb.getThisResumeEducationBackground() != this)
			eb.setThisResumeEducationBackground(this);
	}
	
	public List<EducationBackground> getResumeEducationBackgrounds(){
		return resumeEducationBackgrounds;
	}
	
	public void setResumeEducationBackgrounds(List<EducationBackground> resumeEducationBackgrounds) {
		this.resumeEducationBackgrounds = resumeEducationBackgrounds;
	}
	//
	//For Project
	@OneToMany(mappedBy="thisResumeProject", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Project> resumeProject;	
	public void resumeProject(Project pj) {
		this.resumeProject.add(pj);
		if (pj.getThisResumeProject() != this)
			pj.setThisResumeProject(this);
	}
	
	public List<Project> getResumeProject(){
		return resumeProject;
	}
	
	public void setResumeProject (List<Project> resumeProject) {
		this.resumeProject = resumeProject;
	}
	//	

	//For Industrial Experience

	@OneToMany(mappedBy="thisResumeIndustrialExperience", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<IndustrialExperience> resumeIndustrialExperiences;

	public void resumeIndustrialExperiences(IndustrialExperience ie) {
		this.resumeIndustrialExperiences.add(ie);
		if (ie.getThisResumeIndustrialExperience() != this)
			ie.setThisResumeIndustrialExperience(this);
	}
	
	public List<IndustrialExperience> getResumeIndustrialExperiences(){
		return resumeIndustrialExperiences;
	}
	
	public void setResumeIndustrialExperiences (List<IndustrialExperience> resumeIndustrialExperiences) {
		this.resumeIndustrialExperiences = resumeIndustrialExperiences;
	}

	//For Research Experience

	@OneToMany(mappedBy="thisResumeResearchExperience", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<ResearchExperience> resumeResearchExperiences;	
	
	public void resumeResearchExperiences(ResearchExperience re) {
		this.resumeResearchExperiences.add(re);
		if (re.getThisResumeResearchExperience() != this)
			re.setThisResumeResearchExperience(this);
	}
	
	public List<ResearchExperience> getResumeResearchExperiences(){
		return resumeResearchExperiences;
	}
	
	public void setResumeResearchExperiences(List<ResearchExperience> resumeResearchExperiences) {
		this.resumeResearchExperiences = resumeResearchExperiences;
	}
	// Many to one for student
	@ManyToOne()
	private Student thisStudentResume;
	public Student getThisStudentResume() {
		return thisStudentResume;
	}
	
	public void setThisStudentResume(Student thisStudentResume) {
		this.thisStudentResume =  thisStudentResume;
		if (!thisStudentResume.getResumesForThisStudent().contains(this)) {
			thisStudentResume.getResumesForThisStudent().add(this);
		}
	}
	

	//Con
	public Resume() {}
	
	public Resume(String skill) {
		this.skill = skill;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}


}
