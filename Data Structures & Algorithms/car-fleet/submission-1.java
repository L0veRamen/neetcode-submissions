class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // TreeMap: key = position, value = time to reach target
        // Automatically sorted by position ascending
        TreeMap<Integer, Double> map = new TreeMap<>();

        for(int i = 0; i < position.length; i++){
            double time = (double)(target - position[i]) / speed[i];
            map.put(position[i], time);
        }
        int fleets = 0;
        double prevTime = 0.0;

        //Iterate descending by position(front of road -> back)
        for(double time: map.descendingMap().values()){
            //if this car takes longer than the fleet ahead -> new fleet
            if(time > prevTime){
                fleets++;
                prevTime = time; // this car is now the slowest fleet leader
            }
            // else: merge into the fleet ahead
        }
        return fleets;
    }
}
