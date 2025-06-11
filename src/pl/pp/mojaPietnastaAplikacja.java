package pl.pp;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class mojaPietnastaAplikacja {

    static class User {
        private int id;
        private String name;
        private String email;

        public User(int id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }

        public String getName() { return name; }
    }

    static class Event {
        private int id;
        private String title;
        private String location;
        private LocalDate date;
        private int totalSeats;
        private int availableSeats;

        public void setId(int id) { this.id = id; }
        public void setTitle(String title) { this.title = title; }
        public void setLocation(String location) { this.location = location; }
        public void setDate(LocalDate date) { this.date = date; }
        public void setTotalSeats(int totalSeats) { this.totalSeats = totalSeats; }
        public void setAvailableSeats(int availableSeats) { this.availableSeats = availableSeats; }

        public int getAvailableSeats() { return availableSeats; }
        public void reduceAvailableSeats(int seats) { this.availableSeats -= seats; }
    }

    static class Reservation {
        private User user;
        private Event event;
        private int numberOfSeats;
        private LocalDateTime reservationDate;

        public void setUser(User user) { this.user = user; }
        public void setEvent(Event event) { this.event = event; }
        public void setNumberOfSeats(int numberOfSeats) { this.numberOfSeats = numberOfSeats; }
        public void setReservationDate(LocalDateTime reservationDate) { this.reservationDate = reservationDate; }
    }

    static class ReservationService {
        public boolean makeReservation(User user, Event event, int seatsRequested) {
            System.out.println("🔍 Sprawdzanie dostępności miejsc dla " + user.getName() + "...");
            if (event.getAvailableSeats() >= seatsRequested) {
                event.reduceAvailableSeats(seatsRequested);

                Reservation reservation = new Reservation();
                reservation.setUser(user);
                reservation.setEvent(event);
                reservation.setNumberOfSeats(seatsRequested);
                reservation.setReservationDate(LocalDateTime.now());

                System.out.println("✅ Rezerwacja zakończona sukcesem dla " + user.getName() +
                        ". Zarezerwowano: " + seatsRequested + " miejsc.");
                System.out.println("🪑 Dostępne miejsca po rezerwacji: " + event.getAvailableSeats());
                return true;
            } else {
                System.out.println("❌ Niestety, " + user.getName() + ", nie ma wystarczającej liczby miejsc.");
                System.out.println("🪑 Dostępne miejsca: " + event.getAvailableSeats() +
                        ", żądane: " + seatsRequested);
                System.out.println("🙏 Spróbuj wybrać inną liczbę miejsc lub inne wydarzenie.");
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Event event = new Event();
        event.setId(1);
        event.setTitle("Koncert Imagine Dragons");
        event.setLocation("Warszawa Stadion Narodowy");
        event.setDate(LocalDate.of(2025, 7, 18));
        event.setTotalSeats(5);
        event.setAvailableSeats(5);

        User user1 = new User(1, "Nazarchik", "nazar@example.com");
        User user2 = new User(2, "Maria", "maria@example.com");
        User user3 = new User(3, "Kostik", "kostik@example.com");

        ReservationService service = new ReservationService();

        service.makeReservation(user1, event, 2);

        service.makeReservation(user2, event, 4);

        service.makeReservation(user3, event, 2);
    }
}