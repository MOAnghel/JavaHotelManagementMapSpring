# JavaHotelManagement App

## Overview

JavaHotelManagement is a Spring Boot application that manages hotel information using a PostgreSQL database. This project utilizes Spring Data JPA for database interaction and Docker for containerization, making it easy to deploy and run.

## Features

- **Hotel Management:** Manage information about hotels, rooms, reservations, and guests.
- **Spring Boot:** Utilizes the Spring Boot framework for building and deploying Java-based applications.
- **Spring Data JPA:** Simplifies data access using the Java Persistence API (JPA) and Hibernate.
- **Docker:** Containerization of the PostgreSQL database for easy deployment.
- **RESTful Service:** The project implements a RESTful API, used for decoupling and simplifying information retrieval from the database. It implements the common CRUD operations (Create, Read, Update, Delete) for every endpoint in the API.

## Prerequisites

Before running the application, ensure you have the following installed:

- Java Development Kit (openJDK)
- Docker
- Maven
- Postman
- IntelliJ IDEA, Eclipse IDE

## Getting Started

1. In your IDE clone the repository. Make sure you have Maven installed:

    ```bash
    git clone https://github.com/MOAnghel/JavaHotelManagementMapSpring.git
    ```

2. In your terminal build the Docker image for the PostgreSQL database, using the following command:

    ```bash
    docker-compose build
    ```

3. Start the Docker container for the database:

    ```bash
    docker-compose up
    ```

4. Run the app on your IDE
5. Access the application at [http://localhost:8080](http://localhost:8080)
## Configuration

- Database configuration can be found in `src/main/resources/application.properties`.
- Customize application properties, such as server port, database credentials, etc., according to your needs.

## Usage

The application provides REST APIs for managing hotels, rooms, reservations, guests, employees and hotel restaurants.

## Entities

### 1. BaseEntity
Used for defining a unified identifier for every class in this application

#### Attributes:

- `id` (Long): unique identifier

### 2. Hotel
This class inherits from `BaseEntity` the `id` attribute and manages the name, the address and the employees of a hotel.

#### Attributes

- `name` (String): the name of the Hotel
- `address` (String): the address of a hotel
- `hotelEmployees` (Set<Employee>): manages the list of employees

### 3. Person
Defines a common behaviour and common attributes for classes that inherit from the `Person` class. Inherits `id` from `BaseEntity`

#### Attributes

- `name` (String): the name of a specific person
- `email` (String): the email of a person
- `phoneNumber` (String): the phone number of a person

### 4. Client
Extends the behaviour of `Person` base class and extends it to include the client's address, the bookings, the restaurant orders a specific client has made using the app

#### Atributes

- `address` (String): the address of a client
- `bookings` (Set<Booking>): the history of bookings 
- `restaurantOrders` (Set<RestaurantOrder>): the history of orders

### 5. Booking
Used for storing the contents of a booking such as the hotel, the client and the list of booked rooms

#### Attributes

- `client` (Client): the client instance
- `hotel` (Hotel): the hotel instance
- `bookedRooms` (Set<Room>): list of booked rooms

### 6. Employee
Extends the behaviour of `Person` base class and extends it to include the employee's salary

#### Attributes

- `salary` (Double): the salary
- `hotelEmployees` (Set<Employee>): list used for establishing a many-to-many relationship with `Hotel` entity

### 7. Room
Manages the room information such as room number, room type, price and number of beds

#### Attributes

- `roomNumber` (Integer): room number
- `roomCategory` (RoomCategory): room type
- `numberOfBeds` (Integer): number of beds
- `occupied` (boolean): status of a room
- `price` (Integer): price
- `bookedRooms` (Set<Room>): list used for many-to-many relationship for the `Room` entity
- `hotel` (Hotel): instance of the hotel to which the room belongs to

### 8. Restaurant
Manages information of a specific restaurant such as name and menu

#### Attributes

- `name` (String): the name of the restaurant
- `restaurantMenus` (`Set<Menu>`): used for many-to-many relationship with `Menu` entity

### 9. Menu
Manages the menu of a specific restaurant

#### Attributes

- `name` (String): name of the menu
- `items` (Set<Item>): contents of a menu
- `restaurantsMenus` (Set<Restaurant>): many-to-many with `Restaurant` entity

### 10. Item
Defines a base class for `Food` and `Beverage` entities

#### Attributes: 
- `name` (String): name
- `price` (Double): price
- `description` (String): description of an item
- `menu` (Menu): many-to-many relationship with `Menu`
- `restaurantOrder` (RestaurantOrder): many-to-many relationship with `RestaurantOrder`

### 11. Food
Extends the base class `Item` and adds information such as quantity of a specific meal, spice level, food type

#### Atributes: `quantity`, `spiceLevel`, `foodType`

### 12. Beverage
Extends the base class `Item` and adds information such as volume and alcohol percentage

#### Attributes: `volume`, `alcoholPercentage`

### 13. RestaurantOrder
Manages information of a restaurant order such as the client information, items and the payment method

#### Attributes: 
- `client` (Client): the client instance that placed the order
- `items` : many-to-many relationship with `Item`
- `paymentMethod`: the type of payment used 

# Use Cases


1. **Hotel Management:**
   - **Use Case:** Admins can efficiently manage and organize hotel information, including details about hotels, rooms, reservations, and guests, using CRUD operations provided by the RESTful service.
   - **Example Scenario:** A hotel manager adds a new hotel to the system, specifying details such as the hotel name, location, contact information, and available facilities. The information is seamlessly stored in the PostgreSQL database using JPA.

2. **Management of Multiple Hotels:**
   - **Use Case:** Chains or companies with multiple hotels can use the system to store and manage information about each hotel individually while having centralized access to overall information.
   - **Example Scenario:** A hotel chain that owns multiple hotels across different locations uses the system to track the activity of each hotel individually. The chain can access and control the overall information from all hotels.

3. **Reservation Management:**
   - **Use Case:** Users can make and manage reservations for rooms, and the system ensures proper tracking of availability and confirmation.
   - **Example Scenario:** A guest searches for available rooms for a specific date range, selects a room, and makes a reservation. The system checks room availability and confirms the reservation, updating the database accordingly.

4. **Employee and Staff Management:**
   - **Use Case:** Hotel administrators can keep track of employees, manage staff roles, and monitor employee activity.
   - **Example Scenario:** An admin adds a new employee to the system, providing details such as name and role (e.g., front desk staff). The system ensures accurate information for hotel staff.

5. **Room Maintenance and Availability:**
   - **Use Case:** Staff can log and manage maintenance requests related to rooms and ensure accurate tracking of room availability.
   - **Example Scenario:** A staff member receives a maintenance request for a room, logs the request into the system, assigns it to maintenance personnel, and updates the room's availability status.