package repository;

import exceptions.NullValueException;
import model.Course;

/**
 * We cannot implement the CRUD methods in generic class InMemoryRepository because getId() isn't recognized (because of class T).
 * That's why we implement them in different repositories for objects that have the method getId() implemented
 */
public class CourseRepository extends InMemoryRepository<Course> {

    public CourseRepository() {
        super();
    }

    @Override
    public Course findOne(Long id) throws NullValueException {
        if (id == null)
            throw new NullValueException("Invalid ID");
        for (Course course : repoList) {
            if (course.getId() == id)
                return course;
        }
        return null;
    }

    @Override
    public Course save(Course entity) throws NullValueException {
        if (entity == null)
            throw new NullValueException("Invalid entity");
        for (Course course : repoList)
            if (course.getId() == entity.getId())
                return entity;
        repoList.add(entity);
        return null;
    }

    @Override
    public Course delete(Long id) throws NullValueException {
        if (id == null)
            throw new NullValueException("Invalid entity");
        for (Course course : repoList)
            if (course.getId() == id) {
                repoList.remove(course);
                return course;
            }
        return null;
    }

    @Override
    public Course update(Course entity) throws NullValueException {
        if (entity == null)
            throw new NullValueException("Invalid entity");
        for (Course course : repoList)
            if (course.getId() == entity.getId()) {
                repoList.remove(course);
                repoList.add(entity);
                return null;
            }
        return entity;
    }
}
