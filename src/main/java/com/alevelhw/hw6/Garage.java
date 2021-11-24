package com.alevelhw.hw6;

public class Garage {
    public static void checkCar (CarForTenPoint carForTenPoint) {
        boolean isEnoughPetrolLevel = carForTenPoint.isEnoughPetrolLevel();
        boolean isElectricalEngine = carForTenPoint.getEngine().getType().equals("Electrical");
        int petrolLevel = carForTenPoint.getPetrol();
        int enginePower = carForTenPoint.getEngine().getPower();

        if (isEnoughPetrolLevel && enginePower > 200) {
            if (isElectricalEngine) {
                System.out.println("Автомобиль готов к путешествию. Мощность двигателя " + enginePower +
                        ", заряд батареи " + petrolLevel);
            }
            else {
                System.out.println("Автомобиль готов к путешествию. Мощность двигателя " + enginePower +
                        ", количество топлива " + petrolLevel);
            }
        }
        else {
            System.out.println("Автомобиль не готов к эксплуатации");
            if (enginePower < 200) {
                System.out.println("Мощность двигателя " + enginePower + ". Замените или отремонтируйте двигатель");
            }
            if (!isEnoughPetrolLevel) {
                if (isElectricalEngine) {
                    System.out.println("Уровень заряда батареи " + petrolLevel + ". Зарядите авто");
                }
                else {
                    System.out.println("Уровень топлива " + petrolLevel + ". Заправьте авто");
                }
            }
        }
    }
}
