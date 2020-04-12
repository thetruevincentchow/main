package seedu.planner.model.graduation;

/**
 * Enum class to specify how a {@code CompoundGraduationRequirement} determines if it has been fulfilled.
 */
public enum AggregationType {
    ALL("All"),
    ANY("Any"),
    AT_LEAST_MC(">=");
    private String aggregationType;

    /**
     * Default constructor of an Aggregation type based on a String representation.
     *
     * @param aggregationType String representation of Aggregation Type
     */
    AggregationType(String aggregationType) {
        this.aggregationType = aggregationType;
    }

    /**
     * Get's the string representation of a given {@code AggregationType}.
     *
     * @param minMCs Minimum number of Module Credits required for fulfilment, applicable only for {@code AT_LEAST_MC}
     * @return String representation of a given {@code AggregationType}
     */
    public String getAggregationType(int minMCs) {
        if (aggregationType.equals(">=")) {
            return aggregationType + " " + minMCs + " MCs";
        }
        return aggregationType;
    }
}
