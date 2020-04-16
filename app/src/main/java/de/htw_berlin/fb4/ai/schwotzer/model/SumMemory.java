package de.htw_berlin.fb4.ai.schwotzer.model;

public interface SumMemory {
    /**
     * keep sum
     * @param sum
     */
    void save(int sum);

    /**
     * restore sum from persistent memory
     * @return
     */
    int restore();
}
