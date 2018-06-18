package org.problems.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/keys-and-rooms/description/
public class KeysandRooms {

    private static void canVisitAllRooms(List<List<Integer>> rooms, boolean[] visited, int room) {
        if (visited[room])
            return;
        visited[room] = true;
        for (Integer nextRoom : rooms.get(room))
            canVisitAllRooms(rooms, visited, nextRoom);
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];

        canVisitAllRooms(rooms, visited, 0);
        for (int i = 0; i < visited.length; ++i)
            if (!visited[i])
                return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canVisitAllRooms(new ArrayList<>(Arrays.asList(Arrays.asList(1),Arrays.asList(2),Arrays.asList(3),Arrays.asList()))));
    }
}
