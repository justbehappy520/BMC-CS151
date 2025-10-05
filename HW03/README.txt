TwoStacksQueue uses two stacks to simulate a queue data structure.
The enqueue directly pushes the new value onto the first stack, which
has a runtime complexity of O(1). The dequeue first pushes everything
in the first stack onto the second stack, which reverse the order of 
the elements so that the first element of the first stack is now the 
last element of the second stack. As a queue is FIFO while a stack is
FILO, this is the perfect set up for a simulated queue. The last
element of the second stack, which was previously the first element of
the first stack, is then popped, completing the FIFO required of a queue.
This will have a runtime complexity of O(n) because to push all elements
in the first stack to the second stack requires touching every element in
the queue.