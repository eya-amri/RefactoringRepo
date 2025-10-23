package com.directi.training.ocp.exercise;

public class TimeSlot implements Resource {

    @Override
    public int allocate() {
        int resourceId = findFreeSlot();
        markBusy(resourceId);
        return resourceId;
    }

    @Override
    public void free(int resourceId) {
        markFree(resourceId);
    }

    @Override
    public void markBusy(int resourceId) {
        System.out.println("Time slot " + resourceId + " busy");
    }

    @Override
    public void markFree(int resourceId) {
        System.out.println("Time slot " + resourceId + " free");
    }

    @Override
    public int findFreeSlot() {
        return 0;
    }
}
