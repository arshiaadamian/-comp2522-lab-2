package ca.bcit.comp2522.fantasy;

/**
 * Represents a Date with year, month, and day.
 * Provides validation to ensure dates are not in the future
 * relative to the current year and month.
 *
 *
 * @author Sukhraj, Arshia, Rodrick, Abdullah
 * @version 1.0
 */
public class Date {
    /** The year of the date. */
    private final int year;

    /** The month of the date. */
    private final int month;

    /** The day of the month. */
    private final int day;

    /** Maximum allowed year. */
    public static final int MAX_YEAR = 2025;

    /** The current month used for validation. */
    public static final int CURRENT_MONTH = 9;

    /**
     * Constructs a Date object with the specified year, month, and day.
     * Validates that the year and month are not in the future.
     *
     * @param year the year of the date
     * @param month the month of the date (1-12)
     * @param day the day of the month (1-31)
     * @throws IllegalArgumentException if the year or month is in the future
     */
    public Date(final int year, final int month, final int day) {
        if (year > MAX_YEAR) {
            throw new IllegalArgumentException("Year can not be in the future");
        }
        if (year == MAX_YEAR && month > CURRENT_MONTH) {
            throw new IllegalArgumentException("Month can not be in the future");
        }

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
     * Returns the day of this date.
     *
     * @return the day as an int
     */
    public int getDay() {
        return day;
    }

    /**
     * Returns the date in the format YYYY-MM-DD.
     *
     * @return the formatted date as a String
     */
    public String getYYYYMMDD() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }
}
