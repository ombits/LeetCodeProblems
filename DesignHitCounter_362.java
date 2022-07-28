/*
Design a hit counter which counts the number of hits received in the past 5 minutes.

Each function accepts a timestamp parameter (in seconds granularity) and you may assume that calls are being made to the system in chronological order
 (ie, the timestamp is monotonically increasing). You may assume that the earliest timestamp starts at 1.
It is possible that several hits arrive roughly at the same time.

Example:
HitCounter counter = new HitCounter();
// hit at timestamp 1.
counter.hit(1);
// hit at timestamp 2.
counter.hit(2);
// hit at timestamp 3.
counter.hit(3);
// get hits at timestamp 4, should return 3.
counter.getHits(4);
// hit at timestamp 300.
counter.hit(300);
// get hits at timestamp 300, should return 4.
counter.getHits(300);
// get hits at timestamp 301, should return 3.
counter.getHits(301);
 */

public class DesignHitCounter_362 {
    int[] hits = new int[300] ;  // 300 as smaller unit is second and we need to keep 5 minutes data
    int[] timestamps = new int[300];

    public void hit(int timestamp) {
        int i = timestamp %300;

        if(timestamps[i] == timestamp){
            ++hits[i];
        }else{
            timestamps[i] = timestamp;
            hits[i] = 1;
        }

    }

    public int getHits(int timestamp) {
        int hitCount =0;
        for(int i=0; i<300; i++){
            if(timestamp - timestamps[i] < 300){
                hitCount += hits[i];
            }
        }
        return hitCount;
    }

    public static void main(String[] args){
        DesignHitCounter_362 designHitCounter_362 = new DesignHitCounter_362();
        designHitCounter_362.hit(1);
        designHitCounter_362.hit(2);
        designHitCounter_362.hit(3);
        System.out.println(designHitCounter_362.getHits(4));
        designHitCounter_362.hit(300);
        System.out.println(designHitCounter_362.getHits(300));
        System.out.println(designHitCounter_362.getHits(301));
    }


}
