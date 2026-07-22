package Collections.Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLogs {

    static class LogEntry {
        int timestamp;
        String message;

        LogEntry(int timestamp, String message) {
            this.timestamp = timestamp;
            this.message = message;
        }

        @Override
        public String toString() {
            return "[" + timestamp + ": " + message + "]";
        }
    }

    public static List<LogEntry> mergeKSortedLogs(List<List<LogEntry>> sources) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> sources.get(a[0]).get(a[1]).timestamp - sources.get(b[0]).get(b[1]).timestamp
        );
        for (int i = 0; i < sources.size(); i++) {
            if (!sources.get(i).isEmpty()) {
                minHeap.offer(new int[]{i, 0});
            }
        }
        List<LogEntry> merged = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int sourceIdx = top[0], elemIdx = top[1];
            merged.add(sources.get(sourceIdx).get(elemIdx));
            if (elemIdx + 1 < sources.get(sourceIdx).size()) {
                minHeap.offer(new int[]{sourceIdx, elemIdx + 1});
            }
        }
        return merged;
    }

    public static void main(String[] args) {
        List<LogEntry> server1 = Arrays.asList(
            new LogEntry(100, "Auth start"),
            new LogEntry(105, "DB connection")
        );
        List<LogEntry> server2 = Arrays.asList(
            new LogEntry(102, "Request received"),
            new LogEntry(108, "Auth success")
        );
        List<LogEntry> server3 = Arrays.asList(
            new LogEntry(101, "Cache hit"),
            new LogEntry(110, "Response sent")
        );

        List<List<LogEntry>> allLogs = Arrays.asList(server1, server2, server3);
        System.out.println(mergeKSortedLogs(allLogs));
    }
}
