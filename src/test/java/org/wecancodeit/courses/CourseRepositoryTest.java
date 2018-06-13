package org.wecancodeit.courses;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Test;

public class CourseRepositoryTest {
	private long firstCourseId = 1L; // created variable for courseID
	private Course firstCourse = new Course(firstCourseId, "course name", "course description"); // created the object course and
																						// a matching class with //
																						// contsructor
	private long secondCourseId;
	private Course secondCourse = new Course(secondCourseId, "course name", "course description");

	@Test
	public void shouldFindACourse() {
		CourseRepository underTest = new CourseRepository(firstCourse); // from this created the class
		Course result = underTest.findOne(firstCourseId); // find a course by ID
		assertThat(result, is(firstCourse));
	}

	@Test
	public void shouldFindASecondCourse() {
		CourseRepository underTest = new CourseRepository(secondCourse);
		Course result = underTest.findOne(secondCourseId);
		assertThat(result, is(secondCourse));
	}
	@Test
	public void shouldFindAllCourses() {
		CourseRepository underTest = new CourseRepository(firstCourse, secondCourse);
	Collection<Course> result = underTest.findAll();
	assertThat(result, containsInAnyOrder(firstCourse, secondCourse));
	}
}
