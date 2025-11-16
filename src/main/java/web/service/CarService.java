package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private List<Car> cars;

    public CarService() {
        cars = new ArrayList<>();
        cars.add(new Car("BMW X5", "Black", 2020));
        cars.add(new Car("Audi A6", "White", 2018));
        cars.add(new Car("Toyota Camry", "Silver", 2019));
        cars.add(new Car("Mercedes C200", "Blue", 2021));
        cars.add(new Car("Lexus RX350", "Red", 2017));
    }

    public List<Car> getCars(int count) {
        if (count >= cars.size()) {
            return cars;
        }
        return cars.subList(0, count);
    }

    public List<Car> getAllCars() {
        return cars;
    }
}
