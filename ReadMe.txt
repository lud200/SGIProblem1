The problem is used for calculating the year with most people alive. 

The problem works on the bucket sort algorithm. 

Problem description:

1. An array with the years is constructed (from 1900 to 2000).

2. The program reads the birth and death years of people.

3. If birth year <= 1900 or death year >=2000 or if birthyear > deathyear, the object will not be added

4. The program only works for years between 1900 and 2000.

5. For each person, buckets are created and the count is incremented by 1 for every  birth year and decremented by 1 for every death year

6. The index value is calculated for the maximum year with people alive count and returned. 

Time Complexity:

The program runs for all the elements(100 years from 1900-2000) in the loop once for finding the bucket with max count. 

Hence the program runs in linear time that is O(n) time complexity. 

PS: Please let me know if I had missed any test cases.