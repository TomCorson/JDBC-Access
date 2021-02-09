package daos;

import models.Car;

import java.util.List;

public interface DAO <T>{
    public T findById(int id);
    public List findAll();
    public Boolean update(Car c);
    public Boolean create(Car c);
    public Boolean delete(int id);
}
