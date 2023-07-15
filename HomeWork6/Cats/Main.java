package HomeWork6.Cats;

public class Main {
    public static void main(String[] msi) {
        
        
        Owner owner = new Owner();
        Cats[] animals = new Cats[2];
        animals[0] = new Cats("Барсик", "Мясо", "Диван");
        animals[1] = new Cats("Мурзик", "Рыба", "Кресло");
        

        for (Cats animal : animals) {
            owner.feedAnimal(animal);
        }
    }
    
}