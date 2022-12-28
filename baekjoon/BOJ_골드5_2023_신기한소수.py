import math

N = int(input())
nums = [2, 3, 5, 7]


def search(curr: int, cnt: int) -> None:
    if cnt == N:
        print(curr)
        return

    for n in range(1, 10):
        next_num = curr * 10 + n
        if is_prime(next_num):
            search(next_num, cnt + 1)


def is_prime(x: int) -> bool:
    lim = int(math.sqrt(x)) + 1
    for i in range(2, lim):
        if x % i == 0:
            return False
    return True


for num in nums:
    search(num, 1)
