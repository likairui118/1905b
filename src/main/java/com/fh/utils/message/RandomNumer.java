package com.fh.utils.message;

import java.util.Random;

public class RandomNumer {

    /**
     * 产生4位随机数(0000-9999)
     * @return 4位随机数
     */
    public static String getFourRandom(int leng){
        Random random = new Random();
        String fourRandom = random.nextInt((int) Math.pow(10,leng)) +"";
        int randLength = fourRandom.length();
        if(randLength<leng){
            for(int i=1; i<=leng-randLength; i++)
                fourRandom = "0" + fourRandom ;
        }
        return fourRandom;
    }

    public static void main(String[] aa){
        for (int i = 0; i <100 ; i++) {
            String fourRandom = RandomNumer.getFourRandom(6);
            System.out.println(fourRandom);
        }


    }
}
