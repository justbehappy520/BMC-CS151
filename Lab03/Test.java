public class Test {
    public static void main(String[] args) {
        CityDLL list = new CityDLL();
        City tmp1 = new City("b", 1);
        list.insertFirst(tmp1);
        list.insertFirst(new City("a", 1));
        System.out.println(list.toString());
        list.insertBack(new City("c", 1));
        list.insertSortedAlpha(new City("d", 1));
        System.out.println(list.toString());
    }
}
