from collections import deque
import math

class Queue:
    def __init__(self):
        self.items = deque()
    
    def put(self, item):
        self.items.append(item)
    
    def get(self):
        if not self.items:
            raise IndexError("Queue is empty")
        return self.items.popleft()
    
    def size(self):
        return len(self.items)
    
    def is_empty(self):
        return not self.items

class StackWithTwoQueues:
    def __init__(self):
        self.q1 = Queue()  # Main queue (acts like the stack's top)
        self.q2 = Queue()  # Secondary queue (stores groups)
        self.total_elements = 0
        self.group_size = 0
        self.q2_front_distance = 0  # Distance of the current group from q2's front
        self.last_move = 0

    def push(self):
        self.total_elements += 1
        self._reorder_q2()
        
        self.q1.put(self.total_elements)
        
        if self._is_perfect_square(self.total_elements):
            self._move_group_to_q2()
        
        return self.total_elements

    def pop(self):
        if self.is_empty():
            raise IndexError("Stack is empty")
        
        self._reorder_q2()

        pop = self._pop_from_q1()
        
        if self._is_perfect_square(self.total_elements):
            self._move_group_from_q2_to_q1()
        
        self.total_elements -= 1
        return pop

    def _move_group_to_q2(self):
        if self.last_move == self.total_elements or self.total_elements == 4:
            return
        print('Moving to q2')

        self._set_group_size()
        for _ in range(self.group_size):
            self.q2.put(self.q1.get())
        self.q2_front_distance = self.q2.size() - self.group_size
        self.last_move = self.total_elements

    def _move_group_from_q2_to_q1(self):
        if self.last_move == self.total_elements:
            return
        for _ in range(self.group_size):
            self.q1.put(self.q2.get())
        self.group_size -= 2
        self.last_move = self.total_elements

    def _pop_from_q1(self):
        for _ in range(self.q1.size() - 1):
            self.q1.put(self.q1.get())
        return self.q1.get()

    def _reorder_q2(self):
        print(f'items to move = {self.q2_front_distance}')
        items_moved = 0
        while items_moved < self.group_size and self.q2_front_distance > 0:
            self.q2.put(self.q2.get())
            self.q2_front_distance -= 1
            items_moved += 1

    def _set_group_size(self):
        n = self.total_elements
        self.group_size = int((math.sqrt(n) - 1) ** 2 - (math.sqrt(n) - 2) ** 2)    
        print(f'group size = {self.group_size}')

    @staticmethod
    def _is_perfect_square(n):
        return math.isqrt(n) ** 2 == n and n > 3

    def is_empty(self):
        return self.total_elements == 0

    def size(self):
        return self.total_elements

    def print_state(self):
        print(f"Q1: {self._format_queue(self.q1)}")
        print(f"Q2: {self._format_queue(self.q2)}")
        print(f"Total elements: {self.total_elements}")

    @staticmethod
    def _format_queue(queue):
        return f"[{' '.join(map(str, queue.items))}]"

def main():
    stack = StackWithTwoQueues()
    print("Stack with Two Queues")
    print("Commands: 'e' to push the next integer, 'd' to pop, 'q' to quit")
    
    while True:
        command = input("Enter command: ").strip()
        
        if command == 'e':
            value = stack.push()
            print(f"Pushed: {value}")
        elif command == 'd':
            try:
                value = stack.pop()
                print(f"Popped: {value}")
            except IndexError as e:
                print(e)
        elif command == 'q':
            print("Quitting...")
            break
        else:
            print("Invalid command. Use 'e' to push, 'd' to pop, or 'q' to quit.")
        
        stack.print_state()
        print()

if __name__ == "__main__":
    main()
