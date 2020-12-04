package kr.ac.hansung.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Course {
	
	@NotNull(message="The year cannot be empty")
	private int year;

	@Range(min=1, max=2, message="The semester must be between 1 ~ 2")
	@NotNull(message="The semester cannot be empty")
	private int semester;
	
	@Length(max=30, message="The title must be 30 characters or less")
	@NotEmpty(message="The title cannot be empty")
	private String title;
	
	@Length(max=5, message="The classification must be 5 characters or less")
	@NotEmpty(message="The classification cannot be empty")
	private String classification;
	
	@Length(max=15, message="The professor must be 15 characters or less")
	@NotEmpty(message="The professor cannot be empty")
	private String professor;
	
	@Range(min=1, max=3, message="The credit must be between 1 ~ 3")
	@NotNull(message="The credit cannot be empty")
	private int credit;
}