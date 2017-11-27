import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by avsrivathsan on 7/27/2017.
 */
public class SortIntervals {

    class Endpoint implements  Comparable<Endpoint> {
        int time;
        boolean isStart;

        public Endpoint(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public boolean isStart() {
            return isStart;
        }

        public void setStart(boolean start) {
            isStart = start;
        }


        @Override
        public int compareTo(Endpoint o) {
            int value = Integer.compare(time, o.getTime());
            if (value != 0) {
                return value;
            }
            return (isStart && !o.isStart ? -1 : (!isStart && o.isStart ? 1 : 0));

        }
    }


    class Event {
        int startTime;
        int endTime;

    }

    private int maxConcurrentEvents(List<Event> events) {
        List<Endpoint> endpoints = new ArrayList<>();
        for (Event e : events) {
            endpoints.add(new Endpoint(e.startTime, true));
            endpoints.add(new Endpoint(e.endTime, false));
        }
        Collections.sort(endpoints);
        int maxEvents = 0;
        int currentEvents = 0;
        for (Endpoint endpoint : endpoints) {
            if (endpoint.isStart) {
                currentEvents++;
            } else {
                currentEvents--;
            }
            maxEvents = Math.max(currentEvents, maxEvents);
        }
        return maxEvents;
    }
}
