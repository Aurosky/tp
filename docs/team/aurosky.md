# XIAO Yanjing, Kiri - Project Portfolio Page

## Overview
ClausControl is a desktop application for Santa Claus to manage children, gifts, elves and tasks, optimized for use via a Command Line Interface (CLI).
It is written in Java, and has about 8200 LoC.

Given below are my contributions to the project.

* **Code contributed**: [Link to code dashboard](https://nus-cs2113-ay2526-s2.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2026-02-20T00%3A00%3A00&filteredFileName=&tabOpen=true&tabType=authorship&tabAuthor=prerana-r11&tabRepo=AY2526S2-CS2113-T09-2%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code~other&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false)

* **Add Elf Feature** (`elf` command): Allows Santa to add a new elf to the system.
    * Contribution: Implemented `ElfCommand` to handle elf creation. Created `Elf`, `ReadOnlyElf` and `ElfCommand` classes to facilitate the command.

* **Edit Elf Feature** (`editelf` command): Allows Santa to update the name of an existing elf in the system.
    * Contribution: Implemented `EditElfCommand` which utilizes the `setName` method to modify the Name attribute of the target elf. Integrates error handling for `IllegalValueException` to ensure that the new name adheres to the system's naming constraints.

* **Remove Elf Feature** (`rmelf` command): Enables the removal of a specific elf from the system based on their current list index.
    * Contribution: Implemented `RmElfCommand` class to locate and delete the target elf from the global `elfList`. Includes robust index validation to prevent errors when a user provides an out-of-bounds or invalid index.

* **Assign Task to Elf** (`task` command): Allows Santa to assign a specific work description to an individual elf.
    * Contribution: Implemented `TaskCommand` which encapsulates the input into an `ElfTask` object and adds it to the target elf's task list.

* **Delete Elf Task** (`detask` command): Provides the functionality to delete a specific task from a chosen elf's assignment list.
    * Contribution: Implemented `DeTaskCommand` which requires both an elf index and a specific task index for precise removal.

* **Find Child** (`find` command): Allows Santa to search for specific children in the list using name, age, or location.
    * Contribution: Implemented `FindCommand` with a `SearchType` enum to handle different search parameters. Provides detailed feedback including the child's index, name, age, and location for all matches found.

* **View Elf List** (`elflist` command): Allows Santa to view a list of all elves currently in the system with their assigned tasks.
    * Contribution: Uses a `StringBuilder` to efficiently format the output, ensuring a clear hierarchical view of elves and their tasks.

* **View Child List** (`childlist` command): Allows Santa to view a complete, numbered list of all children currently stored in the system.
    * Contribution: Implemented `ChildListCommand` class to iterate through the `childList` and generate a formatted string summary.

* **System Reset** (`reset` command): Allows Santa to completely wipe all data, clearing all children, elves, todos and tasks.
    * Contribution: Implemented `ResetCommand` to perform a deep clean of both the `childList` and `elfList` simultaneously.

* **Documentation**:
    * User Guide:
        * Added sections for: `elf`, `rmelf`, `editelf`, `find`, `childlist`, `elflist`, `reset`.
        * Created Command Summary table framework.
        * Helped fix grammar bugs.
    * Developer Guide:
        * Added implementation details for: `elf`, `rmelf`, `editelf`, `task`, `detask`, `find`, `childlist`, `elflist`, `reset`.
        * Added sequence diagrams for all above features.

* **Contributions to Team-Based Tasks**:
    * Added features in Google Docs for planning tasks.
    * Helped in documentation of common sections in the UG and DG.
    * Helped in testing of implemented commands and bug fixes.
    * Reviewed PRs from teammates.
    * Implemented a `PendingCommand` safety layer that intercepts all deletion-related actions, requiring explicit confirmation from Santa to prevent accidental data loss.

* **Review/Mentoring Contributions**:
    * Helped teammates resolve Git merge conflicts.
    * Resolved merge conflicts of team members.