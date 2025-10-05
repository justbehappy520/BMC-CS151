Glory Zhang
Design of the remove method:
    For the remove method, I created two helper methods, one that does the
    removing called removeHelper, and one that finds the minimum value of a 
    subtree, called findMin. For a binary search tree, there are three 
    possibilities when it comes to removing: 0 children, 1 child, 2 children.
    removeHelper takes into account all three situations, and findMin assists
    when there are 2 children.
    First: findMin.
    findMin takes a Node as a parameter and returns a Node. So long as there
    is a node.left, findMin will keep looping, eventually ending up with the
    smallest Node in the tree.
    Second: removeHelper.
    removeHelper takes a Node and a generic element as parameters and returns
    a Node. 
        First: base case.
        If the given Node is null, the Node is returned and the nothing else
        happens.
        Second: compare.
        compare is an int variable that takes the comparison value of the 
        given element and the element of the given Node.
        Third: compare > 0.
        If compare is greater than 0, removeHelper is called recursively on 
        the right Node as the element is to the right of the Node.
        Fourth: compare < 0.
        If compare is less than 0, removeHelper is called recursively on the
        left Node as the element is to the left of Node.
        Fifth: compare == 0.
        If compare is equal to 0, then the element has been located. The 
        three possibilities are then considered:
            First: 0 children.
            The Node is returned.
            Second: 1 child.
            If there is only the left child, the left Node is returned. If 
            there is only the right child, the right Node is returned.
            Third: 2 children.
            A Node called minNode is set to the minimum Node in the right
            subtree of the Node. Node takes the element of minNode, and 
            removeHelper is called recursively on the right Node so that
            it will fill in the spot the Node used to be in.
    Third: remove.
    remove takes a generic element as a parameter and returns a boolean 
    depending on whether or not the given element is found and removed from
    the tree. 
        First: true.
        The tree is checked to see if the given element exists in the tree.
        If so, removeHelper is called upon the root of the tree and the root
        is set to any successor Node. The size decreases by one, the method
        returns true.
        Second: false.
        Otherwise, the method returns false.
Extra Credit Implementation:
    I had debated whether to write separate methods to implement the exra
    credit but ultimately chose not to because I wasn't sure how.
    First: files.
    I created a separate ExpandableArray called files to store and 
    rearrange the filenames from the command-line.
    Second: if-statement.
    I set up an if-else statement for autograder purposes.
        First: autograder.
        Implementing the extra credit involved extracting the date from the
        filename, which was not something I assumed the single, small test
        file had in the autograder. So I set up a little default for cases
        where there was a single command-line argument. The filename would
        be directly added to files.
        Second: extra credit.
        I extracted the date from the filename using substrings and stored 
        them in sorted order in files. Then I iterated back through files, 
        removed the date, and inserted in its place the corresponding
        filename.
Time Spent on Assignment: 11 hours give or take
What did you learn?
    I learned that sometimes methods are more inexplicably linked than I
    initially realized. I also learned how to (very slowly) trace recursive
    methods.
