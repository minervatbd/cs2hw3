/* Mina Georgoudiou
 * Dr. Steinberg
 * COP3503 Fall 2024
 * Programming Assignment 3
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class GreedyChildren
{
    // greedy factor of kids
    int[] greedList;
    // sweetness factor of candies
    int[] sweetList;

    // counters
    int candies;
    int kids;

    // num of happies
    int happyKids;
    // num of angries
    int angryKids;

    // constructor time
    GreedyChildren(int canNum, int kidNum, String fnGreed, String fnSweet)
    {
        this.happyKids = 0;
        this.angryKids = 0;

        this.candies = canNum;
        this.kids = kidNum;

        Read(canNum, kidNum, fnGreed, fnSweet);
    }

    // TODO
    public void greedyCandy()
    {
        
    }

    public void Read(int canNum, int kidNum, String fnGreed, String fnSweet)
    {
        try
        {
            // get files from names
            File gFile = new File(fnGreed);
            File sFile = new File(fnSweet);

            // scanner objects
            Scanner gScan = new Scanner(gFile);
            Scanner sScan = new Scanner(sFile);

            //  temp arraylist

            // allocate lists with len space
            this.greedList = new int[kidNum];
            this.sweetList = new int[canNum];

            // parse all ints in to lists
            for (int a = 0; a < kidNum; a++)
                this.greedList[a] = Integer.parseInt(gScan.nextLine());
            
            for (int b = 0; b < canNum; b++)
                this.sweetList[b] = Integer.parseInt(sScan.nextLine());

            // close scanners
            gScan.close();
            sScan.close();

            for (int h = 0; h < 15; h++)
                System.out.printf("%d\t%d\n", greedList[h], sweetList[h]);

            return;
        }
        // input files werent found
        catch (FileNotFoundException e)
        {
            System.err.println("Input files not found!");
            e.printStackTrace();
        }
    }

    // TODO
    public void display()
    {
        System.out.println("there are children...");
    }
}