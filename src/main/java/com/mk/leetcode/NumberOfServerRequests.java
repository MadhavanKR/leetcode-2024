package com.mk.leetcode;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author keerthanamadhavan
 * link: https://leetcode.com/discuss/interview-question/5379922/Amazon-OA-oror-SDE-2-2024-(Code-Question-1)
 */
public class NumberOfServerRequests {

    public static void main(String[] args) {
        int[] serverIds = {2, 5, 2};
        int[] replaceIds = {2, 5, 3};
        int[] newIds = {3, 1, 5};
        Solution solution = new Solution();
        int[] answer = solution.numberOfServerRequests(serverIds, replaceIds, newIds);
        int[] optimizedAnswer = solution.numberOfServerRequestsOptimized(serverIds, replaceIds, newIds);

        System.out.println("answer: " + Arrays.toString(answer));
        System.out.println("optimizedAnswer: " + Arrays.toString(answer));
    }

    public static class Solution {

        /**
         * Bruteforce solutio
         * @param serverIds
         * @param replaceIds
         * @param newIds
         * @return
         */
        public int[] numberOfServerRequests(int[] serverIds, int[] replaceIds, int[] newIds) {

            int[] results = new int[serverIds.length];
            int numDays = serverIds.length;

            for (int day = 0; day < numDays; day++) {
                int serverToBeReplaced = replaceIds[day];
                int newServer = newIds[day];
                int numRequests = 0;
                for (int i = 0; i<serverIds.length; i++) {
                    serverIds[i] = serverIds[i] == serverToBeReplaced ? newServer : serverIds[i];
                    numRequests += serverIds[i];
                }
                results[day] = numRequests;
            }

            return results;
        }

        /**
         * Optimized solution
         */
        public int[] numberOfServerRequestsOptimized(int[] serverIds, int[] replaceIds, int[] newIds) {

            int[] results = new int[serverIds.length];
            int numDays = serverIds.length;

            Map<Integer, Integer> serversCountMap = new HashMap<>();

            for (int serverId : serverIds) {
                int serverCount = serversCountMap.getOrDefault(serverId, 0);
                serversCountMap.put(serverId, serverCount + 1);
            }


            for (int day = 0; day < numDays; day++) {
                int serverToBeReplaced = replaceIds[day];
                int newServer = newIds[day];

                int numServersToReplace = serversCountMap.getOrDefault(serverToBeReplaced, 0);
                int newServerCount = serversCountMap.getOrDefault(newServer, 0);

                serversCountMap.remove(serverToBeReplaced);
                serversCountMap.put(newServer, newServerCount + numServersToReplace);

                results[day] = 0;

                for (Map.Entry<Integer, Integer> entry : serversCountMap.entrySet()) {
                    results[day] += (entry.getKey() * entry.getValue());
                }
            }

            return results;
        }


    }
}
