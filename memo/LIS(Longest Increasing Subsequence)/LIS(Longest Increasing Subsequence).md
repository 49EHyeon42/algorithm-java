# LIS(Longest Increasing Subsequence)

## 1. O(N^2)

```java
// LIS
int maxLength = 1;

for (int i = 0; i < N; i++) {
    dp[i] = 1;

    for (int j = 0; j < i; j++) {
        if (array[j] < array[i]) {
            dp[i] = Math.max(dp[i], dp[j] + 1);
        }
    }

    maxLength = Math.max(maxLength, dp[i]);
}
```

## 2. O(NlogN)

```java
// Binary Search
private int binarySearch(int[] array, int target, int left, int right) {
    while (left < right) {
        int mid = (left + right) / 2;

        if (array[mid] < target) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }

    return right;
}

// LIS
int maxLength = 0;

dp[0] = array[0];

for (int i = 1; i < N; i++) {
    if (dp[maxLength] < array[i]) {
        dp[maxLength + 1] = array[i];

        maxLength++;
    } else {
        dp[binarySearch(dp, array[i], 0, maxLength)] = array[i];
    }
}

// Add 1 because it starts from 0
maxLength++;
```
