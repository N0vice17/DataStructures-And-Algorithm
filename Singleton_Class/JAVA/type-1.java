class Singleton {
    static int count = 0; // object counter
    int id; // instance variable

    private Singleton(int id) { // private constructor
        this.id = id;
    }

    static Singleton createObject(int id) {
        if (1 == count) { // if one object is already created
            System.out.println("This is a singleton class! Cannot create more objects!");
            return null;
        }
        
        else {
            System.out.println("Object has been created!");
            count++; // increment object counter
            return new Singleton(id); // return new object
        }
    }
}

class Main {
    public static void main(String[] args) {
        Singleton obj1 = Singleton.createObject(1);
        Singleton obj2 = Singleton.createObject(2);
        Singleton obj3 = Singleton.createObject(3);

        System.out.println(obj1.id);
        System.out.println(obj2.id);
        System.out.println(obj3.id);
    }
}