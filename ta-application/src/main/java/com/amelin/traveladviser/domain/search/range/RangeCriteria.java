package com.amelin.traveladviser.domain.search.range;

import com.amelin.traveladviser.domain.exception.flow.InvalidParameterException;

/**
 * Pagination parameters for data retrieval operations
 * @author Mike Amelin
 */
public class RangeCriteria {
    /**
     * Page index (0-based)
     */
    private final int page;
    /**
     * Number of elements per page
     */
    private final int rowCount;

    public RangeCriteria(int page, int rowCount) {
        if (page < 0) {
            throw new InvalidParameterException("Incorrect page index" + page);
        }
        if (rowCount < 0) {
            throw new InvalidParameterException("Incorrect row count" + rowCount);
        }
        this.page = page;
        this.rowCount = rowCount;
    }

    public int getPage() {
        return page;
    }

    public int getRowCount() {
        return rowCount;
    }
}
