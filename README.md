# Offroad-repair-service-Project
My own Java Spring Web project with SQL database

This application simplifies the process of managing spare parts and workshop visits for offroad car repairs.

Description: 
The Offroad Repair Service is a software application designed to manage specific spare parts for cars within the database of an offroad car service. 
This application comes with built-in functionality for reserving workshop visit slots for vehicles. Each visit includes a list of selected repair parts, the estimated time required for replacement, 
and the associated parts cost. The primary goal of this program is to streamline car repair processes, saving time for service providers, while also providing automatic estimates for repair duration 
and parts cost.

Prerequisites
To run this project, ensure that your system meets the following requirements:
•	Java version 11
•	Spring Boot Version: 2.6.7
•	Database: MySQL
•	Maven

Installation
To get started, follow these steps:
1. Clone this repository to your local machine: 
   Git clone https://github.com/RadoslavDanailov/Offroad-repair-service-Project
2.	Navigate to the project directory: 
    cd Offroad-repair-service-Project
3.	Run the application using Maven:
    mvn spring-boot:run
4.	Access the application in your web browser using http://localhost:8080.

Usage
After launching the application, you will be directed to the "Login" page. Here, you have the option to either create a new user by clicking the "Register" button or log in with an existing account 
using the "Login" button.
Once logged in, you will arrive at the "Home" screen, which provides the following functionalities:
•	"Offroad Repair Service" button: Returns to the "Home" screen.
•	"Check Visits" button: Redirects to a screen where you can enter a car's registration number to view its service visits, including detailed information about the spare parts used, time required for replacement,
and the cost.
•	"Add Parts" button: Redirects to a screen for adding a spare part to the database. You can specify details such as the manufacturer, part name, manufacturing date, time needed for replacement, price,
and part type. Use the "Add Part" button to save the part to the database.
Below the "Add Parts" and "Check Visits" buttons, there is a list of spare parts categorized into three sections: "Suspension," "Body," and "Engine." Each part has an adjacent "Add" button,
which adds the selected part to the repair cart.
The right half of the "Home" screen displays the Repair Cart, which lists the selected parts for repair, along with the total repair time and cost. 
Each part has a "Remove" button for removing it from the repair cart. Two additional buttons are located beneath the cart:
•	"Remove All": Clears all parts from the current repair.
•	"Book Visit": Redirects to a screen for booking a workshop visit for a specific vehicle. On this screen, you should provide details such as the car's make, model, visit date, and license plate. 
After clicking the "Book Visit" button, the program automatically saves the car's information, selected parts, repair duration, and parts cost. 
You can then use the "Remove All" button to start a new visit for another vehicle.


##Database Schema:
##Table name: “part”
| Column name                      | Data type   | Description                                  |
|----------------------------------|-------------|----------------------------------------------|
| id                               | INT         | Unique identifier                            |
| manufacturer                     | VARCHAR     | Manufacturer of the part                     |
| manufacturing_date               | TIMESTAMP   | Date of production of the part               |
| part_name	                       | VARCHAR     | Name of the part                             |
| price                            | DECIMAL     | Cost of the part                             |
| time_needed_to_change            | INT         | Replacement time                             |

##Table name: “type”
| Column name                      | Data type   | Description                                  |
|----------------------------------|-------------|----------------------------------------------|
| id                               | INT         | Unique identifier                            |
| description                      | VARCHAR     | Description of part type                     |
| type_name                        | VARCHAR     | Name of the type                             |

##Table name: “user”
| Column name                      | Data type   | Description                                  |
|----------------------------------|-------------|----------------------------------------------|
| id                               | INT         | Unique identifier                            |
| email                            | VARCHAR     | Email of current user                        |
| password                         | VARCHAR     | Password for login                           |
| username	                       | VARCHAR     | Username of current user                     |

##Table name: “visit”
| Column name                      | Data type   | Description                                  |
|----------------------------------|-------------|----------------------------------------------|
| id                               | INT         | Unique identifier                            |
| car_make                         | VARCHAR     | Manufacturer of the car                      |
| car_model                        | VARCHAR     | Model of the car                             |
| date_reserved                    | TIMESTAMP   | Date reserved for visit                      |
| license_plate                    | VARCHAR     | License plate of the vehicle                 |
| total_price                      | DECIMAL     | Sum of cost for all parts for visit          |
| total_time                       | INT         | Sum of time_needed_to_change                 |
| user                             | VARCHAR     | User reserved current visit                  |

##Relationships
“part” table has a foreign key relationship with “user” via “fk_user”
“visit” table has a foreign key relationship with “part” via “fk_part”

Credits:
Special thanks to the Spring Boot and MySQL communities for their excellent tools and documentation.

Contact information:
e-mail: Radoslav_g_danailov@abv.bg


