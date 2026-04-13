# CPU Scheduling Simulation (Preemptive SJN)

## Course
CUS 1163 – Operating Systems

---

## Overview
This project simulates a CPU scheduling algorithm using Preemptive Shortest Job Next (SJN). The scheduler always selects the process with the smallest remainingTime. If a process with a shorter remainingTime is available, it is selected for execution. Each process executes one unit of time at a time until it is completed.

The goal of this simulation is to demonstrate how preemptive scheduling behaves when multiple processes with different arrivalTime, burstTime, and deadlines compete for CPU execution time.

---

## Scheduling Policy Behavior
- The scheduler selects the process with the smallest remainingTime
- Each process runs one time unit per iteration
- If no process has arrived yet, time is increased
- A process is marked completed when remainingTime reaches 0
- The simulation ends when all processes are completed

---

## Process Class Structure

Each process is defined using the Process class:

- id
- arrivalTime
- burstTime
- remainingTime
- deadline
- completionTime
- completed

---

## Process Generation

The generateProcesses method creates 100 processes using:

### arrivalTime
A new process arrives every 5 time units:
0, 5, 10, 15, 20, ...

### burstTime
Burst times follow this repeating array:
- int[] burstCycle = {5, 10, 20, 30, 40, 50};

### deadline
Deadlines are calculated using:
- deadline = arrival + deadlineCycle[i % deadlineCycle.length];
- Where:
  - int[] deadlineCycle = {10, 20, 40, 60, 80, 100};

---

## Process Format

Each process is created as:
- (id, arrivalTime, burst, deadline)

---

## Output Format

The program prints:

ID | Arrival | Burst | Deadline | Completion | Met Deadline
------------------------------------------------------------
For each process:
- id
- arrivalTime
- burstTime
- deadline
- completionTime
- whether completionTime <= deadline


### Example Output
| ID | Arrival | Burst | Deadline | Completion | Met Deadline |
|----|---------|-------|----------|-------------|--------------|
| 0  | 0       | 5     | 10       | 5           | YES          |
| 1  | 0       | 10    | 20       | 35          | NO           |
| 2  | 0       | 20    | 40       | 275         | NO           |
| ...| ...     | ...   | ...      | ...         | ...          |

The output shows that Shortest Remaining Time First efficiently completes short processes quickly, but significantly delays longer processes, leading to many missed deadlines due to frequent preemption.

Essentially:
- fast for smaller jobs
- significant delay for larger jobes

---

## Key Features
- Simulates 100 processes
- Uses Preemptive Shortest Job Next scheduling
- Uses arrivalTime increments of 5
- Uses burstCycle array for burstTime values
- Uses deadlineCycle array for deadline calculation
- Tracks completionTime and deadline satisfaction
