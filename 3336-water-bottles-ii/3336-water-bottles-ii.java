class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int drunk = numBottles;
        int empty = numBottles;
        numBottles = 0;
        while(numBottles + empty >= numExchange){
            numBottles++;
            empty = empty - numExchange;
            numExchange++;
            if(empty == 0){
                drunk += numBottles;
                numBottles = 0;
            } 
        }
        drunk += numBottles;
        return drunk;
    }
}