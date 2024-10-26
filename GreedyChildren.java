/* Mina Georgoudiou
 * Dr. Steinberg
 * COP3503 Fall 2024
 * Programming Assignment 3
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

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
        this.angryKids = kidNum;

        this.candies = canNum;
        this.kids = kidNum;

        Read(canNum, kidNum, fnGreed, fnSweet);
    }

    // TODO
    public void greedyCandy()
    {

        // sort arrays via merging (nlogn runtime)
        mergeSort(greedList, 0, kids - 1);
        mergeSort(sweetList, 0, candies - 1);

        //for (int h = 0; h < 15; h++)
        //        System.out.printf("%d\t%d\n", greedList[h], sweetList[h]);

        int d = 0;
        int c = 0;
        int greed = 0;
        int inefficiency = 0;

        while (c < kids && d < candies)
        {
            greed = greedList[c];
            while (greed > 0)
            {
                if (d == candies)
                    continue;
                greed -= sweetList[d];
                d++;
            }

            if (greed <= 0)
            {
                inefficiency -= greed;
                angryKids--;
                happyKids++;
            }

            c++;
        }
        System.out.println(inefficiency);
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

            return;
        }
        // input files werent found
        catch (FileNotFoundException e)
        {
            System.err.println("Input files not found!");
            e.printStackTrace();
        }
    }

    public void display()
    {
        System.out.printf("There are %d happy children.\n", this.happyKids);
        System.out.printf("There are %d angry children.\n", this.angryKids);
    }

    // for sorting in nlogn runtime
    void mergeSort(int pData[], int l, int r)
    {
        // terminating condition
        if (l >= r) return;
        else
        {

            int mid = (l+r)/2; // midpoint

            // recursive call;
            mergeSort(pData, l, mid);
            mergeSort(pData, mid+1, r);

            // lengths of temp arrays
            int lSize = mid - l + 1;
            int rSize = r - mid;

            // temp arrays
            int[] lArray = new int[lSize];
            int[] rArray = new int[rSize];

            // populate temp arrays
            for (int x = 0; x < lSize; x++)
                lArray[x] = pData[l + x];
            
            for (int y = 0; y < rSize; y++)
                rArray[y] = pData[mid+1 + y];

            // put data from temp arrays back into array
            int m = 0, n = 0; // indexes for temp arrays
            for (int p = l; p < r+1; p++) {
                
                // if we've already run out of entries in rArray but lArray still has some left
                if (n >= rSize && m < lSize) {
                    pData[p] = lArray[m];
                    m++;
                }
                // vice versa
                else if (m >= lSize && n < rSize) {
                    pData[p] = rArray[n];
                    n++;
                }
                // otherwise, compare the two and determine which to put first
                else {

                    if (lArray[m] <= rArray[n]) {
                        pData[p] = lArray[m];
                        m++;
                    }
                    else {
                        pData[p] = rArray[n];
                        n++;
                    }
                }
            }
        }
    }
}