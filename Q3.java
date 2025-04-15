class Continent {
    String continentName;

    Continent(String continentName) {
        this.continentName = continentName;
    }
}


// Intermediate class: Country (inherits from Continent)
class Country extends Continent {
    String countryName;

    Country(String continentName, String countryName) {
        super(continentName);
        this.countryName = countryName;
    }
}

// Derived class: State (inherits from Country)
class State extends Country {
    String stateName;

    State(String continentName, String countryName, String stateName) {
        super(continentName, countryName);
        this.stateName = stateName;
    }

    // Method to display details
    void displayDetails() {
        System.out.println("Continent: " + continentName);
        System.out.println("Country: " + countryName);
        System.out.println("State: " + stateName);
    }
}

public class Q3 {
    public static void main(String[] args) {
        // Create an object of State (which is at the deepest level of inheritance)
        State obj = new State("Asia", "India", "Maharashtra");
        
        // Display the details
        obj.displayDetails();
    }
}

