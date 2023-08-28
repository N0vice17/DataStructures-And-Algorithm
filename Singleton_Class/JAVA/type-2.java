class Singleton {
    private static Singleton instance = null; // private static instance
    int id; // instance variable

    private Singleton(int id) { // private constructor
        this.id = id;
    }

    static Singleton createObject(int id) {
        if (null == instance) // if no object is created
            instance = new Singleton(id); // create new instance and store it
        return instance; // return the instance
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