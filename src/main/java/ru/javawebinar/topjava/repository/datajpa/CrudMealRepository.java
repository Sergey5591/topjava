package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.util.List;

@Transactional(readOnly = true)
public interface CrudMealRepository extends JpaRepository<Meal, Integer> {

    @Transactional
    Meal save (Meal meal, int userId);

    Meal findByIdAndUserId(int id, int userId);

    List<Meal> findAllByIdAndUserId (Sort sort, int userId);

    List<Meal> getAllByDateTimeBetweenAndUserId (LocalDateTime startTime, LocalDateTime endTime, int userId);

    boolean deleteByIdAndUserId (int id, int userId);
}
