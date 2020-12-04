package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Course;

@Repository
public class CourseDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int getRowCount() {
		
		String sqlStatement = "select count(*) from courses";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
		
	}
	
	// query and return a single object
	public Course getCourse(int year, int semester, String title) {
		
		String sqlStatement = "select * from courses where year=? and semester=? and title=?";
		return jdbcTemplate.queryForObject(sqlStatement, new Object[] {year, semester, title},
				new RowMapper<Course>() {

			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Course course = new Course();
				
				course.setYear(rs.getInt("year"));
				course.setSemester(rs.getInt("semester"));
				course.setTitle(rs.getString("title"));
				course.setClassification(rs.getString("classification"));
				course.setProfessor(rs.getString("professor"));
				course.setCredit(rs.getInt("credit"));
				
				return course;
			}
			
		});
		
	}
	
	// query and return a multiple object
	// cRud method
	public List<Course> getCourses() {
		
		String sqlStatement = "select * from courses";
		return jdbcTemplate.query(sqlStatement, new RowMapper<Course>() {

			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Course course = new Course();
				
				course.setYear(rs.getInt("year"));
				course.setSemester(rs.getInt("semester"));
				course.setTitle(rs.getString("title"));
				course.setClassification(rs.getString("classification"));
				course.setProfessor(rs.getString("professor"));
				course.setCredit(rs.getInt("credit"));
				
				return course;
			}
			
		});
		
	}
	
	public List<Course> getCoursesBySemester(int year, int semester) {
		
		String sqlStatement = "select * from courses where year=? and semester=?";
		return jdbcTemplate.query(sqlStatement, new Object[] {year, semester},
				new RowMapper<Course>() {

			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Course course = new Course();
				
				course.setYear(rs.getInt("year"));
				course.setSemester(rs.getInt("semester"));
				course.setTitle(rs.getString("title"));
				course.setClassification(rs.getString("classification"));
				course.setProfessor(rs.getString("professor"));
				course.setCredit(rs.getInt("credit"));
				
				return course;
			}
			
		});
		
	}
	
	public List<Course> getCreditsBySemester(int year, int semester) {
		
		String sqlStatement = "select year, semester, sum(credit) creditSum "
				+ "from courses "
				+ "where year<" + year + " or (year="+ year + " and semester<=" + semester + ")"
				+" group by year, semester";
		return jdbcTemplate.query(sqlStatement, new RowMapper<Course>() {

			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Course course = new Course();
				
				course.setYear(rs.getInt("year"));
				course.setSemester(rs.getInt("semester"));
				course.setCredit(rs.getInt("creditSum"));
				
				return course;
			}
			
		});
		
	}
	
	
	// Crud method
	public boolean insert(Course course) {
		
		int year = course.getYear();
		int semester = course.getSemester();
		String title = course.getTitle();
		String classification = course.getClassification();
		String professor = course.getProfessor();
		int credit = course.getCredit();
		
		String sqlStatement = "insert into courses (year, semester, title, classification, professor, credit) values(?,?,?,?,?,?)";
		
		return (jdbcTemplate.update(sqlStatement, new Object[] {year, semester, title, classification, professor, credit}) == 1);
	}
	
	// crUd method
	public boolean update(Course course) {
		
		int year = course.getYear();
		int semester = course.getSemester();
		String title = course.getTitle();
		String classification = course.getClassification();
		String professor = course.getProfessor();
		int credit = course.getCredit();
		
		String sqlStatement = "update courses set year=?, semester=?, title=?, classification=?, professor=?, credit=? where year=? and semester=? and title=?";
		
		return (jdbcTemplate.update(sqlStatement, new Object[] {year, semester, title, classification, professor, credit, year, semester, title}) == 1);
	}
	
	// cruD method
	public boolean delete(int year, int semester, String title) {
		String sqlStatement = "delete from courses where year=? and semester=? and title=?";
		return (jdbcTemplate.update(sqlStatement, new Object[] {year, semester, title}) == 1);
	}
}
