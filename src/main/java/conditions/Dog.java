package conditions;

import java.util.ArrayList;
import java.util.List;

public class Dog {

    public static void main(String[] args) {
        Dog dog1 = new Dog("vasya", 1, Breed.LABRADOR);
        Dog dog2 = new Dog("vasya", 8, Breed.BULLDOG);
        Dog dog3 = new Dog("danya", 3, Breed.BEAGLE);

        boolean sameName = false;

        if (dog1.getName().equals(dog2.getName()) || dog1.getName().equals(dog3.getName()) || dog2.getName().equals(dog3.getName()))
            sameName = true;

        System.out.println("Is there dogs with same name: " + sameName);

        List<Dog> dogs = new ArrayList<>();
        dogs.add(dog1);
        dogs.add(dog2);
        dogs.add(dog3);

        int maxAge = Integer.MIN_VALUE;
        String oldestDogName = "";
        Breed oldestDogBreed = null;

        for (int i = 0; i < dogs.size(); i++) {
            if (dogs.get(i).getAge() > maxAge) {
                maxAge = dogs.get(i).getAge();
                oldestDogName = dogs.get(i).getName();
                oldestDogBreed = dogs.get(i).getBreed();
            }
        }
        System.out.println("Oldest dog name is: " + oldestDogName);
        System.out.println("Oldest dog breed is: " + oldestDogBreed);
    }


    private String name;
    private int age;
    private Breed breed;

    public Dog(String name, int age, Breed breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
