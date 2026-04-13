# srtf-scheduler-simulation

## Course
CUS 1163 – Operating Systems

---

## Overview
This project simulates a CPU scheduling algorithm called Preemptive Shortest Job Next (SJN), also known as Shortest Remaining Time First (SRTF). In this scheduling method, the CPU always selects the process with the smallest remaining execution time. If a new process arrives with a shorter remaining time than the currently running process, the CPU immediately switches to the new process (preemption).

The goal of this simulation is to demonstrate how preemptive scheduling behaves when multiple processes with different arrival times, burst times, and deadlines compete for CPU time.

---

## Scheduling Policy Behavior
- Processes are scheduled based on the shortest remaining burst time  
- The scheduler checks available processes at every time unit  
- A running process can be preempted if a shorter job arrives  
- Each process runs until completion  
- The system continues until all processes are finished  

---

## Process Input Format
The program automatically generates 100 processes using the following rules:

- Arrival Time: A new process arrives every 5 time units  
- Burst Time: Repeats in a cycle → 5, 10, 20, 30, 40, 50  
- Deadline: Based on a repeating cycle relative to arrival time  
- Each process is defined as: (processId, arrivalTime, burstTime, deadline)
