package edu.northeastern.cs5200.models;

import java.util.List;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
@Entity
public class Resume {
	@Column(name = "skill")
	private String skill;
	@Column(name = "GPA")
	private String GPA;
	@OneToMany(mappedBy="this_resume_education_background", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Education_Background> resume_education_backgrounds;
	
	@OneToMany(mappedBy="this_resume_project", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Projects> resume_projects;	
	
	@OneToMany(mappedBy="this_resume_industrial_experience", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Industrial_Experience> resume_industrial_experiences;
	
	@OneToMany(mappedBy="this_resume_research_experience", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Research_Experience> resume_research_experiences;	
	
	@ManyToOne()
	private Student thisStudent_resume;
	public Student getThisStudent_resume() {
		return thisStudent_resume;
	}
	
	public void setThisStudent_resume(Student thisStudent_resume) {
		this.thisStudent_resume =  thisStudent_resume;
		if (!thisStudent_resume.getResumes_for_thisStudent().contains(this)) {
			thisStudent_resume.getResumes_for_thisStudent().add(this);
		}
	}
	
	public Resume() {}
	
	public Resume(String skill, String GPA) {
		this.skill = skill;
		this.GPA = GPA;
	}	
	//For Education_Backgroudn
	public void resume_education_backgrounds(Education_Background eb) {
		this.resume_education_backgrounds.add(eb);
		if (eb.getThis_resume_education_background() != this)
			eb.setThis_resume_education_background(this);
	}
	
	public List<Education_Background> getResume_education_backgrounds(){
		return resume_education_backgrounds;
	}
	
	public void setResume_education_backgrounds(List<Education_Background> resume_education_backgrounds) {
		this.resume_education_backgrounds = resume_education_backgrounds;
	}
	
	//For Project
	public void resume_projects(Projects pj) {
		this.resume_projects.add(pj);
		if (pj.getThis_resume_project() != this)
			pj.setThis_resume_project(this);
	}
	
	public List<Projects> getResume_projects(){
		return resume_projects;
	}
	
	public void setResume_projects (List<Projects> resume_projects) {
		this.resume_projects = resume_projects;
	}
	
	//For Industrial Experience
	public void resume_industrial_experiences(Industrial_Experience ie) {
		this.resume_industrial_experiences.add(ie);
		if (ie.getThis_resume_industrial_experience() != this)
			ie.setThis_resume_industrial_experience(this);
	}
	
	public List<Industrial_Experience> getResume_industrial_experiences(){
		return resume_industrial_experiences;
	}
	
	public void setResume_industrial_experiences (List<Industrial_Experience> resume_industrial_experiences) {
		this.resume_industrial_experiences = resume_industrial_experiences;
	}	
	
	//For Research Experience
	public void resume_research_experiences(Research_Experience re) {
		this.resume_research_experiences.add(re);
		if (re.getThis_resume_research_experience() != this)
			re.setThis_resume_research_experience(this);
	}
	
	public List<Research_Experience> getResume_research_experiences(){
		return resume_research_experiences;
	}
	
	public void setResume_research_experiences(List<Research_Experience> resume_research_experiences) {
		this.resume_research_experiences = resume_research_experiences;
	}
}
