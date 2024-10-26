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

        Read(fnGreed, fnSweet);
    }

    // TODO
    public void greedyCandy()
    {
        
    }

    public void Read(String fnGreed, String fnSweet)
    {
        try
        {
            // get files from names
            File gFile = new File(fnGreed);
            File sFile = new File(fnSweet);

            // scanner objects
            Scanner gScan = new Scanner(gFile);
            Scanner sScan = new Scanner(sFile);

            // temp arraylists
            ArrayList<Integer> gArray = new ArrayList<Integer>();
            ArrayList<Integer> sArray = new ArrayList<Integer>();

            // length counters
            int gLen = 0;
            int sLen = 0;

            // parse all ints into temp arraylist
            while (gScan.hasNextLine())
            {
                gArray.add(Integer.parseInt(gScan.nextLine()));
                gLen++;
            }

            while (sScan.hasNextLine())
            {
                sArray.add(Integer.parseInt(sScan.nextLine()));
                sLen++;
            }

            // allocate lists with len space
            this.greedList = new int[gLen];
            this.sweetList = new int[sLen];

            // transfer from temps to lists
            for (int a = 0; a < gLen; a++)
                this.greedList[a] = gArray.get(a);
            
            for (int b = 0; b < sLen; b++)
                this.sweetList[b] = sArray.get(b);
            
            // get rid of the temps
            gArray.clear();
            sArray.clear();

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