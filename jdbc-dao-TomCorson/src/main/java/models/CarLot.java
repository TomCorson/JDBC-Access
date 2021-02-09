package models;

import daos.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarLot implements DAO {
    private ArrayList<Car> cars = new ArrayList<Car>();

    Connection connection = ConnectionFactory.getConnection();


    public void addCar(Integer id){
        cars.add(findById(id));
    }


    public Car findById(int id)  {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from cars where id=" + id+";");

            if(rs.next()){
                return extractCarFromResultSet(rs);
                      }
                }
            catch (SQLException e) {
            e.printStackTrace();
                }
               return null;
    }
    public String getCars(){
        String carList = "";
        for(Car c: cars){
            carList += c.toString();
            carList += "\n\n";
        }
        return carList;
    }
    private Car extractCarFromResultSet(ResultSet rs) throws SQLException {
        Car car = new Car();
        car.setId(rs.getInt("id"));
        car.setMake(rs.getString("make"));
        car.setModel(rs.getString("model"));
        car.setYear(rs.getInt("year"));
        car.setColor(rs.getString("color"));
        car.setVin(rs.getString("vin"));
        return car;
    }



    public List findAll() {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from cars;");
            ArrayList<Car> allCars = new ArrayList<Car>();

                while(rs.next()) {
                    Car car = extractCarFromResultSet(rs);
                    allCars.add(car);
                }
                return allCars;

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Boolean update(Car c) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("update cars set make=?, model=?, year=?, color=?, vin=? where id="+c.getId()+";");
            preparedStatement.setString(1,c.getMake());
            preparedStatement.setString(2,c.getModel());
            preparedStatement.setInt(3,c.getYear());
            preparedStatement.setString(4,c.getColor());
            preparedStatement.setString(5,c.getVin());
            int i = preparedStatement.executeUpdate();

            return i == 1 ? true:false;
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public Boolean create(Car c) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("insert into cars values(null, ?, ?, ?, ?, ?);");
            preparedStatement.setString(1,c.getMake());
            preparedStatement.setString(2,c.getModel());
            preparedStatement.setInt(3,c.getYear());
            preparedStatement.setString(4, c.getColor());
            preparedStatement.setString(5,c.getVin());
            int i = preparedStatement.executeUpdate();
            return i == 1 ? true:false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public Boolean delete(int id) {
        try{
            Statement statement = connection.createStatement();
            int i = statement.executeUpdate("delete from cars where id="+id+";");
            return i == 1 ? true:false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}


















