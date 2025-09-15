package ca.bcit.comp2522.fantasy;

/**
 * Represents a Date with year, month, and day.
 *
 * @author Indy
 * @version 1.0
 */
public class Date {
    // Instance variables
    private final int year;
    private final int month;
    private final int day;

    // Constants
    public static final int MAX_YEAR = 2025;
    public static final int CURRENT_MONTH = 9;

    /**
     * Constructs a Date object with validation.
     *
     * @param year
     * @param month
     * @param day
     * @throws IllegalArgumentException if the date is invalid
     */
    public Date(final int year, final int month, final int day) {
        //validation
        if (year > MAX_YEAR)
        {
            throw new IllegalArgumentException("Year can not be in the future");
        }
        if (year == MAX_YEAR && month > CURRENT_MONTH)
        {
            throw new IllegalArgumentException("Month can not be in the future");
        }

        // Save values after validation
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Returns the year of this date.
     *
     * @return the year as an int
     */
    public int getYear() {
        return year;
    }

    /**
     * Returns the month of this date.
     *
     * @return the month as an int
     */
    public int getMonth() {
        return month;
    }

    /**
     * Returns the day of the month for this date.
     *
     * @return the day as an int
     */
    public int getDay() {
        return day;
    }

    /**
     * Returns the date in YYYY-MM-DD format.
     *
     * @return the date as a String
     */
    public String getYYYYMMDD() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

}