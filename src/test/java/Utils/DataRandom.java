package Utils;

import java.util.Random;

public class DataRandom {

    public String generateRandomText(){
        Random random = new Random();
        int firstNumber = random.nextInt(1000);
        int secondNumber = random.nextInt(1000);

        String formattedTitle = String.format("test-%03d-%03d", firstNumber, secondNumber);
        return formattedTitle;
    }
    public   String generateRandomEmail (){
        String numbers = "0123456789";
        StringBuilder randomNumbers = new StringBuilder();
        for(int i = 0; i<5;i++){
            int randomIndex = (int) (Math.random()*numbers.length());
            randomNumbers.append(numbers.charAt(randomIndex));
        }
        String emailPrefix = "sm-qa-user"+ randomNumbers+ "@Gmail.com";
        return emailPrefix;
    }
}
