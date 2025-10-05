Time to run DriverHW04:
    real 0m2.035s
    user 0m2.481s
    sys  0m0.202s

There is definitely a speedup in time. My Driver01 had already
been super slow, and I don't really want to see how long it
would take to run through 100000 zipcodes. Let's just say that
in the time it took me to write this README (3m29.803s real 
time), the code only ran up to the "No such zipcode" after
Lancaster, CA 34.69 -117.9 72046.

I do have a question.
The TA, Ruth, suggested I change my updatePlace method to also
use binary search, but after changing it, it would stall for a
very long time. Only after removing the else from what was 
originally an else if on line 73 of LookupZip.java, then it ran
as fast as I reported. Why did the act of changing else if to if
all of a sudden allow my program to work?

Thank you!