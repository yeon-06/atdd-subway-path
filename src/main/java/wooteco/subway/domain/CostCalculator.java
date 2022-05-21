package wooteco.subway.domain;

public class CostCalculator {

    private static final int BASIC_COST = 1250;
    private static final int CHARGED_COST = 100;
    private static final int CHARGED_DISTANCE_1 = 10;
    private static final int CHARGED_DISTANCE_2 = 50;
    private static final int CHARGED_UNIT_1 = 5;
    private static final int CHARGED_UNIT_2 = 8;

    private final int distance;
    private final int extraFare;

    public CostCalculator(int distance, int extraFare) {
        this.distance = distance;
        this.extraFare = extraFare;
    }

    public int calculate() {
        return calculateByDistance() + extraFare;
    }

    private int calculateByDistance() {
        int cost = BASIC_COST;
        int distance = this.distance;

        if (distance > CHARGED_DISTANCE_2) {
            cost += calculateCost(distance, CHARGED_DISTANCE_2, CHARGED_UNIT_2);
            distance = CHARGED_DISTANCE_2;
        }
        if (distance > CHARGED_DISTANCE_1) {
            cost += calculateCost(distance, CHARGED_DISTANCE_1, CHARGED_UNIT_1);
        }
        return cost;
    }

    private int calculateCost(int distance, int baseDistance, int unit) {
        return ((distance - baseDistance - 1) / unit + 1) * CHARGED_COST;
    }
}
