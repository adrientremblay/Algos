package src.clrs.ch_15_greedy_algos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ActivitySelectionProblem {
    /**
     * Activities are represented in a 2D matrix
     * the first colomn represents the start times, and the second represents the finish times
     * @param activities
     * @return
     */
    public static List<Integer[]> greedySolution(List<Integer[]> activities) {
        ArrayList<Integer[]> ret = new ArrayList<Integer[]>();

        // We want to continuously pick the first COMPATIBLE activity that finishes FIRST,
        // so we need to ensure that the activities are sorted in monotonically increasing order
        activities.sort(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[1].compareTo(o2[1]);
            }
        });

        ret.add(activities.get(0));
        int curFinish = activities.get(0)[1];

        for (int i = 1 ; i < activities.size() ; i++) {
            Integer[] activity = activities.get(i);

            if (activity[0] >= curFinish) {
                ret.add(activity);
                curFinish = activity[1];
            }
        }

        return ret;
    }

    public static void main(String args[]) {
        ArrayList<Integer[]> activities = new ArrayList<Integer[]>();
        activities.add(new Integer[]{7, 11});
        activities.add(new Integer[]{3, 9});
        activities.add(new Integer[]{5, 9});
        activities.add(new Integer[]{8, 12});
        activities.add(new Integer[]{12, 16});
        activities.add(new Integer[]{5, 7});
        activities.add(new Integer[]{3, 5});
        activities.add(new Integer[]{0, 6});
        activities.add(new Integer[]{6, 10});
        activities.add(new Integer[]{1, 4});
        activities.add(new Integer[]{2, 14});

        List<Integer[]> largestSubset = greedySolution(activities);

        for (Integer[] activty : largestSubset) {
            System.out.println(activty[0] + " " + activty[1]);
        }

        /*
        activities.add(new Integer[]{1, 4});
        activities.add(new Integer[]{3, 5});
        activities.add(new Integer[]{0, 6});
        activities.add(new Integer[]{5, 7});
        activities.add(new Integer[]{3, 9});
        activities.add(new Integer[]{5, 9});
        activities.add(new Integer[]{6, 10});
        activities.add(new Integer[]{7, 11});
        activities.add(new Integer[]{8, 12});
        activities.add(new Integer[]{2, 14});
        activities.add(new Integer[]{12, 16});
         */
    }
}
