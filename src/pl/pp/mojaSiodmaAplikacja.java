package pl.pp;

public class mojaSiodmaAplikacja {
    static class Person {
        String forename;
        String surname;
        int age;
        String address;
        int birthYear;

        Person() {
        }

        Person(String initForename, String initSurname, int initAge, String initAddress, int initBirthYear) {
            forename = initForename;
            surname = initSurname;
            age = initAge;
            address = initAddress;
            birthYear = initBirthYear;
        }

        void hiToAll() {
            System.out.println("Nazywam się " + forename + " " + surname + ", " + "Mam " + age + " lat.");
        }

        int growOld(int years) {
            age = age + years;
            return age;
        }

        int beYounger() {
            age = age - 1;
            return age;
        }

        String getName() {
            return forename;
        }

        void setName(String nameToSet) {
            forename = nameToSet;
        }
    }

    public static void main(String[] args) {
        Person person1 = new Person();
        person1.hiToAll();

        person1.forename = "Mateusz";
        person1.surname = "Karmazyn";
        person1.age = 24;
        person1.address = "ul. Przykładowa 123, Warszawa";
        person1.birthYear = 2000;
        person1.hiToAll();

        Person person2 = new Person("Dariusz", "Walentyniak", 42, "ul. Inna 456, Kraków", 1982);
        person2.hiToAll();

        person1.growOld(10);
        for(int i=0; i<3; i++) {
            person2.growOld(5);
        }

        person1.hiToAll();
        person2.hiToAll();

        person1.beYounger();
        person1.hiToAll();

        System.out.println(person1.getName());
        person1.setName("Lolo");
        System.out.println(person1.getName());
        person1.hiToAll();
    }
}