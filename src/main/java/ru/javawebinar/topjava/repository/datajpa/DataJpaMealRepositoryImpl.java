package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class DataJpaMealRepositoryImpl implements MealRepository {
    private static final Sort SORT_MEAL_DATE_TIME = new Sort(Sort.Direction.DESC, "date_time");


    @Autowired
    private CrudMealRepository crudRepository;

    @Override
    public Meal save(Meal meal, int userId) {

        return crudRepository.save(meal, userId);
    }

    @Override
    public boolean delete(int id, int userId)
    {
        return crudRepository.deleteByIdAndUserId(id, userId);
    }

    @Override
    public Meal get(int id, int userId) {

        return crudRepository.findByIdAndUserId(id, userId);
    }

    @Override
    public List<Meal> getAll(int userId) {

        return crudRepository.findAllByIdAndUserId(SORT_MEAL_DATE_TIME, userId);
    }

    @Override
    public List<Meal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        return crudRepository.getAllByDateTimeBetweenAndUserId(startDate, endDate, userId);
    }
}
