package Seminar06_HW;

import java.util.*;

class Main {
    public static void main(String[] args) {
        Laptop hp_pailion_g6 = new Laptop("hp_pailion_g6", 500, "16", "Windows", "black");
        Laptop hp_galaxy_x64 = new Laptop("hp_galaxy_x64", 500, "8", "Windows", "white");
        Laptop samsung_a52 = new Laptop("samsung_a52", 300, "8", "Windows", "black");
        Laptop samsung_m31s = new Laptop("samsung_m31s", 1000, "16", "Linux", "black");
        Laptop lenovo_gtx76 = new Laptop("lenovo_gtx76", 700, "8", "Windows", "white");
        Laptop macbook_14pro = new Laptop("macbook_14pro", 1000, "8", "ios", "white");
        Laptop asus_x515 = new Laptop("asus_x515", 300, "4", "Windows", "black");
        Laptop acer_air5 = new Laptop("acer_air5", 600, "8", "Windows", "black");
        Laptop acer_air6 = new Laptop("acer_air6" ,500, "16", "Windows", "black");
        Laptop acer_a313 = new Laptop("acer_a313", 500, "8", "Windows", "black");
        Set <Laptop> laptop = new HashSet<>();
        laptop.add(hp_pailion_g6);
        laptop.add(hp_galaxy_x64);
        laptop.add(samsung_a52);
        laptop.add(samsung_m31s);
        laptop.add(lenovo_gtx76);
        laptop.add(macbook_14pro);
        laptop.add(asus_x515);
        laptop.add(acer_air5);
        laptop.add(acer_air6);
        laptop.add(acer_a313);
        Laptop FilterLaptop = new Laptop();
        System.out.println(FilterLaptop.newFilter(laptop));
    }
}

public class Laptop {
    private String model;
    private int hardDisk;
    private String operativeMemory;
    private String operatingSystem;
    private String color;
    public Laptop() {
    }
    public Laptop(String model, int hardDisk,
                  String operativeMemory, String operatingSystem, String color) {
        this.model = model;
        this.hardDisk = hardDisk;
        this.operativeMemory = operativeMemory;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }
    public String getModel() {return model;}
    public int getHardDisk() {return hardDisk;}
    public String getOperativeMemory() {return operativeMemory;}
    public String getOperatingSystem() {return operatingSystem;}
    public String getColor() {return color;}
    public List<Laptop> filter(Set<Laptop> laptop) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Укажите параметры для ноутбука." +
                "\nУкажите размер жёсткого диска в гб\nВналичии : 300,500,600,700,1000");
        String enterHardDisk = scan.nextLine();
        int intParseEnterHardDisk = Integer.parseInt(enterHardDisk);
        System.out.println("Укажите количество оперативной памяти в Гб\nВналичии : 4, 8, 16 ");
        String enterOperativeMemory = scan.nextLine();
        System.out.println("Укажите операционную систему\nВналичии : Linux, ios, Windows");
        String enterOperatingSystem = scan.nextLine();
        System.out.println("Укажите цвет ноутбука\nВналичии : black, white");
        String enterColor = scan.nextLine();

        List<Laptop> listLaptop = new ArrayList<>();
        for (Laptop tempLaptop : laptop) {
            if (intParseEnterHardDisk == tempLaptop.hardDisk) {
                if (enterOperativeMemory.equals(tempLaptop.operativeMemory)) {
                    if (enterOperatingSystem.equals(tempLaptop.operatingSystem)) {
                        if (enterColor.equals(tempLaptop.color)) {
                            listLaptop.add(tempLaptop);
                        }
                    }
                }
            }
        }
        return listLaptop;
    }

    public Set<Laptop> newFilter(Set<Laptop> laptop) {
        Scanner scan = new Scanner(System.in);
        Set<Laptop> listLaptop = new HashSet<>(laptop);

        System.out.println("Укажите номер критерия для фильрации ноутбуков," +
                "\n1. Размер жёсткого диска\n2. Количество оперативной памяти\n3. Операционная система\n4. Цвет");
        String userRequest = scan.nextLine();

        for (int i = 0; i < userRequest.length(); i++) {
            if(1 == Character.getNumericValue(userRequest.charAt(i))) {
                System.out.println("Укажите размер жёсткого диска в гб\nВналичии : 300,500,600,700,1000");
                String enterHardDisk = scan.nextLine();
                int intParseEnterHardDisk = Integer.parseInt(enterHardDisk);
                for (Laptop tempLaptop : laptop) {
                    if (intParseEnterHardDisk != tempLaptop.hardDisk){
                        listLaptop.remove(tempLaptop);
                    }
                }
            }

            if(2 == Character.getNumericValue(userRequest.charAt(i))){
                System.out.println("Укажите количество оперативной памяти в Гб\nВналичии : 4, 8, 16 ");
                String enterOperativeMemory = scan.nextLine();
                for (Laptop tempLaptop : laptop) {
                    if ((enterOperativeMemory.equals(tempLaptop.operativeMemory)) == false) {
                        listLaptop.remove(tempLaptop);
                    }
                }
            }

            if(3 == Character.getNumericValue(userRequest.charAt(i))){
                System.out.println("Укажите операционную систему\nВналичии : Linux, ios, Windows");
                String enterOperatingSystem = scan.nextLine();
                for (Laptop tempLaptop : laptop) {
                    if ((enterOperatingSystem.equals(tempLaptop.operatingSystem) == false)) {
                        listLaptop.remove(tempLaptop);
                    }
                }
            }

            if(4 == Character.getNumericValue(userRequest.charAt(i))){
                System.out.println("Укажите цвет ноутбука\nВналичии : black, white");
                String enterColor = scan.nextLine();
                for (Laptop tempLaptop : laptop) {
                    if ((enterColor.equals(tempLaptop.color)) == false) {
                        listLaptop.remove(tempLaptop);
                    }
                }
            }
        }
        return listLaptop;
    }

    @Override
    public String toString() {
        return "\nLaptop  ->  " + model + ",\nhardDisk = " + hardDisk + ",\noperativeMemory = " + operativeMemory
                + ",\noperatingSystem = " + operatingSystem + ",\ncolor = " + color + "\n";
    }

}
