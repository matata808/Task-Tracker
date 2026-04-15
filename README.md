# Task Tracker CLI

A simple command-line application to track and manage your tasks. Tasks are saved locally in a `output.json` file so they persist between sessions.

## Requirements

- Java 11 or higher

## How to Run

```bash
java -cp Task-Tracker.jar src.Main
```

## Commands

| Command | Description |
|---|---|
| `add <description>` | Add a new task |
| `update <id> <description>` | Update a task's description |
| `delete <id>` | Delete a task by ID |
| `mark-in-progress <id>` | Mark a task as in-progress |
| `mark-done <id>` | Mark a task as done |
| `list` | List all tasks |
| `list todo` | List all tasks with status: todo |
| `list in-progress` | List all in-progress tasks |
| `list done` | List all completed tasks |
| `help` | Show the list of commands |
| `exit` | Exit the application |

## Example Usage

```
add Buy groceries
# Task added successfully (ID: 0)

add Clean the house
# Task added successfully (ID: 1)

list
# ID: 0 | Buy groceries | Created: 2026-04-15 | Status: todo
# ID: 1 | Clean the house | Created: 2026-04-15 | Status: todo

mark-in-progress 0
list in-progress
# ID: 0 | Buy groceries | Created: 2026-04-15 | Status: in-progress

update 0 Buy groceries and cook dinner
list
# ID: 0 | Buy groceries and cook dinner | Updated: 2026-04-15 | Status: in-progress

mark-done 0
delete 1
exit
# Exiting....
```

## Project Structure

```
src/
├── Main.java       # Entry point, handles user input and command routing
├── TaskList.java   # Manages the task list and JSON persistence
└── Tasks.java      # Task model with all fields and toString formatting
output.json         # Auto-generated file where tasks are stored
```

## Notes

- Task IDs are assigned based on the list size at time of creation and do not re-order after deletions.
- The `output.json` file is created automatically in the directory where you run the program.
- If a task has been updated, the displayed date switches from `Created:` to `Updated:`.
