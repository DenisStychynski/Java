package HomeWork6.Cats;

public class Cats {
   
        String food;
        String location;
        String name;
    
        public Cats(String name,String food, String location) {
            this.food = food;
            this.location = location;
            this.name = name;
        }
    
        public void makeNoise() {
            System.out.println("Noise");
        }
    
        public void eat() {
            System.out.println("Eat");
        }
    
        public void sleep() {
            System.out.println("Sleep");
        }
    }

