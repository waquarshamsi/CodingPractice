/**
 * Author:  Waquar Shamsi
 * Date:    March 24, 2024
 * Link:    https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/?envType=study-plan-v2&envId=leetcode-75
 * Performance: Time=0ms(Beats 100% of Java Submissions), Memory=42.12MB (Beats 70.83% of Java Submissions)
 * Comments: Using java streams to find the largest element in array takes more time than simple for loop iteration.
 */
class KidsWithTheGreatestNumbeOfCandies {
    private List<Boolean> result;
    private int[] candiesGlobal;
    private int extraCandies;

    private int recursiveMax(int[] candies, int extraCandies, int index, int maxTillNow) {
        if (index >= candies.length) {
            return maxTillNow;
        }
        maxTillNow = maxTillNow > candies[index] ? maxTillNow : candies[index];
        maxTillNow = recursiveMax(candies, extraCandies, index+1, maxTillNow);
        result.add(0, candies[index] + extraCandies >= maxTillNow ? true : false);
        return maxTillNow;
    }
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        this.result = new ArrayList<>(candies.length);
        recursiveMax(candies, extraCandies, 0, 0);
        return this.result;
    }
}