package src;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a single task in the Task Tracker application.
 * Each task has an ID, description, status, and timestamps for creation and last update.
 */
public class Tasks {

    private String state;
    private int id;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    /**
     * Returns the unique ID of the task.
     *
     * @return the task ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique ID of the task.
     *
     * @param id the ID to assign
     * @return the assigned ID
     */
    public int setId(int id) {
        return this.id = id;
    }

    /**
     * Returns the description of the task.
     *
     * @return the task description
     */
    public String getDescription() {
        return this.description = description;
    }

    /**
     * Sets the description of the task.
     *
     * @param description the new description
     * @return the assigned description
     */
    public String setDescription(String description) {
        return this.description = description;
    }

    /**
     * Returns the date and time the task was created.
     *
     * @return the creation timestamp
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Returns the date and time the task was last updated, or null if never updated.
     *
     * @return the last updated timestamp, or null
     */
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets the creation timestamp of the task.
     *
     * @param now the creation date and time
     * @return the assigned timestamp
     */
    public LocalDateTime setCreatedAt(LocalDateTime now) {
        return this.createdAt = now;
    }

    /**
     * Sets the last updated timestamp of the task.
     *
     * @param updatedAt the date and time of the last update
     */
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * Returns the current status of the task (e.g. "todo", "in-progress", "done").
     *
     * @return the task status
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the status of the task.
     *
     * @param state the new status ("todo", "in-progress", or "done")
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Returns a formatted string representation of the task.
     * Shows "Updated:" date if the task has been updated, otherwise shows "Created:" date.
     *
     * @return formatted task string
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateLabel = (updatedAt != null)
                ? "Updated: " + updatedAt.format(formatter)
                : "Created: " + createdAt.format(formatter);
        return "ID: " + id + " | " + description + " | " + dateLabel + " | Status: " + state;
    }
}