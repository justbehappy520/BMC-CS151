public class InheritanceDriverLab02 {
    public static void main(String[] args){
        Mammal[] mammals = new Mammal[4];
        mammals[0] = new Dolphin();
        mammals[1] = new Platypus();
        mammals[2] = new Human();
        mammals[3] = new CSStudent();

        for (int i=0; i< mammals.length; i++){
            System.out.print("Generally, a " + mammals[i].getName());
            System.out.print(" can be found ");
            if(mammals[i].livesInWater() == false){
                System.out.print("on land, ");
            }
            else {
                System.out.print("in water, ");
            }

            System.out.print("it can ");
            if(mammals[i].laysEggs() == false) {
                System.out.print("not ");
            }
            System.out.print("lay eggs, and is often overheard saying'");
            mammals[i].speak();
            System.out.println("'");
        }
    }
}
